-- db 접속
mariadb -u root -p

-- db 목록 조회
show databases;

-- db 생성
create database db명

-- db 삭제
drop database db명
drop database if EXISTS db명;

-- db 선택
use db명;

-- table 조회
show tables;

-- table 생성
create table author(id int primary key, name varchar(255), email varchar(255), passwd varchar(255));
create table posts(id int primary key, title varchar(255), content varchar(255), author_id int, foreign key(author_id) references author(id));

-- 컬럼 조회
describe table명;

-- 생성 query 조회
show create table table명;

-- columns 조회
show full columns from table명;

-- index 조회
show index from table명;

-- alter :  구조 변경
alter table posts rename post;

-- table 컬럼 추가
alter table table명 add column test1 varchar(50); 

-- table 컬럼 삭제
alter table table명 drop column test1; 

-- table 컬럼명 변경'
alter table post change column content contents varchar(255);

-- table 컬럼 type, 제약 조건 변경
alter table author modify column email varchar(255) not null;


--실습 1)
--author에 address 컬럼 추가
--post에 title 컬럼울 not null
--post에 contents 컬럼 글자수 3000으로
alter table author add column address varchar(255);
alter table post modify column title varchar(255) not null;
alter table post modify column contents varchar(3000);

-- table 삭제
drop table table명
--+)
show create table post;

-- CREATE TABLE `post` (
--    `id` int(11) NOT NULL,
--    `title` varchar(255) DEFAULT NULL,
--    `content` varchar(3000) DEFAULT NULL,
--    `auth_id` int(11) DEFAULT NULL,
--    PRIMARY KEY (`id`),
--    KEY `auth_id` (`auth_id`),
--    CONSTRAINT `post_ibfk_1` FOREIGN KEY (`auth_id`) REFERENCES `author` (`id`)
--  ) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci
