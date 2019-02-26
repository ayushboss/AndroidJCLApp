package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Republic extends AppCompatActivity{
Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_republic);
        sp = (Spinner) findViewById(R.id.spinnerRepublic);
        String[] s = new String[]{"Fifth Century Conflicts with Rome’s Neighbors ", "The First Samnite War (343 – 341 BC)", "The Latin War (340 – 338 BC)", "The Second (Great) Samnite War (327 – 304 BC: 327 – 301, 316 – 304 BC)", "The Third Samnite War (298 – 290 BC) and Other Battles", "The Pyrrhic Wars (280-272)", "Inter-Bellum: 241 to 218 BC", "The Second Punic War: 218 to 201 BC", "The First and Second Macedonian Wars (215 – 196 BC)", "The Aetolian War (The War Against Antiochus III of Syria): 191 – 188 BC", "The Third and Fourth Macdeonian Wars (171 – 148 BC), and Corinth, Rhodes, Pergamum, and Syria", "The Jugurthine War (111 – 106 BC), The Second Servile War, and the Wars against the Cimbri and Teutones", "Marcus Livius Drusus (91 BC) and The Social War (90 – 88 BC)", "The War Against Quintus Sertorius (122 – 73 BC)", "Lucullus and The Third Mithridatic War (74/73 to 63 BC), and Spartacus and the Third Servile War (73- 71 BC)", "Antony and Octavian, The Second Triumvirate, Antony, Livia, Pompey, Antony in the East, and the Civil War"};
        ArrayAdapter<String> d = new ArrayAdapter<String>(this, R.layout.spinner_item, s);
        d.setDropDownViewResource(R.layout.spinner_dropdown_snacks);
        sp.setAdapter(d);
        System.out.println("LENGTH : " + s.length);
        WebView wv = (WebView) findViewById(R.id.webViewRep);
        wv.loadUrl("file:///android_asset/rep.rtf.html");

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);


        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));
            sp.setOnItemSelectedListener(new CustomOnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    System.out.println("POS : " + position);
                    WebView wv = (WebView) findViewById(R.id.webViewRep);
                    System.out.println("POSITION : " + position);

                    switch(position) {
                        case 0:
                            wv.loadUrl("file:///android_asset/rep.rtf.html");
                            break;
                        case 1:
                            wv.loadUrl("file:///android_asset/rep2.rtf.html");
                            break;
                        case 2:
                            wv.loadUrl("file:///android_asset/rep3.rtf.html");
                            break;
                        case 3:
                            wv.loadUrl("file:///android_asset/rep4.rtf.html");
                            break;
                        case 4:
                            wv.loadUrl("file:///android_asset/rep5.rtf.html");
                            break;
                        case 5:
                            wv.loadUrl("file:///android_asset/rep6.rtf.html");
                            break;
                        case 6:
                            wv.loadUrl("file:///android_asset/rep8.rtf.html");
                            break;
                        case 7:
                            wv.loadUrl("file:///android_asset/rep9.rtf.html");
                            break;
                        case 8:
                            wv.loadUrl("file:///android_asset/rep10.rtf.html");
                            break;
                        case 9:
                            wv.loadUrl("file:///android_asset/rep11.rtf.html");
                            break;
                        case 10:
                            wv.loadUrl("file:///android_asset/rep12.rtf.html");
                            break;
                        case 11:
                            wv.loadUrl("file:///android_asset/rep14.rtf.html");
                            break;
                        case 12:
                            wv.loadUrl("file:///android_asset/rep15.rtf.html");
                            break;
                        case 13:
                            wv.loadUrl("file:///android_asset/rep17.rtf.html");
                            break;
                        case 14:
                            wv.loadUrl("file:///android_asset/rep18.rtf.html");
                            break;
                        case 15:
                            wv.loadUrl("file:///android_asset/rep20.rtf.html");
                            break;
                        case 16:
                            wv.loadUrl("file:///android_asset/rep21.rtf.html");
                            break;
                        case 17:
                            wv.loadUrl("file:///android_asset/rep.rtf.html");
                            break;
                        case 18:
                            wv.loadUrl("file:///android_asset/rep.rtf.html");
                            break;
                        case 19:
                            wv.loadUrl("file:///android_asset/rep.rtf.html");
                            break;
                        case 20:
                            wv.loadUrl("file:///android_asset/rep.rtf.html");
                            break;

                    }
                }

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
    }

}
