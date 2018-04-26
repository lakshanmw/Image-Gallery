package com.example.lakshan.imagegallary;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lakshan on 4/25/2018.
 */

public class gsonmodel {

    String strDrink;
    String strDrinkThumb;
    String idDrink;


    public gsonmodel(String strDrink, String strDrinkThumb, String idDrink) {
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.idDrink = idDrink;
    }

    @SerializedName("strDrink")
    public String getStrDrink() {
        return strDrink;
    }

    @SerializedName("strDrink")
    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    @SerializedName("strDrinkThumb")
    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    @SerializedName("strDrinkThumb")
    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    @SerializedName("idDrink")
    public String getIdDrink() {
        return idDrink;
    }

    @SerializedName("idDrink")
    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }
//    String name;
//    String realname;
//
//    public gsonmodel(String name, String realname) {
//        this.name = name;
//        this.realname = realname;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getRealname() {
//        return realname;
//    }
//
//    public void setRealname(String realname) {
//        this.realname = realname;
//    }








}
