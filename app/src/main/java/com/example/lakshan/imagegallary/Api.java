package com.example.lakshan.imagegallary;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lakshan on 4/25/2018.
 */

public interface Api {

  //  String BASE_URL = "https://dog.ceo/api/breed/affenpinscher/";
  // String BASE_URL= "https://simplifiedcoding.net/demos/";
  //  http://dog.ceo/api/breed/affenpinscher/images
  String BASE_URL= "https://www.thecocktaildb.com/api/json/v1/1/" ;
    @GET("filter.php?a=Non_Alcoholic")
    Call<DrinkList> getHeroes();
}
