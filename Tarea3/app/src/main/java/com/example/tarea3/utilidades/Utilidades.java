package com.example.tarea3.utilidades;

public class Utilidades {

    public static final String TABLA_ALUMNO = "alumnos";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDO = "apellido";
    public static final String CAMPO_CARRERA = "carrera";

    public static final String CREAR_TABLA_ALUMNO = "CREATE TABLE " + TABLA_ALUMNO
            + " (" + CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CAMPO_NOMBRE + " TEXT, "
            + CAMPO_APELLIDO + " TEXT, " + CAMPO_CARRERA + " TEXT)";

}
