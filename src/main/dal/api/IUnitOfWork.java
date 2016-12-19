package main.dal.api;

import main.dal.entinties.*;


public interface IUnitOfWork {
    IRepository<Card> cards();
    IRepository<Credit> credits();
    IRepository<Customer> customers();
    IRepository<Employed> employeds();
    IRepository<Invoice> invoices();
    IRepository<Request> requests();
}