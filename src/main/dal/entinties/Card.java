package main.dal.entinties;

import java.util.Date;


public class Card {
    private int number;
    private Date validOf;
    private int invoceId;
    private String currency;
    private double balance;

    
    public Card() {
    }

    public Card(int number, Date validOf, int invoceId, String currency, double balance) {
        this.number = number;
        this.validOf = validOf;
        this.invoceId = invoceId;
        this.currency = currency;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getValidOf() {
        return validOf;
    }

    public void setValidOf(Date validOf) {
        this.validOf = validOf;
    }

    public int getInvoceId() {
        return invoceId;
    }

    public void setInvoceId(int invoceId) {
        this.invoceId = invoceId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

