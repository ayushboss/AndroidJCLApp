package com.ayushcoding.www.jclapp;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Empire extends AppCompatActivity {
Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empire);
        sp = (Spinner) findViewById(R.id.spinnerEmpire);
        String[] s = new String[]{"Augustus","Tiberius","Caligula","Claudius","Nero","Year of 4 Emperors","Flavian Dynasty","Five Good Emperors and Commodus","Severan dynasty","Probus, Carus, Carinus and Numerian","Diocletian","Constantinian Dynasty" ,"Gratian and Theodosius the Great", "Arcadius and Honorius: The Divided Empire"};
        ArrayAdapter<String> d = new ArrayAdapter<String>(this, R.layout.spinner_item, s);
        d.setDropDownViewResource(R.layout.spinner_dropdown_snacks);
        sp.setAdapter(d);
        System.out.println("LENGTH : " + s.length);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarEmp);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        mToolbar.setTitle("");

        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));
        sp.setOnItemSelectedListener(new CustomOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("POS : " + position);
                WebView wv = (WebView) findViewById(R.id.webViewEmp);
                System.out.println("POSITION : " + position);

                switch(position) {
                    case 0:
                        wv.loadUrl("file:///android_asset/augustus.htm");
                        break;
                    case 1:
                        wv.loadUrl("file:///android_asset/tiberius.htm");
                        break;
                    case 2:
                        wv.loadUrl("file:///android_asset/caligula.htm");
                        break;
                    case 3:
                        wv.loadUrl("file:///android_asset/Claudius.htm");
                        break;
                    case 4:
                        wv.loadUrl("file:///android_asset/nero.htm");
                        break;
                    case 5:
                        wv.loadUrl("file:///android_asset/4emperors.htm");
                        break;
                    case 6:
                        wv.loadUrl("file:///android_asset/Flavian.htm");
                        break;
                    case 7:
                        wv.loadUrl("file:///android_asset/5emperors.htm");
                        break;
                    case 8:
                        wv.loadUrl("file:///android_asset/severan.htm");
                        break;
                    case 9:
                        wv.loadUrl("file:///android_asset/probus_carus.htm");
                        break;
                    case 10:
                        wv.loadUrl("file:///android_asset/diocletian.htm");
                        break;
                    case 11:
                        wv.loadUrl("file:///android_asset/constantine.htm");
                        break;
                    case 12:
                        wv.loadUrl("file:///android_asset/theodosian.htm");
                        break;
                    case 13:
                        wv.loadUrl("file:///android_asset/fall.htm");
                        break;
//                    case 14:
//                        wv.loadUrl("file:///android_asset/rep18.rtf.htm");
//                        break;
//                    case 15:
//                        wv.loadUrl("file:///android_asset/rep20.rtf.htm");
//                        break;
//                    case 16:
//                        wv.loadUrl("file:///android_asset/rep21.rtf.htm");
//                        break;
//                    case 17:
//                        wv.loadUrl("file:///android_asset/rep.rtf.htm");
//                        break;
//                    case 18:
//                        wv.loadUrl("file:///android_asset/rep.rtf.htm");
//                        break;
//                    case 19:
//                        wv.loadUrl("file:///android_asset/rep.rtf.htm");
//                        break;
//                    case 20:
//                        wv.loadUrl("file:///android_asset/rep.rtf.htm");
//                        break;

                }
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}