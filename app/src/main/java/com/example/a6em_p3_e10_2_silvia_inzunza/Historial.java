package com.example.a6em_p3_e10_2_silvia_inzunza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    private TextView saiaTextoHistorial;
    private ArrayList<String> saiaHistorialConversiones;
    private Button saiaAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        saiaHistorialConversiones = getIntent().getStringArrayListExtra("historial");

        saiaTextoHistorial = findViewById(R.id.historial);
        saiaAtras = findViewById(R.id.atras2);

        for (int i = 0; i< saiaHistorialConversiones.size(); i++) {
            saiaTextoHistorial.append(saiaHistorialConversiones.get(i) + '\n');
        }

        saiaAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMenuPrincipal();
            }
        });

    }


    public void irMenuPrincipal() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("historial", saiaHistorialConversiones);
        startActivity(intent);
    }
}