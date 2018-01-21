package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class StatisticheHome extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        AppCompatButton btn_all = findViewById(R.id.btn_all);
        AppCompatButton btn_p_secco= findViewById(R.id.btn_p_secco);
        AppCompatButton btn_p_verde = findViewById(R.id.btn_p_verde);
        AppCompatButton btn_p_vetro = findViewById(R.id.btn_p_vetro);
        AppCompatButton btn_p_carta = findViewById(R.id.btn_p_carta);
        AppCompatButton btn_p_plastica = findViewById(R.id.btn_p_plastica);
        AppCompatButton btn_p_rd = findViewById(R.id.btn_p_rd);
        AppCompatButton btn_p_rifiuti = findViewById(R.id.btn_p_rifiuti);

        btn_all.setOnClickListener(this);
        btn_p_secco.setOnClickListener(this);
        btn_p_verde.setOnClickListener(this);
        btn_p_vetro.setOnClickListener(this);
        btn_p_carta.setOnClickListener(this);
        btn_p_plastica.setOnClickListener(this);
        btn_p_rd.setOnClickListener(this);
        btn_p_rifiuti.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int category = 0;//All

        switch (v.getId()) {
            case R.id.btn_all:
                category = 0;
                break;
            case R.id.btn_p_secco:
                category = 3;
                break;
            case R.id.btn_p_verde:
                category = 4;
                break;
            case R.id.btn_p_vetro:
                category = 5;
                break;
            case R.id.btn_p_carta:
                category = 6;
                break;
            case R.id.btn_p_plastica:
                category = 7;
                break;
            case R.id.btn_p_rd:
                category = 17;
                break;
            case R.id.btn_p_rifiuti:
                category = 16;
                break;
        }

        Intent intent = new Intent(getApplicationContext(), Statistiche.class);
        intent.putExtra("FILTER_CAT", category);
        startActivity(intent);
    }
}
