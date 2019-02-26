package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
public class NotecardView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notecard_view);
        Intent intent = getIntent();

        final Activity activity = NotecardView.this;
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.myPrimaryDarkColor));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarNotes);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_action_back);

        final String getQuestion = intent.getStringExtra("question");
        final String getAnswer = intent.getStringExtra("answer");
        final TextView tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        final TextView tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        tvAnswer.setText(getQuestion);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.notecardView);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvQuestion.setText("Answer");
                tvAnswer.setText(getAnswer);
            }
        });
        ImageView d = (ImageView) findViewById(R.id.deleteIcon);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                NotecardDB n = new NotecardDB(context);
                n.deleteThings(getQuestion);
                Toast.makeText(activity, "Question unstarred.",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent("com.ayushcoding.www.jclapp.Notecards");
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.deleteCard) {
            Context context = getApplicationContext();
            NotecardDB notecardDB = new NotecardDB(context);
            Intent intent = getIntent();
            String getQuestion = intent.getStringExtra("question");
            notecardDB.deleteThings(getQuestion);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
