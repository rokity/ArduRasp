package com.raspberry.arduino.ardurasp;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import com.ortiz.touch.TouchImageView;

import java.lang.reflect.Field;


public class DetailsActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);


        String title = getIntent().getStringExtra("title");



        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);




        String file=title.toLowerCase().replace(" ", "_");
        Log.d("FILE",file);
        int id=getResourceId(file, "drawable", getPackageName());



        TouchImageView img = (TouchImageView) findViewById(R.id.img);
        //  Bitmap bitmap = Global.img;

        //  img.setImageBitmap(bitmap);
        img.setImageResource(id);


    }





    public  int getResourceId(String pVariableName, String pResourcename, String pPackageName)
    {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }













}