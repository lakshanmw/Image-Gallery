package com.example.lakshan.imagegallary;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lakshan on 4/25/2018.
 */

public class FavoritImageGridAdapter extends BaseAdapter {

    Context mcontext;
    ImageView imageView;
    LayoutInflater inflater;
    List<FavoriteImageModel> favorites;
    TextView description_tv;

    public FavoritImageGridAdapter(Context mcontext, List<FavoriteImageModel> favorites) {
        this.mcontext = mcontext;
        this.favorites = favorites;
        System.out.println("insidde adapter");
    }

    @Override
    public int getCount() {
        return favorites.size();
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
        View itemView = inflater.inflate(R.layout.fav_grid_item, parent, false);

        imageView = (ImageView) itemView.findViewById(R.id.fav_img);
        description_tv= (TextView) itemView.findViewById(R.id.description_tv);

        description_tv.setText(favorites.get(position).description);
        System.out.println(favorites.get(position).description);
        description_tv.setTextColor(Color.parseColor("#008000"));
        Picasso.with(mcontext).load(favorites.get(position).img_url).into(imageView);
//        imageView.setImageDrawable(res);
        return itemView;
    }
}
