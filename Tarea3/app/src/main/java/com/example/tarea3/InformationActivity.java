package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        TextView nombre = findViewById(R.id.name);
        TextView apellido = findViewById(R.id.lastName);
        TextView carrera = findViewById(R.id.career);
        Intent intent = getIntent();
        nombre.setText(intent.getStringExtra("nombre"));
        apellido.setText(intent.getStringExtra("apellido"));
        carrera.setText(intent.getStringExtra("carrera"));
    }

    public void regresar(View view){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent, 200);
    }
}
