-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: mapp
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `enrolled_user`
--

DROP TABLE IF EXISTS `enrolled_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrolled_user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dateofbirth` date NOT NULL,
  `postalcode` int NOT NULL,
  `address` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `municipality` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `image_url_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_enrolled_user_image_url1_idx` (`image_url_id`),
  CONSTRAINT `fk_enrolled_user_image_url1` FOREIGN KEY (`image_url_id`) REFERENCES `image_url` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrolled_user`
--

LOCK TABLES `enrolled_user` WRITE;
/*!40000 ALTER TABLE `enrolled_user` DISABLE KEYS */;
INSERT INTO `enrolled_user` VALUES (1,'john','1234','Ioannis','Ioannou','john@gmail.com','1990-03-02',15344,'akropoleos 2','athens','philadelphia','2102222222','6972222226',1),(2,'pelataki','1234','Vassiliki','Vassileiou','vaso@gmail.com','2001-03-02',15344,'aetos','athens','chalkidona','2106664333','6976663336',2),(3,'daboss','1234','fragko','fonias','ff@gmail.com','1970-03-02',15344,'kallithea 22','athens','politeia','2222222222','2222222222',3),(5,'nick','1234','Νικος','Νικολάου','nick@gmail.com','1990-03-02',15344,'Ακροπόλεως 2','Αθήνα','Φιλαδέλφεια','2102222222','6972222222',4),(6,'peter','1234','Πετρος','Πέτρου','peter@gmail.com','1990-03-02',15344,'Πετρου Ράλλη 2','Αθήνα','Πετρούπολη','2103332333','6972222333',5),(7,'maria','1234','Μαρια','Μαράτου','maria@gmail.com','1990-03-02',15344,'Αγιας Μαρίας 2','Αθήνα','Μαριούπολη','2104432333','6922552333',6),(8,'testaki','1234','Peter','Panos','pan@gmail.com','2001-11-04',15344,'Air 24','FlyLand','Flyyyy','2106664333','6976663336',64),(9,'τεστ','τττ','τττ','τττ','kaka@gmail.com','2021-09-09',12331,'58758ηξγ','νηξγκ','γμξ','67587587','68686',64),(10,'wrqwerwere','1234','weqrqrre','qwerwrqwer','qaqaw@gmail.com','2020-12-31',12331,'wqerqwer 22','werqwer','qwerqwe','13213123','1231231',66),(11,'noUserOnPayment','1234','noUserOnPayment','noUserOnPayment','nouseronpayment@gmail.com','1990-01-01',12345,'noUserStreet','noUserCity','noUsermunicipality','noUserTelephone','noUserMobile',66),(12,'minaidhs','1234','heloo','world','qaqaw@gmail.com','2021-01-12',15344,'wqerqwer 22','ΑΘΗΝΑ','aetos','2131313123','1321321',66);
/*!40000 ALTER TABLE `enrolled_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-19 22:09:30
