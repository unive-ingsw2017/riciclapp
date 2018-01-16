package com.riciclapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Game extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 15;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"giornali", "carta", "raee", "secco", "organico"},
            {"riviste", "carta", "organico", "secco", "plastica"},
            {"libri", "carta", "secco", "plastica", "rup"},
            {"quaderni", "carta", "organico", "secco", "plastica"},
            {"fustini dei detersivi", "carta", "secco", "rup", "raee"},
            {"fotocopie", "carta", "organico", "secco", "plastica"},
            {"tetrapak", "carta", "secco", "rup", "raee"},
            {"frutta", "organico", "secco", "carta", "raee"},
            {"verdura", "organico", "secco", "carta", "raee"},
            {"alimenti", "organico", "secco", "carta", "raee"},
            {"fondi di caffè", "organico", "secco", "carta", "raee"},
            {"gusci d’uovo", "organico", "secco", "carta", "raee"},
            {"biodegradabili", "organico", "secco", "carta", "raee"},
            {"noccioli", "organico", "secco", "carta", "raee"},
            {"salviette", "organico", "secco", "carta", "raee"},
            {"pane", "organico", "secco", "carta", "raee"},
            {"bottiglie di acqua", "plastica", "secco", "vetro/lattine", "raee"},
            {"flaconi", "plastica", "secco", "vetro/lattine", "raee"} ,
            {"polistirolo", "plastica", "secco", "vetro/lattine", "raee"}  ,
            {"pellicole per alimenti", "plastica", "secco", "vetro/lattine", "raee"} ,
            {"scatole di pelati", "vetro/lattine", "plastica", "secco", "raee"},
            {"bombolette", "vetro/lattine", "plastica", "secco", "rup"},
            {"contenitori di vetro", "vetro/lattine", "plastica", "secco", "raee"},
            {"gomma", "secco", "carta", "vetro/lattine", "organico"},
            {"gommapiuma", "secco", "carta", "vetro/lattine", "organico"},
            {"ossi", "secco", "carta", "vetro/lattine", "organico"},
            {"cocci di ceramica", "secco", "carta", "vetro/lattine", "organico"},
            {"mozziconi di sigaretta", "secco", "carta", "vetro/lattine", "organico"},
            {"lettiere per animali", "secco", "carta", "vetro/lattine", "organico"},
            {"stracci", "secco", "carta", "vetro/lattine", "organico"},
            {"appendiabiti", "secco", "carta", "vetro/lattine", "organico"},
            {"pannolini", "secco", "carta", "vetro/lattine", "organico"},
            {"assorbenti", "secco", "carta", "vetro/lattine", "organico"},
            {"garze", "secco", "carta", "vetro/lattine", "organico"},
            {"cerotti", "secco", "carta", "vetro/lattine", "organico"},
            {"piatti", "secco", "carta", "vetro/lattine", "organico"},
            {"carta sporca", "secco", "carta", "vetro/lattine", "organico"},
            {"TV", "raee", "secco", "plastica", "vetro/lattine"},
            {"PC", "raee", "secco", "plastica", "vetro/lattine"},
            {"scanner", "raee", "secco", "plastica", "vetro/lattine"},
            {"schermi", "raee", "secco", "plastica", "vetro/lattine"},
            {"stampanti", "raee", "secco", "plastica", "vetro/lattine"},
            {"fax", "raee", "secco", "plastica", "vetro/lattine"},
            {"fotocopiatrici", "raee", "secco", "plastica", "vetro/lattine"},
            {"frigoriferi", "raee", "secco", "plastica", "vetro/lattine"},
            {"scope elettriche", "raee", "secco", "plastica", "vetro/lattine"},
            {"tostapane", "raee", "secco", "plastica", "vetro/lattine"},
            {"calcolatrici", "raee", "secco", "plastica", "vetro/lattine"},
            {"telefoni", "raee", "secco", "plastica", "vetro/lattine"},
            {"radio", "raee", "secco", "plastica", "vetro/lattine"},
            {"vernici", "rup", "secco", "plastica", "raee"},
            {"collanti", "rup", "secco", "plastica", "raee"},
            {"solventi", "rup", "secco", "plastica", "raee"},
            {"coloranti", "rup", "secco", "plastica", "raee"},
            {"pesticidi", "rup", "secco", "plastica", "raee"},
            {"termometri", "rup", "secco", "plastica", "raee"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {
            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);  // Country
            tmpArray.add(quizData[i][1]);  // Right Answer
            tmpArray.add(quizData[i][2]);  // Choice1
            tmpArray.add(quizData[i][3]);  // Choice2
            tmpArray.add(quizData[i][4]);  // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();

    }

    public void showNextQuiz() {

        // Update quizCountLabel.
        countLabel.setText("DOMANDA nr° " + quizCount);

        // Generate random number between 0 and 14 (quizArray's size - 1).
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format: {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Country" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set Choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            // Correct!
            alertTitle = "Risposta Esatta!";
            rightAnswerCount++;
        } else {
            // Wrong...
            alertTitle = "Hai Sbagliato..Mi Dispiace..";
        }

        // Create Dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Risposta Corretta : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    // Show Result.
                    Intent intent = new Intent(getApplicationContext(), Result.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}