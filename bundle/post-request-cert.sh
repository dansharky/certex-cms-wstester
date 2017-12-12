#!/bin/sh

java -cp wstester.jar kz.gamma.certex.cms.web.services.PostCertRequest \
    -request ./tmp/result.xml \
    -profile profile://eToken \
    -pass 123456 \
    -algorithm ECGOST34310
