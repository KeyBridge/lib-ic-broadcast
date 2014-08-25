Update Canada BDBS database with correct call sign and banner fields


UPDATE apatstat SET banner    = TRIM(SUBSTRING(calls_banr, -2, 2));
UPDATE apatstat SET call_sign = TRIM( SUBSTRING_INDEX(calls_banr, ' ', 1));
UPDATE augment SET banner    = TRIM(SUBSTRING(calls_banr, -2, 2));
UPDATE augment SET call_sign = TRIM( SUBSTRING_INDEX(calls_banr, ' ', 1));
UPDATE augments SET banner    = TRIM(SUBSTRING(calls_banr, -2, 2));
UPDATE augments SET call_sign = TRIM( SUBSTRING_INDEX(calls_banr, ' ', 1));
UPDATE comments SET banner    = TRIM(SUBSTRING(calls_banr, -2, 2));
UPDATE comments SET call_sign = TRIM( SUBSTRING_INDEX(calls_banr, ' ', 1));
UPDATE contours SET banner    = TRIM(SUBSTRING(calls_banr, -2, 2));
UPDATE contours SET call_sign = TRIM( SUBSTRING_INDEX(calls_banr, ' ', 1));
UPDATE params SET banner    = TRIM(SUBSTRING(calls_banr, -2, 2));
UPDATE params SET call_sign = TRIM( SUBSTRING_INDEX(calls_banr, ' ', 1));

