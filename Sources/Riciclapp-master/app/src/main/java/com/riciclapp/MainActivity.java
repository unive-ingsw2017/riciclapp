package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton btnGioco, btnStatistiche, btnGuida, btnSelezionaProvincia, btnPreferiti;
    int bottone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnGioco = findViewById(R.id.btnGioco);
        btnStatistiche = findViewById(R.id.btnStatistiche);
        btnGuida = findViewById(R.id.btnGuida);
        btnSelezionaProvincia = findViewById(R.id.btnSelProvincia);
        btnPreferiti = findViewById(R.id.btnPreferiti);

        btnGioco.setOnClickListener(this);
        btnStatistiche.setOnClickListener(this);
        btnGuida.setOnClickListener(this);
        btnSelezionaProvincia.setOnClickListener(this);
        btnPreferiti.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnGioco:
                startActivity(new Intent(this, Gioco.class));
                break;
            case R.id.btnGuida:
                startActivity(new Intent(this, Guida.class));
                break;
            case R.id.btnStatistiche:
                startActivity(new Intent(this, StatisticheHome.class));
                break;
            case R.id.btnSelProvincia:
                bottone = 4;
                intent = new Intent(getApplicationContext(), SelezionaProvincia.class);
                intent.putExtra("BOTTONE", bottone);
                startActivity(intent);
                break;
            case R.id.btnPreferiti:
                bottone = 5;
                intent = new Intent(getApplicationContext(), CentroEcologico.class);
                intent.putExtra("BOTTONE", bottone);
                startActivity(intent);
                break;
        }
    }
}
