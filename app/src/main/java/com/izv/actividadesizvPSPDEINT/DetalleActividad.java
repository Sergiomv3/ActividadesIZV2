package com.izv.actividadesizvPSPDEINT;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sergio.actividadesizv.R;


public class DetalleActividad extends Activity {

    ActividadRest a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad);
        a = (ActividadRest)getIntent().getExtras().getSerializable("actividad");
        FragmentoDetalle.mostrarActividad(a);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_borrar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_borrar) {
            borrar(a.getId()); // BORRAMOS
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void borrar(String id){ // PASAMOS ID Y BORRAMOS
        Toast.makeText(this,a.toString()+"-----------"+a.getId(),Toast.LENGTH_LONG).show();
        DeleteRestFul dr = new DeleteRestFul();
        dr.execute(id);
    }

    private class DeleteRestFul extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... s) {
            String r = ClientRestFul.delete(FragmentoLista.URLBASE+"actividad/"+s[0]);
            return r;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


        }
    }
}
