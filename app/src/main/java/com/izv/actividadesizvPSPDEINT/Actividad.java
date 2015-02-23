package com.izv.actividadesizvPSPDEINT;

import java.io.Serializable;


public class Actividad implements Serializable{
    private String profesor,grupo,departamento,descripcion;

    public Actividad(String profesor, String grupo, String departamento, String descripcion) {
        this.profesor = profesor;
        this.grupo = grupo;
        this.departamento = departamento;
        this.descripcion = descripcion;
    }

    public Actividad() {
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actividad)) return false;

        Actividad actividad = (Actividad) o;

        if (departamento != null ? !departamento.equals(actividad.departamento) : actividad.departamento != null)
            return false;
        if (descripcion != null ? !descripcion.equals(actividad.descripcion) : actividad.descripcion != null)
            return false;
        if (grupo != null ? !grupo.equals(actividad.grupo) : actividad.grupo != null) return false;
        if (profesor != null ? !profesor.equals(actividad.profesor) : actividad.profesor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = profesor != null ? profesor.hashCode() : 0;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (departamento != null ? departamento.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "profesor='" + profesor + '\'' +
                ", grupo='" + grupo + '\'' +
                ", departamento='" + departamento + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
