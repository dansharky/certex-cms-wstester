package kz.gamma.certex.cms.web.services;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import kz.gamma.asn1.cryptopro.GammaObjectIndentifiers;
import kz.gamma.core.UtilCM;

public class CertificateFieldsResolver {
    public static final int HEX_STRING = 0;
    public static final int BYTE_ARRAY = 1;

    public CertificateFieldsResolver() {
    }

    public Object getSerialNumber(X509Certificate x509Certificate, Integer resultType) {
        Integer requiredLength = null;
        if(!x509Certificate.getSigAlgName().equals("ECGOST34310") && !x509Certificate.getSigAlgName().equals(GammaObjectIndentifiers.gost34310.getId())) {
            requiredLength = 20;
        } else {
            requiredLength = 32;
        }

        return this.getSerialNumber(x509Certificate.getSerialNumber(), requiredLength, resultType);
    }

    public Object getSerialNumber(BigInteger serialNumber, Integer resultType) {
        Integer requiredLength = null;
        if(serialNumber.toByteArray().length != 31 && serialNumber.toByteArray().length != 32) {
            requiredLength = 20;
        } else {
            requiredLength = 32;
        }

        return this.getSerialNumber(serialNumber, requiredLength, resultType);
    }

    private Object getSerialNumber(BigInteger serialNumber, Integer requiredLength, Integer resultType) {
        String sn = UtilCM.array2hex(serialNumber.toByteArray());
        if(serialNumber.toByteArray().length < requiredLength.intValue()) {
            char[] snChars = new char[requiredLength.intValue() * 2];
            if(serialNumber.toString().charAt(0) == 45) {
                Arrays.fill(snChars, 'F');
            } else {
                Arrays.fill(snChars, '0');
            }

            System.arraycopy(sn.toCharArray(), 0, snChars, snChars.length - sn.toCharArray().length, sn.toCharArray().length);
            sn = new String(snChars);
        }

        switch(resultType.intValue()) {
            case 0:
                return sn;
            case 1:
                return UtilCM.hex2array(sn);
            default:
                throw new IllegalArgumentException("Illegal data type: " + resultType);
        }
    }
}