package main.dal.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.dal.api.*;
import main.dal.entinties.*;


public class RequestRepo implements IRepository<Request> {


    private Connection connection;


    private final String GET_ALL ="Select * from request";
    private final String GET_ALL_BY_ID = "Select * from request WHERE id=?";
    private final String CREATE = "INSERT INTO  request (id_customer, frend) VALUES(?,?)";
    private final String UPDATE = " UPDATE request SET  id_customer=?, frend=? WHERE id=?";
    private final String DELETE = "DELETE FROM request  WHERE id = ?";
    private final String GET_FOR_BY_ID = "select * from request  inner join customer  on id_customer=customer.id where id_customer=?";


    public RequestRepo(IContext context) {

        connection = context.getConnection();
    }

    @Override
    public List<Request> getAll() throws SQLException {
        List<Request> requests = new ArrayList<Request>();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(GET_ALL);
        while (res.next()) {
            requests.add(new Request(res.getInt("id"), res.getString("frend"), res.getInt("id_customer")));
        }
        return requests;
    }

    public List<Request> getForById(int id) throws SQLException {
        List<Request> credits = new ArrayList<Request>();
        PreparedStatement statement = connection.prepareStatement(GET_FOR_BY_ID);
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            credits.add(new Request(res.getInt("id"), res.getString("frend"), res.getInt("id_customer")));
        }
        return credits;
    }

    @Override
    public Request get(int id) throws SQLException {
        Request requests;

        PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_ID);
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            requests = new Request(res.getInt("id"), res.getString("frend"), res.getInt("id_customer"));
        } else {
            requests = null;
        }
        return requests;
    }

    @Override
    public void create(Request item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(CREATE);
        statement.setInt(1, item.getCustomerId());
        statement.setString(2, item.getFriend());
        statement.execute();
    }

    @Override
    public void update(Request item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setInt(1, item.getCustomerId());
        statement.setString(2, item.getFriend());
        statement.setInt(3, item.getId());
        statement.execute();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        statement.execute();
    }
}

