package com.crypto.hash;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * hash md5
 * Created by toonew on 2017/4/20.
 */
public class hash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = getMD5("hello 世界");
        String str2 = getMD5("hello 世界2");
        System.out.println(str);
        System.out.println(str2);
    }

    private static String getMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = null;
        md5 = MessageDigest.getInstance("MD5");
        try {
//            md5.update(str. getBytes("UTF-8"));
            md5.update(str.getBytes("iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, md5.digest()).toString(16);
    }

}
