﻿# Host: localhost  (Version: 5.5.20)
# Date: 2018-12-12 11:42:01
# Generator: MySQL-Front 5.3  (Build 1.21)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "tb_user"
#

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `stuId` varchar(255) NOT NULL DEFAULT '',
  `stuName` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `avatar` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `bio` text,
  `gitUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tb_user"
#

INSERT INTO `tb_user` VALUES ('1','1','1','1','11','1','1'),('2','2','2','e0052341-92b8-4a48-abdc-211dfa4d3fd3_Koala.jpg','f','2','2'),('3','123','3','5562b7ea-af07-4674-8cc2-09cf16728e66_Desert.jpg','m','','');

#
# Source for table "tb_posts"
#

DROP TABLE IF EXISTS `tb_posts`;
CREATE TABLE `tb_posts` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `posttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pv` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `post_author_stuId` (`author`),
  CONSTRAINT `post_author_stuId` FOREIGN KEY (`author`) REFERENCES `tb_user` (`stuId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "tb_posts"
#

INSERT INTO `tb_posts` VALUES (1,'1','222','2222222222222','2018-11-07 11:52:45',0),(2,'1','333','33','2018-11-07 11:55:27',0),(3,'3','111','111','2018-12-05 10:21:11',0);

#
# Source for table "tb_comments"
#

DROP TABLE IF EXISTS `tb_comments`;
CREATE TABLE `tb_comments` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL DEFAULT '',
  `postId` int(11) NOT NULL DEFAULT '0',
  `content` varchar(255) NOT NULL DEFAULT '',
  `posttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`commentId`),
  KEY `commentAuthor_UserStuID` (`author`),
  KEY `commentPostId_PostsId` (`postId`),
  CONSTRAINT `commentAuthor_UserStuID` FOREIGN KEY (`author`) REFERENCES `tb_user` (`stuId`),
  CONSTRAINT `commentPostId_PostsId` FOREIGN KEY (`postId`) REFERENCES `tb_posts` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Data for table "tb_comments"
#

INSERT INTO `tb_comments` VALUES (1,'2',3,'2','2018-12-12 10:07:07'),(2,'2',3,'2','2018-12-12 10:07:12'),(3,'2',3,'2','2018-12-12 10:07:34'),(4,'2',3,'3','2018-12-12 10:07:55'),(5,'2',3,'3','2018-12-12 10:19:56'),(6,'2',3,'3','2018-12-12 10:20:01'),(7,'2',3,'3','2018-12-12 10:20:02'),(8,'3',3,'7','2018-12-12 10:21:06'),(9,'3',3,'Q','2018-12-12 10:21:30'),(10,'3',3,'Q','2018-12-12 10:21:39'),(11,'3',3,'Q','2018-12-12 10:24:18'),(12,'3',1,'23','2018-12-12 10:28:33'),(13,'3',1,'t','2018-12-12 10:31:36'),(14,'3',1,'r','2018-12-12 10:41:26'),(15,'3',1,'mm','2018-12-12 10:43:43'),(16,'3',1,'w','2018-12-12 10:45:39'),(17,'3',1,'qq','2018-12-12 10:45:49'),(18,'3',2,'w','2018-12-12 10:49:24'),(19,'2',2,'22','2018-12-12 10:51:59'),(20,'2',2,'test','2018-12-12 11:01:47'),(21,'2',2,'test','2018-12-12 11:01:51'),(22,'2',1,'是是是','2018-12-12 11:04:36');

#
# Source for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `age` int(11) NOT NULL DEFAULT '1',
  `major` text NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "users"
#

INSERT INTO `users` VALUES ('1','1',1,'1'),('2','2',2,'2'),('3','3',3,'3');

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
