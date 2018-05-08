package com.invest.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static String encodeMd5(String pass) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] results = md5.digest(pass.getBytes());
            String result = byteArrayToHexString(results);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    //将一个字节转化成十六进制形式的字符串
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}

