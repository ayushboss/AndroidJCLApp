package com.ayushcoding.www.jclapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class StudyGuides extends AppCompatActivity  {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    Button geo, rh, vocab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_guides);
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
                        new ProfileDrawerItem().withName("The JCL App").withEmail("The Best Way to Learn Latin").withIcon(R.mipmap.ic_avatar)                )
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
                            Intent intent = new Intent(StudyGuides.this, Performance.class);

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

        geo = (Button) findViewById(R.id.geoBeginButtonStudyGuide);
        geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.GeoSelect");
                startActivity(intent);
            }
        });
        rh = (Button) findViewById(R.id.rhBeginButtonStudyGuide);
        rh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.RomanStudyGuideSelect");
                startActivity(intent);
            }
        });
        vocab = (Button) findViewById(R.id.vocabularyBeginButtonStudyGuide);
        vocab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.VocabSelect");
                startActivity(intent);
            }
        });
        Button mottoes = (Button) findViewById(R.id.mottoesBeginButtonStudyGuide);
        mottoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.SwipeMottoes");
                startActivity(intent);
            }
        });
        Button rl = (Button) findViewById(R.id.rlBeginButtonStudyGuide);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.RomanLifeSelect");
                startActivity(intent);
            }
        });
        Button no = (Button) findViewById(R.id.notecardsBeginButtonStudyGuide);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.Notecards");
                startActivity(intent);
            }
        });
        Button deriv = (Button) findViewById(R.id.derivBeginButtonStudyGuide);
        deriv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.GreekDerivatives");
                startActivity(intent);
            }
        });
        Button m = (Button) findViewById(R.id.mythBeginButtonStudyGuide);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent("com.ayushcoding.www.jclapp.MythologyStudyGuide");
                startActivity(intent);
            }
        });
        Button lit = (Button) findViewById(R.id.LatinLitBeginButtonStudyGuide);
        lit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.LitStudyGuide");
                startActivity(intent);
            }
        });
        Button gram = (Button) findViewById(R.id.grammarBeginButtonStudyGuide);
        gram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ayushcoding.www.jclapp.GrammarSelect");
                startActivity(intent);
            }
        });

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
}
