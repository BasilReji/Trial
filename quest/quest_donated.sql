CREATE DATABASE  IF NOT EXISTS `quest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quest`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: quest
-- ------------------------------------------------------
-- Server version	5.5.25a

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
-- Table structure for table `donated`
--

DROP TABLE IF EXISTS `donated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donated` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `Status` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `id_donator` int(11) DEFAULT NULL,
  PRIMARY KEY (`did`),
  KEY `FK_qt1mhpc2lu7r2ayt1yj2bl46s` (`pid`),
  KEY `FK_s1ffjnckp6q19lpybjnex9gru` (`id_donator`),
  CONSTRAINT `FK_s1ffjnckp6q19lpybjnex9gru` FOREIGN KEY (`id_donator`) REFERENCES `donator` (`idDonator`),
  CONSTRAINT `FK_qt1mhpc2lu7r2ayt1yj2bl46s` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donated`
--

LOCK TABLES `donated` WRITE;
/*!40000 ALTER TABLE `donated` DISABLE KEYS */;
INSERT INTO `donated` VALUES (19,'Used','30',3,1),(21,'New','10',4,3);
/*!40000 ALTER TABLE `donated` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-13 10:34:51
