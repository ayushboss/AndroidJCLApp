package com.ayushcoding.www.jclapp;

/**
 * Created by akhil on 7/9/16.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class V1RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tv1,tv2;


    public V1RecyclerViewHolder(View itemView) {
        super(itemView);

        tv1= (TextView) itemView.findViewById(R.id.list_title);
        tv2= (TextView) itemView.findViewById(R.id.list_desc);


    }
}

