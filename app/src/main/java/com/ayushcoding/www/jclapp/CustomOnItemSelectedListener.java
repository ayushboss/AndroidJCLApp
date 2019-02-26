package com.ayushcoding.www.jclapp;

/**
 * Created by Ayush on 7/2/2016.
 */
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public abstract class CustomOnItemSelectedListener implements OnItemSelectedListener, AdapterView.OnItemClickListener {

    public void onItemSelectedListener(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}