package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conexao = DriverManager.getConnection("");
            return conexao;

        } catch (Exception ex) {
            return null;
        }
    }
}
