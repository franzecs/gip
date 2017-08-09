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
-- Table structure for table `estagio`
--

DROP TABLE IF EXISTS `estagio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estagio` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `aluno` bigint(20) NOT NULL,
  `periodo` varchar(3) DEFAULT NULL,
  `semestreatual` varchar(6) DEFAULT NULL,
  `tipoestagio` varchar(12) DEFAULT NULL,
  `diaestagio` varchar(10) DEFAULT NULL,
  `horario` varchar(12) DEFAULT NULL,
  `observacao` varchar(500) DEFAULT NULL,
  `datainscricao` date DEFAULT NULL,
  `dp` tinyint(1) DEFAULT NULL,
  `cargahoraria` varchar(3) DEFAULT NULL,
  `professor` varchar(100) DEFAULT NULL,
  `nota` double DEFAULT NULL,
  `situacao` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `idx_aluno_idx` (`aluno`),
  CONSTRAINT `idx_aluno` FOREIGN KEY (`aluno`) REFERENCES `aluno` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estagio`
--

LOCK TABLES `estagio` WRITE;
/*!40000 ALTER TABLE `estagio` DISABLE KEYS */;
INSERT INTO `estagio` VALUES (1,1,'5º','2017.2','REAL CÍVEL',NULL,NULL,NULL,NULL,1,NULL,'fulano',0,NULL);
/*!40000 ALTER TABLE `estagio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-15 12:55:01
