package com.ayushcoding.www.jclapp;

/**
 * Created by akhil on 7/9/16.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kundan on 10/26/2015.
 */
public class CreditRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tv1,tv2;
    ImageView img;

    public CreditRecyclerViewHolder(View itemView) {
        super(itemView);

        tv1= (TextView) itemView.findViewById(R.id.list_title);
        tv2= (TextView) itemView.findViewById(R.id.list_desc);

        img = (ImageView) itemView.findViewById(R.id.list_avatar);
    }
}

