package main.console;


import main.bll.api.*;
import main.bll.service.imp.*;
import main.dal.contextdb.MySQLContext;
import main.dal.entinties.*;
import main.dal.imp.ContextUnitOfWork;

import java.sql.SQLException;
import java.util.List;

public class TestApp {

    public  void main(String[] args) throws SQLException{
        IServiceCustomer service;
        IServiceEmployed serviceEmpl;

        service = new ServiceCustomer(new ContextUnitOfWork(new MySQLContext()));

        serviceEmpl = new ServiceEmployed(new ContextUnitOfWork(new MySQLContext()));
        for(int i =0; i<10; i++) {

            serviceEmpl.addCard(1);
        }

        List<Invoice> invoises = service.seeInvoises(3);


//        List<Credit> credits = service.seeCredit(3);
//
//        Credit credit = service.seeCredit(3).get(0);
//
//        Date d = (Date) credit.getDayOfPay();
//
//        Calendar cal = Calendar.getInstance();

        //System.out.println(cal.get(cal.getDisplayNames(cal.));

        // calendar = new GregorianCalendar();

        // service.inviteFriend(3, "Vadim");

//        Random rnd = new Random(System.currentTimeMillis());
//        int min = 1;
//        int max = 1000000;
//
//        for (int i=1; i<20; i++){
//            int t = min+rnd.nextInt(max-min+1);
//
//            System.out.println(t);
//        }

        //System.out.println(calendar.get(calendar.));



        System.out.println("End");


        //Start developer with notebook






    }
}
