package com.adtec.crowd.util;

import com.adtec.crowd.constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrowdUtil {
    public static boolean judgeRequestType(HttpServletRequest httpServletRequest) {
        String acceptInformation = httpServletRequest.getHeader("Accept");
        String xRequestInformation = httpServletRequest.getHeader("X-Requested-With");

        // 2.检查并返回
        return
                (
                        acceptInformation != null
                                &&
                                acceptInformation.length() > 0
                                &&
                                acceptInformation.contains("application/json")
                )
                        ||
                        (
                                xRequestInformation != null
                                        &&
                                        xRequestInformation.length() > 0
                                        &&
                                        xRequestInformation.equals("XMLHttpRequest")
                        );

    }

    public static String md5(String source) {

        // 1.判断source是否有效
        if (source == null || source.length() == 0) {
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }


        try {
            String algorithm = "md5";
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] input = source.getBytes();
            byte[] output = messageDigest.digest(input);
            int signum = 1;
            String encoded = String.valueOf(new BigInteger(signum,output)).toUpperCase();
            return encoded;


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }
}
