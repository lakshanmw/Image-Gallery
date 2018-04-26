package com.example.lakshan.imagegallary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lakshan on 4/26/2018.
 */

public class SharedPreference {

    public static final String PREFS_NAME = "IMAGE_GALLARY_APP";
    public static final String FAVORITES = "Favorite_Images";

    public SharedPreference() {
        super();
    }

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<FavoriteImageModel> favorites) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, FavoriteImageModel product) {
        List<FavoriteImageModel> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<FavoriteImageModel>();
        System.out.println("add favorite called");
        favorites.add(product);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, FavoriteImageModel product) {
        ArrayList<FavoriteImageModel> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(product);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<FavoriteImageModel> getFavorites(Context context) {
        SharedPreferences sharedPreferences;
        List<FavoriteImageModel> favorites;

        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(FAVORITES)) {
            String jsonFavorites = sharedPreferences.getString(FAVORITES, null);
            Gson gson = new Gson();
            FavoriteImageModel[] favoriteItems = gson.fromJson(jsonFavorites,
                    FavoriteImageModel[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<FavoriteImageModel>(favorites);
        } else
            return null;

        return (ArrayList<FavoriteImageModel>) favorites;
    }

}
