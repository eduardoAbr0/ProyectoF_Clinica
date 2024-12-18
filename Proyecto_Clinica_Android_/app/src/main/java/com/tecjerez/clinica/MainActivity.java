package com.tecjerez.clinica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void abrirActivities(View v){
        Intent i = null;
        if(v.getId() == R.id.btnEmpleado){
            i = new Intent(this, empleadoActivity.class);
        }else if(v.getId() == R.id.btnPaciente){
            i = new Intent(this, pacienteActivity.class);
        }else if(v.getId() == R.id.btnLogout){
            finish();
            i = new Intent(this, loginResActivity.class);
        }else if(v.getId() == R.id.btnSalir){
            finishAffinity();
            System.exit(0);
        }

        startActivity(i);
    }
}