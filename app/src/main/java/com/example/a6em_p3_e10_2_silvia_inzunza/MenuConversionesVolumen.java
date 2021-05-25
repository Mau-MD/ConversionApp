package com.example.a6em_p3_e10_2_silvia_inzunza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuConversionesVolumen extends AppCompatActivity {

    // Botones Menu conversiones
    private ArrayList<String> saiaHistorialConversiones;

    private EditText saiaNumeroCoversion;
    private Button saiaConvertir;
    private Button saiaAtras;
    private TextView saiaResultado;
    private Spinner saiaOpcionConversiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_conversiones);


        // Menu Conversiones -------------

        saiaHistorialConversiones = getIntent().getStringArrayListExtra("historial");


        // Declarar botones

        saiaNumeroCoversion = findViewById(R.id.numeroConvertir);
        saiaConvertir = findViewById(R.id.convertir);
        saiaResultado = findViewById(R.id.resultado);
        saiaAtras = findViewById(R.id.atras);
        saiaOpcionConversiones = findViewById(R.id.spinner);

        final List<String> saiaConversiones = Arrays.asList("Litros - Cuartos", "Cuartos - Litros", "Mililitros - Onzas", "Onzas - Mililitros");

        // Inicializar spinner

        ArrayAdapter saiaAdaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, saiaConversiones);
        saiaAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        saiaOpcionConversiones.setAdapter(saiaAdaptador);

        // Eventos botones

        saiaAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMenuPrincipal();
            }
        });

        saiaConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String saiaOperacion = saiaOpcionConversiones.getSelectedItem().toString();
                if (saiaNumeroCoversion.getText().toString().equals("")) {
                    Toast.makeText(MenuConversionesVolumen.this, "Por favor ingresa una numero", Toast.LENGTH_SHORT).show();
                    return;
                }
                double saiaNumeroAConvertir = Double.parseDouble(saiaNumeroCoversion.getText().toString());
                double saiaNumeroConvertido = 0;
                String saiaUnidadConvertida = "";

                // "Litros - Cuartos", "Cuartos - Litros", "Mililitros - Onzas", "Onzas - Mililitros"
                switch (saiaOperacion) {
                    case "Litros - Cuartos":
                        saiaNumeroConvertido = saiaNumeroAConvertir * 1.057;
                        saiaUnidadConvertida = "qt";
                        break;
                    case "Cuartos - Litros":
                        saiaNumeroConvertido = saiaNumeroAConvertir / 1.057;                        ;
                        saiaUnidadConvertida = "l";
                        break;
                    case "Mililitros - Onzas":
                        saiaNumeroConvertido = saiaNumeroAConvertir /  29.574;
                        saiaUnidadConvertida = "oz";
                        break;
                    case "Onzas - Mililitros":
                        saiaNumeroConvertido = saiaNumeroAConvertir *  29.574;
                        saiaUnidadConvertida = "ml";
                        break;
                }

                DecimalFormat precision = new DecimalFormat("0.00");
                saiaResultado.setText(""+precision.format(saiaNumeroConvertido) + " " + saiaUnidadConvertida);
                saiaHistorialConversiones.add(saiaOperacion + ": " + saiaNumeroAConvertir + " -> " + saiaNumeroConvertido + " " + precision.format(saiaUnidadConvertida));
            }
        });
    }


    public void irMenuPrincipal() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("historial", saiaHistorialConversiones);
        startActivity(intent);
    }


}