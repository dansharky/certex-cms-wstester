#!/bin/sh

java -cp wstester.jar kz.gamma.certex.cms.web.services.PrepareCertRevokeXml \
    -profile profile://eToken \
    -pass 123456 \
    -alias E326B7147BA312D0B4C9F8BA64356DD0CB2C75DFBF14E96C4B1B5121F32C4AA4 \
    -output ./requests/revokeCert.xml