package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Context;
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


public class MottoesFrag extends Fragment {
            @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment_mottoes, container, false);

                ListView listView = (ListView) rootView.findViewById(R.id.listViewMottoes);

                String[] moTitle = {"ars artis gratia","cave canem","e pluribus unum","Annuit Coeptis","Novus Ordo Seclorum","semper fidelis","semper paratus","veni,vidi,vici","errare humanum est","carpe diem","ars longa, vita brevis","et tu, Brute!","festina lente","in hoc signo vinces","mens sana in corpore sano","A mari usque ad mare","citius,altius,fortius","alea iacta est","Audentis Fortuna iuvat","Rident stolidi verba Latina","Nec verbum verbo curabis reddere fidus interpres","Difficile est tenere quae acceperis nisi exerceas."};
                String[] moSub = {"Metro- Goldwyn - Mayer logo","beware of dog found on a mosaic in Pompeii","from many, one (one out of many) -- U.S. -- found on all coins","he (God) looks with favor on our undertakings --found on $1 bill","A new order of the ages -- found on $1 bill","always faithful --U.S. Marine Corps","always prepared -- U.S. Coast Guard","I came, I saw, I conquered -- Julius Caesar","to err is human -- Seneca","seize the day -- Horace","- art is long, life is short -- Horace","even you, Brutus -- Julius Caesar","- make haste slowly -- Augustus","by this sign you will conquer -- Constantine saw this in the sky before the battle of the Milvian Bridge","a sound mind in a sound body -- Juvenal","from sea to sea -- National motto of Canada","swifter, higher, stronger -- motto of modern Olympics","the die is cast – Caesar, as he was about to cross the Rubicon","Fortune favors the brave. Virgil","Fools laugh at the Latin language.----Ovid","As a true translator you will take care not to translate word for word.----Horace","It is difficult to retain what you may have learned unless you should practice it.----Pliny the Younger"};
                HashMap<String, String> values = new HashMap<String, String>();
                int z = moTitle.length;
                for(int i = 0; i < z; i++) {
                    values.put(moTitle[i], moSub[i]);
                }

                System.out.println(values);
                DoubleAdapter doubleAdapter = new DoubleAdapter(values);
                listView.setAdapter(doubleAdapter);
        return rootView;


            }
}
