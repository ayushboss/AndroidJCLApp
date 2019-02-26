package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Grammar1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar1);
        Button g1 = (Button) findViewById(R.id.buttonGrammarS);
        Button g2 = (Button) findViewById(R.id.button2GrammarS);
        Button g3 = (Button) findViewById(R.id.button3GrammarS);
        Button g4 = (Button) findViewById(R.id.button4GrammarS);
        Button g5 = (Button) findViewById(R.id.button5GrammarS);
        Button g6 = (Button) findViewById(R.id.button6GrammarS);

        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.Tenses");
                startActivity(intent);
            }
        });
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.Conj1");
                startActivity(intent);
            }
        });
        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.Conj2");
                startActivity(intent);
            }
        });
        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.Conj3");
                startActivity(intent);
            }
        });
        g5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.Conj3io");
                startActivity(intent);
            }
        });
        g6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.Conj4");
                startActivity(intent);
            }
        });

    }
}
