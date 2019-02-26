package com.ayushcoding.www.jclapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MythologyStudyGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mythology_study_guide);
        WebView wv = (WebView) findViewById(R.id.myth_study_guide_web);
        wv.loadUrl("file:///android_asset/myth_study_guide.htm");
    }
}
