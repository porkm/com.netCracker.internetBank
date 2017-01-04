package main.bll.api;

import java.sql.SQLException;
import java.util.List;

import main.bll.modeldto.TransferDTO;
import main.dal.entinties.*;
import main.bll.modeldto.CreditDTO;

public interface IServiceCustomer {
    List<Invoice> seeInvoises(int customerId) throws SQLException;
    boolean transferMoney(TransferDTO transferDTO)throws SQLException;
    List<CreditDTO>  seeCredit(int customerId) throws SQLException;
    void inviteFriend(int customerId, String friend) throws SQLException;
    boolean checkLoginPassw(Customer checkedCustomer);
    int getIdByLogin(String login);
}
