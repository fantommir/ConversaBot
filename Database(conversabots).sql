-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: conversabots
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `ACCOUNTID` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) NOT NULL,
  `MAILID` varchar(255) DEFAULT NULL,
  `PHONE` bigint NOT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `DEFAULTPAYMENT` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ACCOUNTID`),
  UNIQUE KEY `MAILID` (`MAILID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Deo John','deo@example.com',987654321,'deo@123','Cash on Delivery'),(2,'Jane Doe','jane@example.com',9876543210,'jane@987','Cash on Delivery'),(3,'Alice Smith','alice@example.com',5555555555,'alice@555','upi'),(4,'Bob Smith','bob@example.com',1112223333,'bob@111','Card'),(5,'Emma Johnson','emma@example.com',9998887777,'emma@99','upi'),(9,'Sayyad','sayyad@gmail.com',9119402147,'sayyad12',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carddetails`
--

DROP TABLE IF EXISTS `carddetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carddetails` (
  `CARDID` int NOT NULL AUTO_INCREMENT,
  `CARDNAME` varchar(255) DEFAULT NULL,
  `CARDNUMBER` varchar(16) DEFAULT NULL,
  `expirydate` varchar(255) DEFAULT NULL,
  `CARDPIN` int NOT NULL,
  `ACCOUNTID` int NOT NULL,
  `methodname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CARDID`),
  KEY `ACCOUNTID` (`ACCOUNTID`),
  CONSTRAINT `carddetails_ibfk_1` FOREIGN KEY (`ACCOUNTID`) REFERENCES `account` (`ACCOUNTID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carddetails`
--

LOCK TABLES `carddetails` WRITE;
/*!40000 ALTER TABLE `carddetails` DISABLE KEYS */;
INSERT INTO `carddetails` VALUES (1,'Credit card','1234567812345678','2026-12-31',1111,1,NULL),(2,'Credit card','9876543210987654','2025-06-30',4444,2,NULL),(3,'Debit card','4567812345678123','2026-12-31',9876,3,NULL),(4,'Debit card','3210987654987654','2025-08-26',27,4,NULL),(5,'Credit card','2210987654987644','2025-10-16',5555,5,NULL);
/*!40000 ALTER TABLE `carddetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashback`
--

DROP TABLE IF EXISTS `cashback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashback` (
  `CASHBACKID` int NOT NULL,
  `CASHBACKAMOUNT` double NOT NULL,
  `cashbackdate` varchar(255) DEFAULT NULL,
  `CASHBACKSTATUS` varchar(255) NOT NULL,
  `ACCOUNTID` int NOT NULL,
  `PRODUCTID` int NOT NULL,
  PRIMARY KEY (`CASHBACKID`),
  KEY `ACCOUNTID` (`ACCOUNTID`),
  KEY `PRODUCTID` (`PRODUCTID`),
  CONSTRAINT `cashback_ibfk_1` FOREIGN KEY (`ACCOUNTID`) REFERENCES `account` (`ACCOUNTID`),
  CONSTRAINT `cashback_ibfk_2` FOREIGN KEY (`PRODUCTID`) REFERENCES `product` (`PRODUCTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashback`
--

LOCK TABLES `cashback` WRITE;
/*!40000 ALTER TABLE `cashback` DISABLE KEYS */;
INSERT INTO `cashback` VALUES (1,40,'2024-04-01','Credited',1,101),(2,30,'2024-04-02','Pending',2,201),(3,5,'2024-03-31','Credited',3,301),(4,20,'2024-04-02','Processing',4,401),(5,15,'2024-04-23','Credited',5,501),(11,80,'2024-04-01','Credited',1,102),(12,50,'2024-04-02','Pending',2,202),(13,15,'2024-03-31','Credited',3,302),(14,60,'2024-04-02','Processing',4,402),(15,500,'2024-04-25','Credited',5,502),(23,35,'2024-03-31','Credited',3,303),(25,60,'2024-04-02','Processing',5,503);
/*!40000 ALTER TABLE `cashback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `ORDERID` int NOT NULL,
  `orderdate` varchar(255) DEFAULT NULL,
  `ORDERADDRESS` varchar(255) NOT NULL,
  `ORDERPRICE` double NOT NULL,
  `QUANTITY` int NOT NULL,
  `TOTALPRICE` double NOT NULL,
  `STATUS` varchar(255) NOT NULL,
  `deliverydate` varchar(255) DEFAULT NULL,
  `ACCOUNTID` int NOT NULL,
  `PRODUCTID` int NOT NULL,
  `productname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ORDERID`),
  KEY `ACCOUNTID` (`ACCOUNTID`),
  KEY `PRODUCTID` (`PRODUCTID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`ACCOUNTID`) REFERENCES `account` (`ACCOUNTID`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`PRODUCTID`) REFERENCES `product` (`PRODUCTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2024-04-01','123 Main St',800,1,800,'Delivered','2024-04-03',1,101,NULL),(2,'2024-04-02','456 Elm St',600,1,600,'Shipped',NULL,2,201,NULL),(3,'2024-03-31','789 Oak St',50,2,100,'Delivered','2024-04-02',3,301,NULL),(4,'2024-04-02','101 Pine St',400,1,400,'Processing',NULL,4,401,NULL),(5,'2024-04-11','789 Oak St',200,3,600,'Delivered','2024-04-23',5,501,NULL),(11,'2024-04-01','123 Main St',8000,1,8000,'Delivered','2024-04-03',1,102,NULL),(12,'2024-04-02','456 Elm St',60000,1,60000,'Shipped',NULL,2,202,NULL),(13,'2024-03-31','789 Oak St',1500,2,3000,'Delivered','2024-04-02',3,302,NULL),(14,'2024-04-02','101 Pine St',400,1,400,'Processing',NULL,4,402,NULL),(15,'2024-04-16','565 Oak St',50000,2,100000,'Delivered','2024-04-25',5,502,NULL),(23,'2024-03-31','789 Oak St',50000,2,100000,'Delivered','2024-04-02',3,303,NULL),(25,'2024-04-02','101 Pine St',500,1,500,'Processing',NULL,5,503,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `TRANSACTIONID` int NOT NULL,
  `PINCODE` int NOT NULL,
  `PAYMENTID` varchar(255) NOT NULL,
  `ACCOUNTNUMBER` bigint NOT NULL,
  `paymentdate` varchar(255) DEFAULT NULL,
  `PAYMENTMETHOD` varchar(255) NOT NULL,
  `PAYMENTSTATUS` varchar(255) NOT NULL,
  `PAYMENTAMOUNT` double NOT NULL,
  `PIN` int NOT NULL,
  `ACCOUNTID` int NOT NULL,
  `ORDERID` int NOT NULL,
  PRIMARY KEY (`TRANSACTIONID`),
  KEY `ACCOUNTID` (`ACCOUNTID`),
  KEY `ORDERID` (`ORDERID`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`ACCOUNTID`) REFERENCES `account` (`ACCOUNTID`),
  CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`ORDERID`) REFERENCES `orders` (`ORDERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,12345,'PAY001',123456789012,'2024-04-01','Card','Completed',800,101,1,1),(2,54321,'PAY002',987654321098,'2024-04-02','Cash on Delivery','Pending',600,202,2,2),(3,13579,'PAY003',1357924680,'2024-03-31','upi','Completed',100,303,3,3),(4,24680,'PAY004',2468013579,'2024-04-02','Card','Processing',400,404,4,4),(5,568941,'PAY005',5139246780,'2024-04-23','upi','Completed',600,3030,5,5),(11,227013,'PAY011',321456789012,'2024-04-01','Card','Completed',8000,1010,1,1),(12,54581,'PAY012',876954321098,'2024-04-02','Cash on Delivery','Pending',6000,2020,2,2),(13,508206,'PAY013',5713924680,'2024-03-31','upi','Completed',3000,3030,3,3),(14,112205,'PAY014',6825013579,'2024-04-02','Card','Processing',400,4040,4,4),(15,225016,'PAY015',3924680591,'2024-04-25','upi','Completed',100000,3003,5,5),(23,508206,'PAY023',5713924680,'2024-03-31','upi','Completed',100000,3003,3,3),(25,559873,'PAY025',8250135794,'2024-04-02','Card','Processing',500,4040,5,5);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `PRODUCTID` int NOT NULL,
  `PRODUCTNAME` varchar(255) NOT NULL,
  `productprice` double DEFAULT NULL,
  `ACCOUNTID` int NOT NULL,
  PRIMARY KEY (`PRODUCTID`),
  KEY `ACCOUNTID` (`ACCOUNTID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`ACCOUNTID`) REFERENCES `account` (`ACCOUNTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (101,'Laptop',800,1),(102,'Smartphone',8000,1),(201,'Smartphone',600,2),(202,'Laptop',60000,2),(301,'Headphones',50,3),(302,'SmartWatch',1500,3),(303,'Laptop',50000,3),(401,'Camera',400,4),(402,'Headphones',400,4),(501,'Goggles',200,5),(502,'Tv',50000,5),(503,'Speakers',500,5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upidetails`
--

DROP TABLE IF EXISTS `upidetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `upidetails` (
  `UPIID` int NOT NULL AUTO_INCREMENT,
  `UPINAME` varchar(255) DEFAULT NULL,
  `UPIIDENTIFIER` varchar(255) DEFAULT NULL,
  `REGISTEREDMOBILE` varchar(15) DEFAULT NULL,
  `UPIPIN` int NOT NULL,
  `ACCOUNTID` int NOT NULL,
  PRIMARY KEY (`UPIID`),
  KEY `ACCOUNTID` (`ACCOUNTID`),
  CONSTRAINT `upidetails_ibfk_1` FOREIGN KEY (`ACCOUNTID`) REFERENCES `account` (`ACCOUNTID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upidetails`
--

LOCK TABLES `upidetails` WRITE;
/*!40000 ALTER TABLE `upidetails` DISABLE KEYS */;
INSERT INTO `upidetails` VALUES (1,'John','John.smith@bank','8856543210',3322,1),(2,'Jane','Jane.smith@bank','9987654321',3322,2),(3,'Alice','alice.smith@bank','9876543210',3322,3),(4,'Bob','Bob.smith@bank','8765432105',3322,4),(5,'Emma','emma.johnson@bank','7894561230',5544,5);
/*!40000 ALTER TABLE `upidetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-18 23:48:48
