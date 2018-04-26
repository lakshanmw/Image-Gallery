package com.example.lakshan.imagegallary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lakshan on 4/25/2018.
 */

public class Favorite_Image_Fragment extends Fragment{

    private static final String TAG="Favorite_Image_Fragment";


    SharedPreferences settings;
    SharedPreference sharedPreference;
    List<FavoriteImageModel> favorites;
    FavoritImageGridAdapter favoritImageGridAdapter;
    ListView fav_gridview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.favorite_image_layout,container,false);

        System.out.println("loading the faramennt");


        fav_gridview= (ListView) view.findViewById(R.id.fav_grid);
        // Get favorite items from SharedPreferences.
        sharedPreference = new SharedPreference();
        favorites = sharedPreference.getFavorites(getActivity());

        if (favorites == null) {
            Toast.makeText(getActivity(), "no favorites", Toast.LENGTH_SHORT).show();
        } else {

            if (favorites.size() == 0) {
                Toast.makeText(getActivity(), "no favorites", Toast.LENGTH_SHORT).show();

            }


            if (favorites != null) {
                favoritImageGridAdapter = new FavoritImageGridAdapter(getActivity(), favorites);
                fav_gridview.setAdapter(favoritImageGridAdapter);


            }
        }

        fav_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sharedPreference.removeFavorite(getActivity(), favorites.get(position));
                System.out.println("remove data"+favorites.get(position).getImg_url());

                Toast.makeText(getActivity(), "Image removed", Toast.LENGTH_SHORT).show();
                Intent newintent=new Intent(getActivity(),MainActivity.class);
                startActivity(newintent);

            }
        });


        return view;
    }
}
