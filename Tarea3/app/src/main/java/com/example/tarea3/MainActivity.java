package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tarea3.utilidades.Utilidades;

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
        registrarUsuario(nombre, apellido, carrera);
        Intent intent = new Intent(view.getContext(), InformationActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("carrera", carrera);
        startActivityForResult(intent, 200);
    }

    private void registrarUsuario(String nombre, String apellido, String carrera) {
        ConexionSQLiteHelper conn =
                new ConexionSQLiteHelper(this, "bd_alumnos", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE, nombre);
        values.put(Utilidades.CAMPO_APELLIDO, apellido);
        values.put(Utilidades.CAMPO_CARRERA, carrera);
        Long idRes = db.insert(Utilidades.TABLA_ALUMNO, null, values);
        System.out.println("idRes: " + idRes);
        db.close();
    }

    public void verRegistros(View view) {
        Intent intent = new Intent(view.getContext(), QueryActivity.class);
        startActivityForResult(intent, 200);
    }
}
