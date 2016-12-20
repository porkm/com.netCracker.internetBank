package main.console;


import main.bll.api.*;
import main.configuration.IoCConfiguration;
import main.dal.entinties.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class TestApp {

    public static void main(String[] args) throws SQLException{

        ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);

        IServiceCustomer service = context.getBean(IServiceCustomer.class);

        List<Invoice> listinvoice = service.seeInvoises(3);
//
//        serviceEmpl = new ServiceEmployed(new ContextUnitOfWork(new MySQLContext()));
//        for(int i =0; i<10; i++) {
//
//            serviceEmpl.addCard(1);
//        }
//
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
