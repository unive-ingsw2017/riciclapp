package com.riciclapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.io.InputStream;
import java.util.List;

public class SelezionaComune extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleziona_comune);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        InputStream inputStream = getResources().openRawResource(R.raw.ecocentri);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> ecoList = csvFile.read();



    }
}
