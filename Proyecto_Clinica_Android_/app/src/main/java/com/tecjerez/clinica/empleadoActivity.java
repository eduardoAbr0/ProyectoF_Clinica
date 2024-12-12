package com.tecjerez.clinica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import db.conexionDB;
import entities.Empleado;

public class empleadoActivity extends Activity {

    Spinner spinnerPuesto;
    EditText cajaId, cajaNombre, cajaPrimerAp, cajaSegundoAp, cajaCalle, cajaNumCasa, cajaColonia, cajaCP, cajaNumTelefono;
    conexionDB bd;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empleados);

        cajaId = findViewById(R.id.editTextId);
        cajaNombre = findViewById(R.id.editTextNombre);
        cajaPrimerAp = findViewById(R.id.editTextPrimerApellido);
        cajaSegundoAp = findViewById(R.id.editTextSegundoApellido);
        cajaCalle = findViewById(R.id.editTextCalle);
        cajaNumCasa = findViewById(R.id.editTextNumCasa);
        cajaColonia = findViewById(R.id.editTextColonia);
        cajaCP = findViewById(R.id.editTextCp);
        cajaNumTelefono = findViewById(R.id.editTextTelefono);


        spinnerPuesto = findViewById(R.id.spinnerPuesto);
        String[] puestos = {"Medico", "Enfermera", "Practicante"};
        ArrayAdapter<String> adapterPuesto = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, puestos);
        adapterPuesto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPuesto.setAdapter(adapterPuesto);

    }

    public void agregarEmpleado(View v){
        bd = conexionDB.getAppDatabase(getBaseContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bd.empleadoDAO().agregarEmpleado(new Empleado(
                            cajaNombre.getText().toString(),
                            cajaPrimerAp.getText().toString(),
                            cajaSegundoAp.getText().toString(),
                            cajaCalle.getText().toString(),
                            Integer.parseInt(cajaNumCasa.getText().toString()),
                            cajaColonia.getText().toString(),
                            Integer.parseInt(cajaCP.getText().toString()),
                            cajaNumTelefono.getText().toString(),
                            spinnerPuesto.getSelectedItem().toString()
                    ));
                    Log.i("MSJ->", "Insertado Correctamente");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "Empleado agregado.", Toast.LENGTH_LONG).show();
                        }
                    });

                } catch (Exception e) {
                    Log.e("Error->", "Error al insertar empleado: " + e.getMessage());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "Error al agregar empleado.", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        }).start();
    }

    public void eliminarEmpleado(View v){
        bd = conexionDB.getAppDatabase(getBaseContext());

        if (cajaId.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(), "Ingresa un id.", Toast.LENGTH_LONG).show();
        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int rowsDeleted = bd.empleadoDAO().deleteByID(cajaId.getText().toString());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (rowsDeleted > 0) {
                                Toast.makeText(getBaseContext(), "Empleado eliminado correctamente", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getBaseContext(), "Error al eliminar, ID no encontrado", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }).start();
        }

    }

    public void modificarEmpleado(View w){
        bd = conexionDB.getAppDatabase(getBaseContext());

        if(cajaId.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Ingresa id.", Toast.LENGTH_LONG).show();
        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bd.empleadoDAO().updateEmpleadoByID(cajaNombre.getText().toString(), cajaPrimerAp.getText().toString(), cajaSegundoAp.getText().toString(), cajaCalle.getText().toString(), Integer.valueOf(cajaNumCasa.getText().toString()),
                            cajaColonia.getText().toString(), Integer.valueOf(cajaCP.getText().toString()),cajaNumTelefono.getText().toString(), spinnerPuesto.getSelectedItem().toString(),cajaId.getText().toString());

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

    public void abrirMostrar(View view){
        Intent i = new Intent(this, empleadoMostrarActivity.class);
        startActivity(i);
    }

}
