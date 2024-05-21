-- 트랜잭션
    -- db의 일관성을 유지하면서 여러 작업을 단일 작업 단위로 묶어 처리하는 방법
    -- ACID 속성
        -- Atomicity : 모든 작업이 성공적으로 완료되거나 모두 취소
        -- Consistency : db 규칙(제약 조건, 트리거 등)은 항상 유지
        -- Isolation : 트랜잭션이 실행되는 동안 다른 트랜잭션이 영향 x
        -- Durability : 트랜잭션이 완료된 후에는 시스템 오류가 발생하더라도 결과는 영구적으로 유지
-- 시작 
BEGIN TRANSACTION;
-- 계좌 A에서 금액 차감
UPDATE accounts
SET balance = balance - 100
WHERE account_id = 'A';

-- 계좌 B에 금액 추가
UPDATE accounts
SET balance = balance + 100
WHERE account_id = 'B';

-- 모든 작업이 성공하면 COMMIT(확정 짓는 행위)
COMMIT;
-- 오류 발생 시 ROLLBACK(모두 취소)
ROLLBACK;

-- post에 post_count 컬럼 추가

-- post에 글 작성 후 author 테이블에 post_count값에 +1 -> transaction
start transaction;
update author set post_count = post_coint+1 where id = 1;
insert into post(title, author_id) values("hihi",2);
commit; || ROLLBACK;

-- sql 분기처리 w.stored procedure
DELIMITER //
CREATE PROCEDURE InsertPostAndUpdateAuthor()
BEGIN
    DECLARE exit handler for SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;
    -- 트랜잭션 시작
    START TRANSACTION;
    -- UPDATE 구문
    UPDATE author SET post_count = post_count + 1 where id = 1;
    -- INSERT 구문
    insert into post(title, author_id) values('hello world java', 5);
    -- 모든 작업이 성공했을 때 커밋
    COMMIT;
END //
DELIMITER ;
CALL InsertPostAndUpdateAuthor();

