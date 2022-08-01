package com.example.webservices;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    TextView resultadoOro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relacionarVistas();
    }
    public void relacionarVistas() {
        resultadoOro = (TextView) findViewById(R.id.oro);
    }
    public void mensaje(String texto) {
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
    }
    public void webServices3(View v) {
        RequestQueue servicio = Volley.newRequestQueue(this);
        String url = "https://www.goldapi.io/api/XAU/MXN";
        StringRequest respuesta = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        resultadoOro.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mensaje(error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap datos = new HashMap();
                datos.put("Content-Type", "application/json");
                datos.put("x-access-token", "goldapi-11618wtl5jlhquh-io");
                return datos;
            }
        };
        servicio.add(respuesta);

    }
}



