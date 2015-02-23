package com.izv.actividadesizvPSPDEINT;

/**
 * Created by sergio on 19/12/2014.
 */
public class Extraescolar extends Actividad{

    private String fechaSalida, fechaLlegada, horaSalida, horaLlegada, lugarSalida, lugarLlegada;

    public Extraescolar(String profesor, String grupo, String departamento, String descripcion, String fechaSalida,
                        String fechaLlegada, String horaSalida, String horaLlegada, String lugarSalida, String lugarLlegada) {
        super(profesor, grupo, departamento, descripcion);
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.lugarSalida = lugarSalida;
        this.lugarLlegada = lugarLlegada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getLugarSalida() {
        return lugarSalida;
    }

    public void setLugarSalida(String lugarSalida) {
        this.lugarSalida = lugarSalida;
    }

    public String getLugarLlegada() {
        return lugarLlegada;
    }

    public void setLugarLlegada(String lugarLlegada) {
        this.lugarLlegada = lugarLlegada;
    }

    @Override
    public String toString() {
        return "Extraescolar{" +
                "fechaSalida='" + fechaSalida + '\'' +
                ", fechaLlegada='" + fechaLlegada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", lugarSalida='" + lugarSalida + '\'' +
                ", lugarLlegada='" + lugarLlegada + '\'' +
                '}';
    }
}
