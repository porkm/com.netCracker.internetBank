package main.dal.contextdb;

import java.sql.Connection;
import main.dal.api.IContext;

public class OracleContext implements IContext {
    @Override
    public Connection getConnection() {
        return null;
    }
}
