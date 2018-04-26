package com.example.lakshan.imagegallary;

import java.util.ArrayList;
import java.util.HashMap;




/**
 * Created by Lakshan on 4/26/2018.
 */

public class FavoriteImageModel{

    String img_url;
    String description;

    public FavoriteImageModel(String img_url, String description) {
        this.img_url = img_url;
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
