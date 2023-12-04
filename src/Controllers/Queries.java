package Controllers;

import Models.Log;
import Models.Repuestos;
import Models.Vehiculo;
import Models.Servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    public static Vehiculo getVehiculoData(Connection connection, String plate) throws SQLException {
        String query = "SELECT * FROM Vehiculo WHERE placa = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, plate);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setPlaca(resultSet.getString("placa"));
                    vehiculo.setModelo(resultSet.getString("modelo"));
                    vehiculo.setColor(resultSet.getString("color"));
                    vehiculo.setMarca(resultSet.getString("marca"));
                    vehiculo.setCreatedAt(resultSet.getTimestamp("created_At"));
                    vehiculo.setUpdatedAt(resultSet.getTimestamp("updated_At"));
                    return vehiculo;
                } else {
                    return null;  // No se encontraron datos para la placa dada
                }
            }
        }
    }

    public static void insertVehicle(Connection connection, Vehiculo vehiculo) throws SQLException {
        String query = "INSERT INTO Vehiculo (placa, modelo, color, marca, created_At) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, vehiculo.getPlaca());
            preparedStatement.setString(2, vehiculo.getModelo());
            preparedStatement.setString(3, vehiculo.getColor());
            preparedStatement.setString(4, vehiculo.getMarca());
            preparedStatement.setTimestamp(5, vehiculo.getCreatedAt());
            preparedStatement.executeUpdate();
        }
    }

    public static List<Servicios> getServicios(Connection connection) throws SQLException {
        List<Servicios> servicios = new ArrayList<>();

        String query = "SELECT * FROM Servicios";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Servicios servicio = new Servicios();
                    servicio.setServicioId(resultSet.getInt("servicio_id"));
                    servicio.setNombre(resultSet.getString("nombre"));
                    servicio.setDescripcion(resultSet.getString("descripcion"));
                    servicio.setPrecio(resultSet.getDouble("precio"));
                    servicios.add(servicio);
                }
            }
        }

        return servicios;
    }

    public static List<Repuestos> getRepuestos(Connection connection) throws SQLException {
        List<Repuestos> repuestos = new ArrayList<>();

        String query = "SELECT * FROM Repuestos";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Repuestos repuesto = new Repuestos();
                    repuesto.setRepuestoId(resultSet.getInt("repuesto_id"));
                    repuesto.setNombre(resultSet.getString("nombre"));
                    repuesto.setDescripcion(resultSet.getString("descripcion"));
                    repuesto.setPrecio(resultSet.getDouble("precio"));
                    repuesto.setStock(resultSet.getInt("stock"));
                    repuestos.add(repuesto);
                }
            }
        }

        return repuestos;
    }

    public static List<Log> getLogs(Connection connection) throws SQLException {
    List<Log> logs = new ArrayList<>();

    String query = "SELECT * FROM Logs";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Log log = new Log();
                log.setLogId(resultSet.getInt("log_id"));
                log.setPlacaVehiculo(resultSet.getString("placa_vehiculo"));
                log.setServicio(resultSet.getString("servicio"));
                log.setRepuesto(resultSet.getString("repuesto"));
                log.setFecha(resultSet.getTimestamp("fecha"));
                logs.add(log);
            }
        }
    }

    return logs;
}
    
    public static void insertLog(Connection connection, Log log) throws SQLException {
        String query = "INSERT INTO Logs (placa_vehiculo, servicio, repuesto, fecha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, log.getPlacaVehiculo());
            preparedStatement.setString(2, log.getServicio());
            preparedStatement.setString(3, log.getRepuesto());
            preparedStatement.setTimestamp(4, log.getFecha());
            preparedStatement.executeUpdate();
        }
    }
}
