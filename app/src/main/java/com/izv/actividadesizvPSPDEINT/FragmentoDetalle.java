package com.izv.actividadesizvPSPDEINT;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergio.actividadesizv.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragmentoDetalle extends Fragment {

    private static TextView tvDescripcion;
    private static TextView tvProfesor;
    private static TextView tvLugar;
    private static TextView tvFecha;
    private static TextView tvHorarioNormal;
    private static TextView tvHoraSalidaLlegada;
    private static TextView tvLugarSalidaLlegada;
    private static TextView tvTipo;


    public FragmentoDetalle() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragmento_detalle, container, false);
        tvDescripcion = (TextView)v.findViewById(R.id.tvFragmentoDetalle);
        tvProfesor = (TextView)v.findViewById(R.id.tvProfesor);
        tvLugar = (TextView)v.findViewById(R.id.tvLugar);
        tvFecha = (TextView)v.findViewById(R.id.tvFecha);
        tvHorarioNormal = (TextView)v.findViewById(R.id.tvHorarioNormal);

        //tvHoraSalidaLlegada = (TextView)v.findViewById(R.id.tvHoraSalidaLlegada);
        tvLugarSalidaLlegada = (TextView)v.findViewById(R.id.tvLugarSalidaLLegada);
        tvTipo = (TextView)v.findViewById(R.id.tvTipo);
        return v;
    }

    public static void mostrarActividad(ActividadRest a){
        String profesor = "";

        for (int i = 0; i <Principal.alProfesoresL.size() ; i++) {
            if(a.getIdprofesor().equals(Principal.alProfesoresL.get(i).getId())){
                profesor = Principal.alProfesoresL.get(i).getNombre()+" "+Principal.alProfesoresL.get(i).getApellidos();
            }
        }
        tvDescripcion.setText("Descripcion: "+a.getDescripcion().toString());
        tvProfesor.setText("Profesor: " +profesor);
        tvLugar.setText("Lugar: "+a.getLugari());
        tvFecha.setText("Fecha Inicio: "+a.getFechai());
        tvHorarioNormal.setText("Fecha Fin: "+a.getFechaf());
        if(a.getTipo().equalsIgnoreCase("extraescolar")) {
            tvLugarSalidaLlegada.setText("Llegada: " + a.getFechaf());
        }else{
            tvLugarSalidaLlegada.setText("");
        }
        tvTipo.setText(a.getTipo());

    }


}
