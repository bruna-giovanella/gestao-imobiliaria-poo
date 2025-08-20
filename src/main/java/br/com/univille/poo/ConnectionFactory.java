package br.com.univille.poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance;

    private ConnectionFactory() {}

    public static ConnectionFactory getInstance() {
        if(instance==null) instance = new ConnectionFactory();
        return instance;
    }

    public Connection get() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/poo-aula";
        String user = "root";
        String password = "basedeelite";
        return DriverManager.getConnection(url, user, password);
    }



}
