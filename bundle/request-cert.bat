java -jar wstester.jar^
    -method requestCert^
    -input requests/requestCert.xml^
    -output responces/requestCertResp.xml^
    -wsdl http://192.168.0.21:8081/webra/Service?wsdl^
    -profile officer_gost^
    -pass ""

