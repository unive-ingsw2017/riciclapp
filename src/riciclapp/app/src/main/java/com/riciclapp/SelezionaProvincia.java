package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.InputStream;
import java.util.List;

public class SelezionaProvincia extends AppCompatActivity implements View.OnClickListener {

    int bottone;
    String provincia;

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

        AppCompatButton btnPadova = findViewById(R.id.btnPadova);
        AppCompatButton btnRovigo = findViewById(R.id.btnRovigo);
        AppCompatButton btnBelluno = findViewById(R.id.btnBelluno);
        AppCompatButton btnVenezia = findViewById(R.id.btnVenezia);
        AppCompatButton btnVicenza = findViewById(R.id.btnVicenza);
        AppCompatButton btnVerona = findViewById(R.id.btnVerona);
        AppCompatButton btnTreviso = findViewById(R.id.btnTreviso);

        btnPadova.setOnClickListener(this);
        btnRovigo.setOnClickListener(this);
        btnBelluno.setOnClickListener(this);
        btnVenezia.setOnClickListener(this);
        btnVicenza.setOnClickListener(this);
        btnVerona.setOnClickListener(this);
        btnTreviso.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnPadova:
                provincia = "PD";
                intent = new Intent(getApplicationContext(), SelezionaComune.class);
                intent.putExtra("BOTTONE", bottone);
                intent.putExtra("PROVINCIA", provincia);
                startActivity(intent);
                break;
            case R.id.btnBelluno:
                provincia = "BL";
                intent = new Intent(getApplicationContext(), SelezionaComune.class);
                intent.putExtra("BOTTONE", bottone);
                intent.putExtra("PROVINCIA", provincia);
                startActivity(intent);
                break;
            case R.id.btnRovigo:
                provincia = "RO";
                intent = new Intent(getApplicationContext(), SelezionaComune.class);
                intent.putExtra("BOTTONE", bottone);
                intent.putExtra("PROVINCIA", provincia);
                startActivity(intent);
                break;
            case R.id.btnVenezia:
                provincia = "VE";
                intent = new Intent(getApplicationContext(), SelezionaComune.class);
                intent.putExtra("BOTTONE", bottone);
                intent.putExtra("PROVINCIA", provincia);
                startActivity(intent);
                break;
            case R.id.btnVicenza:
                provincia = "VI";
                intent = new Intent(getApplicationContext(), SelezionaComune.class);
                intent.putExtra("BOTTONE", bottone);
                intent.putExtra("PROVINCIA", provincia);
                startActivity(intent);
                break;
            case R.id.btnVerona:
                provincia = "VR";
                intent = new Intent(getApplicationContext(), SelezionaComune.class);
                intent.putExtra("BOTTONE", bottone);
                intent.putExtra("PROVINCIA", provincia);
                startActivity(intent);
                break;
            case R.id.btnTreviso:
                provincia = "TV";
                intent = new Intent(getApplicationContext(), SelezionaComune.class);
                intent.putExtra("BOTTONE", bottone);
                intent.putExtra("PROVINCIA", provincia);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }

}
