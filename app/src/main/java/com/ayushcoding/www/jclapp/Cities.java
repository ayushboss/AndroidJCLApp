package com.ayushcoding.www.jclapp;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class Cities extends Activity {

    private MapView mapView;
    Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        activity = Cities.this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        mapView = (MapView) findViewById(R.id.mapView3);// update merge thing test dont mind
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(41.90, 12.48))
                        .title("Rome")
                        .snippet("Population : 1,000,000"));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.20, 29.92))
                        .title("Alexandria")
                        .snippet("Population : 600,000"));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(31.47, 35.13))
                        .title("Jerusalem")
                        .snippet("Population : 150,000"));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(38.42, 27.13))
                        .title("Smyrna")
                        .snippet("Population : 200,000"));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(41.01, 28.97))
                        .title("Constantinople")
                        .snippet("Population : 200,000"));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(51.3758, -2.3599))
                        .title("Aquae Sulis")
                        .snippet("Population : 60,000"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(51.5074, 0.1278))
                        .title("Londinium")
                        .snippet("Population : 600,000"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(47.4979, 19.0402))
                        .title("Aquincum")
                        .snippet("Population : 10,000"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(52.6702, -2.6456))
                        .title("Viroconium")
                        .snippet("Population : 1,000"));

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(50.7374, 7.0982))
                        .title("Bonna")
                        .snippet("Population : 20,000"));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(50.9375, 6.9603))
                        .title("Colonia Agrippina")
                        .snippet("Population : 45,000"));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(53.9600, -1.0873))
                        .title("York")
                        .snippet("Population : 6,000"));




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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
