package com.ltqh.qh.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    /**
     * 对字符串进行32位签名
     * @param value
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String md5Encrypt(String value) throws NoSuchAlgorithmException {
        MessageDigest digester = MessageDigest.getInstance("MD5");
        digester.reset();
        return bytes2HexString(digester.digest(value.getBytes()));
    }

    /**
     * 二进制转十六进制String
     * @param bytes
     * @return
     */
    private static String bytes2HexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int val = ((int)bytes[i]) & 0xff;
            if(val < 16) sb.append("0"); //当转换十进制，会忽略掉前面的"0"
            sb.append(Integer.toHexString(val));
        }
        return sb.toString();
    }

}
