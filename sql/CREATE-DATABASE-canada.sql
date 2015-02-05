-- -----------------------------------------------------------------------------
-- MYSQL BOOTSTRAP SCRIPT FOR CANADIAN STATION DATA
-- use this script from the command line to create a complete canada database
--   % mysql < CREATE-database-CANADA.sql
-- -----------------------------------------------------------------------------
-- HISTORY
-- -----------------------------------------------------------------------------
-- 01/14/15 - fix clazz length - change from 2 to 3 chars
-- 06/01/14 - rename database from 'canada' to 'ic_bdbs' 
--            all FCC databases now have the 'ic_' prefix
-- 03/19/14 - allow null erpvpk entries - NULL for AM, required for all others
--            same for ehaat - null or AM, required for all others
--            remove the table tvstatio_staging - FCC Data is duplicatative  of 
--            and identical to our own SQL query
-- 01/04/13 - add tvstatio_staging table, loaded from FCC extracted data
-- 12/18/12 - fix feeds lat/long fields from float to string
--          - change float to double
-- 08/13/12 - add staging table for WSIF builder ca_station_staging
-- 08/13/12 - fix misspelled ehaatt to ehaat
-- 08/04/12 - redesign with KB table ca_station, consolidated FK and functions
-- 08/03/12 - add custom fields to enable foreign keys
-- 08/02/12 - created

-- -----------------------------------------------------------------------------
-- CREATE THE DATABASE
-- -----------------------------------------------------------------------------
--
DROP DATABASE IF EXISTS ic_bdbs;
CREATE DATABASE ic_bdbs;
USE ic_bdbs;


-- -----------------------------------------------------------------------------
-- Function asdate
-- Converts string encoded data information into a date instance
--   encoding strategy is: yyyyMMDD
-- This method is called from the JPA dynamically-generated SQL script to load
-- the ca_station table.
-- -----------------------------------------------------------------------------
DROP function if EXISTS ic_bdbs.asdate;
DELIMITER //
CREATE FUNCTION ic_bdbs.asdate(col char(8)) 
  RETURNS DATE
  DETERMINISTIC
  READS SQL DATA
  BEGIN 
  DECLARE d DATE;
    SET d =  concat(substr(col,1,4),"-",substr(col,5,2) ,"-",substr(col,7,2));
    IF d = date("0000-00-00") THEN SET d = DATE("1900-01-01");
    END IF;
    RETURN d;
END // 
DELIMITER ;


-- -----------------------------------------------------------------------------
-- Function DMS2DEC
-- Converts string encoded DMS information into a decimal number
--   encoding strategy is: 503720 = 50' 37" 20s
-- This method is called from the JPA dynamically-generated SQL script to load
-- the ca_station table.
-- -----------------------------------------------------------------------------
DROP function if EXISTS ic_bdbs.dms2dec;
DELIMITER //
CREATE FUNCTION ic_bdbs.dms2dec(col varchar(7)) 
  RETURNS double
  DETERMINISTIC
  READS SQL DATA
  BEGIN 
  DECLARE d double;
    IF LENGTH(col) = 7 THEN SET d =  substr(col,1,3) + substr(col,4,2)/60 + substr(col,6,2)/3600;
    ELSE SET d =  substr(col,1,2) + substr(col,3,2)/60 + substr(col,5,2)/3600;
    END IF;
    RETURN d;
END // 
DELIMITER ;



-- -----------------------------------------------------------------------------
-- CREATE THE TABLES
-- Order is important:
--  1  ca_station
--  2  apatdesc
--  3  apatstat
--  4  apatdat
--  ...  contours, comment, tsid, etc.
-- -----------------------------------------------------------------------------

-- -----------------------------------------------------------------------------
-- 1 CA_STATION  (KEY BRIDGE TABLE)
-- -----------------------------------------------------------------------------
-- Generic container for all station type, differentiated by the station_type field
DROP TABLE IF EXISTS `ca_station`;
CREATE TABLE `ca_station` (
  `station_type` varchar(16) NOT NULL,
  `banner` char(2) NOT NULL,
  `call_sign` varchar(12) NOT NULL,
  `channel` int(11) NOT NULL,
  `erpvpk` double ,   -- null for AM, required for FM, TV, SDAR
  `ehaat` double ,    -- null for AM, required for FM, TV, SDAR
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `alloc_zone` int(11),
  `ant_mode` char(1),
  `auto_prog` varchar(1),
  `bc_mode` char(1),
  `beam_tilt` double,
  `border` double,
  `brdr_lat` char(6),
  `brdr_long` char(7),
  `can_land` double,
  `cert_numb` char(6),
  `city` varchar(25),
  `clazz` char(3),
  `close_cap` char(1),
  `dec_number` int(11),
  `doc_file` int(11),
  `erpaav` double,
  `erpapk` double,
  `erpata` int(11),
  `erphav` double,
  `erphpk` double,
  `erpvav` double,
  `erpvta` double,
  `euvalu` double,
  `fre_land` double,
  `frequency` double,
  `ground_lev` double,
  `ifrbn_d` double,
  `ifrbn_n` double,
  `latitude2` char(6),
  `limit_code` varchar(8),
  `longitude2` char(7),
  `network` char(4),
  `off_prec` char(1),
  `offset` char(1),
  `ok_dump` date,
  `overall_h` double,
  `par_rms_c` double,
  `par_rms_d` double,
  `par_rms_n` double,
  `powercrit` double,
  `powerday` double,
  `powernight` double,
  `province` char(2),
  `q_crit` double,
  `q_day` double,
  `q_night` double,
  `rad_center` double,
  `scmo` char(1),
  `ss_code` char(5),
  `st_creat` date,
  `st_mod` date,
  `status1` char(2),
  `status2` char(2),
  `unattended` char(1),
  `usa_land` double,
  PRIMARY KEY (`call_sign`,`banner`),
  KEY (`station_type`),
  KEY (`channel`),
  KEY (`latitude`),
  KEY (`longitude`)  
) ENGINE=MyISAM;

-- -----------------------------------------------------------------------------
-- 2, 3, 4 ANTENNA DETAIL
-- -----------------------------------------------------------------------------
-- Description record of antenna patterns
DROP TABLE IF EXISTS `apatdesc`;
CREATE TABLE `apatdesc` (
  `patt_key` int(11) DEFAULT '0',
  `hor_ver` varchar(1),
  `patt_numb` double,
  `patt_type` varchar(12),
  `punits` double,
  `numpoints` double,
  `patt_date` char(8),
  PRIMARY KEY (`patt_key`)
) ENGINE=MyISAM;

-- Data records for antenna pattern points (FM, TV)
DROP TABLE IF EXISTS `apatdat`;
CREATE TABLE `apatdat` (
  `patt_key` int(11) DEFAULT '0',
  `angle` double DEFAULT '0',
  `gain` double DEFAULT '0',
  PRIMARY KEY (`patt_key`,`angle`,`gain`),
  FOREIGN KEY (patt_key) REFERENCES apatdesc (patt_key) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- Lookup table connecting antenna patters to call sign/banners
DROP TABLE IF EXISTS `apatstat`;
CREATE TABLE `apatstat` (
  `calls_banr` varchar(32),  -- hide for MyISAM
  `patt_key` int(11) DEFAULT '0',
  `call_sign` varchar(12),
  `banner` char(2),
  PRIMARY KEY (`calls_banr`,`patt_key`), -- hide for MyISAM
--  KEY `patt_key` (`patt_key`),
--  KEY `call_sign` (`call_sign`),
--  KEY `call_sign_2` (`call_sign`,`banner`)
  -- Reference to the antenna record
  FOREIGN KEY (patt_key) REFERENCES apatdesc (patt_key) ON UPDATE CASCADE ON DELETE CASCADE,
  -- Reference to the generic station
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- -----------------------------------------------------------------------------
-- ... Everything else COMMENT, CONTOUR, TSID
-- -----------------------------------------------------------------------------
-- AM station augmentations
DROP TABLE IF EXISTS `augment`;
CREATE TABLE `augment` (
  `calls_banr` varchar(32),
  `dnc_code` varchar(1),
  `number` double DEFAULT '0',
  `radiation` int(11),
  `center_az` int(11),
  `span` int(11),
  `call_sign` varchar(12),
  `banner` char(2),
  PRIMARY KEY (`calls_banr`,`dnc_code`,`number`),
--  PRIMARY KEY (`call_sign`,`banner`,`dnc_code`,`number`),
  KEY `call_sign` (`call_sign`),
  -- Reference to the generic station
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- Comments of all station types (contains the contact information)
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `calls_banr` varchar(32),
  `name` varchar(40),
  `addr1` varchar(40),
  `addr2` varchar(40),
  `addr3` varchar(40),
  `addr4` varchar(40),
  `hqcomm` int(11),
  `rgcomm` int(11),
  `edetails` int(11),
  `fdetails` int(11),
  `call_sign` varchar(12),
  `banner` char(2),
  PRIMARY KEY (`calls_banr`),
-- ISAM ONLY PRIMARY KEY (`call_sign`,`banner`),
  KEY `call_sign` (`call_sign`),
  KEY `banner` (`banner`),
  -- Reference to the generic station
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- Station contours of FM and TV stations
DROP TABLE IF EXISTS `contours`;
CREATE TABLE `contours` (
  `calls_banr` varchar(32),
  `azimuth` double DEFAULT '0',
  `valu_dist` double DEFAULT '0',
  `name` varchar(4),
  `lat_end` double,
  `long_end` double,
  `call_sign` varchar(12),
  `banner` char(2),
  PRIMARY KEY (`calls_banr`,`azimuth`,`valu_dist`),
  KEY `call_sign` (`call_sign`),
  KEY `banner` (`banner`),
  -- Reference to the generic station
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- AM stations extended hours of operation
DROP TABLE IF EXISTS `extend`;
CREATE TABLE `extend` (
  `calls_banr` varchar(32),
  `number` double,
  `ant_system` varchar(1),
  `start1` varchar(4),
  `end1` varchar(4),
  `start2` double,
  `end2` double,
  `power` double,
  `rms` int(11),
  `call_sign` varchar(12),
  `banner` char(2),
  PRIMARY KEY (`calls_banr`),
-- ISAM ONLY
--  PRIMARY KEY (`call_sign`,`banner`),
  KEY `call_sign` (`call_sign`),  
  KEY `banner` (`banner`),
  -- Reference to the generic station
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- Source of feed signals
DROP TABLE IF EXISTS `feeds`;
CREATE TABLE `feeds` (
  `calls_banr` varchar(32),
  `feed_id` varchar(1),
  `feed_chan` double,
  `link_type` varchar(1),
  `feed_call` varchar(12),
  `feed_lat` varchar(7),
  `feed_long` varchar(8),
  `call_sign` varchar(12),
  `banner` char(2),
  PRIMARY KEY (`calls_banr`),
-- ISAM ONLY
--  PRIMARY KEY (`call_sign`,`banner`),
  KEY `call_sign` (`call_sign`),
  KEY `banner` (`banner`),
  -- Reference to the generic station
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- Lookup table translating fields and codes to English and French
DROP TABLE IF EXISTS `lookup`;
CREATE TABLE `lookup` (
  `fieldname` varchar(32),
  `code` varchar(8),
  `description_english` varchar(128),
  `description_french` varchar(128),
  PRIMARY KEY (`fieldname`,`code`)
) ENGINE=MyISAM;

-- AM stations parameters (towers information)
DROP TABLE IF EXISTS `params`;
CREATE TABLE `params` (
  `calls_banr` varchar(32),
  `dnc_code` varchar(1),
  `tower_numb` int(11) DEFAULT '0',
  `fieldratio` double,
  `spacing` double,
  `orienta` double,
  `phasing` double,
  `height` double,
  `type_ant` int(11),
  `a` double,
  `b` double,
  `c` double,
  `d` double,
  `call_sign` varchar(12),
  `banner` char(2),
  PRIMARY KEY (`calls_banr`,`dnc_code`,`tower_numb`),
  KEY `call_sign` (`call_sign`),
  KEY `banner` (`banner`),
  -- Reference to the generic station
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- Data that regional users supply for compliance and inspections
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `calls_banr` varchar(32),
  `region` varchar(1),
  `district` varchar(2),
  `inspec_rep` varchar(1),
  `painting` varchar(4),
  `spr_dat` double,
  `rsp_dat` double,
  `stdett` double,
  `air_clear` double,
  `inspec_dat` double,
  `rcf_dat` double,
  `stat_type` varchar(2),
  `docfex` varchar(4),
  `province` varchar(2),
  `country` varchar(2),
  `call_sign` varchar(12),
  `banner` char(2),
  PRIMARY KEY (`calls_banr`),
-- ISAM ONLY
--  PRIMARY KEY (`call_sign`,`banner`),
  KEY `call_sign` (`call_sign`),
  KEY `banner` (`banner`),
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;

-- TSID assignments
DROP TABLE IF EXISTS `tsid`;
CREATE TABLE `tsid` (
  `province` char(2),
  `city` varchar(32),
  `call_sign` varchar(12),
  `banner` char(2),
  `channel` int(11),
  `tsid` char(4),
  PRIMARY KEY (`call_sign`,`banner`),
  -- Reference to the generic station
  FOREIGN KEY (call_sign, banner) REFERENCES ca_station (call_sign, banner) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=MyISAM;


-- -----------------------------------------------------------------------------
-- STATION TABLES
-- -----------------------------------------------------------------------------
-- Main station information for AM stations
DROP TABLE IF EXISTS `amstatio`;
CREATE TABLE `amstatio` (
  `province` varchar(2),
  `city` varchar(20),
  `call_sign` varchar(12),
  `frequency` double,
  `clazz` varchar(3),
  `latitude` char(6),
  `longitude` char(7),
  `banner` char(2),
  `status1` varchar(2),
  `status2` varchar(2),
  `latitude2` char(6),
  `longitude2` char(7),
  `brdr_lat` double,
  `brdr_long` double,
  `border` double,
  `can_land` double,
  `usa_land` double,
  `fre_land` double,
  `st_creat` char(8),
  `st_mod` char(8),
  `ok_dump` char(8),
  `doc_file` int(11),
  `dec_number` int(11),
  `ifrbn_d` double,
  `ifrbn_n` double,
  `clist1` double,
  `clist2` double,
  `clist3` double,
  `clist4` double,
  `clist5` double,
  `clist6` double,
  `clist7` double,
  `clist8` double,
  `clist9` double,
  `clist10` double,
  `network` varchar(4),
  `cert_numb` varchar(6),
  `bc_mode` varchar(1),
  `unattended` varchar(1),
  `auto_prog` varchar(1),
  `euvalu` double,
  `powerday` double,
  `par_rms_d` double,
  `q_day` double,
  `powernight` double,
  `par_rms_n` double,
  `q_night` double,
  `powercrit` double,
  `par_rms_c` double,
  `q_crit` double,
  `channel` int(11),
  PRIMARY KEY (`call_sign`,`banner`)
) ENGINE=MyISAM;

-- Main station information for FM stations
DROP TABLE IF EXISTS `fmstatio`;
CREATE TABLE `fmstatio` (
  `province` varchar(2),
  `city` varchar(20),
  `call_sign` varchar(12),
  `frequency` double,
  `clazz` varchar(3),
  `latitude` char(6),
  `longitude` char(7),
  `banner` char(2),
  `ss_code` varchar(5),
  `network` varchar(4),
  `ant_mode` varchar(1),
  `bc_mode` varchar(1),
  `brdr_lat` double,
  `brdr_long` double,
  `border` double,
  `can_land` double,
  `usa_land` double,
  `fre_land` double,
  `st_creat` char(8),
  `st_mod` char(8),
  `ok_dump` char(8),
  `doc_file` int(11),
  `dec_number` int(11),
  `unattended` varchar(1),
  `cert_numb` varchar(6),
  `scmo` varchar(1),
  `auto_prog` varchar(1),
  `beam_tilt` double,
  `ehaat` double,
  `erpvav` double,
  `erpvpk` double,
  `erphav` double,
  `erphpk` double,
  `ground_lev` double,
  `overall_h` double,
  `rad_center` double,
  `channel` int(11),
  PRIMARY KEY (`call_sign`,`banner`)
) ENGINE=MyISAM;

-- SDARS: Satellite Digital Audio Radio Service, operated by XM Radio and Sirius
DROP TABLE IF EXISTS `sdars`;
CREATE TABLE `sdars` (
  `province` char(2),
  `city` varchar(128),
  `call_sign` varchar(12),
  `frequency` double,
  `clazz` varchar(8),
  `latitude` char(6),
  `longitude` char(7),
  `banner` char(2),
  `limit_code` varchar(8),
  `network` varchar(64),
  `ant_mode` char(1),
  `bc_mode` char(1),
  `offset` int(11),
  `off_prec` char(1),
  `brdr_lat` char(6),
  `brdr_long` char(7),
  `border` double,
  `can_land` double,
  `usa_land` double,
  `fre_land` double,
  `st_creat` char(8),
  `st_mod` char(8),
  `ok_dump` char(8),
  `doc_file` int(11),
  `dec_number` int(11),
  `unattended` char(1),
  `cert_numb` int(11),
  `close_cap` char(1),
  `alloc_zone` int(11),
  `beam_tilt` double,
  `ehaat` double,
  `erpvav` double,
  `erpvpk` double,
  `erpaav` double,
  `erpapk` double,
  `erpvta` double,
  `erpata` double,
  `ground_lev` double,
  `overall_h` double,
  `rad_center` double,
  `channel` int(11),
  PRIMARY KEY (`call_sign`)
) ENGINE=MyISAM;

-- Main station information for TV stations
DROP TABLE IF EXISTS `tvstatio`;
CREATE TABLE `tvstatio` (
  `province` varchar(2),
  `city` varchar(20),
  `call_sign` varchar(12),
  `frequency` double,
  `clazz` varchar(3),
  `latitude` char(6),
  `longitude` char(7),
  `banner` char(2),
  `limit_code` varchar(8),
  `network` varchar(4),
  `ant_mode` varchar(1),
  `bc_mode` varchar(1),
  `offset` varchar(1),
  `off_prec` varchar(1),
  `brdr_lat` char(6),
  `brdr_long` char(7),
  `border` double,
  `can_land` double,
  `usa_land` double,
  `fre_land` double,
  `st_creat` char(8),
  `st_mod` char(8),
  `ok_dump` char(8),
  `doc_file` int(11),
  `dec_number` int(11),
  `unattended` varchar(1),
  `cert_numb` varchar(6),
  `close_cap` varchar(1),
  `alloc_zone` double,
  `beam_tilt` double,
  `ehaat` double,
  `erpvav` double,
  `erpvpk` double,
  `erpaav` double,
  `erpapk` double,
  `erpvta` double,
  `erpata` double,
  `ground_lev` double,
  `overall_h` double,
  `rad_center` double,
  `channel` int(11),
  PRIMARY KEY (`call_sign`,`banner`)
) ENGINE=MyISAM;



