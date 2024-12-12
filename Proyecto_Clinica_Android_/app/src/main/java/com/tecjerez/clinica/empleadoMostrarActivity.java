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
import entities.Empleado;

public class empleadoMostrarActivity extends Activity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Empleado> datos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empleados_busqueda);

        recyclerView = findViewById(R.id.recyclerViewEmpleado);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        conexionDB bd = conexionDB.getAppDatabase(getBaseContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                datos = (ArrayList<Empleado>) bd.empleadoDAO().mostrarTodos();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new empleadoAdapter(datos);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }
}

class empleadoAdapter extends RecyclerView.Adapter<empleadoAdapter.ViewHolder>{

    private ArrayList<Empleado> localDatSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView v;
        public TextView id, nombre, papellido, sapellido, calle, numcasa, cp, colonia, tel, puesto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            v = itemView.findViewById(R.id.imageViewEmpleado);
            id = itemView.findViewById(R.id.txtviewIDEmpleado);
            nombre = itemView.findViewById(R.id.txtviewNombreEmpleado);
            papellido = itemView.findViewById(R.id.txtviewApellido1Empleado);
            sapellido = itemView.findViewById(R.id.txtviewApellido2Empleado);
            calle = itemView.findViewById(R.id.txtviewCalle);
            numcasa = itemView.findViewById(R.id.txtviewNumcasa);
            cp = itemView.findViewById(R.id.txtviewCP);
            colonia = itemView.findViewById(R.id.txtviewColonia);
            tel = itemView.findViewById(R.id.txtviewTelefonoEmpleado);
            puesto = itemView.findViewById(R.id.txtviewPuesto);
        }

    }

    public empleadoAdapter(ArrayList<Empleado> dataset){
        localDatSet = dataset;
    }


    @NonNull
    @Override
    public empleadoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empleado_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull empleadoAdapter.ViewHolder holder, int position) {
        Empleado empleado = localDatSet.get(position);

        holder.v.setImageResource(R.drawable.icon_usuario);

        holder.id.setText("ID: "+empleado.getId());
        holder.nombre.setText("Nombre: "+empleado.getNombre());
        holder.papellido.setText("Primer apellido: "+empleado.getPrimerAp());
        holder.sapellido.setText("Segundo apellido: "+empleado.getSegundoAp());
        holder.calle.setText("Calle: "+empleado.getCalle());
        holder.numcasa.setText("Num casa: "+empleado.getNumCasa());
        holder.colonia.setText("Colonia: "+empleado.getColonia());
        holder.cp.setText("CP casa: "+empleado.getCP());
        holder.tel.setText("Telefono: "+empleado.getNumTelefono());
        holder.puesto.setText("Puesto: "+empleado.getPuesto());
    }

    @Override
    public int getItemCount() {
        return localDatSet.size();
    }
}
