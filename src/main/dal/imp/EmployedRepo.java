package main.dal.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.dal.api.*;
import main.dal.entinties.*;


public class EmployedRepo implements IRepository<Employed> {


    private Connection connection;

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
        ResultSet res = statement.executeQuery("Select * from employed");
        while (res.next()) {
            employeds.add(new Employed(res.getInt("id"), res.getString("name"),
                    res.getString("login"), res.getString("passw")));
        }
        return employeds;
    }

    @Override
    public Employed get(int id) throws SQLException {

        Employed employed;

        PreparedStatement statement = connection.prepareStatement("Select * from employed WHERE id=?");
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
        PreparedStatement statement = connection.prepareStatement("INSERT INTO" +
                " employed (name, login, passw) VALUES(?,?,?)");
        statement.setString(1, item.getName());
        statement.setString(2, item.getLogin());
        statement.setString(3, item.getPassw());
        statement.execute();
    }

    @Override
    public void update(Employed item) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(" UPDATE employed SET " +
                "name=?, login=?, passw=? WHERE id=?");
        statement.setString(1, item.getName());
        statement.setString(2, item.getLogin());
        statement.setString(3, item.getPassw());
        statement.setInt(4, item.getId());

        statement.execute();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM employed WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();

    }
}

