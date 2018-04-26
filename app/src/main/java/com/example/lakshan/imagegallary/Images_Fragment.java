package com.example.lakshan.imagegallary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lakshan on 4/25/2018.
 */

public class Images_Fragment extends Fragment {

    private static final String TAG="Images_Fragment";
    ArrayList<gsonmodel> drinklist1;
    View view;
    GridView gridView;
    GridAdapter gridAdapter;
    Context context;
    ArrayList<gsonmodel> copy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.images_layout,container,false);

        //Creating a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        //creating the api interface
        Api api = retrofit.create(Api.class);

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<DrinkList> call = api.getHeroes();
        Log.d("url",call.request().url().toString());

        call.enqueue(new Callback<DrinkList>() {
            @Override
            public void onResponse(Call<DrinkList> call, retrofit2.Response<DrinkList> response) {
                System.out.println(response.body().getDrinklist().size());
                // drinklist1=new ArrayList<gsonmodel>();
                drinklist1=response.body().getDrinklist();
                 copy = (ArrayList<gsonmodel>) drinklist1.clone();
                System.out.println("2nd url :"+response.body().getDrinklist().get(2).getStrDrinkThumb());
                System.out.println("2nd url :"+drinklist1.get(3).getStrDrinkThumb());
                gridView= (GridView) view.findViewById(R.id.grid);
                gridAdapter =new GridAdapter(getActivity(),drinklist1);
                gridView.setAdapter(gridAdapter);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i = new Intent(getActivity(), onImageClickActivity.class);
                        i.putExtra("id", position);
                        Singleton.getInstance().doSomething(copy.get(position).getStrDrinkThumb());
                        i.putExtra("img_url", copy.get(position).getStrDrinkThumb());
                        System.out.println("img_url inside onitemclick :"+copy.get(position).getStrDrinkThumb());
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Call<DrinkList> call, Throwable t) {

                Toast.makeText(getActivity(), "not worked", Toast.LENGTH_SHORT).show();

            }


        });



        return view;
    }
}
