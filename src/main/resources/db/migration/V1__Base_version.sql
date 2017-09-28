-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: guithub
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `collaborator`
--

DROP TABLE IF EXISTS `collaborator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collaborator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `role` int(10) NOT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKgyxx779oyldn0panqmdt5q0k8` (`project_id`),
  KEY `FKpv9ttaqhwj3srjddin2lq491h` (`user_id`),
  CONSTRAINT `FKgyxx779oyldn0panqmdt5q0k8` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FKpv9ttaqhwj3srjddin2lq491h` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collaborator`
--

LOCK TABLES `collaborator` WRITE;
/*!40000 ALTER TABLE `collaborator` DISABLE KEYS */;
INSERT INTO `collaborator` VALUES (1,1,1,1,0),(2,9,1,0,0),(3,28,1,0,0),(4,2,2,1,0),(5,3,3,1,0),(6,4,4,1,0),(7,21,4,0,0),(8,25,4,0,0),(9,5,5,1,0),(10,6,6,1,0),(11,7,7,1,0),(12,9,7,0,0),(13,8,8,1,0),(14,11,11,1,0),(15,12,12,1,0),(16,24,12,0,0),(17,23,12,0,0),(18,13,13,1,0),(19,22,13,0,0),(20,14,14,1,0),(21,15,9,1,0),(22,15,15,1,0),(23,16,10,1,0),(24,16,16,1,0),(25,10,16,0,0),(26,17,17,1,0),(27,18,18,1,0),(28,19,19,1,0),(29,20,20,1,0);
/*!40000 ALTER TABLE `collaborator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cookie`
--

DROP TABLE IF EXISTS `cookie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cookie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `cookie` varchar(255) NOT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKrwp4p085fko2x6nnikhdwfv36` (`user_id`),
  CONSTRAINT `FKrwp4p085fko2x6nnikhdwfv36` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cookie`
--

LOCK TABLES `cookie` WRITE;
/*!40000 ALTER TABLE `cookie` DISABLE KEYS */;
INSERT INTO `cookie` VALUES (1,1,'fk5l4mn4do45led8',0),(2,2,'nmf56lf99uflse4j',0),(3,3,'lbmcngui789yfhr6',0),(4,4,'qas987rfj4nv93dl',0),(5,5,'fki234nyt78jhf09',0),(6,6,'bncko90uhs3e4r8j',0),(7,7,'7jqa904kmn2ws6yh',0),(8,8,'1zx34ki56mf4ews4',0),(9,9,'asd789lkj56rf23d',0),(10,10,'c99kmn34fds89jwa',0),(11,11,'ftg123kug456cvh6',0),(12,12,'lkj98hgr432xc456',0),(13,13,'asdfg987njr64lnd',0),(14,14,'plmnji87ygfr45ds',0),(15,15,'abf7smd8v9kd5rnd',0),(16,16,'nn7ygf89kdb64mf0',0),(17,17,'huiolm876vfr4dja',0),(18,18,'aqw123nbv6fk9dmn',0),(19,19,'0o9ijytgf876nhyd',0),(20,20,'2we4fjn876zmjfte',0),(21,21,'sf8kf98fnby57f43',0),(22,22,'89fy65nbf99jedlh',0),(23,23,'12sd98fv64mbxire',0),(24,24,'ghbvf567dcvgtrfd',0),(25,25,'ploik987yhn78f7f',0),(112,28,'e0cf76e1-b5c5-4fcf-86b2-6ef1e00f203a',0);
/*!40000 ALTER TABLE `cookie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `project_name` varchar(255) NOT NULL,
  `create_date` varchar(255) NOT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKo06v2e9kuapcugnyhttqa1vpt` (`user_id`),
  CONSTRAINT `FKo06v2e9kuapcugnyhttqa1vpt` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,28,'bass','07.05.2017',0),(2,2,'solo','06.05.2017',0),(3,3,'guitar','05.05.2017',0),(4,4,'drum','04.05.2017',0),(5,5,'keys','03.05.2017',0),(6,6,'introduction','02.05.2017',0),(7,7,'chorus','01.05.2017',0),(8,8,'bust','30.04.2017',0),(9,15,'dromroll','29.04.2017',0),(10,16,'saxophone','28.04.2017',0),(11,11,'middle','27.04.2017',0),(12,12,'bit','26.04.2017',0),(13,13,'verse','25.04.2017',0),(14,14,'violin','24.04.2017',0),(15,15,'piano','23.04.2017',0),(16,16,'final','22.04.2017',0),(17,17,'flute','21.04.2017',0),(18,18,'cover','20.04.2017',0),(19,19,'composition','19.04.2017',0),(20,20,'concert','18.04.2017',0);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schema_version`
--

DROP TABLE IF EXISTS `schema_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schema_version` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `schema_version_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schema_version`
--

LOCK TABLES `schema_version` WRITE;
/*!40000 ALTER TABLE `schema_version` DISABLE KEYS */;
INSERT INTO `schema_version` VALUES (1,'1','Base version','SQL','V1__Base_version.sql',-217737013,'root','2017-05-09 21:11:28',250,1),(2,'2','Base version','SQL','V2__Base_version.sql',-1403896704,'root','2017-05-09 21:11:28',35,1);
/*!40000 ALTER TABLE `schema_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  `bio` varchar(255) DEFAULT NULL,
  `foto` varchar(255) NOT NULL DEFAULT 'img/avatar.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ann','123456','ann@mail.com',0,NULL,'img/avatar.jpg'),(2,'Banny','654321','banny@mail.com',0,NULL,'img/avatar.jpg'),(3,'Celly','987456','celly@mail.com',0,NULL,'img/avatar.jpg'),(4,'Dafna','654789','dafna@mail.com',0,NULL,'img/avatar.jpg'),(5,'Each','741258','each@mail.com',0,NULL,'img/avatar.jpg'),(6,'French','963258','french@mail.com',0,NULL,'img/avatar.jpg'),(7,'Georg','789639','georg@mail.com',0,NULL,'img/avatar.jpg'),(8,'Harris','321147','harris@mail.com',0,NULL,'img/avatar.jpg'),(9,'Inna','456741','inna@mail.com',0,NULL,'img/avatar.jpg'),(10,'Jon','123258','jon@mail.com',0,NULL,'img/avatar.jpg'),(11,'Kristina','789852','kristina@mail.com',0,NULL,'img/avatar.jpg'),(12,'Liza','452145','liza@mail.com',0,NULL,'img/avatar.jpg'),(13,'Mary','563325','mary@mail.com',0,NULL,'img/avatar.jpg'),(14,'Nick','589965','nick@mail.com',0,NULL,'img/avatar.jpg'),(15,'Otis','785547','otis@mail.com',0,NULL,'img/avatar.jpg'),(16,'Polly','589965','polly@mail.com',0,NULL,'img/avatar.jpg'),(17,'Quarter','741852','quarter@mail.com',0,NULL,'img/avatar.jpg'),(18,'Ron','965523','ron@mail.com',0,NULL,'img/avatar.jpg'),(19,'Stim','785412','stim@mail.com',0,NULL,'img/avatar.jpg'),(20,'Tom','896523','tom@mail.com',0,NULL,'img/avatar.jpg'),(21,'Alex','159951','alex@mail.com',0,NULL,'img/avatar.jpg'),(22,'Bobby','753357','bobby@mail.com',0,NULL,'img/avatar.jpg'),(23,'Carlo','852357','carlo@mail.com',0,NULL,'img/avatar.jpg'),(24,'Daddy','789458','daddy@mail.com',0,NULL,'img/avatar.jpg'),(25,'Erick','963325','erick@mail.com',0,NULL,'img/avatar.jpg'),(28,'admin','25d55ad283aa400af464c76d713c07ad','admin@mail.ru',0,NULL,'img/avatar.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `version`
--

DROP TABLE IF EXISTS `version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `version_number` int(20) NOT NULL,
  `xml_link` varchar(255) NOT NULL,
  `approve` tinyint(1) NOT NULL DEFAULT '0',
  `commit_message` varchar(255) NOT NULL,
  `create_date` varchar(255) NOT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK5q7csydn4alo2pf0bbv74g9ko` (`project_id`),
  KEY `FK73nui2hklc6pvtp7dastpmh8i` (`user_id`),
  CONSTRAINT `FK5q7csydn4alo2pf0bbv74g9ko` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FK73nui2hklc6pvtp7dastpmh8i` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `version`
--

LOCK TABLES `version` WRITE;
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
INSERT INTO `version` VALUES (1,1,1,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','07.05.2017',0),(2,2,2,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','06.05.2017',0),(3,2,2,2,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','08.05.2017',0),(4,2,2,3,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',0,'test','22.05.2017',0),(5,3,3,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','05.05.2017',0),(6,4,4,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','04.05.2017',0),(7,4,4,2,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',0,'test','06.05.2017',0),(8,5,5,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','03.05.2017',0),(9,6,6,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','02.05.2017',0),(10,7,7,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','01.05.2017',0),(11,8,8,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','30.04.2017',0),(12,8,8,2,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','03.05.2017',0),(13,11,11,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','27.04.2017',0),(14,12,12,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','26.04.2017',0),(15,13,13,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','25.04.2017',0),(16,14,14,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','24.04.2017',0),(17,14,14,2,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',0,'test','26.04.2017',0),(18,15,9,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','29.04.2017',0),(19,15,15,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','23.04.2017',0),(20,15,15,2,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','28.04.2017',0),(21,16,10,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','28.04.2017',0),(22,16,16,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','22.04.2017',0),(23,16,16,2,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',0,'test','27.04.2017',0),(24,17,17,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','21.04.2017',0),(25,18,18,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','20.04.2017',0),(26,19,19,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','19.04.2017',0),(27,20,20,1,'https://www.primaryteaching.co.uk/prodimg/B31_1_Zoom.jpg',1,'test','18.04.2017',0);
/*!40000 ALTER TABLE `version` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-10 15:29:20
