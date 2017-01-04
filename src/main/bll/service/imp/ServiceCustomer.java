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
    public List<Invoice> seeInvoises(int customerId) {

        //todo cath exeption and validate model
        List<Invoice> list = null;
        try {
            list = unit.customers().get(customerId).getInvoices();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    @Override
    public boolean checkLoginPassw(Customer checkedCustomer) {
        boolean check = false;
        try {
            check = unit.customers().getAll().stream().anyMatch(
                    x->
                            x.getLogin().equals(checkedCustomer.getLogin())
                            &&
                            x.getPassw().equals(checkedCustomer.getPassw())
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
    public boolean transferMoney(TransferDTO transferDTO) {

        InvoiceUtil invoiceUtil = new InvoiceUtil(transferDTO, unit);

        boolean result =invoiceUtil.makeTransfer();
        return result;
    }

    @Override
    public List<CreditDTO> seeCredit(int customerId) throws SQLException {
        List<Credit> credits = unit.customers().get(customerId).getCredits();
        List<CreditDTO> creditDTO = new ArrayList<>();

        for (Credit credit: credits) {
            CreditDTO model = new CreditDTO();
            //model.s

        }

        return null;

    }

    @Override
    public void inviteFriend(int customerId, String friend) throws SQLException {
        unit.requests().create(new Request(0, friend, customerId));

    }


}

