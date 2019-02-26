package com.ayushcoding.www.jclapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convention extends Activity {
    TextView nameCon, dateCon, loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convention);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String date = intent.getStringExtra("Date");
        String city = intent.getStringExtra("City");
        String state = intent.getStringExtra("State");
        System.out.println(name);
        System.out.println(date);
        System.out.println(city + ", " + state);
        nameCon = (TextView) findViewById(R.id.nameCon);
        dateCon = (TextView) findViewById(R.id.dateCon);
        loc = (TextView) findViewById(R.id.locCon);
        nameCon.setText(name);

        dateFormat(date);
        dateCon.setText(date);
        loc.setText(city + ", " + state);

    }

    public Date dateFormat(String date) {
        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
Date dateFormat = null;
        try {
            dateFormat = sourceFormat.parse(date);
            System.out.println(dateFormat + " THIS IS THE DATEFORMAT");
            return dateFormat;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat;

    }
}
