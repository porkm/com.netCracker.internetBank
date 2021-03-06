package main.bll.service.util.stock;


import main.dal.entinties.Invoice;

public class BringFriend {

    private final static int BONUS = 500;
    private final static int MEGA_BONUS = 1000;

    public static synchronized void addBonus(Invoice invoice){

        invoice.setBalance(invoice.getBalance()+BONUS);
    }

    public static synchronized void addMegaBonus(Invoice invoice){

        invoice.setBalance(invoice.getBalance()+MEGA_BONUS);
    }

}
