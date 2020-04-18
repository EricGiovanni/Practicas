package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarInfo(View view){
        String nombre = ((EditText) findViewById(R.id.nombre)).getText().toString();
        String apellido = ((EditText) findViewById(R.id.apellido)).getText().toString();
        String carrera = ((EditText) findViewById(R.id.carrera)).getText().toString();
        Intent intent = new Intent(view.getContext(), InformationActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("carrera", carrera);
        startActivityForResult(intent, 200);
    }
}
