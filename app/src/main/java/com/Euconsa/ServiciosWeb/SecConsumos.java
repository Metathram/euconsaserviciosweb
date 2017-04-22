package com.Euconsa.ServiciosWeb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Metathram on 05/04/2017.
 */




public class SecConsumos extends Activity implements View.OnClickListener {
    private Button baltas, bbajas, bmodificaciones;
    protected void onCreate(Bundle savedInstanceState) {
        TextView Conductor;
        TextView conductorgloval;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.secconsumos);

        final ClaseGlobal claseGlobal = (ClaseGlobal) getApplicationContext();

        // setup botones
        baltas = (Button) findViewById(R.id.btaltas);
        bbajas = (Button) findViewById(R.id.btbajas);
        bmodificaciones  = (Button) findViewById(R.id.btmodificaciones);
        // registra listeners
        baltas.setOnClickListener(this);
        bbajas.setOnClickListener(this);
        bmodificaciones.setOnClickListener(this);


        // CREAMOS LAS VARIABLES Y PILLAMOS LOS DATOS DEL LOGIN.JAVA             ---- OK ----
        Conductor=(TextView) findViewById(R.id.tvconductor);
        Bundle extras= getIntent().getExtras();
        String username=extras.getString("username");
        Conductor.setText(username+", Bienvenido.");

        final String name = claseGlobal.getName();
        conductorgloval=(TextView) findViewById(R.id.tvconductorglobal);
        String tvconductorglobal = " Nombre : "+name;
        conductorgloval.setText(tvconductorglobal);
    }


    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {
            case R.id.btaltas:
                Intent c = new Intent(this, Consumos.class);
                startActivity(c);
                break;
            case R.id.btbajas:
                Intent b = new Intent(this, BajasConsumos.class);
                startActivity(b);
                break;
            case R.id.btmodificaciones:
                Intent m = new Intent(this, ModifConsumos.class);
                startActivity(m);
                break;
            default:
                break;
        }

    }
}