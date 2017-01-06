package main.bll.modeldto;

import main.bll.service.util.CardCurrency;


/**
 * Created by porkm on 04.01.2017.
 */

public class CardDTO {

    private int number;
    private int validOf;
    private int invoceId;
    private CardCurrency currency;

      public CardDTO() {
    }

    public CardCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(CardCurrency currency) {
        this.currency = currency;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getValidOf() {
        return validOf;
    }

    public void setValidOf(int validOf) {
        this.validOf = validOf;
    }

    public int getInvoceId() {
        return invoceId;
    }

    public void setInvoceId(int invoceId) {
        this.invoceId = invoceId;
    }
}