package com.izv.actividadesizvPSPDEINT;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.sergio.actividadesizv.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Calendar;


public class Aniadir extends Activity {
    /**** DECLARACION DE VARIABLES DE LA INTERFAZ!*****/
    private TextView tvDe, tvHasta,tvFechaSalida,tvFechaLlegada,tvLugarSalida,tvLugarLlegada,tvHoraSalida,tvHoraLlegada;
    private EditText etDescripcion, etDepartamento,  etLugar,etLugarSalida,etLugarLlegada;
    private Spinner spProfesor, spGrupo;
    private static TextView etHoraLlegada,etHoraSalida, etFecha, etHoraDe, etHoraHasta,etFechaSalida,etFechaLlegada;
    private RadioButton rbComplementaria, rbExtraescolar;
    private Button btHoraSalida, btHoraLlegada, btFechaSalida, btFechaLlegada,btHoraDe, btHoraHasta, btFecha;
    /*************************************************/
    ArrayList<String> alGrupos = new ArrayList<String>();
    static ArrayList<String> alProfesores = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        boolean esTablet=b.getBoolean("esTablet");
        if(esTablet){
            showAsPopup(this); // ASI APARECE COMO DIALOGO
        }
        setContentView(R.layout.activity_aniadir);

        /**********VARIABLES INSTANCIADAS***d*********/
        tvHasta = (TextView)findViewById(R.id.tvHasta);
        etDepartamento = (EditText)findViewById(R.id.etDepartamento);
        etDescripcion = (EditText)findViewById(R.id.etDescripcion);
        spProfesor = (Spinner)findViewById(R.id.spProfesor);
        spGrupo = (Spinner)findViewById(R.id.spGrupo);
        rbComplementaria = (RadioButton)findViewById(R.id.rbComplementaria);
        rbExtraescolar = (RadioButton)findViewById(R.id.rbExtraescolar);



        String[] peticiones = new String[2]; // SACAMOS PROFESORES
        peticiones[0] = "profesor";
        peticiones[1] = "grupo"; // SACAMOS GRUPOS
        GetRestFul get = new GetRestFul();
        get.execute(peticiones);






        /*
        ArrayAdapter<String> aaGrupos = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, alGrupos);
        aaGrupos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGrupo.setAdapter(aaGrupos);*/

        // COMPLEMENTARIA
        etHoraHasta = (TextView)findViewById(R.id.etHoraHasta);
        etHoraDe = (TextView)findViewById(R.id.etHoraDe);
        tvDe = (TextView)findViewById(R.id.tvDe);
        etFecha = (TextView)findViewById(R.id.etFecha);
        etLugar = (EditText)findViewById(R.id.etLugar);
        btHoraHasta = (Button)findViewById(R.id.btHoraHasta);
        btHoraDe = (Button)findViewById(R.id.btHoraDe);

        btFecha = (Button)findViewById(R.id.btFecha);
        // EXTRAESCOLAR
        tvFechaSalida = (TextView)findViewById(R.id.tvFechaDe);
        tvFechaLlegada = (TextView)findViewById(R.id.tvFechaHasta);
        tvHoraLlegada = (TextView)findViewById(R.id.tvHoraHasta);
        tvHoraSalida = (TextView)findViewById(R.id.tvHoraDe);
        tvLugarSalida = (TextView)findViewById(R.id.tvSalida);
        tvLugarLlegada = (TextView)findViewById(R.id.tvLlegada);
        etFechaSalida = (TextView)findViewById(R.id.etFechaDe);
        etHoraSalida = (TextView)findViewById(R.id.etHoraSalida);
        etHoraLlegada = (TextView)findViewById(R.id.etHoraLlegada);
        etLugarLlegada = (EditText)findViewById(R.id.etLlegada);
        etFechaLlegada = (TextView)findViewById(R.id.etFechaHasta);
        etLugarSalida = (EditText)findViewById(R.id.etSalida);
        btHoraLlegada = (Button)findViewById(R.id.btHoraLlegada);
        btFechaLlegada = (Button)findViewById(R.id.btFechaDe);
        btFechaSalida = (Button)findViewById(R.id.btFechaHasta);
        btHoraSalida = (Button)findViewById(R.id.btHoraSalida);
        comple();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_aceptar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_accept:
                String profesor,departamento,grupo,descripcion;
                profesor = (spProfesor.getSelectedItemPosition()+1)+"";
                departamento = etDepartamento.getText().toString();
                grupo = spGrupo.getSelectedItem().toString();
                descripcion = etDescripcion.getText().toString();
                if(rbComplementaria.isChecked()){
                    String horaInicio,horaFin,lugar,fecha;
                    horaInicio = etHoraDe.getText().toString();
                    horaFin = etHoraHasta.getText().toString();
                    lugar = etLugar.getText().toString();
                    fecha = etFecha.getText().toString();
                    ActividadRest a = new ActividadRest(
                            profesor,
                            "Complementaria",
                            fecha+" "+horaInicio,
                            fecha+" "+horaFin,
                            lugar,
                            lugar,
                            descripcion,
                            "Sergio");
                    ParametrosPost p = new ParametrosPost();
                    p.url = FragmentoLista.URLBASE+"actividad";
                    p.object = a.getJSON();
                    PostRestFul pr = new PostRestFul();
                    pr.execute(p);
                }else if(rbExtraescolar.isChecked()){
                    String horaSalida,horaLlegada,fechaSalida,fechaLlegada,lugarSalida,lugarLlegada;
                    horaSalida = etHoraSalida.getText().toString();
                    horaLlegada = etHoraLlegada.getText().toString();
                    fechaSalida = etFechaSalida.getText().toString();
                    fechaLlegada = etFechaLlegada.getText().toString();
                    lugarSalida = etLugarSalida.getText().toString();
                    lugarLlegada = etLugarLlegada.getText().toString();
                    ActividadRest a = new ActividadRest(
                            profesor,
                            "extraescolar",
                            fechaSalida+" "+horaSalida,
                            fechaLlegada+" "+horaLlegada,
                            lugarSalida,
                            lugarLlegada,
                            descripcion,
                            "Sergio");
                    ParametrosPost p = new ParametrosPost();
                    p.url = FragmentoLista.URLBASE+"actividad";
                    p.object = a.getJSON();
                    PostRestFul pr = new PostRestFul();
                    pr.execute(p);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void comple(View v){
       // COMPL
        tvDe.setVisibility(View.VISIBLE);
        tvHasta.setVisibility(View.VISIBLE);
        etHoraDe.setVisibility(View.VISIBLE);
        etHoraHasta.setVisibility(View.VISIBLE);
        btHoraDe.setVisibility(View.VISIBLE);
        etLugar.setVisibility(View.VISIBLE);
        etFecha.setVisibility(View.VISIBLE);
        btHoraHasta.setVisibility(View.VISIBLE);
        btFecha.setVisibility(View.VISIBLE);
        // EXTRA HIDDEN
        tvLugarSalida.setVisibility(View.GONE);
        tvLugarLlegada.setVisibility(View.GONE);
        tvHoraSalida.setVisibility(View.GONE);
        tvHoraLlegada.setVisibility(View.GONE);
        tvFechaSalida.setVisibility(View.GONE);
        tvFechaLlegada.setVisibility(View.GONE);
        etHoraSalida.setVisibility(View.GONE);
        etHoraLlegada.setVisibility(View.GONE);
        etFechaSalida.setVisibility(View.GONE);
        etFechaLlegada.setVisibility(View.GONE);
        etLugarSalida.setVisibility(View.GONE);
        etLugarLlegada.setVisibility(View.GONE);
        btFechaLlegada.setVisibility(View.GONE);
        btFechaSalida.setVisibility(View.GONE);
        btHoraSalida.setVisibility(View.GONE);
        btHoraLlegada.setVisibility(View.GONE);
    }
    public void comple(){
        // COMPL
        tvDe.setVisibility(View.VISIBLE);
        tvHasta.setVisibility(View.VISIBLE);
        etHoraDe.setVisibility(View.VISIBLE);
        etHoraHasta.setVisibility(View.VISIBLE);
        btHoraDe.setVisibility(View.VISIBLE);
        etLugar.setVisibility(View.VISIBLE);
        etFecha.setVisibility(View.VISIBLE);
        btHoraHasta.setVisibility(View.VISIBLE);
        btFecha.setVisibility(View.VISIBLE);
        // EXTRA HIDDEN
        tvLugarSalida.setVisibility(View.GONE);
        tvLugarLlegada.setVisibility(View.GONE);
        tvHoraSalida.setVisibility(View.GONE);
        tvHoraLlegada.setVisibility(View.GONE);
        tvFechaSalida.setVisibility(View.GONE);
        tvFechaLlegada.setVisibility(View.GONE);
        etHoraSalida.setVisibility(View.GONE);
        etHoraLlegada.setVisibility(View.GONE);
        etFechaSalida.setVisibility(View.GONE);
        etFechaLlegada.setVisibility(View.GONE);
        etLugarSalida.setVisibility(View.GONE);
        etLugarLlegada.setVisibility(View.GONE);
        btFechaLlegada.setVisibility(View.GONE);
        btFechaSalida.setVisibility(View.GONE);
        btHoraSalida.setVisibility(View.GONE);
        btHoraLlegada.setVisibility(View.GONE);
    }
    public void extraescolar(View v){
       // HIDDEN COMP
        tvDe.setVisibility(View.GONE);
        tvHasta.setVisibility(View.GONE);
        etHoraDe.setVisibility(View.GONE);
        etHoraHasta.setVisibility(View.GONE);
        etLugar.setVisibility(View.GONE);
        etFecha.setVisibility(View.GONE);
        btHoraDe.setVisibility(View.GONE);
        btHoraHasta.setVisibility(View.GONE);
        btFecha.setVisibility(View.GONE);
        /*MOSTRAMOS COMP*/
        tvLugarSalida.setVisibility(View.VISIBLE);
        tvLugarLlegada.setVisibility(View.VISIBLE);
        tvHoraSalida.setVisibility(View.VISIBLE);
        tvHoraLlegada.setVisibility(View.VISIBLE);
        etFechaLlegada.setVisibility(View.VISIBLE);
        etLugarSalida.setVisibility(View.VISIBLE);
        etLugarLlegada.setVisibility(View.VISIBLE);
        btFechaLlegada.setVisibility(View.VISIBLE);
        btFechaSalida.setVisibility(View.VISIBLE);
        btHoraSalida.setVisibility(View.VISIBLE);
        btHoraLlegada.setVisibility(View.VISIBLE);
        tvFechaSalida.setVisibility(View.VISIBLE);
        tvFechaLlegada.setVisibility(View.VISIBLE);
        etHoraSalida.setVisibility(View.VISIBLE);
        etHoraLlegada.setVisibility(View.VISIBLE);
        etFechaSalida.setVisibility(View.VISIBLE);
    }
    // SACAR FECHAS
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener { // PARA SACAR LA HORA
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            if(getTag().toString().compareTo("fechaSalida")==0){
                etFechaSalida.setText(year+"-"+month+"-"+day);
            }else if(getTag().toString().compareTo("fechaLlegada")==0){
                etFechaLlegada.setText(year + "-" + month + "-" + day);
            }else{
                etFecha.setText(year+"-"+month+"-"+day);
            }
        }
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener { // OBTENER HORAS

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            //
            return new TimePickerDialog(getActivity(), this, hour, minute,DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            if(getTag().toString().compareTo("horaDe")==0){
                etHoraDe.setText(hourOfDay + ":" + minute);
            }else if(getTag().toString().compareTo("horaHasta")==0){
                etHoraHasta.setText(hourOfDay + ":" + minute);
            }else if(getTag().toString().compareTo("horaSalida")==0){
                etHoraSalida.setText(hourOfDay + ":" + minute);
            }else{
                etHoraLlegada.setText(hourOfDay + ":" + minute);
            }
        }
    }

    public void fechaSalida(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(),"fechaSalida");
    }

    public void fechaLlegada(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(),"fechaLlegada");
    }

    public void fecha(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(),"fecha");
    }

    public void horaSalida(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"horaSalida");
    }

    public void horaLlegada(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"horaLlegada");
    }

    public void horaDe(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"horaDe");
    }

    public void horaHasta(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"horaHasta");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public static void showAsPopup(Activity activity){
        activity.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.height = 650;
        params.width = 650;
        params.alpha = 1.0f;
        params.dimAmount = 0.5f;
        activity.getWindow().setAttributes((WindowManager.LayoutParams) params);
    }

    static class ParametrosPost{
        String url;
        JSONObject object;
    }

    private class PostRestFul extends AsyncTask<ParametrosPost, Void, String> {

        @Override
        protected String doInBackground(ParametrosPost... s) {
            String r = ClientRestFul.post(s[0].url, s[0].object);
            Log.v("Añadir",r);
            return r;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                System.out.println("llamada notificar");
                FragmentoLista.notificar();
                System.out.println("intenta salir");
                finish();
            }catch(Exception ex){}

        }
    }

    private class GetRestFul extends AsyncTask<String, Void, String[]> {
        @Override
        protected String[] doInBackground(String... s) {
            String[] r = new String[s.length];
            int i = 0;
            for(String a: s){
                r[i] = ClientRestFul.get(FragmentoLista.URLBASE+a);
                i++;
            }
            return r;
        }

        @Override
        protected void onPostExecute(String... s) {
            super.onPostExecute(s);
            JSONTokener token = new JSONTokener(s[0]);
            try {
                //JSONObject root = new JSONObject(tokener); no sirve
                JSONArray array = new JSONArray(token);
                for(int i=0;  i<array.length(); i++){
                    JSONObject object = array.getJSONObject(i);
                    Profesor p = new Profesor(object);
                    alProfesores.add(p.getNombre());
                }
                ArrayAdapter<String> aaProfesor = new ArrayAdapter<String>(Aniadir.this,
                        android.R.layout.simple_spinner_item, alProfesores);
                aaProfesor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spProfesor.setAdapter(aaProfesor);
            }catch(Exception ex){}
            JSONTokener token2 = new JSONTokener(s[1]);
            try {
                //JSONObject root = new JSONObject(tokener); no sirve
                JSONArray array2 = new JSONArray(token2);
                for(int i=0;  i<array2.length(); i++){
                    JSONObject object = array2.getJSONObject(i);
                    Grupo g = new Grupo(object);
                    alGrupos.add(g.getGrupo());
                }
                ArrayAdapter<String> aaGrupo = new ArrayAdapter<String>(Aniadir.this,
                        android.R.layout.simple_spinner_item, alGrupos);
                aaGrupo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spGrupo.setAdapter(aaGrupo);
            }catch(Exception ex){}
            System.out.println(s[1]);
        }
    }

}
