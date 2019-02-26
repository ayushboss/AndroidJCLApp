package com.ayushcoding.www.jclapp;

/**
 * Created by Ayush on 7/2/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class ImageListAdapter extends BaseAdapter{
    String [] result;
    String[]resultSub;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public ImageListAdapter(Credits mainActivity, String[] prgmNameList, int[] prgmImages, String[]sub) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        resultSub = sub;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    @Override
    public boolean isEnabled(int arg0)
    {
        return true;
    }
    public class Holder
    {
        TextView tv;
        TextView tvSub;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.image_list_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.titleImage);
        holder.tvSub=(TextView) rowView.findViewById(R.id.subIImage);
        holder.img=(ImageView) rowView.findViewById(R.id.imageViewCreditsAdapter);
        holder.tv.setText(result[position]);
        holder.tvSub.setText(resultSub[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (position == 0) {
                    Intent viewIntent =
                            new Intent("android.intent.action.VIEW",
                                    Uri.parse("https://icons8.com/"));
                    context.startActivity(viewIntent);

                }
                System.out.println("You Clicked : "+result[position]);
            }
        });
        return rowView;
    }

}