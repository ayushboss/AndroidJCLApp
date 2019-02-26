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


public class AbbreviationsFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_abbreviations, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listViewAbbs);

        String[] abbTitle = {"ab urbe condita/ anno urbis conditae – A.U.C","anno domini - A.D","ad libitum -- ad lib.","ante meridiem -- A.M","confer -- cf","exempli gratia -- e.g.","et alia -- et al.","et cetera -- etc.","ibidem – ibid.","idem – id.","id est -- i.e.","Medicinae Doctor -- M.D."," meridie – m.","nota bene -- N.B.","opere citato – op. cit.","per centum -- per cent","post meridiem -- P.M.","pro tempore -- pro tem.","post scriptum -- P.S.","Quod erat demonstrandum – Q.E. D.","quod vide -- q.v."," recipe -- Rx","videlicet -- viz.","versus -- vs."};
        String[] abbSub = {"from the founding of the city","in the year of our Lord","at pleasure","before noon","compare","for example","and others","and so forth, and the rest","in the same place","the same (author)","that is (an explanation)","medical doctor, doctor of medicine","at midday, noon","note well (pay attention to this)","in the work cited/mentioned","by the hundred","afternoon","for the time being","written afterwards","that which must be demonstrated","which see","take as prescribed (medical term)","namely","against"};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = abbTitle.length;
        for(int i = 0; i < z; i++) {
            values.put(abbTitle[i], abbSub[i]);
        }
        System.out.println(values);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.setAdapter(doubleAdapter);
        return rootView;
    }
}
