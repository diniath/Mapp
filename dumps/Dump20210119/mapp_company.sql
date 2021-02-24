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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `cname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `postalcode` int NOT NULL,
  `address` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `municipality` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `vatnumber` varchar(45) NOT NULL,
  `vatservice` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `representative` varchar(45) NOT NULL,
  `rating` int unsigned DEFAULT NULL,
  `iban` varchar(45) DEFAULT NULL,
  `image_url_id` int unsigned NOT NULL,
  `profile` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_image_url1_idx` (`image_url_id`),
  CONSTRAINT `fk_company_image_url1` FOREIGN KEY (`image_url_id`) REFERENCES `image_url` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'kukuruku','psalidi1234','Mind the Cut','mindthecut@gmail.com',15235,'Κύπρου 5','Αθήνα','Βριλήσσια','2106567891','6934256781','445124761','ΔΟΥ Χολαργού','Mind the Cut: the new barber\'s experience in town','Αργύρης Δεμπεγιώτης',5,'GR16014010101002101047414',7,'Barber Shop'),(2,'shashasha','nuxia1234','Fairy Nails','fairynails@gmail.com',15235,'Κύπρου 7','Αθήνα','Βριλήσσια','2106452134','6985432165','324567812','ΔΟΥ Χολαργού','Παραμυθένια νύχια! Περιποίηση άκρων, μανικιούρ, πεντικιούρ, ακρυλικό, ημιμόνιμο στις καλύτερες τιμές','Σοφία Σάρδη',5,'GR16014010101002101048713',8,'Περιποίηση άκρων'),(3,'shoshosho','nuxia5678','Nails and More','nailsandmore@gmail.com',12135,'Ακαρνανίας 52','Αθήνα','Περιστέρι','2105765431','6876543129','456123980','ΔΟΥ Περιστερίου','Υπέροχος χώρος, καταπληκτικές υπηρεσίες περιποίησης νυχιών!','Αιμιλία Μπαλούρδου',5,'GR16014010101002101065123',9,'Μανικιούρ-Πεντικιούρ'),(4,'shesheshe','nuxia0987','Nail Design by Eleni','eleninaildesign@gmail.com',12135,'Αμοργού 14','Αθήνα','Περιστέρι','2105134568','6975434565','431123789','ΔΟΥ Περιστερίου','Ονειρεύεστε τα τέλεια νύχια; Είμαστε εδώ για εσάς. Υπηρεσίες νυφικού μανικιούρ-πεντικιούρ με τιμές στα μέτρα σας!','Ελένη Σουρμελά',5,'GR16014010101002101043123',10,'Nail Artist'),(5,'shishishi','psalidi7ole','Roses and Razors','rosesandrazors@gmail.com',15235,'Ολύμπου 27','Αθήνα','Βριλήσσια','2106854123','6975431246','443316789','ΔΟΥ Χολαργού','Gentlmen\'s club for real gentlemen. Νέος χώρος στα Βριλήσσια για την ανδρική περιποίηση','Μάνος Χατζηχρήστος',5,'GR16014010101002101041251',11,'Gentlmen\'s Club - Barber Shop'),(6,'fafafa','solines123','Υδραυλικές εργασίες Θωμάς Ο. Θωμόπουλος','thomasthomop@gmail.com',11853,'Νεφέλης 57','Αθήνα','Πετράλωνα','2103121567','6986554519','432189010','ΔΟΥ ΦΑΕ Αθηνών','Υδραυλικές εργασίες παντώς τύπου. Για οποιαδήποτε ανάγκη, οποιαδήποτε ημέρα!','Θωμάς Θωμόπουλος',5,'GR16014010301002101041251',12,'Υδραυλικές εργασίες'),(7,'fefefe','solines456','Mr Plumber','mrplumberservice@gmail.com',11853,'Αριστόβουλου 46','Αθήνα','Πετράλωνα','2103145611','6985432178','314511901','ΔΟΥ ΦΑΕ Αθηνών','Καζανάκια - Συντηρήσεις σωμάτων - Σωληνώσεις','Παρασκευάς Βενεδικτίνος',5,'GR16014010101002101041001',13,'Υδραυλικές εργασίες'),(8,'fififi','varakia123','Body and Soul','bodyandsoul@gmail.com',17122,'Κοραή 20','Αθήνα','Νέα Σμύρνη','2109765143','6987114567','445127811','ΔΟΥ Καλλιθέας','Βρείτε την εσωτερική σας ισορροπία μέσα από την εξερεύνηση του εαυτού σας. Namaste! Hatha Yoga - Vinyasa Yoga - Pilates','Ισμήνη Φιλιοπούλου',5,'GR16014010101002101034189',14,'Yoga Instructor'),(9,'fofofo','varakia456','Σωτήρης Ι. Ρανταγκαστινός','personaltrainer1@gmail.com',17122,'Ουρανίας Δούκα 7','Αθήνα','Νέα Σμύρνη','21093741256','6972225117','44123670','ΔΟΥ Καλλιθέας','Personal trainer με πολυετή εμπειρία. Cross Fit - Krav Maga - Brazilian jiu-jitsu. Το μόνο εμπόδιο του εαυτού σου είσαι εσύ.','Σωτήρης Ρανταγκαστινός',5,'GR16014010101002101001234',15,'Personal Trainer - Self Defence'),(10,'kekeke','kekpc','PC Service','pcservicedoctor@gmail.com',14232,'Λόρδου Βύρωνος 9','Αθήνα','Νέα Ιωνία','2107712561','6942378912','441098124','ΔΟΥ Νέας Ιωνίας','Επισκευές Ηλεκτρονικών Υπολογιστών και παντώς είδους βλαβών. Αναλαμβάνω εγκαταστάσεις νέων τερματικών. Εξυπηρέτηση: Περισσός, Νέα Ιωνία και γύρω περιοχές','Σπύρος Βανδής',5,'GR16014010101002101042156',16,'Επισκευές Η/Υ'),(11,'kikiki','kikpc','Fix it!','fixitpcservice@gmail.com',14232,'Ξάνθου 13','Αθήνα','Νέα Ιωνία','2107687124','6954231259','44125221','ΔΟΥ Νέας Ιωνίας','Επισκευές και εγκαταστάσεις Η/Υ. Επισκευές κινητών. Επισκευές και κατ\' οίκον.','Σταμτάτης Σταματιάδης',5,'GR16014010101002101052142',17,'Επισκευές Η/Υ - κινητών'),(12,'la','La','come on!','fixitpcservice@gmail.com',14232,'Test 13','Test ','Test ','2107687124','6954231259','44125221','Test ','Test ','Test ',5,'GR16014010101002101052142',64,'Test '),(13,'werrwrew','1234','kakabubu','sdsDFfdSF@gmail.com',12331,'AA 22','DFASF','ASDF','123132','1231233131233','31233213','skaska','qwerdqwecq','SDFASDSAFS',5,'123133',65,'bubu'),(14,'werrwrew','1234','kakabubu','sdsDFfdSF@gmail.com',12331,'AA 22','DFASF','ASDF','123132131','1312312','1323','sfawrc','fdsecaf','SDFASDSAFS',5,'1231321',65,'bubu'),(15,'werrwrew','1234','kakabubu','sdsDFfdSF@gmail.com',12331,'AA 22','DFASF','qwe','1312','1231','1231','skaska','dd','SDFASDSAFS',5,'132123',65,'bubu'),(16,'bububu','kipos123','Φύλλο Φύλλο','fyllofyllo@gmail.com',14232,'Μαδύτου 4','Αθήνα','Νέα Ιωνία','2107645124','6954681259','44125543','ΔΟΥ Νέας Ιωνίας','Η εταιρεία Φύλλο Φύλλο είναι στην διάθεσή σας για να σχεδιάσουμε τον κήπο των ονείρων σας!','Χρήστος Χρήστου',5,'16014010101002101052345',69,'Gardening Services'),(17,'bebebe','kipos345','Δέντρα και Πρασινάδα','dentraprasinada@gmail.com',14232,'Δημοσθένους 29','Αθήνα','Νέα Ιωνία','2107645178','6954686759','44125512','ΔΟΥ Νέας Ιωνίας','Τα πάντα για τον κήπο και τα φυτά σας.','Ανέστης Καραμάνος',5,'16014010101002101052111',65,'Gardening Services'),(18,'rttrt','1234','kakabubu','fyllofyllo@gmail.com',15344,'Μαδύτου 4','ΑΘΗΝΑ','Νέα Ιωνία','4654765465','567587547645','3453654','skaska','hfcnhf','Χρήστος Χρήστου',5,'475467',65,'Gardening Services');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
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
