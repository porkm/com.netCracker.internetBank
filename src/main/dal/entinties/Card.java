package main.dal.entinties;

import java.util.Date;


public class Card {
    private int number;
    private Date validOf;
    private int invoceId;

    public Card(int number, Date validOf, int invoceId) {
        this.number = number;
        this.validOf = validOf;
        this.invoceId = invoceId;
    }

    public Card() {

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
}

