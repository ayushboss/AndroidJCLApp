package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Objects;

public class Charts extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);
        Intent intent = getIntent();
        String conj = intent.getStringExtra("Conjugation");
        System.out.println(conj);
        ImageView im = (ImageView) findViewById(R.id.imageView2);
        if (Objects.equals(conj, "conj1")) {

        } else if(Objects.equals(conj, "conj2")) {
            Drawable myDrawable = getResources().getDrawable(R.drawable.conj2);
            im.setImageDrawable(myDrawable);
        } else if(Objects.equals(conj, "conj3")) {
            Drawable myDrawable = getResources().getDrawable(R.drawable.conj3);
            im.setImageDrawable(myDrawable);
        } else if(Objects.equals(conj, "conj3io")) {
            Drawable myDrawable = getResources().getDrawable(R.drawable.conj3io);
            im.setImageDrawable(myDrawable);
        } else if(Objects.equals(conj, "conj4")) {
            Drawable myDrawable = getResources().getDrawable(R.drawable.conj4);
            im.setImageDrawable(myDrawable);
        }
    }
}
