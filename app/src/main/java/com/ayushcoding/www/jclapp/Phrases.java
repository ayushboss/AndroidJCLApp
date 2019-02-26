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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        ListView listView = (ListView) findViewById(R.id.listViewPhrases);
        Activity activity = Phrases.this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        String[] phTitle = {"ad ovo usque ad mala","ad hoc","ad infinitum","ad nauseam","alma mater","ante bellum","bona fide","caveat emptor","de gustibus non est disputandum","corpus delicti","cum grano salis","de facto","de jure","de mortuis nil nisi bonum","divide et impera","ex libris","errare humanum est","et tu, Brute!","exit;exeunt","ex officio","ex post facto","ex tempore","festina lente","habeas corpus","in absentia","in loco parentis","in medias res","in memoriam","in re","in toto","ipso facto","lapsus linguae","modus operandi","modus vivendi","multum in parvo","ne plus ultra","non compos mentis","non sequitur","pater patriae","pax vobiscum","per annum","per capita","per diem","per se","persona non grata","post mortem","prima faciae","post proelium, praemium","pro and con(tra)","pro bono public","pro tempore","quid pro quo","sic transit gloria mundi","sine die","sine qua non","status quo","stet","te Deum laudamus","tempus fugit","terra firma","vade mecum","verbatim","via","vice versa","vigilantia pretium libertatis","viva voce","voc populi,vox Dei"};
        String[] phSub = {"from the egg to the apple (like “from soup to nuts”)","for this purpose","without end","to the point of disgust","nourishing mother= for any school/college","before the war","in good faith","let the buyer beware"," there is no accounting for tastes; everyone to his own taste","the body of the crime","with a grain of salt","in fact,actually","by right; legally","speak only good of the dead","divide and rule","from the books of","to err is human","even you, Brutus!","he goes out/they go out","by virtue of office","enacted after the fact;retroactive","on the spur of the moment","make haste slowly"," a writ to bring a detained person before a judge (lit. you must have the body)","in absence","in the place of a parent","in the middle of things","in memory of","in the matter of/concerning","entirely","by the very fact itself","a slip of the tounge","a method of working","a method of living","much in little","nothing more beyond;perfection","not of sound mind","it does not follow","father of his country","peace be with you","by the year","by heads","by the day","by itself","an unwelcome person","after death","on first sight","after the battle; the reward","for and against","for the public welfare","for the time being","something for something","thus passes the glory of the world","indefinitely; without setting a day","indispensable;a necessity","the existing state of affairs","let it stand","we praise you, O Lord","time flies","solid ground","a constant companion (go with me)","word for word","by way of","the other way around","vigilance is the price of liberty","by spoken word; orally","the voice of the people is the voice of God"};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = phTitle.length;
        for(int i = 0; i < z; i++) {
            values.put(phTitle[i], phSub[i]);
        }
        System.out.println(values);
        LayoutInflater layoutInflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) layoutInflater.inflate(R.layout.phrases_header, listView, false);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.addHeaderView(header, null, false);
        listView.setAdapter(doubleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_phrases, menu);
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
