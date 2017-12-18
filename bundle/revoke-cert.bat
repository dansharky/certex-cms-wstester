java -jar wstester.jar^
    -method revokeCert^
    -input ./requests/revokeCert.xml^
    -wsdl http://localhost:8080/webra/Service?wsdl^
    -profile officer_gost^
    -pass 1^
    -output ./responces/revokeCertResp.xml

PAUSE