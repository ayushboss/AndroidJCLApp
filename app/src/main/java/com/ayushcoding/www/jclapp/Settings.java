package com.ayushcoding.www.jclapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button red = (Button) findViewById(R.id.button5);
        final TextView te = (TextView) findViewById(R.id.button11);
        CharSequence meme = selectTheme();

    }
//    public CharSequence colorToMainActivity() {
//        CharSequence meme = selectTheme();
//        return meme;
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }
    public CharSequence selectTheme() {
        Button red = (Button) findViewById(R.id.button5);
        final TextView te = (TextView) findViewById(R.id.button11);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                te.setText("red");
            }
        });
        System.out.println("RED : " + te.getText());
        CharSequence color = te.getText();
        return color;
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
