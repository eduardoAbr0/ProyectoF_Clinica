package com.tecjerez.clinica;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import db.conexionDB;
import entities.Paciente;

public class pacienteMostrarActivity extends Activity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Paciente> datos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacientes_busqueda);

        recyclerView = findViewById(R.id.recycleViewPaciente);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        conexionDB bd = conexionDB.getAppDatabase(getBaseContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                datos = (ArrayList<Paciente>) bd.pacienteDAO().mostrarTodos();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new pacienteAdapter(datos);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }
}

class pacienteAdapter extends RecyclerView.Adapter<pacienteAdapter.ViewHolder>{

    private ArrayList<Paciente> localDatSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView v;
        public TextView id, nombre, papellido, sapellido, fechaNac, sexo, sangre, alergias, tel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            v = itemView.findViewById(R.id.imageViewPaciente);
            id = itemView.findViewById(R.id.txtviewIDPaciente);
            nombre = itemView.findViewById(R.id.txtviewNombre);
            papellido = itemView.findViewById(R.id.txtviewApellido1);
            sapellido = itemView.findViewById(R.id.txtviewApellido2);
            fechaNac = itemView.findViewById(R.id.txtviewFechaNac);
            sexo = itemView.findViewById(R.id.txtviewSexo);
            sangre = itemView.findViewById(R.id.txtviewSangre);
            alergias = itemView.findViewById(R.id.txtviewAlergias);
            tel = itemView.findViewById(R.id.txtviewTelefono);
        }

    }

    public pacienteAdapter(ArrayList<Paciente> dataset){
        localDatSet = dataset;
    }


    @NonNull
    @Override
    public pacienteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paciente_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pacienteAdapter.ViewHolder holder, int position) {
        Paciente paciente = localDatSet.get(position);

        holder.v.setImageResource(R.drawable.icon_usuario);

        holder.id.setText("ID: "+paciente.getId());
        holder.nombre.setText("Nombre: "+paciente.getNombre());
        holder.papellido.setText("Primer apellido: "+paciente.getPrimerAp());
        holder.sapellido.setText("Segundo apellido: "+paciente.getSegundoAp());
        holder.fechaNac.setText("Fecha nacimiento: "+paciente.getFechaNac());
        holder.sexo.setText("Sexo: "+paciente.getSexo());
        holder.sangre.setText("Tipo sangre: "+paciente.getSangre());
        holder.alergias.setText("Alergias: "+paciente.getAlergia());
        holder.tel.setText("Telefono: "+paciente.getNumTelefono());
    }

    @Override
    public int getItemCount() {
        return localDatSet.size();
    }
}
