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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `product_comment` varchar(100) DEFAULT NULL,
  `product_rating` tinyint unsigned NOT NULL,
  `orderlist_id` int unsigned NOT NULL,
  `company_rating` tinyint DEFAULT NULL,
  `comment_company` varchar(100) DEFAULT NULL,
  `company_id` int unsigned NOT NULL,
  `product_id` int unsigned NOT NULL,
  `enrolled_user_id` int unsigned NOT NULL,
  `rating_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_reviews_orderlist1_idx` (`orderlist_id`),
  KEY `fk_reviews_company1_idx` (`company_id`),
  KEY `fk_review_product1_idx` (`product_id`),
  KEY `fk_review_enrolled_user1_idx` (`enrolled_user_id`),
  CONSTRAINT `fk_product_reviews_orderlist1` FOREIGN KEY (`orderlist_id`) REFERENCES `orderlist` (`id`),
  CONSTRAINT `fk_review_enrolled_user1` FOREIGN KEY (`enrolled_user_id`) REFERENCES `enrolled_user` (`id`),
  CONSTRAINT `fk_review_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_reviews_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'Ola kala',5,9,5,'Mono agaph re',2,4,9,'2021-11-11'),(2,'Πολυ ωραια',5,10,5,'Τελειο!',2,3,1,'2021-01-17');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-19 22:09:31
