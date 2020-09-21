CREATE DATABASE  IF NOT EXISTS `service-user` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `service-user`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: service-user
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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_email` varchar(255) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('me@gmail.com','2020-09-21 19:17:27.713000','e10adc3949ba59abbe56e057f20f883e','2020-09-21 19:17:27.713000','Fernando Lima'),('me2@gmail.com','2020-09-21 19:17:39.463000','e10adc3949ba59abbe56e057f20f883e','2020-09-21 19:17:39.463000','Joao Pereira'),('me3@gmail.com','2020-09-21 19:18:03.511000','e10adc3949ba59abbe56e057f20f883e','2020-09-21 19:18:03.511000','Maria Lucia');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'service-user'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-21 19:15:47
CREATE DATABASE  IF NOT EXISTS `service-movie` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `service-movie`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: service-movie
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
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `director_name` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES ('05de22d0-9963-4f61-826f-c1c8d8ba06b6','2020-09-21 20:59:41.493000','Jon Favreau','2020-09-21 20:59:41.493000'),('39a64cd0-8e2c-4f42-9d4f-5ce21d6e7c68','2020-09-21 21:58:04.041000','Shane Black','2020-09-21 21:58:04.041000'),('878a8207-3338-46c0-8bc3-3944979c5c7d','2020-09-21 20:27:02.134000','Lucas P','2020-09-21 20:27:02.134000');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `movie_title` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `director_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbi47w3cnsfi30gc1nu2avgra2` (`director_id`),
  CONSTRAINT `FKbi47w3cnsfi30gc1nu2avgra2` FOREIGN KEY (`director_id`) REFERENCES `director` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('0037cac2-4cd9-4152-afa9-0a2b31958eb9','2020-09-21 20:27:02.180000','Iron Man','2020-09-21 20:27:02.180000','878a8207-3338-46c0-8bc3-3944979c5c7d'),('6a527f56-a359-47db-b650-85d52e305757','2020-09-21 21:58:04.071000','Iron Man 3','2020-09-21 21:58:04.071000','39a64cd0-8e2c-4f42-9d4f-5ce21d6e7c68'),('8d872299-fe4e-4725-9c91-fd2123505b2b','2020-09-21 21:04:35.857000','Iron Man 2','2020-09-21 21:04:35.857000','05de22d0-9963-4f61-826f-c1c8d8ba06b6');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_rental`
--

DROP TABLE IF EXISTS `movie_rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_rental` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `user_email` varchar(255) NOT NULL,
  `movie_stock_id` varchar(36) NOT NULL,
  `rental_status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5krf4mh9ms22gwq9lbl17jfl2` (`movie_stock_id`),
  CONSTRAINT `FK5krf4mh9ms22gwq9lbl17jfl2` FOREIGN KEY (`movie_stock_id`) REFERENCES `movie_stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_rental`
--

LOCK TABLES `movie_rental` WRITE;
/*!40000 ALTER TABLE `movie_rental` DISABLE KEYS */;
INSERT INTO `movie_rental` VALUES ('10092857-b9db-4af3-bd7d-6e834df03d69','2020-09-21 21:35:09.394000','2020-09-21 21:52:52.426000','me@gmail.com','8ac4e7b3-5def-44f5-8932-1d0b2759f6b1','RETURNED');
/*!40000 ALTER TABLE `movie_rental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_stock`
--

DROP TABLE IF EXISTS `movie_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_stock` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `movie_total_amount` bigint DEFAULT NULL,
  `movie_total_available` bigint DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `movie_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhg5c9sgem6uowg1uwtto5fj9b` (`movie_id`),
  CONSTRAINT `FKhg5c9sgem6uowg1uwtto5fj9b` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_stock`
--

LOCK TABLES `movie_stock` WRITE;
/*!40000 ALTER TABLE `movie_stock` DISABLE KEYS */;
INSERT INTO `movie_stock` VALUES ('8ac4e7b3-5def-44f5-8932-1d0b2759f6b1','2020-09-21 20:29:28.631000',6,6,'2020-09-21 21:52:52.452000','0037cac2-4cd9-4152-afa9-0a2b31958eb9'),('94942bc3-2bb9-41fb-8420-2d3dbe202bfc','2020-09-21 21:12:22.632000',15,15,'2020-09-21 21:12:22.632000','8d872299-fe4e-4725-9c91-fd2123505b2b'),('ce5f2177-a534-4e53-b2ba-67e60ab4acac','2020-09-21 21:59:23.967000',20,20,'2020-09-21 21:59:23.967000','6a527f56-a359-47db-b650-85d52e305757');
/*!40000 ALTER TABLE `movie_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'service-movie'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-21 19:15:48
