# Host: localhost  (Version: 5.5.20)
# Date: 2018-11-07 11:57:17
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

INSERT INTO `tb_user` VALUES ('1','1','1','1','11','1','1'),('2','2','2','e0052341-92b8-4a48-abdc-211dfa4d3fd3_Koala.jpg','f','2','2');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tb_posts"
#

INSERT INTO `tb_posts` VALUES (1,'1','222','2222222222222','2018-11-07 11:52:45',0),(2,'1','333','33','2018-11-07 11:55:27',0);

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
