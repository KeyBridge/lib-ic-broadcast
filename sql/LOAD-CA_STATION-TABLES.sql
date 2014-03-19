-- -----------------------------------------------------------------------------
-- MYSQL SCRIPT FOR CANADIAN STATION DATA
-- This set of SQL commands is called FROM within the get_and_load_CANADA.sh script
-- to load date from the Canadian BDBS tables into the (KeyBridge) consolidated
-- ca_station and ca_station_staging tables.
-- -----------------------------------------------------------------------------
-- HISTORY
-- -----------------------------------------------------------------------------
-- 12/18/12 - change select statement to only capture valid, transmitting stations
--          - no need to use staging table anymore, remove references.
-- 09/27/12 - improve documentation - add banner definitions
-- 09/18/12 - add filter limiting staging records to channels below 52
-- 08/04/12 - Add load commands to copy into ca_station table
-- 08/03/12 - created
--
-- -----------------------------------------------------------------------------
-- NOTES
--   apatstat is just a lookup table
--   UPDATE canada.apatstat SET call_sign = substring_index(calls_banr, ' ', 1);
--   UPDATE canada.apatstat SET banner = trim(trim(leading substring_index(calls_banr, ' ', 1) 
--     FROM canada.calls_banr));
--
--   How to extract the callsign and banner FROM canada.a calls_banr column
--   SELECT calls_banr, substring_index(calls_banr, ' ', 1), 
--     trim(trim(leading substring_index(calls_banr, ' ', 1) 
--     FROM canada.calls_banr)) FROM canada.canada.comments;
--
-- The following tables are updated FROM within the get-and-load script:
-- Once the call_sign and banner fields are updated in these tables this SQL
-- script may be run.
--    [apatstat augment comments contours extend feeds params region]
-- -----------------------------------------------------------------------------
-- DO IT!

-- -----------------------------------------------------------------------------
-- Clear the ca_station table
-- -----------------------------------------------------------------------------
DELETE FROM canada.ca_station;

-- -----------------------------------------------------------------------------
-- Load the AM Station data
-- -----------------------------------------------------------------------------
REPLACE INTO canada.ca_station SELECT
  "AM"
, banner      
, call_sign   
, channel     
, NULL  
, NULL  
, canada.dms2dec(latitude)
, -canada.dms2dec(longitude)
, NULL  
, NULL  
, auto_prog   
, bc_mode     
, NULL  
, border      
, brdr_lat    
, brdr_long   
, can_land    
, cert_numb   
, city              
, clazz             
, NULL  
, dec_number  
, doc_file    
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, euvalu      
, fre_land    
, frequency  / 1000
, NULL  
, ifrbn_d     
, ifrbn_n     
, latitude2   
, NULL  
, longitude2  
, network     
, NULL  
, NULL  
, canada.asdate(ok_dump)
, NULL  
, par_rms_c   
, par_rms_d   
, par_rms_n   
, powercrit   
, powerday    
, powernight  
, province    
, q_crit      
, q_day             
, q_night     
, NULL  
, NULL  
, NULL  
, canada.asdate(st_creat)
, canada.asdate(st_mod)
, status1     
, status2     
, unattended  
, usa_land 
FROM canada.amstatio
WHERE province IN ("AB", "BC", "MB", "NB", "NF", "NS", "NT", "ON", "PE", "QC", "SK", "YT")
  AND banner IN ("AP", "AU", "O", "OP", "TO");

-- -----------------------------------------------------------------------------
-- Load the FM Station data
-- -----------------------------------------------------------------------------

REPLACE INTO canada.ca_station SELECT
  "FM"
, banner
, call_sign
, channel
, erpvpk
, ehaat  
, canada.dms2dec(latitude)
, -canada.dms2dec(longitude)
, NULL  
, ant_mode
, auto_prog
, bc_mode
, beam_tilt
, border
, brdr_lat
, brdr_long
, can_land
, cert_numb
, city  
, clazz 
, NULL  
, dec_number
, doc_file
, NULL  
, NULL  
, NULL  
, erphav
, erphpk
, erpvav
, NULL  
, NULL  
, fre_land
, frequency
, ground_lev
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, network
, NULL  
, NULL  
, canada.asdate(ok_dump)
, overall_h
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, province
, NULL  
, NULL  
, NULL  
, rad_center
, scmo  
, ss_code
, canada.asdate(st_creat)
, canada.asdate(st_mod)
, NULL  
, NULL  
, unattended
, usa_land
FROM canada.fmstatio
WHERE province IN ("AB", "BC", "MB", "NB", "NF", "NS", "NT", "ON", "PE", "QC", "SK", "YT")
  AND banner IN ("AP", "AU", "O", "OP", "TO");

-- -----------------------------------------------------------------------------
-- Load the TV Station data
-- -----------------------------------------------------------------------------
REPLACE INTO canada.ca_station SELECT
  "TV"
, banner
, call_sign
, channel
, erpvpk
, ehaat  
, canada.dms2dec(latitude)
, -canada.dms2dec(longitude)
, alloc_zone
, ant_mode
, NULL  
, bc_mode
, beam_tilt
, border
, brdr_lat
, brdr_long
, can_land
, cert_numb
, city  
, clazz 
, close_cap
, dec_number
, doc_file
, erpaav
, erpapk
, erpata
, NULL  
, NULL  
, erpvav
, erpvta
, NULL  
, fre_land
, frequency
, ground_lev
, NULL  
, NULL  
, NULL  
, limit_code
, NULL  
, network
, off_prec
, offset
, canada.asdate(ok_dump)
, overall_h
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, province
, NULL  
, NULL  
, NULL  
, rad_center
, NULL  
, NULL  
, canada.asdate(st_creat)
, canada.asdate(st_mod)
, NULL  
, NULL  
, unattended
, usa_land
FROM canada.tvstatio
WHERE province IN ("AB", "BC", "MB", "NB", "NF", "NS", "NT", "ON", "PE", "QC", "SK", "YT")
  AND banner IN ("AP", "AU", "O", "OP", "TO");


-- -----------------------------------------------------------------------------
-- Load the SDAR Station data
-- -----------------------------------------------------------------------------
REPLACE INTO canada.ca_station SELECT
  "SDAR"
, banner
, call_sign
, channel
, erpvpk
, ehaat  
, canada.dms2dec(latitude)
, -canada.dms2dec(longitude)
, alloc_zone
, ant_mode
, NULL  
, bc_mode
, beam_tilt
, border
, brdr_lat
, brdr_long
, can_land
, cert_numb
, city  
, clazz 
, close_cap
, dec_number
, doc_file
, erpaav
, erpapk
, erpata
, NULL  
, NULL  
, erpvav
, erpvta
, NULL  
, fre_land
, frequency
, ground_lev
, NULL  
, NULL  
, NULL  
, limit_code
, NULL  
, network
, off_prec
, offset
, canada.asdate(ok_dump)
, overall_h
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, NULL  
, province
, NULL  
, NULL  
, NULL  
, rad_center
, NULL  
, NULL  
, canada.asdate(st_creat)
, canada.asdate(st_mod)
, NULL  
, NULL  
, unattended
, usa_land
FROM canada.sdars
WHERE province IN ("AB", "BC", "MB", "NB", "NF", "NS", "NT", "ON", "PE", "QC", "SK", "YT")
  AND banner IN ("AP", "AU", "O", "OP", "TO");

-- -----------------------------------------------------------------------------
-- Load the STAGING table with ACTIVE, CANADIAN TV stations broadcasting below CH 51
-- Important - this loads the staging table from which wireless service records
-- and white space contours are built
--    AL  Allotment
-- x  AP  Approved
-- x  AU  Authorized
--    CP  Construction Permit  (US Only)
--    DE  Denied
--    IC  Incomplete
--    IL  Illegal
-- x  OP  Operational
--    PC  Proposed Channel
--    RE  Referred to CRTC
--    TD  Tentative Deletion
--    TO  Temp. Operation
--    UA  Approved by CRTC
--    UC  Under Consideration
--    UN  Unacceptable
-- -----------------------------------------------------------------------------
-- DELETE FROM canada.tvstatio_staging 
-- WHERE province NOT IN ("AB", "BC", "MB", "NB", "NF", "NS", "NT", "ON", "PE", "QC", "SK", "YT")
--   AND banner NOT IN ("AP", "AU", "OP");

-- SELECT count(*) FROM canada.tvstatio
-- WHERE province IN ("AB", "BC", "MB", "NB", "NF", "NS", "NT", "ON", "PE", "QC", "SK", "YT")
--   AND banner IN ("AP", "AU", "OP")
--   AND channel < 52  AND border < 400  ;
