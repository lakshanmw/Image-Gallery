package com.example.lakshan.imagegallary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;




public class onImageClickActivity extends AppCompatActivity {

    ArrayList<String> favlist;
    ImageView imageView;
    EditText editText;
    String img_description;
    ArrayList<HashMap<String,String>> imgdetails;
    HashMap<String,String> map;
    Button button;
    String img_url;
    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_image_click);

        sharedPreference = new SharedPreference();
        imageView= (ImageView) findViewById(R.id.clicked_im);
        editText= (EditText) findViewById(R.id.description_text);
        button= (Button) findViewById(R.id.button);
       //  this.img_description=editText.getText().toString();
        System.out.println("fjffffff_jgjg"+editText.getText().toString());


       Intent i = getIntent();
        final int position = i.getExtras().getInt("id");
          img_url = i.getExtras().getString("img_url");
        System.out.println("fjffffff"+img_url);

        Picasso.with(getApplicationContext()).load(img_url).into(imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_description=editText.getText().toString();
                System.out.println("fjffffff_jgjg"+editText.getText().toString());

                sharedPreference.addFavorite(getApplicationContext(),new FavoriteImageModel(img_url,img_description));
                Toast.makeText(onImageClickActivity.this, "image is added to the favorites", Toast.LENGTH_SHORT).show();
                Intent newintent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(newintent);

            }
        });

    }


}
