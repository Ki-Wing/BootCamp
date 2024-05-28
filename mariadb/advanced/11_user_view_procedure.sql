-- 사용지 관리
-- 사용자 목록 조회
select * from mysql.user; 

-- 사용자 생성
create user 'test1'@'localhost' identified by '1234';
mariadb -u test1 -p  -- 로그인

-- 사용자 select 권한 부여
grant select on board.author to 'test1'@'localhost';

-- test1으로 로그인
select * from board.author;

-- 권한 조회
show grants for 'test1'@'localhost';

-- 사용자 권한 회수
revoke select from board.author from 'test1'@'localhost';

-- 환경설정을 변경 후 확정
flush privileges;

-- test1 확인
ERROR 1142 (42000): SELECT command denied to user 'test1'@'localhost' for table `board`.`author` 

-- test1 삭제
drop user 'test1'@'localhost'


--[view]
-- view 생성
create view author_for_marketing_team as select name, age, role from author;

-- view 조회
select * from author_for_marketing_team;

-- view에 권한 부여
grant select on board.author_for_marketing_team to ...;
    create user 'test'@'localhost' identified by '1234';
    grant select on board.author_for_marketing_team to 'test1'@'localhost';

-- view 변경(대체)
create or replace view author_for_marketing_team as
select name, email, age, role from author;

-- view 삭제
drop view author_for_marketing_team;

--[procedure]
-- 프로시저 생성
DELIMITER //
CREATE PROCEDURE TEST_PROCEDURE()
BEGIN
    SELECT 'HELLO WORLD';

END
// DELIMITER ;

CALL TEST_PROCEDURE();

-- 프로시저 삭제
drop procedure TEST_PROCEDURE;


-- 게시글 목록 조회 프로시저 생성;
DELIMITER //
CREATE PROCEDURE TEST_PROCEDURE1()
BEGIN
    SELECT * FROM post;

END
// DELIMITER ;

CALL TEST_PROCEDURE1();


-- 게시글 상세 조회(단건) -> 동적
DELIMITER //
CREATE PROCEDURE TEST_PROCEDURE2(in id int, in 제목 varchar(255))
BEGIN
    SELECT * FROM post WHERE author_id = id and title = 제목;

END
// DELIMITER ;

CALL TEST_PROCEDURE1(1,'hi');


-- 글쓰기
    -- title,contents,id
DELIMITER //
CREATE PROCEDURE TEST_PROCEDURE3(in id int, in 제목 varchar(255), in 내용 varchar(255))
BEGIN
	insert into post(title, contents, author_id) value(제목, 내용, id);
    SELECT * FROM post WHERE author_id = id and title = 제목;

END
// DELIMITER ;

call TEST_PROCEDURE3(1, 'test', 'test');

-- 글쓰기2 
DELIMITER //
CREATE PROCEDURE TEST_PROCEDURE4(in 이메일 varchar(255), in 제목 varchar(255), in 내용 varchar(255))
BEGIN
    DECLARE 아이디 INT;
    select id into 아이디 from author where email = 이메일;
	insert into post(title, contents, author_id) value(제목, 내용, 아이디);
    SELECT * FROM post WHERE author_id = id and title = 제목;

END
// DELIMITER ;

call TEST_PROCEDURE3('test@naver.com', 'test', 'test');

-- 등급 조회
    -- 글을 100개 이상 쓴 사용자는 고수입니다. 출력 
    -- 10개 이상 100개 미만은 중수입니다.
    -- 그 외는 초보입니다.

DELIMITER //
CREATE PROCEDURE TEST_PROCEDURE5(IN 이메일 VARCHAR(255))
BEGIN
    DECLARE 아이디 INT;
    DECLARE 글수 INT;

    SELECT id INTO 아이디 FROM author  WHERE email = 이메일; 
    SELECT COUNT(contents) INTO 글수 FROM post  WHERE author_id = 아이디;

    -- 글 수에 따른 메시지 출력
    IF 글수 >= 100 THEN
        SELECT '고수'  MESSAGE;
    ELSEIF 글수 >= 10 THEN
        SELECT '중수'  MESSAGE;
    ELSE
        SELECT '초보'  MESSAGE;
    END IF;
END
//
DELIMITER ;


-- for
    -- 반복문을 통해 post 대량 생성
DELIMITER //
CREATE PROCEDURE 글도배(IN 이메일 VARCHAR(255), IN 반복횟수 INT)
BEGIN
    DECLARE 아이디 INT DEFAULT (SELECT id FROM author WHERE email = 이메일);
    DECLARE i INT DEFAULT 0; 

    WHILE i < 반복횟수 DO
        INSERT INTO post (author_id, title) VALUES (아이디, '안녕하세요');
        SET i = i + 1;
    END WHILE;
END
//
DELIMITER ;

-- 프로시서 생성문 조회
show create procedure 프로시저명;

-- 프로시서 권한 부여
grant excute on board.글도배 to 'test1'@'localhost';


