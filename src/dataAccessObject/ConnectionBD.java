package dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConnectionBD {
    private static String SERVER;
    private static String USER;
    private static String PASSWORD;
    private static String DB_NAME;
    private static String URL;
    private static Connection connection;

    static {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            props.load(fis);
            SERVER = props.getProperty("SERVER");
            USER = props.getProperty("USER");
            PASSWORD = props.getProperty("PASSWORD");
            DB_NAME = props.getProperty("DB_NAME");
            URL = "jdbc:mysql://" + SERVER + ":3306/" + DB_NAME;
        } catch (IOException e) {
            System.err.println("Erro a carregar configurações da BD: " + e.getMessage());
        }
    }

    private ConnectionBD() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a ligação: " + e.getMessage());
        }
    }

    public static boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}