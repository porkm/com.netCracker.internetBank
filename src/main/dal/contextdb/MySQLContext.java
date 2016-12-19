package main.dal.contextdb;

import java.sql.*;
import main.dal.api.IContext;

//todo Singleton
//todo new class Exception

public class MySQLContext implements IContext {

    private final static String URLFIXED =
            "jdbc:mysql://localhost:3306/ibank?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private Connection connection;

    public MySQLContext(){

        try {
            connection = DriverManager.getConnection(URLFIXED, USERNAME, PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}



