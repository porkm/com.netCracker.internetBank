package main.dal.entinties;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import java.util.Date;


public class Credit {
    private int id;
    @Max(value = 1000000, message = "Максимальная сумма кредита 1 000 000 рублей")
    private double sumCredit;
    private double percentRate;
    @Future(message = "Дата должна быть больше сегодняшней")
    private Date dayOfPay;
    private double pay;
    private double overPay;
    @Future(message = "Дата должна быть больше сегодняшней")
    private Date creditStart;
    @Max(value = 5, message = "Максимальный срок кредита 5 лет")
    private int creditTerm;
    private int customerId;

    public Credit(int id, double sumCredit, double percentRate, java.sql.Date dayOfPay, double pay, double overPay, int creditLeft, java.sql.Date creditStart, int customerId) {
        this.id = id;
        this.sumCredit = sumCredit;
        this.percentRate = percentRate;
        this.dayOfPay = dayOfPay;
        this.pay = pay;
        this.overPay = overPay;
        this.creditStart = creditStart;
        this.creditTerm = creditLeft;
        this.customerId = customerId;
    }

    public Credit() {

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

