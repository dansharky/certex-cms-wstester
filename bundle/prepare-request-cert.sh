#!/bin/sh

# registration
# initialization
# revocation

#"C=KZ, O=GAMMA, CN=Антипов Макс Тестов, UID=850104300418"
#"C=KZ, O=Template, CN=GOST_USER_SIGN_14D"
#    -sign-alias  \

java -cp wstester.jar kz.gamma.certex.cms.web.services.PrepareCertRequestXml \
    -gen-profile profile://eToken \
    -gen-pass 123456 \
    -sign-profile officer_gost \
    -sign-pass 1 \
    -dn "C=KZ, O=GAMMA, CN=Прореллеров Карлсон" \
    -template "C=KZ, O=Template, CN=GOST_USER_SIGN_1Y" \
    -tariff-id 2 \
    -detail-id 0 \
    -type registration \
    -output ./requests/requestCert.xml
