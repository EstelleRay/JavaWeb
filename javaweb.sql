# Host: localhost  (Version 5.7.23-log)
# Date: 2018-10-08 22:31:44
# Generator: MySQL-Front 6.1  (Build 1.18)


#
# Structure for table "users"
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
