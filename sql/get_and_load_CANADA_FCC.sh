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
#  get_and_load_canada_fcc.sh [yes]
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
#   * working directory /mnt/canada/fcc
#   * correct database access privileges (IMPORTANT: see below)
#
# Installation
#   Grant MySQL privileges
#     GRANT INSERT, DELETE, SELECT, UPDATE, EXECUTE ON canada_fcc.* TO 'canada'@'localhost';
#   Add the following to crontab 
#     Load the canada_fcc database every week at 3:05 (5 minutes after canada main)
#     5  3  *  *  0  /export/data/canada/get_and_load_CANADA_FCC.sh
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
#   01/30/13 - fix curl command to force use of SSLv3
#   01/04/13 - update to only load TV data into staging table, enable app-server notification 
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
# GRANT INSERT, DELETE, SELECT, UPDATE, EXECUTE ON canada_fcc.* TO 'canada_fccloader'@'localhost';

####
# GLOBAL VARIABLES
#
export PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:/usr/gnu/bin:/usr/bin:/usr/X11/bin:/usr/sbin:/sbin:/opt/sfw/bin:/opt/csw/bin:/usr/dt/bin:/usr/openwin/bin:/usr/ccs/bin:/usr/sfw/bin:/usr/sfw/sbin:/usr/local/bin

# program configuration parameters
# where to store the data files
WORKINGDIR="/export/data/canada"

# The FCC transmogrified Canada Broadcasting database files (ZIP, 1.5  MB), updated daily
DATAFILE="http://data.fcc.gov/download/white-space-database-administration/ca_tv_data.zip"

# the FCC data also contains antenna data, but we only care about the tv_station table
# which we use as a staging table and pointer into our normalized ca_station table.
TABLES="tvstatio_staging"

# the application server URL to notify after this script has completed
#   URI pattern is: http://[host][:port]/notify/[database]/[dayOfYear|'alert']
#   [database] must be an enumerated wsif dataSource (not case sensitive.
#   normal operation proceeds if dayOfYear is provided
#   if the 'alert' flag is present a ticket will be created indicating that this program failed
# NOTIFY_API_URI="https://api.keybridgeglobal.com/api/rest/notify/bdbs"
NOTIFY_API_URI="https://localhost:8080/api/rest/notify/bdbs"
NOTIFY_API_KEY="e3e02175-56b1-11e2-a490-0024211c6fd1"

# name of load record XML file is set in the MAIN section
LOAD_RECORD_FILE="load_record.xml"
# load record file contents
LOAD_RECORD_OPEN="<loadRecord database=\"cdbs\">"
LOAD_RECORD_CLOSE="</loadRecord>"
# initialize the data content
LOAD_RECORD=$LOAD_RECORD_OPEN

# identify supporting programs
CURL=`which curl`
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
# Notify the API system that the database has been updated and is ready for processing
NOTIFY() {
  $CURL -sslv3 --header "notify_api_key: $NOTIFY_API_KEY" $NOTIFY_API_URI &>/dev/null
}

################################################################################
####
# Rename DBF files to lower case for easier processing and to match MySQL tables
RENAMETOLOWER () {
  # rename to lower case
  #  echo "    Rename to lower $PWD"
  for FILE in `ls *.txt`; do
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
#  load the data files into the canada_fcc database
#  they are structured and can be handled the same
PROCESSDATA () {

  for ZIP in *zip; do
    # use -o unzip flags to force overwrite of any existing files
    echo "  Working on datafile $ZIP"
    unzip -o $ZIP &>/dev/null
    
    # update the load_record xml with category name
    echo "  <dataFile name=\"$ZIP\">" >> $LOAD_RECORD_FILE

    # txt files are already lower case
    # RENAMETOLOWER
    # rename tv_statio.txt to tvstatio_staging.txt
    if [ -e tv_statio.txt ] ; then
      echo "    Renaming tv_statio.txt to tvstatio_staging.txt"
      mv tv_statio.txt tvstatio_staging.txt
    fi

    # processes only the 'tv_statio.txt' data file within this ZIP file
    for TABLENAME in $TABLES; do
      # load the new data into the database (confirm txt file exists)
      if [ -e $TABLENAME.txt ]; then
      
        # convert the DBF data file to a txt data file
        # $DBVIEW -b -t $TABLENAME.dbf > $TABLENAME.dat

        # load the data file into the associated ULS table
        NEWCOUNT=`wc -l $TABLENAME.txt | sed 's/\([0-9]\) .*/\1/'`
        echo "    $TABLENAME : $NEWCOUNT records"

        # update the load_record xml 
        echo "    <dataTable name=\"$TABLENAME\" numRecords=\"$NEWCOUNT\"/>" >> $LOAD_RECORD_FILE
       
        # airport and runway are tab-deliminted - no need for special field-termination
        $MYSQLIMPORT -L -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS --replace canada $TABLENAME.txt \
            --fields-terminated-by='|' &>/dev/null
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
DATADIR="fcc/$YEAR/$DOY"     # working dir is fcc/[year][dayOfYear]

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
echo " Fetch and load FCC Canada extract into MySQL staging table"
echo "   host       : $HOST "
echo "   date       : `date`"
echo "   working dir: $PWD"
echo "   data dir   : $DATADIR"
echo "   complete   : $FULL"
echo ""
echo "##########################################################################"
echo ""

echo "Purge current staging records table"
echo "DELETE FROM canada.tvstatio_staging" | $MYSQL -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS &>/dev/null


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
BASENAME=`basename $DATAFILE`
if [ ! -e $BASENAME ] ; then
  # redirect stderr and stdout to /dev/null
  echo "  Fetching data file $BASENAME"
  $WGET -q $DATAFILE &>/dev/null
  echo
else
  echo "  Data file $BASENAME already fetched. Using existing."
  echo
fi
    
# if FULL then perform a COMPLETE database update
echo "Purging existing FCC Canada staging records"
for table in $TABLES; do
  echo "delete from canada.$table;" |$MYSQL -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS &>/dev/null
done

# Process the data. note that PWD if DATADIR
echo
echo "Process FCC Canada staging data files"
PROCESSDATA

echo
echo "Run database update scripts"

echo "DELETE FROM canada.tvstatio_staging WHERE province NOT IN ('AB', 'BC', 'MB', 'NB', 'NF', 'NS', 'NT', 'ON', 'PE', 'QC', 'SK', 'YT')" | $MYSQL -h $MYSQL_HOST --user=$MYSQL_USER --password=$MYSQL_PASS &>/dev/null

# notify the application server that new data is present
echo 'Notify application server of successful database update'
NOTIFY

# DEPRECATED - keep the daily files - they're useful for historical archive
#   clean up data files (no need to keep them about)
#   echo "Cleaning up ULS files"
#   rm -rf $DOY

# END
FINISH=`date +%s`
DURATION=`echo "$FINISH - $START"|$BC`
DURATIONMIN=`echo "($FINISH - $START)/60"|$BC`

# complete and write the load record xml file
echo "  <processStatistics start=\"$START\" end=\"$FINISH\" duration=\"$DURATION\"/>" >> $WORKINGDIR/$DATADIR/$LOAD_RECORD_FILE
echo "$LOAD_RECORD_CLOSE"  >> $WORKINGDIR/$DATADIR/$LOAD_RECORD_FILE

echo "##########################################################################"
echo " Program took $DURATION seconds ($DURATIONMIN minutes)"
echo ""
echo "##########################################################################"

exit



