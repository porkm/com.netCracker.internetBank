package main.dal.imp;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import main.dal.api.*;
import main.dal.entinties.*;


public class CreditRepo implements IRepository<Credit> {
    private IContext context;
    private Connection connection;

    public CreditRepo(IContext context) {
        this.context = context;
        connection = context.getConnection();
    }

    @Override
    public List<Credit> getAll() throws SQLException {
        List<Credit> credits = new ArrayList<Credit>();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("Select * from credit");
        while (res.next()) {
            credits.add(new Credit(res.getInt("id"), res.getDouble("sum_credit"), res.getDouble("percent_rate"),
                    res.getDate("day_of_pay"), res.getDouble("pay"), res.getDouble("over_pay"),
                    res.getInt("credit_left"), res.getDate("credit_start"), res.getInt("id_customer")));
        }
        return credits;
    }
    //Для получения списка кредитов
    public List<Credit> getForById(int id) throws SQLException {
        List<Credit> credits = new ArrayList<Credit>();
        PreparedStatement statement = connection.prepareStatement("select * from credit " +
                " inner join customer" +
                " on id_customer=customer.id" +
                " where id_customer=?");
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            credits.add(new Credit(res.getInt("id"), res.getDouble("sum_credit"), res.getDouble("percent_rate"),
                    res.getDate("day_of_pay"), res.getDouble("pay"), res.getDouble("over_pay"),
                    res.getInt("credit_left"), res.getDate("credit_start"), res.getInt("id_customer")));
        }
        return credits;
    }

    @Override
    public Credit get(int id) throws SQLException {
        Credit credit;

        PreparedStatement statement = connection.prepareStatement("Select * from credit WHERE id=?");
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            credit = new Credit(res.getInt("id"), res.getDouble("sum_credit"), res.getDouble("percent_rate"),
                    res.getDate("day_of_pay"), res.getDouble("pay"), res.getDouble("over_pay"),
                    res.getInt("credit_left"), res.getDate("credit_start"), res.getInt("id_customer"));
        } else {
            credit = null;
        }
        return credit;
    }

    @Override
    public void create(Credit item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO" +
                " credit (sum_credit, percent_rate, day_of_pay," +
                " pay, over_pay, id_customer, credit_start, credit_left) VALUES(?,?,?,?,?,?,?,?)");
        statement.setDouble(1, item.getSumCredit());
        statement.setDouble(2, item.getPercentRate());
        statement.setDate(3,   new java.sql.Date (item.getDayOfPay().getTime()));
        statement.setDouble(4, item.getPay());
        statement.setDouble(5, item.getOverPay());
        statement.setInt(6, item.getCustomerId());
        statement.setDate(7, new java.sql.Date (item.getCreditStart().getTime()));
        statement.setInt(8, item.getCreditTerm());

        statement.execute();

    }

    @Override
    public void update(Credit item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(" UPDATE credit SET " +
                " sum_credit=?, percent_rate=?, day_of_pay=?," +
                " pay=?, over_pay=?, id_customer=?, credit_start=?, credit_left=?  WHERE id=?");
        statement.setDouble(1, item.getSumCredit());
        statement.setDouble(2, item.getPercentRate());
        statement.setDate(3, (Date) item.getDayOfPay());
        statement.setDouble(4, item.getPay());
        statement.setDouble(5, item.getOverPay());
        statement.setInt(6, item.getCustomerId());
        statement.setDate(7, (Date) item.getCreditStart());
        statement.setInt(8,  item.getCreditTerm());
        statement.setInt(9, item.getId());

        statement.execute();

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM credit" +
                " WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();

    }
}

