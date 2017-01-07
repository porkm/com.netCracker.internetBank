package main.console;


import main.bll.api.*;
import main.bll.service.imp.ServiceCustomer;
import main.configuration.IoCConfiguration;
import main.dal.entinties.*;
import main.dal.imp.ContextUnitOfWork;
import main.dal.imp.contextdb.MySQLContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class TestApp {

    public static void main(String[] args) throws SQLException{

//        String password = "123456";
//
//        MessageDigest md = null;
//        try {
//            md = MessageDigest.getInstance("SHA-256");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        md.update(password.getBytes());
//
//        byte byteData[] = md.digest();
//
//
//
//
//        String s= String.format("%064x", new java.math.BigInteger(1, byteData));
//
//        System.out.println(s);

int longer=5;


        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, longer);

        Date date = calendar.getTime();
        System.out.println(date);


    }
}
