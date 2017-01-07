package main.bll.service.util;

import main.dal.entinties.Credit;

public class CreditCalculate {

    private Credit credit;

    public CreditCalculate(Credit credit) {
        this.credit = credit;
    }


    public double getPay(){
        double sumCredit = credit.getSumCredit();
        double termCredit = credit.getCreditTerm();
        double percentRate = credit.getPercentRate()/100;

        double result = (sumCredit*(percentRate/12))/
                (1-(1/Math.pow(1+percentRate/12,termCredit*12)));
        return result;
    }


    public double getOverPay() {
        return  getPay()*credit.getCreditTerm()*12-credit.getSumCredit();
    }

}

