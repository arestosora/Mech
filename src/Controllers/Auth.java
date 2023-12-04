package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {

    public static void main(String[] args) {
        // Your main method code here
    }

    public static boolean checkPlateExists(Connection connection, String plate) throws SQLException {
        String query = "SELECT * FROM Vehiculo WHERE placa = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, plate);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                boolean plateExists = resultSet.next();
                System.out.print(plateExists);
                return plateExists;
            }
        }
    }
}
