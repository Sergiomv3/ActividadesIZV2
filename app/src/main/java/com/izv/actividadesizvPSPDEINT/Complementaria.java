package com.izv.actividadesizvPSPDEINT;

/**
 * Created by sergio on 18/12/2014.
 */
public class Complementaria extends Actividad {

    private String fecha, horaInicio, horaFin, lugar;

    public Complementaria(String profesor, String grupo, String departamento, String descripcion, String fecha, String horaInicio, String horaFin, String lugar) {
        super(profesor, grupo, departamento, descripcion);
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Complementaria{" +
                "fecha='" + fecha + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
