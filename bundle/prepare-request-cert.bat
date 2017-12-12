REM registration
REM initialization
REM revocation

REM "C=KZ, O=GAMMA, CN=Антипов Макс Тестов, UID=850104300418"
REM "C=KZ, O=Template, CN=GOST_USER_SIGN_14D"

java -cp wstester.jar kz.gamma.certex.cms.web.services.PrepareCertRequestXml^
    -gen-profile profile://eToken^
    -gen-pass 123456^
    -sign-profile officer_gost^
    -sign-alias 8A5D4265C1B8D57EE6CEB504CEACD6B45DFA87E0ACC62A18137BC54015B20D28^
    -sign-pass 1^
    -dn "C=KZ, O=GAMMA, CN=Прореллеров Карлсон"^
    -template "C=KZ, O=Template, CN=GOST_USER_SIGN_1Y"^
    -tariff-id 2^
    -detail-id 0^
    -type registration^
    -output ./requests/requestCert.xml
