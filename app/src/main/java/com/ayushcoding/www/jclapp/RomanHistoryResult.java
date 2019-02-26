package com.ayushcoding.www.jclapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RomanHistoryResult extends AppCompatActivity {
SharedPreferences prefs;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roman_history_result);
        score = (TextView) findViewById(R.id.scoreRH);
        Bundle b = getIntent().getExtras();
        final int scoreRHTHING = b.getInt("scoreRH");
        ScoresDB scoresDB = new ScoresDB(this);
        try {
            checkIfFirstMainActivity(scoresDB, scoreRHTHING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Context context = this;

        score.setText("" + scoreRHTHING + "");
    }

    public void checkIfFirstMainActivity(ScoresDB scoresDB, int scoreRHTHING) throws InterruptedException {
        prefs = getSharedPreferences("com.ayushcoding.www.jclapp", MODE_PRIVATE);
        if (prefs.getBoolean("firstrunResult", true)) {
            scoresDB.addScore("romanH", scoreRHTHING, 10);
            prefs.edit().putBoolean("firstrunResult", false).apply();
        } else {
            scoresDB.ScoreUpdate("romanH", scoreRHTHING);
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
