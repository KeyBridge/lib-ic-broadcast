#!/bin/bash
################################################################################
#  Copyright (C) 2010-2012 Caulfield IP Holdings and/or its affiliates.
#  All rights reserved. Use is subject to license terms.
#
#  Software Code is protected by Copyright. Caulfield hereby
#  reserves all rights in and to Copyrights and no license is
#  granted under Copyrights in this Software License Agreement.
#  Caulfield generally licenses Copyrights for commercialization
#  pursuant to the terms of either Caulfield's Standard Software Source Code
#  License Agreement or Caulfield's Standard Product License Agreement.
#  A copy of Caulfield's either License Agreement can be obtained on request
#  by email from: info@caufield.org.
################################################################################
####
#  get_and_load_CANADA.sh [yes]
#
# Shell script to fetch and load Canadian broadcast data files into MySQL database
#
#  Download Canadian Television Assignment (CTA) Data:
#
#  FCC Extracted:
#   http://data.fcc.gov/download/white-space-database-administration/ca_tv_data.zip
#
#  Industry Canada (RAW)
#   http://spectrum.ic.gc.ca/engineering/engdoc/baserad.zip
# 
# Requires:
#   * working directory /mnt/canada
#   * correct database access privileges (IMPORTANT: see below)
#
# Installation
#   Grant MySQL privileges
#     GRANT INSERT, DELETE, SELECT, UPDATE, EXECUTE ON canada.* TO 'canada'@'localhost';
#   Add the following to crontab 
#     Load the Canada database every week at 3:00
#     0  3  *  *  0  /export/data/canada/get_and_load_CANADA.sh
#
# To Do:
#   * email notification
#   * post update to web service
#
# References:
#   Useful SED how-to notes:
#     http://www.grymoire.com/Unix/Sed.html#uh-0
#   Useful BASH how-to notes:
#     http://tldp.org/LDP/Bash-Beginners-Guide/html/sect_07_02.html
#
# Revision history
#   09/13/12 - update working dir for operation on black
#   08/02/12 - created
#
################################################################################
####
# SETTINGS
#MYSQL_HOST='mysqlrds.internal'
#MYSQL_USER='loader'
#MYSQL_PASS='keybridge00'

MYSQL_HOST=localhost
MYSQL_USER=canadaloader
MYSQL_PASS=

################################################################################
# IMPORTANT: Required MySQL privileges
# GRANT INSERT, DELETE, SELECT, UPDATE, EXECUTE ON canada.* TO 'canadaloader'@'localhost';

####
# GLOBAL VARIABLES
#
export PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:/usr/gnu/bin:/usr/bin:/usr/X11/bin:/usr/sbin:/sbin:/opt/sfw/bin:/opt/csw/bin:/usr/dt/bin:/usr/openwin/bin:/usr/ccs/bin:/usr/sfw/bin:/usr/sfw/sbin:/usr/local/bin

# program configuration parameters
# where to store the data files
WORKINGDIR="/export/data/canada"

# The Broadcasting database files (ZIP, 5  MB), updated daily
# See http://www.ic.gc.ca/eic/site/sp_dgse-ps_dggs.nsf/eng/gg00026.html
CANADADATAFILE="http://spectrum.ic.gc.ca/engineering/engdoc/baserad.zip"

# the tables we care about. Order is important when loading InnoDB tables.
# TABLES="amstatio apatdat apatdesc apatstat augment city comments contours distbord extend feeds fmstatio limcode lookup params province region sdars stations tsid tvstatio"
TABLES="distbord extend feeds limcode lookup province amstatio fmstatio tvstatio sdars apatstat apatdat apatdesc augment city comments contours params region stations tsid"

# the application server URL to notify after CDBS data has been loaded
#   URI pattern is: http://[host][:port]/notify/[database]/[dayOfYear|'alert']
#   normal operation proceeds if dayOfYear is provided
#   if the string 'alert' is provided a notification is made that this program failed
# APPLICATION_SERVER_TRIGGER="http://localhost:8181/notify/canada"

# name of load record XML file is set in the MAIN section
LOAD_RECORD_FILE="load_record.xml"
# load record file contents
LOAD_RECORD_OPEN="<loadRecord database=\"cdbs\">"
LOAD_RECORD_CLOSE="</loadRecord>"
# initialize the data content
LOAD_RECORD=$LOAD_RECORD_OPEN

# identify supporting programs
WGET=`which wget`
MYSQL=`which mysql`
MYSQLIMPORT=`which mysqlimport`
BC=`which bc`
HOST=`hostname`
DBVIEW=`which dbview`

################################################################################
# NOTE: PROGRAM BEGINS AT MAIN - BELOW
################################################################################


################################################################################
####
# Rename DBF files to lower case for easier processing and to match MySQL tables
RENAMETOLOWER () {
  # rename to lower case
  #  echo "    Rename to lower $PWD"
  for FILE in `ls *.dbf *.DBF`; do
    LOWFILE=`echo $FILE | tr '[:upper:]' '[:lower:]'`
    if [ ! $LOWFILE = $FILE ] ; then
      mv $FILE $LOWFILE &>/dev/null  
    fi
  done

  # rename airport.txt and runway.txt to [].dat
  for FILE in *.txt; do
    BASENAME=`basename $FILE .txt `
    mv $BASENAME.txt $BASENAME.dat &>/dev/null  
  done
}


################################################################################
####
# PROCESS ULS DATA
#  load the data files into the CANADA database
#  they are structured and can be handled the same
PROCESSDATA () {
  for ZIP in *zip; do
    # use -o unzip flags to force overwrite of any existing files
    echo "  Working on datafile $ZIP"
    unzip -o $ZIP &>/dev/null
    
    # update the load_record xml with category name
    echo "  <dataFile name=\"$ZIP\">" >> $LOAD_RECORD_FILE

    # rename DAT files to lower case
    RENAMETOLOWER

    # process each 'dat' file within this ZIP file
    # 06/23/11 - only load enumerated table DAT files instead of loading all data
    for TABLENAME in $TABLES; do
      # load the new data into the database (confirm DAT file exists)
      if [ -e $TABLENAME.dbf ]; then
      
        # convert the DBF data file to a txt data file
        $DBVIEW -b -t $TABLENAME.dbf > $TABLENAME.dat

        # load the data file into the associated ULS table
        NEWCOUNT=`$DBVIEW -b -t $TABLENAME.dbf | wc -l | sed 's/\([0-9]\) .*/\1/'`
        echo "    $TABLENAME : $NEWCOUNT records"

        # update the load_record xml 
        echo "    <dataTable name=\"$TABLENAME\" numRecords=\"$NEWCOUNT\"/>" >> $LOAD_RECORD_FILE
       
        # airport and runway are tab-deliminted - no need for special field-termination
        $MYSQLIMPORT -L -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS --replace canada $TABLENAME.dat \
            --fields-terminated-by=':' &>/dev/null

      fi
    done
    
    # close the load_record xml with category name
    echo "  </dataFile>" >> $LOAD_RECORD_FILE
    
    # clean up: remove all dat files - ignore if none are present
    rm *.dat *.dbf *.dbt *.txt *.mif &>/dev/null 
  done
}


################################################################################
####
# MAIN
#
# mark the start time
START=`date +%s`
# calculate day of year
DOY=`date +%j`           # day of year
YEAR=`date +%Y`          # year        (4 digits e.g. 2011)
DATADIR="$YEAR/$DOY"     # working dir is [year][dayOfYear]

# is this a complete load - command line arg == true
if [ "$1" = "yes" ] 
then
  FULL="TRUE"
else
  FULL="FALSE"
fi

# DEPRECATED - only do a full refresh when manually prompted
# Do a full database refresh if today is the first day of the month
# if [ `date +%d` == "01" ] ; then
#   echo "First day of the Month: Refresh our ULS data"
#   FULL="TRUE"
# fi

echo ""
echo "##########################################################################"
echo ""
echo " Fetch and load CANADA data into MySQL"
echo "   host       : $HOST "
echo "   date       : `date`"
echo "   working dir: $PWD"
echo "   data dir   : $DATADIR"
echo "   complete   : $FULL"
echo ""
echo "##########################################################################"
echo ""

cd $WORKINGDIR

# create a data directory if none exists
if [ ! -e $DATADIR ]; then
  #  echo "  $DATADIR does not exist.. creating"
  mkdir -p $DATADIR
fi

# update the load record XML content
# initialize the load record XML content
echo "<loadRecord database=\"uls\" host=\"$HOST\" workingDir=\"$PWD\" dataDir=\"$DATADIR\" complete=\"$FULL\" timeStamp=\"$START\" doy=\"$DOY\"/>" > $DATADIR/$LOAD_RECORD_FILE


cd $DATADIR

# fetch the data file
BASENAME=`basename $CANADADATAFILE`
if [ ! -e $BASENAME ] ; then
  # redirect stderr and stdout to /dev/null
  echo "  Fetching data file $BASENAME"
  $WGET -q $CANADADATAFILE &>/dev/null
  echo
else
  echo "  Data file $BASENAME already fetched. Using existing."
  echo
fi
    
# if FULL then perform a COMPLETE database update
if [ $FULL = "TRUE" ] ; then
  echo "Purging existing CANADA database records"
  for table in `echo "use canada; show tables;" |$MYSQL -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS`; do
    echo "delete from canada.$table;" |$MYSQL -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS &>/dev/null
  done
fi

# Process the data. note that PWD if DATADIR
echo
echo "Process CANADA data files"
PROCESSDATA

echo
echo "Run database update scripts"
# Canada tables have bogus concatenated call signs. Run this script to 
# clean them up. This is required to correctly implement the foreign key 
# relationships.
FIXTABLES="apatstat augment comments contours extend feeds params region"
for table in $FIXTABLES; do
  echo "  Set call_sign and banner in $table"
  echo "UPDATE canada.$table set call_sign = substring_index(calls_banr, ' ', 1);" |$MYSQL -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS &>/dev/null
  echo "UPDATE canada.$table set banner =  trim(trim(leading substring_index(calls_banr, ' ', 1) from calls_banr));" |$MYSQL -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS &>/dev/null
done

# The canada tables are highly redundant to the point of uselessness. Key bridge consolidates 
# all station information into a single station table, into which all the other
# tables link via call sign and banner (set above). The following script loads
# AM, FM, TV and SDAR data into the consolidated station table
echo "  Load consolidated data into ca_station & ca_station_staging tables" 
$MYSQL -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS < $WORKINGDIR/LOAD-CA_STATION-TABLES.sql &>/dev/null

# notify the application server that new ULS data is present
# echo 'Notify application server of successful ULS update'
# $WGET "$APPLICATION_SERVER_TRIGGER/$DOY"  &>/dev/null

# DEPRECATED - keep the daily files - they're useful for historical archive
#   clean up data files (no need to keep them about)
#   echo "Cleaning up ULS files"
#   rm -rf $DOY

# END
FINISH=`date +%s`
DURATION=`echo "$FINISH - $START"|$BC`
DURATIONMIN=`echo "($FINISH - $START)/60"|$BC`

# complete and write the load record xml file
echo "  <processStatistics start=\"$START\" end=\"$FINISH\" duration=\"$DURATION\"/>" >> $WORKINGDIR/$DATADIR/$LOAD_RECORD_FILE &>/dev/null
echo "$LOAD_RECORD_CLOSE"  >> $WORKINGDIR/$DATADIR/$LOAD_RECORD_FILE &>/dev/null


echo "##########################################################################"
echo " Program took $DURATION seconds ($DURATIONMIN minutes)"
echo ""
echo "##########################################################################"

exit



