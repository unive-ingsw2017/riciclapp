package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton btnGioco, btnStatistiche, btnGuida, btnSelezionaProvincia, btnPosizioneCorrente;

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
        btnPosizioneCorrente = findViewById(R.id.btnPosizioneCorrente);

        btnGioco.setOnClickListener(this);
        btnStatistiche.setOnClickListener(this);
        btnGuida.setOnClickListener(this);
        btnSelezionaProvincia.setOnClickListener(this);
        btnPosizioneCorrente.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.preferiti:
                startActivity(new Intent(this, Preferiti.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGioco:
                startActivity(new Intent(this, Gioco.class));
                break;
            case R.id.btnGuida:
                startActivity(new Intent(this, Guida.class));
                break;
            case R.id.btnStatistiche:
                startActivity(new Intent(this, Statistiche.class));
                break;
            case R.id.btnSelProvincia:
                startActivity(new Intent(this, SelezionaProvincia.class));
                break;
            case R.id.btnPosizioneCorrente:
                startActivity(new Intent(this, PosizioneCorrente.class));
                break;
        }
    }
}
