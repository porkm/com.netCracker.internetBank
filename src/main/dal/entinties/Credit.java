package main.dal.entinties;

import java.util.Date;


public class Credit {
    private int id;
    private double sumCredit;
    private double percentRate;
    private Date dayOfPay;
    private double pay;
    private double overPay;
    private Date creditStart;
    private int creditTerm;
    private int customerId;

    public Credit(int id, double sum_credit, double percent_rate, java.sql.Date day_of_pay, double pay, double over_pay, double credit_left, java.sql.Date credit_start, int id_customer) {
    }

    public Credit(int id, double sumCredit, double percentRate, Date dayOfPay, double pay, double overPay, Date creditStart, int creditTerm, int customerId) {
        this.id = id;
        this.sumCredit = sumCredit;
        this.percentRate = percentRate;
        this.dayOfPay = dayOfPay;
        this.pay = pay;
        this.overPay = overPay;
        this.creditStart = creditStart;
        this.creditTerm = creditTerm;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getDayOfPay() {
        return dayOfPay;
    }

    public void setDayOfPay(Date dayOfPay) {
        this.dayOfPay = dayOfPay;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getOverPay() {
        return overPay;
    }

    public void setOverPay(double overPay) {
        this.overPay = overPay;
    }

    public Date getCreditStart() {
        return creditStart;
    }

    public void setCreditStart(Date creditStart) {
        this.creditStart = creditStart;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

