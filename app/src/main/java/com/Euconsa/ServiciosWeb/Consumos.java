package com.Euconsa.ServiciosWeb;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import static com.Euconsa.ServiciosWeb.R.id.tvconductor;

/**
 * Created by Metathram on 05/04/2017.
 */

public class Consumos extends Activity implements View.OnClickListener {

    TextView Conductor;
    TextView conductorgloval;

    Button btfecha;
    EditText etfecha;
    private int dia,mes,ano;

    //SPINNER
    //protected ArrayAdapter<CharSequence> adapter;
    //Spinner spinner = (Spinner) findViewById(R.id.spubicacion);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumos);


        /*/SPINNER
        adapter = ArrayAdapter.createFromResource(this, R.array.lugarrepostaje,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // FIN SPINNER
**/


// INDICAMOS EL CONDUCTOR.

// SACAMOS EL NOMBRE DEL CONDUCTOR.
        final ClaseGlobal claseGlobal = (ClaseGlobal) getApplicationContext();

        final String name = claseGlobal.getName();
        conductorgloval = (TextView) findViewById(tvconductor);
        String tvconductor = name;
        conductorgloval.setText(tvconductor);

// LA FECHA...
        btfecha=(Button)findViewById(R.id.btfecha);
        etfecha=(EditText)findViewById(R.id.etfecha);
        btfecha.setOnClickListener(this); //Permanecemos a la escucha del botón.

        final Calendar c= Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        ano=c.get(Calendar.YEAR);
        etfecha.setText(dia+"/"+mes+"/"+ano);

// TERMINAMOS LA INDICACIÓN DEL CONDUCTOR.
    }


    @Override
    public void onClick(View v) {
        if(v==btfecha){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    etfecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);

                }

            },dia,mes,ano);
            datePickerDialog.show();
        }


    }
}


