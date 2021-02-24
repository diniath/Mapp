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
-- Table structure for table `image_url`
--

DROP TABLE IF EXISTS `image_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_url` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(2083) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_url`
--

LOCK TABLES `image_url` WRITE;
/*!40000 ALTER TABLE `image_url` DISABLE KEYS */;
INSERT INTO `image_url` VALUES (1,'https://i.ibb.co/t4c6PZS/user1.jpg'),(2,'https://i.ibb.co/m4rvgzy/user2.jpg'),(3,'https://i.ibb.co/CvGF9Nf/user3.jpg'),(4,'https://i.ibb.co/zh1Z7zt/user4.jpg'),(5,'https://i.ibb.co/hcGC3kx/user5.jpg'),(6,'https://i.ibb.co/xMV9yPd/user6.jpg'),(7,'https://i.fbcd.co/products/original/61b9edf19ef295d913effee576abce8f276f53eb830c0cd65eaa9f0e2ca280a5.jpg'),(8,'https://cdn.dribbble.com/users/246611/screenshots/6372905/fourhands.su.jpg?compress=1&resize=400x300'),(9,'https://image.shutterstock.com/image-vector/nail-studio-logo-260nw-477015682.jpg'),(10,'https://static.vecteezy.com/system/resources/thumbnails/000/484/972/small/nail_studio_logo4.jpg'),(11,'https://st4.depositphotos.com/7473544/19626/v/1600/depositphotos_196260876-stock-illustration-barbershop-logo-barber-pole-vintage.jpg'),(12,'https://image.freepik.com/free-vector/vintage-plumbing-logo-service_43322-134.jpg'),(13,'https://img.freepik.com/free-vector/vintage-logo-graphic-design-print-stamp_140930-308.jpg?size=338&ext=jpg'),(14,'https://i.etsystatic.com/9026673/c/1247/991/261/79/il/b1b581/2531847702/il_340x270.2531847702_3pj3.jpg'),(15,'https://thelogocompany.net/wp-content/uploads/2018/03/fight-hard.png'),(16,'https://thumbs.dreamstime.com/b/computer-repair-service-laptop-screwdriver-wrench-computer-repair-service-laptop-screwdriver-wrench-pc-repair-110381963.jpg'),(17,'https://splendordesign.com/wp-content/uploads/2017/05/computerdoctor.jpg'),(18,'https://i.pinimg.com/564x/e7/ee/35/e7ee35b343478f2d163b40b96369e0b9.jpg'),(19,'https://fashionarrow.com/wp-content/uploads/2019/03/short-hairstyles-for-men.jpg'),(20,'https://trendyseekers.com/wp-content/uploads/2018/10/Slicked-Back-Undercut-with-Long-Beard.jpg'),(21,'https://i.pinimg.com/originals/7c/6b/d5/7c6bd546e4418c78f4aa2b13fafb80ec.jpg'),(22,'https://epagelmaties.gr/wp-content/uploads/CHRISTYN-NAILS-SALON-%CE%9C%CE%91%CE%9D%CE%99%CE%9A%CE%99%CE%9F%CE%A5%CE%A1-%CE%A0%CE%95%CE%9D%CE%A4%CE%99%CE%9A%CE%99%CE%9F%CE%A5%CE%A1-%CE%A4%CE%95%CE%A7%CE%9D%CE%97%CE%A4%CE%91-%CE%9D%CE%A5%CE%A7%CE%99%CE%91-%CE%92%CE%9B%CE%95%CE%A6%CE%91%CE%A1%CE%99%CE%94%CE%95%CE%A3-%CE%A6%CE%A1%CE%A5%CE%94%CE%99%CE%91-%CE%9A%CE%95%CE%A1%CE%91%CE%A4%CE%A3%CE%99%CE%9D%CE%99-epagelmaties.gr22-3.jpg'),(23,'https://www.larisaevents.gr/wp-content/uploads/2018/07/n2_3-1.jpg'),(24,'https://myspa.gr/wp-content/uploads/2017/10/pantikiour-hmimonimo-400x300.jpg'),(25,'https://www.gooddeals.gr/photos/vspa_main.jpg'),(26,'https://olagiatingunaika.gr/wp-content/uploads/2019/08/gel-manicure-simvoules.jpg'),(27,'https://www.flowmagazine.gr/wp-content/uploads/texni_shellac_i_allios_imimonimo_manikiour_ti_kindunous_kruvei_featured.jpg'),(28,'https://womland.files.wordpress.com/2013/09/imimonimi21.jpg'),(29,'https://www.womanoclock.gr/wp-content/uploads/2017/05/sxedia-pedicure-2017-kalokairi-13.jpg'),(30,'https://www.beautetinkyriaki.gr/wp-content/uploads/2018/07/sxedia-gia-imimonimo-manikiour-03.jpg'),(31,'https://www.beautymagic.gr/wp-content/uploads/2019/03/c5bfdc83149636fc0a53e01575778e5d.jpg'),(32,'https://www.regroup.gr/img/EshopProductsDisplayThumb/11846/thumb_design4u_001.jpg'),(33,'https://hugbeautysalon.gr/wp-content/uploads/2020/06/16015375903753.jpg'),(34,'https://www.losbarberos.gr/wp-content/uploads/2018/04/fade.jpg'),(35,'https://www.the-man.gr/wp-content/uploads/2020/02/petyxeis-mono-konto-kourema.jpg'),(36,'https://komotiriofaliro.com/_files/200000042-8eea58fe54/450/7EAD5EEC98EDA6C0A7A631FC632A3751.jpg'),(37,'https://2x1dks3q6aoj44bz1r1tr92f-wpengine.netdna-ssl.com/wp-content/uploads/2017/10/Best-Selection-Of-Beard-Accessories.jpg'),(38,'https://blog.11888.gr/wp-content/uploads/2017/03/fix-toilet-3.jpg'),(39,'https://bagnocasa.gr/wp-content/uploads/2016/06/classic-1.jpg'),(40,'https://24gr.gr/wp-content/uploads/2017/10/vlaves-sto-kalorifer-poies-einai-oi-syxnoteres-aities-poy-prokaloyn-vlaves-1.jpg'),(41,'https://www.diaforetiko.gr/wp-content/uploads/2019/05/ydraulikoi-voula-ydraulikos-ydraulikes-ergasies-vlaves-1.jpg'),(42,'https://www.chaniotis.com.gr/content/images/thumbs/0008620_-_600.jpeg'),(43,'https://s3.praktiker.gr/myPraktiker.Images/Tips/54/2/23477/floter_L.jpg'),(44,'https://st.douleutaras.gr/media/thumbs/img/bsdir/lp_header/66_-_%CE%98%CE%AD%CF%81%CE%BC%CE%B1%CE%BD%CF%83%CE%B7_550c1ap.jpg.360x240_q90_crop-%2C0_upscale.jpg'),(45,'https://decorexpro.com/images/article/orig/2018/05/samostoyatelnyj-demontazh-i-razborka-radiatorov-otopleniya-11.jpg'),(46,'https://www.westlondonliving.co.uk/wordpress/wp-content/uploads/2013/04/yoga.jpg'),(47,'https://c2.staticflickr.com/4/3493/3465969451_bdc4be9398.jpg'),(48,'https://fitspot47.gr/wp-content/uploads/2019/10/DSC_0080.jpg'),(49,'https://hobnob.gr/wp-content/uploads/2018/08/pilates-mat.jpg'),(50,'https://static.theyogarooms.co.uk/resources/classes/the-yoga-rooms-chorlton37b0072.jpg'),(51,'https://static.theyogarooms.co.uk/resources/classes/the-yoga-rooms-chorlton37b9760.jpg'),(52,'https://dailyburn.com/life/wp-content/uploads/2014/08/CrossFit-Workouts-5-WODs-1.jpg'),(53,'https://ifitnessbook.com/media/k2/items/cache/4648ad8dce49ac4b26f21cf81a446165_M.jpg'),(54,'https://cdn2.coachmag.co.uk/sites/coachmag/files/images/dir_31/mens_fitness_15823.jpg'),(55,'https://physiowanaka.co.nz/wp-content/uploads/2016/09/canstockphoto10275919-1.jpg'),(56,'https://informatics.sourceweb.ag/wp-content/uploads/2018/02/2118_pc-service.jpg'),(57,'https://www.drmpcservice.com/image/122341949.jpg'),(58,'https://techvalue.gr/wp-content/uploads/2017/10/%CE%B5%CF%80%CE%B9%CF%83%CE%BA%CE%B5%CF%85%CE%AE-%CE%BF%CE%B8%CF%8C%CE%BD%CE%B7%CF%82-%CE%BA%CE%B9%CE%BD%CE%B7%CF%84%CE%BF%CF%8D.jpg'),(59,'https://www.9volto.gr/wp-content/uploads/2019/09/grhgoro-service-smartphone-iphone-peiraias-greece-athina.jpg'),(60,'https://s.nbst.gr/files/1/2014/09/11/vahd13.thumbnail.jpg'),(61,'https://ng-solutions.gr/wp-content/uploads/2017/05/episkeui-1-820x400.jpg'),(62,'https://datasync.gr/wp-content/uploads/2019/06/datasync-repair-4.jpg'),(63,'https://www.9volto.gr/wp-content/uploads/2019/09/service-smartphone-iphone-samsung-ti-na-prosexw.jpg'),(64,'https://i.ibb.co/t4c6PZS/user1.jpg'),(65,'https://i.ibb.co/C8mq4JT/companydefault.jpg'),(66,'https://i.ibb.co/fkrv0DQ/userdefault.jpg'),(67,'https://i.ibb.co/ZhvcMf0/product1.jpg'),(68,'https://i.ibb.co/zQV6LKB/product2.jpg'),(69,'https://i.ibb.co/K2rkcrD/gardeningservices1.jpg');
/*!40000 ALTER TABLE `image_url` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-19 22:09:32
