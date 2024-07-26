package Controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import Model.ModeloEmpleado;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.attendancetrackingapp.VolleySingleton;
import com.example.attendancetrackingapp.empleadoAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class EmpleadoController {

    private final Context context;
    private final RequestQueue requestQueue;

    public EmpleadoController(Context context) {
        this.context = context;
        this.requestQueue = VolleySingleton.getmInstance(context).getRequestQueue();
    }

    public void fetchEmpleados(List<ModeloEmpleado> empleadoList, RecyclerView recyclerView) {
        String url = "http://10.0.2.2:8080/proyecto1/SvEmpleados";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String nombre = jsonObject.getString("nombre");
                            String apellido = jsonObject.getString("apellido");
                            String posicion = jsonObject.getString("posicion");
                            int password_ingreso = jsonObject.getInt("password_ingreso");

                            ModeloEmpleado empleado = new ModeloEmpleado(nombre, apellido, posicion, id, password_ingreso);
                            empleadoList.add(empleado);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    empleadoAdapter adapter = new empleadoAdapter(context, empleadoList);
                    recyclerView.setAdapter(adapter);
                }, error -> Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show());

        requestQueue.add(jsonArrayRequest);
    }

    public void markAttendance(int id, String password, MarkAttendanceCallback callback) {
        String url = "http://10.0.2.2:8080/proyecto1/SvEmpleados?id=" + id;
        Log.d("TAG", "Am I going this far?");


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET, url, null,
                response -> {
                    Log.d("TAG1", "did i go through the lambda expression?");
                    try {
                        Log.d("markAttendance", "Response received: " + response.toString());
                        int password_ingreso = response.getInt("password_ingreso");
                        boolean success = password.equals(String.valueOf(password_ingreso));
                        callback.onAttendanceMarked(success);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error", "JSON parsing error: " + e.getMessage());

                    }
                }, error -> {
            Log.e("error", "Request error: " + error.toString());
            Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
        });


        requestQueue.add(jsonObjectRequest);
    }

    public interface MarkAttendanceCallback {
        void onAttendanceMarked(boolean success);
    }
}

