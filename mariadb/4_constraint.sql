-- not null 조건
alter table 테이블면 modify column 타입 not null;

-- auto_increment
SELECT * FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_NAME = 'post';
alter table post drop foreign key post_ibfk_1; # fk 삭제
alter table post modify column id bigint auto_increment;
alter table author modify column id bigint auto_increment;
alter table post modify column author_id bigint;
describe author;

-- pk추가
    -- 방법1
        -- ALTER TABLE 테이블이름 MODIFY COLUMN 필드이름 필드타입 PRIMARY KEY
    -- 방법2(별도의 제약조건이름 옵션)
        -- ALTER TABLE 테이블이름 ADD CONSTRAINT 제약조건이름 PRIMARY KEY (필드이름)

-- 삭제된 제약조건 추가
    -- 동작옵션을 주지 않으면 기본은 RESTRICT
alter table post add constraint author_fk  foreign key(author_id) references author(id);

-- uuid (Universally Unique Identifier)
    -- 특정 항목을 전 세계적으로 유일하게 식별할 수 있도록 설계
ALTER TABLE post ADD COLUMN user_id CHAR(36) DEFAULT (UUID());

-- unique 제약조건// 자동으로 index 생성
alter table author modify column email varchar(255) unique;
show index from author;

-- on delete cascade test -> 부모 table id 수정하면 수정 x
SELECT * FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_NAME = 'post';
alter table post drop foreign key post_ibfk_1; # fk 삭제  // 실습 하니까 하는겨~
alter table post add constraint author_fk  foreign key(author_id) references author(id)  on delete on update;
alter table post add constraint author_fk  foreign key(author_id) references author(id)  on delete set null on update cascade;
-- 확인
update author set id=101 where id=1;
select * from post;


-- index별도로 제거 // 제약 조건 제거 시 남아있응게
ALTER TABLE post  DROP INDEX post_author_fk;