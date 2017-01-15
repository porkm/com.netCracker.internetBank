package main.bll.api;

import java.sql.SQLException;
import java.util.List;

import main.bll.modeldto.TransferDTO;
import main.bll.service.myexeption.InterneteBankExeption;
import main.bll.service.util.TransferError;
import main.dal.entinties.*;
import main.bll.modeldto.CreditDTO;

public interface IServiceCustomer {
    TransferError transferMoney(TransferDTO transferDTO) throws InterneteBankExeption;
    void inviteFriend(int customerId, String friend) throws  InterneteBankExeption;
    boolean checkLoginPassw(Customer checkedCustomer);
    int getIdByLogin(String login) throws InterneteBankExeption;

    List<Invoice> seeInvoises(int customerId) throws  InterneteBankExeption;

    void makeNextPay(int creditId, int invoiceId) throws  InterneteBankExeption;
    void closedCredit(Credit credit, Invoice invoice);
}
