package com.tecjerez.clinica;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Calendar;

import db.conexionDB;
import entities.Empleado;
import entities.Paciente;

public class pacienteActivity extends Activity {
    conexionDB bd;
    private Spinner spinnerSexo,spinnerSangre;
    private EditText cajaId, cajaNombre, cajaPrimerAp, cajaSegundoAp, cajaAlergia, cajaNumTelefono,editTextFechaNacimiento;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacientes);

        cajaId = findViewById(R.id.editTextId);
        cajaNombre = findViewById(R.id.editTextNombre);
        cajaPrimerAp = findViewById(R.id.editTextPrimerApellido);
        cajaSegundoAp = findViewById(R.id.editTextSegundoApellido);
        cajaAlergia = findViewById(R.id.editTextAlergias);
        cajaNumTelefono = findViewById(R.id.editTextTelefono);

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

    public void agregarPaciente(View v){
        bd = conexionDB.getAppDatabase(getBaseContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bd.pacienteDAO().agregarPaciente(new Paciente(
                            cajaNombre.getText().toString(),
                            cajaPrimerAp.getText().toString(),
                            cajaSegundoAp.getText().toString(),
                            editTextFechaNacimiento.getText().toString(),
                            spinnerSexo.getSelectedItem().toString(),
                            spinnerSangre.getSelectedItem().toString(),
                            cajaAlergia.getText().toString(),
                            cajaNumTelefono.getText().toString()
                    ));
                    Log.i("MSJ->", "Insertado Correctamente");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "Paciente agregado.", Toast.LENGTH_LONG).show();
                        }
                    });

                } catch (Exception e) {
                    Log.e("Error->", "Error al insertar paciente: " + e.getMessage());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "Error al agregar paciente.", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        }).start();
    }

    public void eliminarPaciente(View v){
        bd = conexionDB.getAppDatabase(getBaseContext());

        if (cajaId.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(), "Ingresa un id.", Toast.LENGTH_LONG).show();
        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int rowsDeleted = bd.pacienteDAO().deleteByID(cajaId.getText().toString());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (rowsDeleted > 0) {
                                Toast.makeText(getBaseContext(), "Paciente eliminado correctamente", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getBaseContext(), "Error al eliminar, ID no encontrado", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }).start();
        }

    }

    public void modificarPaciente(View w){
        bd = conexionDB.getAppDatabase(getBaseContext());

        if(cajaId.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Ingresa id.", Toast.LENGTH_LONG).show();
        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bd.pacienteDAO().updatePacienteByID(cajaNombre.getText().toString(), cajaPrimerAp.getText().toString(), cajaSegundoAp.getText().toString(), editTextFechaNacimiento.getText().toString(), spinnerSexo.getSelectedItem().toString(),
                            spinnerSangre.getSelectedItem().toString(), cajaAlergia.getText().toString(),cajaNumTelefono.getText().toString(), cajaId.getText().toString());


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(),"Cambiado correctamente", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }).start();
        }

    }
}
