package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author manuelkalueka
 */
public class Conexao {

    private static final String password = "admin@kalueka";
    private static final String user = "root";

    public static Connection conectar() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost/ong_gestao", user, password);
    }
}
