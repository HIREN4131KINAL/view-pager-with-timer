package com.example.dhaval.viewpagerdemo;

import android.content.Context;
import android.content.SharedPreferences;


public class MyPreferences {
    public static  SharedPreferences preferences;
    public static  SharedPreferences.Editor editor;


    public static void init(Context context){
        preferences=context.getSharedPreferences("KandyCredentials", Context.MODE_PRIVATE);
        editor = preferences.edit();

    }

}
