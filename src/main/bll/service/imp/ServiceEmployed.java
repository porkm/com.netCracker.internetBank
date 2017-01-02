package main.bll.service.imp;


import java.sql.SQLException;
import java.util.List;

import main.dal.entinties.*;
import main.dal.api.IUnitOfWork;
import main.bll.api.IServiceEmployed;
import main.bll.service.util.*;


public class ServiceEmployed implements IServiceEmployed {

    private IUnitOfWork unit;



    public ServiceEmployed(IUnitOfWork unit) {
        this.unit = unit;
    }

    @Override
    public void registerCustomer(Customer newCustomer) {
        // Проверить существование поллбзователя

        try {
            unit.customers().create(newCustomer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Invoice> seeInvoises(int customerId) throws SQLException {
        List<Invoice> list = null;
        try {
            list = unit.customers().get(customerId).getInvoices();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Card> seeCards(int invoicesId) throws SQLException {
        List<Card> list = null;
        try {
            list = unit.cards().getForById(invoicesId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Customer> getAll() throws SQLException {


        return unit.customers().getAll();
    }

    @Override
    public void createInvoice(Invoice invoice) {
        try {
            unit.invoices().create(invoice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Credit> seeCredit(int customerId) throws SQLException {
        return  unit.customers().get(customerId).getCredits();
    }

    @Override
    public void addCard(int invoicesId) throws SQLException {
       // Card newCard = new Card();
        //todo add chek Date()
        List<Card> cards = unit.cards().getAll();
        CardInfo cardInfo = new CardInfo();

        //-------------Процедура получения уникального номера карты--------------------------
        int newNumberCard = cardInfo.generateNumberCard();
//        for (Card card : cards) {
//            if (card.getNumber() != newNumberCard) {
//                break;
//            }
//            newNumberCard=cardInfo.generateNumberCard();
//        }
        //--------------------------------------------------------------------------------------



        unit.cards().create(new Card(newNumberCard,cardInfo.setValidOfCard(2000),invoicesId));

    }


    @Override
    public void addCredit(Credit credit) {
        credit.setPercentRate(10);

        CreditCalculate creditCalculate = new CreditCalculate(credit);
        credit.setPay(creditCalculate.getPay());
        credit.setOverPay(creditCalculate.getOverPay());


        try {
            unit.credits().create(credit);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Request> chekRequest() throws SQLException {

        return unit.requests().getAll();
    }

}
