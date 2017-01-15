package main.bll.modeldto;

import main.bll.service.util.CardInfo;

import javax.validation.constraints.Max;



public class CardDTO {

    private int number;

    @Max(value = 10, message = "Максимальный срок действия карты 10 лет")
    private int validOf;

    private int invoceId;

    private CardInfo.CardCurrency currency;

      public CardDTO() {
    }

    public CardInfo.CardCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(CardInfo.CardCurrency currency) {
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
