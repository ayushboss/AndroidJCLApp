package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class GeoSelect extends AppCompatActivity {
    Activity activity;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_select);
        listView = (ListView) findViewById(R.id.listViewGeo);
        activity = GeoSelect.this;

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        String[] values = new String[] { "Achaea",
                "Aegyptus",
                "Africa Proconsularis (North)",
                "Africa Proconsularis (South)",
                "Arabia",
                "Armenia",
                "Asia",
                "Baetica",
                "Bithynia and Pontus",
                "Britannia",
                "Cappadocia",
                "Cilicia",
                "Cities",
                "Corsica",
                "Creta",
                "Cyprus",
                "Dacia",
                "Dalmatia",
                "Epirus",
                "Galatia",
                "Gallia Narbonensis",
                "Galliae",
                "Germania Inferior",
                "Germania Superior",
                "Italia",
                "Iudea",
                "Libya Superior",
                "Lusitania",
                "Lycia and Pamphylia",
                "Macedonia",
                "Mauretania Caesariensis",
                "Mauretania Tingitana",
                "Mesopotamia",
                "Moesia Inferior",
                "Moesia Superior",
                "Noricum",
                "Pannonia Inferior",
                "Pannonia Superior",
                "Raetia",
                "Sardinia",
                "Sicillia",
                "Syria",
                "Tarraconensis",
                "Thracia"
        };
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                if (itemValue == "Cities") {
                    Intent i = new Intent("com.ayushcoding.www.jclapp.Cities");
                    startActivity(i);
                } else {
                    Intent intent = new Intent("com.ayushcoding.www.jclapp.GeoStudyGuide");
                    intent.putExtra("province", itemValue);
                    startActivity(intent);
                }
            }

        });
    }
    }

