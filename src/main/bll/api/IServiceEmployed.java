package main.bll.api;

import java.sql.SQLException;
import main.dal.entinties.*;
import java.util.List;

public interface IServiceEmployed {

    void registerCustomer(Customer newCustomer);
    void createInvoice(Invoice invoice, Customer customer);
    void addCard(int invoicesId) throws SQLException;
    void addCredit(Credit credit, Customer customer);
    List<Request> chekRequest() throws SQLException;

    List<Customer> getAll() throws SQLException;


}
