package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.messaging.FirebaseMessaging;

public class notificationActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = notificationActivity.this;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));


       final  SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
       // editor.putBoolean(getString(R.string.userWantsNotif), true);
        //editor.commit();


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarNotif);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        mToolbar.setTitle("Notification Settings");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("SHJDHGSSJKHGSJKHGDJG");
                String var = spinner.getSelectedItem().toString();


            }
        });
        final Button button = (Button) findViewById(R.id.ButtonConfirm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final boolean x = sharedPref.getBoolean(getString(R.string.userWantsNotif),false);
                System.out.println(x);
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                if (x){



                }
                else{



                }
                //FirebaseMessaging.ge1tInstance().subscribeToTopic(spinner.getSelectedItem().toString().replaceAll("\\s+",""));
                /*


                    SharedPreferences.Editor editor = sharedPref.edit();

                    FirebaseMessaging.getInstance().subscribeToTopic("all");

                    Snackbar snackbar = Snackbar
                            .make(v, "You will receive notifications about conventions from " + spinner.getSelectedItem().toString(), Snackbar.LENGTH_SHORT);

                    View sbView = snackbar.getView();
                    sbView.setBackgroundColor(Color.parseColor("#4CAF50"));
                    snackbar.show();
                */

            }
        });


        final Button xbutton = (Button) findViewById(R.id.button9);
        xbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Select 'Notifications' and Enable/Disable Notifications";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                String packageName = "com.ayushcoding.www.jclapp";

                try {
                    //Open the specific App Info page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + packageName));
                    startActivity(intent);

                } catch ( ActivityNotFoundException e ) {
                    //e.printStackTrace();

                    //Open the generic Apps page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
                    startActivity(intent);

                }
            }
        });
    }


}
