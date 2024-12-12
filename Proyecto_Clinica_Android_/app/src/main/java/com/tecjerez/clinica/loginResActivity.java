package com.tecjerez.clinica;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import db.conexionDB;
import entities.Empleado;
import entities.Login;

public class loginResActivity extends Activity {
    private EditText usuario, contra;
    conexionDB bd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usuario = findViewById(R.id.cajaUsuario);
        contra = findViewById(R.id.cajaContra);
    }

    
}
