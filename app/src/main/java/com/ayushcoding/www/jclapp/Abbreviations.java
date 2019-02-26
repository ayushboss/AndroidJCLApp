package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.HashMap;

public class Abbreviations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abbreviations);
        ListView listView = (ListView) findViewById(R.id.listViewAbbs);
        Activity activity = Abbreviations.this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        String[] abbTitle = {"ab urbe condita/ anno urbis conditae – A.U.C","anno domini - A.D","ad libitum -- ad lib.","ante meridiem -- A.M","confer -- cf","exempli gratia -- e.g.","et alia -- et al.","et cetera -- etc.","ibidem – ibid.","idem – id.","id est -- i.e.","Medicinae Doctor -- M.D."," meridie – m.","nota bene -- N.B.","opere citato – op. cit.","per centum -- per cent","post meridiem -- P.M.","pro tempore -- pro tem.","post scriptum -- P.S.","Quod erat demonstrandum – Q.E. D.","quod vide -- q.v."," recipe -- Rx","videlicet -- viz.","versus -- vs."};
        String[] abbSub = {"from the founding of the city","in the year of our Lord","at pleasure","before noon","compare","for example","and others","and so forth, and the rest","in the same place","the same (author)","that is (an explanation)","medical doctor, doctor of medicine","at midday, noon","note well (pay attention to this)","in the work cited/mentioned","by the hundred","afternoon","for the time being","written afterwards","that which must be demonstrated","which see","take as prescribed (medical term)","namely","against"};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = abbTitle.length;
        for(int i = 0; i < z; i++) {
            values.put(abbTitle[i], abbSub[i]);
        }
        System.out.println(values);
        LayoutInflater layoutInflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) layoutInflater.inflate(R.layout.abbreviations_header, listView, false);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.addHeaderView(header, null, false);
        listView.setAdapter(doubleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_abbreviations, menu);
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
}
