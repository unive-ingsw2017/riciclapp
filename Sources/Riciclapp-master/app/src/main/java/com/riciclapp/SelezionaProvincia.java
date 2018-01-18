package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.io.InputStream;
import java.util.List;

public class SelezionaProvincia extends AppCompatActivity {

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

        InputStream inputStream = getResources().openRawResource(R.raw.ecocentri);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> ecoList = csvFile.read();

//        Intent intent = new Intent(getApplicationContext(), SelezionaComune.class);
//        intent.putExtra("PROVINCIA", provincia);
//        intent.putExtra("BOTTONE", bottone);
//        startActivity(intent);

    }
}
