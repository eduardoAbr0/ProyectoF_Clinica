package com.example.proyecto_clinica_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;

public class empleadoActivity extends Activity {

    Spinner spinnerPuesto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empleados);


        spinnerPuesto = findViewById(R.id.spinnerPuesto);
        String[] puestos = {"Medico", "Enfermera", "Practicante"};
        ArrayAdapter<String> adapterPuesto = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, puestos);
        adapterPuesto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPuesto.setAdapter(adapterPuesto);

    }

    public void abrirMostrar(View view){
        Intent i = new Intent(this, empleadoMostrarActivity.class);
        startActivity(i);
    }

}
