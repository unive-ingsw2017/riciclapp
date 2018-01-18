package com.riciclapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CentroEcologico extends AppCompatActivity {

    int pos, bottone;
    String provincia;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_ecologico);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView comune = (TextView) findViewById(R.id.text_nome_comune);
        TextView dettagli = (TextView) findViewById(R.id.text_dettagli_eco);

        bottone = getIntent().getIntExtra("BOTTONE", 0);

        InputStream inputStream = getResources().openRawResource(R.raw.ecocentri);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> ecoList = csvFile.read();

        if (bottone == 4){
            //arriva da selezione provincia o preferiti
            pos = getIntent().getIntExtra("POSIZIONE", 0);
            provincia = getIntent().getStringExtra("PROVINCIA");

            List<String[]> auxList = new ArrayList<String[]>();

            for (String[] object:ecoList){
                if (object[3].equals(provincia)){
                    auxList.add(object);
                    Collections.sort(auxList, new Comparator<String[]>() {
                        @Override
                        public int compare(String[] lhs, String[] rhs) {
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            return lhs[5].compareTo(rhs[5]);
                        }
                    });
                }
            }

            String[] linea = auxList.get(pos);

            comune.setText(linea[5]);
            dettagli.setText(
                    "Bacino : " + linea[4] + "\n" +
                    "Indirizzo : " + linea[7] + "\n" +
                    "Comune : " + linea[8] + "\n" +
                    "Ecomobile : " + linea[6] + "\n" +
                    "Solo raee : " + linea[10] + "\n" +
                    "Per informazioni : " + linea[9] + "\n");

        }
        else if (bottone == 6) {
            //arriva da preferiti

        }
        else{
            //arriva da gps

        }

    }
}
