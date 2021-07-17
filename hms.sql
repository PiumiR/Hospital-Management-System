-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2020 at 08:33 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

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
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `A_Id` int(11) NOT NULL,
  `Description` varchar(60) NOT NULL,
  `Status` varchar(30) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `token_No` int(11) NOT NULL,
  `DoctorId` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bed`
--

CREATE TABLE `bed` (
  `Bed_Id` int(11) NOT NULL,
  `Bed_type` varchar(20) NOT NULL,
  `Room_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `docphoneno`
--

CREATE TABLE `docphoneno` (
  `DoctorId` varchar(15) NOT NULL,
  `DocPhoneNo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `DoctorId` varchar(15) NOT NULL,
  `DoctorIDValid` date NOT NULL,
  `DoctorName` varchar(20) NOT NULL,
  `Speciality` varchar(20) NOT NULL,
  `DocAvailability` varchar(5) NOT NULL,
  `DateTime` datetime NOT NULL DEFAULT current_timestamp(),
  `RoomNo` int(11) NOT NULL,
  `ChannelingRange` int(11) NOT NULL,
  `ChannelingCharge` float NOT NULL,
  `e-mail` varchar(20) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `drug`
--

CREATE TABLE `drug` (
  `DrugId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Mgs` double NOT NULL,
  `ReOrderQty` int(11) NOT NULL,
  `Prescription` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `labpatient`
--

CREATE TABLE `labpatient` (
  `LabTestId` int(11) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `lab_test`
--

CREATE TABLE `lab_test` (
  `LabTestId` int(11) NOT NULL,
  `TestName` varchar(20) NOT NULL,
  `TestCharge` float NOT NULL,
  `RoomNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order1`
--

CREATE TABLE `order1` (
  `StockID` int(11) NOT NULL,
  `DrugID` int(11) NOT NULL,
  `ExpDate` date NOT NULL,
  `ManuDate` date NOT NULL,
  `PriceTo` double NOT NULL,
  `PriceFrom` double NOT NULL,
  `NoOfTablets` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `User_Id` int(11) NOT NULL,
  `Title` varchar(10) NOT NULL,
  `FullName` varchar(20) NOT NULL,
  `Dob` date NOT NULL DEFAULT current_timestamp(),
  `Age` int(11) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Bill_No` int(11) NOT NULL,
  `Payers_Name` varchar(20) NOT NULL,
  `Card_No` varchar(20) DEFAULT NULL,
  `Expiry_Date` date DEFAULT NULL,
  `Amount` double NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pharmacybill`
--

CREATE TABLE `pharmacybill` (
  `Bill_No` int(11) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `DoctorName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pharmacydrug`
--

CREATE TABLE `pharmacydrug` (
  `Bill_No` int(11) NOT NULL,
  `DrugId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `Room_No` int(11) NOT NULL,
  `Status` tinyint(1) NOT NULL,
  `Wd_No` int(11) NOT NULL,
  `Rt_Id` int(11) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `In_Date` date NOT NULL DEFAULT current_timestamp(),
  `Out_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `room_type`
--

CREATE TABLE `room_type` (
  `Rt_Id` int(11) NOT NULL,
  `Rt_name` varchar(20) NOT NULL,
  `Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ward`
--

CREATE TABLE `ward` (
  `Wd_No` int(11) NOT NULL,
  `W_Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`A_Id`),
  ADD KEY `fk_appointmentUser` (`User_Id`),
  ADD KEY `fk_appointmentDoc` (`DoctorId`);

--
-- Indexes for table `bed`
--
ALTER TABLE `bed`
  ADD PRIMARY KEY (`Bed_Id`),
  ADD KEY `fk_roomNo` (`Room_No`);

--
-- Indexes for table `docphoneno`
--
ALTER TABLE `docphoneno`
  ADD PRIMARY KEY (`DocPhoneNo`) USING BTREE,
  ADD KEY `fk_docId` (`DoctorId`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`DoctorId`),
  ADD UNIQUE KEY `NIC` (`NIC`),
  ADD UNIQUE KEY `e-mail` (`e-mail`);

--
-- Indexes for table `drug`
--
ALTER TABLE `drug`
  ADD PRIMARY KEY (`DrugId`);

--
-- Indexes for table `labpatient`
--
ALTER TABLE `labpatient`
  ADD KEY `fk_labTestId` (`LabTestId`),
  ADD KEY `fk_labUserId` (`User_Id`);

--
-- Indexes for table `lab_test`
--
ALTER TABLE `lab_test`
  ADD PRIMARY KEY (`LabTestId`),
  ADD UNIQUE KEY `TestName` (`TestName`);

--
-- Indexes for table `order1`
--
ALTER TABLE `order1`
  ADD PRIMARY KEY (`StockID`,`DrugID`) USING BTREE,
  ADD KEY `drug_constraint` (`DrugID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`User_Id`),
  ADD UNIQUE KEY `Phone` (`Phone`),
  ADD UNIQUE KEY `NIC` (`NIC`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Bill_No`),
  ADD KEY `fk_paymentUser` (`User_Id`);

--
-- Indexes for table `pharmacybill`
--
ALTER TABLE `pharmacybill`
  ADD PRIMARY KEY (`Bill_No`),
  ADD KEY `fk_pharmacyUser` (`User_Id`);

--
-- Indexes for table `pharmacydrug`
--
ALTER TABLE `pharmacydrug`
  ADD PRIMARY KEY (`Bill_No`,`DrugId`),
  ADD KEY `fk_drug` (`DrugId`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`Room_No`),
  ADD KEY `fk_wdNo` (`Wd_No`),
  ADD KEY `fk_rtId` (`Rt_Id`),
  ADD KEY `fk_userId` (`User_Id`);

--
-- Indexes for table `room_type`
--
ALTER TABLE `room_type`
  ADD PRIMARY KEY (`Rt_Id`),
  ADD UNIQUE KEY `Rt_name` (`Rt_name`);

--
-- Indexes for table `ward`
--
ALTER TABLE `ward`
  ADD PRIMARY KEY (`Wd_No`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `A_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bed`
--
ALTER TABLE `bed`
  MODIFY `Bed_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `drug`
--
ALTER TABLE `drug`
  MODIFY `DrugId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lab_test`
--
ALTER TABLE `lab_test`
  MODIFY `LabTestId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order1`
--
ALTER TABLE `order1`
  MODIFY `StockID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `User_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Bill_No` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pharmacybill`
--
ALTER TABLE `pharmacybill`
  MODIFY `Bill_No` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `Room_No` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `room_type`
--
ALTER TABLE `room_type`
  MODIFY `Rt_Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ward`
--
ALTER TABLE `ward`
  MODIFY `Wd_No` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `fk_appointmentDoc` FOREIGN KEY (`DoctorId`) REFERENCES `doctor` (`DoctorId`),
  ADD CONSTRAINT `fk_appointmentUser` FOREIGN KEY (`User_Id`) REFERENCES `patient` (`User_Id`);

--
-- Constraints for table `bed`
--
ALTER TABLE `bed`
  ADD CONSTRAINT `fk_roomNo` FOREIGN KEY (`Room_No`) REFERENCES `room` (`Room_No`);

--
-- Constraints for table `docphoneno`
--
ALTER TABLE `docphoneno`
  ADD CONSTRAINT `fk_docId` FOREIGN KEY (`DoctorId`) REFERENCES `doctor` (`DoctorId`);

--
-- Constraints for table `labpatient`
--
ALTER TABLE `labpatient`
  ADD CONSTRAINT `fk_labTestId` FOREIGN KEY (`LabTestId`) REFERENCES `lab_test` (`LabTestId`),
  ADD CONSTRAINT `fk_labUserId` FOREIGN KEY (`User_Id`) REFERENCES `patient` (`User_Id`);

--
-- Constraints for table `order1`
--
ALTER TABLE `order1`
  ADD CONSTRAINT `drug_constraint` FOREIGN KEY (`DrugID`) REFERENCES `drug` (`DrugId`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fk_paymentUser` FOREIGN KEY (`User_Id`) REFERENCES `patient` (`User_Id`);

--
-- Constraints for table `pharmacybill`
--
ALTER TABLE `pharmacybill`
  ADD CONSTRAINT `fk_pharmacyUser` FOREIGN KEY (`User_Id`) REFERENCES `patient` (`User_Id`);

--
-- Constraints for table `pharmacydrug`
--
ALTER TABLE `pharmacydrug`
  ADD CONSTRAINT `fk_biilNo` FOREIGN KEY (`Bill_No`) REFERENCES `pharmacybill` (`Bill_No`),
  ADD CONSTRAINT `fk_drug` FOREIGN KEY (`DrugId`) REFERENCES `drug` (`DrugId`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `fk_rtId` FOREIGN KEY (`Rt_Id`) REFERENCES `room_type` (`Rt_Id`),
  ADD CONSTRAINT `fk_userId` FOREIGN KEY (`User_Id`) REFERENCES `patient` (`User_Id`),
  ADD CONSTRAINT `fk_wdNo` FOREIGN KEY (`Wd_No`) REFERENCES `ward` (`Wd_No`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
