package main.bll.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import main.dal.entinties.*;
import main.dal.api.IUnitOfWork;
import main.bll.modeldto.CreditDTO;
import main.bll.service.imp.ServiceCustomer;
import java.util.List;


public class ServiceCustomer implements IServiceCustomer {

    private IUnitOfWork unit;

    public ServiceCustomer(IUnitOfWork unit) {
        this.unit = unit;
    }

    @Override
    public List<Invoice> seeInvoises(int customerId) throws SQLException {

        //todo cath exeption and validate model
        return  unit.customers().get(customerId).getInvoices();
    }

    @Override
    public void transferMoney(Customer me, Customer you, double money) {

        Transfer transfer = new Transfer();




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

