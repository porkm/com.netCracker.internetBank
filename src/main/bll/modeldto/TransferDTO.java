package main.bll.modeldto;

public class TransferDTO {

    private   int toInvoiceId;
    private   int fromInvoiceId;
    private   double money;

    public TransferDTO() {
    }

    public TransferDTO(int toCustomerId, int fromCustomerId, double money) {
        this.toInvoiceId = toCustomerId;
        this.fromInvoiceId = fromCustomerId;
        this.money = money;
    }

    public int getToInvoiceId() {
        return toInvoiceId;
    }

    public void setToInvoiceId(int toInvoiceId) {
        this.toInvoiceId = toInvoiceId;
    }

    public int getFromInvoiceId() {
        return fromInvoiceId;
    }

    public void setFromInvoiceId(int fromInvoiceId) {
        this.fromInvoiceId = fromInvoiceId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
