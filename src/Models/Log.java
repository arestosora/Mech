package Models;

import java.sql.Timestamp;

public class Log {
    private int logId;
    private String placaVehiculo;
    private String servicio;
    private String repuesto;
    private Timestamp fecha;

    // Constructor
    public Log(String placaVehiculo, String servicio, String repuesto, Timestamp fecha) {
        this.placaVehiculo = placaVehiculo;
        this.servicio = servicio;
        this.repuesto = repuesto;
        this.fecha = fecha;
    }

    public Log() {
        
    }

    // Getters and Setters
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
