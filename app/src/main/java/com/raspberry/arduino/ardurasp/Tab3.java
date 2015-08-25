package com.raspberry.arduino.ardurasp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ortiz.touch.TouchImageView;

/**
 * Created by riccardo on 24/08/15.
 */
@SuppressLint("ValidFragment")
public class Tab3 extends Fragment {



    String title;
    String packageName;


    @SuppressLint("ValidFragment")
    public Tab3(String t,String p)
    {       super();
        this.title=t;
        this.packageName=p;

    }










    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =(View)inflater.inflate(R.layout.tab_3,container,false);
        createImageTab(v);
        return v;
    }


    public void createImageTab(View view){




        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        titleTextView.setText(title);



        int id_picture=getResourceId(title.toLowerCase().replace(" ", "_"), "drawable",this.packageName );
        TouchImageView img = (TouchImageView) view.findViewById(R.id.img);
        img.setImageResource(id_picture);
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
