package com.example.proyecto_clinica_android;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import java.util.Calendar;

public class pacienteActivity extends Activity {
    private EditText editTextFechaNacimiento;
    Spinner spinnerSexo,spinnerSangre;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacientes);

        editTextFechaNacimiento = findViewById(R.id.editTextFechaNacimiento);

        editTextFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        pacienteActivity.this,
                        (view, year1, month1, dayOfMonth1) -> {
                            editTextFechaNacimiento.setText(dayOfMonth1 + "-" + (month1 + 1) + "-" + year1);
                        },
                        year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

        spinnerSexo = findViewById(R.id.spinnerSexo);
        String[] sexos = {"Masculino", "Femenino"};
        ArrayAdapter<String> adapterSexo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sexos);
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSexo.setAdapter(adapterSexo);

        spinnerSangre = findViewById(R.id.spinnerTipoSangre);
        String[] sangre = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+","O-"};
        ArrayAdapter<String> adapterSangre = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sangre);
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSangre.setAdapter(adapterSangre);
    }

    public void abrirMostrar(View view){
        Intent i = new Intent(this, pacienteMostrarActivity.class);
        startActivity(i);
    }
}
