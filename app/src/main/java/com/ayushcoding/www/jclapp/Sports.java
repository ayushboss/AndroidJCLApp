package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.HashMap;

public class Sports extends AppCompatActivity   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarSP);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        ListView listView = (ListView) findViewById(R.id.sports);
        String[] conj1 = {"metae","spina","ova et delphines","Laps in a usual chariot races","Capacity of the circus maximus","ludi circenses","factiones","Colors of the factions","Colors of the original factions","Longest lasting factions","Location of the Circus Maximus","mappa","biga","quadriga","auriga","curriculum","carceres","Myrmillones","Retiarii","Samnites","Thracians","Bestiarii","Essedarii","Andabatae","Laquearii","Secutores","Hoplomachi","rudis","lanista","editor munerum","arena","venationes","premere pollicem","vertere pollicem","Introduction date of gladiator fights","Original place of gladiatorial fights","maumachiae"};
        String[] cong1Sub = {"turning posts","backbone around which chariots raced","eggs and dolphins (wood or bronze) used as lap counters","7","250,000","chariot races","racing companies","red (russata),white (albata),blue (veneta),green (prasina)","red and white","blue and green","Between the Palatine and Aventine Hills","white cloth used to signify the start of the race","2 horse chariot","4 horse chariot","charioteer","sucessfully completed lap","starting gates","fought with helmet, oblong shield, sword, fish crest on helmet. Usually fought the retiarius or Thracians","lightly clad, armed with a net and trident. Usually fought Myrmillones or Secutores.","oblong shield, visored helmet, sword.","small round shield, curved scimitar.","hunters, fought wild beasts.","rode chariots with 2 horses","heavily armed, but can’t see out of visored helmet.","armed with lasso and a curved piece of wood."," “pursuers” – like Samnite but without the neck protector","full-armed with a breast-plate and visored helmet.","wooden sword given to gladiators on their retirement.","gladiator trainer.","giver of games.","sand put down to absorb the blood from a gladiator match.","hunts where Bestiarii fought wild beasts.","to press the thumb against the forefinger – crowd wants to spare gladiators life.","turning the thumb upwards or towards the chest – to signify the death stroke.","264 BC","funerals","mock naval battles – they flooded the arena."};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = conj1.length;
        for(int i = 0; i < z; i++) {
            values.put(conj1[i], cong1Sub[i]);
        }
        System.out.println(values);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.setAdapter(doubleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //Wat
        getMenuInflater().inflate(R.menu.menu_sports, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item= menu.findItem(R.id.action_settings);
        item.setVisible(false);
        super.onPrepareOptionsMenu(menu);
        return true;
    }
}
