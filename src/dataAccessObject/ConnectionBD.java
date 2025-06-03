package dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tiago Junqueira
 */

public class ConnectionBD {
    private static final String SERVER = "157.90.92.167";
    private static final String USER = "minhabdp_java";
    private static final String PASSWORD = "Jockadh10.";
    private static final String DB_NAME = "minhabdp_clinica_java";
    private static final String URL = "jdbc:mysql://" + SERVER + ":3306/" + DB_NAME;
    private static Connection connection;

    // Construtor privado para evitar instanciar esta classe.
    private ConnectionBD() {}
    
    /**
     * Retoma uma ligação ativa a base de dados.
     * Se a ligação não existir ou estiver fechada, cria uma nova.
     *
     * @return Objeto Connection representando a ligação a base de dados.
     * @throws SQLException Se ocorrer um erro ao estabelecer a ligação.
     */

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
    
     /**
     * Fecha a ligação à base de dados
     */

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a ligação: " + e.getMessage());
        }
    }

    /**
     * Verifica se existe uma ligação ativa à base de dados
     *
     * @return true se a ligação estiver ativa, false caso contrário.
     */
    
    public static boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}

    

