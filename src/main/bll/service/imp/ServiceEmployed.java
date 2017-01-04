package main.bll.service.imp;


import java.sql.SQLException;
import java.util.Currency;
import java.util.List;

import main.bll.modeldto.CardDTO;
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
    public void addInvoice(Invoice invoice) {
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
    public void addCard(CardDTO card) throws SQLException {

        CardInfo cardInfo = new CardInfo();
        Card addCard = new Card();

        //-------------Проверка уникального номера карты--------------------------
        int newNumberCard = cardInfo.generateNumberCard();
//        while (unit.cards().getAll().stream().filter(x->x.getNumber()==newNumberCard).count()==0){
//            newNumberCard=cardInfo.generateNumberCard();
//        }
        //--------------------------------------------------------------------------------------
        addCard.setValidOf(cardInfo.setValidOfCard(card.getValidOf()));
        addCard.setNumber(newNumberCard);
        addCard.setInvoceId(card.getInvoceId());
        addCard.setCurrency(card.getCurrency().toString());

        //
        double balance = unit.invoices().get(card.getInvoceId()).getBalance();
        addCard.setBalance(cardInfo.getBalance(balance, card.getCurrency()));


        unit.cards().create(addCard);
    }

    @Override
    public void checkForBonus() throws SQLException {

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
