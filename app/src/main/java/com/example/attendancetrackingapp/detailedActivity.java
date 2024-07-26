package com.example.attendancetrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendancetrackingapp.databinding.EmpleadoDetalladoBinding;
import com.example.attendancetrackingapp.databinding.RecyclerViewItemBinding;

import Controller.EmpleadoController;

public class detailedActivity extends AppCompatActivity {

    private EmpleadoController empleadoController;
    private int employeeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empleado_detallado);

        empleadoController = new EmpleadoController(this);

        TextView nombre = findViewById(R.id.Ednombre);
        TextView posicion = findViewById(R.id.Edposicion);
        TextView id = findViewById(R.id.EdcodigoEmpleado);
        EditText passwordIngreso = findViewById(R.id.editTextCodigo);
        Button markAttendanceButton = findViewById(R.id.buttonMarcarAsistencia);

        Bundle bundle = getIntent().getExtras();

        String mNombre = bundle.getString("nombre");
        String mApellido = bundle.getString("apellido");
        String mPosicion = bundle.getString("posicion");
        employeeId = bundle.getInt("id");

        nombre.setText(mNombre + " " + mApellido);
        posicion.setText(mPosicion);
        id.setText(Integer.toString(employeeId));

        markAttendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordIngreso.getText().toString();
                markAttendance(employeeId, password);
            }
        });
    }

    private void markAttendance(int id, String password) {
        empleadoController.markAttendance(id, password, new EmpleadoController.MarkAttendanceCallback() {
            @Override
            public void onAttendanceMarked(boolean success) {
                if (success) {
                    Toast.makeText(detailedActivity.this, "Asistencia marcada correctamente", Toast.LENGTH_SHORT).show();
                    Intent resultIntent = new Intent();
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    Toast.makeText(detailedActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}