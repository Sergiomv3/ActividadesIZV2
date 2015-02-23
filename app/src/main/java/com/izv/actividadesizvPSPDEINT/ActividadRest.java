package com.izv.actividadesizvPSPDEINT;

import org.json.JSONObject;

import java.io.Serializable;


public class ActividadRest implements Serializable,Comparable<ActividadRest>{
    private String id, idprofesor, tipo, fechai, fechaf, lugari, lugarf, descripcion, alumno;

    public ActividadRest(String idprofesor, String tipo, String fechai, String fechaf, String lugari, String lugarf, String descripcion, String alumno) {
        this.idprofesor = idprofesor;
        this.tipo = tipo;
        this.fechai = fechai;
        this.fechaf = fechaf;
        this.lugari = lugari;
        this.lugarf = lugarf;
        this.descripcion = descripcion;
        this.alumno = alumno;
    }

    public ActividadRest(JSONObject object) {
        try {
            this.id = object.getString("id");
            this.idprofesor = object.getString("idprofesor");
            this.tipo = object.getString("tipo");
            this.fechai = object.getString("fechai");
            this.fechaf = object.getString("fechaf");
            this.lugari = object.getString("lugari");
            this.lugarf = object.getString("lugarf");
            this.descripcion = object.getString("descripcion");
            this.alumno = object.getString("alumno");
        } catch (Exception ex){}
    }

    public JSONObject getJSON(){
        JSONObject object = new JSONObject();
        try {
            //object.put("id", this.id);
            object.put("idprofesor", this.idprofesor);
            object.put("tipo", this.tipo);
            object.put("fechai", this.fechai);
            object.put("fechaf", this.fechaf);
            object.put("lugari", this.lugari);
            object.put("lugarf", this.lugarf);
            object.put("descripcion", this.descripcion);
            object.put("alumno", this.alumno);
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

    public String getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(String idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    public String getFechaf() {
        return fechaf;
    }

    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
    }

    public String getLugari() {
        return lugari;
    }

    public void setLugari(String lugari) {
        this.lugari = lugari;
    }

    public String getLugarf() {
        return lugarf;
    }

    public void setLugarf(String lugarf) {
        this.lugarf = lugarf;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        String profesor = "";

        for (int i = 0; i <Principal.alProfesoresL.size() ; i++) {
            if(getIdprofesor().equals(Principal.alProfesoresL.get(i).getId())){
                profesor = Principal.alProfesoresL.get(i).getNombre()+" "+Principal.alProfesoresL.get(i).getApellidos();
            }
        }
        return descripcion+"\n"+profesor+"\n"+fechai;
    }

    @Override
    public int compareTo(ActividadRest actividad) {
        return actividad.getFechai().compareTo(this.getFechai());
    }
}
