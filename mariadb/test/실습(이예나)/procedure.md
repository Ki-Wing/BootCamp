# Procedure

- 회원가입
- 로그인
- 물품 등록
- 주문하기
- 리뷰등록
- 등급업데이트
- 주문내역조회하기

<br>

### 회원가입

```sql
DELIMITER //

CREATE PROCEDURE `회원가입`( IN i_name VARCHAR(50), IN i_passwd VARCHAR(255),
    IN i_email VARCHAR(255),  IN i_user_type ENUM('seller', 'customer'))
BEGIN
    IF EXISTS (SELECT 1 FROM user WHERE email = i_email) THEN
        SELECT '회원가입 실패(중복 email)' message;
    ELSE
        INSERT INTO `user` (name, passwd, email, user_type)
        VALUES (i_name, i_passwd, i_email, i_user_type);

        SELECT '회원가입 성공^^' message;
    END IF;
END;
//

DELIMITER ;
```

- 실행 쿼리
```sql
CALL 회원가입('이예녀', '1234', 'ynlee@test.com', 'customer');
CALL 회원가입('이예남', '1234', 'ynlee1@test.com', 'seller');
```

<br>

### 로그인

```sql
DELIMITER //
CREATE PROCEDURE `로그인`(IN i_email VARCHAR(255), IN i_passwd VARCHAR(255))
 BEGIN
     IF EXISTS (SELECT 1 FROM user WHERE email = i_email AND passwd = i_passwd AND del_YN = 'N') THEN
         SELECT '로그인 성공!'  message;
     ELSE
         SELECT '로그인 실패!'  message;
     END IF;
 END
 //

DELIMITER ;
```

- 실행 쿼리
```sql
CALL 로그인('ynlee@test.com', '1234');
```

<br>

### 물품 등록

```sql
DELIMITER //

CREATE PROCEDURE `물품등록`( IN i_email VARCHAR(255),   IN i_product_name VARCHAR(100),   IN i_quantity INT,  IN i_price DECIMAL(10,2),  IN i_description TEXT)
BEGIN
    IF NOT EXISTS (SELECT 1 FROM User WHERE email = i_email AND user_type = 'seller' AND del_YN = 'N') THEN
        SELECT '등록된 판매자가 아니거나 권한이 없습니다.' AS message;
    ELSE

        INSERT INTO Product (seller_id, name, quantity, price, description)
        SELECT id, i_product_name, i_quantity, i_price, i_description
        FROM User
        WHERE email = i_email AND user_type = 'seller' AND del_YN = 'N';

        SELECT '판매 물품이 등록되었습니다.' AS message;
    END IF;
END;
//

DELIMITER ;
```

- 실행 쿼리
```sql
CALL 물품등록('ynlee1@test.com', '확!깨는 졸음 번쩍 껌', 15, 5200, '졸음이 확! 깹니다..');    -- 판매 물품이 등록되었습니다.
CALL 물품등록('ynlee@test.com', '확!깨는 졸음 번쩍 껌', 15, 5200, '졸음이 확! 깹니다..');   -- 등록된 판매자가 아니거나 권한이 없습니다.
```

<br>

### 주문하기

```sql
DELIMITER //

CREATE PROCEDURE `주문하기`(IN i_email VARCHAR(255),   IN i_product_id INT,
    IN i_quantity INT)
BEGIN
    DECLARE current_stock INT;
    DECLARE product_price DECIMAL(10,2);
    DECLARE total_amount DECIMAL(10,2);
    DECLARE user_id INT;

    SELECT id INTO user_id FROM `user` WHERE email = i_email AND del_YN = 'N';

    IF user_id IS NULL THEN
        SELECT '등록된 사용자가 아닙니다.'  message;
    ELSE

        SELECT quantity, price INTO current_stock, product_price FROM product WHERE id = i_product_id AND del_YN = 'N';

        IF current_stock IS NULL THEN
            SELECT '상품이 존재하지 않습니다'  message;
        ELSEIF current_stock < i_quantity THEN
            SELECT '재고가 없습니다.'  message;
        ELSE

            SET total_amount = product_price * i_quantity;

            INSERT INTO orders (user_id, total_amount, status, product_count)
            VALUES (user_id, total_amount, 'pending', i_quantity);

            SET @order_id = LAST_INSERT_ID();

            INSERT INTO order_product (order_id, product_id, quantity, price)
            VALUES (@order_id, i_product_id, i_quantity, product_price);

            UPDATE product
            SET quantity = quantity - i_quantity
            WHERE id = i_product_id;

            SELECT '주문이 완료되었습니다.' message;
        END IF;
    END IF;
END;
//

DELIMITER ;

```

- 실행 쿼리
```sql
CALL 주문하기('ynlee@test.com', 3, 3);
select * from product; -- 재고가 15 -> 10으로 변경
select * from order_product;
```

<br>

### 리뷰 등록

```sql
DELIMITER //

CREATE PROCEDURE `리뷰등록`( IN i_email VARCHAR(255), IN i_product_id INT,
    IN i_rating INT, IN i_review_text TEXT
)
BEGIN
    DECLARE v_user_id INT;
    DECLARE order_exists INT;

    SELECT id INTO v_user_id FROM `user` WHERE email = i_email AND del_YN = 'N';

    IF v_user_id IS NULL THEN
        SELECT '등록된 사용자가 아닙니다.'  message;
    ELSE
        SELECT COUNT(*) INTO order_exists
        FROM orders o JOIN order_product op ON o.id = op.order_id
        WHERE o.user_id = v_user_id AND op.product_id = i_product_id;

        IF order_exists > 0 THEN
            INSERT INTO reviews (product_id, user_id, rating, review_text)
            VALUES (i_product_id, v_user_id, i_rating, i_review_text);

            SELECT '리뷰가 등록되었습니다.'  message;
        ELSE
            SELECT '해당 제품을 주문한 기록이 없어 리뷰를 작성할 수 없습니다.'  message;
        END IF;
    END IF;
END;
//

DELIMITER ;

```
- 실행 쿼리
```sql
CALL 리뷰등록('ynlee@test.com', 1, 5, '최고입니다');
CALL 리뷰등록('ynlee1@test.com', 1, 5, '최고입니다'); --해당 제품을 주문한 기록이 없어 리뷰를 작성할 수 없습니다.  
```

<br>

### 등급 업데이트
```sql
DELIMITER //

CREATE PROCEDURE 등급업데이트(IN i_email VARCHAR(255))
BEGIN
    DECLARE v_user_id INT;
    DECLARE v_order_count INT;

    SELECT id INTO v_user_id FROM `user` WHERE email = i_email AND del_YN = 'N';

    IF v_user_id IS NULL THEN
        SELECT '등록된 사용자가 아닙니다.' message;
    ELSE
        SELECT COUNT(*) INTO v_order_count FROM orders WHERE user_id = v_user_id AND status != 'cancelled';

        IF v_order_count >= 20 THEN
            UPDATE `user` SET user_grade = '플래티넘' WHERE id = v_user_id;
            SELECT '사용자 등급이 플래티넘으로 업데이트되었습니다.'  message;
        ELSEIF v_order_count >= 10 THEN
            UPDATE `user` SET user_grade = '골드' WHERE id = v_user_id;
            SELECT '사용자 등급이 골드로 업데이트되었습니다.'  message;
        ELSEIF v_order_count >= 5 THEN
            UPDATE `user` SET user_grade = '실버' WHERE id = v_user_id;
            SELECT '사용자 등급이 실버로 업데이트되었습니다.'  message;
        ELSE
            UPDATE `user` SET user_grade = '브론즈' WHERE id = v_user_id;
            SELECT '사용자 등급이 브론즈로 업데이트되었습니다.'  message;
        END IF;
    END IF;
END;
//
DELIMITER ;

```

- 실행 쿼리
```sql
call 등급업데이트('ynlee1@test.com');
```

<br>

### 주문내역 조회
```sql
DELIMITER //
CREATE PROCEDURE 주문내역조회(IN i_email VARCHAR(255))
BEGIN
    SELECT  p.name  제품명, op.quantity  물품수량,  op.price  개별금액,
        o.total_amount  총금액, o.created_at  주문날짜, u.user_grade  내등급
    FROM user u JOIN orders o ON u.id = o.user_id
        JOIN order_product op ON o.id = op.order_id
        JOIN product p ON op.product_id = p.id
    WHERE 
        u.email = i_email
    ORDER BY 
        o.created_at DESC;
END;
 //

DELIMITER ;
```

- 실행 쿼리
```sql
call 주문내역조회('ynlee1@test.com');
```
