package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;

public class SelezionaComune extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    int bottone;
    String provincia;
    private EcoArrayAdapter ecoArrayAdapter;
    private ListView listView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleziona_comune);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        bottone = getIntent().getIntExtra("BOTTONE", 0);
        provincia = getIntent().getStringExtra("PROVINCIA");

        listView = (ListView) findViewById(R.id.listViewComune);
        ecoArrayAdapter = new EcoArrayAdapter(provincia, getApplicationContext(), R.layout.item_layout);

        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(ecoArrayAdapter);
        listView.onRestoreInstanceState(state);

        InputStream inputStream = getResources().openRawResource(R.raw.ecocentri);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> ecoList = csvFile.read();

        for(String[] linea:ecoList ) {
            ecoArrayAdapter.add(linea);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id){
                // qui dentro stabilisco cosa fare dopo il click
                Intent intent = new Intent(getApplicationContext(), CentroEcologico.class);
                intent.putExtra("POSIZIONE", pos);
                intent.putExtra("BOTTONE", bottone);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(), CentroEcologico.class);
        intent.putExtra("POSIZIONE", i);
        intent.putExtra("BOTTONE", bottone);
        startActivity(intent);
    }

}