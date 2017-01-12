package main.dal.entinties;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;

public class Invoice {
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
//    @DecimalMin(value = "10", message = "Счет открывается от 10 рублей")
//    @DecimalMax(value = "1000000", message = "Счет открывается до 1000000 рублей")
    //@Digits(integer = 10, fraction = 1000000, message = "Счет открывается от 10 рублей до 1000000 рублей")
    @Min(value = 1000000, message = "Счет открывается от 1 рубля до 1000000 рублей" )
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

