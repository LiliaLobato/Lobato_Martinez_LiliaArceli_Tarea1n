package com.example.lilialobato.tarea1;

public class Alumno {
    String strName;
    String strPhone;
    String strEscolaridad;
    String strGenero;
    String strLibro;
    String strDeporte;

    Alumno(String strName, String strPhone, String strEscolaridad,
           String strGenero, String strLibro, String strDeporte) {

        this.strName = strName;
        this.strPhone = strPhone;
        this.strEscolaridad = strEscolaridad;
        this.strGenero = strGenero;
        this.strLibro = strLibro;
        this.strDeporte = strDeporte;
    }
@Override
    public String toString() {
        return "Nombre: " + strName + "\nTeléfono: " + strPhone +
                "\nEscolaridad: " + strEscolaridad + "\nGénero: " + strGenero +
                "\nLibro Favorito: " + strLibro + "\nPractica Deporte: " + strDeporte;
    }
}
