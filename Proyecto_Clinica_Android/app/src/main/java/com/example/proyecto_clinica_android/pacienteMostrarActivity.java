package com.example.proyecto_clinica_android;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class pacienteMostrarActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacientes_busqueda);
    }
}
