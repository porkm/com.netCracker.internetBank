package main.dal.entinties;

public class Invoice {
    private int id;
    private double balance;
    private int customerId;

    public Invoice(int id, double balance, int customerId) {
        this.id = id;
        this.balance = balance;
        this.customerId = customerId;
    }

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

