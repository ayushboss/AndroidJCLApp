package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class Tutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        tutorial();
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));
    }
    public void tutorial() {
        // Do first run stuff here then set 'firstrun' as false
        // using the following line to edit/commit prefs
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        final FragmentManager fragmentManager = getFragmentManager();
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Mobile",
                "The convenient all-in-one resource for the Junior Classical League",
                Color.parseColor("#8e44ad"), R.drawable.smartphone, R.drawable.smartphone);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Study",
                "Study for the JCL exams. Anytime. Anywhere. Online. Offline",
                Color.parseColor("#2ecc71"), R.drawable.map, R.drawable.map);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Test your knowledge",
                "Test your knowledge against past JCL exams, for free. Forever.",
                Color.parseColor("#95a5a6"), R.drawable.notepad, R.drawable.notepad);
        PaperOnboardingPage scr4 = new PaperOnboardingPage("Track your performance",
                "Understand your performance with interactive charts and graphs.",
                Color.parseColor("#e67e22"), R.drawable.stopwatch, R.drawable.stopwatch);
        PaperOnboardingPage scr5 = new PaperOnboardingPage("Get started",
                "Welcome to the JCL App. Swipe right to go to the home page",
                Color.parseColor("#e74c3c"), R.drawable.user, R.drawable.user);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        elements.add(scr4);
        elements.add(scr5);

        final PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(elements);

        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.meme, onBoardingFragment);
        fragmentTransaction.commit();
        onBoardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
