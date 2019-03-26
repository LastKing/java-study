package com.crypto.cipher;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

/**
 * @author toonew on 2018/8/15
 */
public class Test {
    private static byte[] iv = "0000000000000000".getBytes();

    private static String decrypt(String encrypted, String seed) throws Exception {
        byte[] keyb = seed.getBytes("utf-8");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] thedigest = md.digest(keyb);
        SecretKeySpec skey = new SecretKeySpec(thedigest, "AES");
        Cipher dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        dcipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(seed.getBytes("UTF-8"), "AES"), new IvParameterSpec(iv));
        byte[] clearbyte = dcipher.doFinal(DatatypeConverter.parseHexBinary(encrypted));
        return new String(clearbyte);
    }

    public static String encrypt(String content, String key) throws Exception {
        byte[] input = content.getBytes("utf-8");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] thedigest = md.digest(key.getBytes("utf-8"));
        SecretKeySpec skc = new SecretKeySpec(thedigest, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), new IvParameterSpec(iv));
        byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
        int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);
        return DatatypeConverter.printHexBinary(cipherText);
    }

    public static String encrypt128(String content, String key) throws Exception {
        byte[] input = content.getBytes("utf-8");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(DatatypeConverter.parseHexBinary(key), "AES"), new IvParameterSpec(iv));
        byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));
        return DatatypeConverter.printHexBinary(encrypted);
    }

    public static void main(String[] args) throws Exception {
        String data = "Here is my string";
        String key = "1234567891123456";
        String cipher = Test.encrypt(data, key);
        String decipher = Test.decrypt(cipher, key);
        System.out.println(cipher);
        System.out.println(decipher);
        System.out.println(Test.encrypt(data, "1234567891123456"));
        System.out.println(Test.encrypt128(data, "d7900701209d3fbac4e214dfeb5f230f"));


        String nodePassword = "098F6BCD4621D373CADE4E832627B4F6";
        String nodeData = "85611349edb2622a73047e5f98dec9b3bcbd1cb1528be100077949b5cf8ff3d6";

        System.out.println(Test.decrypt(nodeData, nodePassword));

    }

}