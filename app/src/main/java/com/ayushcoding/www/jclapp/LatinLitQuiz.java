package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

import java.util.List;
import java.util.Random;

public class LatinLitQuiz extends AppCompatActivity {
    List<Questions> quesList;
    int score=0;
    int qid=0;
    boolean buttonPushed = false;
    Questions currentQ;
    TextView txtQuestion;
    Button opt1, opt2, opt3, opt4;
    Button butNext;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latin_lit_quiz);
        final Intent intent = getIntent();
        String subway;
        if (intent.getStringExtra("subject") == "vocab") {
            subway = "vocab";
        } else {
            subway = "lit";
        }
            LatinLitQuizDB db = new LatinLitQuizDB(this, subway);

        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        mToolbar = (Toolbar) findViewById(R.id.toolbarRHQ);
        setSupportActionBar(mToolbar);
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle("Latin Literature Quiz");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txtQuestion = (TextView) findViewById(R.id.questionLL);
        opt1 = (Button) findViewById(R.id.Ll1);
        opt2 = (Button) findViewById(R.id.Ll2);
        opt3 = (Button) findViewById(R.id.Ll3);
        opt4 = (Button) findViewById(R.id.Ll4);
        setQuestionView();
        final ImageView pin = (ImageView) findViewById(R.id.pinQuestionLit);

        pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttonPushed){

                    pin.setImageResource(R.drawable.ic_action_star_filled);
                    Snackbar snackbarPin = Snackbar
                            .make(v, "Question starred.", Snackbar.LENGTH_SHORT);
                    snackbarPin.show();
                    buttonPushed = true;
                }
                else if (buttonPushed){

                    pin.setImageResource(R.drawable.ic_action_star);
                    Snackbar snackbarPin = Snackbar
                            .make(v, "Question unstarred.", Snackbar.LENGTH_SHORT);
                    snackbarPin.show();
                    buttonPushed = false;

                }
                NotecardDB notecard = new NotecardDB(LatinLitQuiz.this);
                if (intent.getStringExtra("subject") == "vocab") {
                    notecard.addQuestion(currentQ.getQUESTION(), currentQ.getANSWER(), "vocab");
                } else {
                    notecard.addQuestion(currentQ.getQUESTION(), currentQ.getANSWER(), "lit");
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
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                else {
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

                    Intent intent = new Intent(LatinLitQuiz.this, LatinLitResult.class);

                    Bundle b = new Bundle();

                    b.putInt("scoreRl", score); //Your score

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
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                else {
                    Snackbar snackbar = Snackbar
                            .make(v, "You are incorrect.", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                if(qid<10){

                    currentQ=quesList.get(qid);

                    setQuestionView();
                }else{
                    System.out.println("" + score);

                    Intent intent = new Intent(LatinLitQuiz.this, LatinLitResult.class);

                    Bundle b = new Bundle();

                    b.putInt("scoreRl", score); //Your score

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
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                else {
                    Snackbar snackbar = Snackbar
                            .make(v, "You are incorrect.", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                if(qid<10){

                    currentQ=quesList.get(qid);

                    setQuestionView();
                }else{
                    System.out.println("" + score);

                    Intent intent = new Intent(LatinLitQuiz.this, LatinLitResult.class);

                    Bundle b = new Bundle();

                    b.putInt("scoreRl", score); //Your score

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
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                else {
                    Snackbar snackbar = Snackbar
                            .make(v, "You are incorrect.", Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#f44336"));
                    snackbar.show();
                }
                if(qid<10){

                    currentQ=quesList.get(qid);

                    setQuestionView();
                }else{
                    System.out.println("" + score);

                    Intent intent = new Intent(LatinLitQuiz.this, LatinLitResult.class);

                    Bundle b = new Bundle();

                    b.putInt("scoreRl", score); //Your score

                    intent.putExtras(b); //Put your score to your next Intent

                    startActivity(intent);

                    finish();
                }
            }
        });
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
}
