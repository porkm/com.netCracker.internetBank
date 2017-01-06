package main.bll.modeldto;

public class TransferDTO {

    private   int toInvoiceId;
    private   int fromInvoiceId;
    private   double money;

    public TransferDTO() {
    }

    public TransferDTO(int toInvoiceId, int fromInvoiceId, double money) {
        this.toInvoiceId = toInvoiceId;
        this.fromInvoiceId = fromInvoiceId;
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
