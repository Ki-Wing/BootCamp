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

-- +)NULLABLE FALSE인지 확인