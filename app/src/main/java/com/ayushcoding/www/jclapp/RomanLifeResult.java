package com.ayushcoding.www.jclapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RomanLifeResult extends AppCompatActivity {
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roman_life_result);
        score = (TextView) findViewById(R.id.scoreRL);
        Bundle b = getIntent().getExtras();
        final int scoreRHTHING= b.getInt("scoreRl");
        Context context = this;

        score.setText(""+ scoreRHTHING+ "");
        final ScoresDB scoresDB = new ScoresDB(RomanLifeResult.this);
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
//                        ScoresDB scoresDB = new ScoresDB(GrammarFinished.this);
                        scoresDB.addScore("romanL", scoreRHTHING, 10);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
//                        scoresDB = new ScoresDB(GrammarFinished.this);
                        scoresDB.ScoreUpdate("romanL", scoreRHTHING);
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Is this the first time you have completed this quiz?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
//        SaveIntRL();
//        ScoresDB scoresDB = new ScoresDB(GrammarFinished.this);
//       scoresDB.checkEvent("grammar", scoreGrammar);
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
