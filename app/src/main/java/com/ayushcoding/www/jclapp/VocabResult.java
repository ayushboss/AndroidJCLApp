package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class VocabResult extends Activity {
    SharedPreferences prefs;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_result);
        score = (TextView) findViewById(R.id.scoreVocabThingPleaseWoek);
        Bundle b = getIntent().getExtras();
        final int scoreRHTHING = b.getInt("scoreVocab");
        ScoresDB scoresDB = new ScoresDB(this);
        try {
            checkIfFirstMainActivity(scoresDB, scoreRHTHING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Context context = this;
System.out.println(scoreRHTHING);
//        score.setText(scoreRHTHING);
    }

    public void checkIfFirstMainActivity(ScoresDB scoresDB, int scoreRHTHING) throws InterruptedException {
        prefs = getSharedPreferences("com.ayushcoding.www.jclapp", MODE_PRIVATE);
        if (prefs.getBoolean("firstrunResultVocab", true)) {
            scoresDB.addScore("vocabScore", scoreRHTHING, 10);
            prefs.edit().putBoolean("firstrunResultVocab", false).apply();
        } else {
            scoresDB.ScoreUpdate("vocabScore", scoreRHTHING);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_roman_history_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    }

