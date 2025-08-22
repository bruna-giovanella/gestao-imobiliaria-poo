package br.com.univille.poo.DAOs;

import br.com.univille.poo.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

class BaseDAO {

    protected Connection con() throws SQLException {
        return ConnectionFactory.getInstance().get();
    }
}
