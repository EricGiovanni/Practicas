package com.example.practica1.ui.login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.practica1.R;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private RequestQueue mq;
    private String url = "http://www.lamarr.com.mx/webservice2.php";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mq = Volley.newRequestQueue(this);
    }

    public void send(final View view){
        String user = ((EditText) findViewById(R.id.username)).getText().toString();
        String pass = ((EditText) findViewById(R.id.password)).getText().toString();
        String newUrl = url + "?email=" + user + "&password=" + pass;
        if(user.equals("") || pass.equals("")){
            Toast.makeText(this, "Introduce un correo y una contraseña", Toast.LENGTH_LONG).show();
        }else {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, newUrl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equals("false")){
                                Toast.makeText(view.getContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_LONG);
                            }else{
                                Intent intent = new Intent(view.getContext(), ListActivity.class);
                                intent.putExtra("response", response.toString());
                                startActivityForResult(intent, 200);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(view.getContext(), error.toString(), Toast.LENGTH_LONG).show();
                }
            });
            mq.add(stringRequest);
        }
    }
}
