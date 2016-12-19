package main.dal.imp;

import main.dal.entinties.*;
import main.dal.api.*;
import main.dal.contextdb.*;
import main.dal.imp.*;


public class ContextUnitOfWork implements IUnitOfWork {

    private IRepository<Card> card;
    private IRepository<Credit> credit;
    private IRepository<Customer> customer;
    private IRepository<Employed> employed;
    private IRepository<Invoice> invoice;
    private IRepository<Request> request;

    private IContext context;

    public ContextUnitOfWork(IContext context) {
        this.context = context;
    }

    @Override
    public IRepository<Card> cards() {
        if (card == null)
            card = new CardRepo(context);
        return card;
    }

    @Override
    public IRepository<Credit> credits() {
        if (credit == null)
            credit = new CreditRepo(context);
        return credit;
    }

    @Override
    public IRepository<Customer> customers() {
        if (customer == null)
            customer = new CustomerRepo(context);
        return customer;
    }

    @Override
    public IRepository<Employed> employeds() {
        if (employed == null)
            employed = new EmployedRepo(context);
        return employed;
    }

    @Override
    public IRepository<Invoice> invoices() {
        if (invoice == null)
            invoice = new InvoiceRepo(context);
        return invoice;
    }

    @Override
    public IRepository<Request> requests() {
        if (request == null)
            request = new RequestRepo(context);
        return request;
    }
}

