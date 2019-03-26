package com.crypto.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * create by toonew on 2018/8/17
 */
public class Test3 {
    static String ivParameter = "00000000000000000000000000000000"; //设置 向量

    public static String Encrypt(String key, String data) throws Exception {
        //密码串
        byte[] raw = hex2byte(key);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //偏移量
        IvParameterSpec iv = new IvParameterSpec(hex2byte(ivParameter));
        //初始化加密器
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(hex2byte(data));
        return byte2hex(encrypted);
    }

    public static String Decrypt(String sKey, String sSrc) throws Exception {
        //密码串
        byte[] raw = hex2byte(sKey);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //偏移量
        IvParameterSpec iv = new IvParameterSpec(hex2byte(ivParameter));

        //生成解码器
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");

        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = hex2byte(sSrc);

        byte[] original = cipher.doFinal(encrypted1);
        return byte2hex(original);
    }


    public static void main(String[] args) throws Exception {
        //加密用的Key
        String cKey = "02DAE77757F58DD86F36707FCD654615";
        //需要加密的字串
        String cSrc = "07000B006E00000100D874FB84F8210B";
        //加密
        long lStart = System.currentTimeMillis();
        String enString = Encrypt(cKey, cSrc);
        System.out.println("加密后的字串是：" + enString);
        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");

        //解密
        //enString = "FABDA2E40C3B524D50709458DE612806" ;
        lStart = System.currentTimeMillis();
        String DeString = Decrypt(cKey, enString);
        System.out.println("解密后的字串是：" + DeString);
        lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("解密耗时：" + lUseTime + "毫秒");

    }


    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
        }
        return b;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
}
