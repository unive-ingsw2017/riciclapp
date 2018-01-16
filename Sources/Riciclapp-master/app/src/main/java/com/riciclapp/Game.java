package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;

public class Game extends AppCompatActivity implements View.OnClickListener {

    private AppCompatTextView elemento;
    private int punteggio = 0, numDomanda = 0;
    int maxPunteggio;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppCompatButton btnCarta = findViewById(R.id.btnCarta);
        AppCompatButton btnOrganico = findViewById(R.id.btnOrganico);
        AppCompatButton btnPlastica = findViewById(R.id.btnPlaticaLattine);
        AppCompatButton btnVetro = findViewById(R.id.btnVetroLattine);
        AppCompatButton btnIndifferenziato = findViewById(R.id.btnIndifferenziato);
        AppCompatButton btnRaee = findViewById(R.id.btnRaee);
        AppCompatButton btnRup = findViewById(R.id.btnRup);
        AppCompatButton btnPileAltro = findViewById(R.id.btnPile);
        elemento = findViewById(R.id.textElemento);

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
    public void onClick(View view) {

    }

//    Presumo vada fatta una classe apposta per far andare avanti il gioco ma che non sia una activity
//    numDomanda = maxPunteggio;
//
//    public void increasePunteggio(){
//        punteggio++;
//    }
//
//    public void setElemento(){
//        elemento.setText(random di un dizionario (elemento, tipo/id_bottone));
//    }
//
//    while (numDomanda < 30){
//        gioco va avanti altrimenti torna a Gioco.java
//    }
//    @Override
//    public void onClick(View v) {
//        check id bottone premuto per il aumentare punteggio
//        switch (v.getId()) {
//            case R.id.btnCarta:
//                increasePunteggio();
//                break;
//            case R.id.btnOrganico:
//                testoGuida.setText(getString(R.string.organico));
//                break;
//            case R.id.btnPlaticaLattine:
//                testoGuida.setText(getString(R.string.plasticalattine));
//                break;
//            case R.id.btnVetroLattine:
//                testoGuida.setText(getString(R.string.vetrolattine));
//                break;
//            case R.id.btnIndifferenziato:
//                testoGuida.setText(getString(R.string.secco));
//                break;
//            case R.id.btnRaee:
//                testoGuida.setText(getString(R.string.raee));
//                break;
//            case R.id.btnRup:
//                testoGuida.setText(getString(R.string.rup));
//                break;
//            case R.id.btnPile:
//                testoGuida.setText(getString(R.string.pile));
//                break;
//        }
//    }
}
