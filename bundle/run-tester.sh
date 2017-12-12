#!/bin/sh

java -jar wstester.jar \
    -method requestCert \
    -input requestCert.xml \
    -wsdl http://192.168.0.21:8081/webra/Service?wsdl \
    -profile officer_gost \
    -pass 1
