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

public class NamesAndClothing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names_and_clothing);
        ListView listView = (ListView) findViewById(R.id.names);
        String[] conj1 = {"praenomen","nomen","cognomen","agnomen","subligaculum","tunica","toga praetexta","toga virilis","toga pura","toga libera","toga candida","toga pulla","stola","palla","fibula","bulla","calceus","solea","petasus","pileus"};
        String[] cong1Sub = {"first name","family name","name for branch of family","earned name","underwear","worn by all","worn by boys under 16 and magistrates (with purple stripe)","all white worn by men over 16","same as toga virilis","same as toga virilis (boys gave up toga praetexta on Libertalia)","worn by men running for office; bright white due to chalk","worn by men in mourning also known as 'sordidati'","women's dress","women's shawl","broach,pin","child's good luck charm","shoe (for outside)","sandals for inside","broad-brimmed hat","cap of freedom"};
        HashMap<String, String> values = new HashMap<String, String>();

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarNC);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        int z = conj1.length;
        for(int i = 0; i < z; i++) {
            values.put(conj1[i], cong1Sub[i]);
        }
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        System.out.println(values);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.setAdapter(doubleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_names_and_clothing, menu);
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
