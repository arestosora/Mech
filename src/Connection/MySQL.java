
package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/taller_mecanico";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static java.sql.Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    public static void closeConnection(java.sql.Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
