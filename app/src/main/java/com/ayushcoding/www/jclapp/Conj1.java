package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Conj1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conj1);
        Button chart = (Button) findViewById(R.id.conj1Chart);
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.Charts");
                intent.putExtra("Conjugation", "conj1");
                startActivity(intent);
            }
        });
    }
}
