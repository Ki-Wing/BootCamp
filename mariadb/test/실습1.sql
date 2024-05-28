
-- 실습[1-author||post||author_post||address]
create database board2;
use board2;

    -- author table 
CREATE TABLE `author` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(100) DEFAULT NULL,
   `email` varchar(255) NOT NULL,
   `passwd` varchar(255) DEFAULT NULL,
   `crated_time` datetime DEFAULT current_timestamp(),
   PRIMARY KEY (`id`),
   UNIQUE KEY `email` (`email`)
 )
    -- post table 
CREATE TABLE `post` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `title` varchar(255) NOT NULL,
   `contents` varchar(3000) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) 

    -- address table
CREATE TABLE `address` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `city` varchar(255) DEFAULT NULL,
   `street` varchar(255) DEFAULT NULL,
   `author_id` int(11) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `author_id` (`author_id`), 
   CONSTRAINT `address_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE
 ) 
    -- author_post table
CREATE TABLE `author_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  KEY `author_post_ibfk_2` (`post_id`),
  CONSTRAINT `author_post_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `author_post_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE
)

-- 제약조건 변경
ALTER TABLE author_post drop constraint author_post_ibfk_1;
alter table author_post add CONSTRAINT `author_post_ibfk_1` 
FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE;


