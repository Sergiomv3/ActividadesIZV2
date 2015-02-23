package com.izv.actividadesizvPSPDEINT;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sergio.actividadesizv.R;

import java.util.ArrayList;


public class Adaptador extends ArrayAdapter<String> {

    private Context contexto;
    private ArrayList<ActividadRest> lista;
    private int recurso;
    static LayoutInflater i;


    public static class ViewHolder{
        public TextView tv1;
        public int position;
    }

    public Adaptador(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);
        this.contexto=context;
        this.lista=objects;
        this.recurso=resource;
        this.i = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView == null){
            convertView = i.inflate(recurso, null);
            vh = new ViewHolder();
            vh.tv1=(TextView)convertView.findViewById(R.id.tvFecha);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder)convertView.getTag();
        }
        vh.position = position;
        vh.tv1.setText(lista.get(position).toString());
        return convertView;

    }


}