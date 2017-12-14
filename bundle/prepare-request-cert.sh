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
    -dn-file dn-file.txt \
    -template "C=KZ, O=Template, CN=GOST_USER_SIGN_14D|C=KZ, O=Template, CN=RSA_USER_SIGN_14D" \
    -tariff-id 39 \
    -detail-id 0 \
    -type initialization \
    -output ./requests/requestCert.xml
