package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Competitions extends AppCompatActivity {
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
ListView lv;
    DatabaseReference superChild = mRootRef.child("Events");


    DatabaseReference nameFire = superChild.child("Event");

    DatabaseReference location = nameFire.child("Location");

    DatabaseReference date = nameFire.child("Date");
    DatabaseReference city = location.child("City");
    //             DatabaseReference rName = nameFire.child("Name");
    DatabaseReference state = location.child("State");
    private MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
        lv = (ListView) findViewById(R.id.listViewConventions);
        mapView = (MapView) findViewById(R.id.mapViewCom);
        mapView.onCreate(savedInstanceState);
        Activity activity = Competitions.this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));
        Toolbar mToolbar = (Toolbar) findViewById(R.id.comptoolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar();
    }
    

    @Override
    protected void onStart() {
        super.onStart();
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                System.out.println("There are " + dataSnapshot.getChildrenCount() + " blog posts");

                final ArrayList<Object> al = new ArrayList<Object>();
                final ArrayList<Object> date = new ArrayList<Object>();
                final ArrayList<Object> alCity = new ArrayList<Object>();
                final ArrayList<Object> alState = new ArrayList<Object>();


                final List<Object> list = new ArrayList<Object>();
                final List<Object> list2 = new ArrayList<Object>();
                final List<Object> list3 = new ArrayList<Object>();
                final List<Object> listDate = new ArrayList<Object>();
                final List<Object> listCity = new ArrayList<Object>();
                final List<Object> listState = new ArrayList<Object>();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    System.out.println("MEMEMEMEMEEM : " + postSnapshot.getValue());
                    System.out.println(postSnapshot.getValue().getClass().getName());
                    Map meme = (Map) postSnapshot.getValue();
                    System.out.println("COORDS : " + meme.get("Coordinates"));
                    list.add(meme.get("Name"));
                    listDate.add(meme.get("Date"));
                    System.out.println("Coordinate Type " + meme.get("Coordinates").getClass().getName());
                    HashMap coords = (HashMap) meme.get("Coordinates");
                    HashMap location = (HashMap) meme.get("Location");
                    String city = (String) location.get("City");
                    String stateThing = (String) location.get("State");
                    System.out.println("City : " + city + stateThing);
                    listCity.add(city);
                    listState.add(stateThing);
                    System.out.println("COORDS 0 : " + coords.get("Lat"));
                    Double lat = (Double) coords.get("Lat");
                    Double longi = (Double) coords.get("Long");
                    System.out.println(meme.get("Lat") + " LATTTTTTTTTTTTTTTT");
                    list2.add(lat);
                    list3.add(longi);
                }
                    for (int i = 0; i < list.size(); i++) {
                        String dateS = (String) list.get(i);
                        al.add(dateS);
                        String realD = (String) listDate.get(i);
                        date.add(realD);
                        String cityList = (String) listCity.get(i);
                        String stateList = (String) listState.get(i);
                        alCity.add(cityList);
                        alState.add(stateList);
                    }

                ArrayAdapter<Object> ar = new ArrayAdapter<Object>(Competitions.this, android.R.layout.simple_list_item_1, al);
                lv.setAdapter(ar);

                mapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(final MapboxMap mapboxMap) {
                        final ArrayList<LatLng> lilat = new ArrayList<LatLng>();
                        for(int j = 0; j < list2.size(); j++){
                            LatLng ln = new LatLng();
                            ln.setLongitude((Double) list3.get(j));
                            ln.setLatitude((Double) list2.get(j));
                            lilat.add(j, ln);
                        }
                        for(int k = 0; k < lilat.size(); k++) {
                            mapboxMap.addMarker(new MarkerOptions()
                                    .position(lilat.get(k))
                                    .title((String) list.get(k))
                            );
                            System.out.println("LIST@ AND # " + list3.get(k));
                            System.out.println("LIST2 AND 3 " + list2.get(k));
                            System.out.println("MARLER CPPRD " + lilat.get(k));
                            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    /*Intent intent = new Intent("com.ayushcoding.www.jclapp.Convention");
                                    intent.putExtra("Name", al.get(position) + "");
                                    intent.putExtra("Date", date.get(position) + "");
                                    intent.putExtra("City", alCity.get(position) + "");
                                    intent.putExtra("State", alState.get(position) + "");
                                    startActivity(intent);
                                    */
                                    CameraPosition xposition = new CameraPosition.Builder()
                                            .target(lilat.get(position)) // Sets the new camera position
                                            .zoom(13) // Sets the zoom
                                            .bearing(0) // Rotate the camera
                                            .tilt(0) // Set the camera tilt
                                            .build(); // Creates a CameraPosition from the builder

                                    mapboxMap.animateCamera(CameraUpdateFactory
                                            .newCameraPosition(xposition), 7000);

                                }
                            });
                        }
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


                }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


}
