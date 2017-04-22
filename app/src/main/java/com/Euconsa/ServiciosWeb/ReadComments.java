package com.Euconsa.ServiciosWeb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static com.Euconsa.ServiciosWeb.R.id.username;

/**
 * Created by Metathram on 21/03/2017.
 */
public class ReadComments extends ActionBarActivity {



    // IP de mi Url
    String IP = "http://euconsa.es/esw";
    // Rutas deL Web Services
    String GET_BY_ID = IP + "/datosconductor.php";

    TextView Bienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // note that use read_comments.xml instead of our single_post.xml
                setContentView(R.layout.read_comments);

        // CREAMOS LAS VARIABLES Y PILLAMOS LOS DATOS DEL LOGIN.JAVA             ---- OK ----
        Bienvenido=(TextView) findViewById(R.id.bienvenido);
        Bundle extras= getIntent().getExtras();
        String username=extras.getString("username");
        Bienvenido.setText(username+", Bienvenido.");
        // VARIABLE GLOBAL.
        final ClaseGlobal claseGlobal = (ClaseGlobal) getApplicationContext();
        claseGlobal.setName(username);
        // FUNCIONANDO.                                                          ---- OK ----
        // MANTENEMOS EL NOMBRE PARA MANDARLO A LAS SIGUIENTES PANTALLAS.

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.consumos){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),"Cargando Sección Consumos...", Toast.LENGTH_SHORT);
            toast1.show();
            Intent c = new Intent(ReadComments.this, SecConsumos.class);
            (c).putExtra("username", username);
            finish();
            startActivity(c);
            return true;
        }
        if (id == R.id.acercade){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Seleccionado Acerca de...", Toast.LENGTH_SHORT);
            toast1.show();
            Intent a = new Intent(this, Acercade.class);
            startActivity(a);
            return true;
        }
        return super.onOptionsItemSelected(item);
       }
}
