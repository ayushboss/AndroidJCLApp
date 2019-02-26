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

public class Miscellaneous extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscellaneous);
        ListView listView = (ListView) findViewById(R.id.misc);
        String[] conj1 = {"cisium", "raeda", "lectica", "Via Appia", "Via Sacra", "Mare Nostrum", "basilica", "curia", "cloaca maxima", "insulae", "vigiles", "praefciae", "neniae", "conclamatio", "sarcophagus", "columbarium", "atrium", "compluvium", "impluvium", "alae", "imagines", "tablinum", "triclinium", "culina", "cubiculum", "peristylium", "hortus", "tunica recta", "flammeum", "sponsalia", "dos", "'ubi tu Gaius, ego Gaia'", "pronuba", "Bad luck to marry on", "usus", "coemptio", "confarreatio", "deductio", "century", "maniple", "cohort", "legion", "contubernium", "dux", "imperator", "legatus", "centurio", "optio", "toga picta", "tesserae", "signum", "signifier", "aquila", "aquilifer", "cornicen", "vexillum", "pedites", "equites", "scorpio", "ballista", "onager", "catapulta", "gladius", "scutum", "galea", "cassis", "pilum", "hasta", "lorica", "cingulum", "caligae", "sarcina", "pugio"};
        String[] cong1Sub = {"lightweight,2 wheeled vehicle", "4 wheeled carriage, comfortable and large", "litter (carried by 4 slaves)", "Appian Way – from Rome to Capua early on, then extended to Brundisium; known as the queen of the roads – “regina viarum” – built by Appius Claudius Caecus in 312 BC", " road which ran through the forum", "“our sea” – Mediterranean", "law court", "senate house", "great sewer", "apartment buildings", "firemen/police", "professional mourners", "dirges", "oldest son shakes father 3 times and calls his name", "stone coffin", "underground chamber for urns holding the ashes of a cremated person", "entry hallway/large meeting room", "hole in roof of atrium – allows water in", "basin that catches water", "wings off atrium", "bust of ancestors, housed in alae", "master’s office", "dining room", "kitchen", "bedroom", "outdoor garden with columns", "regular garden", "white wedding dress", "'saffron' colored veil", "engagement", "dowry", "what bride says at ceremony – 'where you are, my husband, I am' night before wedding, a girl would dedicate her bulla to the Lares", "matron of honor", " the kalends, nones, ides (and the day after each) of any month; all of May and half of June were all unlucky days also unlucky, the days the lower world was supposed to open – August 24, October 5, November 8.", "common law marriage", "fictitious sale of the bride", "upper class marriage ceremony", "procession of wedding party to forum", "smallest unit of a legion", "double a century (later dropped in favor of a cohort)", "6 times a century", "basic fighting unit of the Roman army", "6-8 men who share a tent (part of a century)", "general", "victorious general", "legionary commander", "leader of a century", "2nd in command to a centurio", "worn by victorius generals", "passwords", "standard", "holder of standard (of a century or cohort)", "silver or bronze eagle-standard (of a legion)", "holder of the eagle", "horn blower", "flag", "infantry", "cavalry", "dart thrower (standing crossbow used by one man)", "dart or stone throwing siege engine, larger than a scorpio", "siege engine (like a catapult), threw boulders; means “wild ass” for its kick", "siege engine which hurled javelins", "sword", "shield", "helmet (originally only made of leather)", "helmet (originally only made of metal)", "javelin", "spear (used by triarii and hastati)", "leather breastplate", "military belt", "boots", "soldier's cloak/blanket", "dagger"};
        HashMap<String, String> values = new HashMap<String, String>();
        int z = conj1.length;
        for (int i = 0; i < z; i++) {
            values.put(conj1[i], cong1Sub[i]);
        }
        System.out.println(values);
        DoubleAdapter doubleAdapter = new DoubleAdapter(values);
        listView.setAdapter(doubleAdapter);
        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarMisc);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_miscellaneous, menu);
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
