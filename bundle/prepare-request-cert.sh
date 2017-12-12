#!/bin/sh

java -cp wstester.jar kz.gamma.certex.cms.web.services.PrepareCertRequestXml \
    -gen-profile profile://eToken \
    -gen-pass 123456 \
    -sign-profile officer_gost \
    -sign-pass 1 \
    -dn "C=KZ, O=GAMMA, CN=Антипов Макс Тестов, UID=850104300418" \
    -template "C=KZ, O=Template, CN=GOST_USER_SIGN_14D" \
    -tariff-id 2 \
    -detail-id 0 \
    -output requestCert.xml