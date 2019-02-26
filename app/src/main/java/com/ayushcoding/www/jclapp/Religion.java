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

public class Religion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religion);
        ListView listView = (ListView) findViewById(R.id.religions);
        String[] conj1 = {"Pontifex Maximus","Vestal Virgins","auspex","augur","haruspex","Salii","Lares","Lararium","Penates"};
        String[] cong1Sub = {"Chief priest, elected for life","start at age 6 – (30 years) learn job for 10 years, work as Vestal for 10 years,teach for 10 years keep flame of Vesta burning, keep documents, etc. safe; only man allowed in temple (which is round) is Pontifex Maximus","priest who checks sky for omens (birds/lightning)","similar to an auspex","checks guts of animals for omens (2 hearts are bad…)","priests of Mars","household gods","shrine for Lares","gods of cupboards"};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = conj1.length;
        for(int i = 0; i < z; i++) {
            values.put(conj1[i], cong1Sub[i]);
        }

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarRELI);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        System.out.println(values);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.setAdapter(doubleAdapter);
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_religion, menu);
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
