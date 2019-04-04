package br.com.estevaocristino.dsp20191.aulas1316.ap.persistencia.base;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
    String getUrl();
    String getUser();
    String getPassword();
}
