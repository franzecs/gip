-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_gip
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(4) NOT NULL,
  `tamanho` varchar(3) DEFAULT NULL,
  `andar` varchar(10) DEFAULT NULL,
  `situacao` varchar(8) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,'101','55','Térreo','Vazia'),(2,'103','55','Térreo','Vazia'),(3,'105','55','Térreo','Vazia'),(4,'201','55','1º andar','Vazia'),(5,'202','55','1º andar','Vazia'),(6,'203','55','1º andar','Vazia'),(7,'204','55','1º andar','Vazia'),(8,'205','55','1º andar','Vazia'),(9,'206','55','1º andar','Vazia'),(10,'207','55','1º andar','Vazia'),(11,'208','55','1º andar','Vazia'),(12,'209','75','1º andar','Cedida'),(13,'211','75','1º andar','Cedida'),(14,'210','30','1º andar','Vazia'),(15,'212','34','1º andar','Vazia'),(16,'213','30','1º andar','Vazia'),(17,'215','35','1º andar','Vazia'),(18,'216','35','1º andar','Vazia'),(19,'217','30','1º andar','Vazia'),(20,'218','35','1º andar','Vazia'),(21,'214','30','1º andar','Vazia'),(22,'102','55','Térreo','Cedida');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-15 12:55:03
