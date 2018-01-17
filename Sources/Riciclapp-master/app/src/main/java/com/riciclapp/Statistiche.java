package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;


public class Statistiche extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;
    int category;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiche);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        category = getIntent().getIntExtra("FILTER_CAT", 0);

        listView = (ListView) findViewById(R.id.listView);
        itemArrayAdapter = new ItemArrayAdapter(category, getApplicationContext(), R.layout.item_layout);

        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(itemArrayAdapter);
        listView.onRestoreInstanceState(state);

        InputStream inputStream = getResources().openRawResource(R.raw.rifiuti);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> scoreList = csvFile.read();

        for(String[] scoreData:scoreList ) {
            itemArrayAdapter.add(scoreData);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id){
                // qui dentro stabilisco cosa fare dopo il click
                Intent intent = new Intent(getApplicationContext(), Comune.class);
                intent.putExtra("POSIZIONE", pos);
                intent.putExtra("CAT", category);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(), Comune.class);
        intent.putExtra("COMUNE_NAME", category);
        intent.putExtra("CAT", category);
        startActivity(intent);
    }


    //click comune
//    Intent intent = new Intent(getApplicationContext(), Comune.class);
//    intent.putExtra("FILTER_CAT", category);
//    startActivity(intent);
}
