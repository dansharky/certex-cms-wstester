java -jar wstester.jar
 -method requestCert^
 -input requests/requestCert.xml^
 -output responces/requestCertResp.xml^
 -wsdl http://localhost:8080/webra/Service?wsdl^
 -profile officer_gost^
 -pass 1

PAUSE