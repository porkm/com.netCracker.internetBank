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
            cards.add(new Card(res.getInt("number"), res.getDate("valid_of"), res.getInt("id_invoice"),
                    res.getString("currency"), res.getDouble("balance")));
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
            cards = new Card(res.getInt("number"), res.getDate("valid_of"), res.getInt("id_invoice"),
                    res.getString("currency"), res.getDouble("balance"));
        } else {
            cards = null;
        }
        return cards;
    }

    @Override
    public void create(Card item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO" +
                " card (number, valid_of, id_invoice, balance, currency) VALUES(?,?,?,?,?)");
        statement.setInt(1, item.getNumber());
        statement.setDate(2, new java.sql.Date(item.getValidOf().getTime()));
        statement.setInt(3, item.getInvoceId());
        statement.setDouble(4, item.getBalance());
        statement.setString(5, item.getCurrency());

        statement.execute();

    }

    @Override
    public void update(Card item) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(" UPDATE card SET " +
                " number=?, valid_of=?, id_invioce=?, balance=?, currency=? WHERE number=?");
        statement.setInt(1, item.getNumber());
        statement.setDate(2, new java.sql.Date(item.getValidOf().getTime()));
        statement.setInt(3, item.getInvoceId());
        statement.setDouble(4, item.getBalance());
        statement.setString(5, item.getCurrency());
        statement.setInt(6, item.getNumber());
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
    public List<Card> getForById(int invoicesId) throws SQLException {
        List<Card> cards = new ArrayList<Card>();
        PreparedStatement statement = connection.prepareStatement("select * from card inner join invoice on card.id_invoice=invoice.id where id_invoice=?");
        statement.setInt(1, invoicesId);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            cards.add(new Card(res.getInt("number"), res.getDate("valid_Of"), res.getInt("id_invoice"),
                    res.getString("currency"), res.getDouble("balance")));
        }
        return cards;
    }
}

