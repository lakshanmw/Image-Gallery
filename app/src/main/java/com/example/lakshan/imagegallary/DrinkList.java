package com.example.lakshan.imagegallary;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lakshan on 4/25/2018.
 */

public class DrinkList {

    @SerializedName("drinks")
    ArrayList<gsonmodel> drinklist;

    public ArrayList<gsonmodel> getDrinklist() {
        return drinklist;
    }

    public void setDrinklist(ArrayList<gsonmodel> drinklist) {
        this.drinklist = drinklist;
    }
}
