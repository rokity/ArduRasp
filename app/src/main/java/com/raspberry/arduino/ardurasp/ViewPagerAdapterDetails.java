package com.raspberry.arduino.ardurasp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class ViewPagerAdapterDetails extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    String title;
    String packageName;
    Context context;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapterDetails(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb,String t,String p,Context c) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.title=t;
        this.packageName=p;
        this.context=c;


    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            Tab3 tab1 = new Tab3(this.title,this.packageName);

            return tab1;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Tab4 tab2 = new Tab4(this.title,this.packageName,this.context);
            return tab2;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
