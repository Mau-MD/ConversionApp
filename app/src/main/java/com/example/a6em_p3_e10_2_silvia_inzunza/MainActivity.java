package com.example.a6em_p3_e10_2_silvia_inzunza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Historial
    private ArrayList<String> saiaHistorialConversiones;

    // Botones menu principal
    private Button saiaConversionesVolumen;
    private Button saiaConversionesLongitud;
    private Button saiaHistorial;
    private Button saiaBorrar;
    private Button saiaDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menu Principal

        // Iniciar historial
        saiaHistorialConversiones = getIntent().getStringArrayListExtra("historial");
        if (saiaHistorialConversiones == null) {
            saiaHistorialConversiones = new ArrayList<>();
        }
        // Declarar botones
        saiaConversionesVolumen = findViewById(R.id.conversionesVolumen);
        saiaConversionesLongitud = findViewById(R.id.conversionesLongitud);
        saiaHistorial = findViewById(R.id.historial);
        saiaBorrar = findViewById(R.id.borrar);
        saiaDescripcion = findViewById(R.id.descripcion);

        // Eventos botones
        saiaConversionesVolumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMenuConversionesVolumen();
            }
        });

        saiaConversionesLongitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMenuConversionesLongitud();
            }
        });

        saiaHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHistorial();
            }
        });

        saiaBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Historial borrado correctamente", Toast.LENGTH_SHORT).show();
                saiaHistorialConversiones.clear();
            }
        });

        saiaDescripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Programa que convierte distintos tipos de unidades \n Creado por Areana Inzunza", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void irMenuConversionesVolumen() {
        Intent intent = new Intent(this, MenuConversionesVolumen.class);
        intent.putExtra("historial", saiaHistorialConversiones);
        startActivity(intent);
    }

    public void irMenuConversionesLongitud() {
        Intent intent = new Intent(this, MenuConversionesLongitud.class);
        intent.putExtra("historial", saiaHistorialConversiones);
        startActivity(intent);
    }

    public void irHistorial() {
        Intent intent = new Intent(this, Historial.class);
        intent.putExtra("historial", saiaHistorialConversiones);
        startActivity(intent);
    }

}