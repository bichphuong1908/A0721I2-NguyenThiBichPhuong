-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: cs_module3
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `attach_service`
--

DROP TABLE IF EXISTS `attach_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attach_service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attach_service`
--

LOCK TABLES `attach_service` WRITE;
/*!40000 ALTER TABLE `attach_service` DISABLE KEYS */;
INSERT INTO `attach_service` VALUES (1,'laundry',3,'kg','new'),(2,'ciname',2,'ticket','on'),(3,'taxi',1,'km','off'),(4,'gym',2,'hour','on'),(5,'massage',8,'ticket','on');
/*!40000 ALTER TABLE `attach_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `down_payment` double DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_employee1_idx` (`employee_id`),
  KEY `fk_contract_customer1_idx` (`customer_id`),
  KEY `fk_contract_service1_idx` (`service_id`),
  CONSTRAINT `fk_contract_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_contract_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_contract_service1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `contract_id` int DEFAULT NULL,
  `attach_service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_detail_attach_service1_idx` (`attach_service_id`),
  KEY `fk_contract_detail_contract1_idx` (`contract_id`),
  CONSTRAINT `fk_contract_detail_attach_service1` FOREIGN KEY (`attach_service_id`) REFERENCES `attach_service` (`id`),
  CONSTRAINT `fk_contract_detail_contract1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `identify_number` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `customer_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_customer_type1_idx` (`customer_type_id`),
  CONSTRAINT `fk_customer_customer_type1` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Winston Van der Son','1973-01-25',_binary '','51625-002','150-638-9355','wvang@merriam-webster.com','1533 Kim Drive',1),(2,'Chevy Stanaway','1981-07-14',_binary '\0','51625-002','172-626-0746','cstanawayh@multiply.com','9 Meadow Ridge Parkway',1),(3,'Nolan Pflieger','1994-10-23',_binary '','51625-002','316-568-2767','npfliegeri@artisteer.com','8 Straubel Alley',5),(4,'Blanche Bonnyson','1997-10-05',_binary '','51625-002','312-274-1325','bbonnysonj@harvard.edu','9 Longview Crossing',3),(5,'Scott Penburton','1997-07-30',_binary '\0','51625-002','646-810-1655','spenburtonk@imageshack.us','02056 Spaight Way',1),(6,'Vinson Hunting','2005-08-08',_binary '','51625-002','457-893-9840','vhuntingl@123-reg.co.uk','27 Twin Pines Way',2),(7,'Gabriellia Lepick','1980-03-18',_binary '\0','51625-002','493-593-5681','glepickm@microsoft.com','28429 Independence Parkway',2),(8,'Vaughn Olivey','1959-01-25',_binary '','971-529-2866','493-593-5681','voliveyn@walmart.com','72 Doe Crossing Crossing',3),(9,'Elaine Oxton','1960-03-25',_binary '','143-972-2973','493-593-5681','eoxtono@nymag.com','3 Hagan Hill',5),(10,'Stephanus Gibbieson','1962-03-25',_binary '','51625-002','456-807-4184','sgibbiesonp@mlb.com','02676 Drewry Lane',5),(11,'Hendrika Peare','1989-04-14',_binary '','51625-002','408-404-2547','hpeareq@dagondesign.com','20074 Melrose Way',4),(12,'Torin Sellors','2000-08-18',_binary '\0','51625-002','504-394-9756','tsellorsr@symantec.com','717 Hoard Pass',3),(13,'Gisella Legan','1965-07-20',_binary '\0','51625-002','103-386-8874','glegans@feedburner.com','885 Judy Street',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Diamond'),(2,'Gold'),(3,'Silver'),(4,'Member'),(5,'Retail');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degree`
--

DROP TABLE IF EXISTS `degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree`
--

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` VALUES (1,'Undergraduate'),(2,'Master'),(3,'DOCTER'),(4,'PROFESSOR'),(5,'College'),(6,'University'),(7,'Bacherlor'),(8,'Associate');
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Marketing'),(2,'Legal'),(3,'Human Resources'),(4,'Legal'),(5,'Sales'),(6,'Training');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `identify_number` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `degree_id` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_position_idx` (`position_id`),
  KEY `fk_employee_degree1_idx` (`degree_id`),
  KEY `fk_employee_department1_idx` (`department_id`),
  CONSTRAINT `fk_employee_degree1` FOREIGN KEY (`degree_id`) REFERENCES `degree` (`id`),
  CONSTRAINT `fk_employee_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_employee_position` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Sandy Pashan','1961-01-15','37000-727','1163.08','663-959-9605','spashan0@bandcamp.com','5 Roth Road',6,5,4),(2,'Philipa Kennerley','1954-11-14','48951-1178','1313.71','587-113-9816','pkennerley1@sourceforge.net','5 Union Pass',5,1,3),(3,'Mahalia Bigland','1961-04-03','0406-9959','2347.75','369-457-9519','mbigland2@harvard.edu','922 Gateway Alley',6,6,6),(4,'Quillan Rewcastle','1988-08-18','53157-300','3124.24','941-396-9009','qrewcastle3@unc.edu','734 John Wall Terrace',5,4,5),(5,'Joella Skilbeck','1968-09-15','61314-225','1061.98','847-249-3629','jskilbeck4@ox.ac.uk','577 Everett Park',2,2,1),(6,'Evangelin Grayshan','1984-05-31','51334-882','2107.3','253-637-2071','egrayshan5@reuters.com','2 Union Place',4,1,3),(7,'Mavis Mattiuzzi','1995-06-03','54868-0520','2948.05','851-771-0858','mmattiuzzi6@acquirethisname.com','77 Kensington Trail',5,5,4),(8,'Virgilio Jaze','1979-12-15','64764-253','3895.07','597-347-4065','vjaze7@ftc.gov','22 4th Point',6,5,2),(9,'Annabela Pitherick','1950-12-01','36987-1190','2880.58','528-905-6627','apitherick8@ed.gov','0 Lighthouse Bay Junction',3,2,2),(10,'Rickert Freshwater','1992-06-16','36987-2899','2300.7','271-319-5402','rfreshwater9@biglobe.ne.jp','73 Clemons Avenue',3,6,6),(11,'Trisha Coton','1968-11-15','16853-1305','2971.4','914-126-8308','tcotona@scribd.com','04 Del Mar Circle',4,4,5),(12,'Wat Eckersall','1980-06-02','0268-0153','1313.17','713-338-8129','weckersallb@4shared.com','302 Manitowish Avenue',6,6,6),(13,'Gabi Tidman','1994-05-13','0615-2525','3253.19','324-999-3543','gtidmanc@goo.gl','85165 Eagan Hill',4,1,6),(14,'Constantin Treadway','1952-01-22','43857-0101','2344.88','586-507-1116','ctreadwayd@webs.com','5448 Graedel Hill',3,4,1),(15,'Amalie Linfitt','1964-12-26','10237-629','2191.54','640-545-4045','alinfitte@tumblr.com','6400 Mifflin Parkway',5,1,3),(16,'Leola Halward','1987-03-08','49999-895','2572.72','410-710-1004','lhalwardf@miibeian.gov.cn','681 Dexter Parkway',6,4,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Manager Employee'),(2,'Database Administrator'),(3,'Registered receptionist'),(4,'Structural Analysis Engineer'),(5,'Budget/Accounting Analyst'),(6,'Environmental Specialist'),(7,'Attendant'),(8,'Supervisor'),(9,'security'),(10,'HR'),(11,'Sales'),(12,'Director'),(13,'Chef');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,'Day'),(2,'Month'),(3,'Year'),(4,'Hour');
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `area` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `max_people` int DEFAULT NULL,
  `standar_room` varchar(45) DEFAULT NULL,
  `description_other_convinience` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pool_area` int DEFAULT NULL,
  `floor_number` int DEFAULT NULL,
  `rent_type_id` int DEFAULT NULL,
  `service_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_service_rent_type1_idx` (`rent_type_id`),
  KEY `fk_service_service_type1_idx` (`service_type_id`),
  CONSTRAINT `fk_service_rent_type1` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`id`),
  CONSTRAINT `fk_service_service_type1` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Villa Sweet',23,120,10,'other','no comment',12,5,1,1),(2,'Villa Couple',2,120,10,'other','no comment',12,5,2,1),(3,'Villa Family',6,120,10,'other','no comment',12,5,3,1),(4,'Villa Standard',8,120,10,'other','no comment',12,5,4,1),(5,'House Sweet',23,120,10,'other','no comment',12,5,1,2),(6,'House Couple',23,120,10,'other','no comment',12,5,2,2),(7,'House Family',23,120,10,'other','no comment',12,5,3,2),(8,'House Standard',23,120,10,'other','no comment',12,5,4,2),(9,'Room Sweet',23,120,10,'other','no comment',NULL,5,1,3),(10,'Room Couple',23,120,10,'other','no comment',NULL,5,2,3),(11,'Room Family',23,120,10,'other','no comment',NULL,5,3,3),(12,'Room Standard',23,120,10,'other','no comment',NULL,5,4,3);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'Villa'),(2,'House'),(3,'Room');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 19:04:01
