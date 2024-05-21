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

-- TEXT
        -- 가변 길이 // 최대 65535
        -- disk 에 저장해서 조회하기 때문에 메모리 저장(varchar)보다 느림
        -- index 사용 어려움

-- blob 
alter table author add column img blob;
alter table author modify column img longblob;
insert into author(id, email, img) values(8, 'test1@naver.com', load_file('C:\\귀요미.jpg'));
select hex(img) from author where id=8;

-- enum : 삽입 될 수 있는 데이터 종류 합정
alter table author add column role enum('user','admin') not null;
--실습1
    -- user1 insert -> error남 Data truncated for column 'role' at row 1
    insert into author(id, email,role) values(11,"user@google.com", "user1");
    -- user insert -> o
    insert into author(id, email,role) values(11,"user@google.com", "user");
alter table author modify column role enum('user','admin') not null default 'user';   -- default 안해도 앞값이 default // not null 필요x
    -- enum 값 변경하고 싶을때 추가 -> 업데이트 -> 기존 삭제

-- data/datetime(m) ->dateime(4)
    -- 날짜 타입의 insert는 문자열 형식으로 insert
alter table author add column birth date
alter table author add column created_time datetime default now();
alter table post add column created_time datetime default currnet_timestamp;
-- alter table author add column created_time datetime(4) default currnet_timestamp(4);

-- [비교 연산자]
select * from post where id >=2 and id<=4;   # &&
select * from post where id between 2 and 4;
select created_time from post where created_time between '2024-05-15' and '2024-05-16';

select * from post where id<2 || id>4;   # or
select * from post where not(id<2 || id>4);
select * from post where !(id<2 || id>4);

select * from post where price is null;
select * from post where price is not null;

select * from post where id in (2,4);
select * from post where id not in (2,4);

-- [검색엔진]
-- like 
select * from author where name like '%ln%';   #중간 단어값 조회
select * from author where name not like '%ln%';
-- regexp
select * from author where name regexp '[a-z]';
select * from author where name regexp '[가-힣]';

-- ifnull(a,b) 흐름 제어문 : 만약 a값이 널이면 b 반환, null 아니면 a 반환
select id, ifnull(author_id, '익명') a_id from post;

-- 타입 변환 : 숫자 -> 날짜, 문자 -> 날짜(Y,m,d) 시간(H,i,s)
select cast(20240517 as date) date;      # cast : int -> date
select cast('20240517' as date) date;  # convert : string -> date;
select cast(created_time as date) date from post;
select convert('20240517', date) date;
select date_format('2024-05-17 14:40:23', '%y-%m-%d');
select id, date_format(created_time, '%y-%m') as date from post;

-- 05, 08 이런게 아니라 한 자릿수(0 땔때)
-- int 대신 unsigned 또는 signed사용
select cast(date_format(created_time,"%m") as unsigned) date from post;    --unsigned : 음수 x

select * from post where date_format(created_time, '%y')='24';

-- 오늘의 시간
select now();
