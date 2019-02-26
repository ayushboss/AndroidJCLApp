package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.HashMap;


public class PhrasesFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_phrases, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listViewPhrases);

        String[] phTitle = {"ad ovo usque ad mala","ad hoc","ad infinitum","ad nauseam","alma mater","ante bellum","bona fide","caveat emptor","de gustibus non est disputandum","corpus delicti","cum grano salis","de facto","de jure","de mortuis nil nisi bonum","divide et impera","ex libris","errare humanum est","et tu, Brute!","exit;exeunt","ex officio","ex post facto","ex tempore","festina lente","habeas corpus","in absentia","in loco parentis","in medias res","in memoriam","in re","in toto","ipso facto","lapsus linguae","modus operandi","modus vivendi","multum in parvo","ne plus ultra","non compos mentis","non sequitur","pater patriae","pax vobiscum","per annum","per capita","per diem","per se","persona non grata","post mortem","prima faciae","post proelium, praemium","pro and con(tra)","pro bono public","pro tempore","quid pro quo","sic transit gloria mundi","sine die","sine qua non","status quo","stet","te Deum laudamus","tempus fugit","terra firma","vade mecum","verbatim","via","vice versa","vigilantia pretium libertatis","viva voce","voc populi,vox Dei"};
        String[] phSub = {"from the egg to the apple (like “from soup to nuts”)","for this purpose","without end","to the point of disgust","nourishing mother= for any school/college","before the war","in good faith","let the buyer beware"," there is no accounting for tastes; everyone to his own taste","the body of the crime","with a grain of salt","in fact,actually","by right; legally","speak only good of the dead","divide and rule","from the books of","to err is human","even you, Brutus!","he goes out/they go out","by virtue of office","enacted after the fact;retroactive","on the spur of the moment","make haste slowly"," a writ to bring a detained person before a judge (lit. you must have the body)","in absence","in the place of a parent","in the middle of things","in memory of","in the matter of/concerning","entirely","by the very fact itself","a slip of the tounge","a method of working","a method of living","much in little","nothing more beyond;perfection","not of sound mind","it does not follow","father of his country","peace be with you","by the year","by heads","by the day","by itself","an unwelcome person","after death","on first sight","after the battle; the reward","for and against","for the public welfare","for the time being","something for something","thus passes the glory of the world","indefinitely; without setting a day","indispensable;a necessity","the existing state of affairs","let it stand","we praise you, O Lord","time flies","solid ground","a constant companion (go with me)","word for word","by way of","the other way around","vigilance is the price of liberty","by spoken word; orally","the voice of the people is the voice of God"};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = phTitle.length;
        for(int i = 0; i < z; i++) {
            values.put(phTitle[i], phSub[i]);
        }
        System.out.println(values);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.setAdapter(doubleAdapter);
        return rootView;
    }
}
