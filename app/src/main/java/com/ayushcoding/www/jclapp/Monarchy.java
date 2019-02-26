package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.lang.reflect.Field;

public class Monarchy extends AppCompatActivity {
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monarchy);
        sp = (Spinner) findViewById(R.id.spinnerMonarchy);
        String[] s = new String[]{"Romulus", "Numa Pompillius", "Tullus Hostillius", "Ancus Marcius", "Tarquinus Priscus", "Servius Tullius", "Tarquinius Superbus"};
        ArrayAdapter<String> d = new ArrayAdapter<String>(this, R.layout.spinner_item, s);
        d.setDropDownViewResource(R.layout.spinner_dropdown_snacks);
        sp.setAdapter(d);
        System.out.println("LENGTH : " + s.length);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarM);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        mToolbar.setTitle("");
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        sp.setOnItemSelectedListener(new CustomOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("POS : " + position);
                WebView wv = (WebView) findViewById(R.id.webViewMon);
                System.out.println("POSITION : " + position);

                switch (position) {
                    case 0:
                        wv.loadUrl("file:///android_asset/romulus.html");
                        break;
                    case 1:
                        wv.loadUrl("file:///android_asset/numa.html");
                        break;
                    case 2:
                        wv.loadUrl("file:///android_asset/host.html");
                        break;
                    case 3:
                        wv.loadUrl("file:///android_asset/ancus.html");
                        break;
                    case 4:
                        wv.loadUrl("file:///android_asset/pris.html");
                        break;
                    case 5:
                        wv.loadUrl("file:///android_asset/serv.html");
                        break;
                    case 6:
                        wv.loadUrl("file:///android_asset/luc.html");
                        break;

                }
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
