package com.example.lakshan.imagegallary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Lakshan on 4/24/2018.
 */

public class GridAdapter extends BaseAdapter {

    Context mcontext;
    Integer[] image_id ;
    ImageView imageView;
    LayoutInflater inflater;
    ArrayList<gsonmodel> drinklist=new ArrayList<>();

    public GridAdapter(Context context,ArrayList<gsonmodel> drinklist ) {
        mcontext=context;
        this.drinklist=drinklist;
    }

    @Override
    public int getCount() {

        //return drinklist.size();
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.grid_item, parent, false);

        imageView = (ImageView) itemView.findViewById(R.id.imageView);
      //  imageView.setImageDrawable(image_id[position]);
       // imageView.setImageResource(image_id[position]);
       // Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        Picasso.with(mcontext).load(drinklist.get(position).getStrDrinkThumb()).into(imageView);
//        imageView.setImageDrawable(res);
        return itemView;
    }
}
