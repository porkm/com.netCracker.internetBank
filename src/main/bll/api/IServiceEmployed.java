package main.bll.api;

import java.sql.SQLException;
import main.dal.entinties.*;
import java.util.List;

public interface IServiceEmployed {

    void registerCustomer(Customer newCustomer);
    List<Invoice> seeInvoises(int customerId) throws SQLException;
    List<Card> seeCards(int invoicesId) throws SQLException;
    List<Credit> seeCredit(int customerId) throws SQLException;
    void createInvoice(Invoice invoice);
    void addCard(int invoicesId) throws SQLException;
    void addCredit(Credit credit);
    List<Request> chekRequest() throws SQLException;

    List<Customer> getAll() throws SQLException;


}
