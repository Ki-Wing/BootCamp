-- 흐름제어 : case문
select 컬1, 컬2, 컬3, 
CASE expression
    WHEN value1 THEN result1
    WHEN value2 THEN result2
    ...
    ELSE default_result
END
from table명;

-- 예제1
select id, title, case author_id when 1 then "fr" when 2 then "se" else "others" end  as author_id from post;

-- 예제2
    -- case
select id, title, 
case 
    when author_id is null then "fr" 
    else "익명" end as author_id 
from post;
    -- ifnull
select id, title, ifnull(author_id,"익명사용자") a_id from post;
    -- if
select id, title, if(author_id is not null,author_id,"익명사용자") a_id from post;

-- 예제3
SELECT
    employee_id,
    CASE
        WHEN department_id = 10 AND years_of_service >= 10 THEN salary * 0.2
        ELSE salary * 0.05
    END AS bonus
FROM employees;

-- ifnull
select id, ifnull(author_id, '익명') a_id from post;


SELECT board_id,writer_id,title, price ,
CASE status 
WHEN 'SALE' THEN '판매중'
WHEN 'RESERVED' THEN '예약중' 
WHEN 'DONE' THEN '거래완료' END status
FROM used_goods_board
WHERE created_date = '2022-10-05' 
ORDER BY board_id DESC
