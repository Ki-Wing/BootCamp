-- insert into : 데이터 삽입
insert into table명(컬럼1, 컬럼2...) values(data1, data2...);

-- select : 데이터 조회 (*:모든 컬럼)
select * from table명;
select * from schema명.table명;

-- table 제약 조건 조회
SELECT * FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_NAME = 'post';

-- update [table명] set 컬럼먕=데이터, 컬럼먕1=데이터1 where id=1
    -- wherer문 없으면 모든 data update 적용됨
update author set name="abc" where id=1;

-- delete from table명 where 조건
    -- delete는 복구가 가능(속도 느림) truncate 다 날림
delete from author where id=5;

-- select문 다양한 조회
select * from  author where ~;
select * from post where id>=3;
select * from post where id=3 and name="ynlee*";
-- 특정 columns만 조회
select name from post;    
select distinct name form author;
-- 정렬 order by // default pk기준 오름차순
select distinct contents,id from post order by id desc;
select distinct contents,id from post order by title asc;
-- multi culumns order by 
select * from post order by title, author_id desc;
-- limit num: 출력값 제한
select name from author order by id desc limit 1;
-- alias
select max(author_id) as contents from post;;
select a.name from author as a order by id desc limit 1;
-- null 조회 조건
select * from post where author_id is not null;   # is null

-- type




