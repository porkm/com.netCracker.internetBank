package main.bll.service.util;

import main.dal.entinties.Invoice;



public class Transfer {


    public boolean chekTransfer(Invoice fromInvoice, Double money){
        return  fromInvoice.getBalance()>money;
    }




}

