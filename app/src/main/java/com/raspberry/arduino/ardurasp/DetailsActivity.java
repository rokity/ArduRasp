package com.raspberry.arduino.ardurasp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.ortiz.touch.TouchImageView;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class DetailsActivity extends ActionBarActivity {




    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapterDetails adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Board","Technical Specifications"};
    int Numboftabs =2;


    public String title = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        title = getIntent().getStringExtra("title");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        creatToolBar();












    }



































        public void creatToolBar(){
            toolbar = (Toolbar) findViewById(R.id.tool_bar_details);
            setSupportActionBar(toolbar);


            adapter =  new ViewPagerAdapterDetails(getSupportFragmentManager(),Titles,Numboftabs,title,getPackageName(),this);


            pager = (ViewPager) findViewById(R.id.pager_details);
            pager.setAdapter(adapter);


            tabs = (SlidingTabLayout) findViewById(R.id.tabs_details);
            tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

            // Setting Custom Color for the Scroll bar indicator of the Tab View


            // Setting the ViewPager For the SlidingTabsLayout
            tabs.setViewPager(pager);


        }







































}