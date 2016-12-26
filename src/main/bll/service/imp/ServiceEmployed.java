package main.bll.service.imp;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    public List<Customer> getAll() throws SQLException {


        return unit.customers().getAll();
    }

    @Override
    public void createInvoice(Invoice invoice, Customer customer) {


    }


    @Override
    public void addCard(int invoicesId) throws SQLException {
        Card newCard = new Card();
        List<Card> cards = unit.cards().getAll();
        CardInfo cardInfo = new CardInfo();

        //-------------Процедура получения уникального номера карты--------------------------
        int newNumberCard = cardInfo.generateNumberCard();
        for (Card card : cards) {
            if (card.getNumber() != newNumberCard) {
                break;
            }
            else newNumberCard=cardInfo.generateNumberCard();
        }
        //--------------------------------------------------------------------------------------



        unit.cards().create(new Card(newNumberCard,cardInfo.setValidOfCard(1),invoicesId));

    }


    @Override
    public void addCredit(Credit credit, Customer customer) {

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
