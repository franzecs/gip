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
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `coordenador` varchar(150) DEFAULT NULL,
  `mec` varchar(30) NOT NULL,
  `ies` bigint(20) NOT NULL,
  `horarioseg` varchar(32) DEFAULT NULL,
  `horarioter` varchar(32) DEFAULT NULL,
  `horarioqua` varchar(32) DEFAULT NULL,
  `horarioqui` varchar(32) DEFAULT NULL,
  `horariosex` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_curso_ies_idx` (`ies`),
  CONSTRAINT `fk_curso_ies` FOREIGN KEY (`ies`) REFERENCES `ies` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'ADMINISTRAÇÃO','HENRIQUE SERGIO CAVALCANTE ROLIM','RECONHECIDO',1,'17:30-20:30','','17:30-20:30','',''),(2,'ENFERMAGEM','FERNANDA ROCHELLY DO NASCIMENTO MOTA','RECONHECIDO',1,'','18:00-22:00','18:00-22:00','',''),(4,'DIREITO','EDENILO BALTAZAR BARREIRA FILHO','reconhecido',1,'17:30-19:10/20:30-22:00','17:30-22:00','17:30-20:30','',''),(5,'FARMÁCIA','LANA KARINE VASCONCELOS BARROSO','reconhecido',1,'19:10-21:40','17:30-20:00/20:15-21:55','','',''),(6,'FISIOTERAPIA','FABRICIA SALVADOR BEZERRA','reconhecido',1,'17:55-20:15','','','','17:55-20:15'),(7,'NUTRIÇÃO','ANNUNZIATA CUNTO DE VASCONCELOS','autorizado',1,'','18:00-20:30','','19:15-21:45',''),(8,'EDUCAÇÃO FÍSICA BACHARELADO','RHODEN MELO OLIVEIRA','autorizado',1,'17:30-20:30','17:30-20:30','','',''),(9,'EDUCAÇÃO FÍSICA LICENCIATURA','RHODEN MELO OLIVEIRA','',1,'17:30-20:30','17:30-20:30','','',''),(10,'ADMINISTRAÇÃO','MARIA CAROLINA DE ALCANTARA BUOSI','reconhecido',2,'18:40-22:00','','18:40-20:00','',''),(11,'CIÊNCIAS CONTÁBEIS','TATIANA LEITÃO VIANA SOUZA','reconhecido',2,'18:40-21:00','','','','18:40-21:00'),(12,'DIREITO','ANA ISABEL MODENA','reconhecido',2,'','17:30-19:10/20:30-22:00','17:30-19:10/20:30-22:00','18:00-22:00',''),(13,'ENGENHARIA DA PRODUÇÃO','JOÃO MARCELO CARNEIRO','',2,'','','','',''),(14,'SERVIÇO SOCIAL','ANTÔNIO DIOGO CALS DE OLIVEIRA FILHO','reconhecido',2,'17:30-19:10','17:30-22:00','','','');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-15 12:55:02
