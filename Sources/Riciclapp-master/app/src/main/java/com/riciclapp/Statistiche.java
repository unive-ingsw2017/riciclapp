package com.riciclapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Parcelable;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;


public class Statistiche extends AppCompatActivity {

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
    }

    //click comune
//    Intent intent = new Intent(getApplicationContext(), comune.class);
//    intent.putExtra("FILTER_CAT", category);
//    startActivity(intent);
}
