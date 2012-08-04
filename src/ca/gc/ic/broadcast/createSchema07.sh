#!/bin/sh

clear

# export CLASSPATH=/usr/local/glassfish/glassfish/modules/*:/usr/local/netbeans/java/modules/ext/eclipselink/*:/usr/local/glassfish/glassfish/domains/domain1/lib/*

export CLASSPATH=/usr/local/glassfish/glassfish/modules/*:/usr/local/netbeans/java/modules/ext/eclipselink/*:/usr/local/glassfish/glassfish/domains/domain1/lib/*:/usr/local/glassfish/glassfish/modules/*:/usr/local/netbeans/java/modules/ext/eclipselink/*:/usr/local/glassfish/glassfish/domains/domain1/lib/*:/usr/local/glassfish/glassfish/modules/javax.persistence.jar:/usr/local/glassfish/glassfish/domains/domain1/lib/jts-1.11.jar


PWD=`pwd`

echo "+------------------------------------------------------------------------+"
echo "|  Generating XSD Schema from .java class files                          |"
echo "|    dir: $PWD"
echo "+------------------------------------------------------------------------+"


schemagen -cp $CLASSPATH:.:entity/:entity/enumerated/:enumerated/:interfaces/:util/ \
    entity/*.java \
    entity/enumerated/*.java \
    whitespace/*.java \
    enumerated/*.java \
    util/*.java \
   interfaces/*.java 

find . -name "*.class" -exec rm {} \;

echo
echo "+------------------------------------------------------------------------+"
echo "|  done                                                                  |"
echo "+------------------------------------------------------------------------+"
