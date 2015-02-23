package com.izv.actividadesizvPSPDEINT;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by sergio on 13/02/2015.
 */
public class Grupo  implements Serializable{
    private String id,
            grupo;

    public Grupo(){}

    public Grupo(JSONObject object){
        try {
            this.id = object.getString("id");
            this.grupo = object.getString("grupo");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJSON(){
        JSONObject objetoJSON = new JSONObject();
        try {
            objetoJSON.put("id", this.id);
            objetoJSON.put("grupo", this.grupo);
            return objetoJSON;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Grupo(String id, String grupo) {
        this.id = id;
        this.grupo = grupo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return this.grupo;
    }
}


