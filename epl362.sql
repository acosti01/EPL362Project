-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 19, 2017 at 01:35 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `epl362`
--

-- --------------------------------------------------------

--
-- Table structure for table `Allergy`
--

CREATE TABLE `Allergy` (
  `ALLERGY_NAME` varchar(45) NOT NULL,
  `DRUGS` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Appointment`
--

CREATE TABLE `Appointment` (
  `PATIENTID` int(8) UNSIGNED NOT NULL,
  `CLINICNAME` varchar(45) NOT NULL,
  `APPOINT_DATE` datetime NOT NULL,
  `MISSED_APPOINT` tinyint(1) NOT NULL,
  `SUPER_DOCTOR` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Clinic`
--

CREATE TABLE `Clinic` (
  `NAME` varchar(45) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `TELEPHONE` int(10) NOT NULL,
  `LOCATION` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Conditions`
--

CREATE TABLE `Conditions` (
  `DESCRIPTION` varchar(100) NOT NULL,
  `PRESCRIPTION` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `ID` int(8) UNSIGNED NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `CANEDIT` tinyint(1) NOT NULL,
  `CANACCESS` tinyint(1) NOT NULL,
  `ISATWORK` tinyint(1) NOT NULL,
  `PATIENTS` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `Nurse`
--

CREATE TABLE `Nurse` (
  `ID` int(8) UNSIGNED NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `SURNAME` varchar(45) NOT NULL,
  `CANEDIT` tinyint(1) NOT NULL,
  `CANACCESS` tinyint(1) NOT NULL,
  `ISATWORK` tinyint(1) NOT NULL,
  `PATIENTS` varchar(45) NOT NULL,
  `ATVISIT` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Patient`
--

CREATE TABLE `Patient` (
  `ID` int(8) UNSIGNED NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `SURNAME` varchar(45) NOT NULL,
  `ADDRESS` varchar(65) NOT NULL,
  `ISHOMELESS` tinyint(1) NOT NULL,
  `ISALIVE` tinyint(1) NOT NULL,
  `RISKINDICATOR` enum('VeryLow','Low','High','VeryHigh') NOT NULL,
  `APPOINTMENTS` varchar(50) NOT NULL,
  `CONDITIONS` varchar(50) NOT NULL,
  `ALLERGY` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Prescription`
--

CREATE TABLE `Prescription` (
  `DRUG_NAME` varchar(45) NOT NULL,
  `DOSAGE` decimal(8,0) NOT NULL,
  `SIDE_EFFECTS` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Receptionist`
--

CREATE TABLE `Receptionist` (
  `ID` int(8) UNSIGNED NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `SURNAME` varchar(45) NOT NULL,
  `CANEDIT` tinyint(1) NOT NULL,
  `CANACCESS` tinyint(1) NOT NULL,
  `ISATWORK` tinyint(1) NOT NULL,
  `APPOINTMENTS` varchar(45) NOT NULL,
  `PRESCRIPTION` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Appointment`
--
ALTER TABLE `Appointment`
  ADD PRIMARY KEY (`PATIENTID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Nurse`
--
ALTER TABLE `Nurse`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Patient`
--
ALTER TABLE `Patient`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Receptionist`
--
ALTER TABLE `Receptionist`
  ADD PRIMARY KEY (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
