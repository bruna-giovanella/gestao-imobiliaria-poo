package br.com.univille.poo;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {

    protected Connection con() throws SQLException {
        return ConnectionFactory.getInstance().get();
    }
}
