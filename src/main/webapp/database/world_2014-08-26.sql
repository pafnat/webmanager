-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.29 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных world
DROP DATABASE IF EXISTS `world`;
CREATE DATABASE IF NOT EXISTS `world` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `world`;


-- Дамп структуры для таблица world.city
DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(64) NOT NULL DEFAULT '',
  `CountryCode` varchar(10) NOT NULL DEFAULT '',
  `District` varchar(128) NOT NULL DEFAULT '',
  `Population` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы world.city: ~1 rows (приблизительно)
DELETE FROM `city`;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`id`, `Name`, `CountryCode`, `District`, `Population`) VALUES
	(1, 'Phoenix', 'USA', 'Arizona', 486699),
	(2, 'Birmingham', 'USA', 'Alabama', 242820);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


-- Дамп структуры для таблица world.country
DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Capital` varchar(128) NOT NULL,
  `Code` varchar(128) NOT NULL,
  `Code2` varchar(128) NOT NULL,
  `Continent` varchar(128) NOT NULL,
  `GNP` double NOT NULL,
  `GNPOld` double NOT NULL,
  `GovernmentForm` varchar(128) NOT NULL,
  `HeadOfState` varchar(128) NOT NULL,
  `IndepYear` int(11) NOT NULL,
  `LifeExpectancy` int(11) NOT NULL,
  `LocalName` varchar(128) NOT NULL,
  `Name` varchar(128) NOT NULL,
  `Population` int(11) NOT NULL,
  `Region` varchar(128) NOT NULL,
  `SurfaceArea` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы world.country: 1 rows
DELETE FROM `country`;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`id`, `Capital`, `Code`, `Code2`, `Continent`, `GNP`, `GNPOld`, `GovernmentForm`, `HeadOfState`, `IndepYear`, `LifeExpectancy`, `LocalName`, `Name`, `Population`, `Region`, `SurfaceArea`) VALUES
	(1, 'ANGOLA', 'AGO', 'C2', 'North America', 0, 0, 'Unknown', 'George Bush', 100, 100, 'Angola', 'New', 100000, 'Corribean', 100);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


-- Дамп структуры для таблица world.userinfo
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE IF NOT EXISTS `userinfo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL DEFAULT '',
  `Password` varchar(45) NOT NULL DEFAULT '',
  `AuthLevel` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы world.userinfo: ~3 rows (приблизительно)
DELETE FROM `userinfo`;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` (`id`, `UserName`, `Password`, `AuthLevel`) VALUES
	(1, 'admin', '99admin', 2),
	(2, 'infinite_skills', '1234567', 1),
	(3, 'dbuser', '12dbuser', 2);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
