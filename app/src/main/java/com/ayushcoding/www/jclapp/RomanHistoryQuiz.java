package com.ayushcoding.www.jclapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;
import java.util.Random;

public class RomanHistoryQuiz extends AppCompatActivity {
    List<Questions> quesList;
    int score = 0;
    int qid = 0;
    boolean buttonPushed = false;
    Questions currentQ;
    TextView txtQuestion;
    Button opt1, opt2, opt3, opt4;
    Button butNext;

    private Toolbar mToolbar;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_roman_history_quiz);
        RomanHistoryQuestionsDB db = new RomanHistoryQuestionsDB(this);
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.questionMyth);
        mToolbar = (Toolbar) findViewById(R.id.toolbarRHQ);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar();
        System.out.print("meme");
        opt1 = (Button) findViewById(R.id.button);
        opt2 = (Button) findViewById(R.id.button2);
        opt3 = (Button) findViewById(R.id.button3);
        opt4 = (Button) findViewById(R.id.button4);
        final ImageView pin = (ImageView) findViewById(R.id.pinQuestion);

        setQuestionView();
        pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotecardDB notecard = new NotecardDB(RomanHistoryQuiz.this);
                notecard.addQuestion(currentQ.getQUESTION(), currentQ.getANSWER(), "rh");
                if (!buttonPushed) {

                    pin.setImageResource(R.drawable.ic_action_star_filled);
                    Snackbar snackbarPin = Snackbar
                            .make(v, "Question starred.", Snackbar.LENGTH_SHORT);
                    snackbarPin.show();
                    buttonPushed = true;
                } else if (buttonPushed) {

                    pin.setImageResource(R.drawable.ic_action_star);
                    Snackbar snackbarPin = Snackbar
                            .make(v, "Question unstarred.", Snackbar.LENGTH_SHORT);
                    snackbarPin.show();
                    buttonPushed = false;

                }

            }
        });
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPushed = false;
                pin.setImageResource(R.drawable.ic_action_star);
                String answer = opt1.getText().toString();
                Log.d("yourans", currentQ.getANSWER() + " " + answer);
                if (currentQ.getANSWER().equals(answer)) {
                    score++;
                    Log.d("score", "Your score" + score);
                    Snackbar snackbar = Snackbar
                            .make(v, "You are correct!", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#4CAF50"));
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(v, "You are incorrect.", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                if (qid < 10) {

                    currentQ = quesList.get(qid);

                    setQuestionView();
                } else {
                    System.out.println("" + score);

                    Intent intent = new Intent(RomanHistoryQuiz.this, RomanHistoryResult.class);

                    Bundle b = new Bundle();

                    b.putInt("scoreRH", score); //Your score

                    intent.putExtras(b); //Put your score to your next Intent

                    startActivity(intent);

                    finish();
                }
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPushed = false;
                pin.setImageResource(R.drawable.ic_action_star);
                String answer = opt2.getText().toString();
                Log.d("yourans", currentQ.getANSWER() + " " + answer);
                if (currentQ.getANSWER().equals(answer)) {
                    score++;
                    Log.d("score", "Your score" + score);
                    Snackbar snackbar = Snackbar
                            .make(v, "You are correct!", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#4CAF50"));
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(v, "You are incorrect.", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                if (qid < 10) {

                    currentQ = quesList.get(qid);

                    setQuestionView();
                } else {
                    System.out.println("" + score);

                    Intent intent = new Intent(RomanHistoryQuiz.this, RomanHistoryResult.class);

                    Bundle b = new Bundle();

                    b.putInt("scoreRH", score); //Your score

                    intent.putExtras(b); //Put your score to your next Intent

                    startActivity(intent);

                    finish();
                }
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPushed = false;
                pin.setImageResource(R.drawable.ic_action_star);
                String answer = opt3.getText().toString();
                Log.d("yourans", currentQ.getANSWER() + " " + answer);
                if (currentQ.getANSWER().equals(answer)) {
                    score++;
                    Log.d("score", "Your score" + score);
                    Snackbar snackbar = Snackbar
                            .make(v, "You are correct!", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#4CAF50"));
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(v, "You are incorrect.", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                if (qid < 10) {

                    currentQ = quesList.get(qid);

                    setQuestionView();
                } else {
                    System.out.println("" + score);

                    Intent intent = new Intent(RomanHistoryQuiz.this, RomanHistoryResult.class);

                    Bundle b = new Bundle();

                    b.putInt("scoreRH", score); //Your score

                    intent.putExtras(b); //Put your score to your next Intent

                    startActivity(intent);

                    finish();
                }
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPushed = false;
                pin.setImageResource(R.drawable.ic_action_star);
                String answer = opt4.getText().toString();
                Log.d("yourans", currentQ.getANSWER() + " " + answer);
                if (currentQ.getANSWER().equals(answer)) {
                    score++;
                    Log.d("score", "Your score" + score);
                    Snackbar snackbar = Snackbar
                            .make(v, "You are correct!", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#4CAF50"));
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(v, "You are incorrect.", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                if (qid < 10) {

                    currentQ = quesList.get(qid);

                    setQuestionView();
                } else {
                    System.out.println("" + score);

                    Intent intent = new Intent(RomanHistoryQuiz.this, RomanHistoryResult.class);

                    Bundle b = new Bundle();

                    b.putInt("scoreRH", score); //Your score

                    intent.putExtras(b); //Put your score to your next Intent

                    startActivity(intent);

                    finish();
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_roman_history_quiz, menu);
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

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        Random random = new Random();
        int numberOfMethods = 4;

        switch (random.nextInt(numberOfMethods)) {
            case 0:
                opt1.setText(currentQ.getOPTA());
                opt2.setText(currentQ.getOPTB());
                opt3.setText(currentQ.getANSWER());
                opt4.setText(currentQ.getOPTC());
                break;
            case 1:
                opt1.setText(currentQ.getOPTA());
                opt2.setText(currentQ.getANSWER());
                opt3.setText(currentQ.getOPTB());
                opt4.setText(currentQ.getOPTC());
                break;
            case 2:
                opt1.setText(currentQ.getANSWER());
                opt2.setText(currentQ.getOPTA());
                opt3.setText(currentQ.getOPTB());
                opt4.setText(currentQ.getOPTC());
                break;
            case 3:
                opt1.setText(currentQ.getOPTA());
                opt2.setText(currentQ.getOPTB());
                opt3.setText(currentQ.getOPTC());
                opt4.setText(currentQ.getANSWER());
                break;
        }
//        opt1.setText(currentQ.getOPTA());
//        opt2.setText(currentQ.getOPTB());
//        opt3.setText(currentQ.getANSWER());
//        opt4.setText(currentQ.getOPTC());
        qid++;

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "RomanHistoryQuiz Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ayushcoding.www.jclapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "RomanHistoryQuiz Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ayushcoding.www.jclapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
