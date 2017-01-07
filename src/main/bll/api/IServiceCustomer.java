package main.bll.api;

import java.sql.SQLException;
import java.util.List;

import main.bll.modeldto.TransferDTO;
import main.bll.service.util.TransferError;
import main.dal.entinties.*;
import main.bll.modeldto.CreditDTO;

public interface IServiceCustomer {
    TransferError transferMoney(TransferDTO transferDTO)throws SQLException;
    void inviteFriend(int customerId, String friend) throws SQLException;
    boolean checkLoginPassw(Customer checkedCustomer);
    int getIdByLogin(String login);

    List<Invoice> seeInvoises(int customerId) throws SQLException;

    void makeNextPay(Credit credit, Invoice invoice);
    void closedCredit(Credit credit, Invoice invoice);
}
