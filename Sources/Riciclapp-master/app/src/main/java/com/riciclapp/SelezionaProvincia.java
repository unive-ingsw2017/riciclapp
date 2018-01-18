package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.InputStream;
import java.util.List;

public class SelezionaProvincia extends AppCompatActivity implements View.OnClickListener {

    int bottone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleziona_provincia);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        bottone = getIntent().getIntExtra("BOTTONE", 0);

//        AppCompatButton btnGioco = findViewById(R.id.btnPadova);
//        AppCompatButton btnStatistiche = findViewById(R.id.btnRovigo);
//        btnGuida = findViewById(R.id.btnBelluno);
//        btnSelezionaProvincia = findViewById(R.id.btnVenezia);
//        btnPosizioneCorrente = findViewById(R.id.btnVicenza);
//        btnPreferiti = findViewById(R.id.btnVerona);
//
//        btnGioco.setOnClickListener(this);
//        btnStatistiche.setOnClickListener(this);
//        btnGuida.setOnClickListener(this);
//        btnSelezionaProvincia.setOnClickListener(this);
//        btnPosizioneCorrente.setOnClickListener(this);
//        btnPreferiti.setOnClickListener(this);
//
////        InputStream inputStream = getResources().openRawResource(R.raw.ecocentri);
////        CSVFile csvFile = new CSVFile(inputStream);
////        List<String[]> ecoList = csvFile.read();

//        Intent intent = new Intent(getApplicationContext(), SelezionaComune.class);
//        intent.putExtra("PROVINCIA", provincia);
//        intent.putExtra("BOTTONE", bottone);
//        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnPadova:
                startActivity(new Intent(this, Gioco.class));
                break;
            case R.id.btnBelluno:
                startActivity(new Intent(this, Guida.class));
                break;
            case R.id.btnRovigo:
                startActivity(new Intent(this, StatisticheHome.class));
                break;
            case R.id.btnVenezia:
                bottone = 4;
                intent = new Intent(getApplicationContext(), SelezionaProvincia.class);
                intent.putExtra("BOTTONE", bottone);
                startActivity(intent);
                break;
            case R.id.btnVicenza:
                bottone = 5;
                intent = new Intent(getApplicationContext(), CentroEcologico.class);
                intent.putExtra("BOTTONE", bottone);
                startActivity(intent);
                break;
            case R.id.btnVerona:
                bottone = 6;
                intent = new Intent(getApplicationContext(), Preferiti.class);
                intent.putExtra("BOTTONE", bottone);
                startActivity(intent);
                break;
        }
    }
}
