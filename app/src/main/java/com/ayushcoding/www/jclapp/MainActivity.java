package com.ayushcoding.www.jclapp;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity
         {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    SharedPreferences prefs = null;
    SharedPreferences prefs2 = null;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    Animation animFadeIn, animFadeOut;
    TextView warmWelcome,name, locationFire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (getPreferences(MODE_PRIVATE).getBoolean("is_first_run", true)) {
        /*
         * your code here
         */
            getPreferences(MODE_PRIVATE).edit().putBoolean("is_first_run", false).commit();
            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            // editor.putString(getString(R.string.notifStringPrefString),"Alabama");
            //editor.commit();
            //String xy = sharedPref.getString(getString(R.string.notifStringPrefString), "error");
            //FirebaseMessaging.getInstance().subscribeToTopic(xy);

        }

        mToolbar = (Toolbar) findViewById(R.id.toolbar_of_activity_main);
        setSupportActionBar(mToolbar);
        prefs = getSharedPreferences("com.ayushcoding.www.jclapp", MODE_PRIVATE);

        final PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("Home").withIcon(R.drawable.home).withSelectable(false);
        final PrimaryDrawerItem item2 = new PrimaryDrawerItem().withName("Study Guides").withIcon(R.drawable.book).withSelectable(false);
        final PrimaryDrawerItem item3 = new PrimaryDrawerItem().withName("Test Yourself").withIcon(R.drawable.studentmale).withSelectable(false);
        final PrimaryDrawerItem item4 = new PrimaryDrawerItem().withName("Performance").withIcon(R.drawable.radarplot).withSelectable(false);
        final PrimaryDrawerItem item5 = new PrimaryDrawerItem().withName("Conventions").withIcon(R.drawable.ic_action_con).withSelectable(false);
        final PrimaryDrawerItem item6 = new PrimaryDrawerItem().withName("Credits").withIcon(R.drawable.ic_info).withSelectable(false);
        final PrimaryDrawerItem item7 = new PrimaryDrawerItem().withName("Notification Settings").withIcon(R.drawable.ic_alert).withSelectable(false);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.purplewallpaper)
                .addProfiles(
                        new ProfileDrawerItem().withName("The JCL App").withEmail("The Best Way to Learn Latin").withIcon(R.mipmap.ic_avatar)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
            final Context context = this;

        final Drawer drawerBuilder = new DrawerBuilder().withActivity(this)
                .withToolbar(mToolbar)

                .withAccountHeader(headerResult)
                .addDrawerItems(

                        item1,
                        item5,
                        new SectionDrawerItem().withName("Study"),
                        item2,
                        item3,
                        item4,
                        new SectionDrawerItem().withName("Settings"),
                        item6,
                        item7
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        if (drawerItem == item1) {
                            Intent startIntent = new Intent(context, MainActivity.class);
                            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(startIntent);
                        } else if(drawerItem == item2) {
                            Intent intent = new Intent("com.ayushcoding.www.jclapp.StudyGuides");
                            startActivity(intent);
                        } else if(drawerItem == item3) {
                            Intent intent = new Intent("com.ayushcoding.www.jclapp.TestSelection");
                            startActivity(intent);
                        } else if(drawerItem == item4) {
                            Intent intent = new Intent(MainActivity.this, Performance.class);

                            startActivity(intent);
                        }
                        else if(drawerItem == item5) {
                            Intent intent = new Intent("com.ayushcoding.www.jclapp.Competitions");
                            startActivity(intent);
                        }
                        else if(drawerItem == item6) {
                            Intent intent = new Intent("com.ayushcoding.www.jclapp.Credits");
                            startActivity(intent);
                        }
                        else if(drawerItem == item7) {
                            Intent intent = new Intent(MainActivity.this, notificationActivity.class);
                            startActivity(intent);
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(false)
                .build();

        drawerBuilder.setSelection(2);
        drawerBuilder.setSelection(1);
        drawerBuilder.setSelection(3);
        drawerBuilder.setSelection(4);
    }

    @Override
    protected void onStart() {
        super.onStart();


        animFadeIn= AnimationUtils.loadAnimation(this, R.anim.fadein);
        warmWelcome = (TextView) findViewById(R.id.textView4);
        warmWelcome.startAnimation(animFadeIn);
        warmWelcome.setVisibility(View.VISIBLE);
        warmWelcome.setTypeface(Typeface.create("sans-serif-thin", Typeface.NORMAL));
        System.out.println((char) 27 + "hews");
        try {
            checkIfFirstMainActivity();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Target homeTarget = new Target() {
//            @Override
//            public Point getPoint() {
//                // Get approximate position of home icon's center
//                int actionBarSize = mToolbar.getHeight();
//                int x = actionBarSize / 2;
//                int y = actionBarSize / 2;
//                return new Point(x, y);
//            }
//        };
//        new ShowcaseView.Builder(this)
//                .setContentTitle("Click on this to take tests or study!")
//                .setTarget(homeTarget)
//                .withNewStyleShowcase()
//                .build();
    }

             private String convertDate(String date) {
                 try {
                     SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
                     Date d = format.parse(date);
                     SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd'T'");
                     return serverFormat.format(d);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 return "";
             }

    public void checkIfFirstMainActivity() throws InterruptedException {
        prefs = getSharedPreferences("com.ayushcoding.www.jclapp", MODE_PRIVATE);
        if (prefs.getBoolean("firstrunMain", true)) {
            Intent intent = new Intent("com.ayushcoding.www.jclapp.Tutorial");
            startActivity(intent);
            prefs.edit().putBoolean("firstrunMain", false).commit();
        }
    }





//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        if (!mNavigationDrawerFragment.isDrawerOpen()) {
//            // Only show items in the action bar relevant to this screen
//            // if the drawer is not showing. Otherwise, let the drawer
//            // decide what to show in the action bar.
//            getMenuInflater().inflate(R.menu.main, menu);
//            return true;
//        }
//        return super.onCreateOptionsMenu(menu);
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear_data_2) {
            new AlertDialog.Builder(this)
                    .setTitle("Clear Data")
                    .setMessage("Do you really want to clear your quiz data?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {
                            ScoresDB scoresDB = new ScoresDB(MainActivity.this);
                            scoresDB.deleteValues();
                        }})
                    .setNegativeButton(android.R.string.no, null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
