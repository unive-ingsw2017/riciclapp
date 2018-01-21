package com.riciclapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.content.Context;

public class Gioco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioco);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView maxScore = (TextView) findViewById(R.id.maxScore);

        int score = getIntent().getIntExtra("SCORE", 0);


        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int max = settings.getInt("max", 0);
        if (score > max){
            max = score;
        }

        maxScore.setText("Best Score: " + max);

        // Update max score.
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("max", max);
        editor.commit();

    }

    public void startQuiz(View view) {

        Intent intent = new Intent(getApplicationContext(), Game.class);
        startActivity(intent);

    }
}