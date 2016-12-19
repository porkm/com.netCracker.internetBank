package main.bll.service.util;

import main.dal.entinties.Credit;

public class CreditCalculate {

    private Credit credit;

    public CreditCalculate(Credit credit) {
        this.credit = credit;
    }


    public double getPay(){
        return (credit.getSumCredit()+((credit.getSumCredit()*credit.getPercentRate())/100)*credit.getCreditTerm());
    }

    public double getOverPay() {
        return getPay()*credit.getCreditTerm()*12;
    }

}

