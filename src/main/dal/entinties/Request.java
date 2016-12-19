package main.dal.entinties;

public class Request {
    private int id;
    private String frend;
    private int customerId;

    public Request(int id, String frend, int customerId) {
        this.id = id;
        this.frend = frend;
        this.customerId = customerId;
    }

    public Request() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrend() {
        return frend;
    }

    public void setFrend(String frend) {
        this.frend = frend;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
