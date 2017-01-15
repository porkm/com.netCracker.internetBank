package main.bll.service.util;

import main.dal.entinties.Credit;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public Date setNextPay(){
        GregorianCalendar calendar = new GregorianCalendar();
//                credit.getDayOfPay().getYear(),
//                credit.getDayOfPay().getMonth(),
//                credit.getDayOfPay().getDay()
        //);
        calendar.setTime(credit.getDayOfPay());
        //todo check generate date

        calendar.add(Calendar.MONTH, 1);
        Date date = calendar.getTime();
        return date;
    }

    public double getOverPay() {
        return  getPay()*credit.getCreditTerm()*12-credit.getSumCredit();
    }




}

