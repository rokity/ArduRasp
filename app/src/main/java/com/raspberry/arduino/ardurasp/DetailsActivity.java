package com.raspberry.arduino.ardurasp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ortiz.touch.TouchImageView;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class DetailsActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);


        String title = getIntent().getStringExtra("title");



        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);
        Log.d("title", title);
        int id=getResourceId(title.toLowerCase().replace(" ", "_"), "array", getPackageName());
        Resources res = getResources();
        String[] values = res.getStringArray(id);
        //Context context = getApplicationContext();
       // InputStream istream = context.getResources().openRawResource(R.xml.details);
        ArrayList<ArrayList<String>> names=new ArrayList<ArrayList<String>>();
        try {
            XmlPullParser xpp=getResources().getXml(R.xml.details);

            while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType()==XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("array")&&(xpp.getAttributeValue(0).equals(title.toLowerCase().replace(" ", "_")))) {
                        ArrayList<String> array=new ArrayList<String>();
                        System.out.println("NAME ARRAY"+xpp.getAttributeValue(0));
                      array.add(xpp.getAttributeValue(0));
                        xpp.next();

                        while(xpp.getName().equals("item")){
                            array.add(xpp.getAttributeValue(0));
                          System.out.println(xpp.getAttributeValue(0));

                          xpp.next();
                          xpp.next();
                          xpp.next();





                      }
                        names.add(array);


                    }
                }

                xpp.next();
            }
        }
        catch (Throwable t) {
            Toast
                    .makeText(this, "Request failed: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }



        int id_picture=getResourceId(title.toLowerCase().replace(" ", "_"), "drawable", getPackageName());
        TouchImageView img = (TouchImageView) findViewById(R.id.img);
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