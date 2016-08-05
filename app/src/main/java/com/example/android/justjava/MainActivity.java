package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.justjava.R;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0 ;
    int scoreB = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // PASTE CODE YOU WANT TO TEST HERE

    }



    /**
     * Display methods that allow the text to appear on the screen. Don't worry if you don't know
     * how these work yet. We'll be covering them in lesson 3.
     */

    public void displayForTeamB(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score) ;
        scoreView.setText(String.valueOf(score));
    }

    public void clickOn3b(View v){
        scoreB = scoreB + 3 ;
        displayForTeamB(scoreB);
    }


    public void clickOn2b(View v){
        scoreB = scoreB + 2 ;
        displayForTeamB(scoreB);
    }

    public void clickOnFreeThrowb(View v){
        scoreB = scoreB + 1 ;
        displayForTeamB(scoreB );
    }

    public void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score) ;
        scoreView.setText(String.valueOf(score));
    }

    public void clickOn3(View v){
        scoreA = scoreA + 3 ;
        displayForTeamA(scoreA);
    }


    public void clickOn2(View v){
        scoreA = scoreA + 2 ;
        displayForTeamA(scoreA);
    }

    public void clickOnFreeThrow(View v){
        scoreA = scoreA + 1 ;
        displayForTeamA(scoreA );
    }

    public void resetAll(View view) {
        scoreA = 0 ;
        scoreB = 0 ;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}