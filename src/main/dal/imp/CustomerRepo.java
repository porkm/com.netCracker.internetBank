package main.dal.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.dal.api.*;
import main.dal.entinties.*;


public class CustomerRepo implements IRepository<Customer> {

    private IContext context;
    private Connection connection;


    private final String GET_ALL ="Select * from customer";
    private final String GET_ALL_BY_ID = "Select * from customer WHERE id=?";
    private final String CREATE = "INSERT INTO customer (name, login, passw) VALUES(?,?,?)";
    private final String UPDATE = " UPDATE customer SET name=?, login=?, passw=? WHERE id=?";
    private final String DELETE = "DELETE FROM cusromer WHERE id = ?";



    public CustomerRepo(IContext context) {
        this.context = context;
        connection = context.getConnection();
    }
    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<Customer>();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(GET_ALL);
        while (res.next()) {
            Customer c = new Customer(res.getInt("id"), res.getString("name"),
                    res.getString("login"), res.getString("passw"));

            c.setInvoices(new InvoiceRepo(context).getForById(c.getId()));
            c.setCredits(new CreditRepo(context).getForById(c.getId()));
            c.setRequests(new RequestRepo(context).getForById(c.getId()));
            customers.add(c);
        }
        return customers;
    }

    @Override
    public List<Customer> getForById(int id) throws SQLException {
        return null;
    }

    @Override
    public Customer get(int id) throws SQLException {
        Customer customer;

        PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_ID);
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            customer = new Customer(res.getInt("id"), res.getString("name"),
                    res.getString("login"), res.getString("passw"));
            customer.setInvoices(new InvoiceRepo(context).getForById(id));
            customer.setCredits(new CreditRepo(context).getForById(id));
            customer.setRequests(new RequestRepo(context).getForById(id));
        } else {
            customer = null;
        }
        return customer;
    }

    @Override
    public void create(Customer item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(CREATE);
        statement.setString(1, item.getName());
        statement.setString(2, item.getLogin());
        statement.setString(3, item.getPassw());
        statement.execute();

    }

    @Override
    public void update(Customer item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1, item.getName());
        statement.setString(2, item.getLogin());
        statement.setString(3, item.getPassw());
        statement.setInt(4, item.getId());

        statement.execute();

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        statement.execute();

    }
}

