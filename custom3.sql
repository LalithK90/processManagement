-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: May 22, 2021 at 08:32 PM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `custom3`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `live_dead` varchar(255) DEFAULT NULL,
  `main_category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `live_dead`, `main_category`, `name`) VALUES
(1, 'ACTIVE', 'PT', 'KEELS'),
(2, 'ACTIVE', 'PT', 'CARGILLS'),
(3, 'ACTIVE', 'PT', 'ELEPHANT HOUSE'),
(4, 'ACTIVE', 'BR', 'COCA COLA'),
(5, 'ACTIVE', 'BR', 'FANTA'),
(6, 'ACTIVE', 'BR', 'PEPSI'),
(7, 'ACTIVE', 'BR', 'HIGHLAND'),
(8, 'ACTIVE', 'BR', 'DAILY'),
(9, 'ACTIVE', 'CF', 'CAPTAIN'),
(10, 'ACTIVE', 'CF', 'DIAMOND'),
(11, 'ACTIVE', 'CF', 'GRAND ASIA'),
(12, 'ACTIVE', 'CF', 'PEACOCK'),
(13, 'ACTIVE', 'CI', 'RITZBURY'),
(14, 'ACTIVE', 'CI', 'EDNA'),
(15, 'ACTIVE', 'CI', 'KANDOS'),
(16, 'ACTIVE', 'CI', 'ALPHENLIBE'),
(17, 'ACTIVE', 'RP', 'ARALIYA'),
(18, 'ACTIVE', 'RP', 'HIRU'),
(19, 'ACTIVE', 'RP', 'RATHNA'),
(20, 'ACTIVE', 'CS', 'VIJAYA'),
(21, 'ACTIVE', 'CS', 'RUHUNU'),
(22, 'ACTIVE', 'CS', 'FREELAN'),
(23, 'ACTIVE', 'MF', 'BAIRAHA'),
(24, 'ACTIVE', 'MF', 'PUSSELLAWA'),
(25, 'ACTIVE', 'MF', 'CRYSBRO'),
(26, 'ACTIVE', 'MF', 'NELNA'),
(27, 'ACTIVE', 'PT', 'MEEGAMU'),
(28, 'ACTIVE', 'MF', 'PALIYAGODA EGG CENTRE'),
(29, 'ACTIVE', 'OF', 'FORTUNE'),
(30, 'ACTIVE', 'OF', 'MARINA'),
(31, 'ACTIVE', 'OF', 'N-JOY'),
(32, 'ACTIVE', 'OF', 'PRIMA'),
(33, 'ACTIVE', 'VF', 'SUNIL VEGETABLES AND FRUITS'),
(34, 'ACTIVE', 'VF', 'UPCOUNTRY FRUITS AND VEGETABLES '),
(35, 'ACTIVE', 'MP', 'ANCHOR'),
(36, 'ACTIVE', 'MP', 'RATHTHI'),
(37, 'ACTIVE', 'MP', 'MALIBAN'),
(38, 'ACTIVE', 'MP', 'BONLAC'),
(39, 'ACTIVE', 'MP', 'LUXSPRAY'),
(40, 'ACTIVE', 'DP', 'RICHLIFE'),
(41, 'ACTIVE', 'DP', 'KOTMALE'),
(42, 'ACTIVE', 'DP', 'DAILY'),
(43, 'ACTIVE', 'DP', 'HIGHLAND'),
(44, 'ACTIVE', 'BP', 'BABY CHERAMY'),
(45, 'ACTIVE', 'BP', 'PEARS'),
(46, 'ACTIVE', 'BP', 'PANDA BABY'),
(47, 'ACTIVE', 'BP', 'KHOMBA BABY'),
(48, 'ACTIVE', 'PC', 'DETTOL'),
(49, 'ACTIVE', 'PC', 'BRITTOL'),
(50, 'ACTIVE', 'PC', 'HICARE'),
(51, 'ACTIVE', 'PC', 'DREAMRON'),
(52, 'ACTIVE', 'PC', 'PANTENE'),
(53, 'ACTIVE', 'PC', 'DOVE'),
(54, 'ACTIVE', 'PC', 'REXONA'),
(55, 'ACTIVE', 'PC', 'BLACKNIGHT'),
(56, 'ACTIVE', 'PC', 'CLOGARD'),
(57, 'ACTIVE', 'PC', 'SIGNAL'),
(58, 'ACTIVE', 'HH', 'HIT'),
(59, 'ACTIVE', 'HH', 'GOODKNIGHT'),
(60, 'ACTIVE', 'HH', 'MORTIEN'),
(61, 'ACTIVE', 'HH', 'DASH'),
(62, 'ACTIVE', 'HH', 'AURA'),
(63, 'ACTIVE', 'HH', 'ORANGE'),
(64, 'ACTIVE', 'HH', 'HARPIC'),
(65, 'ACTIVE', 'HH', 'FLORA'),
(66, 'ACTIVE', 'HH', 'COMFORT'),
(67, 'ACTIVE', 'HH', 'LYSOL'),
(68, 'ACTIVE', 'BC', 'NESTLE'),
(69, 'ACTIVE', 'BC', 'KELLOGS'),
(70, 'ACTIVE', 'GI', 'UPCOUNTRY GOURMETS'),
(71, 'ACTIVE', 'DI', 'MOTHA'),
(72, 'ACTIVE', 'DI', 'MD PRODUCTS'),
(73, 'ACTIVE', 'DI', 'KVC '),
(74, 'ACTIVE', 'DI', 'MAGNA'),
(75, 'ACTIVE', 'SF', 'GLOBAL'),
(76, 'ACTIVE', 'SF', 'MINISTRY OF CRABS'),
(77, 'ACTIVE', 'PF', 'ELITE'),
(78, 'ACTIVE', 'MF', 'OTHER');

-- --------------------------------------------------------

--
-- Table structure for table `chandler`
--

DROP TABLE IF EXISTS `chandler`;
CREATE TABLE IF NOT EXISTS `chandler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `brn` varchar(255) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `contact_one` varchar(10) DEFAULT NULL,
  `contact_two` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `live_dead` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hpp3yeewh5nmirnd02hpirv3v` (`code`),
  UNIQUE KEY `UK_3sxj9qldkihut3fds2qs5ngyp` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `chandler`
--

INSERT INTO `chandler` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `address`, `brn`, `code`, `contact_one`, `contact_two`, `email`, `live_dead`, `name`) VALUES
(1, '2021-05-13 17:24:44.913490', 'admin', '2021-05-13 17:24:44.913490', 'admin', '23, Galle Road, Kolpity ', '4684864', 'SLCC210000', '0716548565', '0776654852', 'innterocean@gmail.com', 'ACTIVE', 'Interocean'),
(2, '2021-05-13 17:25:59.727137', 'admin', '2021-05-13 17:25:59.727137', 'admin', '34, Lotus Street, Bambalapitiya  ', '7657587', 'SLCC210001', '0118656554', '0775621458', 'oceaneeds@gmail.com', 'ACTIVE', 'Oceaneeds PLC'),
(3, '2021-05-13 18:03:01.903073', 'admin', '2021-05-13 18:03:01.903073', 'admin', '34, Malwatte Road, Pitakotuwa', '7689842', 'SLCC210002', '0118656554', '0776653096', 'crescentlankaplc@gamil.com', 'ACTIVE', 'Crescent Lanka PLC'),
(4, '2021-05-13 18:05:55.926484', 'admin', '2021-05-13 18:05:55.926484', 'admin', '5/2, Lotus Street, Hettiyawatte', '3553646', 'SLCC210003', '0719547895', '0776653096', 'oceanwaveplc@gmail.com', 'ACTIVE', 'Oceanwave PLC'),
(5, '2021-05-13 18:07:33.458393', 'admin', '2021-05-13 18:07:33.458393', 'admin', '11/2, BOC Street, Colombo 3 ', '5353258', 'SLCC210004', '0115468464', '0775621458', 'oceancombine@gmail.com', 'ACTIVE', 'Ocean Combine PLC'),
(6, '2021-05-13 18:10:35.373854', 'admin', '2021-05-13 18:10:35.373854', 'admin', 'No.41/3,Nawam Mawatha, Colombo 02', '2878646', 'SLCC210005', '0115468464', '0776654852', 'hslanka@gmail.com', 'ACTIVE', 'HSLanka PLC'),
(7, '2021-05-13 18:14:58.205935', 'admin', '2021-05-13 18:14:58.205935', 'admin', '284, Vauxhall Street Colombo 02', '6434355', 'SLCC210006', '0719547895', '0775621458', 'trigon@gmail.com', 'ACTIVE', 'Trigon PLC'),
(8, '2021-05-13 18:17:15.261351', 'admin', '2021-05-13 18:17:15.261351', 'admin', '3/12 Liberty Plaza Colombo 03', '3546546', 'SLCC210007', '0118656554', '0776653096', 'hansamarine@gmail.com', 'ACTIVE', 'Air Inn Hansa Marine PLC'),
(9, '2021-05-13 18:33:54.463749', 'admin', '2021-05-13 18:33:54.463749', 'admin', '159 Pickarings Rd Colombo 13', '4646365', 'SLCC210008', '0719547895', '0776654852', 'seavistaent@gmail.com', 'ACTIVE', 'Sea Vista Enterprises'),
(10, '2021-05-13 18:35:35.446633', 'admin', '2021-05-21 00:42:59.871514', 'admin', '48/1, Ward Place, Colombo - 07', '6464353', 'SLCC210009', '0118656554', '0776654852', 'intoceanofz@gmail.com', 'ACTIVE', 'Penguin PLC');

-- --------------------------------------------------------

--
-- Table structure for table `chandler_license`
--

DROP TABLE IF EXISTS `chandler_license`;
CREATE TABLE IF NOT EXISTS `chandler_license` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `end_date` date DEFAULT NULL,
  `license_status` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `chandler_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_n8veqoqyxte2o60tnebx10jqd` (`number`),
  KEY `FKaxhkbuqrs02tgql9mo3brj78e` (`chandler_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `chandler_license`
--

INSERT INTO `chandler_license` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `end_date`, `license_status`, `number`, `start_date`, `chandler_id`) VALUES
(1, '2021-05-13 18:36:18.271968', 'admin', '2021-05-13 18:41:41.276083', 'admin', '2021-12-13', 'VALID', 'SLCC210000', '2021-05-13', 1),
(2, '2021-05-13 18:37:26.100678', 'admin', '2021-05-13 18:41:47.161505', 'admin', '2021-12-14', 'VALID', 'SLCC210001', '2021-05-14', 2),
(3, '2021-05-13 18:37:45.678913', 'admin', '2021-05-13 18:41:52.192142', 'admin', '2021-12-15', 'VALID', 'SLCC210002', '2021-05-15', 3),
(4, '2021-05-13 18:38:03.448329', 'admin', '2021-05-16 00:00:00.084559', 'admin', '2021-05-16', 'INVALID', 'SLCC210003', '2021-05-16', 4),
(5, '2021-05-13 18:38:19.694414', 'admin', '2021-05-13 18:42:04.145277', 'admin', '2021-05-17', 'VALID', 'SLCC210004', '2021-05-17', 5),
(6, '2021-05-13 18:38:41.101703', 'admin', '2021-05-13 18:42:11.438213', 'admin', '2021-12-18', 'VALID', 'SLCC210005', '2021-05-18', 6),
(7, '2021-05-13 18:39:02.560239', 'admin', '2021-05-19 00:00:00.462366', 'admin', '2021-05-19', 'INVALID', 'SLCC210006', '2021-05-19', 7),
(8, '2021-05-13 18:40:26.118079', 'admin', '2021-05-20 00:00:00.264684', 'admin', '2021-05-20', 'INVALID', 'SLCC210007', '2021-05-20', 8),
(9, '2021-05-13 18:41:03.976386', 'admin', '2021-05-21 00:00:00.371010', 'admin', '2021-05-21', 'INVALID', 'SLCC210008', '2021-05-21', 9),
(10, '2021-05-13 18:41:18.883143', 'admin', '2021-05-22 00:00:00.268758', 'admin', '2021-05-22', 'INVALID', 'SLCC210009', '2021-05-22', 10),
(11, '2021-05-16 00:03:21.515010', 'asuperintendent1', '2021-05-16 00:04:00.988984', 'asuperintendent1', '2021-12-16', 'VALID', 'SLCC210010', '2021-05-16', 4);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `item_status` varchar(255) DEFAULT NULL,
  `live_dead` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6cgogdarkq48dlg1lbnv4q1oq` (`code`),
  KEY `FK2n9w8d0dp4bsfra9dcg0046l4` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `code`, `item_status`, `live_dead`, `name`, `category_id`) VALUES
(1, '2021-05-14 00:14:00.407186', 'guard1', '2021-05-14 00:14:00.407186', 'guard1', 'IT210000', 'NOT_AVAILABLE', 'ACTIVE', 'Chicken Sausages 500 g', 1),
(2, '2021-05-14 00:14:08.964485', 'guard1', '2021-05-14 00:14:08.964485', 'guard1', 'IT210001', 'NOT_AVAILABLE', 'ACTIVE', 'Chicken Sausages 500 g', 2),
(3, '2021-05-14 00:14:17.480268', 'guard1', '2021-05-14 00:14:17.480268', 'guard1', 'IT210002', 'NOT_AVAILABLE', 'ACTIVE', 'Chicken Sausages 500 g', 3),
(4, '2021-05-14 00:14:54.806804', 'guard1', '2021-05-14 00:14:54.806804', 'guard1', 'IT210003', 'NOT_AVAILABLE', 'ACTIVE', 'Chicken Sausages 1kg', 1),
(5, '2021-05-14 00:15:14.076205', 'guard1', '2021-05-14 00:15:14.076205', 'guard1', 'IT210004', 'NOT_AVAILABLE', 'ACTIVE', 'Chicken Sausages 1kg', 2),
(6, '2021-05-14 00:15:23.351499', 'guard1', '2021-05-14 00:15:23.351499', 'guard1', 'IT210005', 'NOT_AVAILABLE', 'ACTIVE', 'Chicken Sausages 1kg', 3),
(7, '2021-05-14 00:15:52.826123', 'guard1', '2021-05-14 00:15:52.826123', 'guard1', 'IT210006', 'NOT_AVAILABLE', 'ACTIVE', 'Baken 500g', 1),
(8, '2021-05-14 00:16:01.807611', 'guard1', '2021-05-14 00:16:01.807611', 'guard1', 'IT210007', 'NOT_AVAILABLE', 'ACTIVE', 'Baken 500g', 2),
(9, '2021-05-14 00:16:10.039745', 'guard1', '2021-05-14 00:16:10.039745', 'guard1', 'IT210008', 'NOT_AVAILABLE', 'ACTIVE', 'Baken 500g', 3),
(10, '2021-05-14 00:19:28.945631', 'guard1', '2021-05-14 00:19:28.945631', 'guard1', 'IT210009', 'NOT_AVAILABLE', 'ACTIVE', 'Cheese and Onion sausages 250 g', 1),
(11, '2021-05-14 00:19:39.107076', 'guard1', '2021-05-14 00:19:39.107076', 'guard1', 'IT210010', 'NOT_AVAILABLE', 'ACTIVE', 'Cheese and Onion sausages 250 g', 2),
(12, '2021-05-14 21:33:41.433243', 'guard1', '2021-05-14 21:33:41.433243', 'guard1', 'IT210011', 'NOT_AVAILABLE', 'ACTIVE', '1L bottle', 6),
(13, '2021-05-14 21:38:10.170715', 'guard1', '2021-05-14 21:38:10.170715', 'guard1', 'IT210012', 'NOT_AVAILABLE', 'ACTIVE', '500ml bottle', 5),
(14, '2021-05-15 01:46:52.157947', 'guard1', '2021-05-15 01:46:52.157947', 'guard1', 'IT210013', 'NOT_AVAILABLE', 'ACTIVE', '1.5L bottle', 4),
(15, '2021-05-15 01:47:00.930593', 'guard1', '2021-05-15 01:47:00.930593', 'guard1', 'IT210014', 'NOT_AVAILABLE', 'ACTIVE', '1.5L bottle', 5),
(16, '2021-05-15 01:47:11.565851', 'guard1', '2021-05-15 01:47:11.565851', 'guard1', 'IT210015', 'NOT_AVAILABLE', 'ACTIVE', '1.5L bottle', 6),
(17, '2021-05-15 01:48:09.488248', 'guard1', '2021-05-15 01:48:09.488248', 'guard1', 'IT210016', 'NOT_AVAILABLE', 'ACTIVE', '500ml bottle	', 4),
(18, '2021-05-15 01:48:20.364353', 'guard1', '2021-05-15 01:48:20.364353', 'guard1', 'IT210017', 'NOT_AVAILABLE', 'ACTIVE', '500ml bottle	', 6),
(19, '2021-05-15 01:49:05.491858', 'guard1', '2021-05-15 01:49:05.491858', 'guard1', 'IT210018', 'NOT_AVAILABLE', 'ACTIVE', '1L bottle', 4),
(20, '2021-05-15 01:49:17.115075', 'guard1', '2021-05-15 01:49:17.115075', 'guard1', 'IT210019', 'NOT_AVAILABLE', 'ACTIVE', '1L bottle', 5),
(21, '2021-05-15 01:50:02.210272', 'guard1', '2021-05-15 01:50:02.210272', 'guard1', 'IT210020', 'NOT_AVAILABLE', 'ACTIVE', '300ml', 7),
(22, '2021-05-15 01:50:12.208487', 'guard1', '2021-05-15 01:50:12.208487', 'guard1', 'IT210021', 'NOT_AVAILABLE', 'ACTIVE', '300ml', 8),
(23, '2021-05-15 01:50:26.302485', 'guard1', '2021-05-15 01:50:26.302485', 'guard1', 'IT210022', 'NOT_AVAILABLE', 'ACTIVE', '100ml', 7),
(24, '2021-05-15 01:50:35.020910', 'guard1', '2021-05-15 01:50:35.020910', 'guard1', 'IT210023', 'NOT_AVAILABLE', 'ACTIVE', '100ml', 8),
(25, '2021-05-15 01:51:42.919796', 'guard1', '2021-05-15 01:51:42.919796', 'guard1', 'IT210024', 'NOT_AVAILABLE', 'ACTIVE', 'fish 425g', 9),
(26, '2021-05-15 01:51:53.140808', 'guard1', '2021-05-15 01:51:53.140808', 'guard1', 'IT210025', 'NOT_AVAILABLE', 'ACTIVE', 'fish 425g', 10),
(27, '2021-05-15 01:52:02.519182', 'guard1', '2021-05-15 01:52:02.519182', 'guard1', 'IT210026', 'NOT_AVAILABLE', 'ACTIVE', 'fish 425g', 12),
(28, '2021-05-15 01:54:20.061868', 'guard1', '2021-05-15 01:54:20.061868', 'guard1', 'IT210027', 'NOT_AVAILABLE', 'ACTIVE', 'fish 500g ', 10),
(29, '2021-05-15 01:55:33.716994', 'guard1', '2021-05-15 01:55:33.716994', 'guard1', 'IT210028', 'NOT_AVAILABLE', 'ACTIVE', 'Sliced Mango 500g', 11),
(30, '2021-05-15 01:55:56.853535', 'guard1', '2021-05-15 01:55:56.853535', 'guard1', 'IT210029', 'NOT_AVAILABLE', 'ACTIVE', 'Dates 500g', 12),
(31, '2021-05-15 01:56:21.061250', 'guard1', '2021-05-15 01:56:21.061250', 'guard1', 'IT210030', 'NOT_AVAILABLE', 'ACTIVE', 'Black Olives 450g', 12),
(32, '2021-05-15 01:57:17.296264', 'guard1', '2021-05-15 01:57:17.296264', 'guard1', 'IT210031', 'NOT_AVAILABLE', 'ACTIVE', 'Natural Green Olives 500g', 11),
(33, '2021-05-15 01:57:44.166192', 'guard1', '2021-05-15 01:57:44.166192', 'guard1', 'IT210032', 'NOT_AVAILABLE', 'ACTIVE', 'Peaches in Syrup 500g', 10),
(34, '2021-05-15 01:58:43.856232', 'guard1', '2021-05-15 01:58:43.856232', 'guard1', 'IT210033', 'NOT_AVAILABLE', 'ACTIVE', 'Tomato Puree 400g', 11),
(35, '2021-05-15 01:59:16.186058', 'guard1', '2021-05-15 01:59:16.186058', 'guard1', 'IT210034', 'NOT_AVAILABLE', 'ACTIVE', 'Sliced Pineapple 400g', 12),
(36, '2021-05-15 02:00:05.420227', 'guard1', '2021-05-15 02:00:05.420227', 'guard1', 'IT210035', 'NOT_AVAILABLE', 'ACTIVE', 'Tuna in Sunflower Oil 300g', 9),
(37, '2021-05-15 02:01:24.518898', 'guard1', '2021-05-15 02:01:24.518898', 'guard1', 'IT210036', 'NOT_AVAILABLE', 'ACTIVE', 'Minced beef with onion 500g', 10),
(38, '2021-05-15 02:01:55.673183', 'guard1', '2021-05-15 02:01:55.673183', 'guard1', 'IT210037', 'NOT_AVAILABLE', 'ACTIVE', 'Corned Beef 500g', 10),
(39, '2021-05-15 02:02:30.102537', 'guard1', '2021-05-15 02:02:30.102537', 'guard1', 'IT210038', 'NOT_AVAILABLE', 'ACTIVE', 'Chicken meatballs in gravy 500g', 11),
(40, '2021-05-15 02:03:13.195456', 'guard1', '2021-05-15 02:03:13.195456', 'guard1', 'IT210039', 'NOT_AVAILABLE', 'ACTIVE', 'Sliced Mushroom 500g', 12),
(41, '2021-05-15 02:04:24.056878', 'guard1', '2021-05-15 02:04:24.056878', 'guard1', 'IT210040', 'NOT_AVAILABLE', 'ACTIVE', 'Crikle Cut Beetroot (670g) ', 11),
(42, '2021-05-15 02:05:20.969278', 'guard1', '2021-05-15 02:05:20.969278', 'guard1', 'IT210041', 'NOT_AVAILABLE', 'ACTIVE', ' Revello Milk 170g', 13),
(43, '2021-05-15 02:05:40.916655', 'guard1', '2021-05-15 02:05:40.916655', 'guard1', 'IT210042', 'NOT_AVAILABLE', 'ACTIVE', ' Peanut Chocolate 100g', 13),
(44, '2021-05-15 02:06:03.102062', 'guard1', '2021-05-15 02:06:03.102062', 'guard1', 'IT210043', 'NOT_AVAILABLE', 'ACTIVE', 'Revello Cashew 170g', 13),
(45, '2021-05-15 02:06:22.399082', 'guard1', '2021-05-15 02:06:22.399082', 'guard1', 'IT210044', 'NOT_AVAILABLE', 'ACTIVE', 'Revello Almond 170g', 13),
(46, '2021-05-15 02:06:39.763486', 'guard1', '2021-05-15 02:06:39.763486', 'guard1', 'IT210045', 'NOT_AVAILABLE', 'ACTIVE', 'Revello Crispy 100g', 13),
(47, '2021-05-15 02:08:06.829758', 'guard1', '2021-05-15 02:08:06.829758', 'guard1', 'IT210046', 'NOT_AVAILABLE', 'ACTIVE', ' Choc ‘n nut (100g)', 14),
(48, '2021-05-15 02:09:06.516783', 'guard1', '2021-05-15 02:09:06.516783', 'guard1', 'IT210047', 'NOT_AVAILABLE', 'ACTIVE', 'Chocky Fruit(15g)', 14),
(49, '2021-05-15 02:09:39.239300', 'guard1', '2021-05-15 02:09:39.239300', 'guard1', 'IT210048', 'NOT_AVAILABLE', 'ACTIVE', 'Wafer Chox (6g)', 14),
(50, '2021-05-15 02:10:02.932849', 'guard1', '2021-05-15 02:10:02.932849', 'guard1', 'IT210049', 'NOT_AVAILABLE', 'ACTIVE', 'Golden Nuggets(140g)', 14),
(51, '2021-05-15 02:10:25.872221', 'guard1', '2021-05-15 02:10:25.872221', 'guard1', 'IT210050', 'NOT_AVAILABLE', 'ACTIVE', 'Dreams(100g)', 14),
(52, '2021-05-15 02:10:54.540451', 'guard1', '2021-05-15 02:10:54.540451', 'guard1', 'IT210051', 'NOT_AVAILABLE', 'ACTIVE', 'Bunty Choco(Paper Carton 100Pcs', 14),
(53, '2021-05-15 02:11:20.614073', 'guard1', '2021-05-15 02:11:20.614073', 'guard1', 'IT210052', 'NOT_AVAILABLE', 'ACTIVE', 'Cooking Chocolate(1kg)', 14),
(54, '2021-05-15 02:11:56.457891', 'guard1', '2021-05-15 02:11:56.457891', 'guard1', 'IT210053', 'NOT_AVAILABLE', 'ACTIVE', 'Crunchy Crispy(90g)', 14),
(55, '2021-05-15 02:12:23.860105', 'guard1', '2021-05-15 02:12:23.860105', 'guard1', 'IT210054', 'NOT_AVAILABLE', 'ACTIVE', 'Dark(100g)', 14),
(56, '2021-05-15 02:12:55.654676', 'guard1', '2021-05-15 02:12:55.654676', 'guard1', 'IT210055', 'NOT_AVAILABLE', 'ACTIVE', 'Giselle (170g)', 14),
(57, '2021-05-15 02:13:53.734418', 'guard1', '2021-05-15 02:13:53.734418', 'guard1', 'IT210056', 'NOT_AVAILABLE', 'ACTIVE', 'Bar Cashewnut 45g.', 15),
(58, '2021-05-15 02:14:10.395078', 'guard1', '2021-05-15 02:14:10.395078', 'guard1', 'IT210057', 'NOT_AVAILABLE', 'ACTIVE', 'Bar Caramel Cream 45g', 15),
(59, '2021-05-15 02:14:29.360602', 'guard1', '2021-05-15 02:14:29.360602', 'guard1', 'IT210058', 'NOT_AVAILABLE', 'ACTIVE', 'Bar Crackerjack 45g', 15),
(60, '2021-05-15 02:14:51.332961', 'guard1', '2021-05-15 02:14:51.332961', 'guard1', 'IT210059', 'NOT_AVAILABLE', 'ACTIVE', 'Bar White Cream 45g', 15),
(61, '2021-05-15 02:16:09.451269', 'guard1', '2021-05-15 02:16:09.451269', 'guard1', 'IT210060', 'NOT_AVAILABLE', 'ACTIVE', 'Juzt Jelly Straw berry 200 Pcs Jar ', 16),
(62, '2021-05-15 02:16:39.751897', 'guard1', '2021-05-15 02:16:39.751897', 'guard1', 'IT210061', 'NOT_AVAILABLE', 'ACTIVE', 'Creamfills Assorted 405G', 16),
(63, '2021-05-15 02:17:37.718803', 'guard1', '2021-05-15 02:17:37.718803', 'guard1', 'IT210062', 'NOT_AVAILABLE', 'ACTIVE', 'Center Shock Chewing Gum – 110 Pcs', 16),
(64, '2021-05-15 02:17:56.678404', 'guard1', '2021-05-15 02:17:56.678404', 'guard1', 'IT210063', 'NOT_AVAILABLE', 'ACTIVE', '10kg ', 17),
(65, '2021-05-15 02:18:07.045962', 'guard1', '2021-05-15 02:18:07.045962', 'guard1', 'IT210064', 'NOT_AVAILABLE', 'ACTIVE', '20kg ', 17),
(66, '2021-05-15 02:18:16.135558', 'guard1', '2021-05-15 02:18:16.135558', 'guard1', 'IT210065', 'NOT_AVAILABLE', 'ACTIVE', '50kg ', 17),
(67, '2021-05-15 02:18:30.060567', 'guard1', '2021-05-15 02:18:30.060567', 'guard1', 'IT210066', 'NOT_AVAILABLE', 'ACTIVE', '10kg ', 18),
(68, '2021-05-15 02:18:42.444419', 'guard1', '2021-05-15 02:18:42.444419', 'guard1', 'IT210067', 'NOT_AVAILABLE', 'ACTIVE', '20kg ', 18),
(69, '2021-05-15 02:18:57.461755', 'guard1', '2021-05-15 02:18:57.461755', 'guard1', 'IT210068', 'NOT_AVAILABLE', 'ACTIVE', '50kg ', 18),
(70, '2021-05-15 02:19:09.039143', 'guard1', '2021-05-15 02:19:09.039143', 'guard1', 'IT210069', 'NOT_AVAILABLE', 'ACTIVE', '10kg ', 19),
(71, '2021-05-15 02:19:18.924115', 'guard1', '2021-05-15 02:19:18.924115', 'guard1', 'IT210070', 'NOT_AVAILABLE', 'ACTIVE', '20kg ', 19),
(72, '2021-05-15 02:19:29.329173', 'guard1', '2021-05-15 02:19:29.329173', 'guard1', 'IT210071', 'NOT_AVAILABLE', 'ACTIVE', '50kg ', 19),
(73, '2021-05-15 02:20:35.306003', 'guard1', '2021-05-15 02:20:35.306003', 'guard1', 'IT210072', 'NOT_AVAILABLE', 'ACTIVE', 'Chilli Powder 100g', 20),
(74, '2021-05-15 02:20:50.322426', 'guard1', '2021-05-15 02:20:50.322426', 'guard1', 'IT210073', 'NOT_AVAILABLE', 'ACTIVE', 'Chilli Powder 100g', 21),
(75, '2021-05-15 02:20:59.212848', 'guard1', '2021-05-15 02:20:59.212848', 'guard1', 'IT210074', 'NOT_AVAILABLE', 'ACTIVE', 'Chilli Powder 100g', 22),
(76, '2021-05-15 02:21:28.623622', 'guard1', '2021-05-15 02:21:28.623622', 'guard1', 'IT210075', 'NOT_AVAILABLE', 'ACTIVE', 'Chilli Pieces 100g', 20),
(77, '2021-05-15 02:21:38.239913', 'guard1', '2021-05-15 02:21:38.239913', 'guard1', 'IT210076', 'NOT_AVAILABLE', 'ACTIVE', 'Chilli Pieces 100g', 21),
(78, '2021-05-15 02:21:47.023201', 'guard1', '2021-05-15 02:21:47.023201', 'guard1', 'IT210077', 'NOT_AVAILABLE', 'ACTIVE', 'Chilli Pieces 100g', 22),
(79, '2021-05-15 02:22:12.004150', 'guard1', '2021-05-15 02:22:12.004150', 'guard1', 'IT210078', 'NOT_AVAILABLE', 'ACTIVE', 'Turmeric Powder 100g', 20),
(80, '2021-05-15 02:22:20.555602', 'guard1', '2021-05-15 02:22:20.555602', 'guard1', 'IT210079', 'NOT_AVAILABLE', 'ACTIVE', 'Turmeric Powder 100g', 21),
(81, '2021-05-15 02:22:28.909823', 'guard1', '2021-05-15 02:22:28.909823', 'guard1', 'IT210080', 'NOT_AVAILABLE', 'ACTIVE', 'Turmeric Powder 100g', 22),
(82, '2021-05-15 02:22:49.390612', 'guard1', '2021-05-15 02:22:49.390612', 'guard1', 'IT210081', 'NOT_AVAILABLE', 'ACTIVE', 'Pepper Powder 100g', 20),
(83, '2021-05-15 02:22:57.886538', 'guard1', '2021-05-15 02:22:57.886538', 'guard1', 'IT210082', 'NOT_AVAILABLE', 'ACTIVE', 'Pepper Powder 100g', 21),
(84, '2021-05-15 02:23:06.834864', 'guard1', '2021-05-15 02:23:06.834864', 'guard1', 'IT210083', 'NOT_AVAILABLE', 'ACTIVE', 'Pepper Powder 100g', 22),
(85, '2021-05-15 02:23:26.650335', 'guard1', '2021-05-15 02:23:26.650335', 'guard1', 'IT210084', 'NOT_AVAILABLE', 'ACTIVE', 'Cummin Powder 100g', 20),
(86, '2021-05-15 02:23:34.256198', 'guard1', '2021-05-15 02:23:34.256198', 'guard1', 'IT210085', 'NOT_AVAILABLE', 'ACTIVE', 'Cummin Powder 100g', 21),
(87, '2021-05-15 02:23:43.187497', 'guard1', '2021-05-15 02:23:43.187497', 'guard1', 'IT210086', 'NOT_AVAILABLE', 'ACTIVE', 'Cummin Powder 100g', 22),
(88, '2021-05-15 02:24:05.027898', 'guard1', '2021-05-15 02:24:05.027898', 'guard1', 'IT210087', 'NOT_AVAILABLE', 'ACTIVE', 'Curry Powder 100g', 20),
(89, '2021-05-15 02:24:13.216210', 'guard1', '2021-05-15 02:24:13.216210', 'guard1', 'IT210088', 'NOT_AVAILABLE', 'ACTIVE', 'Curry Powder 100g', 21),
(90, '2021-05-15 02:24:21.364441', 'guard1', '2021-05-15 02:24:21.364441', 'guard1', 'IT210089', 'NOT_AVAILABLE', 'ACTIVE', 'Curry Powder 100g', 22),
(91, '2021-05-15 02:25:02.674769', 'guard1', '2021-05-15 02:25:02.674769', 'guard1', 'IT210090', 'NOT_AVAILABLE', 'ACTIVE', 'Milky Fish Curry Powder 100g', 20),
(92, '2021-05-15 02:25:11.131768', 'guard1', '2021-05-15 02:25:11.131768', 'guard1', 'IT210091', 'NOT_AVAILABLE', 'ACTIVE', 'Milky Fish Curry Powder 100g', 21),
(93, '2021-05-15 02:25:18.903986', 'guard1', '2021-05-15 02:25:18.903986', 'guard1', 'IT210092', 'NOT_AVAILABLE', 'ACTIVE', 'Milky Fish Curry Powder 100g', 22),
(94, '2021-05-15 02:25:47.745340', 'guard1', '2021-05-15 02:25:47.745340', 'guard1', 'IT210093', 'NOT_AVAILABLE', 'ACTIVE', 'Whole Chicken 1kg', 23),
(95, '2021-05-15 02:25:56.411530', 'guard1', '2021-05-15 02:25:56.411530', 'guard1', 'IT210094', 'NOT_AVAILABLE', 'ACTIVE', 'Whole Chicken 1kg', 24),
(96, '2021-05-15 02:26:06.154410', 'guard1', '2021-05-15 02:26:06.154410', 'guard1', 'IT210095', 'NOT_AVAILABLE', 'ACTIVE', 'Whole Chicken 1kg', 25),
(97, '2021-05-15 02:26:15.181546', 'guard1', '2021-05-15 02:26:15.181546', 'guard1', 'IT210096', 'NOT_AVAILABLE', 'ACTIVE', 'Whole Chicken 1kg', 26),
(98, '2021-05-15 02:26:38.522119', 'guard1', '2021-05-15 02:26:38.522119', 'guard1', 'IT210097', 'NOT_AVAILABLE', 'ACTIVE', 'Pork 1kg', 23),
(99, '2021-05-15 02:26:52.692451', 'guard1', '2021-05-15 02:26:52.692451', 'guard1', 'IT210098', 'NOT_AVAILABLE', 'ACTIVE', 'Pork 1kg', 24),
(100, '2021-05-15 02:27:02.844267', 'guard1', '2021-05-15 02:27:02.844267', 'guard1', 'IT210099', 'NOT_AVAILABLE', 'ACTIVE', 'Pork 1kg', 25),
(101, '2021-05-15 02:27:11.779327', 'guard1', '2021-05-15 02:27:11.779327', 'guard1', 'IT210100', 'NOT_AVAILABLE', 'ACTIVE', 'Pork 1kg', 26),
(102, '2021-05-15 02:27:23.783916', 'guard1', '2021-05-15 02:27:23.783916', 'guard1', 'IT210101', 'NOT_AVAILABLE', 'ACTIVE', 'Beef 1kg', 23),
(103, '2021-05-15 02:27:38.664117', 'guard1', '2021-05-15 02:27:38.664117', 'guard1', 'IT210102', 'NOT_AVAILABLE', 'ACTIVE', 'Beef 1kg', 24),
(104, '2021-05-15 02:27:48.355061', 'guard1', '2021-05-15 02:27:48.355061', 'guard1', 'IT210103', 'NOT_AVAILABLE', 'ACTIVE', 'Beef 1kg', 25),
(105, '2021-05-15 02:27:57.891453', 'guard1', '2021-05-15 02:27:57.891453', 'guard1', 'IT210104', 'NOT_AVAILABLE', 'ACTIVE', 'Beef 1kg', 26),
(106, '2021-05-15 02:28:25.112286', 'guard1', '2021-05-15 02:28:25.112286', 'guard1', 'IT210105', 'NOT_AVAILABLE', 'ACTIVE', 'Eggs 12 pcs', 28),
(107, '2021-05-15 02:28:42.073018', 'guard1', '2021-05-15 02:28:42.073018', 'guard1', 'IT210106', 'NOT_AVAILABLE', 'ACTIVE', 'Mutton 1kg', 23),
(108, '2021-05-15 02:28:49.689803', 'guard1', '2021-05-15 02:28:49.689803', 'guard1', 'IT210107', 'NOT_AVAILABLE', 'ACTIVE', 'Mutton 1kg', 24),
(109, '2021-05-15 02:28:57.494127', 'guard1', '2021-05-15 02:28:57.494127', 'guard1', 'IT210108', 'NOT_AVAILABLE', 'ACTIVE', 'Mutton 1kg', 25),
(110, '2021-05-15 02:29:05.504892', 'guard1', '2021-05-15 02:29:05.504892', 'guard1', 'IT210109', 'NOT_AVAILABLE', 'ACTIVE', 'Mutton 1kg', 26),
(111, '2021-05-15 02:30:27.689344', 'guard1', '2021-05-15 02:30:27.689344', 'guard1', 'IT210110', 'NOT_AVAILABLE', 'ACTIVE', 'CALAMARI RINGS 1kg', 24),
(112, '2021-05-15 02:30:49.678668', 'guard1', '2021-05-15 02:30:49.678668', 'guard1', 'IT210111', 'NOT_AVAILABLE', 'ACTIVE', 'CRAB CLEANED WITH SHELL 1kg', 28),
(113, '2021-05-15 02:32:03.213230', 'guard1', '2021-05-15 02:32:03.213230', 'guard1', 'IT210112', 'NOT_AVAILABLE', 'ACTIVE', 'SAILFISH CUBES 1kg', 78),
(114, '2021-05-15 02:32:21.402766', 'guard1', '2021-05-15 02:32:21.402766', 'guard1', 'IT210113', 'NOT_AVAILABLE', 'ACTIVE', 'TUNA STEAK 1kg', 78),
(115, '2021-05-15 02:32:39.898677', 'guard1', '2021-05-15 02:32:39.898677', 'guard1', 'IT210114', 'NOT_AVAILABLE', 'ACTIVE', 'BABY OCTOPUS 1kg', 78),
(116, '2021-05-15 02:32:59.278338', 'guard1', '2021-05-15 02:32:59.278338', 'guard1', 'IT210115', 'NOT_AVAILABLE', 'ACTIVE', 'SEER STEAK 1KG', 78),
(117, '2021-05-15 02:33:14.526431', 'guard1', '2021-05-15 02:33:14.526431', 'guard1', 'IT210116', 'NOT_AVAILABLE', 'ACTIVE', 'Prawns 1kg', 78),
(118, '2021-05-15 02:33:37.857391', 'guard1', '2021-05-15 02:33:37.857391', 'guard1', 'IT210117', 'NOT_AVAILABLE', 'ACTIVE', 'Yellofin Tuna 1kg', 78),
(119, '2021-05-15 02:34:47.594068', 'guard1', '2021-05-15 02:34:47.594068', 'guard1', 'IT210118', 'NOT_AVAILABLE', 'ACTIVE', 'Vegetable Oil 20 Ltr', 29),
(120, '2021-05-15 02:35:00.692292', 'guard1', '2021-05-15 02:35:00.692292', 'guard1', 'IT210119', 'NOT_AVAILABLE', 'ACTIVE', 'Sunflower Oil 20 Ltr', 29),
(121, '2021-05-15 02:35:13.270522', 'guard1', '2021-05-15 02:35:13.270522', 'guard1', 'IT210120', 'NOT_AVAILABLE', 'ACTIVE', 'Coconut Oil 20 Ltr', 29),
(122, '2021-05-15 02:35:28.571101', 'guard1', '2021-05-15 02:35:28.571101', 'guard1', 'IT210121', 'NOT_AVAILABLE', 'ACTIVE', 'Corn Oil 20 Ltr', 29),
(123, '2021-05-15 02:36:58.444511', 'guard1', '2021-05-15 02:36:58.444511', 'guard1', 'IT210122', 'NOT_AVAILABLE', 'ACTIVE', 'Cooking Oil (Physically Refined) 20L', 30),
(124, '2021-05-15 02:37:14.600224', 'guard1', '2021-05-15 02:37:14.600224', 'guard1', 'IT210123', 'NOT_AVAILABLE', 'ACTIVE', 'Sunflower Oil 20 Ltr', 30),
(125, '2021-05-15 02:37:31.212592', 'guard1', '2021-05-15 02:37:31.212592', 'guard1', 'IT210124', 'NOT_AVAILABLE', 'ACTIVE', 'Soya Bean Oil 20L', 30),
(126, '2021-05-15 02:37:54.097762', 'guard1', '2021-05-15 02:37:54.097762', 'guard1', 'IT210125', 'NOT_AVAILABLE', 'ACTIVE', 'Olive Oil 10L', 30),
(127, '2021-05-15 02:39:02.494162', 'guard1', '2021-05-15 02:39:02.494162', 'guard1', 'IT210126', 'NOT_AVAILABLE', 'ACTIVE', 'Coconut Oil, 10litre', 31),
(128, '2021-05-15 02:39:12.678837', 'guard1', '2021-05-15 02:39:12.678837', 'guard1', 'IT210127', 'NOT_AVAILABLE', 'ACTIVE', 'Olive Oil 10L', 31),
(129, '2021-05-15 02:39:35.514398', 'guard1', '2021-05-15 02:39:35.514398', 'guard1', 'IT210128', 'NOT_AVAILABLE', 'ACTIVE', 'Sunflower Oil 20 Ltr', 31),
(130, '2021-05-15 02:39:47.198707', 'guard1', '2021-05-15 02:39:47.198707', 'guard1', 'IT210129', 'NOT_AVAILABLE', 'ACTIVE', 'Coconut Oil 20 Ltr', 32),
(131, '2021-05-15 02:39:57.487173', 'guard1', '2021-05-15 02:39:57.487173', 'guard1', 'IT210130', 'NOT_AVAILABLE', 'ACTIVE', 'Olive Oil 10L', 32),
(132, '2021-05-15 02:40:09.056771', 'guard1', '2021-05-15 02:40:09.056771', 'guard1', 'IT210131', 'NOT_AVAILABLE', 'ACTIVE', 'Sunflower Oil 20 Ltr', 32),
(133, '2021-05-15 02:41:28.792480', 'guard1', '2021-05-15 02:41:28.792480', 'guard1', 'IT210132', 'NOT_AVAILABLE', 'ACTIVE', 'Carrot 1kg', 33),
(134, '2021-05-15 02:41:42.971460', 'guard1', '2021-05-15 02:41:42.971460', 'guard1', 'IT210133', 'NOT_AVAILABLE', 'ACTIVE', 'Carrot 1kg', 34),
(135, '2021-05-15 02:42:01.303295', 'guard1', '2021-05-15 02:42:01.303295', 'guard1', 'IT210134', 'NOT_AVAILABLE', 'ACTIVE', 'Leeks 1kg', 33),
(136, '2021-05-15 02:42:08.758050', 'guard1', '2021-05-15 02:42:08.758050', 'guard1', 'IT210135', 'NOT_AVAILABLE', 'ACTIVE', 'Leeks 1kg', 34),
(137, '2021-05-15 02:44:21.417605', 'guard1', '2021-05-15 02:44:21.417605', 'guard1', 'IT210136', 'NOT_AVAILABLE', 'ACTIVE', 'Cabbage 1kg', 33),
(138, '2021-05-15 02:44:29.186022', 'guard1', '2021-05-15 02:44:29.186022', 'guard1', 'IT210137', 'NOT_AVAILABLE', 'ACTIVE', 'Cabbage 1kg', 34),
(139, '2021-05-15 02:44:45.354687', 'guard1', '2021-05-15 02:44:45.354687', 'guard1', 'IT210138', 'NOT_AVAILABLE', 'ACTIVE', 'Cauliflower 1kg', 33),
(140, '2021-05-15 02:45:00.329844', 'guard1', '2021-05-15 02:45:00.329844', 'guard1', 'IT210139', 'NOT_AVAILABLE', 'ACTIVE', 'Cauliflower 1kg', 34),
(141, '2021-05-15 02:45:19.227732', 'guard1', '2021-05-15 02:45:19.227732', 'guard1', 'IT210140', 'NOT_AVAILABLE', 'ACTIVE', 'Salad Leaves 1kg', 33),
(142, '2021-05-15 02:45:29.823620', 'guard1', '2021-05-15 02:45:29.823620', 'guard1', 'IT210141', 'NOT_AVAILABLE', 'ACTIVE', 'Salad Leaves 1kg', 34),
(143, '2021-05-15 02:45:46.902766', 'guard1', '2021-05-15 02:45:46.902766', 'guard1', 'IT210142', 'NOT_AVAILABLE', 'ACTIVE', 'Beet 1kg', 33),
(144, '2021-05-15 02:45:54.681028', 'guard1', '2021-05-15 02:45:54.681028', 'guard1', 'IT210143', 'NOT_AVAILABLE', 'ACTIVE', 'Beet 1kg', 34),
(145, '2021-05-15 02:46:12.310116', 'guard1', '2021-05-15 02:46:12.310116', 'guard1', 'IT210144', 'NOT_AVAILABLE', 'ACTIVE', 'Beans 1kg', 33),
(146, '2021-05-15 02:46:20.215144', 'guard1', '2021-05-15 02:46:20.215144', 'guard1', 'IT210145', 'NOT_AVAILABLE', 'ACTIVE', 'Beans 1kg', 34),
(147, '2021-05-15 02:46:53.465261', 'guard1', '2021-05-15 02:46:53.465261', 'guard1', 'IT210146', 'NOT_AVAILABLE', 'ACTIVE', 'Bell-pepper 1kg', 33),
(148, '2021-05-15 02:47:07.521877', 'guard1', '2021-05-15 02:47:07.521877', 'guard1', 'IT210147', 'NOT_AVAILABLE', 'ACTIVE', 'Bell-pepper 1kg', 34),
(149, '2021-05-15 02:47:33.744355', 'guard1', '2021-05-15 02:47:33.744355', 'guard1', 'IT210148', 'NOT_AVAILABLE', 'ACTIVE', 'Salad Cucumber 1kg', 33),
(150, '2021-05-15 02:47:42.120886', 'guard1', '2021-05-15 02:47:42.120886', 'guard1', 'IT210149', 'NOT_AVAILABLE', 'ACTIVE', 'Salad Cucumber 1kg', 34),
(151, '2021-05-15 02:47:57.698566', 'guard1', '2021-05-15 02:47:57.698566', 'guard1', 'IT210150', 'NOT_AVAILABLE', 'ACTIVE', 'Gherkins 1kg', 33),
(152, '2021-05-15 02:48:06.740176', 'guard1', '2021-05-15 02:48:06.740176', 'guard1', 'IT210151', 'NOT_AVAILABLE', 'ACTIVE', 'Gherkins 1kg', 34),
(153, '2021-05-15 02:48:36.123616', 'guard1', '2021-05-15 02:48:36.123616', 'guard1', 'IT210152', 'NOT_AVAILABLE', 'ACTIVE', 'Pumpkin 1kg', 33),
(154, '2021-05-15 02:48:54.594622', 'guard1', '2021-05-15 02:48:54.594622', 'guard1', 'IT210153', 'NOT_AVAILABLE', 'ACTIVE', 'Bitter-gourd 1kg', 33),
(155, '2021-05-15 02:49:01.910099', 'guard1', '2021-05-15 02:49:01.910099', 'guard1', 'IT210154', 'NOT_AVAILABLE', 'ACTIVE', 'Bitter-gourd 1kg', 34),
(156, '2021-05-15 02:51:30.102455', 'guard1', '2021-05-15 02:51:30.102455', 'guard1', 'IT210155', 'NOT_AVAILABLE', 'ACTIVE', 'Passion fruit 1kg', 33),
(157, '2021-05-15 02:51:38.634208', 'guard1', '2021-05-15 02:51:38.634208', 'guard1', 'IT210156', 'NOT_AVAILABLE', 'ACTIVE', 'Passion fruit 1kg', 34),
(158, '2021-05-15 02:52:01.529542', 'guard1', '2021-05-15 02:52:01.529542', 'guard1', 'IT210157', 'NOT_AVAILABLE', 'ACTIVE', 'Mango 1kg', 33),
(159, '2021-05-15 02:52:11.817396', 'guard1', '2021-05-15 02:52:11.817396', 'guard1', 'IT210158', 'NOT_AVAILABLE', 'ACTIVE', 'Mango 1kg', 34),
(160, '2021-05-15 02:52:30.873181', 'guard1', '2021-05-15 02:52:30.873181', 'guard1', 'IT210159', 'NOT_AVAILABLE', 'ACTIVE', 'Durian 1kg', 33),
(161, '2021-05-15 02:52:40.796157', 'guard1', '2021-05-15 02:52:40.796157', 'guard1', 'IT210160', 'NOT_AVAILABLE', 'ACTIVE', 'Durian 1kg', 34),
(162, '2021-05-15 02:53:02.746274', 'guard1', '2021-05-15 02:53:02.746274', 'guard1', 'IT210161', 'NOT_AVAILABLE', 'ACTIVE', 'Woodapple 1kg', 33),
(163, '2021-05-15 02:53:11.907801', 'guard1', '2021-05-15 02:53:11.907801', 'guard1', 'IT210162', 'NOT_AVAILABLE', 'ACTIVE', 'Woodapple 1kg', 34),
(164, '2021-05-15 02:53:32.493111', 'guard1', '2021-05-15 02:53:32.493111', 'guard1', 'IT210163', 'NOT_AVAILABLE', 'ACTIVE', 'Rambutan 1kg', 33),
(165, '2021-05-15 02:53:40.134277', 'guard1', '2021-05-15 02:53:40.134277', 'guard1', 'IT210164', 'NOT_AVAILABLE', 'ACTIVE', 'Rambutan 1kg', 34),
(166, '2021-05-15 02:54:15.206438', 'guard1', '2021-05-15 02:54:15.206438', 'guard1', 'IT210165', 'NOT_AVAILABLE', 'ACTIVE', 'Pineapple 1kg', 33),
(167, '2021-05-15 02:54:24.453577', 'guard1', '2021-05-15 02:54:24.453577', 'guard1', 'IT210166', 'NOT_AVAILABLE', 'ACTIVE', 'Pineapple 1kg', 34),
(168, '2021-05-15 02:54:40.330656', 'guard1', '2021-05-15 02:54:40.330656', 'guard1', 'IT210167', 'NOT_AVAILABLE', 'ACTIVE', 'Banana 1kg', 33),
(169, '2021-05-15 02:54:58.099660', 'guard1', '2021-05-15 02:54:58.099660', 'guard1', 'IT210168', 'NOT_AVAILABLE', 'ACTIVE', 'Mangosteen 1kg', 34),
(170, '2021-05-15 02:55:17.518370', 'guard1', '2021-05-15 02:55:17.518370', 'guard1', 'IT210169', 'NOT_AVAILABLE', 'ACTIVE', 'Banana 1kg', 34),
(171, '2021-05-15 02:55:35.715463', 'guard1', '2021-05-15 02:55:35.715463', 'guard1', 'IT210170', 'NOT_AVAILABLE', 'ACTIVE', 'Mangosteen 1kg', 33),
(172, '2021-05-15 02:55:53.455585', 'guard1', '2021-05-15 02:55:53.455585', 'guard1', 'IT210171', 'NOT_AVAILABLE', 'ACTIVE', 'Papaya 1kg', 33),
(173, '2021-05-15 02:56:01.346011', 'guard1', '2021-05-15 02:56:01.346011', 'guard1', 'IT210172', 'NOT_AVAILABLE', 'ACTIVE', 'Papaya 1kg', 34),
(174, '2021-05-15 02:56:23.362911', 'guard1', '2021-05-15 02:56:23.362911', 'guard1', 'IT210173', 'NOT_AVAILABLE', 'ACTIVE', 'Pomegranate 1kg', 33),
(175, '2021-05-15 02:56:36.213995', 'guard1', '2021-05-15 02:56:36.213995', 'guard1', 'IT210174', 'NOT_AVAILABLE', 'ACTIVE', 'Pomegranate 1kg', 34),
(176, '2021-05-15 02:57:17.400966', 'guard1', '2021-05-15 02:57:17.400966', 'guard1', 'IT210175', 'NOT_AVAILABLE', 'ACTIVE', '1kg packet', 35),
(177, '2021-05-15 02:58:28.209261', 'guard1', '2021-05-15 02:58:28.209261', 'guard1', 'IT210176', 'NOT_AVAILABLE', 'ACTIVE', '1kg packet', 36),
(178, '2021-05-15 02:58:38.992832', 'guard1', '2021-05-15 02:58:38.992832', 'guard1', 'IT210177', 'NOT_AVAILABLE', 'ACTIVE', '1kg packet', 37),
(179, '2021-05-15 02:58:48.305982', 'guard1', '2021-05-15 02:58:48.305982', 'guard1', 'IT210178', 'NOT_AVAILABLE', 'ACTIVE', '1kg packet', 38),
(180, '2021-05-15 02:59:01.180140', 'guard1', '2021-05-15 02:59:01.180140', 'guard1', 'IT210179', 'NOT_AVAILABLE', 'ACTIVE', '1kg packet', 39),
(181, '2021-05-15 02:59:24.960599', 'guard1', '2021-05-15 02:59:24.960599', 'guard1', 'IT210180', 'NOT_AVAILABLE', 'ACTIVE', '200 ml packet', 40),
(182, '2021-05-15 02:59:38.101750', 'guard1', '2021-05-15 02:59:38.101750', 'guard1', 'IT210181', 'NOT_AVAILABLE', 'ACTIVE', '200 ml packet', 41),
(183, '2021-05-15 02:59:49.448620', 'guard1', '2021-05-15 02:59:49.448620', 'guard1', 'IT210182', 'NOT_AVAILABLE', 'ACTIVE', '200 ml packet', 42),
(184, '2021-05-15 02:59:57.989864', 'guard1', '2021-05-15 02:59:57.989864', 'guard1', 'IT210183', 'NOT_AVAILABLE', 'ACTIVE', '200 ml packet', 43),
(185, '2021-05-15 03:00:24.109667', 'guard1', '2021-05-15 03:00:24.109667', 'guard1', 'IT210184', 'NOT_AVAILABLE', 'ACTIVE', '1L   ', 40),
(186, '2021-05-15 03:00:33.927649', 'guard1', '2021-05-15 03:00:33.927649', 'guard1', 'IT210185', 'NOT_AVAILABLE', 'ACTIVE', '1L   ', 41),
(187, '2021-05-15 03:00:43.609432', 'guard1', '2021-05-15 03:00:43.609432', 'guard1', 'IT210186', 'NOT_AVAILABLE', 'ACTIVE', '1L   ', 42),
(188, '2021-05-15 03:00:52.644964', 'guard1', '2021-05-15 03:00:52.644964', 'guard1', 'IT210187', 'NOT_AVAILABLE', 'ACTIVE', '1L   ', 43),
(189, '2021-05-15 03:05:27.931080', 'guard1', '2021-05-15 03:05:27.931080', 'guard1', 'IT210188', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Soap 100g', 44),
(190, '2021-05-15 03:05:41.417610', 'guard1', '2021-05-15 03:05:41.417610', 'guard1', 'IT210189', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Soap 100g', 45),
(191, '2021-05-15 03:14:32.879268', 'guard1', '2021-05-15 03:14:32.879268', 'guard1', 'IT210190', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Soap 100g', 46),
(192, '2021-05-15 03:14:43.917102', 'guard1', '2021-05-15 03:14:43.917102', 'guard1', 'IT210191', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Soap 100g', 47),
(193, '2021-05-15 03:16:02.717193', 'guard1', '2021-05-15 03:16:02.717193', 'guard1', 'IT210192', 'NOT_AVAILABLE', 'ACTIVE', 'Shampoo 200ml', 44),
(194, '2021-05-15 03:16:10.748813', 'guard1', '2021-05-15 03:16:10.748813', 'guard1', 'IT210193', 'NOT_AVAILABLE', 'ACTIVE', 'Shampoo 200ml', 45),
(195, '2021-05-15 03:16:18.613654', 'guard1', '2021-05-15 03:16:18.613654', 'guard1', 'IT210194', 'NOT_AVAILABLE', 'ACTIVE', 'Shampoo 200ml', 46),
(196, '2021-05-15 03:16:26.664451', 'guard1', '2021-05-15 03:16:26.664451', 'guard1', 'IT210195', 'NOT_AVAILABLE', 'ACTIVE', 'Shampoo 200ml', 47),
(197, '2021-05-15 03:17:10.168353', 'guard1', '2021-05-15 03:17:10.168353', 'guard1', 'IT210196', 'NOT_AVAILABLE', 'ACTIVE', 'cologne 300ml', 44),
(198, '2021-05-15 03:17:18.860153', 'guard1', '2021-05-15 03:17:18.860153', 'guard1', 'IT210197', 'NOT_AVAILABLE', 'ACTIVE', 'cologne 300ml', 45),
(199, '2021-05-15 03:17:26.795764', 'guard1', '2021-05-15 03:17:26.795764', 'guard1', 'IT210198', 'NOT_AVAILABLE', 'ACTIVE', 'cologne 300ml', 46),
(200, '2021-05-15 03:17:35.531200', 'guard1', '2021-05-15 03:17:35.531200', 'guard1', 'IT210199', 'NOT_AVAILABLE', 'ACTIVE', 'cologne 300ml', 47),
(201, '2021-05-15 03:18:35.904401', 'guard1', '2021-05-15 03:18:35.904401', 'guard1', 'IT210200', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Cream 400ml', 44),
(202, '2021-05-15 03:18:44.073319', 'guard1', '2021-05-15 03:18:44.073319', 'guard1', 'IT210201', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Cream 400ml', 45),
(203, '2021-05-15 03:18:52.594464', 'guard1', '2021-05-15 03:18:52.594464', 'guard1', 'IT210202', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Cream 400ml', 46),
(204, '2021-05-15 03:19:02.967894', 'guard1', '2021-05-15 03:19:02.967894', 'guard1', 'IT210203', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Cream 400ml', 47),
(205, '2021-05-15 03:20:21.432625', 'guard1', '2021-05-15 03:20:21.432625', 'guard1', 'IT210204', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Oil 200ml', 44),
(206, '2021-05-15 03:20:43.455578', 'guard1', '2021-05-15 03:20:43.455578', 'guard1', 'IT210205', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Oil 200ml', 45),
(207, '2021-05-15 03:20:51.618656', 'guard1', '2021-05-15 03:20:51.618656', 'guard1', 'IT210206', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Oil 200ml', 46),
(208, '2021-05-15 03:21:06.316197', 'guard1', '2021-05-15 03:21:06.316197', 'guard1', 'IT210207', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Oil 200ml', 46),
(209, '2021-05-15 03:21:14.808752', 'guard1', '2021-05-15 03:21:14.808752', 'guard1', 'IT210208', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Oil 200ml', 47),
(210, '2021-05-15 03:22:08.805254', 'guard1', '2021-05-15 03:22:08.805254', 'guard1', 'IT210209', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Diapers 24 pcs', 44),
(211, '2021-05-15 03:22:16.325103', 'guard1', '2021-05-15 03:22:16.325103', 'guard1', 'IT210210', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Diapers 24 pcs', 45),
(212, '2021-05-15 03:22:23.676834', 'guard1', '2021-05-15 03:22:23.676834', 'guard1', 'IT210211', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Diapers 24 pcs', 46),
(213, '2021-05-15 03:22:32.542876', 'guard1', '2021-05-15 03:22:32.542876', 'guard1', 'IT210212', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Diapers 24 pcs', 47),
(214, '2021-05-15 03:23:51.263848', 'guard1', '2021-05-15 03:23:51.263848', 'guard1', 'IT210213', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Wet Wipes 70 sheets', 44),
(215, '2021-05-15 03:24:01.645304', 'guard1', '2021-05-15 03:24:01.645304', 'guard1', 'IT210214', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Wet Wipes 70 sheets', 45),
(216, '2021-05-15 03:24:09.874367', 'guard1', '2021-05-15 03:24:09.874367', 'guard1', 'IT210215', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Wet Wipes 70 sheets', 46),
(217, '2021-05-15 03:24:19.739806', 'guard1', '2021-05-15 03:24:19.739806', 'guard1', 'IT210216', 'NOT_AVAILABLE', 'ACTIVE', 'Baby Wet Wipes 70 sheets', 47),
(218, '2021-05-15 03:25:39.885753', 'guard1', '2021-05-15 03:25:39.885753', 'guard1', 'IT210217', 'NOT_AVAILABLE', 'ACTIVE', ' Handwash Pump 125ml', 48),
(219, '2021-05-15 03:26:08.338586', 'guard1', '2021-05-15 03:26:08.338586', 'guard1', 'IT210218', 'NOT_AVAILABLE', 'ACTIVE', 'Germ Protection Hand wash Refill 175 ml', 48),
(220, '2021-05-15 03:26:37.175963', 'guard1', '2021-05-15 03:26:37.175963', 'guard1', 'IT210219', 'NOT_AVAILABLE', 'ACTIVE', 'LIQUID HAND WASH 200 ML', 48),
(221, '2021-05-15 03:28:27.570366', 'guard1', '2021-05-15 03:28:27.570366', 'guard1', 'IT210220', 'NOT_AVAILABLE', 'ACTIVE', 'Antiseptic Liquid 110ml', 48),
(222, '2021-05-15 03:29:43.699218', 'guard1', '2021-05-15 03:29:43.699218', 'guard1', 'IT210221', 'NOT_AVAILABLE', 'ACTIVE', 'ANTIBACTERIAL FABRIC PLASTER 100S', 48),
(223, '2021-05-15 03:30:50.843038', 'guard1', '2021-05-15 03:30:50.843038', 'guard1', 'IT210222', 'NOT_AVAILABLE', 'ACTIVE', 'Hand Sanitizer 4L', 49),
(224, '2021-05-15 03:32:27.036951', 'guard1', '2021-05-15 03:32:27.036951', 'guard1', 'IT210223', 'NOT_AVAILABLE', 'ACTIVE', 'Alkaline Builder 10L', 49),
(225, '2021-05-15 03:33:49.523609', 'guard1', '2021-05-15 03:33:49.523609', 'guard1', 'IT210224', 'NOT_AVAILABLE', 'ACTIVE', 'Fabric Softener 10L', 49),
(226, '2021-05-15 03:34:31.646236', 'guard1', '2021-05-15 03:34:31.646236', 'guard1', 'IT210225', 'NOT_AVAILABLE', 'ACTIVE', 'Air Freshener English Rose 4L', 49),
(227, '2021-05-15 03:35:56.275896', 'guard1', '2021-05-15 03:35:56.275896', 'guard1', 'IT210226', 'NOT_AVAILABLE', 'ACTIVE', ' Hand Sanitizer - 300ml', 50),
(228, '2021-05-15 03:36:53.179936', 'guard1', '2021-05-15 03:36:53.179936', 'guard1', 'IT210227', 'NOT_AVAILABLE', 'ACTIVE', 'Dish Wash - 500ml', 50),
(229, '2021-05-15 03:37:15.199587', 'guard1', '2021-05-15 03:37:15.199587', 'guard1', 'IT210228', 'NOT_AVAILABLE', 'ACTIVE', 'Lime Moisturizing Hand Wash', 50);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `cheque_number` varchar(255) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `live_dead` varchar(255) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status_conformation` varchar(255) DEFAULT NULL,
  `chandler_id` int(11) DEFAULT NULL,
  `vessel_order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_opor0kv54jt58n364jog9bu2i` (`code`),
  UNIQUE KEY `UK_i1uqxyrb8pr5vwb28uykv6bgb` (`cheque_number`),
  KEY `FK16n6xlg9q36nr1gr20xa18fq` (`chandler_id`),
  KEY `FK7im12jxxs7hxtrq76hx0j0xm` (`vessel_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `amount`, `bank_name`, `cheque_number`, `code`, `live_dead`, `payment_method`, `remarks`, `status_conformation`, `chandler_id`, `vessel_order_id`) VALUES
(7, '2021-05-21 00:03:40.110341', 'superintendent1', '2021-05-21 00:03:40.110341', 'superintendent1', '171900.00', NULL, NULL, 'SLCP210000', 'ACTIVE', NULL, NULL, 'INR', 8, 6),
(8, '2021-05-21 00:03:43.168654', 'superintendent1', '2021-05-21 00:03:43.168654', 'superintendent1', '133400.00', NULL, NULL, 'SLCP210001', 'ACTIVE', NULL, NULL, 'INR', 10, 6),
(9, '2021-05-22 00:00:54.097252', 'superintendent1', '2021-05-22 00:34:41.932100', 'guard1', '75000.00', NULL, NULL, 'SLCP210002', 'ACTIVE', NULL, NULL, 'REC', 10, 7),
(10, '2021-05-22 00:00:56.871359', 'superintendent1', '2021-05-22 00:34:36.200456', 'guard1', '50000.00', NULL, NULL, 'SLCP210003', 'ACTIVE', NULL, NULL, 'REC', 8, 7),
(12, '2021-05-23 00:01:03.135903', 'superintendent1', '2021-05-23 00:49:28.884944', 'shipagent1', '50000.00', 'Sampath Bank', '5464668788', 'SLCP210004', 'ACTIVE', NULL, '', 'PAIDSHIPAGENT', 1, 9),
(13, '2021-05-23 00:01:10.416750', 'superintendent1', '2021-05-23 00:44:57.997243', 'shipagent1', '45000.00', 'peoples\' bank', '84346659', 'SLCP210005', 'ACTIVE', NULL, '', 'PAIDSHIPAGENT', 2, 9),
(16, '2021-05-23 00:38:01.708098', 'superintendent1', '2021-05-23 00:38:01.708098', 'superintendent1', '52500.00', NULL, NULL, 'SLCP210006', 'ACTIVE', NULL, NULL, 'INR', 1, 8),
(17, '2021-05-23 00:38:03.892868', 'superintendent1', '2021-05-23 00:38:03.892868', 'superintendent1', '60000.00', NULL, NULL, 'SLCP210007', 'ACTIVE', NULL, NULL, 'INR', 2, 8);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iubw515ff0ugtm28p8g3myt0h` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `role_name`) VALUES
(1, '2021-05-13 15:38:28.197120', 'anonymousUser', '2021-05-13 15:38:28.197120', 'anonymousUser', 'ADMIN'),
(2, '2021-05-13 15:38:28.287442', 'anonymousUser', '2021-05-13 15:38:28.287442', 'anonymousUser', 'SHIP_AGENT'),
(3, '2021-05-13 15:38:28.331858', 'anonymousUser', '2021-05-13 15:38:28.331858', 'anonymousUser', 'CHANDLER'),
(4, '2021-05-13 15:38:28.375815', 'anonymousUser', '2021-05-13 15:38:28.375815', 'anonymousUser', 'INSPECTOR'),
(5, '2021-05-13 15:38:28.398135', 'anonymousUser', '2021-05-13 15:38:28.398135', 'anonymousUser', 'SUPERINTENDENT'),
(6, '2021-05-13 15:38:28.421170', 'anonymousUser', '2021-05-13 15:38:28.421170', 'anonymousUser', 'ASSISTANT_SUPERINTENDENT'),
(7, '2021-05-13 15:38:28.442287', 'anonymousUser', '2021-05-13 15:38:28.442287', 'anonymousUser', 'GUARD');

-- --------------------------------------------------------

--
-- Table structure for table `ship_agent`
--

DROP TABLE IF EXISTS `ship_agent`;
CREATE TABLE IF NOT EXISTS `ship_agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cha_number` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `land` varchar(255) DEFAULT NULL,
  `live_dead` varchar(255) DEFAULT NULL,
  `mobile_one` varchar(10) DEFAULT NULL,
  `mobile_two` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nic` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fynpr4fl9y8tql0hwsu9u1qul` (`cha_number`),
  UNIQUE KEY `UK_fpm1k706g59p5a947u4ggq7yx` (`code`),
  UNIQUE KEY `UK_d7wpopnx5jr4tkhqshna06lo1` (`email`),
  UNIQUE KEY `UK_4i2xad0tcfs95uva0ijtaoeui` (`nic`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ship_agent`
--

INSERT INTO `ship_agent` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `address`, `cha_number`, `code`, `email`, `land`, `live_dead`, `mobile_one`, `mobile_two`, `name`, `nic`) VALUES
(1, '2021-05-13 19:45:09.420535', 'admin', '2021-05-13 19:45:09.420535', 'admin', '8/4, Rose Street, Kolpity', '39879', 'LKCSA210000', 'ksamare@gmail.com', '0114765676', 'ACTIVE', '0716468934', '0786896758', 'Kalpana Samarasinghe', '912243456V'),
(2, '2021-05-13 19:47:06.894022', 'admin', '2021-05-13 20:09:48.034594', 'admin', '23/65, 3rd lane, Yatiyana Road, Kaluaggala', '439188', 'LKCSA210001', 'amarechethana@gmail.com', '0117319002', 'ACTIVE', '0755473658', '0786893856', 'Chethana Amarasinghe', '792665259V'),
(3, '2021-05-13 19:49:15.961522', 'admin', '2021-05-13 19:49:15.961522', 'admin', '21, Puttalam Road, Chilaw', '865461', 'LKCSA210002', 'dimuthsilva@gmail.com', '0117300000', 'ACTIVE', '0716460067', '0786895908', 'Dimuth Silva', '881448463V'),
(4, '2021-05-13 19:51:15.053392', 'admin', '2021-05-13 19:51:15.053392', 'admin', '78/2, Kosinna Road, Ganemulla', '321323', 'LKCSA210003', 'premaratnedanuka@gmail.com', '0115483008', 'ACTIVE', '0716464735', '0778650097', 'Danuka Premarathne', '911565359V'),
(5, '2021-05-13 19:53:04.359209', 'admin', '2021-05-13 19:53:04.359209', 'admin', '25, Puttalam Road, Marawila', '684665', 'LKCSA210004', 'rjayakodi@gmail.com', '0117856832', 'ACTIVE', '0716465082', '0778654007', 'Romesh Jayakody', '913565359V'),
(6, '2021-05-13 19:55:15.598926', 'admin', '2021-05-13 19:55:15.598926', 'admin', '211, WK Perera Streer, Namal Pedesa, Pannipitiya', '3546325', 'LKCSA210005', 'lakshan93@gmail.com', '0115484365', 'ACTIVE', '0781264543', '0786895758', 'Lakshaan Fernando', '935479879V'),
(7, '2021-05-13 19:56:28.279931', 'admin', '2021-05-13 19:56:28.279931', 'admin', '45, Piliyandala Road, Kahathuduwa', '5343646', 'LKCSA210006', 'skarunarathne@gmail.com', '0117346487', 'ACTIVE', '0715464543', '0787795954', 'Samith Karunarathne', '886453365V'),
(8, '2021-05-13 19:58:15.953958', 'admin', '2021-05-13 20:25:48.005966', 'admin', '24, Piliyandala Road, Gonapola  ', '35465', 'LKCSA210007', 'naradajaye@gmail.com', '0117319674', 'ACTIVE', '0716464222', '0711653543', 'Narada Jayasinghe', '883545646V'),
(9, '2021-05-13 19:59:53.636179', 'admin', '2021-05-13 19:59:53.636179', 'admin', '85/2, Kandy Road, Kalagedihena', '364535', 'LKCSA210008', 'sirisenadumith@gmail.com', '0115486064', 'ACTIVE', '0775460519', '0786890068', 'Dumith Sirisena', '923643464V'),
(10, '2021-05-13 20:02:03.538362', 'admin', '2021-05-13 20:32:09.832634', 'admin', '78, Egodawatta,Kelaniya', '5456463', 'LKCSA210009', 'damithwaniga@gmail.com', '0117378587', 'ACTIVE', '0716466747', '0786895665', 'Damith Wanigasekara', '853213353V');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `user_details_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FK3wsl4duq3n5imh005r68f3uar` (`user_details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `enabled`, `password`, `username`, `user_details_id`) VALUES
(1, '2021-05-13 15:38:28.699371', 'anonymousUser', '2021-05-13 15:38:28.699371', 'anonymousUser', b'1', '$2a$10$YkfsTw8T8Gc/JFb8Ds0Myu.XC2.Z3zfLfcPdEIzdYzcXJ3SAb1/oO', 'admin', 1),
(2, '2021-05-13 15:46:04.662914', 'admin', '2021-05-13 15:46:04.662914', 'admin', b'1', '$2a$10$OrhKcOu3HPqqWvF0v0KNDuSqGgTArVW8aO1WXE5MTSEqSEaVhDGoG', 'superintendent1', 2),
(3, '2021-05-13 15:49:59.174176', 'admin', '2021-05-13 15:49:59.174176', 'admin', b'1', '$2a$10$XxgNyEEE1ySfizFqq4ur5.JFuuuELsMa8oDgJEQUe6xApyGbmYimK', 'superintendent2', 3),
(4, '2021-05-13 15:54:17.388302', 'admin', '2021-05-13 15:54:17.388302', 'admin', b'1', '$2a$10$kSCPtv32z6hHd/4u5Br6BOI3RbqWyCcSJylaN/xKEngfGlIVEn2z2', 'asuperintendent1', 4),
(5, '2021-05-13 15:56:56.118559', 'admin', '2021-05-13 15:56:56.118559', 'admin', b'1', '$2a$10$xB33xrHu0ukrl.UYO8bRvumDGn6fi3agsGq4sqOihfv.D41nRh82.', 'asuperintendent2', 5),
(6, '2021-05-13 16:00:46.183289', 'admin', '2021-05-13 16:01:06.815274', 'admin', b'1', '$2a$10$L.WMdd7LihCBCgAFlI/zieKmyVacYAFs5ATBH3L8qp501m4x8RGBK', 'inspector1', 6),
(7, '2021-05-13 16:04:27.955649', 'admin', '2021-05-13 16:04:27.955649', 'admin', b'1', '$2a$10$QE3vb4DgC.zpyaMbMrpRhOPi0nmjFPmyBXU5X1Nkong7qk9XX8FvK', 'inspector2', 7),
(8, '2021-05-13 16:08:00.717959', 'admin', '2021-05-13 16:08:00.717959', 'admin', b'1', '$2a$10$iBgwtZEOrF7/utF7EGRNF.yvGaIgYcO4QGy6r05wO5OmPCMMu5sUO', 'guard1', 8),
(9, '2021-05-13 16:15:02.746563', 'admin', '2021-05-13 16:15:02.746563', 'admin', b'1', '$2a$10$hCTxkeskmG.IRJUZDAqDKusNUoz.tfuzql4PIQ9lh0GKWwLWouHsS', 'guard2', 9),
(10, '2021-05-13 18:53:34.932759', 'admin', '2021-05-13 18:53:34.932759', 'admin', b'1', '$2a$10$CRDwhgLF0lgewnl9sgx1buLQ7.sfP.7eNXlsBcwkPBJemGZz4ae6S', 'chandler1', 12),
(11, '2021-05-13 18:59:24.081963', 'admin', '2021-05-13 18:59:24.081963', 'admin', b'1', '$2a$10$28xtpJhNaLEBlCPk3TZsi.4.CH.45BwVhxGGfC.jbgGm6sK.biV6a', 'chandler2', 13),
(12, '2021-05-13 19:02:38.142301', 'admin', '2021-05-13 19:02:38.142301', 'admin', b'1', '$2a$10$Re747om/7/JeY/S9NA0hvOnPaedcLQe.dnq3Qt5folmQrcUIskhlq', 'chandler3', 18),
(13, '2021-05-13 19:04:57.636695', 'admin', '2021-05-13 19:04:57.636695', 'admin', b'1', '$2a$10$gM2WUUIggtL0BbjX7fU24.qzlggu8y2wLA2usd8uT8Xe/Jl.N6xcy', 'chandler4', 19),
(14, '2021-05-13 19:07:28.206901', 'admin', '2021-05-13 19:07:28.206901', 'admin', b'1', '$2a$10$7/xtuaPomwG1zL/pfskgi.NOIG9AavJqdsX89oSwkvW9bX5YvRZWa', 'chandler5', 20),
(15, '2021-05-13 19:19:45.525252', 'admin', '2021-05-13 19:19:45.525252', 'admin', b'1', '$2a$10$dQEjd/QTX6T5lNhgpl0ozOgt9NjznYUwzZ1F0SRxR9El/XiPhpx/e', 'chandler6', 22),
(16, '2021-05-13 19:22:28.302086', 'admin', '2021-05-13 19:22:28.302086', 'admin', b'1', '$2a$10$JnBbXyZtzYB.UWr9IbM9ZOBnDz48Y06btrE8eqZRHvIZQhbavCjIO', 'chandler7', 23),
(17, '2021-05-13 19:27:18.313942', 'admin', '2021-05-13 19:27:18.313942', 'admin', b'1', '$2a$10$2JERwYkFiE66kD.Krx1kdON.TZ.pcPp58kM84Izr8boooXPzyNUPy', 'chandler8', 25),
(18, '2021-05-13 19:29:52.918102', 'admin', '2021-05-13 19:29:52.918102', 'admin', b'1', '$2a$10$dnkqmaKWRGZ0LC.GZWXmH.fleoEs28AdxdqFuD5AIFK2.vyNZsAMm', 'chandler9', 26),
(19, '2021-05-13 19:37:04.383414', 'admin', '2021-05-13 19:37:04.383414', 'admin', b'1', '$2a$10$1/18ooLCuaFC8whAcvxPy.O2.ofn.LIUexnKuxjv1JwQ7xmm1CFBq', 'chandler10', 27),
(20, '2021-05-13 20:06:13.837574', 'admin', '2021-05-13 20:34:11.717662', 'admin', b'1', '$2a$10$h836ONPegtDkTxnyzvVJUeiz4bT5K/m9tJOIOcvZWGqy2Xh7GUkKO', 'shipagent1', 28),
(21, '2021-05-13 20:11:15.734944', 'admin', '2021-05-19 01:24:29.283084', 'admin', b'1', '$2a$10$/Awx058R8WWhaBQlB3XQvuYuYXpj2v0UkjDlApkj8MBMxMl6aFPkG', 'shipagent2', 30),
(22, '2021-05-13 20:13:58.236799', 'admin', '2021-05-13 20:14:10.910450', 'admin', b'1', '$2a$10$HdgJtmjUBETIQstYHgxUCOve9r9ua.tFC/rgCNyxErHFubXBV0UNu', 'shipagent3', 31),
(23, '2021-05-13 20:16:04.192112', 'admin', '2021-05-15 23:49:54.667306', 'admin', b'1', '$2a$10$d7Cz2aRo/4BLuh/FMq7cFup.JW5N669rbTlHDznxDxsMJfndAXsHi', 'shipagent4', 32),
(24, '2021-05-13 20:19:07.513820', 'admin', '2021-05-15 23:51:04.533359', 'admin', b'1', '$2a$10$tHCMeid87y2KLBdkDV39y.K8E55gOAwGHJ6jTsXvigp7225Mfv3Ri', 'shipagent5', 33),
(25, '2021-05-13 20:21:32.968457', 'admin', '2021-05-15 23:51:13.082514', 'admin', b'1', '$2a$10$TAJowUNlIvTcS7Tq01tmLeXTyDx.//2y8mfm/Awv/iQ3nHNpDXXPa', 'shipagent6', 34),
(26, '2021-05-13 20:24:20.037741', 'admin', '2021-05-15 23:53:56.965749', 'admin', b'1', '$2a$10$rdpHKDRL7yPhu.N/gc8tOO7yyJOyAXRjXa6769VMCGSkZj2z3gLIS', 'shipagent7', 35),
(27, '2021-05-13 20:27:36.673462', 'admin', '2021-05-15 23:54:06.333166', 'admin', b'1', '$2a$10$ByrbRMVjsjzt7unPOQPLRuwkIubIoXt5eVpejzbjYLiFsUP./qEJW', 'shipagent8', 36),
(28, '2021-05-13 20:31:10.326262', 'admin', '2021-05-13 20:31:10.326262', 'admin', b'1', '$2a$10$Qp.9UKSWnKjcjcN/Dleqfu4dzHPTgq.l1wOP6ZikYKFEIynvdUHs6', 'shipagent9', 37),
(29, '2021-05-13 20:33:35.580493', 'admin', '2021-05-13 20:33:35.580493', 'admin', b'1', '$2a$10$6QvE8r1uijV4pq0Y1e53QOGS.RzRm6LbfAc2cF49j.z9iTMc/w1GW', 'shipagent10', 38);

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
CREATE TABLE IF NOT EXISTS `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `calling_name` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `land` varchar(255) DEFAULT NULL,
  `live_dead` varchar(255) DEFAULT NULL,
  `mobile_one` varchar(10) DEFAULT NULL,
  `mobile_two` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nic` varchar(12) DEFAULT NULL,
  `number` varchar(255) NOT NULL,
  `office_email` varchar(255) DEFAULT NULL,
  `relevant_party` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4d9rdl7d52k8x3etihxlaujvh` (`email`),
  UNIQUE KEY `UK_kfucs51ugoh91nkt752qybixg` (`nic`),
  UNIQUE KEY `UK_k72n5tr2mhtm128rq1sthdufm` (`office_email`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `address`, `calling_name`, `date_of_birth`, `email`, `gender`, `land`, `live_dead`, `mobile_one`, `mobile_two`, `name`, `nic`, `number`, `office_email`, `relevant_party`, `title`) VALUES
(1, '2021-05-13 15:38:28.535010', 'anonymousUser', '2021-05-13 15:38:28.535010', 'anonymousUser', NULL, 'Admin', '2003-05-13', NULL, 'MALE', NULL, NULL, '0750000000', NULL, '908670000V', NULL, 'SLCU210000', NULL, 'SLC', 'DR'),
(2, '2021-05-13 15:45:16.208643', 'admin', '2021-05-13 15:45:16.208643', 'admin', '15, Pokuna Junction, Ganemulla', 'Arjith', '1969-12-09', 'samaraarjith@gmail.com', 'MALE', '0115486556', 'ACTIVE', '0785464843', '0778659595', 'Arjith Samarasinghe', '693448463V', 'SLCU210001', 'samaraofz@gmail.com', 'SLC', 'MR'),
(3, '2021-05-13 15:48:50.533251', 'admin', '2021-05-13 15:48:50.533251', 'admin', '54, Wathuragama Road, Mirisswatte', 'Athula', '1968-09-12', 'athula.hos@gmail.com', 'MALE', '0116812555', 'ACTIVE', '0716464862', '0758689595', 'Athula Gamage', '682565359V', 'SLCU210002', 'athula.ofz@gmail.com', 'SLC', 'MR'),
(4, '2021-05-13 15:53:40.786502', 'admin', '2021-05-13 15:53:40.786502', 'admin', '12, Hunupitiya road, Wattala', 'Viraj', '1975-12-09', 'virajra7@gmail.com', 'MALE', '0117319856', 'ACTIVE', '0716464862', '0778659591', 'Viraj Rajapaksha', '753448463V', 'SLCU210003', 'virajraofz@gmail.com', 'SLC', 'MR'),
(5, '2021-05-13 15:55:43.827277', 'admin', '2021-05-13 15:55:43.827277', 'admin', '23, Galwarusa road, Athurugiriya', 'Samantha', '1978-09-12', 'aadikari78@gmail.com', 'MALE', '0117319859', 'ACTIVE', '0775464872', '0786895645', 'Samantha Adhikari', '782565359V', 'SLCU210004', 'aadikariofz@gmail.com', 'SLC', 'MR'),
(6, '2021-05-13 15:59:34.713927', 'admin', '2021-05-13 15:59:34.713927', 'admin', '11, Kaduwela Road, Gamunupura, Kaduwela', 'Dilshan', '1990-06-14', 'diladissnayake@gmail.com', 'MALE', '0117346557', 'ACTIVE', '0775464874', '0786895642', 'Dilshan Dissanayake', '901665259V', 'SLCU210005', 'ofzdissnayake@gmail.com', 'SLC', 'MR'),
(7, '2021-05-13 16:03:58.383611', 'admin', '2021-05-13 19:39:18.285932', 'admin', '87, Temple Road, Mihidu lane, Battaramulla', 'Alahakoon', '1989-08-18', 'alasithum@gmail.com', 'MALE', '0116812555', 'ACTIVE', '0785464848', '0778659596', 'Sithum Alahakoon', '892318441V', 'SLCU210006', 'ofzsithum@gmail.com', 'SLC', 'MR'),
(8, '2021-05-13 16:06:57.198767', 'admin', '2021-05-13 19:39:27.801686', 'admin', '08, Hettiyawattaroad, Karagampitiya', 'Balasooriya', '1992-06-14', 'gangabalasuriya@gmail.com', 'MALE', '0116812555', 'ACTIVE', '0775464874', '0711659595', 'Ganganath Balasooriya', '921665259V', 'SLCU210007', 'gangaofzbalasuriya@gmail.com', 'SLC', 'MR'),
(9, '2021-05-13 16:14:31.150786', 'admin', '2021-05-13 16:14:31.150786', 'admin', '23, Namal Pedesa, Pannipitiya', 'Jaliya', '1991-06-14', 'yapajaliya@gmail.com', 'MALE', '0117319856', 'ACTIVE', '0775464877', '0711659595', 'Jaliya Yapa', '911665259V', 'SLCU210008', 'yapajaliyaofz@gmail.com', 'SLC', 'MR'),
(11, '2021-05-13 18:47:23.506258', 'admin', '2021-05-13 18:48:42.333675', 'admin', '2/1, Galwarusa Road, Athurugiriya', 'Lahiru', '1989-06-14', 'laththanayake@gmail.com', 'MALE', '0116812555', 'ACTIVE', '0785464843', '0786895954', 'Lahiru Aththanayake', '891665259V', 'SLCU210009', 'lahiruofficial@gmail.com', 'SLCC', 'MR'),
(12, '2021-05-13 18:52:49.420984', 'admin', '2021-05-13 18:52:49.420984', 'admin', '54, Millenium city, Athurugiriya', 'Saliya', '1976-07-12', 'saliyawije@gmail.com', 'MALE', '0115487645', 'ACTIVE', '0775464481', '0786895387', 'Saliya Wijesooriya', '761945334V', 'SLCU210010', 'sliyaofficial@gmail.com', 'SLCC', 'MR'),
(13, '2021-05-13 18:55:36.258927', 'admin', '2021-05-13 19:39:45.959012', 'admin', '21, Araliya Uyana, Kottawa ', 'Herath', '1977-09-10', 'sakunalhera@gmail.com', 'MALE', '0118576551', 'ACTIVE', '0716464333', '0783335642', 'Sakunal Herath', '772543456V', 'SLCU210011', 'sakunalofz@gmail.com', 'SLCC', 'MR'),
(18, '2021-05-13 19:01:54.411702', 'admin', '2021-05-13 19:41:34.435170', 'admin', '24, 3rd lane, Makola North', 'Suriyarachchi', '1987-09-10', 'damithssh@gmail.com', 'MALE', '0117346397', 'ACTIVE', '0716464945', '0786895111', 'Damith Suriyarachchi', '872543456V', 'SLCU210012', 'damithofficial@gmail.com', 'SLCC', 'MR'),
(19, '2021-05-13 19:04:26.127166', 'admin', '2021-05-13 19:04:26.127166', 'admin', '45, Kandy Road, Kiribathgoda ', 'Hasith', '1979-12-09', 'alwishasitha@gmail.com', 'MALE', '0117346497', 'ACTIVE', '0775464749', '0786895997', 'Hasitha Alwis', '793448463V', 'SLCU210013', 'alwisofficial@gmail.com', 'SLCC', 'MR'),
(20, '2021-05-13 19:06:56.505218', 'admin', '2021-05-13 19:06:56.505218', 'admin', '23, 4th lane, Mahara, Kadawatha', 'Anjana', '1990-06-14', 'anjanakodi@gmail.com', 'MALE', '0117340405', 'ACTIVE', '0716464396', '0786895387', 'Anjana Kodituwakku', '901665111V', 'SLCU210014', 'anjanaofficial@gmail.com', 'SLCC', 'MR'),
(22, '2021-05-13 19:18:59.248091', 'admin', '2021-05-13 19:18:59.248091', 'admin', '45, Hunupituya Road, Wattala', 'Kumar', '1988-12-09', 'kumarraja@gmail.com', 'MALE', '0117873756', 'ACTIVE', '0775464470', '0786895000', 'Kumar Kandaraja', '883448463V', 'SLCU210015', 'officialkumar@gmail.com', 'SLCC', 'MR'),
(23, '2021-05-13 19:21:55.114743', 'admin', '2021-05-13 19:37:53.411253', 'admin', '8/3, Kaduwela Road, Gamunupura', 'Danushanth', '1985-12-09', 'denit85@gmail.com', 'MALE', '0115484950', 'ACTIVE', '0716464880', '0778659909', 'Denit Danushanth', '853448463V', 'SLCU210016', 'denitofficial@gmail.com', 'SLCC', 'MR'),
(25, '2021-05-13 19:25:37.451028', 'admin', '2021-05-16 18:16:18.950753', 'admin', '7/8, Parliment Road, Kotte', 'Edirisinghe', '1987-09-22', 'edirisingheasanka@gmail.com', 'MALE', '0115484490', 'ACTIVE', '0775463956', '0786895875', 'Asanka Edirisinghe', '872665259V', 'SLCU210017', 'officialasanka@gmail.com', 'SLCC', 'MR'),
(26, '2021-05-13 19:29:21.201852', 'admin', '2021-05-13 19:29:21.201852', 'admin', '67/2, Kumara Veediya, Habarakada', 'Nuwantha', '1988-12-19', 'nperera@gmail.com', 'MALE', '0115484200', 'ACTIVE', '0716464490', '0786890007', 'Nuwantha Perera', '883543456V', 'SLCU210018', 'npereraofz@gmail.com', 'SLCC', 'MR'),
(27, '2021-05-13 19:32:29.990591', 'admin', '2021-05-13 19:33:50.789287', 'admin', '32/56, Maligawatte road, Kotahena', 'Ismail', '1993-06-14', 'samjaad@gmail.com', 'MALE', '0117346000', 'ACTIVE', '0775460208', '0786890947', 'Samjaad Ismail', '931665259V', 'SLCU210019', 'samjaadofz@gmail.com', 'SLCC', 'MR'),
(28, '2021-05-13 20:05:34.783022', 'admin', '2021-05-13 20:05:34.783022', 'admin', '8/4, Rose Street, Kolpity', 'Kalpana 	', '1991-08-11', 'ksamare@gmail.com', 'MALE', '0114765676', 'ACTIVE', '0716468934', '0786896758', 'Kalpana Samarasinghe	', '912243456V', 'SLCU210020', 'ksamareofficial@gmail.com', 'SLCS', 'MR'),
(30, '2021-05-13 20:09:50.669720', 'admin', '2021-05-13 20:09:50.669720', 'admin', '23/65, 3rd lane, Yatiyana Road, Kaluaggala\r\n', 'Chethana ', '1979-09-22', 'amarechethana@gmail.com', 'MALE', '0117319002', 'ACTIVE', '0755473658', '0786893856', 'Chethana Amarasinghe	', '792665259V', 'SLCU210021', 'amarechethanaofz@gmail.com', 'SLCS', 'MR'),
(31, '2021-05-13 20:13:28.826362', 'admin', '2021-05-13 20:13:28.826362', 'admin', '21, Puttalam Road, Chilaw', 'Dimuth', '1988-05-23', 'dimuthsilva@gmail.com', 'MALE', '0117300000', 'ACTIVE', '0716460067', '0786895908', 'Dimuth Silva', '881448463V', 'SLCU210022', 'dimuthsilvaofz@gmail.com', 'SLCS', 'MR'),
(32, '2021-05-13 20:15:37.742971', 'admin', '2021-05-13 20:15:37.742971', 'admin', '78/2, Kosinna Road, Ganemulla\r\n', 'Danuka', '1991-06-04', 'premaratnedanuka@gmail.com', 'MALE', '0115483008', 'ACTIVE', '0716464735', '0778650097', 'Danuka Premarathne	', '911565359V', 'SLCU210023', 'premaratnedanukaofz@gmail.com', 'SLCS', 'MR'),
(33, '2021-05-13 20:17:38.254557', 'admin', '2021-05-13 20:17:38.254557', 'admin', '25, Puttalam Road, Marawila\r\n', 'Romesh', '1991-12-21', 'rjayakodi@gmail.com', 'MALE', '0117856832', 'ACTIVE', '0716465082', '0778654007', 'Romesh Jayakody	', '913565359V', 'SLCU210024', 'rjayakodiofz@gmail.com', 'SLCS', 'MR'),
(34, '2021-05-13 20:20:45.899675', 'admin', '2021-05-13 20:20:45.899675', 'admin', '211, WK Perera Streer, Namal Pedesa, Pannipitiya\r\n', 'Lakshaan', '1993-02-16', 'lakshan93@gmail.com', 'FEMALE', '0115484365', 'ACTIVE', '0781264543', '0786895758', 'Lakshaan Fernando	', '935479879V', 'SLCU210025', 'lakshan93ofz@gmail.com', 'SLCS', 'MR'),
(35, '2021-05-13 20:23:49.420851', 'admin', '2021-05-13 20:23:49.420851', 'admin', '45, Piliyandala Road, Kahathuduwa\r\n', 'Samith', '1988-05-24', 'skarunarathne@gmail.com', 'MALE', '0117346487', 'ACTIVE', '0715464543', '0787795954', 'Samith Karunarathne	', '886453365V', 'SLCU210026', 'skarunarathneofz@gmail.com', 'SLCS', 'MR'),
(36, '2021-05-13 20:27:06.125786', 'admin', '2021-05-13 20:27:06.125786', 'admin', '24, Piliyandala Road, Gonapola\r\n', 'Narada', '1988-12-19', 'naradajaye@gmail.com', 'MALE', '0117319674', 'ACTIVE', '0716464222', '0711653543', 'Narada Jayasinghe	', '883545646V', 'SLCU210027', 'naradajayeofz@gmail.com', 'SLCS', 'MR'),
(37, '2021-05-13 20:29:25.731829', 'admin', '2021-05-13 20:29:25.731829', 'admin', '85/2, Kandy Road, Kalagedihena\r\n', 'Dumith', '1992-12-29', 'sirisenadumith@gmail.com', 'MALE', '0115486064', 'ACTIVE', '0775460519', '0786890068', 'Dumith Sirisena	', '923643464V', 'SLCU210028', 'sirisenadumithofz@gmail.com', 'SLCS', 'MR'),
(38, '2021-05-13 20:33:06.798809', 'admin', '2021-05-13 20:33:06.798809', 'admin', '78, Egodawatta,Kelaniya\r\n', 'Damith', '1985-11-16', 'damithwaniga@gmail.com', 'MALE', '0117378587', 'ACTIVE', '0716466747', '0786895665', 'Damith Wanigasekara	', '853213353V', 'SLCU210029', 'damithwanigaofz@gmail.com', 'SLCS', 'MR');

-- --------------------------------------------------------

--
-- Table structure for table `user_details_chandler`
--

DROP TABLE IF EXISTS `user_details_chandler`;
CREATE TABLE IF NOT EXISTS `user_details_chandler` (
  `user_details_id` int(11) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `chandler_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_details_id`),
  KEY `FK6yrao9pbhc3gtheav4rcn6eis` (`chandler_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_details_chandler`
--

INSERT INTO `user_details_chandler` (`user_details_id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `chandler_id`) VALUES
(12, '2021-05-13 18:52:49.488050', 'admin', '2021-05-13 18:52:49.488050', 'admin', 1),
(13, '2021-05-13 18:55:36.329076', 'admin', '2021-05-13 18:55:36.329076', 'admin', 2),
(18, '2021-05-13 19:01:54.522717', 'admin', '2021-05-13 19:01:54.522717', 'admin', 3),
(19, '2021-05-13 19:04:26.261115', 'admin', '2021-05-13 19:04:26.261115', 'admin', 4),
(20, '2021-05-13 19:06:56.571287', 'admin', '2021-05-13 19:06:56.571287', 'admin', 4),
(22, '2021-05-13 19:18:59.297370', 'admin', '2021-05-13 19:18:59.297370', 'admin', 6),
(23, '2021-05-13 19:21:55.205373', 'admin', '2021-05-13 19:21:55.205373', 'admin', 7),
(25, '2021-05-16 18:16:18.794597', 'admin', '2021-05-16 18:16:18.794597', 'admin', 8),
(26, '2021-05-13 19:29:21.249532', 'admin', '2021-05-13 19:29:21.249532', 'admin', 8),
(27, '2021-05-13 19:32:30.083888', 'admin', '2021-05-13 19:32:30.083888', 'admin', 10);

-- --------------------------------------------------------

--
-- Table structure for table `user_details_files`
--

DROP TABLE IF EXISTS `user_details_files`;
CREATE TABLE IF NOT EXISTS `user_details_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `mime_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `new_id` varchar(255) DEFAULT NULL,
  `new_name` varchar(255) DEFAULT NULL,
  `pic` longblob,
  `user_details_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3pj2kpx26q4j8aevn4h83xvf` (`new_id`),
  KEY `FK14snsy54cro4dn8wnfq17vlmi` (`user_details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_details_files`
--

INSERT INTO `user_details_files` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `mime_type`, `name`, `new_id`, `new_name`, `pic`, `user_details_id`) VALUES
(1, '2021-05-13 15:45:16.299130', 'admin', '2021-05-13 15:45:16.299130', 'admin', 'application/octet-stream', '', '663f9f5f-7a61-421a-851b-96fcc0637be5userDetails', '693448463V-2021-05-13T15:45:16.283134100', '', 2),
(2, '2021-05-13 15:48:50.638689', 'admin', '2021-05-13 15:48:50.638689', 'admin', 'application/octet-stream', '', 'b901c0d5-7eee-45ea-95bb-670cc1ee2632userDetails', '682565359V-2021-05-13T15:48:50.630770', '', 3),
(3, '2021-05-13 15:53:40.900173', 'admin', '2021-05-13 15:53:40.900173', 'admin', 'application/octet-stream', '', '1692c582-1888-4490-bc2b-5382b96db25cuserDetails', '753448463V-2021-05-13T15:53:40.900173400', '', 4),
(4, '2021-05-13 15:55:43.891285', 'admin', '2021-05-13 15:55:43.891285', 'admin', 'application/octet-stream', '', 'be3cc09f-310c-4048-a31f-5265c9bd3023userDetails', '782565359V-2021-05-13T15:55:43.883329200', '', 5),
(5, '2021-05-13 15:59:34.754225', 'admin', '2021-05-13 15:59:34.754225', 'admin', 'application/octet-stream', '', 'eb047ef3-b4b2-4d8d-977e-50a2c5be56c7userDetails', '901665259V-2021-05-13T15:59:34.753227200', '', 6),
(6, '2021-05-13 16:03:58.422467', 'admin', '2021-05-13 16:03:58.422467', 'admin', 'application/octet-stream', '', 'fcff71a4-505d-4305-ba04-09dd934625d4userDetails', '892318441V-2021-05-13T16:03:58.419427200', '', 7),
(7, '2021-05-13 16:06:57.241013', 'admin', '2021-05-13 16:06:57.241013', 'admin', 'application/octet-stream', '', '44ad34fb-bb4d-439c-8f36-206579ded201userDetails', '921665259V-2021-05-13T16:06:57.235188700', '', 8),
(8, '2021-05-13 16:14:31.192171', 'admin', '2021-05-13 16:14:31.192171', 'admin', 'application/octet-stream', '', '92136655-2c10-48d0-a764-0d7010b058feuserDetails', '911665259V-2021-05-13T16:14:31.191003300', '', 9),
(9, '2021-05-13 18:52:49.556559', 'admin', '2021-05-13 18:52:49.556559', 'admin', 'application/octet-stream', '', '295d1995-1759-4984-af04-a20d7189a5a2userDetails', '761945334V-2021-05-13T18:52:49.546674', '', 12),
(10, '2021-05-13 18:55:36.373442', 'admin', '2021-05-13 18:55:36.373442', 'admin', 'application/octet-stream', '', 'be7dc9c3-befb-43f9-a24d-032833697d8auserDetails', '772543456V-2021-05-13T18:55:36.371412', '', 13),
(11, '2021-05-13 19:01:54.564974', 'admin', '2021-05-13 19:01:54.564974', 'admin', 'application/octet-stream', '', '8203503d-eaa7-456c-a546-8fd7f193b9fauserDetails', '872543456V-2021-05-13T19:01:54.556692100', '', 18),
(12, '2021-05-13 19:04:26.305212', 'admin', '2021-05-13 19:04:26.305212', 'admin', 'application/octet-stream', '', 'f04fce36-ec06-4436-a29e-523812fdd4b5userDetails', '793448463V-2021-05-13T19:04:26.303218300', '', 19),
(13, '2021-05-13 19:06:56.612433', 'admin', '2021-05-13 19:06:56.612433', 'admin', 'application/octet-stream', '', '4f7c56ae-033c-4fe8-b48f-8ce330d0656auserDetails', '901665111V-2021-05-13T19:06:56.611845700', '', 20),
(14, '2021-05-13 19:18:59.359628', 'admin', '2021-05-13 19:18:59.359628', 'admin', 'application/octet-stream', '', '59d607cd-15ee-41de-bf21-2bf4463a1234userDetails', '883448463V-2021-05-13T19:18:59.351660300', '', 22),
(15, '2021-05-13 19:21:55.298784', 'admin', '2021-05-13 19:21:55.298784', 'admin', 'application/octet-stream', '', '88d6cf28-3d21-419f-a58e-61cf125d396buserDetails', '853448463V-2021-05-13T19:21:55.297785400', '', 23),
(16, '2021-05-13 19:29:21.283529', 'admin', '2021-05-13 19:29:21.283529', 'admin', 'application/octet-stream', '', '20db3484-0eff-4d6d-a1c5-56cc28883953userDetails', '883543456V-2021-05-13T19:29:21.275668600', '', 26),
(17, '2021-05-13 19:32:30.142637', 'admin', '2021-05-13 19:32:30.142637', 'admin', 'application/octet-stream', '', 'd163a114-aa94-499f-b341-40417399638buserDetails', '931665259V-2021-05-13T19:32:30.140642300', '', 27),
(18, '2021-05-13 20:05:34.870938', 'admin', '2021-05-13 20:05:34.870938', 'admin', 'application/octet-stream', '', '0cc4cd5f-ae44-4899-b726-a28a9c8f1853userDetails', '912243456V-2021-05-13T20:05:34.862426700', '', 28),
(19, '2021-05-13 20:13:28.951214', 'admin', '2021-05-13 20:13:28.951214', 'admin', 'application/octet-stream', '', '30e0ace0-c39c-445a-8319-679d0e8bbc08userDetails', '881448463V-2021-05-13T20:13:28.942204900', '', 31),
(20, '2021-05-13 20:15:37.909299', 'admin', '2021-05-13 20:15:37.909299', 'admin', 'application/octet-stream', '', '8c27de75-1539-4d06-8c73-c57ebff17426userDetails', '911565359V-2021-05-13T20:15:37.907306200', '', 32),
(21, '2021-05-13 20:17:38.482979', 'admin', '2021-05-13 20:17:38.482979', 'admin', 'application/octet-stream', '', 'cc77f983-3b80-4c40-bf10-b722f4d8c93auserDetails', '913565359V-2021-05-13T20:17:38.481976400', '', 33),
(22, '2021-05-13 20:20:46.003483', 'admin', '2021-05-13 20:20:46.003483', 'admin', 'application/octet-stream', '', 'c41e0144-8f65-4dbe-8b52-71ede6900f00userDetails', '935479879V-2021-05-13T20:20:46.001488800', '', 34),
(23, '2021-05-13 20:23:49.494442', 'admin', '2021-05-13 20:23:49.494442', 'admin', 'application/octet-stream', '', 'f4a41165-d2f5-4c9a-9882-ddaccd15ea48userDetails', '886453365V-2021-05-13T20:23:49.493442400', '', 35),
(24, '2021-05-13 20:27:06.223916', 'admin', '2021-05-13 20:27:06.223916', 'admin', 'application/octet-stream', '', '14b817df-2d81-4a04-a362-872c8e9f4908userDetails', '883545646V-2021-05-13T20:27:06.222913600', '', 36),
(25, '2021-05-13 20:29:25.889628', 'admin', '2021-05-13 20:29:25.889628', 'admin', 'application/octet-stream', '', '8e321e86-c453-40b9-aebf-409b65958650userDetails', '923643464V-2021-05-13T20:29:25.887636400', '', 37),
(26, '2021-05-13 20:33:06.940065', 'admin', '2021-05-13 20:33:06.940065', 'admin', 'application/octet-stream', '', 'fc2471db-b17b-4b0d-80f4-35b0d1743044userDetails', '853213353V-2021-05-13T20:33:06.939071500', '', 38),
(27, '2021-05-16 18:16:18.837925', 'admin', '2021-05-16 18:16:18.837925', 'admin', 'application/octet-stream', '', 'c281dbcb-668c-488d-924a-bb4974b43581userDetails', '872665259V-2021-05-16T18:16:18.824960900', '', 25);

-- --------------------------------------------------------

--
-- Table structure for table `user_details_ship_agent`
--

DROP TABLE IF EXISTS `user_details_ship_agent`;
CREATE TABLE IF NOT EXISTS `user_details_ship_agent` (
  `user_details_id` int(11) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `ship_agent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_details_id`),
  KEY `FK68mr6f0up9omcjdoupxsnpyfj` (`ship_agent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_details_ship_agent`
--

INSERT INTO `user_details_ship_agent` (`user_details_id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `ship_agent_id`) VALUES
(28, '2021-05-13 20:05:34.829255', 'admin', '2021-05-13 20:05:34.829255', 'admin', 1),
(31, '2021-05-13 20:13:28.882469', 'admin', '2021-05-13 20:13:28.882469', 'admin', 3),
(32, '2021-05-13 20:15:37.843749', 'admin', '2021-05-13 20:15:37.843749', 'admin', 4),
(33, '2021-05-13 20:17:38.361947', 'admin', '2021-05-13 20:17:38.361947', 'admin', 5),
(34, '2021-05-13 20:20:45.947629', 'admin', '2021-05-13 20:20:45.947629', 'admin', 6),
(35, '2021-05-13 20:23:49.467572', 'admin', '2021-05-13 20:23:49.467572', 'admin', 7),
(36, '2021-05-13 20:27:06.185017', 'admin', '2021-05-13 20:27:06.185017', 'admin', 8),
(37, '2021-05-13 20:29:25.813180', 'admin', '2021-05-13 20:29:25.813180', 'admin', 9),
(38, '2021-05-13 20:33:06.891528', 'admin', '2021-05-13 20:33:06.891528', 'admin', 10);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 5),
(3, 5),
(4, 6),
(5, 6),
(6, 4),
(7, 4),
(8, 7),
(9, 7),
(10, 3),
(11, 3),
(12, 3),
(13, 3),
(14, 3),
(15, 3),
(16, 3),
(17, 3),
(18, 3),
(19, 3),
(22, 2),
(28, 2),
(29, 2),
(20, 2),
(21, 2),
(23, 2),
(24, 2),
(25, 2),
(26, 2),
(27, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_session_log`
--

DROP TABLE IF EXISTS `user_session_log`;
CREATE TABLE IF NOT EXISTS `user_session_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `failure_attempts` int(11) NOT NULL,
  `user_session_log_status` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrhb4wune1hnnhdsbiah2ojo5l` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=337 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_session_log`
--

INSERT INTO `user_session_log` (`id`, `created_at`, `failure_attempts`, `user_session_log_status`, `user_id`) VALUES
(1, '2021-05-13 15:38:45.520804', 0, 'LOGGED', 1),
(2, '2021-05-13 16:15:25.109042', 0, 'LOGOUT', 1),
(3, '2021-05-13 17:16:15.981646', 0, 'LOGGED', 1),
(4, '2021-05-13 18:01:07.587327', 0, 'LOGGED', 1),
(5, '2021-05-13 18:49:38.870835', 0, 'LOGGED', 1),
(6, '2021-05-13 18:49:38.917709', 0, 'LOGGED', 1),
(7, '2021-05-13 18:57:59.075742', 0, 'LOGGED', 1),
(8, '2021-05-13 19:14:08.936334', 0, 'LOGGED', 1),
(9, '2021-05-13 19:26:25.455326', 0, 'LOGGED', 1),
(10, '2021-05-13 19:33:25.233728', 0, 'LOGGED', 1),
(11, '2021-05-13 19:36:00.525519', 0, 'LOGGED', 1),
(12, '2021-05-13 19:38:47.191807', 0, 'LOGGED', 1),
(13, '2021-05-13 19:40:28.734978', 0, 'LOGGED', 1),
(14, '2021-05-13 19:42:18.390052', 0, 'LOGGED', 1),
(15, '2021-05-13 20:10:37.358100', 0, 'LOGGED', 1),
(16, '2021-05-13 22:11:28.231087', 0, 'LOGGED', 1),
(17, '2021-05-13 22:12:49.063428', 0, 'LOGGED', 6),
(18, '2021-05-13 23:21:08.677853', 0, 'LOGOUT', 6),
(19, '2021-05-13 23:21:18.020231', 0, 'LOGGED', 8),
(20, '2021-05-14 00:21:07.733987', 0, 'LOGGED', 8),
(21, '2021-05-14 00:30:10.514398', 0, 'LOGGED', 9),
(22, '2021-05-14 00:44:49.193109', 0, 'LOGOUT', 9),
(23, '2021-05-14 14:27:44.558895', 0, 'LOGGED', 1),
(24, '2021-05-14 21:00:36.524920', 0, 'LOGGED', 9),
(25, '2021-05-14 21:33:20.767899', 0, 'LOGGED', 8),
(26, '2021-05-14 21:37:35.439035', 0, 'LOGGED', 8),
(27, '2021-05-14 21:37:35.448059', 0, 'LOGGED', 8),
(28, '2021-05-15 01:46:16.950408', 0, 'LOGGED', 8),
(29, '2021-05-15 10:29:29.527308', 0, 'LOGGED', 7),
(30, '2021-05-15 10:31:44.469897', 0, 'LOGOUT', 7),
(31, '2021-05-15 10:32:12.165165', 0, 'LOGGED', 20),
(32, '2021-05-15 10:33:41.797162', 0, 'LOGGED', 28),
(33, '2021-05-15 15:24:47.109975', 0, 'LOGGED', 20),
(34, '2021-05-15 15:56:24.035328', 0, 'LOGGED', 23),
(35, '2021-05-15 16:08:21.386065', 0, 'LOGGED', 22),
(36, '2021-05-15 16:15:19.203266', 0, 'LOGOUT', 22),
(37, '2021-05-15 16:15:33.406414', 0, 'LOGGED', 13),
(38, '2021-05-15 16:26:50.078712', 0, 'LOGOUT', 13),
(39, '2021-05-15 16:27:02.549368', 0, 'LOGGED', 14),
(40, '2021-05-15 16:33:05.655322', 0, 'LOGOUT', 14),
(41, '2021-05-15 16:41:40.783378', 0, 'LOGGED', 2),
(42, '2021-05-15 17:38:05.728826', 0, 'LOGGED', 2),
(43, '2021-05-19 23:58:13.602957', 0, 'LOGGED', 2),
(44, '2021-05-19 23:59:28.253053', 0, 'LOGGED', 2),
(45, '2021-05-20 00:11:56.257173', 0, 'LOGOUT', 2),
(46, '2021-05-19 23:58:07.884505', 0, 'LOGGED', 2),
(47, '2021-05-20 00:52:19.541666', 0, 'LOGGED', 2),
(48, '2021-05-20 00:54:56.112393', 0, 'LOGOUT', 2),
(49, '2021-05-20 00:55:06.814914', 0, 'LOGGED', 3),
(50, '2021-05-20 01:07:28.913853', 0, 'LOGOUT', 3),
(51, '2021-05-20 01:07:41.852340', 0, 'LOGGED', 13),
(52, '2021-05-20 01:11:03.021389', 0, 'LOGOUT', 13),
(53, '2021-05-20 01:11:34.387628', 0, 'LOGGED', 14),
(54, '2021-05-20 01:17:12.496590', 0, 'LOGOUT', 14),
(55, '2021-05-20 01:17:23.632014', 0, 'LOGGED', 2),
(56, '2021-05-15 21:08:38.319886', 0, 'LOGGED', 20),
(57, '2021-05-15 21:08:57.245922', 0, 'LOGOUT', 20),
(58, '2021-05-15 21:09:08.433258', 0, 'LOGGED', 7),
(59, '2021-05-15 21:14:01.495857', 0, 'LOGOUT', 7),
(60, '2021-05-15 21:14:33.383132', 0, 'LOGGED', 21),
(61, '2021-05-15 21:29:16.147457', 0, 'LOGGED', 10),
(62, '2021-05-15 21:45:56.342251', 0, 'LOGOUT', 10),
(63, '2021-05-15 21:46:45.166656', 0, 'LOGGED', 21),
(64, '2021-05-15 21:49:54.454880', 0, 'LOGGED', 21),
(65, '2021-05-15 21:51:58.988640', 0, 'LOGGED', 21),
(66, '2021-05-15 21:56:34.318289', 0, 'LOGGED', 21),
(67, '2021-05-15 22:00:41.651053', 0, 'LOGOUT', 21),
(68, '2021-05-15 22:00:58.376765', 0, 'LOGGED', 10),
(69, '2021-05-15 22:04:12.688758', 0, 'LOGOUT', 10),
(70, '2021-05-15 22:04:28.840998', 0, 'LOGGED', 11),
(71, '2021-05-15 22:07:22.126576', 0, 'LOGOUT', 11),
(72, '2021-05-15 22:07:33.263556', 0, 'LOGGED', 12),
(73, '2021-05-15 22:13:21.803603', 0, 'LOGOUT', 12),
(74, '2021-05-15 22:13:35.798437', 0, 'LOGGED', 2),
(75, '2021-05-19 00:01:52.149456', 0, 'LOGGED', 2),
(76, '2021-05-19 00:31:41.314975', 0, 'LOGOUT', 2),
(77, '2021-05-19 00:31:52.833581', 0, 'LOGGED', 10),
(78, '2021-05-19 00:36:12.153442', 0, 'LOGGED', 10),
(79, '2021-05-19 00:46:05.849245', 0, 'LOGOUT', 10),
(80, '2021-05-19 00:46:34.556723', 0, 'LOGGED', 11),
(81, '2021-05-19 00:47:15.670329', 0, 'LOGOUT', 11),
(82, '2021-05-19 00:47:26.830726', 0, 'LOGGED', 14),
(83, '2021-05-19 00:47:49.207531', 0, 'LOGOUT', 14),
(84, '2021-05-19 00:48:02.816792', 0, 'LOGGED', 15),
(85, '2021-05-19 00:48:11.729431', 0, 'LOGOUT', 15),
(86, '2021-05-19 00:48:33.050988', 0, 'LOGGED', 20),
(87, '2021-05-19 00:49:16.806543', 0, 'LOGOUT', 20),
(88, '2021-05-19 00:49:27.881007', 0, 'LOGGED', 10),
(89, '2021-05-19 00:49:39.464004', 0, 'LOGOUT', 10),
(90, '2021-05-19 00:51:28.662763', 0, 'LOGGED', 10),
(91, '2021-05-19 00:52:28.482155', 0, 'LOGOUT', 10),
(92, '2021-05-19 00:52:39.990991', 0, 'LOGGED', 11),
(93, '2021-05-19 00:53:07.242178', 0, 'LOGOUT', 11),
(94, '2021-05-19 00:53:18.058822', 0, 'LOGGED', 12),
(95, '2021-05-19 00:53:30.264055', 0, 'LOGOUT', 12),
(96, '2021-05-19 00:53:42.564910', 0, 'LOGGED', 20),
(97, '2021-05-19 00:53:48.920184', 0, 'LOGOUT', 20),
(98, '2021-05-19 00:53:58.092118', 0, 'LOGGED', 21),
(99, '2021-05-19 00:54:20.337123', 0, 'LOGOUT', 21),
(100, '2021-05-19 00:56:41.580398', 0, 'LOGGED', 21),
(101, '2021-05-19 00:58:31.605687', 0, 'LOGOUT', 21),
(102, '2021-05-19 01:00:02.941038', 0, 'LOGGED', 21),
(103, '2021-05-19 01:18:23.504479', 0, 'LOGGED', 1),
(104, '2021-05-19 01:24:32.949086', 0, 'LOGOUT', 1),
(105, '2021-05-15 23:48:26.116643', 0, 'LOGGED', 20),
(106, '2021-05-15 23:48:29.369970', 0, 'LOGOUT', 20),
(107, '2021-05-15 23:48:43.758187', 0, 'LOGGED', 21),
(108, '2021-05-15 23:48:45.718586', 0, 'LOGOUT', 21),
(109, '2021-05-15 23:49:00.057769', 0, 'LOGGED', 22),
(110, '2021-05-15 23:49:03.097242', 0, 'LOGOUT', 22),
(111, '2021-05-15 23:49:38.063105', 0, 'LOGGED', 1),
(112, '2021-05-15 23:50:00.347057', 0, 'LOGOUT', 1),
(113, '2021-05-15 23:50:19.135366', 0, 'LOGGED', 23),
(114, '2021-05-15 23:50:21.130385', 0, 'LOGOUT', 23),
(115, '2021-05-15 23:50:42.693020', 0, 'LOGGED', 1),
(116, '2021-05-15 23:51:38.757875', 0, 'LOGOUT', 1),
(117, '2021-05-15 23:51:53.293621', 0, 'LOGGED', 24),
(118, '2021-05-15 23:51:55.940387', 0, 'LOGOUT', 24),
(119, '2021-05-15 23:52:09.780581', 0, 'LOGGED', 25),
(120, '2021-05-15 23:52:11.720627', 0, 'LOGOUT', 25),
(121, '2021-05-15 23:53:02.230358', 0, 'LOGGED', 28),
(122, '2021-05-15 23:53:05.633592', 0, 'LOGOUT', 28),
(123, '2021-05-15 23:53:22.973439', 0, 'LOGGED', 29),
(124, '2021-05-15 23:53:25.242532', 0, 'LOGOUT', 29),
(125, '2021-05-15 23:53:42.108316', 0, 'LOGGED', 1),
(126, '2021-05-15 23:54:07.994890', 0, 'LOGOUT', 1),
(127, '2021-05-15 23:54:19.767821', 0, 'LOGGED', 27),
(128, '2021-05-15 23:54:21.619077', 0, 'LOGOUT', 27),
(129, '2021-05-15 23:54:33.550723', 0, 'LOGGED', 4),
(130, '2021-05-15 23:57:18.591574', 0, 'LOGOUT', 4),
(131, '2021-05-15 23:57:34.738311', 0, 'LOGGED', 4),
(132, '2021-05-15 23:58:55.271752', 0, 'LOGOUT', 4),
(133, '2021-05-15 23:59:08.162623', 0, 'LOGGED', 4),
(134, '2021-05-16 00:06:25.274896', 0, 'LOGOUT', 4),
(135, '2021-05-16 00:06:38.276183', 0, 'LOGGED', 9),
(136, '2021-05-16 00:19:00.567493', 0, 'LOGGED', 8),
(137, '2021-05-16 00:19:25.681654', 0, 'LOGOUT', 8),
(138, '2021-05-16 00:19:37.022177', 0, 'LOGGED', 7),
(139, '2021-05-16 00:22:26.874036', 0, 'LOGOUT', 7),
(140, '2021-05-16 00:22:47.964184', 0, 'LOGGED', 2),
(141, '2021-05-16 00:25:39.901746', 0, 'LOGOUT', 2),
(142, '2021-05-16 00:26:09.686125', 0, 'LOGGED', 26),
(143, '2021-05-16 00:30:37.818063', 0, 'LOGOUT', 26),
(144, '2021-05-16 00:30:55.083064', 0, 'LOGGED', 14),
(145, '2021-05-16 00:33:00.786808', 0, 'LOGOUT', 14),
(146, '2021-05-16 00:33:13.608583', 0, 'LOGGED', 2),
(147, '2021-05-16 00:40:15.257485', 0, 'LOGGED', 2),
(148, '2021-05-16 00:45:30.598739', 0, 'LOGGED', 2),
(149, '2021-05-16 00:51:54.581854', 0, 'LOGOUT', 2),
(150, '2021-05-16 00:57:42.265159', 0, 'LOGGED', 1),
(151, '2021-05-16 00:57:50.689843', 0, 'LOGOUT', 1),
(152, '2021-05-16 01:03:30.924031', 0, 'LOGGED', 6),
(153, '2021-05-16 01:04:10.736179', 0, 'LOGOUT', 6),
(154, '2021-05-16 01:04:29.450387', 0, 'LOGGED', 5),
(155, '2021-05-16 01:10:13.836787', 0, 'LOGOUT', 5),
(156, '2021-05-16 01:10:23.442679', 0, 'LOGGED', 6),
(157, '2021-05-16 01:10:34.635728', 0, 'LOGOUT', 6),
(158, '2021-05-16 17:38:30.003930', 0, 'LOGGED', 3),
(159, '2021-05-16 17:42:23.503699', 0, 'LOGOUT', 3),
(160, '2021-05-16 17:42:52.560856', 0, 'LOGGED', 18),
(161, '2021-05-16 17:44:22.264277', 0, 'LOGOUT', 18),
(162, '2021-05-16 17:44:43.749604', 0, 'LOGGED', 22),
(163, '2021-05-16 17:45:00.469837', 0, 'LOGOUT', 22),
(164, '2021-05-16 17:45:19.354191', 0, 'LOGGED', 7),
(165, '2021-05-16 17:46:46.476012', 0, 'LOGOUT', 7),
(166, '2021-05-16 17:47:11.333297', 0, 'LOGGED', 22),
(167, '2021-05-16 17:53:46.739495', 0, 'LOGOUT', 22),
(168, '2021-05-16 17:54:03.742340', 0, 'LOGGED', 19),
(169, '2021-05-16 17:56:06.231478', 0, 'LOGOUT', 19),
(170, '2021-05-16 17:56:16.703024', 0, 'LOGGED', 18),
(171, '2021-05-16 17:57:35.974583', 0, 'LOGOUT', 18),
(172, '2021-05-16 17:57:46.713943', 0, 'LOGGED', 17),
(173, '2021-05-16 18:01:33.807942', 0, 'LOGOUT', 17),
(174, '2021-05-16 18:01:44.020692', 0, 'LOGGED', 17),
(175, '2021-05-16 18:04:55.629873', 0, 'LOGOUT', 17),
(176, '2021-05-16 18:05:03.697010', 0, 'LOGGED', 1),
(177, '2021-05-16 18:09:48.197461', 0, 'LOGGED', 17),
(178, '2021-05-16 18:14:19.737304', 0, 'LOGOUT', 17),
(179, '2021-05-16 18:14:28.187014', 0, 'LOGGED', 1),
(180, '2021-05-16 18:16:31.297122', 0, 'LOGOUT', 1),
(181, '2021-05-16 18:16:41.777324', 0, 'LOGGED', 17),
(182, '2021-05-16 18:17:59.797312', 0, 'LOGOUT', 17),
(183, '2021-05-16 18:18:09.191937', 0, 'LOGGED', 2),
(184, '2021-05-16 18:18:31.040446', 0, 'LOGOUT', 2),
(185, '2021-05-21 00:00:30.724217', 0, 'LOGGED', 2),
(186, '2021-05-21 00:09:53.304887', 0, 'LOGOUT', 2),
(187, '2021-05-21 00:10:33.033951', 0, 'LOGGED', 19),
(188, '2021-05-21 00:23:27.028990', 0, 'LOGOUT', 19),
(189, '2021-05-21 00:23:37.819297', 0, 'LOGGED', 8),
(190, '2021-05-21 00:29:23.617505', 0, 'LOGOUT', 8),
(191, '2021-05-21 00:29:30.567144', 0, 'LOGGED', 1),
(192, '2021-05-21 01:26:10.862126', 0, 'LOGGED', 1),
(193, '2021-05-21 01:51:28.300633', 0, 'LOGGED', 1),
(194, '2021-05-21 02:33:09.723667', 0, 'LOGGED', 1),
(195, '2021-05-21 02:34:12.326188', 0, 'LOGOUT', 1),
(196, '2021-05-21 02:34:22.589851', 0, 'LOGGED', 19),
(197, '2021-05-15 02:37:16.114558', 0, 'LOGGED', 19),
(198, '2021-05-15 02:38:09.367184', 0, 'LOGOUT', 19),
(199, '2021-05-15 02:38:34.844641', 0, 'LOGGED', 6),
(200, '2021-05-16 21:01:48.902565', 0, 'LOGGED', 6),
(201, '2021-05-16 21:03:19.840108', 0, 'LOGOUT', 6),
(202, '2021-05-16 21:03:41.313734', 0, 'LOGGED', 20),
(203, '2021-05-16 21:03:52.833159', 0, 'LOGOUT', 20),
(204, '2021-05-16 21:07:10.631537', 0, 'LOGGED', 23),
(205, '2021-05-16 21:12:42.598128', 0, 'LOGOUT', 23),
(206, '2021-05-16 21:12:53.868142', 0, 'LOGGED', 19),
(207, '2021-05-16 21:14:41.914741', 0, 'LOGOUT', 19),
(208, '2021-05-16 21:14:56.283341', 0, 'LOGGED', 18),
(209, '2021-05-16 21:16:26.572469', 0, 'LOGOUT', 18),
(210, '2021-05-16 21:16:45.556131', 0, 'LOGGED', 2),
(211, '2021-05-16 21:16:59.871006', 0, 'LOGOUT', 2),
(212, '2021-05-16 21:17:10.669619', 0, 'LOGGED', 19),
(213, '2021-05-16 21:17:24.688532', 0, 'LOGOUT', 19),
(214, '2021-05-21 00:03:56.285640', 0, 'LOGGED', 2),
(215, '2021-05-21 00:06:05.521407', 0, 'LOGOUT', 2),
(216, '2021-05-20 23:58:48.287715', 0, 'LOGGED', 2),
(217, '2021-05-20 23:58:57.384210', 0, 'LOGOUT', 2),
(218, '2021-05-21 00:00:50.624488', 0, 'LOGGED', 2),
(219, '2021-05-21 00:04:01.513738', 0, 'LOGOUT', 2),
(220, '2021-05-21 00:04:22.844292', 0, 'LOGGED', 19),
(221, '2021-05-21 00:26:41.386970', 0, 'LOGOUT', 19),
(222, '2021-05-21 00:26:54.779636', 0, 'LOGGED', 6),
(223, '2021-05-21 00:27:15.776529', 0, 'LOGOUT', 6),
(224, '2021-05-16 21:58:03.663626', 0, 'LOGGED', 6),
(225, '2021-05-16 22:01:04.191610', 0, 'LOGOUT', 6),
(226, '2021-05-16 22:01:26.144964', 0, 'LOGGED', 24),
(227, '2021-05-16 22:02:52.121205', 0, 'LOGOUT', 24),
(228, '2021-05-16 22:03:02.783104', 0, 'LOGGED', 19),
(229, '2021-05-16 22:03:40.394121', 0, 'LOGOUT', 19),
(230, '2021-05-16 22:03:52.172128', 0, 'LOGGED', 18),
(231, '2021-05-16 22:04:22.740959', 0, 'LOGOUT', 18),
(232, '2021-05-16 22:05:31.998712', 0, 'LOGGED', 24),
(233, '2021-05-16 22:06:52.304395', 0, 'LOGOUT', 24),
(234, '2021-05-22 00:00:13.625954', 0, 'LOGGED', 2),
(235, '2021-05-22 00:01:05.136478', 0, 'LOGOUT', 2),
(236, '2021-05-22 00:01:26.516954', 0, 'LOGGED', 19),
(237, '2021-05-22 00:05:01.900571', 0, 'LOGOUT', 19),
(238, '2021-05-22 00:05:27.981714', 0, 'LOGGED', 6),
(239, '2021-05-22 00:05:39.654921', 0, 'LOGOUT', 6),
(240, '2021-05-16 22:17:35.899251', 0, 'LOGGED', 6),
(241, '2021-05-16 22:17:35.933160', 0, 'LOGGED', 6),
(242, '2021-05-16 22:17:59.391880', 0, 'LOGOUT', 6),
(243, '2021-05-16 22:18:09.165366', 0, 'LOGGED', 20),
(244, '2021-05-16 22:19:48.780152', 0, 'LOGOUT', 20),
(245, '2021-05-16 22:20:00.688064', 0, 'LOGGED', 10),
(246, '2021-05-16 22:20:27.167849', 0, 'LOGOUT', 10),
(247, '2021-05-16 22:20:37.570095', 0, 'LOGGED', 11),
(248, '2021-05-16 22:21:04.527334', 0, 'LOGOUT', 11),
(249, '2021-05-22 00:00:23.827058', 0, 'LOGGED', 2),
(250, '2021-05-22 00:32:12.868094', 0, 'LOGGED', 8),
(251, '2021-05-22 00:35:30.812737', 0, 'LOGOUT', 8),
(252, '2021-05-22 00:35:39.628593', 0, 'LOGGED', 2),
(253, '2021-05-22 00:35:43.467385', 0, 'LOGOUT', 2),
(254, '2021-05-22 00:35:51.709759', 0, 'LOGGED', 8),
(255, '2021-05-22 00:36:46.161695', 0, 'LOGOUT', 8),
(256, '2021-05-22 00:36:55.044194', 0, 'LOGGED', 10),
(257, '2021-05-22 00:37:11.224705', 0, 'LOGOUT', 10),
(258, '2021-05-22 00:37:20.444865', 0, 'LOGGED', 19),
(259, '2021-05-22 00:37:50.324050', 0, 'LOGOUT', 19),
(260, '2021-05-22 00:38:04.637817', 0, 'LOGGED', 21),
(261, '2021-05-22 00:58:37.900520', 0, 'LOGGED', 21),
(262, '2021-05-22 01:02:32.516320', 0, 'LOGGED', 21),
(263, '2021-05-22 01:02:53.558413', 0, 'LOGOUT', 21),
(264, '2021-05-22 01:03:11.905179', 0, 'LOGGED', 24),
(265, '2021-05-22 01:07:06.787419', 0, 'LOGGED', 24),
(266, '2021-05-22 01:09:35.880656', 0, 'LOGGED', 21),
(267, '2021-05-22 01:15:15.697224', 0, 'LOGGED', 21),
(268, '2021-05-22 01:18:41.715403', 0, 'LOGGED', 21),
(269, '2021-05-22 01:26:14.855612', 0, 'LOGGED', 24),
(270, '2021-05-22 01:26:27.618513', 0, 'LOGOUT', 24),
(271, '2021-05-22 01:26:37.194103', 0, 'LOGGED', 23),
(272, '2021-05-22 01:27:59.248790', 0, 'LOGGED', 24),
(273, '2021-05-22 01:28:04.686187', 0, 'LOGOUT', 24),
(274, '2021-05-22 01:28:12.956961', 0, 'LOGGED', 23),
(275, '2021-05-22 01:31:26.045330', 0, 'LOGOUT', 23),
(276, '2021-05-22 01:31:33.375253', 0, 'LOGGED', 2),
(277, '2021-05-22 01:53:29.865843', 0, 'LOGOUT', 2),
(278, '2021-05-22 01:53:38.568858', 0, 'LOGGED', 8),
(279, '2021-05-17 00:33:26.835661', 0, 'LOGGED', 6),
(280, '2021-05-17 00:35:12.515148', 0, 'LOGOUT', 6),
(281, '2021-05-17 00:35:41.964880', 0, 'LOGGED', 20),
(282, '2021-05-17 00:38:03.677918', 0, 'LOGOUT', 20),
(283, '2021-05-17 00:38:24.810100', 0, 'LOGGED', 10),
(284, '2021-05-17 00:39:05.837098', 0, 'LOGOUT', 10),
(285, '2021-05-17 00:39:20.436562', 0, 'LOGGED', 11),
(286, '2021-05-17 00:40:34.870614', 0, 'LOGOUT', 11),
(287, '2021-05-17 00:40:50.034069', 0, 'LOGGED', 11),
(288, '2021-05-17 00:41:12.180775', 0, 'LOGOUT', 11),
(289, '2021-05-23 00:00:22.116775', 0, 'LOGGED', 2),
(290, '2021-05-23 00:01:23.387222', 0, 'LOGOUT', 2),
(291, '2021-05-23 00:01:46.729303', 0, 'LOGGED', 10),
(292, '2021-05-23 00:02:29.065857', 0, 'LOGOUT', 10),
(293, '2021-05-23 00:02:41.482826', 0, 'LOGGED', 11),
(294, '2021-05-23 00:02:57.557079', 0, 'LOGOUT', 11),
(295, '2021-05-23 00:03:09.183894', 0, 'LOGGED', 9),
(296, '2021-05-23 00:03:52.035663', 0, 'LOGOUT', 9),
(297, '2021-05-23 00:04:05.097291', 0, 'LOGGED', 9),
(298, '2021-05-23 00:04:12.240700', 0, 'LOGOUT', 9),
(299, '2021-05-23 00:05:11.728517', 0, 'LOGGED', 8),
(300, '2021-05-23 00:05:21.563684', 0, 'LOGOUT', 8),
(301, '2021-05-23 00:05:31.901152', 0, 'LOGGED', 20),
(302, '2021-05-23 00:10:13.194292', 0, 'LOGGED', 20),
(303, '2021-05-23 00:14:48.870270', 0, 'LOGOUT', 20),
(304, '2021-05-23 00:15:22.804029', 0, 'LOGGED', 20),
(305, '2021-05-23 00:22:41.571353', 0, 'LOGGED', 20),
(306, '2021-05-23 00:24:56.625928', 0, 'LOGGED', 20),
(307, '2021-05-23 00:30:01.997419', 0, 'LOGGED', 20),
(308, '2021-05-23 00:32:52.899416', 0, 'LOGGED', 20),
(309, '2021-05-23 00:37:14.971810', 0, 'LOGOUT', 20),
(310, '2021-05-23 00:37:25.101956', 0, 'LOGGED', 2),
(311, '2021-05-23 00:38:11.792122', 0, 'LOGOUT', 2),
(312, '2021-05-23 00:38:32.210719', 0, 'LOGGED', 2),
(313, '2021-05-23 00:40:01.203633', 0, 'LOGOUT', 2),
(314, '2021-05-23 00:40:14.326940', 0, 'LOGGED', 10),
(315, '2021-05-23 00:41:41.169534', 0, 'LOGOUT', 10),
(316, '2021-05-23 00:41:50.364600', 0, 'LOGGED', 8),
(317, '2021-05-23 00:42:25.686103', 0, 'LOGOUT', 8),
(318, '2021-05-23 00:42:35.798532', 0, 'LOGGED', 10),
(319, '2021-05-23 00:43:57.459638', 0, 'LOGOUT', 10),
(320, '2021-05-23 00:44:09.585386', 0, 'LOGGED', 20),
(321, '2021-05-23 00:49:18.664420', 0, 'LOGGED', 20),
(322, '2021-05-23 00:52:24.878701', 0, 'LOGGED', 20),
(323, '2021-05-23 00:54:31.108804', 0, 'LOGGED', 20),
(324, '2021-05-23 00:57:31.254463', 0, 'LOGGED', 20),
(325, '2021-05-23 01:07:52.571242', 0, 'LOGOUT', 20),
(326, '2021-05-23 01:08:02.800537', 0, 'LOGGED', 10),
(327, '2021-05-23 01:10:28.605286', 0, 'LOGGED', 10),
(328, '2021-05-23 01:14:09.126306', 0, 'LOGGED', 10),
(329, '2021-05-23 01:23:15.195115', 0, 'LOGOUT', 10),
(330, '2021-05-23 01:23:25.462860', 0, 'LOGGED', 10),
(331, '2021-05-23 01:24:19.077428', 0, 'LOGOUT', 10),
(332, '2021-05-23 01:24:29.352080', 0, 'LOGGED', 10),
(333, '2021-05-23 01:27:59.633128', 0, 'LOGGED', 10),
(334, '2021-05-23 01:32:31.987937', 0, 'LOGOUT', 10),
(335, '2021-05-23 01:59:02.192350', 0, 'LOGGED', 1),
(336, '2021-05-23 01:59:07.968468', 0, 'LOGOUT', 1);

-- --------------------------------------------------------

--
-- Table structure for table `vessel`
--

DROP TABLE IF EXISTS `vessel`;
CREATE TABLE IF NOT EXISTS `vessel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `imo_number` varchar(255) DEFAULT NULL,
  `live_dead` varchar(255) DEFAULT NULL,
  `mmsi_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nod02uh55wjgwi44jexdx4keb` (`code`),
  UNIQUE KEY `UK_e8sx4hsxmmbvj5oqulbk230oo` (`imo_number`),
  UNIQUE KEY `UK_6g8sqgq783t9vky6c5d8wvirn` (`mmsi_number`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vessel`
--

INSERT INTO `vessel` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `code`, `country`, `imo_number`, `live_dead`, `mmsi_number`, `name`) VALUES
(1, '2021-05-13 22:22:13.295163', 'inspector1', '2021-05-13 22:22:13.295163', 'inspector1', 'LKC210000', 'LBR', '9498389 ', 'ACTIVE', '636018141', 'AAL PUSAN'),
(2, '2021-05-13 22:24:41.586687', 'inspector1', '2021-05-13 22:24:41.586687', 'inspector1', 'LKC210001', 'RUS', '8724327 ', 'ACTIVE', '273342630', 'KAPITAN KOLESNIKOV'),
(3, '2021-05-13 22:26:17.872035', 'inspector1', '2021-05-13 22:26:17.872035', 'inspector1', 'LKC210002', 'MLT', '9605279 ', 'ACTIVE', '229626000', 'MSC AMALFI'),
(4, '2021-05-13 22:27:58.280203', 'inspector1', '2021-05-13 22:27:58.280203', 'inspector1', 'LKC210003', 'MHL', '9548835  ', 'ACTIVE', '538007655', 'STAR DALMATIA'),
(5, '2021-05-13 22:29:26.385946', 'inspector1', '2021-05-13 22:29:26.385946', 'inspector1', 'LKC210004', 'HKG', '9622617', 'ACTIVE', '477222700', 'OOCL FRANCE'),
(6, '2021-05-13 22:31:02.723891', 'inspector1', '2021-05-13 22:31:02.723891', 'inspector1', 'LKC210005', 'SIN', '9840714 ', 'ACTIVE', '563087600', 'MAERSK SIHANOUKVILLE'),
(7, '2021-05-13 22:32:39.501269', 'inspector1', '2021-05-13 22:32:39.501269', 'inspector1', 'LKC210006', 'MHL', '9489297', 'ACTIVE', '538006517', 'OLYMPIC SKY'),
(8, '2021-05-13 22:34:18.782283', 'inspector1', '2021-05-13 22:34:18.782283', 'inspector1', 'LKC210007', 'PAN', '9700445 ', 'ACTIVE', '372653000', 'SUN APOLLON'),
(9, '2021-05-13 22:35:37.180147', 'inspector1', '2021-05-13 22:35:37.180147', 'inspector1', 'LKC210008', 'PAN', '9326079', 'ACTIVE', '371522000', 'TRANS FUTURE'),
(10, '2021-05-13 22:37:08.554086', 'inspector1', '2021-05-13 22:37:08.554086', 'inspector1', 'LKC210009', 'PAN', '9732448', 'ACTIVE', '352834000', 'BUNUN JUSTICE'),
(11, '2021-05-13 22:38:11.447807', 'inspector1', '2021-05-13 22:38:11.447807', 'inspector1', 'LKC210010', 'PHI', '7824613', 'ACTIVE', '548819200', 'SPAN ASIA'),
(12, '2021-05-13 22:39:27.158859', 'inspector1', '2021-05-13 22:39:27.158859', 'inspector1', 'LKC210011', 'PHI', '9042764', 'ACTIVE', '548398100', 'ST. LEO THE GREAT'),
(13, '2021-05-13 22:40:43.297208', 'inspector1', '2021-05-13 22:40:43.297208', 'inspector1', 'LKC210012', '', '9528902', 'ACTIVE', '236732000', 'ASTER ALVAR'),
(14, '2021-05-13 22:42:09.023052', 'inspector1', '2021-05-13 22:42:09.023052', 'inspector1', 'LKC210013', 'MHL', '9440966', 'ACTIVE', '538006663', 'KAPTA MATHIOS'),
(15, '2021-05-13 22:43:08.275357', 'inspector1', '2021-05-13 22:43:08.275357', 'inspector1', 'LKC210014', 'PAN', '9444261', 'ACTIVE', '356565000', 'MOL PREMIUM'),
(16, '2021-05-13 22:45:48.668365', 'inspector1', '2021-05-13 22:45:48.668365', 'inspector1', 'LKC210015', 'MHL', '9360271', 'ACTIVE', '538004461', 'CAPE MAYOR'),
(17, '2021-05-13 22:50:54.680676', 'inspector1', '2021-05-13 22:50:54.680676', 'inspector1', 'LKC210016', 'MLT', '9189770', 'ACTIVE', '215802000', 'CHRISTINA IV'),
(18, '2021-05-13 22:52:48.325976', 'inspector1', '2021-05-13 22:52:48.325976', 'inspector1', 'LKC210017', 'MHL', '9289855', 'ACTIVE', '538004435', 'ALBERTITO'),
(19, '2021-05-13 22:55:54.370588', 'inspector1', '2021-05-13 22:55:54.370588', 'inspector1', 'LKC210018', 'LBR', '9146314', 'ACTIVE', '636014699', 'DIAMANTIS P'),
(20, '2021-05-13 22:57:34.645763', 'inspector1', '2021-05-13 22:57:34.645763', 'inspector1', 'LKC210019', 'NED', '9721633', 'ACTIVE', '244850226', 'SYMPHONY SKY'),
(21, '2021-05-13 22:58:51.547060', 'inspector1', '2021-05-13 22:58:51.547060', 'inspector1', 'LKC210020', 'NED', '9466362', 'ACTIVE', '246865000', 'AVONBORG'),
(22, '2021-05-13 22:59:59.017348', 'inspector1', '2021-05-13 22:59:59.017348', 'inspector1', 'LKC210021', 'PAN', '9796573', 'ACTIVE', '371523000', 'MEGA BENEFIT'),
(23, '2021-05-13 23:01:27.593933', 'inspector1', '2021-05-13 23:01:27.593933', 'inspector1', 'LKC210022', 'PAN', '9858022', 'ACTIVE', '374883000', 'FJ VIOLA'),
(24, '2021-05-13 23:02:50.042266', 'inspector1', '2021-05-13 23:02:50.042266', 'inspector1', 'LKC210023', 'LBR', '9300283', 'ACTIVE', '636019774', 'OCEANIC LEADER'),
(25, '2021-05-13 23:04:05.835575', 'inspector1', '2021-05-13 23:04:05.835575', 'inspector1', 'LKC210024', 'THA', '9796274', 'ACTIVE', '567571000', 'JARU BHUM'),
(26, '2021-05-13 23:05:31.960438', 'inspector1', '2021-05-13 23:05:31.960438', 'inspector1', 'LKC210025', 'LBR', '9389112', 'ACTIVE', '636013467', 'FANOULA'),
(27, '2021-05-13 23:06:24.703189', 'inspector1', '2021-05-13 23:06:24.703189', 'inspector1', 'LKC210026', 'LBR', '9161297', 'ACTIVE', '636018318', 'MSC PAOLA'),
(28, '2021-05-13 23:07:32.418071', 'inspector1', '2021-05-13 23:07:32.418071', 'inspector1', 'LKC210027', 'HKG', '9617935', 'ACTIVE', '477024700', 'MIN SHENG '),
(29, '2021-05-13 23:08:36.163525', 'inspector1', '2021-05-13 23:08:36.163525', 'inspector1', 'LKC210028', 'NIG', '9067984', 'ACTIVE', '656755000', 'JUYANDEH'),
(30, '2021-05-13 23:10:42.581227', 'inspector1', '2021-05-13 23:10:42.581227', 'inspector1', 'LKC210029', 'HKG', '9300790', 'ACTIVE', '477105600', 'OOCL ASIA');

-- --------------------------------------------------------

--
-- Table structure for table `vessel_arrival_history`
--

DROP TABLE IF EXISTS `vessel_arrival_history`;
CREATE TABLE IF NOT EXISTS `vessel_arrival_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `anchorage_date_and_time` datetime(6) DEFAULT NULL,
  `anchorage_terminal` varchar(255) DEFAULT NULL,
  `captain_name` varchar(255) DEFAULT NULL,
  `cargo_tonnage` varchar(255) DEFAULT NULL,
  `next_harbour` varchar(255) DEFAULT NULL,
  `number_of_crew_members` varchar(255) DEFAULT NULL,
  `number_of_passengers` varchar(255) DEFAULT NULL,
  `one_previous_harbour_name` varchar(255) DEFAULT NULL,
  `purpose_of_visit` varchar(255) DEFAULT NULL,
  `sailing_date` date DEFAULT NULL,
  `three_previous_harbour_name` varchar(255) DEFAULT NULL,
  `two_previous_harbour_name` varchar(255) DEFAULT NULL,
  `vessel_departure_arrival_status` varchar(255) DEFAULT NULL,
  `ship_agent_id` int(11) DEFAULT NULL,
  `vessel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnelgjorikl6rip40bo15txm6a` (`ship_agent_id`),
  KEY `FK9dcmodba1k4hmedd8bdkamhp2` (`vessel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vessel_arrival_history`
--

INSERT INTO `vessel_arrival_history` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `anchorage_date_and_time`, `anchorage_terminal`, `captain_name`, `cargo_tonnage`, `next_harbour`, `number_of_crew_members`, `number_of_passengers`, `one_previous_harbour_name`, `purpose_of_visit`, `sailing_date`, `three_previous_harbour_name`, `two_previous_harbour_name`, `vessel_departure_arrival_status`, `ship_agent_id`, `vessel_id`) VALUES
(1, '2021-05-15 10:30:40.836468', 'inspector2', '2021-05-15 21:12:19.904643', 'inspector2', '2021-05-15 10:30:00.000000', 'CICT', 'David Garricvoz', '200', 'Male - Maldives', '22', '40', 'Cal Mep - Vietnam', 'Trading', '2021-05-22', 'Chabang - Thailand ', 'Piraeus - Greece', 'DP', 1, 1),
(2, '2021-05-15 21:11:44.409799', 'inspector2', '2021-05-16 17:46:42.367873', 'inspector2', '2021-05-15 21:11:00.000000', 'SAGT', 'Jeorge Warner', '215', 'Colon - Panama', '24', '42', 'Mumbai - India', 'Trading', '2021-05-20', 'Klang - Malaysia', 'Yangoon - Myanmar', 'DP', 2, 2),
(3, '2021-05-16 17:46:26.864439', 'inspector2', '2021-05-16 17:46:33.884071', 'inspector2', '2021-05-16 17:46:00.000000', 'ECT', 'Oliver Salonan', '195', 'Male - Maldives', '25', '35', 'Fuzhou - China', 'Trading', '2021-05-23', 'Benteng - Indonesia', 'Tokyo - Japan', 'AR', 3, 3),
(4, '2021-05-16 21:02:57.786704', 'inspector1', '2021-05-16 22:17:52.193282', 'inspector1', '2021-05-16 21:02:00.000000', 'UCT', 'Henry Faulkner', '200', 'Rizhao - China', '25', '35', 'Mumbai - India', 'Trading', '2021-05-22', 'Salalah - Oman', 'Pelepas - Malaysia', NULL, 4, 4),
(5, '2021-05-16 22:00:54.723364', 'inspector1', '2021-05-17 00:34:43.488625', 'inspector1', '2021-05-16 21:59:00.000000', 'GP ', 'Saif Guptha', '210', 'Colon - Panama', '30', '40', 'Manila - Philiphene', 'Trading', '2021-05-23', 'Chabang - Thailand ', 'Pelepas - Malaysia', 'AR', 5, 5),
(6, '2021-05-17 00:34:37.371062', 'inspector1', '2021-05-17 00:34:44.577578', 'inspector1', '2021-05-17 00:34:00.000000', 'UCT', 'Fedrick Hampton', '210', 'Male - Maldives', '30', '50', 'Manila - Philiphene', 'Trading', '2021-05-24', 'Klang - Malaysia', 'Yangoon - Myanmar', 'AR', 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `vessel_order`
--

DROP TABLE IF EXISTS `vessel_order`;
CREATE TABLE IF NOT EXISTS `vessel_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `closing_date` date NOT NULL,
  `number` varchar(255) NOT NULL,
  `vessel_order_status` varchar(255) DEFAULT NULL,
  `vessel_arrival_history_id` int(11) DEFAULT NULL,
  `warehouse_block_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9hircwnu9ccdwv3fx1a6vwqk2` (`number`),
  KEY `FKqtk165wd8b4bnq1ur6rv14opv` (`vessel_arrival_history_id`),
  KEY `FK2ck5n3h0siy2r90qdhqbgja7y` (`warehouse_block_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vessel_order`
--

INSERT INTO `vessel_order` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `closing_date`, `number`, `vessel_order_status`, `vessel_arrival_history_id`, `warehouse_block_id`) VALUES
(1, '2021-05-15 16:14:58.681288', 'shipagent3', '2021-05-20 01:06:06.275904', 'superintendent2', '2021-05-20', 'SLCO210000', 'APPROVE', 1, 1),
(4, '2021-05-15 22:00:32.054425', 'shipagent2', '2021-05-19 00:30:09.444023', 'superintendent1', '2021-05-19', 'SLCO210001', 'APPROVE', 2, 2),
(5, '2021-05-16 17:53:21.475017', 'shipagent3', '2021-05-21 00:08:34.737072', 'superintendent1', '2021-05-21', 'SLCO210002', 'APPROVE', 3, 3),
(6, '2021-05-16 21:12:37.196322', 'shipagent4', '2021-05-21 00:03:45.471995', 'superintendent1', '2021-05-21', 'SLCO210003', 'APPROVE', 4, 4),
(7, '2021-05-16 22:02:41.922635', 'shipagent5', '2021-05-22 00:00:59.158384', 'superintendent1', '2021-05-22', 'SLCO210004', 'APPROVE', 5, 6),
(8, '2021-05-16 22:19:32.133648', 'shipagent1', '2021-05-23 00:38:05.914452', 'superintendent1', '2021-05-22', 'SLCO210005', 'APPROVE', 5, 7),
(9, '2021-05-17 00:37:45.379287', 'shipagent1', '2021-05-23 00:01:16.504004', 'superintendent1', '2021-05-23', 'SLCO210006', 'APPROVE', 6, 8);

-- --------------------------------------------------------

--
-- Table structure for table `vessel_order_item`
--

DROP TABLE IF EXISTS `vessel_order_item`;
CREATE TABLE IF NOT EXISTS `vessel_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `quantity` varchar(255) NOT NULL,
  `vessel_order_item_status` varchar(255) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `vessel_order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeh154txh65l5uposleest7998` (`item_id`),
  KEY `FKsiuj02o55n4hayrhyj7pp796o` (`vessel_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vessel_order_item`
--

INSERT INTO `vessel_order_item` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `quantity`, `vessel_order_item_status`, `item_id`, `vessel_order_id`) VALUES
(1, '2021-05-15 16:14:58.693256', 'shipagent3', '2021-05-15 16:14:58.693256', 'shipagent3', '100', 'PROCESSING', 6, 1),
(2, '2021-05-15 16:14:58.736882', 'shipagent3', '2021-05-15 16:14:58.736882', 'shipagent3', '100', 'PROCESSING', 7, 1),
(3, '2021-05-15 16:14:58.739873', 'shipagent3', '2021-05-15 16:14:58.739873', 'shipagent3', '30', 'PROCESSING', 12, 1),
(4, '2021-05-15 16:14:58.760645', 'shipagent3', '2021-05-15 16:14:58.760645', 'shipagent3', '30', 'PROCESSING', 16, 1),
(5, '2021-05-15 16:14:58.762670', 'shipagent3', '2021-05-15 16:14:58.762670', 'shipagent3', '50', 'PROCESSING', 25, 1),
(6, '2021-05-15 16:14:58.763807', 'shipagent3', '2021-05-15 16:14:58.763807', 'shipagent3', '100', 'PROCESSING', 43, 1),
(7, '2021-05-15 16:14:58.766804', 'shipagent3', '2021-05-15 16:14:58.766804', 'shipagent3', '50', 'PROCESSING', 32, 1),
(8, '2021-05-15 16:14:58.768798', 'shipagent3', '2021-05-15 16:14:58.768798', 'shipagent3', '20', 'PROCESSING', 69, 1),
(9, '2021-05-15 16:14:58.770792', 'shipagent3', '2021-05-15 16:14:58.770792', 'shipagent3', '10', 'PROCESSING', 63, 1),
(10, '2021-05-15 16:14:58.772190', 'shipagent3', '2021-05-15 16:14:58.772190', 'shipagent3', '100', 'PROCESSING', 89, 1),
(11, '2021-05-15 16:14:58.774188', 'shipagent3', '2021-05-15 16:14:58.774188', 'shipagent3', '50', 'PROCESSING', 30, 1),
(12, '2021-05-15 16:14:58.776183', 'shipagent3', '2021-05-15 16:14:58.776183', 'shipagent3', '60', 'PROCESSING', 110, 1),
(13, '2021-05-15 16:14:58.777376', 'shipagent3', '2021-05-15 16:14:58.777376', 'shipagent3', '150', 'PROCESSING', 229, 1),
(14, '2021-05-15 22:00:32.070378', 'shipagent2', '2021-05-15 22:00:32.070378', 'shipagent2', '50', 'PROCESSING', 1, 4),
(15, '2021-05-15 22:00:32.070378', 'shipagent2', '2021-05-15 22:00:32.070378', 'shipagent2', '50', 'PROCESSING', 4, 4),
(16, '2021-05-15 22:00:32.070378', 'shipagent2', '2021-05-15 22:00:32.070378', 'shipagent2', '50', 'PROCESSING', 6, 4),
(17, '2021-05-15 22:00:32.078373', 'shipagent2', '2021-05-15 22:00:32.078373', 'shipagent2', '50', 'PROCESSING', 8, 4),
(18, '2021-05-15 22:00:32.078373', 'shipagent2', '2021-05-15 22:00:32.078373', 'shipagent2', '50', 'PROCESSING', 13, 4),
(19, '2021-05-15 22:00:32.078373', 'shipagent2', '2021-05-15 22:00:32.078373', 'shipagent2', '50', 'PROCESSING', 21, 4),
(20, '2021-05-15 22:00:32.078373', 'shipagent2', '2021-05-15 22:00:32.078373', 'shipagent2', '50', 'PROCESSING', 39, 4),
(21, '2021-05-15 22:00:32.086367', 'shipagent2', '2021-05-15 22:00:32.086367', 'shipagent2', '50', 'PROCESSING', 26, 4),
(22, '2021-05-15 22:00:32.086367', 'shipagent2', '2021-05-15 22:00:32.086367', 'shipagent2', '50', 'PROCESSING', 46, 4),
(23, '2021-05-15 22:00:32.086367', 'shipagent2', '2021-05-15 22:00:32.086367', 'shipagent2', '50', 'PROCESSING', 38, 4),
(24, '2021-05-15 22:00:32.086367', 'shipagent2', '2021-05-15 22:00:32.086367', 'shipagent2', '50', 'PROCESSING', 62, 4),
(25, '2021-05-15 22:00:32.094362', 'shipagent2', '2021-05-15 22:00:32.094362', 'shipagent2', '10', 'PROCESSING', 72, 4),
(26, '2021-05-15 22:00:32.094362', 'shipagent2', '2021-05-15 22:00:32.094362', 'shipagent2', '50', 'PROCESSING', 83, 4),
(27, '2021-05-15 22:00:32.094362', 'shipagent2', '2021-05-15 22:00:32.094362', 'shipagent2', '50', 'PROCESSING', 82, 4),
(28, '2021-05-15 22:00:32.094362', 'shipagent2', '2021-05-15 22:00:32.094362', 'shipagent2', '50', 'PROCESSING', 81, 4),
(29, '2021-05-15 22:00:32.102357', 'shipagent2', '2021-05-15 22:00:32.102357', 'shipagent2', '40', 'PROCESSING', 109, 4),
(30, '2021-05-15 22:00:32.102357', 'shipagent2', '2021-05-15 22:00:32.102357', 'shipagent2', '20', 'PROCESSING', 157, 4),
(31, '2021-05-15 22:00:32.102357', 'shipagent2', '2021-05-15 22:00:32.102357', 'shipagent2', '20', 'PROCESSING', 177, 4),
(32, '2021-05-15 22:00:32.102357', 'shipagent2', '2021-05-15 22:00:32.102357', 'shipagent2', '20', 'PROCESSING', 140, 4),
(33, '2021-05-15 22:00:32.110351', 'shipagent2', '2021-05-15 22:00:32.110351', 'shipagent2', '10', 'PROCESSING', 152, 4),
(34, '2021-05-15 22:00:32.110351', 'shipagent2', '2021-05-15 22:00:32.110351', 'shipagent2', '10', 'PROCESSING', 158, 4),
(35, '2021-05-15 22:00:32.110351', 'shipagent2', '2021-05-15 22:00:32.110351', 'shipagent2', '25', 'PROCESSING', 212, 4),
(36, '2021-05-15 22:00:32.110351', 'shipagent2', '2021-05-15 22:00:32.110351', 'shipagent2', '10', 'PROCESSING', 219, 4),
(37, '2021-05-15 22:00:32.110351', 'shipagent2', '2021-05-15 22:00:32.110351', 'shipagent2', '10', 'PROCESSING', 228, 4),
(38, '2021-05-16 17:53:21.482998', 'shipagent3', '2021-05-16 17:53:21.482998', 'shipagent3', '25', 'PROCESSING', 3, 5),
(39, '2021-05-16 17:53:21.484874', 'shipagent3', '2021-05-16 17:53:21.484874', 'shipagent3', '25', 'PROCESSING', 7, 5),
(40, '2021-05-16 17:53:21.486495', 'shipagent3', '2021-05-16 17:53:21.486495', 'shipagent3', '25', 'PROCESSING', 11, 5),
(41, '2021-05-16 17:53:21.488493', 'shipagent3', '2021-05-16 17:53:21.488493', 'shipagent3', '10', 'PROCESSING', 16, 5),
(42, '2021-05-16 17:53:21.490488', 'shipagent3', '2021-05-16 17:53:21.490488', 'shipagent3', '10', 'PROCESSING', 15, 5),
(43, '2021-05-16 17:53:21.492482', 'shipagent3', '2021-05-16 17:53:21.492482', 'shipagent3', '10', 'PROCESSING', 23, 5),
(44, '2021-05-16 17:53:21.494477', 'shipagent3', '2021-05-16 17:53:21.494477', 'shipagent3', '25', 'PROCESSING', 26, 5),
(45, '2021-05-16 17:53:21.497471', 'shipagent3', '2021-05-16 17:53:21.497471', 'shipagent3', '10', 'PROCESSING', 29, 5),
(46, '2021-05-16 17:53:21.499464', 'shipagent3', '2021-05-16 17:53:21.499464', 'shipagent3', '10', 'PROCESSING', 32, 5),
(47, '2021-05-16 17:53:21.500461', 'shipagent3', '2021-05-16 17:53:21.500461', 'shipagent3', '25', 'PROCESSING', 43, 5),
(48, '2021-05-16 17:53:21.502455', 'shipagent3', '2021-05-16 17:53:21.502455', 'shipagent3', '20', 'PROCESSING', 40, 5),
(49, '2021-05-16 17:53:21.504450', 'shipagent3', '2021-05-16 17:53:21.504450', 'shipagent3', '10', 'PROCESSING', 37, 5),
(50, '2021-05-16 17:53:21.506445', 'shipagent3', '2021-05-16 17:53:21.506445', 'shipagent3', '3', 'PROCESSING', 72, 5),
(51, '2021-05-16 17:53:21.507667', 'shipagent3', '2021-05-16 17:53:21.507667', 'shipagent3', '20', 'PROCESSING', 81, 5),
(52, '2021-05-16 17:53:21.509665', 'shipagent3', '2021-05-16 17:53:21.509665', 'shipagent3', '20', 'PROCESSING', 87, 5),
(53, '2021-05-16 17:53:21.512700', 'shipagent3', '2021-05-16 17:53:21.512700', 'shipagent3', '40', 'PROCESSING', 73, 5),
(54, '2021-05-16 17:53:21.514655', 'shipagent3', '2021-05-16 17:53:21.514655', 'shipagent3', '25', 'PROCESSING', 99, 5),
(55, '2021-05-16 17:53:21.515652', 'shipagent3', '2021-05-16 17:53:21.515652', 'shipagent3', '20', 'PROCESSING', 226, 5),
(56, '2021-05-16 21:12:37.204302', 'shipagent4', '2021-05-16 21:12:37.204302', 'shipagent4', '50', 'PROCESSING', 1, 6),
(57, '2021-05-16 21:12:37.207293', 'shipagent4', '2021-05-16 21:12:37.207293', 'shipagent4', '50', 'PROCESSING', 4, 6),
(58, '2021-05-16 21:12:37.208847', 'shipagent4', '2021-05-16 21:12:37.208847', 'shipagent4', '50', 'PROCESSING', 6, 6),
(59, '2021-05-16 21:12:37.210371', 'shipagent4', '2021-05-16 21:12:37.210371', 'shipagent4', '25', 'PROCESSING', 13, 6),
(60, '2021-05-16 21:12:37.212025', 'shipagent4', '2021-05-16 21:12:37.212025', 'shipagent4', '10', 'PROCESSING', 7, 6),
(61, '2021-05-16 21:12:37.215021', 'shipagent4', '2021-05-16 21:12:37.215021', 'shipagent4', '15', 'PROCESSING', 12, 6),
(62, '2021-05-16 21:12:37.217016', 'shipagent4', '2021-05-16 21:12:37.217016', 'shipagent4', '20', 'PROCESSING', 10, 6),
(63, '2021-05-16 21:12:37.219013', 'shipagent4', '2021-05-16 21:12:37.219013', 'shipagent4', '150', 'PROCESSING', 23, 6),
(64, '2021-05-16 21:12:37.220010', 'shipagent4', '2021-05-16 21:12:37.220010', 'shipagent4', '50', 'PROCESSING', 27, 6),
(65, '2021-05-16 21:12:37.221988', 'shipagent4', '2021-05-16 21:12:37.221988', 'shipagent4', '20', 'PROCESSING', 36, 6),
(66, '2021-05-16 21:12:37.223987', 'shipagent4', '2021-05-16 21:12:37.223987', 'shipagent4', '50', 'PROCESSING', 48, 6),
(67, '2021-05-16 21:12:37.225981', 'shipagent4', '2021-05-16 21:12:37.225981', 'shipagent4', '10', 'PROCESSING', 34, 6),
(68, '2021-05-16 21:12:37.228973', 'shipagent4', '2021-05-16 21:12:37.228973', 'shipagent4', '10', 'PROCESSING', 32, 6),
(69, '2021-05-16 21:12:37.231966', 'shipagent4', '2021-05-16 21:12:37.231966', 'shipagent4', '10', 'PROCESSING', 40, 6),
(70, '2021-05-16 21:12:37.233960', 'shipagent4', '2021-05-16 21:12:37.233960', 'shipagent4', '20', 'PROCESSING', 82, 6),
(71, '2021-05-16 21:12:37.236987', 'shipagent4', '2021-05-16 21:12:37.236987', 'shipagent4', '30', 'PROCESSING', 74, 6),
(72, '2021-05-16 21:12:37.238947', 'shipagent4', '2021-05-16 21:12:37.238947', 'shipagent4', '30', 'PROCESSING', 93, 6),
(73, '2021-05-16 21:12:37.240945', 'shipagent4', '2021-05-16 21:12:37.240945', 'shipagent4', '50', 'PROCESSING', 44, 6),
(74, '2021-05-16 21:12:37.242937', 'shipagent4', '2021-05-16 21:12:37.242937', 'shipagent4', '20', 'PROCESSING', 108, 6),
(75, '2021-05-16 21:12:37.244933', 'shipagent4', '2021-05-16 21:12:37.244933', 'shipagent4', '20', 'PROCESSING', 165, 6),
(76, '2021-05-16 21:12:37.246926', 'shipagent4', '2021-05-16 21:12:37.246926', 'shipagent4', '20', 'PROCESSING', 177, 6),
(77, '2021-05-16 21:12:37.247924', 'shipagent4', '2021-05-16 21:12:37.247924', 'shipagent4', '10', 'PROCESSING', 172, 6),
(78, '2021-05-16 21:12:37.250916', 'shipagent4', '2021-05-16 21:12:37.250916', 'shipagent4', '60', 'PROCESSING', 227, 6),
(79, '2021-05-16 21:12:37.253906', 'shipagent4', '2021-05-16 21:12:37.253906', 'shipagent4', '10', 'PROCESSING', 226, 6),
(80, '2021-05-16 22:02:41.933914', 'shipagent5', '2021-05-16 22:06:33.409873', 'shipagent5', '50', 'PROCESSING', 1, 7),
(81, '2021-05-16 22:02:41.933914', 'shipagent5', '2021-05-16 22:06:33.417838', 'shipagent5', '50', 'PROCESSING', 4, 7),
(82, '2021-05-16 22:02:41.933914', 'shipagent5', '2021-05-16 22:06:33.417838', 'shipagent5', '50', 'PROCESSING', 6, 7),
(83, '2021-05-16 22:02:41.937913', 'shipagent5', '2021-05-16 22:06:33.417838', 'shipagent5', '50', 'PROCESSING', 9, 7),
(84, '2021-05-16 22:02:41.937913', 'shipagent5', '2021-05-16 22:06:33.417838', 'shipagent5', '50', 'PROCESSING', 12, 7),
(85, '2021-05-16 22:19:32.139600', 'shipagent1', '2021-05-16 22:19:32.139600', 'shipagent1', '25', 'PROCESSING', 1, 8),
(86, '2021-05-16 22:19:32.141595', 'shipagent1', '2021-05-16 22:19:32.141595', 'shipagent1', '30', 'PROCESSING', 3, 8),
(87, '2021-05-16 22:19:32.143590', 'shipagent1', '2021-05-16 22:19:32.143590', 'shipagent1', '35', 'PROCESSING', 6, 8),
(88, '2021-05-16 22:19:32.145585', 'shipagent1', '2021-05-16 22:19:32.145585', 'shipagent1', '40', 'PROCESSING', 15, 8),
(89, '2021-05-16 22:19:32.146968', 'shipagent1', '2021-05-16 22:19:32.146968', 'shipagent1', '45', 'PROCESSING', 23, 8),
(90, '2021-05-16 22:19:32.148966', 'shipagent1', '2021-05-16 22:19:32.148966', 'shipagent1', '50', 'PROCESSING', 21, 8),
(91, '2021-05-17 00:37:45.387264', 'shipagent1', '2021-05-17 00:37:45.387264', 'shipagent1', '25', 'PROCESSING', 1, 9),
(92, '2021-05-17 00:37:45.389258', 'shipagent1', '2021-05-17 00:37:45.389258', 'shipagent1', '30', 'PROCESSING', 2, 9),
(93, '2021-05-17 00:37:45.391257', 'shipagent1', '2021-05-17 00:37:45.391257', 'shipagent1', '25', 'PROCESSING', 3, 9),
(94, '2021-05-17 00:37:45.395243', 'shipagent1', '2021-05-17 00:37:45.395243', 'shipagent1', '30', 'PROCESSING', 4, 9),
(95, '2021-05-17 00:37:45.398236', 'shipagent1', '2021-05-17 00:37:45.398236', 'shipagent1', '25', 'PROCESSING', 5, 9),
(96, '2021-05-17 00:37:45.400232', 'shipagent1', '2021-05-17 00:37:45.400232', 'shipagent1', '30', 'PROCESSING', 6, 9),
(97, '2021-05-17 00:37:45.401226', 'shipagent1', '2021-05-17 00:37:45.401226', 'shipagent1', '25', 'PROCESSING', 7, 9);

-- --------------------------------------------------------

--
-- Table structure for table `vessel_order_item_bid`
--

DROP TABLE IF EXISTS `vessel_order_item_bid`;
CREATE TABLE IF NOT EXISTS `vessel_order_item_bid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `bid_valid_or_not` varchar(255) DEFAULT NULL,
  `unit_price` decimal(10,2) NOT NULL,
  `chandler_id` int(11) DEFAULT NULL,
  `vessel_order_item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2g51ydn9sjxitx6wu8ogw9ykj` (`chandler_id`),
  KEY `FKr4njribv43o0d0aycnoj07792` (`vessel_order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vessel_order_item_bid`
--

INSERT INTO `vessel_order_item_bid` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `amount`, `bid_valid_or_not`, `unit_price`, `chandler_id`, `vessel_order_item_id`) VALUES
(153, '2021-05-16 21:14:39.186322', 'chandler10', '2021-05-21 00:03:39.931974', 'superintendent1', '37500.00', 'REJECT', '750.00', 10, 56),
(154, '2021-05-16 21:14:39.190315', 'chandler10', '2021-05-21 00:03:39.934966', 'superintendent1', '50000.00', 'REJECT', '1000.00', 10, 57),
(155, '2021-05-16 21:14:39.192307', 'chandler10', '2021-05-21 00:03:39.936964', 'superintendent1', '47500.00', 'REJECT', '950.00', 10, 58),
(156, '2021-05-16 21:14:39.194301', 'chandler10', '2021-05-21 00:03:39.936964', 'superintendent1', '3750.00', 'SELECT', '150.00', 10, 59),
(157, '2021-05-16 21:14:39.206791', 'chandler10', '2021-05-21 00:03:39.939953', 'superintendent1', '9000.00', 'REJECT', '900.00', 10, 60),
(158, '2021-05-16 21:14:39.208791', 'chandler10', '2021-05-21 00:03:39.940952', 'superintendent1', '2250.00', 'SELECT', '150.00', 10, 61),
(159, '2021-05-16 21:14:39.210784', 'chandler10', '2021-05-21 00:03:39.941950', 'superintendent1', '9000.00', 'SELECT', '450.00', 10, 62),
(160, '2021-05-16 21:14:39.212173', 'chandler10', '2021-05-21 00:03:39.943943', 'superintendent1', '22500.00', 'SELECT', '150.00', 10, 63),
(161, '2021-05-16 21:14:39.214207', 'chandler10', '2021-05-21 00:03:39.947933', 'superintendent1', '22500.00', 'SELECT', '450.00', 10, 64),
(162, '2021-05-16 21:14:39.216167', 'chandler10', '2021-05-21 00:03:39.949925', 'superintendent1', '16000.00', 'SELECT', '800.00', 10, 65),
(163, '2021-05-16 21:14:39.217459', 'chandler10', '2021-05-21 00:03:39.953916', 'superintendent1', '7500.00', 'REJECT', '150.00', 10, 66),
(164, '2021-05-16 21:14:39.219458', 'chandler10', '2021-05-21 00:03:39.955911', 'superintendent1', '10000.00', 'REJECT', '1000.00', 10, 67),
(165, '2021-05-16 21:14:39.220455', 'chandler10', '2021-05-21 00:03:39.957906', 'superintendent1', '6000.00', 'REJECT', '600.00', 10, 68),
(166, '2021-05-16 21:14:39.222450', 'chandler10', '2021-05-21 00:03:39.959900', 'superintendent1', '5000.00', 'REJECT', '500.00', 10, 69),
(167, '2021-05-16 21:14:39.224446', 'chandler10', '2021-05-21 00:03:39.959900', 'superintendent1', '4000.00', 'REJECT', '200.00', 10, 70),
(168, '2021-05-16 21:14:39.226438', 'chandler10', '2021-05-21 00:03:39.961895', 'superintendent1', '4500.00', 'REJECT', '150.00', 10, 71),
(169, '2021-05-16 21:14:39.227468', 'chandler10', '2021-05-21 00:03:39.963890', 'superintendent1', '5700.00', 'REJECT', '190.00', 10, 72),
(170, '2021-05-16 21:14:39.229032', 'chandler10', '2021-05-21 00:03:39.964889', 'superintendent1', '5000.00', 'SELECT', '100.00', 10, 73),
(171, '2021-05-16 21:14:39.231029', 'chandler10', '2021-05-21 00:03:39.966882', 'superintendent1', '20000.00', 'SELECT', '1000.00', 10, 74),
(172, '2021-05-16 21:14:39.232027', 'chandler10', '2021-05-21 00:03:39.969873', 'superintendent1', '900.00', 'REJECT', '45.00', 10, 75),
(173, '2021-05-16 21:14:39.234025', 'chandler10', '2021-05-21 00:03:39.970870', 'superintendent1', '7000.00', 'SELECT', '350.00', 10, 76),
(174, '2021-05-16 21:14:39.236017', 'chandler10', '2021-05-21 00:03:39.971868', 'superintendent1', '400.00', 'SELECT', '40.00', 10, 77),
(175, '2021-05-16 21:14:39.237360', 'chandler10', '2021-05-21 00:03:39.974862', 'superintendent1', '12000.00', 'REJECT', '200.00', 10, 78),
(176, '2021-05-16 21:14:39.239359', 'chandler10', '2021-05-21 00:03:39.975857', 'superintendent1', '25000.00', 'SELECT', '2500.00', 10, 79),
(177, '2021-05-16 21:16:23.091301', 'chandler9', '2021-05-21 00:03:39.922001', 'superintendent1', '32500.00', 'SELECT', '650.00', 8, 56),
(178, '2021-05-16 21:16:23.092332', 'chandler9', '2021-05-21 00:03:39.932972', 'superintendent1', '45000.00', 'SELECT', '900.00', 8, 57),
(179, '2021-05-16 21:16:23.093801', 'chandler9', '2021-05-21 00:03:39.935964', 'superintendent1', '45000.00', 'SELECT', '900.00', 8, 58),
(180, '2021-05-16 21:16:23.095799', 'chandler9', '2021-05-21 00:03:39.937961', 'superintendent1', '3750.00', 'REJECT', '150.00', 8, 59),
(181, '2021-05-16 21:16:23.096797', 'chandler9', '2021-05-21 00:03:39.938956', 'superintendent1', '8000.00', 'SELECT', '800.00', 8, 60),
(182, '2021-05-16 21:16:23.098791', 'chandler9', '2021-05-21 00:03:39.941950', 'superintendent1', '2250.00', 'REJECT', '150.00', 8, 61),
(183, '2021-05-16 21:16:23.100786', 'chandler9', '2021-05-21 00:03:39.942946', 'superintendent1', '10000.00', 'REJECT', '500.00', 8, 62),
(184, '2021-05-16 21:16:23.102781', 'chandler9', '2021-05-21 00:03:39.946935', 'superintendent1', '22500.00', 'REJECT', '150.00', 8, 63),
(185, '2021-05-16 21:16:23.103777', 'chandler9', '2021-05-21 00:03:39.949925', 'superintendent1', '25000.00', 'REJECT', '500.00', 8, 64),
(186, '2021-05-16 21:16:23.105510', 'chandler9', '2021-05-21 00:03:39.950924', 'superintendent1', '18000.00', 'REJECT', '900.00', 8, 65),
(187, '2021-05-16 21:16:23.106939', 'chandler9', '2021-05-21 00:03:39.951923', 'superintendent1', '4000.00', 'SELECT', '80.00', 8, 66),
(188, '2021-05-16 21:16:23.108937', 'chandler9', '2021-05-21 00:03:39.954921', 'superintendent1', '5000.00', 'SELECT', '500.00', 8, 67),
(189, '2021-05-16 21:16:23.109870', 'chandler9', '2021-05-21 00:03:39.956910', 'superintendent1', '5500.00', 'SELECT', '550.00', 8, 68),
(190, '2021-05-16 21:16:23.111868', 'chandler9', '2021-05-21 00:03:39.958902', 'superintendent1', '4000.00', 'SELECT', '400.00', 8, 69),
(191, '2021-05-16 21:16:23.113863', 'chandler9', '2021-05-21 00:03:39.959900', 'superintendent1', '3000.00', 'SELECT', '150.00', 8, 70),
(192, '2021-05-16 21:16:23.114891', 'chandler9', '2021-05-21 00:03:39.960899', 'superintendent1', '3000.00', 'SELECT', '100.00', 8, 71),
(193, '2021-05-16 21:16:23.116855', 'chandler9', '2021-05-21 00:03:39.963890', 'superintendent1', '5400.00', 'SELECT', '180.00', 8, 72),
(194, '2021-05-16 21:16:23.118854', 'chandler9', '2021-05-21 00:03:39.965885', 'superintendent1', '10000.00', 'REJECT', '200.00', 8, 73),
(195, '2021-05-16 21:16:23.120844', 'chandler9', '2021-05-21 00:03:39.967879', 'superintendent1', '24000.00', 'REJECT', '1200.00', 8, 74),
(196, '2021-05-16 21:16:23.121438', 'chandler9', '2021-05-21 00:03:39.968878', 'superintendent1', '700.00', 'SELECT', '35.00', 8, 75),
(197, '2021-05-16 21:16:23.123440', 'chandler9', '2021-05-21 00:03:39.970870', 'superintendent1', '7600.00', 'REJECT', '380.00', 8, 76),
(198, '2021-05-16 21:16:23.124434', 'chandler9', '2021-05-21 00:03:39.972867', 'superintendent1', '450.00', 'REJECT', '45.00', 8, 77),
(199, '2021-05-16 21:16:23.126430', 'chandler9', '2021-05-21 00:03:39.973863', 'superintendent1', '10800.00', 'SELECT', '180.00', 8, 78),
(200, '2021-05-16 21:16:23.127426', 'chandler9', '2021-05-21 00:03:39.975857', 'superintendent1', '26000.00', 'REJECT', '2600.00', 8, 79),
(201, '2021-05-16 22:03:36.373171', 'chandler10', '2021-05-22 00:00:53.969860', 'superintendent1', '25000.00', 'SELECT', '500.00', 10, 80),
(202, '2021-05-16 22:03:36.377174', 'chandler10', '2021-05-22 00:00:53.973881', 'superintendent1', '50000.00', 'REJECT', '1000.00', 10, 81),
(203, '2021-05-16 22:03:36.377174', 'chandler10', '2021-05-22 00:00:53.973881', 'superintendent1', '25000.00', 'SELECT', '500.00', 10, 82),
(204, '2021-05-16 22:03:36.381172', 'chandler10', '2021-05-22 00:00:53.975845', 'superintendent1', '50000.00', 'REJECT', '1000.00', 10, 83),
(205, '2021-05-16 22:03:36.381172', 'chandler10', '2021-05-22 00:00:53.975845', 'superintendent1', '25000.00', 'SELECT', '500.00', 10, 84),
(206, '2021-05-16 22:04:15.671347', 'chandler9', '2021-05-22 00:00:53.972886', 'superintendent1', '50000.00', 'REJECT', '1000.00', 8, 80),
(207, '2021-05-16 22:04:15.671347', 'chandler9', '2021-05-22 00:00:53.972886', 'superintendent1', '25000.00', 'SELECT', '500.00', 8, 81),
(208, '2021-05-16 22:04:15.675342', 'chandler9', '2021-05-22 00:00:53.974879', 'superintendent1', '50000.00', 'REJECT', '1000.00', 8, 82),
(209, '2021-05-16 22:04:15.675342', 'chandler9', '2021-05-22 00:00:53.974879', 'superintendent1', '25000.00', 'SELECT', '500.00', 8, 83),
(210, '2021-05-16 22:04:15.679373', 'chandler9', '2021-05-22 00:00:53.976874', 'superintendent1', '50000.00', 'REJECT', '1000.00', 8, 84),
(211, '2021-05-16 22:20:24.706550', 'chandler1', '2021-05-23 00:38:01.596142', 'superintendent1', '12500.00', 'SELECT', '500.00', 1, 85),
(212, '2021-05-16 22:20:24.711537', 'chandler1', '2021-05-23 00:38:01.601130', 'superintendent1', '30000.00', 'REJECT', '1000.00', 1, 86),
(213, '2021-05-16 22:20:24.714000', 'chandler1', '2021-05-23 00:38:01.602127', 'superintendent1', '17500.00', 'SELECT', '500.00', 1, 87),
(214, '2021-05-16 22:20:24.715995', 'chandler1', '2021-05-23 00:38:01.603126', 'superintendent1', '40000.00', 'REJECT', '1000.00', 1, 88),
(215, '2021-05-16 22:20:24.717989', 'chandler1', '2021-05-23 00:38:01.604122', 'superintendent1', '22500.00', 'SELECT', '500.00', 1, 89),
(216, '2021-05-16 22:20:24.720447', 'chandler1', '2021-05-23 00:38:01.606116', 'superintendent1', '50000.00', 'REJECT', '1000.00', 1, 90),
(217, '2021-05-16 22:21:00.730239', 'chandler2', '2021-05-23 00:38:01.598136', 'superintendent1', '25000.00', 'REJECT', '1000.00', 2, 85),
(218, '2021-05-16 22:21:00.731499', 'chandler2', '2021-05-23 00:38:01.600133', 'superintendent1', '15000.00', 'SELECT', '500.00', 2, 86),
(219, '2021-05-16 22:21:00.733498', 'chandler2', '2021-05-23 00:38:01.602127', 'superintendent1', '35000.00', 'REJECT', '1000.00', 2, 87),
(220, '2021-05-16 22:21:00.735493', 'chandler2', '2021-05-23 00:38:01.603126', 'superintendent1', '20000.00', 'SELECT', '500.00', 2, 88),
(221, '2021-05-16 22:21:00.738484', 'chandler2', '2021-05-23 00:38:01.605118', 'superintendent1', '45000.00', 'REJECT', '1000.00', 2, 89),
(222, '2021-05-16 22:21:00.741476', 'chandler2', '2021-05-23 00:38:01.605118', 'superintendent1', '25000.00', 'SELECT', '500.00', 2, 90),
(223, '2021-05-17 00:39:02.214430', 'chandler1', '2021-05-23 00:01:02.849518', 'superintendent1', '12500.00', 'SELECT', '500.00', 1, 91),
(224, '2021-05-17 00:39:02.217422', 'chandler1', '2021-05-23 00:01:02.852507', 'superintendent1', '30000.00', 'REJECT', '1000.00', 1, 92),
(225, '2021-05-17 00:39:02.220413', 'chandler1', '2021-05-23 00:01:02.852507', 'superintendent1', '12500.00', 'SELECT', '500.00', 1, 93),
(226, '2021-05-17 00:39:02.222412', 'chandler1', '2021-05-23 00:01:02.853504', 'superintendent1', '30000.00', 'REJECT', '1000.00', 1, 94),
(227, '2021-05-17 00:39:02.224226', 'chandler1', '2021-05-23 00:01:02.854501', 'superintendent1', '12500.00', 'SELECT', '500.00', 1, 95),
(228, '2021-05-17 00:39:02.226225', 'chandler1', '2021-05-23 00:01:02.856499', 'superintendent1', '30000.00', 'REJECT', '1000.00', 1, 96),
(229, '2021-05-17 00:39:02.227557', 'chandler1', '2021-05-23 00:01:02.857494', 'superintendent1', '12500.00', 'SELECT', '500.00', 1, 97),
(230, '2021-05-17 00:39:48.990693', 'chandler2', '2021-05-23 00:01:02.850513', 'superintendent1', '25000.00', 'REJECT', '1000.00', 2, 91),
(231, '2021-05-17 00:39:48.992655', 'chandler2', '2021-05-23 00:01:02.851509', 'superintendent1', '15000.00', 'SELECT', '500.00', 2, 92),
(232, '2021-05-17 00:39:48.994648', 'chandler2', '2021-05-23 00:01:02.852507', 'superintendent1', '25000.00', 'REJECT', '1000.00', 2, 93),
(233, '2021-05-17 00:39:48.997641', 'chandler2', '2021-05-23 00:01:02.853504', 'superintendent1', '15000.00', 'SELECT', '500.00', 2, 94),
(234, '2021-05-17 00:39:48.999635', 'chandler2', '2021-05-23 00:01:02.855501', 'superintendent1', '25000.00', 'REJECT', '1000.00', 2, 95),
(235, '2021-05-17 00:39:49.002627', 'chandler2', '2021-05-23 00:01:02.856499', 'superintendent1', '15000.00', 'SELECT', '500.00', 2, 96),
(236, '2021-05-17 00:39:49.003625', 'chandler2', '2021-05-23 00:01:02.857494', 'superintendent1', '25000.00', 'REJECT', '1000.00', 2, 97);

-- --------------------------------------------------------

--
-- Table structure for table `vessel_order_item_bid_payment`
--

DROP TABLE IF EXISTS `vessel_order_item_bid_payment`;
CREATE TABLE IF NOT EXISTS `vessel_order_item_bid_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `vessel_order_item_bid_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkq75emf8rbnkdbkoh6982wyer` (`payment_id`),
  KEY `FK1g06i459bwb4ory3j9ecughph` (`vessel_order_item_bid_id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vessel_order_item_bid_payment`
--

INSERT INTO `vessel_order_item_bid_payment` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `payment_status`, `payment_id`, `vessel_order_item_bid_id`) VALUES
(153, '2021-05-21 00:03:40.154374', 'superintendent1', '2021-05-21 00:03:40.154374', 'superintendent1', 'ITEMNR', 7, 177),
(154, '2021-05-21 00:03:40.177452', 'superintendent1', '2021-05-21 00:03:40.177452', 'superintendent1', 'ITEMNR', 7, 178),
(155, '2021-05-21 00:03:40.221659', 'superintendent1', '2021-05-21 00:03:40.221659', 'superintendent1', 'ITEMNR', 7, 179),
(156, '2021-05-21 00:03:40.265767', 'superintendent1', '2021-05-21 00:03:40.265767', 'superintendent1', 'ITEMNR', 7, 181),
(157, '2021-05-21 00:03:40.290831', 'superintendent1', '2021-05-21 00:03:40.290831', 'superintendent1', 'ITEMNR', 7, 187),
(158, '2021-05-21 00:03:40.310252', 'superintendent1', '2021-05-21 00:03:40.310252', 'superintendent1', 'ITEMNR', 7, 188),
(159, '2021-05-21 00:03:40.333712', 'superintendent1', '2021-05-21 00:03:40.333712', 'superintendent1', 'ITEMNR', 7, 189),
(160, '2021-05-21 00:03:40.353538', 'superintendent1', '2021-05-21 00:03:40.353538', 'superintendent1', 'ITEMNR', 7, 190),
(161, '2021-05-21 00:03:40.378452', 'superintendent1', '2021-05-21 00:03:40.378452', 'superintendent1', 'ITEMNR', 7, 191),
(162, '2021-05-21 00:03:40.397599', 'superintendent1', '2021-05-21 00:03:40.397599', 'superintendent1', 'ITEMNR', 7, 192),
(163, '2021-05-21 00:03:40.422542', 'superintendent1', '2021-05-21 00:03:40.422542', 'superintendent1', 'ITEMNR', 7, 193),
(164, '2021-05-21 00:03:40.442043', 'superintendent1', '2021-05-21 00:03:40.442043', 'superintendent1', 'ITEMNR', 7, 196),
(165, '2021-05-21 00:03:40.467471', 'superintendent1', '2021-05-21 00:03:40.467471', 'superintendent1', 'ITEMNR', 7, 199),
(166, '2021-05-21 00:03:43.269285', 'superintendent1', '2021-05-21 00:03:43.269285', 'superintendent1', 'ITEMNR', 8, 156),
(167, '2021-05-21 00:03:43.312447', 'superintendent1', '2021-05-21 00:03:43.312447', 'superintendent1', 'ITEMNR', 8, 158),
(168, '2021-05-21 00:03:43.332031', 'superintendent1', '2021-05-21 00:03:43.332031', 'superintendent1', 'ITEMNR', 8, 159),
(169, '2021-05-21 00:03:43.355693', 'superintendent1', '2021-05-21 00:03:43.355693', 'superintendent1', 'ITEMNR', 8, 160),
(170, '2021-05-21 00:03:43.376374', 'superintendent1', '2021-05-21 00:03:43.376374', 'superintendent1', 'ITEMNR', 8, 161),
(171, '2021-05-21 00:03:43.400126', 'superintendent1', '2021-05-21 00:03:43.400126', 'superintendent1', 'ITEMNR', 8, 162),
(172, '2021-05-21 00:03:43.420605', 'superintendent1', '2021-05-21 00:03:43.420605', 'superintendent1', 'ITEMNR', 8, 170),
(173, '2021-05-21 00:03:43.445143', 'superintendent1', '2021-05-21 00:03:43.445143', 'superintendent1', 'ITEMNR', 8, 171),
(174, '2021-05-21 00:03:43.464812', 'superintendent1', '2021-05-21 00:03:43.464812', 'superintendent1', 'ITEMNR', 8, 173),
(175, '2021-05-21 00:03:43.488885', 'superintendent1', '2021-05-21 00:03:43.488885', 'superintendent1', 'ITEMNR', 8, 174),
(176, '2021-05-21 00:03:43.509278', 'superintendent1', '2021-05-21 00:03:43.509278', 'superintendent1', 'ITEMNR', 8, 176),
(177, '2021-05-22 00:00:54.174764', 'superintendent1', '2021-05-22 00:34:41.995972', 'guard1', 'NOTPAID', 9, 201),
(178, '2021-05-22 00:00:54.273620', 'superintendent1', '2021-05-22 00:34:42.035306', 'guard1', 'NOTPAID', 9, 203),
(179, '2021-05-22 00:00:54.310021', 'superintendent1', '2021-05-22 00:34:42.061465', 'guard1', 'NOTPAID', 9, 205),
(180, '2021-05-22 00:00:56.952746', 'superintendent1', '2021-05-22 00:34:36.301035', 'guard1', 'NOTPAID', 10, 207),
(181, '2021-05-22 00:00:56.997188', 'superintendent1', '2021-05-22 00:34:36.326234', 'guard1', 'NOTPAID', 10, 209),
(182, '2021-05-23 00:01:03.330618', 'superintendent1', '2021-05-23 00:49:27.052438', 'shipagent1', 'PAID', 12, 223),
(183, '2021-05-23 00:01:03.544841', 'superintendent1', '2021-05-23 00:49:27.090356', 'shipagent1', 'PAID', 12, 225),
(184, '2021-05-23 00:01:03.777177', 'superintendent1', '2021-05-23 00:49:27.118923', 'shipagent1', 'PAID', 12, 227),
(185, '2021-05-23 00:01:03.890875', 'superintendent1', '2021-05-23 00:49:27.144972', 'shipagent1', 'PAID', 12, 229),
(186, '2021-05-23 00:01:10.481577', 'superintendent1', '2021-05-23 00:44:58.101725', 'shipagent1', 'PAID', 13, 231),
(187, '2021-05-23 00:01:10.526498', 'superintendent1', '2021-05-23 00:44:58.133085', 'shipagent1', 'PAID', 13, 233),
(188, '2021-05-23 00:01:10.582062', 'superintendent1', '2021-05-23 00:44:58.176951', 'shipagent1', 'PAID', 13, 235),
(189, '2021-05-23 00:38:01.744190', 'superintendent1', '2021-05-23 00:38:01.744190', 'superintendent1', 'ITEMNR', 16, 211),
(190, '2021-05-23 00:38:01.813671', 'superintendent1', '2021-05-23 00:38:01.813671', 'superintendent1', 'ITEMNR', 16, 213),
(191, '2021-05-23 00:38:01.853896', 'superintendent1', '2021-05-23 00:38:01.853896', 'superintendent1', 'ITEMNR', 16, 215),
(192, '2021-05-23 00:38:03.976605', 'superintendent1', '2021-05-23 00:38:03.976605', 'superintendent1', 'ITEMNR', 17, 218),
(193, '2021-05-23 00:38:04.001496', 'superintendent1', '2021-05-23 00:38:04.001496', 'superintendent1', 'ITEMNR', 17, 220),
(194, '2021-05-23 00:38:04.019449', 'superintendent1', '2021-05-23 00:38:04.019449', 'superintendent1', 'ITEMNR', 17, 222);

-- --------------------------------------------------------

--
-- Table structure for table `warehouse_block`
--

DROP TABLE IF EXISTS `warehouse_block`;
CREATE TABLE IF NOT EXISTS `warehouse_block` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `warehouse_block_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `warehouse_block`
--

INSERT INTO `warehouse_block` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `area`, `name`, `warehouse_block_status`) VALUES
(1, '2021-05-13 23:13:33.615767', 'inspector1', '2021-05-15 16:14:58.842848', 'shipagent3', '1200', 'SAGT1', 'UNAVAILABLE'),
(2, '2021-05-13 23:13:44.448991', 'inspector1', '2021-05-15 22:00:32.176394', 'shipagent2', '1300', 'SAGT2', 'UNAVAILABLE'),
(3, '2021-05-13 23:13:54.731235', 'inspector1', '2021-05-16 17:53:21.579768', 'shipagent3', '1300', 'SAGT3', 'UNAVAILABLE'),
(4, '2021-05-13 23:14:07.410638', 'inspector1', '2021-05-16 21:12:37.308817', 'shipagent4', '1100', 'SAGT4', 'UNAVAILABLE'),
(5, '2021-05-13 23:14:21.747832', 'inspector1', '2021-05-16 22:02:42.019007', 'shipagent5', '1200', 'SAGT5', 'UNAVAILABLE'),
(6, '2021-05-13 23:14:34.796125', 'inspector1', '2021-05-16 22:06:33.522496', 'shipagent5', '1400', 'CICT1', 'UNAVAILABLE'),
(7, '2021-05-13 23:14:45.473746', 'inspector1', '2021-05-16 22:19:32.222683', 'shipagent1', '1400', 'CICT2', 'UNAVAILABLE'),
(8, '2021-05-13 23:14:55.458249', 'inspector1', '2021-05-17 00:37:45.472208', 'shipagent1', '1400', 'CICT3', 'UNAVAILABLE'),
(9, '2021-05-13 23:15:08.677557', 'inspector1', '2021-05-13 23:15:08.677557', 'inspector1', '1300', 'CICT4', 'AVAILABLE'),
(10, '2021-05-13 23:15:23.189575', 'inspector1', '2021-05-13 23:15:23.189575', 'inspector1', '1400', 'CICT5', 'AVAILABLE'),
(11, '2021-05-13 23:15:55.787332', 'inspector1', '2021-05-13 23:15:55.787332', 'inspector1', '1300', 'ECT001', 'AVAILABLE'),
(12, '2021-05-13 23:16:12.315442', 'inspector1', '2021-05-13 23:16:12.315442', 'inspector1', '1300', 'ECT002', 'AVAILABLE'),
(13, '2021-05-13 23:16:24.837182', 'inspector1', '2021-05-13 23:16:24.837182', 'inspector1', '1500', 'ECT003', 'AVAILABLE'),
(14, '2021-05-13 23:16:35.959846', 'inspector1', '2021-05-13 23:16:35.959846', 'inspector1', '1500', 'ECT004', 'AVAILABLE'),
(15, '2021-05-13 23:16:54.018577', 'inspector1', '2021-05-13 23:16:54.018577', 'inspector1', '1400', 'ECT005', 'AVAILABLE'),
(16, '2021-05-13 23:17:28.591620', 'inspector1', '2021-05-13 23:17:28.591620', 'inspector1', '1200', 'UCT001 ', 'AVAILABLE'),
(17, '2021-05-13 23:17:38.367369', 'inspector1', '2021-05-13 23:17:38.367369', 'inspector1', '1300', 'UCT002', 'AVAILABLE'),
(18, '2021-05-13 23:17:49.546587', 'inspector1', '2021-05-13 23:17:49.546587', 'inspector1', '1400', 'UCT003', 'AVAILABLE'),
(19, '2021-05-13 23:18:01.597092', 'inspector1', '2021-05-13 23:18:01.597092', 'inspector1', '1200', 'UCT004', 'AVAILABLE'),
(20, '2021-05-13 23:18:17.530663', 'inspector1', '2021-05-13 23:18:17.530663', 'inspector1', '1200', 'UCT005', 'AVAILABLE'),
(21, '2021-05-13 23:18:34.429326', 'inspector1', '2021-05-13 23:18:34.429326', 'inspector1', '1200', 'JCT001', 'AVAILABLE'),
(22, '2021-05-13 23:18:45.344306', 'inspector1', '2021-05-13 23:18:45.344306', 'inspector1', '1400', 'JCT002', 'AVAILABLE'),
(23, '2021-05-13 23:18:58.508583', 'inspector1', '2021-05-13 23:18:58.508583', 'inspector1', '1300', 'JCT003', 'AVAILABLE'),
(24, '2021-05-13 23:19:16.606547', 'inspector1', '2021-05-13 23:19:16.606547', 'inspector1', '1300', 'JCT004', 'AVAILABLE'),
(25, '2021-05-13 23:19:30.893627', 'inspector1', '2021-05-13 23:19:30.893627', 'inspector1', '1400', 'JCT005', 'AVAILABLE'),
(26, '2021-05-13 23:19:50.402405', 'inspector1', '2021-05-13 23:19:50.402405', 'inspector1', '1300', 'Guide Pier 001', 'AVAILABLE'),
(27, '2021-05-13 23:19:59.018556', 'inspector1', '2021-05-13 23:19:59.018556', 'inspector1', '1300', 'Guide Pier 002', 'AVAILABLE'),
(28, '2021-05-13 23:20:09.267983', 'inspector1', '2021-05-13 23:20:09.267983', 'inspector1', '1400', 'Guide Pier 003', 'AVAILABLE'),
(29, '2021-05-13 23:20:24.417818', 'inspector1', '2021-05-13 23:20:24.417818', 'inspector1', '1300', 'Guide Pier 004', 'AVAILABLE'),
(30, '2021-05-13 23:20:34.306124', 'inspector1', '2021-05-13 23:20:34.306124', 'inspector1', '1400', 'Guide Pier 005', 'AVAILABLE');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chandler_license`
--
ALTER TABLE `chandler_license`
  ADD CONSTRAINT `FKaxhkbuqrs02tgql9mo3brj78e` FOREIGN KEY (`chandler_id`) REFERENCES `chandler` (`id`);

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FK2n9w8d0dp4bsfra9dcg0046l4` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FK16n6xlg9q36nr1gr20xa18fq` FOREIGN KEY (`chandler_id`) REFERENCES `chandler` (`id`),
  ADD CONSTRAINT `FK7im12jxxs7hxtrq76hx0j0xm` FOREIGN KEY (`vessel_order_id`) REFERENCES `vessel_order` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK3wsl4duq3n5imh005r68f3uar` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`);

--
-- Constraints for table `user_details_chandler`
--
ALTER TABLE `user_details_chandler`
  ADD CONSTRAINT `FK6yrao9pbhc3gtheav4rcn6eis` FOREIGN KEY (`chandler_id`) REFERENCES `chandler` (`id`),
  ADD CONSTRAINT `FKbhbadv1ggct6se2qsno7o8g0s` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`);

--
-- Constraints for table `user_details_files`
--
ALTER TABLE `user_details_files`
  ADD CONSTRAINT `FK14snsy54cro4dn8wnfq17vlmi` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`);

--
-- Constraints for table `user_details_ship_agent`
--
ALTER TABLE `user_details_ship_agent`
  ADD CONSTRAINT `FK2s3omti8a6t2nikuc9j2oq9tw` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`),
  ADD CONSTRAINT `FK68mr6f0up9omcjdoupxsnpyfj` FOREIGN KEY (`ship_agent_id`) REFERENCES `ship_agent` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Constraints for table `user_session_log`
--
ALTER TABLE `user_session_log`
  ADD CONSTRAINT `FKrhb4wune1hnnhdsbiah2ojo5l` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `vessel_arrival_history`
--
ALTER TABLE `vessel_arrival_history`
  ADD CONSTRAINT `FK9dcmodba1k4hmedd8bdkamhp2` FOREIGN KEY (`vessel_id`) REFERENCES `vessel` (`id`),
  ADD CONSTRAINT `FKnelgjorikl6rip40bo15txm6a` FOREIGN KEY (`ship_agent_id`) REFERENCES `ship_agent` (`id`);

--
-- Constraints for table `vessel_order`
--
ALTER TABLE `vessel_order`
  ADD CONSTRAINT `FK2ck5n3h0siy2r90qdhqbgja7y` FOREIGN KEY (`warehouse_block_id`) REFERENCES `warehouse_block` (`id`),
  ADD CONSTRAINT `FKqtk165wd8b4bnq1ur6rv14opv` FOREIGN KEY (`vessel_arrival_history_id`) REFERENCES `vessel_arrival_history` (`id`);

--
-- Constraints for table `vessel_order_item`
--
ALTER TABLE `vessel_order_item`
  ADD CONSTRAINT `FKeh154txh65l5uposleest7998` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `FKsiuj02o55n4hayrhyj7pp796o` FOREIGN KEY (`vessel_order_id`) REFERENCES `vessel_order` (`id`);

--
-- Constraints for table `vessel_order_item_bid`
--
ALTER TABLE `vessel_order_item_bid`
  ADD CONSTRAINT `FK2g51ydn9sjxitx6wu8ogw9ykj` FOREIGN KEY (`chandler_id`) REFERENCES `chandler` (`id`),
  ADD CONSTRAINT `FKr4njribv43o0d0aycnoj07792` FOREIGN KEY (`vessel_order_item_id`) REFERENCES `vessel_order_item` (`id`);

--
-- Constraints for table `vessel_order_item_bid_payment`
--
ALTER TABLE `vessel_order_item_bid_payment`
  ADD CONSTRAINT `FK1g06i459bwb4ory3j9ecughph` FOREIGN KEY (`vessel_order_item_bid_id`) REFERENCES `vessel_order_item_bid` (`id`),
  ADD CONSTRAINT `FKkq75emf8rbnkdbkoh6982wyer` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
