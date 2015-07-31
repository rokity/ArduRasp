package com.raspberry.arduino.ardurasp;

import android.app.Activity;
import android.graphics.Bitmap;

import android.os.Bundle;

import android.widget.TextView;

import com.ortiz.touch.TouchImageView;


public class DetailsActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        String title = getIntent().getStringExtra("title");

        Bitmap bitmap = Global.img;

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);




        TouchImageView img = (TouchImageView) findViewById(R.id.img);
        img.setImageBitmap(bitmap);



    }



















}