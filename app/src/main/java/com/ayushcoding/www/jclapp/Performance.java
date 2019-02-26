package com.ayushcoding.www.jclapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;

public class Performance extends AppCompatActivity {
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        final PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName("Home").withIcon(R.drawable.home).withSelectable(false);
        final PrimaryDrawerItem item2 = new PrimaryDrawerItem().withName("Study Guides").withIcon(R.drawable.book).withSelectable(false);
        final PrimaryDrawerItem item3 = new PrimaryDrawerItem().withName("Test Yourself").withIcon(R.drawable.studentmale).withSelectable(false);
        final PrimaryDrawerItem item4 = new PrimaryDrawerItem().withName("Performance").withIcon(R.drawable.radarplot).withSelectable(false);
        final PrimaryDrawerItem item5 = new PrimaryDrawerItem().withName("Conventions").withIcon(R.drawable.ic_action_con).withSelectable(false);
        final PrimaryDrawerItem item6 = new PrimaryDrawerItem().withName("Credits").withIcon(R.drawable.ic_info).withSelectable(false);

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
        Drawer drawerBuilder = new DrawerBuilder().withActivity(this)
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
                        item6
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
                            Intent intent = new Intent(Performance.this, Performance.class);

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
                        return false;
                    }
                })
                .build();
        drawerBuilder.setSelection(2);
        drawerBuilder.setSelection(1);
        drawerBuilder.setSelection(3);
        drawerBuilder.setSelection(4);

    }

    @Override
    protected void onStart() {
        super.onStart();
        RadarChart performance = (RadarChart) findViewById(R.id.performanceChart);

        ScoresDB scoresDB = new ScoresDB(Performance.this);
        int[] rhTotal = scoresDB.selectMythScore("romanH");
        System.out.println("CORRECT " + rhTotal[1]);
        System.out.println("TOTAL " + rhTotal[0]);
        Integer totalrh = rhTotal[0];
        Integer correctrh = rhTotal[1];
        double rhDataDouble = (((double) correctrh)/totalrh);
        float rhData = ((float) rhDataDouble) * 100;

        int[] mythTotal = scoresDB.selectMythScore("greekMyth");
        System.out.println("CORRECT " + mythTotal[1]);
        System.out.println("TOTAL " + mythTotal[0]);
        Integer totalMyth = mythTotal[0];
        Integer correctMyth = mythTotal[1];
        double mythDataDouble = (((double) correctMyth)/totalMyth);
        float mythData = ((float) mythDataDouble) * 100;

        int[] grammarTotal = scoresDB.selectMythScore("greekMyth");
        System.out.println("CORRECT " + grammarTotal[1]);
        System.out.println("TOTAL " + grammarTotal[0]);
        Integer totalGrammar = grammarTotal[0];
        Integer correctGrammar = grammarTotal[1];
        double grammarDataDouble = (((double) correctGrammar)/totalGrammar);
        float grammarData = ((float) grammarDataDouble) * 100;

        int[] LifeTotal = scoresDB.selectMythScore("romanL");
        System.out.println("CORRECT " + LifeTotal[1]);
        System.out.println("TOTAL " + LifeTotal[0]);
        Integer totalLife = LifeTotal[0];
        Integer correctLife = LifeTotal[1];
        double LifeDataDouble = (((double) correctLife)/totalLife);
        float LifeData = ((float) LifeDataDouble) * 100;

        int[] LitTotal = scoresDB.selectMythScore("latinLit");
        System.out.println("CORRECT " + LitTotal[1]);
        System.out.println("TOTAL " + LitTotal[0]);
        Integer totalLit = LitTotal[0];
        Integer correctLit = LitTotal[1];
        double LitDataDouble = (((double) correctLit)/totalLit);
        float LitData = ((float) LitDataDouble) * 100;

        int[] vocabTotal = scoresDB.selectMythScore("vocabScore");
        System.out.println("CORRECT VICAB " + vocabTotal[1]);
        System.out.println("TOTAL VOCAB " + vocabTotal[0]);
        Integer totalVocab = LitTotal[0];
        Integer correctVocab = LitTotal[1];
        double vocabDataDouble = (((double) correctVocab)/totalVocab);
        float vocabData = ((float) vocabDataDouble) * 100;

        ArrayList<Entry> comp2 = new ArrayList<>();

        comp2.add(new Entry(rhData, 0));//Roman History
        comp2.add(new Entry(mythData, 1));//Greek Mythology
        comp2.add(new Entry(LifeData, 2));//Roman Life
        comp2.add(new Entry(LitData, 3));//Roman Literature
        comp2.add(new Entry(74f, 4));//Greek Life
        comp2.add(new Entry(grammarData, 5));//Grammar
        comp2.add(new Entry(vocabData, 6));//Decath
        int colorId = Color.parseColor("#8E44AD");
        RadarDataSet dataset_comp2 = new RadarDataSet(comp2, "Your Test Averages");

        dataset_comp2.setColor(colorId);

        dataset_comp2.setDrawFilled(true);

        ArrayList<RadarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataset_comp2);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Roman History");
        labels.add("Greek Mythology");
        labels.add("Roman Life");
        labels.add("Latin Literature");
        labels.add("Mottoes");
        labels.add("Grammar");
        labels.add("Vocabulary");

        RadarData data = new RadarData(labels, dataSets);
        performance.setData(data);
        for (RadarDataSet set : dataSets) {

           set.setDrawFilled(true);
        }
        String description = "Your Quiz Performance In Percentage";
        performance.setDescription(description);
        performance.setWebLineWidthInner(0.5f);
        performance.setDrawWeb(true);
        performance.setWebAlpha(100);
        performance.setDescriptionColor(Color.RED);
        dataset_comp2.setDrawFilled(true);


    }






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
                            ScoresDB scoresDB = new ScoresDB(Performance.this);
                            scoresDB.deleteValues();
                        }})
                    .setNegativeButton(android.R.string.no, null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
