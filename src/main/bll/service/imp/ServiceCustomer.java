package main.bll.service.imp;

import main.bll.api.IServiceCustomer;
import main.bll.modeldto.TransferDTO;
import main.bll.service.myexeption.InterneteBankExeption;
import main.bll.service.util.CreditCalculate;
import main.bll.service.util.InvoiceUtil;
import main.bll.service.util.PassUtil;
import main.bll.service.util.TransferError;
import main.dal.api.IUnitOfWork;
import main.dal.entinties.Credit;
import main.dal.entinties.Customer;
import main.dal.entinties.Invoice;
import main.dal.entinties.Request;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;


public class ServiceCustomer implements IServiceCustomer {


    @Autowired
    private IUnitOfWork unit;

    public ServiceCustomer(IUnitOfWork unit) {
        this.unit = unit;
    }


    @Override
    public boolean checkLoginPassw(Customer checkedCustomer) {
        boolean check = false;
        try {
            check = unit.customers().getAll().stream().anyMatch(
                    x ->
                            x.getLogin().equals(checkedCustomer.getLogin())
                                    &&
                                    x.getPassw().equals(PassUtil.getPassSHA(checkedCustomer.getPassw()))
            );
        } catch (SQLException e) {
            return check;
        }
        return check;
    }

    @Override
    public int getIdByLogin(String login) throws InterneteBankExeption {
        int id;
        try {
            id = unit.customers().getAll().stream()
                    .filter(x -> x.getLogin().equals(login))
                    .findFirst()
                    .get()
                    .getId();
        } catch (SQLException e) {
            throw new InterneteBankExeption("Пользователь не существует");
        }
        return id;
    }

    @Override
    public synchronized TransferError transferMoney(TransferDTO transferDTO) throws InterneteBankExeption {

        InvoiceUtil invoiceUtil = new InvoiceUtil(transferDTO, unit);
        TransferError result;
        try {
            result = invoiceUtil.makeTransfer();
        } catch (SQLException e) {
            throw new InterneteBankExeption("Невозможно сделать перевод. Ошибка БД");
        }
        return result;
    }


    @Override
    public synchronized void inviteFriend(int customerId, String friend) throws InterneteBankExeption {
        try {
            unit.requests().create(new Request(0, friend, customerId));
        } catch (SQLException e) {
            throw new InterneteBankExeption("Невозможно пригласить друга. Ошибка БД");
        }
    }

    @Override
    public void makeNextPay(int creditId, int invoiceId) throws InterneteBankExeption {
        Credit credit;
        Invoice invoice;

        try {
            credit = unit.credits().get(creditId);
            invoice = unit.invoices().get(invoiceId);
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных в БД");
        }


        if (invoice.getBalance() < credit.getPay()) {
            throw new InterneteBankExeption("На счете нет денег для платежа");
        }

        credit.setSumCredit(credit.getSumCredit() - credit.getPay());
        invoice.setBalance(invoice.getBalance() - credit.getPay());

        CreditCalculate creditCalc = new CreditCalculate(credit);
        synchronized (credit){
            credit.setDayOfPay(creditCalc.setNextPay());
        }
        synchronized (credit) {
            try {
                unit.credits().update(credit);
            } catch (SQLException e) {
                throw new InterneteBankExeption("Ошибка проведения платежа");
            }
        }
        synchronized (invoice) {
            try {
                unit.invoices().update(invoice);
            } catch (SQLException e) {
                throw new InterneteBankExeption("Ошибка проведения платежа");
            }
        }
    }

    @Override
    public void closedCredit(Credit credit, Invoice invoice) {

    }

    public List<Invoice> seeInvoises(int customerId) throws InterneteBankExeption {
        List<Invoice> list;
        try {
            list = unit.customers().get(customerId).getInvoices();
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных в БД");
        }
        return list;
    }


}

