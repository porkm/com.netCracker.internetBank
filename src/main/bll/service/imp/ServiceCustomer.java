package main.bll.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.bll.modeldto.TransferDTO;
import main.dal.entinties.*;
import main.dal.api.IUnitOfWork;
import main.bll.api.IServiceCustomer;
import main.bll.modeldto.CreditDTO;
import main.bll.service.util.*;


public class ServiceCustomer implements IServiceCustomer {

    private IUnitOfWork unit;

    public ServiceCustomer(IUnitOfWork unit) {
        this.unit = unit;
    }


    @Override
    public boolean checkLoginPassw(Customer checkedCustomer) {
        boolean check = false;
        try {
            check = unit.customers().getAll().stream().anyMatch(
                    x->
                            x.getLogin().equals(checkedCustomer.getLogin())
                            &&
                            x.getPassw().equals(PassUtil.getPassSHA(checkedCustomer.getPassw()))
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int getIdByLogin(String login) {
        int id;
        try {
            id=unit.customers().getAll().stream()
                    .filter(x->x.getLogin().equals(login))
                    .findFirst()
                    .get()
                    .getId();
        } catch (SQLException e) {
            e.printStackTrace();
            id=0;
        }
        return id;
    }

    @Override
    public TransferError transferMoney(TransferDTO transferDTO) throws SQLException {

        InvoiceUtil invoiceUtil = new InvoiceUtil(transferDTO, unit);
        TransferError result =invoiceUtil.makeTransfer();
        return result;
    }


    @Override
    public void inviteFriend(int customerId, String friend) throws SQLException {
        unit.requests().create(new Request(0, friend, customerId));
    }

    @Override
    public void makeNextPay(int creditId, int invoiceId) {
        Credit credit;
        Invoice invoice;
        try {
            credit = unit.credits().get(creditId);
        } catch (SQLException e) {
            e.printStackTrace();
            credit=null;
        }
        try {
            invoice=unit.invoices().get(invoiceId);
        } catch (SQLException e) {
            e.printStackTrace();
            invoice=null;
        }


            credit.setSumCredit(credit.getSumCredit()-credit.getPay());
            invoice.setBalance(invoice.getBalance()-credit.getPay());

            CreditCalculate creditCalc = new CreditCalculate(credit);
            credit.setDayOfPay(creditCalc.setNextPay());
            try {
                unit.credits().update(credit);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                unit.invoices().update(invoice);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void closedCredit(Credit credit, Invoice invoice) {

    }

    public List<Invoice> seeInvoises(int customerId) throws SQLException {
        List<Invoice> list = null;
        try {
            list = unit.customers().get(customerId).getInvoices();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }



}

