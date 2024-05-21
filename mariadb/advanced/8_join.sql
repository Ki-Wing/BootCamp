-- inner join
-- 두 테이블 사이 지정된 조건에 맞는 레코드만 반환. on 조건을 통해 겨집합 찾기
select * from post join author on author.id=post.author_id;
select * from post p join author a on a.id=p.author_id;

-- 글쓴이가 있는 post 전체와 글쓴이의 이메일을 출력
select p.*, a.email from post p join author a on a.id=p.author_id;

-- 모든 글 목록을 출력하고, 만약에 글쓴이가 있다면 이메일 출력
select p.id,p.title, a.email from post p left outer join author a on a.id=p.author_id;

-- join된 상황에서의 where 조건
-- 1) 글쓴이가 있는 글 중에 글의 title과 저자의 wmail을 출력, 저자의 나이는 25세 이상
select p.title, a.email from author a join post p on a.id=p.author_id where a.age >=25;
-- 2) 모든 글 목록 중에 글의 title과 저자가 있따면 email을 출력, 2024-05-01 이후 만들어진
select p.title, a.email from post p join author a on a.id=p.author_id where p.title is not null and 
p.created_time>= "2024-05-01";
-- +)NULLABLE FALSE인지 확인해보3


-- Union : 중복 제외 // 밑으로
-- Union all : 중복 포함
    -- 컬럼 개수와 타입이 같아야 함
select 컬1, 컬2 from table1 union select 컬1,컬2 from table2;
--author table의 name, email post의 title, contents union;
select name, email from author union select title,contents from post;

-- 서브쿼리 // join이 성능 더 굿
    -- select 문 안에 또 다른 select문이 있는 쿼리
    -- select 절 안에 서브 쿼리
        -- author email과 헤딩 author가 쓴 글 개수 출력 // 성능이 떨어질 수 있음
select email, (select count(*) from post p where p.author_id = a.id) count from author a;
= select a.email, count(p.author_id) count from post p right join author a on p.author_id = a.id group by a.id;
   
    -- from 절 안에 서브 쿼리
select a.name from (select * from author) as a;

    -- where 절 안에 서브 쿼리
select a.* from author a join post p on a.id=p.author_id;
select * from author a where id in (select p.author_id from post p);

-- 없어진 기록 찾기
SELECT ANIMAL_ID, NAME FROM ANIMAL_OUTS AO WHERE ANIMAL_ID 
NOT IN(SELECT ANIMALID FROM ANIMAL_INS) ORDER BY ANIMAL_ID;


-- 집계 함수
SELECT COUNT(*), SUM(SALES) FROM ABC GROUP BY REGION;
SELECT COUNT(*) FROM AUTHOR;
SELECT SUM(PRICE) FROM POST;
SELECT ROUND(AVG(price)) from post;

-- group by 함수
select author_id from post group by author_id;
select author_id, count(*) from post group by author_id;
select author_id, count(*), ROUND(AVG(price)) , sum(price), max(price) from post group by author_id;

-- group by와 where
    -- 연도졓 PODT 글 출력, 연도가 NULL인 데이터는 제외
select year(created_time) year, count(contents) from post 
where year(created_time) is not null group by year;

-- (프로그래머스) 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
1)
SELECT CAR_TYPE, COUNT(*) CARS FROM CAR_RENTAL_COMPANY_CAR 
WHERE OPTIONS REGEXP '통풍시트|열선시트|가죽시트' 
GROUP BY CAR_TYPE ORDER BY CAR_TYPE;

2)
SELECT CAR_TYPE, COUNT(*) CARS FROM CAR_RENTAL_COMPANY_CAR 
WHERE OPTIONS LIKE '%통풍시트%' || OPTIONS LIKE '%열선시트%' || OPTIONS LIKE '%가죽시트%' 
GROUP BY CAR_TYPE ORDER BY CAR_TYPE;

-- (프로그래머스) 입양 시각 구하기(1)
1)
SELECT DATE_FORMAT(DATETIME, '%H') HOUR, COINT(*) FROM ANIMAL_OUTS 
WHERE DATE_FORMAT(DATETIME, '%H:%I') BETWEEN '09:00' AND '19:59' 
GROUP BY HOUR ORDER BY HOUR;
2)
SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS 
WHERE HOUR(DATETIME) >= 9 AND HOUR(DATETIME) < 20 
GROUP BY HOUR ORDER BY HOUR;

-- HAVING은 조건절로 GROUP BY랑 같이 씀
    -- 그룹화된 후의 데이터 대한 조건

-- 글 2개 이상 쓴 사람 통계 정보
select author_id, count(*) count from post 
group by author_id having count >=2 ;    
-- price이 2000원 이상인 글을 작성자별로 몇건인지 // 평균 price가 3000원 이상 데이터
select author_id, count(*) cnt  from post where price >= 2000 
group by author_id having avg(price) >= 3000;
-- JOIN 2건 이상의 글을 쓴 사람의 id와 email을 구함. 나이는 25세 이상인 사람만
--  가장 나이 많은 사람 1명의 통계를 출력
1)
select a.id, a.email from author a 
join post p on a.id=p.author_id where a.age>=25 
group by a.id having count(p.contents)>=2 
order by max(a.age) desc limit 1; --group by 다음 작동...
2)
select a.id, a.email from author a 
join post p on a.id=p.author_id where a.age>=25 
group by a.id having count(p.contents)>=2 
order by a.age desc limit 1; 
-- GROUP BY를 AGE값을 내부적으로는 가지고 있기 때문에 ㄱㄴ


-- 복잡한 select 쿼리의 실행 순서
    -- select -> join -> on -> where -> group -> having -> order -> limit

-- 다중열 group by
select author_id, title, count(title) from post group by author_id, title;
-- 재구매가 일어난 상품과 회원 리스트 구하기
