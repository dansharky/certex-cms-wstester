#!/bin/sh

java -jar wstester.jar \
    -method revokeCert \
    -input revokeCert.xml \
    -wsdl http://192.168.0.21:8081/webra/Service?wsdl \
    -profile officer_gost \
    -pass 1
