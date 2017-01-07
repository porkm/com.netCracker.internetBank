package main.bll.api;

import java.sql.SQLException;

import main.bll.modeldto.CardDTO;
import main.bll.modeldto.CreditDTO;
import main.dal.entinties.*;
import java.util.List;

public interface IServiceEmployed {

    List<Customer> getAll() throws SQLException;
    void registerCustomer(Customer newCustomer);
    //----------------------------------------------------------//
    List<Invoice> seeInvoises(int customerId) throws SQLException;
    List<Card> seeCards(int invoicesId) throws SQLException;
    List<Credit> seeCredit(int customerId) throws SQLException;
    //----------------------------------------------------------//
    void addInvoice(Invoice invoice);
    void addCard(CardDTO card) throws SQLException;
    void addCredit(Credit credit);
    //----------------------------------------------------------//
    List<Request> checkRequest() throws SQLException;
    void registerFriend(Request newRequest);
    void getBonus(int idCustomer) throws SQLException;





}
