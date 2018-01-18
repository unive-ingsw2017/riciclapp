package com.riciclapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CentroEcologico extends AppCompatActivity {

    int pos, bottone, preferito;
    String provincia,prov_saved, address;
    boolean isfavourite;
    ImageButton star;
    SharedPreferences settings;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_ecologico);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        settings = getSharedPreferences("preferito", Context.MODE_PRIVATE);

        preferito = settings.getInt("pos", -1);
        prov_saved = settings.getString("prov", "");

        TextView comune = (TextView) findViewById(R.id.text_nome_comune);
        TextView dettagli = (TextView) findViewById(R.id.text_dettagli_eco);

        bottone = getIntent().getIntExtra("BOTTONE", 0);
        star = (ImageButton) findViewById(R.id.btnAddPref);

        InputStream inputStream = getResources().openRawResource(R.raw.ecocentri);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> ecoList = csvFile.read();

        if (bottone == 4) {
            //arriva da selezione provincia o preferiti
            pos = getIntent().getIntExtra("POSIZIONE", 0);
            provincia = getIntent().getStringExtra("PROVINCIA");

            List<String[]> auxList = new ArrayList<String[]>();

            for (String[] object : ecoList) {
                if (object[3].equals(provincia)) {
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

            setAddress(linea[7],linea[8],provincia);

            comune.setText(linea[5]);
            dettagli.setText(
                    "BACINO : " + "\n" + linea[4] + "\n\n" +
                    "INDIRIZZO : " + "\n" + linea[7] + "\n\n" +
                    "COMUNE : " + "\n" + linea[8] + "\n\n" +
                    "ECOMOBILE : " + "\n" + linea[6] + "\n\n" +
                    "SOLO RAEE : " + "\n" + linea[10] + "\n\n" +
                    "PER INFORMAZIONI : " + "\n" + linea[9] + "\n\n");

            if (pos == preferito && prov_saved.equals(provincia)){
                star.setImageResource(R.drawable.ic_star_red_24dp);
            }

        } else if (bottone == 5) {
            //arriva da preferiti
            if (preferito == -1) {
                Intent intent = new Intent(getApplicationContext(), Preferiti.class);
                startActivity(intent);
            }
            else
            {
                List<String[]> auxList = new ArrayList<String[]>();

                for (String[] object : ecoList) {
                    if (object[3].equals(prov_saved)) {
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

                String[] linea = auxList.get(preferito);

                setAddress(linea[7],linea[8],prov_saved);

                comune.setText(linea[5]);
                dettagli.setText(
                        "BACINO : " + "\n" + linea[4] + "\n\n" +
                        "INDIRIZZO : " + "\n" + linea[7] + "\n\n" +
                        "COMUNE : " + "\n" + linea[8] + "\n\n" +
                        "ECOMOBILE : " + "\n" + linea[6] + "\n\n" +
                        "SOLO RAEE : " + "\n" + linea[10] + "\n\n" +
                        "PER INFORMAZIONI : " + "\n" + linea[9] + "\n\n");

                star.setImageResource(R.drawable.ic_star_red_24dp);
            }
        }
    }

    public void onToggleStar(View view){

        star = (ImageButton) findViewById(R.id.btnAddPref);

        preferito = settings.getInt("pos", -1);

        if (preferito != -1)
            isfavourite = true;
        else
            isfavourite = false;

        if(!isfavourite){
            // if the star is not already selected and you select it
            isfavourite = true;
            star.setImageResource(R.drawable.ic_star_red_24dp);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("pos", pos);
            editor.putString("prov", provincia);
            editor.commit();

        }else{
            // if the star is already selected and you unselect it
            isfavourite = false;
            star.setImageResource(R.drawable.ic_star_white_24dp);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("pos", -1);
            editor.putString("prov", "");
            editor.commit();
        }
    }

    public void onMapsClick(View view){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + getAddress());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void setAddress(String ind, String com, String prov){
        address = ind + ", " + com + ", " + prov;
    }

    public String getAddress(){
        return address;
    }
}

