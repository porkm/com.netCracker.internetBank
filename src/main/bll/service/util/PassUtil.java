package main.bll.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


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

    public static String randomPassw(){
        Random rnd = new Random(System.currentTimeMillis());
        int min = 100000000;
        int max = 900000000;
        int result=min+rnd.nextInt(max-min+1);
        String password=Integer.toString(result);
        return password;
    }
}
