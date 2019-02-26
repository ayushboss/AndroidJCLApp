package com.ayushcoding.www.jclapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Objects;

public class Notecards extends AppCompatActivity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notecards);
        final Context context = getApplication();
        final NotecardDB notecardDB = new NotecardDB(context);
        System.out.println("BREAK");
        String[] memes = notecardDB.selectQuestions(1);
        String memer = memes[0];
        int dbLength = notecardDB.getProfilesCount();
        System.out.println("DB LENGTH : " + dbLength);
        for (int p = 0; p < dbLength; p++) {
            System.out.println("Question " + notecardDB.selectQuestions(p)[0]);
            System.out.println("Answer " + notecardDB.selectQuestions(p)[1]);
        }

        for (int i = 0; i < dbLength - 1; i++) {
            if (notecardDB.selectQuestions(i)[0] == null) {

            } else {
                CardView card = new CardView(Notecards.this);

                // Set the CardView layoutParams
                RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params1.addRule(RelativeLayout.BELOW, i - 1);
                params1.setMargins(0, 20, 0, 0);
                card.setLayoutParams(params1);

                // Set CardView corner radius

                // Set cardView content padding
                card.setContentPadding(15, 15, 15, 15);
                card.setId(i);
                // Set a background color for CardView
                final String subject = notecardDB.selectQuestions(i)[2];
                System.out.println(subject);
                System.out.println(subject + "memez");


                if (Objects.equals(subject, "myth")){
                    card.setCardBackgroundColor(Color.parseColor("#00BCD4"));

                } else if(Objects.equals(subject, "rl")) {
                    card.setCardBackgroundColor(Color.parseColor("#ff5722"));

                } else if(Objects.equals(subject, "rh")) {
                    card.setCardBackgroundColor(Color.parseColor("#2ecc71"));

                } else if (Objects.equals(subject, "gram")) {
                    card.setCardBackgroundColor(Color.parseColor("#673Ab7"));

                } else if(Objects.equals(subject, "lit")) {
                    card.setCardBackgroundColor(Color.parseColor("#3f51b5"));
                }


                // Set the CardView maximum elevation
                card.setMaxCardElevation(15);

                // Set CardView elevation
                card.setCardElevation(9);

                TextView tv = new TextView(Notecards.this);
                tv.setLayoutParams(params);
                String[] selectedQuestion = notecardDB.selectQuestions(i);
                String question = notecardDB.selectQuestions(i)[0];

                String answer = selectedQuestion[1];
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                tv.setTextColor(Color.BLACK);
                tv.setText(question);
                tv.setTextColor(Color.WHITE);
                // Put the TextView in CardView
                card.addView(tv);
                RelativeLayout mRelativeLayout = (RelativeLayout) findViewById(R.id.notecardrele);
                // Finally, add the CardView in root layout
                final int z = i;
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NotecardDB notecardDB1 = new NotecardDB(context);
                        String[] selectedQuestion = notecardDB1.selectQuestions(z);
                        String question = selectedQuestion[0];
                        String answer = selectedQuestion[1];
                        Intent intent = new Intent("com.ayushcoding.www.jclapp.NotecardView");
                        intent.putExtra("question", question);
                        intent.putExtra("answer", answer);
                        intent.putExtra("subject",  subject);
                        startActivity(intent);

                    }
                });
                mRelativeLayout.addView(card);
            }
        }
        if (dbLength - 1 <= 0) {
            TextView tv = new TextView(Notecards.this);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            tv.setTextColor(Color.BLACK);
            tv.setText("No questions have been starred.");
            RelativeLayout rel = (RelativeLayout) findViewById(R.id.notecardrele);
            rel.addView(tv);
        }
    }

}