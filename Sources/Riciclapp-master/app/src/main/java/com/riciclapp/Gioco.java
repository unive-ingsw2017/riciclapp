package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class Gioco extends AppCompatActivity implements View.OnClickListener {

    private AppCompatTextView textPunteggio;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioco);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        AppCompatButton btnGame = findViewById(R.id.btnGame);
        textPunteggio = findViewById(R.id.textPunteggio);

        btnGame.setOnClickListener(this);
    }

//    textPunteggio.setText(Game.maxPunteggio.toString());

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGame:
                startActivity(new Intent(this, Game.class));
                break;
        }
    }
}
