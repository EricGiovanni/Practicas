package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tarea3.utilidades.Utilidades;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class QueryActivity extends AppCompatActivity {

    private ConexionSQLiteHelper conn;
    private SQLiteDatabase db;
    private Cursor cursor;
    private ListView listaAlumnos;
    private List<String> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        listaAlumnos = findViewById(R.id.listView);
        alumnos = new ArrayList<>();

        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_alumnos", null, 1);
        db = conn.getReadableDatabase();

        String[] campos = {Utilidades.CAMPO_ID, Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_APELLIDO,
                Utilidades.CAMPO_CARRERA};

        try {
            cursor = db.query(Utilidades.TABLA_ALUMNO, campos, null, null,
                    null, null, null);
            if(cursor != null) {
                cursor.moveToFirst();
                do {
                    alumnos.add(cursor.getString(0) + " - "
                            + cursor.getString(1) + " "
                            + cursor.getString(2) + " - "
                            + cursor.getString(3));
                }while(cursor.moveToNext());
            }
            cursor.close();
            db.close();
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alumnos);
            listaAlumnos.setAdapter(adapter);
        }catch(Exception e) {
            System.out.println("No existen registros");
            limpiar();
        }
    }

    private void limpiar() {
        cursor.close();
        db.close();
    }

    public void regresar(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent, 200);
    }
}
