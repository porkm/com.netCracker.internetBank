package main.bll.api;

import java.sql.SQLException;
import java.util.List;

import main.bll.modeldto.TransferDTO;
import main.dal.entinties.*;
import main.bll.modeldto.CreditDTO;

/**
 * Created by Mihalych on 11.12.2016.
 */
public interface IServiceCustomer {
    List<Invoice> seeInvoises(int customerId) throws SQLException;
    void transferMoney(TransferDTO transferDTO)throws SQLException;
    List<CreditDTO>  seeCredit(int customerId) throws SQLException;
    void inviteFriend(int customerId, String friend) throws SQLException;
    boolean checkLoginPassw(Customer checkedCustomer);
    int getIdByLogin(String login);
}
