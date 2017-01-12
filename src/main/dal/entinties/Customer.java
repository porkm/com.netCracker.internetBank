package main.dal.entinties;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;


    @Size(min = 3, max = 5)
    private String login;
    private String passw;
    private List<Invoice> invoices;
    private List<Credit> credits;
    private  List<Request> requests;
    // private List<Invoice> invoice;


    public Customer(int id, String name, String login, String passw ){
        this.id = id;
        this.name = name;
        this.login = login;
        this.passw = passw;
        invoices = new ArrayList<Invoice>();
        credits = new ArrayList<Credit>();
        requests = new ArrayList<Request>();



    }
    public Customer(){
        invoices = new ArrayList<Invoice>();
        credits = new ArrayList<Credit>();
        requests = new ArrayList<Request>();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }


    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoice) {
        this.invoices = invoice;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
