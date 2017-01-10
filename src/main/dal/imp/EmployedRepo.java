package main.dal.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.dal.api.*;
import main.dal.entinties.*;


public class EmployedRepo implements IRepository<Employed> {


    private Connection connection;

    private final String GET_ALL ="Select * from employed";
    private final String GET_ALL_BY_ID = "Select * from employed WHERE id=?";
    private final String CREATE = "INSERT INTO employed (name, login, passw) VALUES(?,?,?)";
    private final String UPDATE = " UPDATE employed SET name=?, login=?, passw=? WHERE id=?";
    private final String DELETE = "DELETE FROM employed WHERE id = ?";


    public EmployedRepo(IContext context) {

        connection = context.getConnection();
    }

    //private

    @Override
    public List<Employed> getForById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Employed> getAll() throws SQLException {

        List<Employed> employeds = new ArrayList<Employed>();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(GET_ALL);
        while (res.next()) {
            employeds.add(new Employed(res.getInt("id"), res.getString("name"),
                    res.getString("login"), res.getString("passw")));
        }
        return employeds;
    }

    @Override
    public Employed get(int id) throws SQLException {

        Employed employed;

        PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_ID);
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            employed = new Employed(res.getInt("id"), res.getString("name"),
                    res.getString("login"), res.getString("passw"));
        } else {
            employed = null;
        }
        return employed;
    }

    @Override
    public void create(Employed item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(CREATE);
        statement.setString(1, item.getName());
        statement.setString(2, item.getLogin());
        statement.setString(3, item.getPassw());
        statement.execute();
    }

    @Override
    public void update(Employed item) throws SQLException {

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

