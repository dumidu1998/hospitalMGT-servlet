-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 24, 2021 at 01:00 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill_payments`
--

CREATE TABLE `bill_payments` (
  `payment_id` int(11) NOT NULL,
  `hosipitalization_id` int(11) NOT NULL,
  `doctor_fee` decimal(10,2) NOT NULL,
  `hospital_fee` decimal(10,2) NOT NULL,
  `total_medicine_fee` decimal(10,2) NOT NULL,
  `grand_total` decimal(10,2) NOT NULL,
  `remark` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill_payments`
--

INSERT INTO `bill_payments` (`payment_id`, `hosipitalization_id`, `doctor_fee`, `hospital_fee`, `total_medicine_fee`, `grand_total`, `remark`) VALUES
(4, 5, '3500.00', '1500.00', '3050.00', '8050.00', '');

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL,
  `branch_name` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`branch_id`, `branch_name`) VALUES
(1, 'Kandy'),
(2, 'Colombo'),
(6, 'Anuradhapura'),
(7, 'Galle');

-- --------------------------------------------------------

--
-- Table structure for table `branch_transfer`
--

CREATE TABLE `branch_transfer` (
  `transfer_id` int(11) NOT NULL,
  `hospitalization_id` int(11) NOT NULL,
  `reason` varchar(111) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `transferred_branch` int(11) NOT NULL,
  `source_branch` int(11) NOT NULL,
  `appointed_doctor` int(11) NOT NULL,
  `remark` varchar(111) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch_transfer`
--

INSERT INTO `branch_transfer` (`transfer_id`, `hospitalization_id`, `reason`, `date`, `transferred_branch`, `source_branch`, `appointed_doctor`, `remark`) VALUES
(5, 5, 'For Operation', '2021-10-23 22:55:39', 2, 1, 7, 'null');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `name` varchar(111) NOT NULL,
  `specialization` varchar(111) NOT NULL,
  `sex` varchar(111) NOT NULL,
  `nic` varchar(111) NOT NULL,
  `education_qualification` varchar(111) NOT NULL,
  `professional_qualification` varchar(111) NOT NULL,
  `address` varchar(111) NOT NULL,
  `mobile` varchar(111) NOT NULL,
  `email` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctor_id`, `branch_id`, `name`, `specialization`, `sex`, `nic`, `education_qualification`, `professional_qualification`, `address`, `mobile`, `email`) VALUES
(2, 1, 'Duminda Bandara', 'Pediatrician', 'male', 'dumiduraj@gmail.com', '123', '123', '123', '0766533964', '123@g.com'),
(7, 1, 'Kamal Addaraarachchi', 'STD', 'male', '199541236984', 'no', 'NO', 'No. 12, Abayaa rd, col 5', '0766533965', 'tikiri@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `medicine_id` int(11) NOT NULL,
  `brand_name` varchar(111) NOT NULL,
  `medicine_name` varchar(111) NOT NULL,
  `type` varchar(111) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `remark` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`medicine_id`, `brand_name`, `medicine_name`, `type`, `price`, `remark`) VALUES
(5, 'Penadol', 'Penadol', 'Tablet', '2.00', ''),
(6, 'Amoxiline', 'Amoxiline', 'Capsules', '110.00', '');

-- --------------------------------------------------------

--
-- Table structure for table `medicine_issue`
--

CREATE TABLE `medicine_issue` (
  `issue_id` int(11) NOT NULL,
  `hosipitalization_id` int(11) NOT NULL,
  `medicine_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine_issue`
--

INSERT INTO `medicine_issue` (`issue_id`, `hosipitalization_id`, `medicine_id`, `qty`) VALUES
(7, 5, 5, 150),
(8, 5, 6, 25);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL,
  `name` varchar(111) NOT NULL,
  `dob` date NOT NULL,
  `sex` varchar(11) NOT NULL,
  `nic` varchar(111) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(111) NOT NULL,
  `mobile` varchar(111) NOT NULL,
  `email` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patient_id`, `name`, `dob`, `sex`, `nic`, `age`, `address`, `mobile`, `email`) VALUES
(4, 'Kumara Thirimadu', '2021-09-26', 'male', '595900735v', 61, 'No 122', '0766533965', 'dumiduraj@gmail.com'),
(5, 'Chamara Silva', '2021-10-22', 'male', '595900715v', 44, 'No 2', '0766533164', 'tikiri@gmail.com'),
(6, 'Nuwan Perera', '2021-09-30', 'male', '595900115v', 33, '122,Abayagiriya road', '0766531164', 'kamal@gmail.com'),
(7, 'Dushmanth Chameera', '2021-09-26', 'male', '591900735v', 43, 'No 16', '0766533135', 'sisira2@g.com');

-- --------------------------------------------------------

--
-- Table structure for table `pati_hospitalization`
--

CREATE TABLE `pati_hospitalization` (
  `hospitalization_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `reason` varchar(111) NOT NULL,
  `doctor_incharge` int(11) NOT NULL,
  `date_admitted` timestamp NOT NULL DEFAULT current_timestamp(),
  `discharged_date` date DEFAULT NULL,
  `ward_id` int(11) NOT NULL,
  `no_of_days` int(11) DEFAULT NULL,
  `remark` varchar(111) DEFAULT NULL,
  `branch_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pati_hospitalization`
--

INSERT INTO `pati_hospitalization` (`hospitalization_id`, `patient_id`, `reason`, `doctor_incharge`, `date_admitted`, `discharged_date`, `ward_id`, `no_of_days`, `remark`, `branch_id`) VALUES
(5, 4, 'Back Pain Acute', 7, '2021-10-23 22:53:48', NULL, 3, NULL, '', 2),
(6, 5, 'Heart Issue', 7, '2021-10-23 22:54:07', NULL, 3, NULL, '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stock_id` int(11) NOT NULL,
  `medicine_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `unit_pirce` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `branch_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stock_id`, `medicine_id`, `qty`, `unit_pirce`, `total`, `branch_id`) VALUES
(1, 5, 100, '2.00', '1000.00', 1),
(4, 5, 150, '2.00', '300.00', 2),
(5, 6, 1500, '110.00', '165000.00', 2),
(6, 6, 150, '110.00', '16500.00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `role` int(11) NOT NULL COMMENT '1-super 2-branch 3- service desk',
  `username` varchar(111) NOT NULL,
  `email` varchar(111) NOT NULL,
  `password` varchar(111) NOT NULL,
  `branch_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `role`, `username`, `email`, `password`, `branch_id`) VALUES
(5, 1, 'dumi@g.com', 'dumi@g.com', '123123', 1),
(7, 3, 'a@a.aa', 'a@a.aa', '123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ward`
--

CREATE TABLE `ward` (
  `ward_id` int(11) NOT NULL,
  `name` varchar(111) NOT NULL,
  `doctor_incharge` int(11) NOT NULL,
  `purpose` varchar(111) NOT NULL,
  `beds` int(11) NOT NULL,
  `rate` decimal(10,2) NOT NULL,
  `branch_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ward`
--

INSERT INTO `ward` (`ward_id`, `name`, `doctor_incharge`, `purpose`, `beds`, `rate`, `branch_id`) VALUES
(3, 'Age 12 +', 2, '12 + aged', 12, '1500.00', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill_payments`
--
ALTER TABLE `bill_payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `hosipitalization_id` (`hosipitalization_id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`branch_id`);

--
-- Indexes for table `branch_transfer`
--
ALTER TABLE `branch_transfer`
  ADD PRIMARY KEY (`transfer_id`),
  ADD KEY `appointed_doctor` (`appointed_doctor`),
  ADD KEY `source_branch` (`source_branch`),
  ADD KEY `transferred_branch` (`transferred_branch`),
  ADD KEY `hospitalization_id` (`hospitalization_id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctor_id`),
  ADD KEY `branch_id` (`branch_id`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`medicine_id`);

--
-- Indexes for table `medicine_issue`
--
ALTER TABLE `medicine_issue`
  ADD PRIMARY KEY (`issue_id`),
  ADD KEY `hosipitalization_id` (`hosipitalization_id`),
  ADD KEY `medicine_id` (`medicine_id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `pati_hospitalization`
--
ALTER TABLE `pati_hospitalization`
  ADD PRIMARY KEY (`hospitalization_id`),
  ADD KEY `pati_hospitalization_ibfk_1` (`doctor_incharge`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `ward_id` (`ward_id`),
  ADD KEY `branch_id` (`branch_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stock_id`),
  ADD KEY `branch_id` (`branch_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `branch_id` (`branch_id`);

--
-- Indexes for table `ward`
--
ALTER TABLE `ward`
  ADD PRIMARY KEY (`ward_id`),
  ADD KEY `doctor_incharge` (`doctor_incharge`),
  ADD KEY `branch_id` (`branch_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill_payments`
--
ALTER TABLE `bill_payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `branch_transfer`
--
ALTER TABLE `branch_transfer`
  MODIFY `transfer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `medicine_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `medicine_issue`
--
ALTER TABLE `medicine_issue`
  MODIFY `issue_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patient_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pati_hospitalization`
--
ALTER TABLE `pati_hospitalization`
  MODIFY `hospitalization_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ward`
--
ALTER TABLE `ward`
  MODIFY `ward_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill_payments`
--
ALTER TABLE `bill_payments`
  ADD CONSTRAINT `bill_payments_ibfk_1` FOREIGN KEY (`hosipitalization_id`) REFERENCES `pati_hospitalization` (`hospitalization_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `branch_transfer`
--
ALTER TABLE `branch_transfer`
  ADD CONSTRAINT `branch_transfer_ibfk_1` FOREIGN KEY (`appointed_doctor`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `branch_transfer_ibfk_2` FOREIGN KEY (`source_branch`) REFERENCES `branch` (`branch_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `branch_transfer_ibfk_3` FOREIGN KEY (`transferred_branch`) REFERENCES `branch` (`branch_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `branch_transfer_ibfk_4` FOREIGN KEY (`hospitalization_id`) REFERENCES `pati_hospitalization` (`hospitalization_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medicine_issue`
--
ALTER TABLE `medicine_issue`
  ADD CONSTRAINT `medicine_issue_ibfk_1` FOREIGN KEY (`hosipitalization_id`) REFERENCES `pati_hospitalization` (`hospitalization_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `medicine_issue_ibfk_2` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`medicine_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pati_hospitalization`
--
ALTER TABLE `pati_hospitalization`
  ADD CONSTRAINT `pati_hospitalization_ibfk_1` FOREIGN KEY (`doctor_incharge`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pati_hospitalization_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pati_hospitalization_ibfk_3` FOREIGN KEY (`ward_id`) REFERENCES `ward` (`ward_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pati_hospitalization_ibfk_4` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ward`
--
ALTER TABLE `ward`
  ADD CONSTRAINT `ward_ibfk_1` FOREIGN KEY (`doctor_incharge`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ward_ibfk_2` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
