package com.riciclapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);

        score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        resultLabel.setText(score + " / 15");
    }
    
    public void returnTop(View view) {
        Intent intent = new Intent(getApplicationContext(), Gioco.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Gioco.class));
    }

}