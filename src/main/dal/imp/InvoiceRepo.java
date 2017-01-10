package main.dal.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.dal.api.*;
import main.dal.entinties.*;


public class InvoiceRepo implements IRepository<Invoice> {


    private Connection connection;


    private final String GET_ALL ="Select * from invoice";
    private final String GET_ALL_BY_ID = "Select * from invoice WHERE id=?";
    private final String CREATE = "INSERT INTO invoice (balance, customer_id) VALUES(?,?)";
    private final String UPDATE = " UPDATE invoice SET  balance=? WHERE id=?";
    private final String DELETE = "DELETE FROM invoice WHERE id = ?";
    private final String GET_FOR_BY_ID = "select * from invoice  inner join customer  on customer_id=customer.id where customer_id=?";


    public InvoiceRepo(IContext context) {

        connection = context.getConnection();
    }
    @Override
    public List<Invoice> getAll() throws SQLException {
        List<Invoice> invoices = new ArrayList<Invoice>();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(GET_ALL);
        while (res.next()) {
            invoices.add(new Invoice(res.getInt("id"), res.getDouble("balance"), res.getInt("customer_id")));
        }
        return invoices;

    }
    //Для получения списка счетов

    public List<Invoice> getForById(int id) throws SQLException  {
        List<Invoice> invoices = new ArrayList<Invoice>();
        PreparedStatement statement = connection.prepareStatement(GET_FOR_BY_ID);
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            invoices.add(new Invoice(res.getInt("id"), res.getDouble("balance"), res.getInt("customer_id")));
        }
        return invoices;
    }

    @Override
    public Invoice get(int id) throws SQLException {
        Invoice invoice;

        PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_ID);
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
        PreparedStatement statement = connection.prepareStatement(CREATE);
        statement.setDouble(1, item.getBalance());
        statement.setInt(2, item.getCustomerId());

        statement.execute();
    }

    @Override
    public void update(Invoice item) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(UPDATE);

        statement.setDouble(1, item.getBalance());
        statement.setInt(2, item.getId());
        statement.execute();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        statement.execute();

    }
}

