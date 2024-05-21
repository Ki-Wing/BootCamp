-- index
    -- 색인/목차 처럼 데이터 검색 속도를 향상시키는데 사용 (tree 구조)
    -- 조회 성능은 향상. 삽입/수정은 하락

-- 기본 키 인덱스 (Primary Key Index):
    --테이블의 기본 키(Primary Key)에 자동으로 생성되는 인덱스입니다.
    --고유성, NULL 값 X
-- 고유 인덱스 (Unique Index):
    --특정 열에 중복 값 X
    --하나 이상의 열에 대해 설정
-- 일반 인덱스 (Non-Unique Index):
    --중복 값을 허용
-- 비트맵 인덱스 (Bitmap Index):
    --주로 데이터 중복이 많은 열에 사용
    --비트맵 사용으로 공간 효율적  //OLAP 시스템
-- 클러스터형 인덱스 (Clustered Index):
    --테이블의 데이터가 인덱스 순서에 따라 물리적으로 정렬됩
    --테이블당 하나만 생성
    --인덱스가 테이블 데이터를 포함하므로 데이터를 읽는 속도가 빠름

-- index 확인
show index from table명 --~컬럼에 조회 성능 높이기 위해 목차 페이지 넣음(빈번한 조회. 용량 차지..)

-- 기본 index 생성
CREATE INDEX index명 ON table명 (column명);

-- index 삭제
alter table table명 drop index 인덱스명;

-- [실습]
create database db명;  --스키마 생성
use db명;
    -- table 생성
CREATE TABLE author (
   id bigint(20) NOT NULL AUTO_INCREMENT,
   email varchar(255) DEFAULT NULL,  -- email에는 index가 안걸림
   PRIMARY KEY (id)
 );
show index from author; --id만 들어있음
    -- 대량 데이터 생성 프로시저 만들기
        -- 미리 컴파일 됐기 때문에 call만 하면 실행돰
        -- for문, if문 자유롭게 쓸 수 있 ㅇㅇ
DELIMITER //
CREATE PROCEDURE insert_authors()  -- 프로시저 이름
BEGIN
    DECLARE i INT DEFAULT 1; --  DECLARE:변수 지정
    DECLARE email VARCHAR(100);
    DECLARE batch_size INT DEFAULT 10000; -- 한 번에 삽입할 행 수
    DECLARE max_iterations INT DEFAULT 100; -- 총 반복 횟수 (100000000 / batch_size)
    DECLARE iteration INT DEFAULT 1;
    WHILE iteration <= max_iterations DO  -- 트랜잭션 나눌라고 이중 while문 사용
        START TRANSACTION;
        WHILE i <= iteration * batch_size DO
            SET email = CONCAT('ynlee', i, '@naver.com'); -- 문자 결합 함수 i만큼 증가
            INSERT INTO author (email) VALUES (email);
            SET i = i + 1;
        END WHILE;
        COMMIT;
        SET iteration = iteration + 1;
        DO SLEEP(0.1); -- 각 트랜잭션 후 0.1초 지연
    END WHILE;
END //
DELIMITER ;
    -- 프로시저 호출
call insert_authors();
select * from author where email='ynlee9999@naver.com'; -- 0초 이상 걸림
    -- index 생성
CREATE INDEX email_index ON author(email);
show index from author; 
select * from author where email='ynlee9999@naver.com'; -- index 생성 훟 0초 걸림
    --data 추가할떄마다 index페이지도 데이터 추가해야함 (목차잉게)
    


