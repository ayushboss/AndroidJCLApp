package com.ayushcoding.www.jclapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by akhil on 7/9/16.
 */
public class CreditRecyclerAdapter extends  RecyclerView.Adapter<CreditRecyclerViewHolder> {


    String[] title = {"Iconography", "Lead Android Developer", "Lead IOS Developer", "Study Guide Help"};
    String[]sub = {"icons8.com", "Ayush Suresh", "Akhil Mandalapu", "Florida Junior Classical League"};
    int[] img = {R.drawable.icons8,R.drawable.android,R.drawable.ios,R.drawable.study};

    Context context;
    LayoutInflater inflater;

    public CreditRecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public CreditRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list, parent, false);

        CreditRecyclerViewHolder viewHolder=new CreditRecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CreditRecyclerViewHolder holder, int position) {

        holder.tv1.setText(title[position]);
        holder.tv2.setText(sub[position]);
        holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.md_deep_purple_500));
        holder.img.setImageResource(img[position]);
    }





    @Override
    public int getItemCount() {
        return title.length;
    }
}
