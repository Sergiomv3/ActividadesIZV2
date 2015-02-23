package com.izv.actividadesizvPSPDEINT;

import org.json.JSONObject;

/**
 * Created by sergio on 13/02/2015.
 */
public class Profesor {
    /* CLASE QUE CONTIENE LOS PARAMETROS DE LOS PROFESORES*/
    private String id, nombre, apellidos, departamento;

    public Profesor(String id, String nombre, String apellidos, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }

    public Profesor(JSONObject object) {
        try {
            this.id = object.getString("id");
            this.nombre = object.getString("nombre");
            this.apellidos = object.getString("apellidos");
            this.departamento = object.getString("departamento");
        } catch (Exception ex){}
    }

    public JSONObject getJSON(){
        JSONObject object = new JSONObject();
        try {
            object.put("id", this.id);
            object.put("nombre", this.nombre);
            object.put("apellidos", this.apellidos);
            object.put("departamento", this.departamento);
            return object;
        } catch (Exception ex){
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
