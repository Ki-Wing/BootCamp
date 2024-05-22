-- MariaDB dump 10.19-11.3.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: board
-- ------------------------------------------------------
-- Server version	11.3.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` tinyint(3) unsigned DEFAULT NULL,
  `role` enum('user','admin') NOT NULL,
  `birth` date DEFAULT NULL,
  `created_time` datetime DEFAULT current_timestamp(),
  `post_count` int(11) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES
(1,'abc','test@naver.com',NULL,NULL,25,'user',NULL,'2023-11-17 12:19:26',0),
(2,'def','test2@google.com','1234','동작구',30,'user',NULL,'2024-05-17 12:19:37',0),
(3,'익명','hi@naver.com',NULL,NULL,27,'user','2001-06-25','2024-05-17 14:11:49',0),
(4,'익명','test11@naver.com','4567',NULL,24,'user','2000-12-17','2024-05-17 12:19:37',0),
(5,NULL,'test5@naver.com','321',NULL,30,'user',NULL,'2024-05-17 12:19:37',0),
(6,NULL,'test6@naver.com',NULL,NULL,25,'user',NULL,'2024-05-17 12:19:37',0),
(7,NULL,'test7@naver.com','124',NULL,27,'user',NULL,'2024-05-17 12:19:37',0),
(8,NULL,'test8@naver.com','5123',NULL,20,'user',NULL,'2024-05-17 12:19:37',0),
(9,NULL,'dldbsk@google.com','1541',NULL,30,'user',NULL,'2024-05-17 12:19:37',0),
(10,NULL,'dlglsk@google.com','1222',NULL,NULL,'admin',NULL,'2024-05-17 12:19:37',0);
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `contents` varchar(3000) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `price` decimal(10,3) DEFAULT NULL,
  `created_time` datetime DEFAULT current_timestamp(),
  `user_id` char(36) NOT NULL DEFAULT uuid(),
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `author_fk` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES
(1,'asd','hihihi',10,1234.100,NULL,'d8014096-141e-11ef-8a40-8cb0e9d93257'),
(2,'hi','hi',2,1234.120,NULL,'d8014176-141e-11ef-8a40-8cb0e9d93257'),
(3,'hi','hi',2,1000.000,NULL,'d80141a5-141e-11ef-8a40-8cb0e9d93257'),
(4,'qwe','qwe',3,2000.000,'2022-05-16 12:19:55','d80141c6-141e-11ef-8a40-8cb0e9d93257'),
(5,'sdf','sdf',3,3000.000,'2024-05-17 12:19:55','d8014242-141e-11ef-8a40-8cb0e9d93257'),
(6,'hi','hi',4,1000.000,'2024-05-17 12:19:55','d8014267-141e-11ef-8a40-8cb0e9d93257'),
(7,'hi','qwe',7,2000.000,'2024-05-20 17:04:04','8e0c2b48-167f-11ef-8a40-8cb0e9d93257'),
(8,'br','qwew',7,5000.000,'2023-05-20 17:04:11','91d6e809-167f-11ef-8a40-8cb0e9d93257'),
(9,'dfg','adfsd',3,4000.000,'2024-05-20 17:04:22','98d19438-167f-11ef-8a40-8cb0e9d93257'),
(23,'SDFDS','SDFSDF',7,10000.000,'2024-05-21 11:23:24','21a93d55-1719-11ef-8a40-8cb0e9d93257');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22 16:27:12
