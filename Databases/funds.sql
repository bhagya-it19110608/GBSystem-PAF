-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 03:19 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `funds`
--

-- --------------------------------------------------------

--
-- Table structure for table `fund`
--

CREATE TABLE `fund` (
  `idfund` int(11) NOT NULL,
  `projectID` char(20) DEFAULT NULL,
  `reasercherID` char(20) DEFAULT NULL,
  `clientID` char(20) DEFAULT NULL,
  `fundAmount` decimal(20,2) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fund`
--

INSERT INTO `fund` (`idfund`, `projectID`, `reasercherID`, `clientID`, `fundAmount`, `status`) VALUES
(3, 'P004', 'R9099', 'C001', '2000000.00', 'approved'),
(4, 'P005', 'R9091', 'C1103', '50000.00', 'approved'),
(5, 'P006', 'R9090', 'C1111', '35000.00', 'pending'),
(7, 'P012', 'R9095', 'C1109', '40000.00', 'pending'),
(8, 'P009', 'R9092', 'C1108', '50000.00', 'approved');

-- --------------------------------------------------------

--
-- Table structure for table `fundrequest`
--

CREATE TABLE `fundrequest` (
  `id` int(11) NOT NULL,
  `reasercherID` char(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `reaserchName` varchar(100) DEFAULT NULL,
  `requestingAmount` decimal(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fundrequest`
--

INSERT INTO `fundrequest` (`id`, `reasercherID`, `name`, `email`, `phone`, `reaserchName`, `requestingAmount`) VALUES
(1, 'R9090', 'Chaveena De silva', 'chaveena@gmail.com', '0912260944', 'Employee Manement Software', '70000.00'),
(2, 'R9095', 'Nipuna Dhananjaya', 'nipuna@yahoo.com', '0717568169', 'Studence Attendence Marking System', '40000.00'),
(3, 'R9100', 'Dewindi Gamage', 'nipuna@yahoo.com', '0913355900', 'TimeTable Manaement System', '80000.00'),
(4, 'R9092', 'Kushani Ptigala', 'kushani@gmail.com', '0786788965', 'School Management System', '50000.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fund`
--
ALTER TABLE `fund`
  ADD PRIMARY KEY (`idfund`);

--
-- Indexes for table `fundrequest`
--
ALTER TABLE `fundrequest`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fund`
--
ALTER TABLE `fund`
  MODIFY `idfund` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `fundrequest`
--
ALTER TABLE `fundrequest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
