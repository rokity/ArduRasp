package com.raspberry.arduino.ardurasp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by riccardo on 24/08/15.
 */
@SuppressLint("ValidFragment")
public class Tab4 extends Fragment {
    String packageName;
    String title;
    Context context;

    @SuppressLint("ValidFragment")
    public Tab4(String t,String p,Context c){
        super();
        this.title=t;
        this.packageName=p;
        this.context=c;
    }
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =(View)inflater.inflate(R.layout.tab_4,container,false);

        TableLayout ll = (TableLayout) v.findViewById(R.id.displayLinear);
            createDetailsTab();

        for (int i = 0; i <names.size(); i++) {

            TableRow row= new TableRow(this.context);

        /*   LinearLayout.LayoutParams params1 =
                    new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

            params1.setMargins(4, 4, 4, 4);
              row.setLayoutParams(params1); */
            ll.setColumnShrinkable(1,true);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            lp.setMargins(3, 3, 3,3);
            row.setLayoutParams(lp);
            row.setBackgroundResource(R.drawable.table);



           TextView tv = new TextView(this.context);
            tv.setText(names.get(i));

            tv.setTextColor(Color.BLACK);




       TextView qty = new TextView(this.context);
            qty.setText(value[i]);
            qty.setMaxLines(20);
            qty.setEllipsize(null);
            qty.setSingleLine(false);
            qty.setTextColor(Color.BLACK);
            row.addView(tv);

            row.addView(qty);

            ll.addView(row,i);
        }
        return v;
    }








ArrayList<String> names;
String[] value;


    public void createDetailsTab(){

         names=getName().get(0);
        int id = getResourceId(title.toLowerCase().replace(" ", "_"), "array", this.packageName);
        Resources res = getResources();
       value = res.getStringArray(id);

       ;

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


    public ArrayList<ArrayList<String>> getName(){
            Log.d("title", title);
            Log.d("NAME ARRAY",title.toLowerCase().replace(" ", "_"));



        ArrayList<ArrayList<String>> names=new ArrayList<ArrayList<String>>();
        try {
            XmlPullParser xpp=getResources().getXml(R.xml.details);

            while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType()==XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("array")&&(xpp.getAttributeValue(0).equals(title.toLowerCase().replace(" ", "_")))) {
                        ArrayList<String> array=new ArrayList<String>();
                        System.out.println("NAME ARRAY"+xpp.getAttributeValue(0));

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
                    .makeText(this.context, "Request failed: " + t.toString(), Toast.LENGTH_LONG)
                    .show();

            return null;
        }
        return names;
    }



}
