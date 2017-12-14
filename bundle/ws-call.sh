#!/bin/sh

java -jar wstester.jar \
    -method updateCUser \
    -input requests/cuseredit.xml \
    -output responces/cusereditResp.xml \
    -wsdl http://localhost:8080/webra/Service?wsdl \
    -profile officer_gost \
    -pass 1
