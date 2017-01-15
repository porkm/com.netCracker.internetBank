package main.bll.service.imp;


import main.bll.api.IServiceEmployed;
import main.bll.modeldto.CardDTO;
import main.bll.service.myexeption.InterneteBankExeption;
import main.bll.service.util.CardInfo;
import main.bll.service.util.CreditCalculate;
import main.bll.service.util.MailUtil;
import main.bll.service.util.PassUtil;
import main.bll.service.util.stock.BringFriend;
import main.dal.api.IUnitOfWork;
import main.dal.entinties.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;


public class ServiceEmployed implements IServiceEmployed {

    @Autowired
    private IUnitOfWork unit;


    public ServiceEmployed(IUnitOfWork unit) {
        this.unit = unit;
    }

    @Override
    public synchronized void registerCustomer(Customer newCustomer) throws InterneteBankExeption {
        String password = newCustomer.getPassw();
        newCustomer.setPassw(PassUtil.getPassSHA(password));

        try {
            unit.customers().create(newCustomer);
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка регистрации пользователя");
        }
    }

    @Override
    public List<Invoice> seeInvoises(int customerId) throws InterneteBankExeption {
        List<Invoice> list;
        try {
            list = unit.customers().get(customerId).getInvoices();
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных");
        }
        return list;
    }

    @Override
    public List<Card> seeCards(int invoicesId) throws InterneteBankExeption {
        List<Card> list;
        try {
            list = unit.cards().getForById(invoicesId);
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных");
        }
        return list;
    }

    @Override
    public List<Customer> getAll() throws InterneteBankExeption {

        try {
            return unit.customers().getAll();
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных");
        }

    }

    @Override
    public synchronized void addInvoice(Invoice invoice) throws InterneteBankExeption {
        try {
            unit.invoices().create(invoice);
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка создания счета");
        }
    }

    @Override
    public List<Credit> seeCredit(int customerId) throws InterneteBankExeption {

        try {
            return unit.customers().get(customerId).getCredits();
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных");
        }
    }

    @Override
    public void addCard(CardDTO card) throws InterneteBankExeption {

        CardInfo cardInfo = new CardInfo();
        Card addCard = new Card();

        //-------------Проверка уникального номера карты--------------------------

        int newNumberCard = cardInfo.generateNumberCard();
        while (cardInfo.checkUniqNumberCard(unit, newNumberCard)) {
            newNumberCard = cardInfo.generateNumberCard();
        }
        //-------------------------------------------------------------------------
        addCard.setValidOf(cardInfo.setValidOfCard(card.getValidOf()));
        addCard.setNumber(newNumberCard);
        addCard.setInvoceId(card.getInvoceId());
        addCard.setCurrency(card.getCurrency().toString());

        //
        double balance;
        try {
            balance = unit.invoices().get(card.getInvoceId()).getBalance();
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных");
        }
        addCard.setBalance(cardInfo.getBalance(balance, card.getCurrency()));
        synchronized (this) {
            try {
                unit.cards().create(addCard);
            } catch (SQLException e) {
                throw new InterneteBankExeption("Невозможно добавить карту");
            }
        }

    }

    @Override
    public void getBonus(int idCustomer) throws InterneteBankExeption {
        Invoice invoice;
        try {
            invoice = unit.customers().get(idCustomer).getInvoices().get(0);
        } catch (NullPointerException ex) {
            addInvoice(new Invoice(0, 0, idCustomer));
            try {
                invoice = unit.customers().get(idCustomer).getInvoices().get(0);
            } catch (SQLException e) {
                throw new InterneteBankExeption("Ошибка получения данных");
            }
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных");
        }
        BringFriend.addBonus(invoice);
        synchronized (invoice) {
            try {
                unit.invoices().update(invoice);
            } catch (SQLException e) {
                throw new InterneteBankExeption("Невозможно добавить бонус");
            }
        }

    }

    @Override
    public synchronized void addCredit(Credit credit) throws InterneteBankExeption {
        credit.setPercentRate(10);
        CreditCalculate creditCalculate = new CreditCalculate(credit);
        credit.setPay(creditCalculate.getPay());
        credit.setOverPay(creditCalculate.getOverPay());

        try {
            unit.credits().create(credit);
        } catch (SQLException e) {
            throw new InterneteBankExeption("Невозможно выдать кредит");
        }
    }

    @Override
    public List<Request> checkRequest() throws InterneteBankExeption {

        try {
            return unit.requests().getAll();
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных");
        }
    }


    @Override
    public synchronized void registerFriend(Request newRequest) throws InterneteBankExeption {
        Customer newCustomer = new Customer();
        newCustomer.setName(newRequest.getFriend());
        newCustomer.setLogin(newRequest.getFriend());
        String passw = PassUtil.randomPassw();
        MailUtil.sendInfo(newCustomer.getPassw());
        newCustomer.setPassw(PassUtil.getPassSHA(passw));

        //todo transaction
        try {
            unit.customers().create(newCustomer);
            unit.requests().delete(newRequest.getId());
        } catch (SQLException e) {
            throw new InterneteBankExeption("Невозможно зарегистрировать приглашенного");
        }
    }
}
