package com.example.paler.pasdeparametres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PasParametres extends AppCompatActivity {
    EditText nombre;
    TextView textViewDatos;
    Button envDatos;
    RadioGroup radioGroup;
    RadioButton radioButtonMujer, radioButtonHombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pas_parametres);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        envDatos = (Button) findViewById(R.id.buttonEnviarDatos);
        textViewDatos = (TextView) findViewById(R.id.textViewDatos);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonMujer = (RadioButton) findViewById(R.id.radioButtonMujer);
        radioButtonHombre = (RadioButton) findViewById(R.id.radioButtonHombre);

        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("MENSAJE");
            boolean enviar = savedInstanceState.getBoolean("ENVIAR");
            boolean nom = savedInstanceState.getBoolean("NOM");
            boolean radiogroup = savedInstanceState.getBoolean("RADIOGROUP");
            boolean hombre = savedInstanceState.getBoolean("HOMBRE");
            boolean mujer = savedInstanceState.getBoolean("MUJER");
            if (enviar == false)
                envDatos.setEnabled(false);
            if (nom == false)
                nombre.setEnabled(false);
            if (radiogroup == false)
                radioGroup.setEnabled(false);
            if (hombre == false)
                radioButtonMujer.setEnabled(false);
            if (mujer == false)
                radioButtonHombre.setEnabled(false);

            textViewDatos.setText(message);
        }
        envDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasParametres.this, MainActivity_Edad.class);
                intent.putExtra("NOM", nombre.getText().toString());
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                lockElementos();
                String edat = data.getStringExtra("EDAD");
                int edatNum = Integer.parseInt(edat);
                if ((edatNum >= 18) && (edatNum < 25)) {
                    textViewDatos.setText("Com que tens " + edatNum + " anys, ja eres major de edat");
                } else if ((edatNum >= 25) && (edatNum < 35)) {
                    textViewDatos.setText("Com que tens " + edatNum + " anys, estas en la flor de la vida");
                } else {
                    textViewDatos.setText("Com que tens " + edatNum + " anys, ai ai ai...");
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("MENSAJE", textViewDatos.getText().toString());
        outState.putBoolean("ENVIAR", envDatos.isEnabled());
        outState.putBoolean("NOM", nombre.isEnabled());
        outState.putBoolean("RADIOGROUP", radioGroup.isEnabled());
        outState.putBoolean("MASCLE", radioButtonHombre.isEnabled());
        outState.putBoolean("FEMELLA", radioButtonMujer.isEnabled());
        super.onSaveInstanceState(outState);
    }

    public void lockElementos() {
        envDatos.setEnabled(false);
        nombre.setEnabled(false);
        radioGroup.setEnabled(false);
        radioButtonMujer.setEnabled(false);
        radioButtonHombre.setEnabled(false);
    }
}