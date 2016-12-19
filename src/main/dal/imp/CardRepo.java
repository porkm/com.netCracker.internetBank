package main.dal.imp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.dal.api.*;
import main.dal.entinties.*;


public class CardRepo implements IRepository<Card> {

    private IContext context;
    private Connection connection;

    public CardRepo(IContext context) {
        this.context = context;
        connection = context.getConnection();
    }

    @Override
    public List<Card> getAll() throws SQLException {
        List<Card> cards = new ArrayList<Card>();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("Select * from card");
        while (res.next()) {
            cards.add(new Card(res.getInt("number"), res.getDate("valid_of"), res.getInt("id_invoice")));
        }
        return cards;
    }

    @Override
    public Card get(int id) throws SQLException {
        Card cards;

        PreparedStatement statement = connection.prepareStatement("Select * from card WHERE number=?");
        statement.setInt(1, id);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            cards = new Card(res.getInt("number"), res.getDate("valid_of"), res.getInt("id_invoice"));
        } else {
            cards = null;
        }
        return cards;
    }

    @Override
    public void create(Card item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO" +
                " card (number, valid_of, id_invoice) VALUES(?,?,?)");
        statement.setInt(1, item.getNumber());
        statement.setDate(2, (Date) item.getValidOf());
        statement.setInt(3, item.getInvoceId());

        statement.execute();

    }

    @Override
    public void update(Card item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(" UPDATE card SET " +
                " number=?, valid_of=?, id_invioce=? WHERE number=?");
        statement.setInt(1, item.getNumber());
        statement.setDate(2, (Date) item.getValidOf());
        statement.setInt(3, item.getInvoceId());
        statement.setInt(4, item.getNumber());
        statement.execute();


    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM card" +
                " WHERE number = ?");
        statement.setInt(1, id);
        statement.execute();

    }

    @Override
    public List<Card> getForCustomerById(int customerId) throws SQLException {
        return null;
    }
}

