package main.bll.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PassUtil {

    public static String getPassSHA(String password){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        return  String.format("%064x", new java.math.BigInteger(1, byteData));
    }
}
