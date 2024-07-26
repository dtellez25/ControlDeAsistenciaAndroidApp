package com.example.attendancetrackingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import Controller.EmpleadoController;
import Model.ModeloEmpleado;



public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ModeloEmpleado> empleadoList;
    private EmpleadoController empleadoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RvListaEmpleados);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        empleadoList = new ArrayList<>();
        empleadoController = new EmpleadoController(this);

        empleadoController.fetchEmpleados(empleadoList, recyclerView);
    }
}