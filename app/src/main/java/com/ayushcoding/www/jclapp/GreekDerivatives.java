package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GreekDerivatives extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greek_derivatives);
        String check = checkTest(this);
        ListView lv = (ListView) findViewById(R.id.lvGD);

        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarGDer);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        String[] checkSplit = check.split(":");
        HashMap<String, String> hm = new HashMap<String, String>();
        for (int i = 0; i < checkSplit.length; i += 2) {
            hm.put(checkSplit[i], checkSplit[i+1]);
            System.out.print(hm);
        }
        DoubleAdapterGreekDerivs db = new DoubleAdapterGreekDerivs(hm);
        lv.setAdapter(db);
    }
    public static String checkTest(Context context) {
        StringBuilder out = null;
        try {
            InputStream is = context.getAssets().open("greekDerivFormat.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);   // add everything to StringBuilder
                // here you can have your logic of comparison.
                if(line.toString().equals(".")) {
                    // do something
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
