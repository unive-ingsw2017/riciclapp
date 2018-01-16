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
//        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);

        score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

//        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
//        int totalScore = settings.getInt("totalScore", 0);
//        totalScore += score;

        resultLabel.setText(score + " / 10");
//        totalScoreLabel.setText("Total Score : " + totalScore);
//
//        // Update total score.
//        SharedPreferences.Editor editor = settings.edit();
//        editor.putInt("totalScore", totalScore);
//        editor.commit();
    }
    
    public void returnTop(View view) {
        Intent intent = new Intent(getApplicationContext(), Gioco.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }

}