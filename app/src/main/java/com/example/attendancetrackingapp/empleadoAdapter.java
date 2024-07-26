package com.example.attendancetrackingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import Model.ModeloEmpleado;

public class empleadoAdapter extends RecyclerView.Adapter<empleadoAdapter.empleadoHolder> {

    private Context context;
    private List<ModeloEmpleado> empleadoList;

    public empleadoAdapter(Context context, List<ModeloEmpleado> empleados){
        this.context = context;
        empleadoList = empleados;
    }

    @NonNull
    @Override
    public empleadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false);
        return new empleadoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull empleadoAdapter.empleadoHolder holder, int position) {
        ModeloEmpleado empleado = empleadoList.get(position);
        holder.nombre.setText(empleado.getNombre() + " " + empleado.apellido);
        holder.posicion.setText(empleado.getPosicion());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , detailedActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nombre" , empleado.getNombre());
                bundle.putString("apellido" , empleado.getApellido());
                bundle.putString("posicion" , empleado.getPosicion());
                bundle.putInt("id" , empleado.getId());

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return empleadoList.size();
    }

    public class empleadoHolder extends RecyclerView.ViewHolder{

        TextView nombre, posicion;
        LinearLayout linearLayout;

        public empleadoHolder(@NonNull View itemView){
            super(itemView);

            nombre = itemView.findViewById(R.id.RvNombre);
            posicion = itemView.findViewById(R.id.RvPosicion);
            linearLayout = itemView.findViewById(R.id.main_detailedlayout);
        }

    }
}
