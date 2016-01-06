-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2015 at 06:02 AM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DBdiet`
--

-- --------------------------------------------------------

--
-- Table structure for table `ocd`
--

CREATE TABLE IF NOT EXISTS `ocd` (
  `id` int(11) NOT NULL,
  `puasa16` text NOT NULL,
  `puasa18` text NOT NULL,
  `puasa20` text NOT NULL,
  `puasa24` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ocd`
--

INSERT INTO `ocd` (`id`, `puasa16`, `puasa18`, `puasa20`, `puasa24`) VALUES
(1, 'puasa 16 berhasil', 'puasa 18 berhasil', 'puasa 20 berhasil', 'puasa 24 berhasil');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ocd`
--
ALTER TABLE `ocd`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ocd`
--
ALTER TABLE `ocd`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
