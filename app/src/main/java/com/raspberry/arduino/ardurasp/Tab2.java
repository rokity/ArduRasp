package com.raspberry.arduino.ardurasp;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.Arrays;

public class Tab2 extends Fragment {

    private GridView grid_rasp;
    private GridViewAdapter gridAdapter_rasp;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = (View)inflater.inflate(R.layout.tab_2,container,false);
        grid_rasp = (GridView) v.findViewById(R.id.gridView_rasp);
        grid_rasp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent();
                intent.setClassName("com.raspberry.arduino.ardurasp", "com.raspberry.arduino.ardurasp.DetailsActivity");
                intent.putExtra("title", item.getTitle());
                Global.img = item.getImage();

                //Start details activity
                startActivity(intent);
            }
        });


        gridAdapter_rasp = new GridViewAdapter(this.getActivity(), R.layout.grid_item_layout, getData(R.array.raspberry_boards));
        grid_rasp.setAdapter(gridAdapter_rasp);
        Log.d("FINISH", "FINISG");
        return v;
    }

    private ArrayList<ImageItem> getData(int array) {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(array);
        String[] some_array = get_names_attribute(getResources().getStringArray(array));



        for (int i = 0; i < imgs.length(); i++) {



            Bitmap bitmap=decodeResource(getResources(), imgs.getResourceId(i, -1));
            TypedValue typedValue = new TypedValue();
            imageItems.add(new ImageItem(bitmap, some_array[i]));


        }
        return imageItems;
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }


    private static Bitmap decodeResource(Resources res, int id) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, id, options);
        options.inSampleSize = calculateInSampleSize(options, 100, 100);

      /*  for (options.inSampleSize = 1; options.inSampleSize <= 32; options.inSampleSize++) {
            try {
                bitmap = BitmapFactory.decodeResource(res, id, options);
                Log.d("INFO", "Decoded successfully for sampleSize " + options.inSampleSize);
                break;
            } catch (OutOfMemoryError outOfMemoryError) {
// If an OutOfMemoryError occurred, we continue with for loop and next inSampleSize value
                Log.e("INFO", "outOfMemoryError while reading file for sampleSize " + options.inSampleSize
                        + " retrying with higher value");
            }
        }
        */
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, id, options);

        // return bitmap;
    }



    public String[] get_names_attribute(String[] array){
        ArrayList<String> returns=new ArrayList<String>();
        for (String value : array) {
            String[] values=value.split("/")[2].split("_");
            String app="";
            for(String par : values)
                if (par.lastIndexOf(".") == -1)
                    app = app +par+' ';
                else
                    app = app +par.substring(0, par.lastIndexOf('.'));


            returns.add(app.toUpperCase());
        }
        return returns.toArray(new String[returns.size()]);
    }


}