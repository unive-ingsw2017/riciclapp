package com.riciclapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;

public class Guida extends AppCompatActivity implements View.OnClickListener{

    private AppCompatTextView titoloGuida, testoGuida;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guida);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        AppCompatButton btnCarta = findViewById(R.id.btnCarta);
        AppCompatButton btnOrganico = findViewById(R.id.btnOrganico);
        AppCompatButton btnPlastica = findViewById(R.id.btnPlaticaLattine);
        AppCompatButton btnVetro = findViewById(R.id.btnVetroLattine);
        AppCompatButton btnIndifferenziato = findViewById(R.id.btnIndifferenziato);
        AppCompatButton btnRaee = findViewById(R.id.btnRaee);
        AppCompatButton btnRup = findViewById(R.id.btnRup);
        AppCompatButton btnPileAltro = findViewById(R.id.btnPile);
        titoloGuida = findViewById(R.id.textGuidaTitolo);
        testoGuida = findViewById(R.id.textGuidaTesto);

        testoGuida.setMovementMethod(new ScrollingMovementMethod());

        btnCarta.setOnClickListener(this);
        btnOrganico.setOnClickListener(this);
        btnPlastica.setOnClickListener(this);
        btnVetro.setOnClickListener(this);
        btnIndifferenziato.setOnClickListener(this);
        btnRaee.setOnClickListener(this);
        btnRup.setOnClickListener(this);
        btnPileAltro.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCarta:
                titoloGuida.setText(((Button)v).getText().toString());
                testoGuida.setText(getString(R.string.carta));
                break;
            case R.id.btnOrganico:
                titoloGuida.setText(((Button)v).getText().toString());
                testoGuida.setText(getString(R.string.organico));
                break;
            case R.id.btnPlaticaLattine:
                titoloGuida.setText(((Button)v).getText().toString().replace("\n", ", "));
                testoGuida.setText(getString(R.string.plasticalattine));
                break;
            case R.id.btnVetroLattine:
                titoloGuida.setText(((Button)v).getText().toString().replace("\n", ", "));
                testoGuida.setText(getString(R.string.vetrolattine));
                break;
            case R.id.btnIndifferenziato:
                titoloGuida.setText(((Button)v).getText().toString());
                testoGuida.setText(getString(R.string.secco));
                break;
            case R.id.btnRaee:
                titoloGuida.setText(((Button)v).getText().toString());
                testoGuida.setText(getString(R.string.raee));
                break;
            case R.id.btnRup:
                titoloGuida.setText(((Button)v).getText().toString());
                testoGuida.setText(getString(R.string.rup));
                break;
            case R.id.btnPile:
                titoloGuida.setText(((Button)v).getText().toString().replace("\n", ", "));
                testoGuida.setText(getString(R.string.pile));
                break;
        }
    }
}
