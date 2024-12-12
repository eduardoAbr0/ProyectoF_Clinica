package com.tecjerez.clinica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import db.conexionDB;
import entities.Login;

public class loginResActivity extends Activity {
    private EditText usuario, contra;
    conexionDB bd;
    Login us;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usuario = findViewById(R.id.cajaUsuario);
        contra = findViewById(R.id.cajaContra);
    }

    public void crearUsuario(View view){
        bd = conexionDB.getAppDatabase(getBaseContext());

        if (usuario.getText().toString().isEmpty() || contra.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(), "Rellena los campos.", Toast.LENGTH_LONG).show();
        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        bd.loginDAO().agregarUsuario(new Login(
                                usuario.getText().toString(),
                                contra.getText().toString()
                        ));
                        Log.i("MSJ->", "Insertado Correctamente");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Se registro usuario.", Toast.LENGTH_LONG).show();
                            }
                        });

                    } catch (Exception e) {
                        Log.e("Error->", "Error al insertar usuario: " + e.getMessage());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Error al agregar usuario.", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }).start();
        }
    }

    public void iniciarSesion(View view){
        bd = conexionDB.getAppDatabase(getBaseContext());
        Intent i = new Intent(this, MainActivity.class);

        if (usuario.getText().toString().isEmpty() || contra.getText().toString().isEmpty()) {
            Toast.makeText(getBaseContext(), "Rellena los campos.", Toast.LENGTH_LONG).show();
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    us = bd.loginDAO().busquedaByID(usuario.getText().toString());

                    if (us == null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "El usuario no existe.", Toast.LENGTH_LONG).show();
                            }
                        });
                    } else if (contra.getText().toString().equals(us.getContra())) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Ingresando", Toast.LENGTH_LONG).show();
                                startActivity(i);
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Contraseña incorrecta.", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }).start();
        }
    }
}
