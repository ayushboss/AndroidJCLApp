package com.ayushcoding.www.jclapp;

import android.content.Context;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class LitStudyGuide extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lit_study_guide);
        final View bottomSheet = findViewById(R.id.bottom_sheet);
        ListView lv = (ListView) findViewById(R.id.litStudyG);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarLitStudy);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        String checkTest = checkTest(getApplicationContext());
//        System.out.println("meme" + checkTest);
        String[] checkArray = checkTest.split("--");
        System.out.println(checkArray.length);

        final ArrayList<LiteratureItem> ali = new ArrayList<LiteratureItem>();
        ArrayList<String> al2 = new ArrayList<String>();
        for (int i = 0; i < 74; i += 2) {
            String name = checkArray[i];
            String desc = checkArray[i + 1];
            al2.add( name);
            System.out.println("NAME " + name + ", Description " + desc);
            LiteratureItem li = new LiteratureItem(name, desc);
            System.out.println("LI " + li);
            System.out.println(i);
            ali.add(li);

        }
        ArrayAdapter<String> adl = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al2);
        lv.setAdapter(adl);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                TextView tv = (TextView) findViewById(R.id.titleLit);
                TextView tv2 = (TextView) findViewById(R.id.subLitStudy);
                String name = ((LiteratureItem) ali.toArray()[position]).getNameLit();
                String desc = ((LiteratureItem) ali.toArray()[position]).getDescLit();
                tv.setText(name);
                tv2.setText(desc);
                int x = mBottomSheetBehavior.getState();
                System.out.println(x);
                if (x == 3) {
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            // this code will be executed after 2 seconds
                            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        }
                    }, 500);

                }
                if (x == 4) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                }


            }
        });

//            ADD THIS IN THE ON ITEM CLICK LISTENER
//        System.out.println(ali.toString());

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public static String checkTest(Context context) {
        StringBuilder out = null;
        try {
            InputStream is = context.getAssets().open("litStudy.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);   // add everything to StringBuilder
                // here you can have your logic of comparison.
                if (line.toString().contains(":")) {
                    // do something
                    out.append(line);
                    out.append('\n');
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "LitStudyGuide Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ayushcoding.www.jclapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "LitStudyGuide Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ayushcoding.www.jclapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
