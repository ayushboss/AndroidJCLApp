package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Vocab3 extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab3);

        Activity activity = this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarV3);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);
        recyclerView = (RecyclerView) findViewById(R.id.v3recycler_view);
        //recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        V1RecyclerAdapter adapter = new V1RecyclerAdapter(this);
String[] dataS = { "Accendo", "Acer", "Adulescens", "Aedes", "Aequor", "Aestimo", "Aetas", "Agmen", "Aio", "Alo", "Amnis", "An", "Anima", "Antiquus", "Appello, -are", "Aptus", "Ara", "Arbitror", "Arceo", "Ardeo", "Arvum", "Arx", "Asper", "At", "Ater", "Atque", "Autem", "Bibo", "Bis", "Carpo", "Carus", "Caterva", "Caveo", "Censeo", "Cerno", "Certus", "Cingo", "Citus", "Clementia", "Classis", "Comes", "Condo", "Conor", "Coniunx", "Cor", "Coruscus", "Cresco", "Crimen", "Cum (conj.)", "Cunctus", "Decet", "Demum", "Denique", "Dignus", "Disco", "Dives", "Divus", "Dulcis", "Dum", "Egeo", "Emo", "Enim", "Ensis", "Eripio", "Erro", "Exuviae", "Fallo", "Fas", "Fateor", "Fatum", "Ferio", "Ferrum", "Fio", "Fingo", "Flamma", "Flecto", "Fleo", "Fluctus", "Foedus, foederis", "For", "Fruor", "Frustra", "Fuga", "Fundo", "Funus", "Gemitus", "Grex", "Haud", "Hinc", "Horreo", "Hortor", "Huc", "Humus", "Immanis", "Impero", "Imperium", "Incendo", "Inde", "Ingenium", "Inquit", "Iste", "Iudicium", "Iungo", "Iuro", "Iuvo", "Labor, labi", "Lacrimo", "Latus, lateris", "Lenis", "Levo", "Licet", "Limen", "Loquor", "Luctor", "Ludo", "Maestus", "Mando, -are", "Meminisse", "Mens", "Mensis", "Mereo", "Metus", "Minor, -ari", "Mirror", "Misceo", "Mitis", "Modo", "Modus", "Moenia", "Moles", "Mollis", "Moror", "Morior", "Mos", "Mulier", "Munus", "Murus", "Muto", "Nanciscor", "Nascor", "Nego", "Nemus", "Nimis", "Nondum", "Nosco", "Numen", "Obliviscor", "Occido", "Odi", "Opes", "Opto", "Opus", "Ora", "Oro", "Orior", "Os, oris", "Otium", "Parco", "Pareo", "Pateo", "Patior", "Pectus", "Pello", "Pendeo", "Pendo", "Perdo", "Pingo", "Pius", "Placeo", "Polliceor", "Pontus", "Potestas", "Potior", "Precor", "Premo", "Pretium", "Principium", "Pro", "Probare", "Procul", "Puto", "Quaero", "Qualis", "Quam", "Quantus", "Queror", "Quia", "Quidem", "Quies", "Quisque", "Quo", "Quondam", "Ramus", "Rapio", "Refero", "Reor", "Ripa", "Rumpo", "Ruo", "Saeculum", "Salio", "Salus", "Sanguis", "Saxum", "Scelus", "Sedes", "Senex", "Sequor", "Servio", "Sol", "Solum", "Solvo", "Somnus", "Sors", "Sterno", "Struo", "Sumo", "Summus", "Supplicium", "Taceo", "Talis", "Tantus", "Tectum", "Tego", "Telum", "Tendo", "Tenuis", "Testis", "Tristis", "Tueor", "Tunc", "Turpis", "Umbra", "Unde", "Uro", "Ut", "Uter", "Utor", "Veho", "Vel", "Ventus", "Vereor", "Vestis", "Vetus", "Vis", "Virtus", "Vitium", "Volvo", "Vulgus", "Vultus"};

String[] dataM = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        adapter.enterData(dataS);
        adapter.enterData2(dataM);
        adapter.setColor("blue");
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
