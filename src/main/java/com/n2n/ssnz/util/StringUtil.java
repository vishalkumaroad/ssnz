package com.n2n.ssnz.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.logging.Logger;

public class StringUtil {

    private static final Logger LOG = Logger.getLogger(StringUtil.class.getName());

    public static String encodeToMd5(String source) {
        String encodedStr = "";
        try {
            if (!ValidatorUtil.isEmpty(source)) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashBytes = md.digest(source.getBytes());
                BigInteger signum = new BigInteger(1, hashBytes);
                String hash = signum.toString(16);
                while (hash.length() < 32) {
                    hash = "0" + hash;
                }
                encodedStr = hash;
            }
        } catch (Exception e) {
            LOG.info("Exception inside StringUtil.encodeToMd5()");
            e.printStackTrace();
        }

        return encodedStr;
    }
}
