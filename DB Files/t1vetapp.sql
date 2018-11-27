CREATE DATABASE  IF NOT EXISTS `t1vetapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `t1vetapp`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: t1vetapp
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `appointments` (
  `appointment_id` int(11) NOT NULL AUTO_INCREMENT,
  `appointment_type` varchar(60) NOT NULL,
  `pet_id` int(11) DEFAULT NULL,
  `date` varchar(60) NOT NULL,
  `time` varchar(60) NOT NULL,
  `pet_name` varchar(60) NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `fk_appointments_pets_idx` (`pet_id`),
  CONSTRAINT `fk_appointments_pets` FOREIGN KEY (`pet_id`) REFERENCES `pets` (`pet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,'Medical',1,'02-15-2019','17:00','Polly',''),(2,'Grooming',2,'03-20-2019','16:00','Fluffy',''),(3,'Medical',3,'04-16-2019','15:00','Dot',' ');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boarding`
--

DROP TABLE IF EXISTS `boarding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `boarding` (
  `boarding_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `appointment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`boarding_id`),
  KEY `fk_boarding_appointments_idx` (`appointment_id`),
  CONSTRAINT `fk_boarding_appointments` FOREIGN KEY (`appointment_id`) REFERENCES `appointments` (`appointment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boarding`
--

LOCK TABLES `boarding` WRITE;
/*!40000 ALTER TABLE `boarding` DISABLE KEYS */;
/*!40000 ALTER TABLE `boarding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medications`
--

DROP TABLE IF EXISTS `medications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medications` (
  `med_id` int(11) NOT NULL AUTO_INCREMENT,
  `med_name` varchar(60) NOT NULL,
  `med_renewal` varchar(60) DEFAULT NULL,
  `med_dosage` int(11) NOT NULL,
  `pet_id` int(11) DEFAULT NULL,
  `med_type` varchar(60) NOT NULL,
  PRIMARY KEY (`med_id`),
  KEY `fk_medications_pets_idx` (`pet_id`),
  CONSTRAINT `fk_medications_pets` FOREIGN KEY (`pet_id`) REFERENCES `pets` (`pet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medications`
--

LOCK TABLES `medications` WRITE;
/*!40000 ALTER TABLE `medications` DISABLE KEYS */;
/*!40000 ALTER TABLE `medications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) DEFAULT NULL,
  `subject` varchar(60) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `fk_messages_owners_idx` (`owner_id`),
  CONSTRAINT `fk_messages_owners` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `owner` (
  `owner_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `phone_number` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'Sally','Baker','678-454-3291','sbaker65@test.com','sbaker65','test76'),(2,'Michael','Smith','404-757-8921','msmith43@test.com','msmith43','text59'),(3,'Alice','Lee','678-513-7492','alicelee51@test.com','alee51','treat45');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pets`
--

DROP TABLE IF EXISTS `pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pets` (
  `pet_id` int(11) NOT NULL AUTO_INCREMENT,
  `pet_name` varchar(60) NOT NULL,
  `pet_age` int(11) DEFAULT NULL,
  `pet_type` varchar(60) NOT NULL,
  `pet_breed` varchar(60) NOT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `pet_weight` int(11) DEFAULT NULL,
  `pet_owner` varchar(60) NOT NULL,
  PRIMARY KEY (`pet_id`),
  KEY `fk_pets_owners_idx` (`owner_id`),
  CONSTRAINT `fk_pets_owners` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets`
--

LOCK TABLES `pets` WRITE;
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` VALUES (1,'Polly',2,'dog','Corgi',1,5,'Sally Baker'),(2,'Fluffy',3,'cat','Calico',1,4,'Sally Baker'),(3,'Chip',4,'fish','Goldfish',2,1,'Michael Smith'),(4,'Dot',1,'dog','Dachshund',2,3,'Michael Smith'),(5,'Donny',5,'snake','Python',3,2,'Alice Lee');
/*!40000 ALTER TABLE `pets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-27 15:16:25
