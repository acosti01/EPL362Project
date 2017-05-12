-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 12, 2017 at 10:59 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arkalam`
--
CREATE DATABASE IF NOT EXISTS `EPL362DB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `EPL362DB`;

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `id` mediumint(9) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `patient` mediumint(9) DEFAULT NULL,
  `clinician` mediumint(9) DEFAULT NULL,
  `clinic` text,
  `time` varchar(255) DEFAULT NULL,
  `type` text,
  `status` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`id`, `date`, `patient`, `clinician`, `clinic`, `time`, `type`, `status`) VALUES
(1, '2017-08-08', 200037, 200011, 'lorem', '14:34:19', 'PRE_ARRANGED', 'SHOW_UP'),
(2, '2018-11-12', 200033, 200029, 'Vestibulum', '15:59:13', 'DROP_IN', 'NOT_SHOW_UP'),
(3, '2019-02-19', 200045, 200086, 'sollicitudin', '19:19:32', 'PRE_ARRANGED', 'SHOW_UP'),
(4, '2018-04-03', 200059, 200049, 'Sed', '19:18:05', 'DROP_IN', 'NOT_SHOW_UP'),
(5, '2019-02-27', 200084, 200010, 'et,', '22:11:35', 'PRE_ARRANGED', 'SHOW_UP'),
(6, '2018-07-18', 200081, 200027, 'turpis.', '05:24:59', 'DROP_IN', 'NOT_SHOW_UP'),
(7, '2018-08-12', 200033, 200056, 'primis', '17:44:43', 'PRE_ARRANGED', 'SHOW_UP'),
(8, '2019-07-17', 200066, 200062, 'blandit', '20:23:38', 'DROP_IN', 'NOT_SHOW_UP'),
(9, '2018-02-06', 200025, 200002, 'Mauris', '09:06:52', 'PRE_ARRANGED', 'SHOW_UP'),
(10, '2019-10-05', 200067, 200010, 'sapien', '04:28:25', 'DROP_IN', 'NOT_SHOW_UP'),
(11, '2018-11-04', 200027, 200048, 'in', '16:01:43', 'PRE_ARRANGED', 'SHOW_UP'),
(12, '2019-10-27', 200090, 200044, 'diam.', '22:03:27', 'DROP_IN', 'NOT_SHOW_UP'),
(13, '2019-06-28', 200029, 200082, 'vel', '12:31:14', 'PRE_ARRANGED', 'SHOW_UP'),
(14, '2019-01-26', 200004, 200090, 'purus,', '21:10:28', 'DROP_IN', 'NOT_SHOW_UP'),
(15, '2017-10-30', 200024, 200058, 'neque', '02:33:58', 'PRE_ARRANGED', 'SHOW_UP'),
(16, '2020-01-26', 200009, 200077, 'elementum,', '19:14:13', 'DROP_IN', 'NOT_SHOW_UP'),
(17, '2018-05-18', 200005, 200028, 'sed,', '04:51:40', 'PRE_ARRANGED', 'SHOW_UP'),
(18, '2018-03-17', 200045, 200066, 'ut,', '18:01:37', 'DROP_IN', 'NOT_SHOW_UP'),
(19, '2019-07-18', 200001, 200013, 'in,', '04:30:15', 'PRE_ARRANGED', 'SHOW_UP'),
(20, '2018-05-31', 200040, 200023, 'Curae;', '09:16:24', 'DROP_IN', 'NOT_SHOW_UP'),
(21, '2019-02-18', 200068, 200069, 'ligula', '16:14:55', 'PRE_ARRANGED', 'SHOW_UP'),
(22, '2019-10-07', 200023, 200083, 'arcu', '08:01:15', 'DROP_IN', 'NOT_SHOW_UP'),
(23, '2018-10-14', 200090, 200032, 'fringilla', '14:29:30', 'PRE_ARRANGED', 'SHOW_UP'),
(24, '2018-06-29', 200068, 200002, 'laoreet', '17:59:56', 'DROP_IN', 'NOT_SHOW_UP'),
(25, '2017-12-11', 200071, 200014, 'morbi', '05:20:47', 'PRE_ARRANGED', 'SHOW_UP'),
(26, '2018-05-05', 200085, 200042, 'rhoncus.', '09:23:01', 'DROP_IN', 'NOT_SHOW_UP'),
(27, '2019-12-31', 200009, 200015, 'et', '23:10:13', 'PRE_ARRANGED', 'SHOW_UP'),
(28, '2018-10-30', 200079, 200067, 'sapien,', '14:00:54', 'DROP_IN', 'NOT_SHOW_UP'),
(29, '2019-04-01', 200004, 200053, 'turpis', '08:18:14', 'PRE_ARRANGED', 'SHOW_UP'),
(30, '2019-08-11', 200002, 200017, 'Phasellus', '19:09:04', 'DROP_IN', 'NOT_SHOW_UP'),
(31, '2019-04-01', 200002, 200024, 'mollis.', '02:58:56', 'PRE_ARRANGED', 'SHOW_UP'),
(32, '2018-12-22', 200075, 200015, 'In', '18:28:15', 'DROP_IN', 'NOT_SHOW_UP'),
(33, '2019-02-15', 200074, 200061, 'non', '11:40:20', 'PRE_ARRANGED', 'SHOW_UP'),
(34, '2017-07-23', 200043, 200039, 'ornare.', '19:04:35', 'DROP_IN', 'NOT_SHOW_UP'),
(35, '2020-02-21', 200006, 200020, 'Nam', '12:43:38', 'PRE_ARRANGED', 'SHOW_UP'),
(36, '2018-10-27', 200008, 200054, 'feugiat.', '09:35:42', 'DROP_IN', 'NOT_SHOW_UP'),
(37, '2018-10-11', 200065, 200056, 'ornare', '23:11:20', 'PRE_ARRANGED', 'SHOW_UP'),
(38, '2018-12-01', 200046, 200071, 'nisl', '11:40:34', 'DROP_IN', 'NOT_SHOW_UP'),
(39, '2017-09-10', 200058, 200081, 'vitae', '22:34:14', 'PRE_ARRANGED', 'SHOW_UP'),
(40, '2017-10-04', 200037, 200057, 'tellus.', '12:36:31', 'DROP_IN', 'NOT_SHOW_UP'),
(41, '2019-11-19', 200026, 200085, 'luctus', '15:46:45', 'PRE_ARRANGED', 'SHOW_UP'),
(42, '2020-04-05', 200085, 200056, 'dignissim', '16:33:10', 'DROP_IN', 'NOT_SHOW_UP'),
(43, '2018-10-11', 200088, 200021, 'malesuada', '16:32:54', 'PRE_ARRANGED', 'SHOW_UP'),
(44, '2018-11-23', 200039, 200051, 'accumsan', '01:09:01', 'DROP_IN', 'NOT_SHOW_UP'),
(45, '2020-02-15', 200076, 200011, 'neque.', '21:01:22', 'PRE_ARRANGED', 'SHOW_UP'),
(46, '2019-10-31', 200022, 200001, 'natoque', '18:05:20', 'DROP_IN', 'NOT_SHOW_UP'),
(47, '2019-05-12', 200017, 200047, 'egestas.', '07:46:48', 'PRE_ARRANGED', 'SHOW_UP'),
(48, '2018-08-16', 200010, 200048, 'tempus,', '15:11:50', 'DROP_IN', 'NOT_SHOW_UP'),
(49, '2017-06-27', 200085, 200007, 'magnis', '01:37:20', 'PRE_ARRANGED', 'SHOW_UP'),
(50, '2017-05-12', 200033, 200056, 'blandit', '14:00:54', 'DROP_IN', 'NOT_SHOW_UP'),
(51, '2017-08-06', 200004, 200072, 'mi', '10:39:37', 'PRE_ARRANGED', 'SHOW_UP'),
(52, '2018-08-30', 200088, 200024, 'tempor', '23:20:12', 'DROP_IN', 'NOT_SHOW_UP'),
(53, '2019-07-16', 200009, 200045, 'tellus.', '04:41:48', 'PRE_ARRANGED', 'SHOW_UP'),
(54, '2018-11-26', 200066, 200064, 'sed', '08:03:50', 'DROP_IN', 'NOT_SHOW_UP'),
(55, '2019-08-28', 200049, 200085, 'aliquet', '01:43:48', 'PRE_ARRANGED', 'SHOW_UP'),
(56, '2018-12-21', 200030, 200030, 'Praesent', '05:56:16', 'DROP_IN', 'NOT_SHOW_UP'),
(57, '2020-04-18', 200054, 200082, 'mauris.', '22:30:35', 'PRE_ARRANGED', 'SHOW_UP'),
(58, '2019-03-25', 200010, 200008, 'in', '06:10:00', 'DROP_IN', 'NOT_SHOW_UP'),
(59, '2017-09-07', 200027, 200007, 'ornare', '09:07:31', 'PRE_ARRANGED', 'SHOW_UP'),
(60, '2017-08-31', 200085, 200047, 'ut', '09:48:40', 'DROP_IN', 'NOT_SHOW_UP'),
(61, '2018-06-28', 200008, 200010, 'amet', '16:22:03', 'PRE_ARRANGED', 'SHOW_UP'),
(62, '2018-02-01', 200064, 200030, 'egestas', '10:32:52', 'DROP_IN', 'NOT_SHOW_UP'),
(63, '2018-07-02', 200076, 200028, 'nisi.', '23:23:30', 'PRE_ARRANGED', 'SHOW_UP'),
(64, '2018-05-30', 200048, 200018, 'blandit', '20:35:32', 'DROP_IN', 'NOT_SHOW_UP'),
(65, '2017-06-18', 200037, 200037, 'turpis.', '10:11:11', 'PRE_ARRANGED', 'SHOW_UP'),
(66, '2019-07-02', 200011, 200047, 'nibh.', '18:11:20', 'DROP_IN', 'NOT_SHOW_UP'),
(68, '2017-08-07', 200039, 200032, 'posuere', '04:19:24', 'DROP_IN', 'NOT_SHOW_UP'),
(69, '2017-06-05', 200088, 200057, 'neque', '15:10:51', 'PRE_ARRANGED', 'SHOW_UP'),
(70, '2018-05-06', 200016, 200039, 'auctor.', '17:09:14', 'DROP_IN', 'NOT_SHOW_UP'),
(71, '2019-05-07', 200030, 200082, 'ante', '00:39:06', 'PRE_ARRANGED', 'SHOW_UP'),
(72, '2019-10-16', 200090, 200023, 'pede,', '01:36:58', 'DROP_IN', 'NOT_SHOW_UP'),
(73, '2018-04-16', 200038, 200070, 'dolor.', '23:40:34', 'PRE_ARRANGED', 'SHOW_UP'),
(74, '2019-02-01', 200025, 200002, 'Curabitur', '22:09:57', 'DROP_IN', 'NOT_SHOW_UP'),
(75, '2020-01-28', 200069, 200044, 'sapien,', '11:09:53', 'PRE_ARRANGED', 'SHOW_UP'),
(76, '2017-09-07', 200003, 200029, 'a,', '13:32:26', 'DROP_IN', 'NOT_SHOW_UP'),
(77, '2020-03-11', 200018, 200049, 'dolor.', '17:35:01', 'PRE_ARRANGED', 'SHOW_UP'),
(78, '2017-08-08', 200024, 200046, 'ut,', '07:45:58', 'DROP_IN', 'NOT_SHOW_UP'),
(79, '2019-12-01', 200060, 200002, 'laoreet', '16:14:06', 'PRE_ARRANGED', 'SHOW_UP'),
(80, '2018-02-11', 200035, 200025, 'Ut', '21:02:06', 'DROP_IN', 'NOT_SHOW_UP'),
(81, '2018-10-25', 200000, 200063, 'lectus', '09:13:22', 'PRE_ARRANGED', 'SHOW_UP'),
(82, '2017-11-22', 200083, 200066, 'mus.', '22:33:35', 'DROP_IN', 'NOT_SHOW_UP'),
(83, '2019-06-04', 200078, 200006, 'varius', '21:13:25', 'PRE_ARRANGED', 'SHOW_UP'),
(84, '2019-03-15', 200061, 200034, 'in,', '07:00:39', 'DROP_IN', 'NOT_SHOW_UP'),
(85, '2017-06-16', 200056, 200017, 'in', '04:35:29', 'PRE_ARRANGED', 'SHOW_UP'),
(86, '2018-12-17', 200023, 200075, 'Vivamus', '17:26:59', 'DROP_IN', 'NOT_SHOW_UP'),
(87, '2019-09-11', 200052, 200032, 'lacus.', '09:58:45', 'PRE_ARRANGED', 'SHOW_UP'),
(88, '2019-12-11', 200083, 200047, 'hendrerit', '03:48:21', 'DROP_IN', 'NOT_SHOW_UP'),
(89, '2018-04-22', 200036, 200057, 'lacinia.', '18:38:20', 'PRE_ARRANGED', 'SHOW_UP'),
(90, '2018-03-24', 200003, 200082, 'cursus', '19:07:10', 'DROP_IN', 'NOT_SHOW_UP'),
(91, '2018-03-29', 200052, 200060, 'ligula.', '01:20:52', 'PRE_ARRANGED', 'SHOW_UP'),
(92, '2018-09-25', 200078, 200048, 'enim', '16:17:45', 'DROP_IN', 'NOT_SHOW_UP'),
(93, '2018-09-01', 200071, 200005, 'ac', '05:20:49', 'PRE_ARRANGED', 'SHOW_UP'),
(94, '2018-09-05', 200048, 200072, 'gravida', '20:55:53', 'DROP_IN', 'NOT_SHOW_UP'),
(95, '2018-10-05', 200000, 200001, 'Duis', '06:53:13', 'PRE_ARRANGED', 'SHOW_UP'),
(96, '2019-04-02', 200034, 200074, 'at', '03:31:28', 'DROP_IN', 'NOT_SHOW_UP'),
(97, '2017-05-21', 200026, 200090, 'Suspendisse', '12:07:28', 'PRE_ARRANGED', 'SHOW_UP'),
(98, '2018-09-19', 200030, 200007, 'erat', '05:16:03', 'DROP_IN', 'NOT_SHOW_UP'),
(99, '2019-03-25', 200081, 200045, 'ligula.', '13:50:00', 'PRE_ARRANGED', 'SHOW_UP'),
(100, '2017-05-22', 200044, 200004, 'molestie', '19:00:28', 'DROP_IN', 'NOT_SHOW_UP');

-- --------------------------------------------------------

--
-- Table structure for table `CLINIC`
--

CREATE TABLE `CLINIC` (
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CLINIC`
--

INSERT INTO `CLINIC` (`name`) VALUES
('Areteeio'),
('Makario');

-- --------------------------------------------------------

--
-- Table structure for table `COMMENT`
--

CREATE TABLE `COMMENT` (
  `id` int(11) NOT NULL,
  `content` text NOT NULL,
  `patient` int(11) NOT NULL,
  `clinician` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `CONSULTANT`
--

CREATE TABLE `CONSULTANT` (
  `clinician` int(11) NOT NULL,
  `patient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `DECEASED`
--

CREATE TABLE `DECEASED` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `INCIDENT`
--

CREATE TABLE `INCIDENT` (
  `id` int(11) NOT NULL,
  `patient` int(11) NOT NULL,
  `details` text NOT NULL,
  `type` enum('INCIDENT','THREAT') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `INCIDENT_BY_PRESCRIPTION`
--

CREATE TABLE `INCIDENT_BY_PRESCRIPTION` (
  `id` int(11) NOT NULL,
  `patient` int(11) NOT NULL,
  `details` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `MEDICAL_RECORD`
--

CREATE TABLE `MEDICAL_RECORD` (
  `patient` int(11) NOT NULL,
  `last_updated` date NOT NULL,
  `status` enum('DANGEROUS','NOT_DANGEROUS') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `MEDICINE`
--

CREATE TABLE `MEDICINE` (
  `name` varchar(15) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` mediumint(9) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `relative_email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(100) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `gender` text,
  `Req_change` tinyint(1) NOT NULL DEFAULT '0',
  `IsAlive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `firstname`, `lastname`, `relative_email`, `address`, `phonenumber`, `birthday`, `gender`, `Req_change`, `IsAlive`) VALUES
(200000, 'Evangeline', 'Montoya', 'nulla.magna@semelit.edu', '6769 Egestas Rd.', '99423906', '1988-08-11', 'M', 0, 0),
(200001, 'Karly', 'Wyatt', 'lobortis@Fusce.ca', '8198 Non Rd.', '99753122', '1946-08-20', 'F', 0, 1),
(200002, 'Aphrodite', 'Simon', 'mauris@NullamnislMaecenas.co.uk', 'Ap #431-9493 Amet, St.', '99809697', '1988-07-11', 'M', 0, 1),
(200003, 'Sybill', 'Burris', 'sit@dictumauguemalesuada.ca', '8507 Phasellus St.', '99673758', '2010-04-25', 'F', 0, 1),
(200004, 'Brooke', 'Pope', 'vitae.erat@placerat.net', 'P.O. Box 326, 1847 Id St.', '99697330', '2009-09-11', 'M', 0, 1),
(200005, 'Faith', 'Duffy', 'viverra.Donec@imperdietdictummagna.net', '798 Donec Av.', '99649381', '1948-07-04', 'F', 0, 1),
(200006, 'Ferris', 'Bowers', 'Duis.ac@massalobortisultrices.net', 'Ap #873-6325 A, Street', '99069765', '1954-05-15', 'M', 0, 1),
(200007, 'Marcia', 'Miranda', 'Sed@euenimEtiam.ca', 'P.O. Box 953, 5260 Varius Rd.', '99732951', '1928-02-28', 'F', 0, 1),
(200008, 'Britanney', 'Hays', 'iaculis.nec@eleifend.co.uk', '529-8206 Ultrices Ave', '99211846', '1992-11-14', 'M', 0, 1),
(200009, 'Quon', 'Gilmore', 'adipiscing.elit.Aliquam@egestasa.net', '8059 Aliquam Av.', '99795970', '1929-06-22', 'F', 0, 1),
(200010, 'Eaton', 'Woodard', 'aliquet.metus.urna@duinecurna.ca', '2390 Aliquam St.', '99746510', '1934-03-29', 'M', 0, 1),
(200011, 'Declan', 'Oconnor', 'ornare@ornarelectusjusto.com', 'Ap #668-8018 Sed Road', '99223440', '1973-08-20', 'F', 0, 1),
(200012, 'Haviva', 'Parsons', 'et@liberoProin.org', 'P.O. Box 624, 9794 Lacinia Rd.', '99471669', '1931-07-28', 'M', 0, 1),
(200014, 'Rama', 'Forbes', 'blandit@nullaDonec.co.uk', '414-2485 Nulla. Ave', '99232527', '1946-10-28', 'M', 0, 1),
(200015, 'Bernard', 'Merritt', 'egestas.ligula.Nullam@Proinnon.com', '569 Erat St.', '99851831', '2013-07-06', 'F', 0, 1),
(200016, 'Jonas', 'Chambers', 'magna.Suspendisse@Phasellusornare.co.uk', '8565 Nec Road', '99356452', '1972-06-12', 'M', 0, 1),
(200017, 'Timothy', 'Mendez', 'orci@Loremipsumdolor.edu', '1939 Diam. St.', '99596773', '1967-11-14', 'F', 0, 1),
(200018, 'Sacha', 'Gibson', 'lorem.tristique.aliquet@sollicitudina.com', 'P.O. Box 478, 7677 Ut Rd.', '99199264', '2004-01-25', 'M', 0, 1),
(200019, 'Stephanie', 'Finch', 'ante.blandit.viverra@Cumsociis.org', '219-4261 Massa Road', '99408649', '1951-05-13', 'F', 0, 1),
(200020, 'Shelly', 'Beard', 'Sed.molestie.Sed@euismod.net', 'P.O. Box 257, 3815 Quisque St.', '99097678', '1965-11-30', 'M', 0, 1),
(200021, 'Rachel', 'Dotson', 'In.lorem@dictumProin.org', '444-5850 Phasellus Rd.', '99016496', '1997-07-26', 'F', 0, 1),
(200022, 'Moses', 'Durham', 'mi@purus.co.uk', 'P.O. Box 938, 4260 Egestas Street', '99358721', '1939-10-18', 'M', 0, 1),
(200023, 'Xander', 'Tillman', 'in.felis.Nulla@ametorciUt.net', '8810 Imperdiet Rd.', '99699517', '2013-08-12', 'F', 0, 1),
(200024, 'Alan', 'Conway', 'euismod.enim.Etiam@Mauris.com', 'P.O. Box 614, 5093 Diam. Rd.', '99547433', '1989-02-25', 'M', 0, 1),
(200025, 'Andrew', 'Colon', 'malesuada.malesuada.Integer@malesuada.co.uk', '5143 Rutrum Street', '99808472', '1976-04-05', 'F', 0, 1),
(200026, 'Joelle', 'Dudley', 'sed.libero@lorem.edu', 'P.O. Box 955, 2213 Nulla Rd.', '99915057', '1988-03-03', 'M', 0, 1),
(200027, 'Xena', 'Short', 'nec.mauris@dignissimlacusAliquam.org', '621 Arcu. Rd.', '99159484', '1995-05-30', 'F', 0, 1),
(200028, 'Emmanuel', 'Lang', 'sollicitudin.a.malesuada@viverra.net', 'Ap #655-5895 Lorem Rd.', '99909867', '1962-02-22', 'M', 0, 1),
(200029, 'Trevor', 'Faulkner', 'Nunc.mauris.Morbi@egetmassaSuspendisse.net', '8034 Lobortis Street', '99024879', '1968-02-10', 'F', 0, 1),
(200030, 'Candice', 'Hayden', 'aliquam@Sedpharetrafelis.edu', 'P.O. Box 143, 3137 Ipsum Av.', '99463603', '1939-04-11', 'M', 0, 1),
(200031, 'Macy', 'Knox', 'adipiscing.non@tristiquealiquetPhasellus.ca', '2573 Lorem Avenue', '99182239', '1989-06-27', 'F', 0, 1),
(200032, 'Lillith', 'Parks', 'sociosqu.ad.litora@etmalesuada.net', 'P.O. Box 853, 4715 Nullam Road', '99621363', '1981-10-29', 'M', 0, 1),
(200033, 'Logan', 'Hawkins', 'faucibus.ut.nulla@Proineget.co.uk', '207 Arcu Rd.', '99430814', '1989-03-28', 'F', 0, 0),
(200034, 'Oprah', 'Blake', 'rutrum@antebibendumullamcorper.edu', 'P.O. Box 210, 8230 Inceptos Street', '99436626', '1938-05-08', 'M', 0, 1),
(200035, 'Paula', 'Cortez', 'magna@natoquepenatibuset.co.uk', 'Ap #997-8403 Velit. Street', '99709408', '2010-12-28', 'F', 0, 1),
(200036, 'Zane', 'Petersen', 'Vivamus.nibh@eratinconsectetuer.edu', 'P.O. Box 812, 4665 Ante. Av.', '99225568', '2001-05-14', 'M', 0, 1),
(200037, 'Alea', 'Moran', 'lobortis@ornaresagittisfelis.net', '626-6098 Erat St.', '99041368', '1995-12-01', 'F', 0, 1),
(200038, 'Phoebe', 'Talley', 'diam.Duis@adipiscingelit.ca', '4754 Vitae Road', '99987591', '1990-01-20', 'M', 0, 1),
(200039, 'Melinda', 'Gilmore', 'Suspendisse.non.leo@a.edu', 'P.O. Box 591, 4086 Quis Rd.', '99571419', '1947-11-29', 'F', 0, 1),
(200040, 'Amela', 'Pittman', 'eget@mattis.org', '589-5737 Magna, Street', '99042981', '1940-12-12', 'M', 0, 1),
(200041, 'Giselle', 'Finch', 'lobortis.augue@ligulaDonecluctus.co.uk', 'Ap #335-1501 Auctor Rd.', '99756310', '1975-03-15', 'F', 0, 1),
(200042, 'Jelani', 'Hahn', 'lorem.vitae.odio@Craseu.net', '580-5137 Luctus, St.', '99058761', '2013-09-14', 'M', 0, 1),
(200043, 'Byron', 'Henson', 'Donec.at.arcu@nonhendreritid.edu', 'P.O. Box 967, 5014 A, St.', '99526904', '1940-06-05', 'F', 0, 1),
(200044, 'Marvin', 'Cannon', 'hendrerit.neque@sollicitudinadipiscingligula.edu', '553-7554 Vitae Avenue', '99171917', '1991-09-23', 'M', 0, 1),
(200045, 'Ali', 'Gilbert', 'cursus.vestibulum.Mauris@necdiamDuis.ca', '7727 Tortor St.', '99721247', '1979-09-26', 'F', 0, 1),
(200046, 'Ferdinand', 'Pope', 'dignissim.lacus.Aliquam@volutpatNulla.net', 'Ap #784-6033 Aenean St.', '99837933', '1992-03-20', 'M', 0, 1),
(200047, 'Rana', 'Gordon', 'amet.diam.eu@massaMaurisvestibulum.org', 'Ap #627-1813 Cras St.', '99662863', '1951-05-15', 'F', 0, 1),
(200048, 'Declan', 'Blevins', 'orci.Ut@metusfacilisis.edu', 'Ap #523-3535 Velit Rd.', '99963424', '1967-09-14', 'M', 0, 1),
(200049, 'Uriah', 'Weiss', 'lacinia@vulputateullamcorper.net', 'Ap #649-4477 Metus Street', '99788339', '1966-04-21', 'F', 0, 1),
(200050, 'Phelan', 'Richard', 'pede.Nunc@molestieSed.co.uk', 'Ap #914-6574 Ligula. St.', '99544148', '1995-12-01', 'M', 0, 1),
(200051, 'Hyacinth', 'Velazquez', 'Aliquam.erat.volutpat@euenim.co.uk', '292-3708 Diam Rd.', '99288730', '1991-06-28', 'F', 0, 1),
(200052, 'Cameron', 'Sykes', 'euismod.in.dolor@lobortisquispede.ca', 'Ap #136-2783 Tortor Rd.', '99743641', '1986-01-29', 'M', 0, 1),
(200053, 'Sonya', 'Key', 'ut.sem@nonenimcommodo.com', '329-355 Sit St.', '99711379', '1941-12-11', 'F', 0, 1),
(200054, 'Haley', 'Odonnell', 'justo.faucibus.lectus@disparturientmontes.ca', '5245 Donec Rd.', '99176312', '1930-10-13', 'M', 0, 1),
(200055, 'Shelley', 'Carey', 'porttitor.interdum@Nunclectuspede.net', 'P.O. Box 183, 8940 Justo Avenue', '99401544', '1933-06-15', 'F', 0, 1),
(200056, 'Zephr', 'Estrada', 'et@augue.co.uk', '7309 In Rd.', '99031805', '1997-09-09', 'M', 0, 1),
(200057, 'Timon', 'Porter', 'sem.vitae@anteblanditviverra.ca', '3125 Sit Ave', '99967334', '1998-03-06', 'F', 0, 1),
(200058, 'Blaine', 'Barr', 'Cum@hendreritneque.co.uk', '161-5606 Ante. Road', '99423362', '1993-11-15', 'M', 0, 1),
(200059, 'Tad', 'Patton', 'Phasellus.elit@sodalesMaurisblandit.org', 'P.O. Box 817, 5270 Proin St.', '99264557', '1983-03-04', 'F', 0, 1),
(200060, 'Cheyenne', 'Ruiz', 'lectus@mollisIntegertincidunt.com', '7378 Nunc St.', '99433816', '1968-05-25', 'M', 0, 1),
(200061, 'Emerson', 'Mcdowell', 'In.ornare.sagittis@suscipitnonummyFusce.co.uk', 'Ap #842-8735 Placerat St.', '99698151', '1945-11-26', 'F', 0, 1),
(200062, 'Tanek', 'Frye', 'eu.tempor.erat@magnaCras.ca', 'P.O. Box 557, 3833 Sem Rd.', '99008743', '2011-07-18', 'M', 0, 1),
(200063, 'Idona', 'Durham', 'consequat.auctor@Integerin.edu', 'P.O. Box 103, 426 A Street', '99384628', '1959-04-19', 'F', 0, 1),
(200064, 'Yoshii', 'Ballard', 'Nulla@consequat.org', '5953 Porttitor Av.', '99443556', '1973-03-09', 'M', 0, 1),
(200065, 'Candace', 'Bradshaw', 'tristique.neque.venenatis@vulputate.co.uk', 'Ap #933-9239 Nec, Street', '99453501', '1938-12-06', 'F', 0, 1),
(200066, 'Hedwig', 'Pitts', 'quis.turpis@Aliquamornare.com', '1896 Sem Street', '99286273', '2016-02-16', 'M', 0, 1),
(200067, 'Sawyer', 'Fields', 'lectus.Nullam.suscipit@consectetuerrhoncus.co.uk', '8688 Pede. St.', '99508047', '1977-10-10', 'F', 0, 1),
(200068, 'Cheryl', 'Clay', 'scelerisque@interdum.co.uk', 'P.O. Box 961, 4304 Placerat Rd.', '99176428', '1964-12-25', 'M', 0, 1),
(200069, 'Vincent', 'Mcdaniel', 'arcu.Morbi@odioauctor.com', '601-1873 Quam. Avenue', '99447227', '1968-08-19', 'F', 0, 1),
(200070, 'Grant', 'Sanchez', 'Integer@sit.org', '860-2942 Ante Rd.', '99808944', '1939-02-26', 'M', 0, 1),
(200071, 'Oscar', 'Ratliff', 'sociosqu@Duiselementum.org', 'P.O. Box 598, 5635 Tellus, Av.', '99904388', '1978-08-15', 'F', 0, 1),
(200072, 'Amir', 'Whitehead', 'ornare.lectus.justo@etmagnaPraesent.edu', '494-5913 Nullam Av.', '99465294', '1929-01-08', 'M', 0, 1),
(200073, 'Madeson', 'Valentine', 'posuere@mattisornarelectus.co.uk', 'Ap #485-7908 Nibh Road', '99151620', '1996-09-22', 'F', 0, 1),
(200074, 'Sage', 'Valenzuela', 'Quisque@Quisqueornaretortor.co.uk', 'Ap #649-1042 Risus. St.', '99361836', '1936-06-15', 'M', 0, 1),
(200075, 'Holly', 'Ramos', 'vestibulum.nec.euismod@Nam.edu', '5205 Netus Road', '99578621', '1986-07-26', 'F', 0, 1),
(200076, 'Jayme', 'Cochran', 'imperdiet.non@ante.org', 'Ap #173-7432 Et Street', '99589903', '2014-04-18', 'M', 0, 1),
(200077, 'Kirk', 'Levine', 'eu@atvelit.org', '9187 Nibh. St.', '99947721', '1956-10-16', 'F', 0, 1),
(200078, 'August', 'Rojas', 'libero.mauris.aliquam@hendreritconsectetuercursus.net', '399-2235 Pede, Road', '99831738', '1983-01-10', 'M', 0, 1),
(200079, 'Melinda', 'William', 'nec.luctus@Maurismolestie.edu', 'Ap #977-2203 Morbi Av.', '99292659', '1955-05-02', 'F', 0, 1),
(200080, 'Ariana', 'Sheppard', 'ornare.Fusce@eratvel.ca', 'P.O. Box 625, 7924 Diam Rd.', '99466794', '1973-07-06', 'M', 0, 1),
(200081, 'Allistair', 'Hunter', 'orci@afeugiattellus.net', 'P.O. Box 518, 1634 Molestie Ave', '99068187', '1938-06-09', 'F', 0, 1),
(200082, 'Taylor', 'Obrien', 'congue.In.scelerisque@enimsitamet.org', 'P.O. Box 630, 3291 Amet, Road', '99370058', '1993-10-07', 'M', 0, 1),
(200083, 'Tanya', 'Lewis', 'Cras@pellentesqueSed.net', '583-2823 Ac Av.', '99037705', '1949-09-03', 'F', 0, 1),
(200084, 'Ifeoma', 'Benjamin', 'Donec@Integersemelit.com', '2230 Eros. Av.', '99157816', '2017-04-22', 'M', 0, 1),
(200085, 'Nissim', 'Edwards', 'sociis.natoque.penatibus@Praesenteu.ca', '738-9667 Leo. Street', '99628166', '2013-10-18', 'F', 0, 1),
(200086, 'Judah', 'Goodwin', 'Phasellus@ultrices.co.uk', '1257 Libero. Avenue', '99156918', '1998-09-17', 'M', 0, 1),
(200087, 'Heidi', 'Burns', 'Nulla.dignissim@diamat.com', 'P.O. Box 125, 3676 Ullamcorper Rd.', '99237645', '2012-06-19', 'F', 0, 1),
(200088, 'Destiny', 'Bonner', 'commodo.at.libero@quismassa.ca', '391-5957 A St.', '99136955', '1931-10-03', 'M', 0, 1),
(200089, 'Ainsley', 'Bird', 'vitae.aliquam@nunc.edu', 'P.O. Box 633, 1396 Congue, Road', '99498185', '2012-11-04', 'F', 1, 1),
(200090, 'Isaiah', 'Oconnor', 'ipsum.cursus.vestibulum@elementumat.net', '309-3174 Eu Avenue', '99121696', '1975-06-09', 'M', 0, 1),
(200091, 'Patrick', 'Powell', 'adipiscing.elit@etmagna.org', 'Ap #142-6980 Aliquet St.', '99644373', '2016-05-16', 'F', 0, 1),
(200092, 'Slade', 'Harmon', 'sit.amet@Duisacarcu.com', 'P.O. Box 545, 6940 Ligula. Av.', '99898134', '1974-05-17', 'M', 0, 1),
(200093, 'Kellie', 'Dejesus', 'lorem.ac@risusat.org', '738-206 Ullamcorper Avenue', '99687139', '1996-03-15', 'F', 0, 1),
(200094, 'Vernon', 'Campos', 'in.aliquet.lobortis@magnaUt.net', '340-4613 Bibendum Rd.', '99543231', '1930-10-22', 'M', 0, 1),
(200095, 'Octavius', 'Logan', 'sem.vitae@nonlacinia.edu', 'P.O. Box 205, 6609 Ornare, Rd.', '99497322', '2006-09-16', 'F', 0, 1),
(200096, 'Phelan', 'Bernard1', 'lacus@interdumCurabiturdictum.ca', '513-5450 Aliquam Rd.', '99320459', '1988-05-27', 'M', 1, 1),
(200097, 'Alisa', 'Sanchez', 'convallis.est.vitae@parturientmontesnascetur.ca', '894-3826 Luctus Avenue', '99101589', '1958-06-23', 'F', 0, 1),
(200098, 'Clare', 'Rice', 'nascetur@nequesed.net', 'Ap #196-2510 Sit Av.', '99182043', '2010-08-27', 'M', 0, 1),
(200099, 'Orson', 'Chandler', 'convallis.in.cursus@vitaesodales.co.uk', '593 Fringilla. Street', '99046637', '2003-05-29', 'F', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `REQUEST`
--

CREATE TABLE `REQUEST` (
  `id` int(11) NOT NULL,
  `patient` int(11) NOT NULL,
  `date` date NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SIDE_EFFECT`
--

CREATE TABLE `SIDE_EFFECT` (
  `medicine` varchar(15) NOT NULL,
  `side_effect` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `TREATMENT`
--

CREATE TABLE `TREATMENT` (
  `id` int(11) NOT NULL,
  `condition` text NOT NULL,
  `medicine` varchar(15) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` mediumint(9) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(100) DEFAULT NULL,
  `username` text,
  `password` text,
  `type` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `email`, `phonenumber`, `username`, `password`, `type`) VALUES
(1, 'a', 'a', 'a', 'a', 'a', 'a', 'RECEPTIONIST'),
(2, 'b', 'b', 'b', 'b', 'b', 'b', 'CLINICAL_STAFF'),
(3, 'c', 'c', 'c', 'c', 'c', 'c', 'MEDICAL_RECORD_STAFF'),
(4, 'd', 'd', 'd', 'd', 'd', 'd', 'HEALTH_SERVICE_MANAGEMENT'),
(200000, 'Ciaran', 'Reynolds', 'a@Nuncacsem.net', '99308458', 'sem', 'adipiscing', 'CLINICAL_STAFF'),
(200001, 'Logan', 'Willis', 'eget.venenatis@Ut.org', '99914313', 'ad', 'mi', 'RECEPTIONIST'),
(200002, 'Lynn', 'Nicholson', 'a.dui@neque.com', '99552529', 'eget', 'mi', 'MEDICAL_RECORD_STAFF'),
(200003, 'Lavinia', 'Mccullough', 'nascetur.ridiculus@ac.net', '99851660', 'Quisque', 'in', 'HEALTH_SERVICE_MANAGEMENT'),
(200004, 'MacKensie', 'Woodward', 'orci@etrutrum.org', '99446009', 'semper', 'interdum.', 'CLINICAL_STAFF'),
(200005, 'Callie', 'Hanson', 'mi.enim@atarcu.ca', '99537732', 'tempor', 'risus.', 'RECEPTIONIST'),
(200006, 'Katell', 'Haney', 'velit.eget@placerat.net', '99740846', 'ipsum.', 'sit', 'MEDICAL_RECORD_STAFF'),
(200007, 'Portia', 'Frost', 'et.magnis.dis@sed.org', '99234932', 'ornare', 'lobortis', 'HEALTH_SERVICE_MANAGEMENT'),
(200008, 'Nelle', 'Love', 'auctor.non.feugiat@purus.com', '99903253', 'sociis', 'Cras', 'CLINICAL_STAFF'),
(200009, 'Eagan', 'Witt', 'non.arcu.Vivamus@nonummyac.ca', '99120759', 'gravida.', 'mauris.', 'RECEPTIONIST'),
(200010, 'Jin', 'Brock', 'nunc.ullamcorper.eu@Maurisut.net', '99786106', 'fringilla', 'Quisque', 'MEDICAL_RECORD_STAFF'),
(200011, 'Ronan', 'Hodge', 'eget.metus@malesuadautsem.ca', '99891063', 'libero.', 'ipsum.', 'HEALTH_SERVICE_MANAGEMENT'),
(200012, 'Irene', 'Nieves', 'vestibulum.Mauris.magna@estmaurisrhoncus.net', '99276719', 'sem.', 'nisl.', 'CLINICAL_STAFF'),
(200013, 'August', 'Holmes', 'Morbi@metus.ca', '99564467', 'ornare,', 'consectetuer', 'RECEPTIONIST'),
(200014, 'Jaquelyn', 'Stewart', 'ridiculus.mus.Donec@ante.edu', '99009499', 'ut', 'a', 'MEDICAL_RECORD_STAFF'),
(200015, 'John', 'Edwards', 'felis.adipiscing.fringilla@felis.ca', '99014025', 'neque', 'diam', 'HEALTH_SERVICE_MANAGEMENT'),
(200016, 'Desiree', 'Cooper', 'habitant.morbi.tristique@sedturpisnec.com', '99988808', 'fermentum', 'neque.', 'CLINICAL_STAFF'),
(200017, 'Carol', 'Weber', 'at@tellusimperdietnon.org', '99785405', 'a,', 'nisl.', 'RECEPTIONIST'),
(200018, 'Ciaran', 'Hughes', 'fringilla@Fusce.com', '99431161', 'Phasellus', 'lectus', 'MEDICAL_RECORD_STAFF'),
(200019, 'Craig', 'Hart', 'egestas.Aliquam.fringilla@velest.net', '99464996', 'Morbi', 'semper', 'HEALTH_SERVICE_MANAGEMENT'),
(200020, 'Wing', 'Russo', 'dignissim@erosturpis.net', '99365134', 'accumsan', 'pharetra', 'CLINICAL_STAFF'),
(200021, 'Steel', 'Taylor', 'purus@cursuset.ca', '99214235', 'metus.', 'mi,', 'RECEPTIONIST'),
(200022, 'Jordan', 'Bartlett', 'dolor.dolor@cursuspurusNullam.com', '99877162', 'Donec', 'ante', 'MEDICAL_RECORD_STAFF'),
(200023, 'Wallace', 'Kerr', 'vehicula.et@velitPellentesqueultricies.co.uk', '99646048', 'eu', 'Pellentesque', 'HEALTH_SERVICE_MANAGEMENT'),
(200024, 'Nerea', 'Sloan', 'Duis.gravida@Sed.net', '99090788', 'Mauris', 'fermentum', 'CLINICAL_STAFF'),
(200025, 'Alyssa', 'Ross', 'Proin.vel@elitpretiumet.net', '99126393', 'auctor', 'Suspendisse', 'RECEPTIONIST'),
(200026, 'Ruby', 'Stanton', 'et@Aliquamtinciduntnunc.co.uk', '99174336', 'bibendum', 'libero.', 'MEDICAL_RECORD_STAFF'),
(200027, 'Bell', 'Vega', 'nisl.arcu.iaculis@velitdui.org', '99273347', 'Curae;', 'aliquet', 'HEALTH_SERVICE_MANAGEMENT'),
(200028, 'Hanna', 'Durham', 'euismod.et@vitaenibhDonec.com', '99918094', 'quam,', 'lorem,', 'CLINICAL_STAFF'),
(200029, 'Leilani', 'Donaldson', 'id.risus@inmolestie.ca', '99898093', 'dolor', 'enim', 'RECEPTIONIST'),
(200030, 'Derek', 'Freeman', 'non.lobortis@erategetipsum.org', '99645660', 'sed', 'ac,', 'MEDICAL_RECORD_STAFF'),
(200031, 'Basil', 'Sherman', 'scelerisque.lorem@pellentesqueSeddictum.org', '99395548', 'justo.', 'dui', 'HEALTH_SERVICE_MANAGEMENT'),
(200032, 'Lisandra', 'Norman', 'nec@ipsum.net', '99079479', 'ullamcorper,', 'at', 'CLINICAL_STAFF'),
(200033, 'Boris', 'Fowler', 'fringilla.porttitor.vulputate@sitamet.org', '99692536', 'erat', 'montes,', 'RECEPTIONIST'),
(200034, 'Jack', 'Sanford', 'dictum@purusactellus.co.uk', '99923401', 'Proin', 'sit', 'MEDICAL_RECORD_STAFF'),
(200035, 'Dacey', 'Harmon', 'aliquam.arcu.Aliquam@vitaemaurissit.com', '99430181', 'Quisque', 'urna.', 'HEALTH_SERVICE_MANAGEMENT'),
(200036, 'Thaddeus', 'Parsons', 'lectus.Nullam.suscipit@molestie.org', '99228805', 'placerat.', 'ultrices.', 'CLINICAL_STAFF'),
(200037, 'Jacqueline', 'Preston', 'neque@ullamcorperDuis.com', '99881722', 'dolor.', 'purus.', 'RECEPTIONIST'),
(200038, 'Lamar', 'Langley', 'diam.nunc.ullamcorper@lobortis.ca', '99590713', 'Nunc', 'malesuada', 'MEDICAL_RECORD_STAFF'),
(200039, 'Tate', 'Bruce', 'luctus.felis@dolorelit.ca', '99374414', 'quam', 'vestibulum', 'HEALTH_SERVICE_MANAGEMENT'),
(200040, 'Gillian', 'Lamb', 'tellus.Aenean@primisinfaucibus.edu', '99611516', 'Vivamus', 'id,', 'CLINICAL_STAFF'),
(200041, 'Cheryl', 'Brennan', 'malesuada.malesuada.Integer@cursus.net', '99404707', 'ipsum', 'massa.', 'RECEPTIONIST'),
(200042, 'Xander', 'Nunez', 'malesuada.Integer.id@risus.co.uk', '99850929', 'vestibulum', 'nec', 'MEDICAL_RECORD_STAFF'),
(200043, 'Ciaran', 'Randolph', 'Mauris.vestibulum@id.ca', '99954569', 'mus.', 'sapien,', 'HEALTH_SERVICE_MANAGEMENT'),
(200044, 'Imani', 'Chandler', 'primis.in.faucibus@Pellentesquehabitant.ca', '99318253', 'pellentesque', 'justo.', 'CLINICAL_STAFF'),
(200045, 'Merritt', 'Franks', 'Cras.sed.leo@primis.org', '99415801', 'ac,', 'Nulla', 'RECEPTIONIST'),
(200046, 'Buckminster', 'Porter', 'sodales.Mauris.blandit@Maecenas.co.uk', '99561798', 'Mauris', 'pede.', 'MEDICAL_RECORD_STAFF'),
(200047, 'Katelyn', 'Hunt', 'amet@pedePraesent.ca', '99407751', 'odio.', 'elementum', 'HEALTH_SERVICE_MANAGEMENT'),
(200048, 'Isadora', 'Cardenas', 'Nulla@tempusscelerisquelorem.net', '99574265', 'et,', 'urna,', 'CLINICAL_STAFF'),
(200049, 'Macon', 'Ingram', 'Morbi@enim.ca', '99643530', 'dolor', 'sit', 'RECEPTIONIST'),
(200050, 'Carlos', 'Logan', 'metus@Quisquefringillaeuismod.com', '99176060', 'lectus', 'luctus', 'MEDICAL_RECORD_STAFF'),
(200051, 'Ryder', 'Hyde', 'vitae.diam@semperNam.com', '99569260', 'convallis', 'erat', 'HEALTH_SERVICE_MANAGEMENT'),
(200052, 'Armando', 'Vinson', 'enim.commodo.hendrerit@sociisnatoquepenatibus.org', '99689878', 'purus.', 'dui,', 'CLINICAL_STAFF'),
(200053, 'Giacomo', 'Schwartz', 'netus.et.malesuada@mus.org', '99972890', 'ut,', 'pede', 'RECEPTIONIST'),
(200054, 'Jaquelyn', 'Ayers', 'a.aliquet.vel@velitQuisquevarius.com', '99391038', 'diam', 'a', 'MEDICAL_RECORD_STAFF'),
(200055, 'Hope', 'Keith', 'mollis.dui.in@pedesagittisaugue.org', '99510089', 'accumsan', 'molestie.', 'HEALTH_SERVICE_MANAGEMENT'),
(200056, 'Shaine', 'Blackwell', 'aliquet.diam.Sed@sitamet.ca', '99174411', 'ultricies', 'ipsum', 'CLINICAL_STAFF'),
(200057, 'Laura', 'Sweeney', 'ipsum@liberonec.com', '99217174', 'vitae', 'lectus', 'RECEPTIONIST'),
(200058, 'Brock', 'Case', 'justo.sit.amet@eu.ca', '99350937', 'ultrices.', 'volutpat.', 'MEDICAL_RECORD_STAFF'),
(200059, 'Kaitlin', 'Gibbs', 'libero.et@pedeblanditcongue.net', '99725885', 'Aliquam', 'in,', 'HEALTH_SERVICE_MANAGEMENT'),
(200060, 'Thor', 'Hardin', 'sit.amet.consectetuer@malesuadavelconvallis.co.uk', '99447915', 'velit', 'elementum,', 'CLINICAL_STAFF'),
(200061, 'Quynn', 'Mercado', 'Cum.sociis.natoque@scelerisqueloremipsum.co.uk', '99414415', 'lorem', 'ultrices,', 'RECEPTIONIST'),
(200062, 'Ria', 'Terrell', 'et.rutrum.non@iaculisquispede.org', '99817430', 'ante', 'semper', 'MEDICAL_RECORD_STAFF'),
(200063, 'Shelley', 'Oliver', 'nibh.vulputate@elementum.ca', '99323627', 'tortor', 'ipsum.', 'HEALTH_SERVICE_MANAGEMENT'),
(200064, 'Jasmine', 'Powers', 'Sed.malesuada.augue@odio.edu', '99324807', 'dolor.', 'orci', 'CLINICAL_STAFF'),
(200065, 'Naomi', 'Waters', 'ipsum@sed.ca', '99605590', 'adipiscing,', 'lorem', 'RECEPTIONIST'),
(200066, 'Wyoming', 'Burris', 'lectus.Nullam.suscipit@tinciduntaliquamarcu.net', '99823643', 'Cras', 'vestibulum', 'MEDICAL_RECORD_STAFF'),
(200067, 'Cullen', 'Rojas', 'lacus.Mauris@Mauris.org', '99878490', 'Vivamus', 'viverra.', 'HEALTH_SERVICE_MANAGEMENT'),
(200068, 'Brady', 'Clayton', 'pede.Cum.sociis@velconvallis.com', '99166314', 'scelerisque', 'risus', 'CLINICAL_STAFF'),
(200069, 'Hamish', 'Hinton', 'sit.amet.lorem@scelerisquelorem.edu', '99576188', 'augue', 'sagittis.', 'RECEPTIONIST'),
(200070, 'Iona', 'Albert', 'sagittis.placerat@lectusantedictum.ca', '99694571', 'quam', 'Aliquam', 'MEDICAL_RECORD_STAFF'),
(200071, 'Hanae', 'Justice', 'tristique.pellentesque@lacus.edu', '99983741', 'eu', 'Nulla', 'HEALTH_SERVICE_MANAGEMENT'),
(200072, 'Christian', 'Bolton', 'dui.Fusce.aliquam@urna.edu', '99339559', 'velit', 'erat', 'CLINICAL_STAFF'),
(200073, 'Xerxes', 'Francis', 'eu.placerat@ametdiameu.org', '99029759', 'massa.', 'dolor.', 'RECEPTIONIST'),
(200074, 'Drew', 'Franco', 'erat.eget@eu.com', '99125743', 'Praesent', 'egestas.', 'MEDICAL_RECORD_STAFF'),
(200075, 'Inga', 'Wade', 'nisi.Aenean.eget@necimperdietnec.ca', '99024664', 'non', 'dictum', 'HEALTH_SERVICE_MANAGEMENT'),
(200076, 'Vincent', 'Garcia', 'faucibus.orci@condimentum.edu', '99066474', 'facilisis', 'mi', 'CLINICAL_STAFF'),
(200077, 'Murphy', 'Terry', 'ac.eleifend@elitEtiam.net', '99517528', 'dictum', 'Suspendisse', 'RECEPTIONIST'),
(200078, 'Josephine', 'Lane', 'arcu.imperdiet@sempererat.net', '99120524', 'Curabitur', 'ac', 'MEDICAL_RECORD_STAFF'),
(200079, 'Clarke', 'Gilliam', 'nec@pedeacurna.net', '99694404', 'porta', 'amet,', 'HEALTH_SERVICE_MANAGEMENT'),
(200080, 'Yardley', 'Robbins', 'libero.Morbi@sodalesMauris.org', '99513441', 'blandit', 'at', 'CLINICAL_STAFF'),
(200081, 'Nicole', 'Le', 'nibh.Quisque.nonummy@nequetellus.net', '99581837', 'aliquet', 'convallis', 'RECEPTIONIST'),
(200082, 'Skyler', 'Tran', 'nostra.per.inceptos@lorem.net', '99446736', 'sed', 'porta', 'MEDICAL_RECORD_STAFF'),
(200083, 'Daryl', 'Lucas', 'Lorem.ipsum.dolor@consequatauctor.org', '99083166', 'hendrerit', 'Nunc', 'HEALTH_SERVICE_MANAGEMENT'),
(200084, 'Kermit', 'Miller', 'in.dolor.Fusce@acmattis.net', '99113811', 'nisl', 'In', 'CLINICAL_STAFF'),
(200085, 'Todd', 'Robinson', 'nunc@ategestasa.com', '99624042', 'dapibus', 'lorem', 'RECEPTIONIST'),
(200086, 'Alfreda', 'Summers', 'gravida.non.sollicitudin@Maecenaslibero.net', '99950375', 'sem', 'Maecenas', 'MEDICAL_RECORD_STAFF'),
(200087, 'Ori', 'Francis', 'amet.luctus.vulputate@neque.co.uk', '99635223', 'nibh', 'Curabitur', 'HEALTH_SERVICE_MANAGEMENT'),
(200088, 'Brennan', 'Houston', 'ante.dictum.cursus@arcuVestibulum.net', '99822543', 'non', 'varius.', 'CLINICAL_STAFF'),
(200089, 'Jin', 'Richard', 'sapien@ametfaucibusut.com', '99243223', 'sed', 'eleifend', 'RECEPTIONIST'),
(200090, 'Tiger', 'Underwood', 'cursus.diam@velit.net', '99240530', 'montes,', 'consectetuer', 'MEDICAL_RECORD_STAFF'),
(200091, 'Ashely', 'Levy', 'lacus@malesuadaInteger.co.uk', '99994089', 'enim.', 'quam', 'HEALTH_SERVICE_MANAGEMENT'),
(200092, 'Samantha', 'Pate', 'parturient.montes.nascetur@convalliserat.ca', '99272078', 'fermentum', 'consequat', 'CLINICAL_STAFF'),
(200093, 'Caryn', 'Frye', 'est@consequat.com', '99297122', 'et,', 'orci', 'RECEPTIONIST'),
(200094, 'Ivy', 'Vasquez', 'Ut.nec@semperpretiumneque.org', '99944205', 'Integer', 'In', 'MEDICAL_RECORD_STAFF'),
(200095, 'Nicole', 'Montgomery', 'dui.semper.et@consequat.ca', '99974795', 'Suspendisse', 'pede.', 'HEALTH_SERVICE_MANAGEMENT'),
(200096, 'Alana', 'Munoz', 'posuere.cubilia@lacus.edu', '99984593', 'tempus', 'dolor.', 'CLINICAL_STAFF'),
(200097, 'Idola', 'Avila', 'eu.dolor@vitaeorci.co.uk', '99100624', 'faucibus.', 'vel', 'RECEPTIONIST'),
(200098, 'Angela', 'Vincent', 'iaculis.odio.Nam@pedemalesuadavel.edu', '99408122', 'at', 'at', 'MEDICAL_RECORD_STAFF'),
(200099, 'Chadwick', 'Hood', 'eget.mollis@egettincidunt.com', '99418159', 'dignissim', 'Suspendisse', 'HEALTH_SERVICE_MANAGEMENT');

-- --------------------------------------------------------

--
-- Table structure for table `WARNING_OVERRULED`
--

CREATE TABLE `WARNING_OVERRULED` (
  `clinician` int(11) NOT NULL,
  `warning` text NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `CLINIC`
--
ALTER TABLE `CLINIC`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `COMMENT`
--
ALTER TABLE `COMMENT`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `DECEASED`
--
ALTER TABLE `DECEASED`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `INCIDENT`
--
ALTER TABLE `INCIDENT`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `INCIDENT_BY_PRESCRIPTION`
--
ALTER TABLE `INCIDENT_BY_PRESCRIPTION`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `MEDICINE`
--
ALTER TABLE `MEDICINE`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `REQUEST`
--
ALTER TABLE `REQUEST`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `TREATMENT`
--
ALTER TABLE `TREATMENT`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` mediumint(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;
--
-- AUTO_INCREMENT for table `COMMENT`
--
ALTER TABLE `COMMENT`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `INCIDENT`
--
ALTER TABLE `INCIDENT`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `INCIDENT_BY_PRESCRIPTION`
--
ALTER TABLE `INCIDENT_BY_PRESCRIPTION`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `REQUEST`
--
ALTER TABLE `REQUEST`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `TREATMENT`
--
ALTER TABLE `TREATMENT`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
