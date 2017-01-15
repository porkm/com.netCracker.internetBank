package main.bll.api;

import java.sql.SQLException;

import main.bll.modeldto.CardDTO;
import main.bll.modeldto.CreditDTO;
import main.bll.service.myexeption.InterneteBankExeption;
import main.dal.entinties.*;
import java.util.List;

public interface IServiceEmployed {

    List<Customer> getAll() throws  InterneteBankExeption;
    void registerCustomer(Customer newCustomer) throws InterneteBankExeption;
    //----------------------------------------------------------//
    List<Invoice> seeInvoises(int customerId) throws  InterneteBankExeption;
    List<Card> seeCards(int invoicesId) throws  InterneteBankExeption;
    List<Credit> seeCredit(int customerId) throws InterneteBankExeption;
    //----------------------------------------------------------//
    void addInvoice(Invoice invoice) throws InterneteBankExeption;
    void addCard(CardDTO card) throws  InterneteBankExeption;
    void addCredit(Credit credit) throws InterneteBankExeption;
    //----------------------------------------------------------//
    List<Request> checkRequest() throws  InterneteBankExeption;
    void registerFriend(Request newRequest) throws InterneteBankExeption;
    void getBonus(int idCustomer) throws InterneteBankExeption;





}
