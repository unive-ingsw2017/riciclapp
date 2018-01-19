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

public class Comune extends AppCompatActivity {

    int pos, category;
    List<String[]> scoreList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comune);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView comune = (TextView) findViewById(R.id.text_nome);
        TextView dettagli = (TextView) findViewById(R.id.text_dettagli);

        pos = getIntent().getIntExtra("POSIZIONE", 0);
        category = getIntent().getIntExtra("CAT", 0);

        InputStream inputStream = getResources().openRawResource(R.raw.rifiuti);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> scoreList = csvFile.read();
        List<String[]> auxList = new ArrayList<String[]>();

        for (String[] object:scoreList){
            try {
                Float.valueOf(object[category]);
                auxList.add(object);
                Collections.sort(auxList, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] lhs, String[] rhs) {
                        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                        if (category != 17)
                            return (Float.valueOf(lhs[category])/Float.valueOf(lhs[2])) > (Float.valueOf(rhs[category])/Float.valueOf(rhs[2])) ? -1
                                    : ((Float.valueOf(lhs[category])/Float.valueOf(lhs[2])) < (Float.valueOf(rhs[category]))/Float.valueOf(rhs[2])) ? 1 : 0;
                        else
                            return Float.valueOf(lhs[category]) > Float.valueOf(rhs[category]) ? -1
                                    : Float.valueOf(lhs[category]) < Float.valueOf(rhs[category]) ? 1 : 0;
                    }
                });
                if (category != 17)
                    Collections.reverse(auxList);

            }
            catch ( NumberFormatException e ) {
                if (category == 0){
                    auxList.add(object);
                    Collections.sort(auxList, new Comparator<String[]>() {
                        @Override
                        public int compare(String[] lhs, String[] rhs) {
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            return lhs[1].compareTo(rhs[1]);
                        }
                    });
                }
            }
        }

        String[] linea = auxList.get(pos);

        comune.setText(linea[1]);
        dettagli.setText(
                "Bacino : \t" + linea[0] + "\n" +
                "Popolazione(n°) : \t" + linea[2] + "\n" +
                "Percentuale Raccolta Differenziata : \t" + linea[17] + "\n" +
                "Rifiuti TOTALE(kg) : \t" + linea[16] + "\n" +
                "Secco(kg) : \t" + linea[3] + "\n" +
                "Verde(kg) : \t" + linea[4] + "\n" +
                "Vetro(kg) : \t" + linea[5] + "\n" +
                "Carta e Cartona(kg) : \t" + linea[6] + "\n" +
                "Plastica(kg) : \t" + linea[7] + "\n" +
                "Imballaggi Metallici(kg) : \t" + linea[8] + "\n" +
                "RAEE(kg) : " + linea[9] + "\n" +
                "Multimatreriale(kg) : \t" + linea[10] + "\n" +
                "Altro(kg) : \t" + linea[11] + "\n" +
                "Rifiuti Particolati(kg) : \t" + linea[12] + "\n" +
                "Ingombranti(KG) : \t" + linea[13] + "\n" +
                "Spazzamento(kg) : \t" + linea[14] + "\n" +
                "Utenze(n°) : \t" + linea[18] + "\n");


    }
}
