package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class Certamen extends Activity {
    List<Questions> quesListCertamen;
    int score=0;
    int qid=0;
    Questions currentQ1;
    TextView txtQuestion1;
    TextView result;
    RadioButton rdac, rdbc, rdcc, rddc;
    Button butNext, showAnswer, p1, p2;
    private Vibrator z;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certamen);
        CertamenDB db=new CertamenDB(this);
        quesListCertamen=db.getAllQuestions();
        currentQ1=quesListCertamen.get(qid);
        txtQuestion1=(TextView)findViewById(R.id.questionCer);
        result = (TextView) findViewById(R.id.certamenTimer);
        butNext=(Button)findViewById(R.id.nxtQuest);
        final Button show = (Button) findViewById(R.id.showAnswer);
        p1 = (Button) findViewById(R.id.p1);
        p2 = (Button) findViewById(R.id.p2);
        z = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        setQuestionView();

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2.setEnabled(false);
                result.setVisibility(View.VISIBLE);
                result.setTextColor(Color.RED);
                result.setText("Player 1");
                p1.setBackgroundColor(Color.parseColor("#25D366"));
                z.vibrate(1500);
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setEnabled(false);
                result.setVisibility(View.VISIBLE);
                result.setText("Player 2");
                result.setTextColor(Color.RED);
                p2.setBackgroundColor(Color.parseColor("#25D366"));
                z.vibrate(1500);
            }
        });

//        } else {
//            setQuestionView();
//            p1.setEnabled(b);
//            p2.setEnabled(b);
//        }
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setVisibility(View.GONE);
                butNext.setVisibility(View.VISIBLE);
                result.setText(currentQ1.getANSWER());
            }
        });
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setEnabled(true);
                p2.setEnabled(true);
                System.out.println("TEsting2");
                show.setVisibility(View.VISIBLE);
                result.setVisibility(View.INVISIBLE);
                butNext.setVisibility(View.GONE);

                p1.setBackgroundColor(Color.parseColor("#4caf50"));
                p2.setBackgroundColor(Color.parseColor("#4caf50"));
                result.setTextColor(Color.BLACK);

                if(qid<10){
                    result.setText(currentQ1.getANSWER());
                    currentQ1=quesListCertamen.get(qid);
                    setQuestionView();


                }else{
                    System.out.println("" + score);

                    Intent intent = new Intent(Certamen.this, RomanHistoryResult.class);

                    Bundle b = new Bundle();

                    b.putInt("score", score); //Your score

                    intent.putExtras(b); //Put your score to your next Intent

                    startActivity(intent);

                    finish();
                }
            }
        });
    }

    private void setQuestionView() {
        txtQuestion1.setText(currentQ1.getQUESTION());
        qid++;

    }
}
