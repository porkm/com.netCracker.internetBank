package main.dal.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.dal.api.*;
import main.dal.entinties.*;


public class InvoiceRepo implements IRepository<Invoice> {

    private IContext context;
    private Connection connection;

    public InvoiceRepo(IContext context) {
        this.context = context;
        connection = context.getConnection();
    }
    @Override
    public List<Invoice> getAll() throws SQLException {
        List<Invoice> invoices = new ArrayList<Invoice>();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("Select * from invoice");
        while (res.next()) {
            invoices.add(new Invoice(res.getInt("id"), res.getDouble("balance"), res.getInt("customer_id")));
        }
        return invoices;

    }
    //Для получения списка счетов

    public List<Invoice> getForCustomerById(int customerId) throws SQLException  {
        List<Invoice> invoices = new ArrayList<Invoice>();
        PreparedStatement statement = connection.prepareStatement("select * from invoice " +
                " inner join customer" +
                " on customer_id=customer.id" +
                " where customer_id=?");
        statement.setInt(1, customerId);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            invoices.add(new Invoice(res.getInt("id"), res.getDouble("balance"), res.getInt("customer_id")));
        }
        return invoices;
    }

    @Override
    public Invoice get(int id) throws SQLException {
        Invoice invoice;

        PreparedStatement statement = connection.prepareStatement("Select * from invoice WHERE id=?");
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            invoice = new Invoice(res.getInt("id"), res.getDouble("balance"), res.getInt("customer_id"));
        } else {
            invoice = null;
        }
        return invoice;
    }

    @Override
    public void create(Invoice item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO" +
                " invoice (balance, customer_id) VALUES(?,?)");
        statement.setDouble(1, item.getBalance());
        statement.setInt(2, item.getCustomerId());

        statement.execute();
    }

    @Override
    public void update(Invoice item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(" UPDATE invoice SET " +
                " balance=?, customer_id=? WHERE id=?");
        statement.setDouble(1, item.getBalance());
        statement.setInt(2, item.getCustomerId());
        statement.setInt(3, item.getId());
        statement.execute();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM invoice" +
                " WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();

    }
}

