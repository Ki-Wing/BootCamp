-- 동시성 이슈로 격리 수준 높히면 정합성은 높아지나 성능이 떨어짐

-- dirty read 실습
    -- 한 트랜잭션이 다른 트랜잭션이 수정 중인 데이터를 읽을 수 있는 문제
    -- 1) 워크밴치에서 autocommit 해제 후 update 실행 -> commit이 안된 상태
    -- 2) 터미널 열어서(다른 트랜잭션이 생성) select 했을때 위 변경사항이 적용됐는지 확인 
    -- 3) 조회 X // mariadb 격리 수준이 높은거임

-- phantom read 동시성 이슈 실습
    -- 한 트랜잭션이 같은 조회쿼리를 여러 번 실행했을 때, 그 중간에 다른 트랜잭션에서 새로운 데이터를 추가/삭제하여 다르게 나타나는 문제
    -- 1) 워크밴치에서 시간 두고 2번의 select가 이뤄지고, 터미널 중간에 insert 실행
    -- 2) 2번의 select 결괏값이 동일한지 확인
    -- 3) 동일해야 repeatable read
start transaction;
select count(*) from author;
do sleep(15);
select count(*) from author;
commit;
    -- 터미널에서 아래 insert문 실행
    insert into author(title) values("hun");

-- lost update 이슈를 해결하기 위한 공유락 (shared lock)
-- 1) 워크밴치에서 코드 실행
start transaction;
select post_count from author where id=1 lock in share mode;
do sleep(15)
select post_count from author where id=1 lock in share mode;
commit;
select post_count from author where id=1; -- 밑에 터미널 코드 끝난 후 실행
-- 2) 터미널 코드
    select post_count from author where id=1 lock in share mode;
    update author set post_count=0 where id=1;   --워크밴치가 끝난 후 실행됨


-- 배타적 lock(exclusive) : select for update
-- select 부터 lock
-- 1) 워크밴치에서 코드 실행
start transaction;
select post_count from author where id=1 for update;
do sleep(15)
select post_count from author where id=1 for update;
commit;
select post_count from author where id=1; -- 밑에 터미널 코드 끝난 후 실행
-- 2) 터미널 코드
    select post_count from author where id=1 for update;
    update author set post_count=0 where id=1;   --워크밴치가 끝난 후 실행됨




