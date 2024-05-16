--- TINYINT
    -- -128 ~ 127범위, 1바이트
    -- java의 byte와 매핑
alter table author add column age tinyint;
insert into author(id,email,age) values(6,"test@naver.com",256); # x
insert into author(id,email,age) values(6,"test@naver.com",25);  # ㅇ
alter table author modify column age tinyint unsigned; #255까지 표현 범위 확대

-- BIGINT
        -- id값은 일반적으로 BIGINT사용
        -- java의 long타입과 매핑 // 8byte

-- DECIMAL(M ,D) // 고정 소수점 타입, D-소수부, M-총자릿수
alter table post add column price decimal(10,3);
insert into post(id,title, price) values(6,"hi" ,0.123456789);   # 0.123
update post set price=1234.1 where id=1;   # 1234.100
update post set price=1234.12 where id=2;   # 1234.120



