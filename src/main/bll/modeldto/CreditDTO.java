package main.bll.modeldto;

import java.util.Date;


public class CreditDTO {
    private double sumCredit;
    private double percentRate;
    private Date dateNextPay;
    private double sumPay;
    private double restCredit;



    public double getSumCredit() {
        return sumCredit;
    }

    public void setSumCredit(double sumCredit) {
        this.sumCredit = sumCredit;
    }

    public double getPercentRate() {
        return percentRate;
    }

    public void setPercentRate(double percentRate) {
        this.percentRate = percentRate;
    }

    public Date getDateNextPay() {
        return dateNextPay;
    }

    public void setDateNextPay(Date dateNextPay) {
        this.dateNextPay = dateNextPay;
    }

    public double getSumPay() {
        return sumPay;
    }

    public void setSumPay(double sumPay) {
        this.sumPay = sumPay;
    }

    public double getRestCredit() {
        return restCredit;
    }

    public void setRestCredit(double restCredit) {
        this.restCredit = restCredit;
    }
}

