package main.dal.api;

import java.sql.Connection;


public interface IContext {
    Connection getConnection();
}

