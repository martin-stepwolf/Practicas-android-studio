package com.ingcampos.splashscreen; // nombre del paquete

import androidx.appcompat.app.AppCompatActivity; // Librerias necesarias de compatibilidad

import android.os.Bundle; // Clase que permite la conexion entre activities


public class MainActivity extends AppCompatActivity { // Uso de las librerias de compatibilidad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
