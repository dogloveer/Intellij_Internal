-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Wersja serwera:               11.3.0-MariaDB - mariadb.org binary distribution
-- Serwer OS:                    Win64
-- HeidiSQL Wersja:              12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Zrzut struktury bazy danych oginternal
CREATE DATABASE IF NOT EXISTS `oginternal` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci */;
USE `oginternal`;

-- Zrzut struktury tabela oginternal.focus
CREATE TABLE IF NOT EXISTS `focus` (
  `focus_id` int(11) NOT NULL AUTO_INCREMENT,
  `focus_name` varchar(50) NOT NULL DEFAULT '0',
  `focus_time` int(11) NOT NULL,
  PRIMARY KEY (`focus_id`),
  KEY `focus_time` (`focus_time`),
  CONSTRAINT `FK_focus_focustime` FOREIGN KEY (`focus_time`) REFERENCES `focustime` (`focustime_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Zrzucanie danych dla tabeli oginternal.focus: ~5 rows (około)
INSERT INTO `focus` (`focus_id`, `focus_name`, `focus_time`) VALUES
	(1, 'aerobics', 2),
	(2, 'bodyweight excercises', 3),
	(3, 'crossfit', 5),
	(4, 'stretching', 1),
	(5, 'weight training', 4);

-- Zrzut struktury tabela oginternal.focustime
CREATE TABLE IF NOT EXISTS `focustime` (
  `focustime_id` int(11) NOT NULL AUTO_INCREMENT,
  `focustime_time` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`focustime_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Zrzucanie danych dla tabeli oginternal.focustime: ~5 rows (około)
INSERT INTO `focustime` (`focustime_id`, `focustime_time`) VALUES
	(1, 30),
	(2, 45),
	(3, 60),
	(4, 90),
	(5, 50);

-- Zrzut struktury tabela oginternal.materials
CREATE TABLE IF NOT EXISTS `materials` (
  `materials_id` int(11) NOT NULL AUTO_INCREMENT,
  `materials_name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`materials_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Zrzucanie danych dla tabeli oginternal.materials: ~6 rows (około)
INSERT INTO `materials` (`materials_id`, `materials_name`) VALUES
	(1, 'sport shoes'),
	(2, 'towel'),
	(3, 'yoga mat'),
	(4, 'jumprope '),
	(5, 'sport bands'),
	(6, 'bottle of water');

-- Zrzut struktury tabela oginternal.materialstofocus
CREATE TABLE IF NOT EXISTS `materialstofocus` (
  `materialstofocus_id` int(11) NOT NULL AUTO_INCREMENT,
  `materialstofocus_focus` int(11) NOT NULL,
  `materialstofocus_materials` int(11) NOT NULL,
  PRIMARY KEY (`materialstofocus_id`),
  KEY `materialstofocus_focus` (`materialstofocus_focus`),
  KEY `materials_materials` (`materialstofocus_materials`),
  CONSTRAINT `FK_materialstofocus_focus` FOREIGN KEY (`materialstofocus_focus`) REFERENCES `focus` (`focus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_materialstofocus_materials` FOREIGN KEY (`materialstofocus_materials`) REFERENCES `materials` (`materials_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Zrzucanie danych dla tabeli oginternal.materialstofocus: ~18 rows (około)
INSERT INTO `materialstofocus` (`materialstofocus_id`, `materialstofocus_focus`, `materialstofocus_materials`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 1, 6),
	(5, 2, 1),
	(6, 2, 2),
	(7, 2, 3),
	(8, 2, 5),
	(9, 2, 6),
	(10, 3, 1),
	(11, 3, 4),
	(12, 3, 6),
	(13, 4, 3),
	(14, 4, 6),
	(15, 5, 1),
	(16, 5, 2),
	(17, 5, 4),
	(18, 5, 6);

-- Zrzut struktury tabela oginternal.trener
CREATE TABLE IF NOT EXISTS `trener` (
  `trener_id` int(11) NOT NULL AUTO_INCREMENT,
  `trener_name` varchar(50) NOT NULL DEFAULT '0',
  `trener_surname` varchar(50) NOT NULL DEFAULT '0',
  `trener_age` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`trener_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Zrzucanie danych dla tabeli oginternal.trener: ~7 rows (około)
INSERT INTO `trener` (`trener_id`, `trener_name`, `trener_surname`, `trener_age`) VALUES
	(1, 'Erica', 'Con', 27),
	(2, 'John ', 'Oswald', 35),
	(3, 'Nina', 'Bailey', 25),
	(4, 'Benny', 'Larkin', 22),
	(5, 'Cristal ', 'Blackburn', 30),
	(6, 'Joseph', 'Turner', 32),
	(7, 'Bethany', 'Jordan', 26);

-- Zrzut struktury tabela oginternal.trenertofocus
CREATE TABLE IF NOT EXISTS `trenertofocus` (
  `trenertofocus_id` int(11) NOT NULL AUTO_INCREMENT,
  `trenertofocus_trener` int(11) NOT NULL DEFAULT 0,
  `trenertofocus_focus` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`trenertofocus_id`),
  KEY `trenertofocus_trener` (`trenertofocus_trener`),
  KEY `trenertofocus_focus` (`trenertofocus_focus`),
  CONSTRAINT `FK_trenertofocus_focus` FOREIGN KEY (`trenertofocus_focus`) REFERENCES `focus` (`focus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_trenertofocus_trener` FOREIGN KEY (`trenertofocus_trener`) REFERENCES `trener` (`trener_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Zrzucanie danych dla tabeli oginternal.trenertofocus: ~12 rows (około)
INSERT INTO `trenertofocus` (`trenertofocus_id`, `trenertofocus_trener`, `trenertofocus_focus`) VALUES
	(2, 1, 1),
	(3, 1, 4),
	(5, 2, 5),
	(6, 3, 2),
	(7, 3, 5),
	(8, 4, 3),
	(9, 4, 5),
	(11, 5, 2),
	(12, 5, 4),
	(13, 6, 3),
	(14, 7, 1),
	(16, 7, 2);

-- Zrzut struktury tabela oginternal.username
CREATE TABLE IF NOT EXISTS `username` (
  `username_id` int(11) NOT NULL AUTO_INCREMENT,
  `username_name` varchar(50) NOT NULL,
  `username_surname` varchar(50) NOT NULL,
  `username_focus` int(11) DEFAULT 0,
  `username_email` varchar(50) NOT NULL,
  `username_username` varchar(50) NOT NULL,
  `username_password` varchar(50) NOT NULL,
  `username_age` int(10) unsigned NOT NULL,
  PRIMARY KEY (`username_id`),
  KEY `username_focus` (`username_focus`),
  CONSTRAINT `FK__focus` FOREIGN KEY (`username_focus`) REFERENCES `focus` (`focus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Zrzucanie danych dla tabeli oginternal.username: ~2 rows (około)
INSERT INTO `username` (`username_id`, `username_name`, `username_surname`, `username_focus`, `username_email`, `username_username`, `username_password`, `username_age`) VALUES
	(1, 'Ala', 'Drozdz', 5, 'ala@gmail.com', 'alade', '1', 18),
	(2, 'Natalia', 'Buczak', 1, 'n@n.pl', 'nb', '2', 20);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
