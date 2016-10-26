package com.example.paler.pasdeparametres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity_Edad extends AppCompatActivity {
    TextView textoSuperior;
    Button botonContinuar;
    EditText textEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__edad);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textoSuperior = (TextView) findViewById(R.id.textViewSuperior);
        botonContinuar = (Button) findViewById(R.id.buttonRetornarDatos);
        textEdad = (EditText) findViewById(R.id.editTextEdad);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("NOM");
        textoSuperior.setText("Hola en " + nombre + ", indica'ns les següents dades:");

        Button retornarDatos = (Button) findViewById(R.id.buttonRetornarDatos);
        retornarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("EDAD", textEdad.getText().toString());
                setResult(Activity.RESULT_OK, intent1);
                finish();
            }
        });

    }
}

