package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.HashMap;

public class Government extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government);
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarGov);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        ListView listView = (ListView) findViewById(R.id.govern);
        String[] conj1 = {"cursus honorum","consul","praetor","quaestor","aedile","censor","dictator","magister equitum","senator","tribune","patricians/optimates","equites","plebians/populares","patorn","cliens","salutatio","sportula","deductio","paterfamilias","patria potestas"};
        String[] cong1Sub = {"course of honors – steps you take to make it to the highest jobs (from bottom to top – quaestor, praetor, consul)","two men – executives – elected yearly",
                "judges (8 elected yearly)",
                "treasurers (20 elected yearly)",
                "in charge of roads and public games (4 elected yearly)",
                "2 elected every five years for 18 months – in charge of taking the census and public morals",
                "had absolute power in times of emergency; normally ruled 6 months maximum",
                "master of the horse/cavalry – assistant to dictator",
                "must be a praetor to enter – for life",
                "10 elected yearly – only plebeians can run – can veto the senate",
                "highest class",
                "business class",
                "lower class",
                "patron",
                "client",
                "visit of client to patron’s house",
                "cold food basket given to client when he is received by patron in his atrium",
                " patron leads clients to forum",
                "head of family (family includes wife, children, slaves and property)",
                "power (of life and death in early times) of paterfamilias over family"};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = conj1.length;
        for(int i = 0; i < z; i++) {
            values.put(conj1[i], cong1Sub[i]);
        }
        System.out.println(values);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.setAdapter(doubleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_government, menu);
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
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item= menu.findItem(R.id.action_settings);
        item.setVisible(false);
        super.onPrepareOptionsMenu(menu);
        return true;
    }
}
