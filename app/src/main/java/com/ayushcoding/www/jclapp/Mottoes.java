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

public class Mottoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mottoes);
        ListView listView = (ListView) findViewById(R.id.listViewMottoes);
        Activity activity = Mottoes.this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        String[] moTitle = {"ars artis gratia","cave canem","e pluribus unum","Annuit Coeptis","Novus Ordo Seclorum","semper fidelis","semper paratus","veni,vidi,vici","errare humanum est","carpe diem","ars longa, vita brevis","et tu, Brute!","festina lente","in hoc signo vinces","mens sana in corpore sano","A mari usque ad mare","citius,altius,fortius","alea iacta est","Audentis Fortuna iuvat","Rident stolidi verba Latina","Nec verbum verbo curabis reddere fidus interpres","Difficile est tenere quae acceperis nisi exerceas."};
        String[] moSub = {"Metro- Goldwyn - Mayer logo","beware of dog found on a mosaic in Pompeii","from many, one (one out of many) -- U.S. -- found on all coins","he (God) looks with favor on our undertakings --found on $1 bill","A new order of the ages -- found on $1 bill","always faithful --U.S. Marine Corps","always prepared -- U.S. Coast Guard","I came, I saw, I conquered -- Julius Caesar","to err is human -- Seneca","seize the day -- Horace","- art is long, life is short -- Horace","even you, Brutus -- Julius Caesar","- make haste slowly -- Augustus","by this sign you will conquer -- Constantine saw this in the sky before the battle of the Milvian Bridge","a sound mind in a sound body -- Juvenal","from sea to sea -- National motto of Canada","swifter, higher, stronger -- motto of modern Olympics","the die is cast – Caesar, as he was about to cross the Rubicon","Fortune favors the brave. Virgil","Fools laugh at the Latin language.----Ovid","As a true translator you will take care not to translate word for word.----Horace","It is difficult to retain what you may have learned unless you should practice it.----Pliny the Younger"};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = moTitle.length;
        for(int i = 0; i < z; i++) {
            values.put(moTitle[i], moSub[i]);
        }
        System.out.println(values);
        LayoutInflater layoutInflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) layoutInflater.inflate(R.layout.mottoes_header, listView, false);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.addHeaderView(header, null, false);
        listView.setAdapter(doubleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mottoes, menu);
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
