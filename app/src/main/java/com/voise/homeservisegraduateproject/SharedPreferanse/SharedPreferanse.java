package com.voise.homeservisegraduateproject.SharedPreferanse;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;


public class SharedPreferanse {


    private static SharedPreferences mSharedPref;
    private SharedPreferences.Editor editor;
    private Context context;
    private static SharedPreferanse instance;
    private static final String PREF_NAME = "DATA";
    public static String APP_LANGUAGE = "APP_LANGUAGE";
    public static String IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH";
    public static String ID = "ID";
    public static String TOKEN = "TOKEN";
    public static String USER_TYPE = "USER_TYPE";
    public static String USERNAME = "USERNAME";
    public static String NAME = "NAME";
    public static String active = "NAME";
    public static String IMAGE = "IMAGE";
    public static String Note = "Note";
    public static String MOBILE = "MOBILE";
    public static String EMAIL = "EMAIL";
    public static String IMAGE_CATEGORIES = "IMAGE_CATEGORIES";
    public static String TITLE_CATEGORIES = "TITLE_CATEGORIES";
    public static String ID_CATEGORIES = "ID_CATEGORIES";
    public static final String SP_USER = "user";
    public static final String SP_API_TOKEN = "fcm_token";
    public static String PASSWORD = "PASSWORD";
    public static String ADDRESS = "ADDRESS";
    public static String CITY = "CITY";
    public static String CITY_Title = "CITY_Title";
    public static String Country_Title = "Country_Title";
    public static String Country = "Country";
    public static String YEAR = "YEAR";
    public static String LANT = "LANT";
    public static String LONG = "LONG";
    public static String PIC = "PIC";
    public static String LoginChoice = "LoginChoice";
    public static String Id_Details = "Id_Details";
    public static String PICKUP_LANT = "PICKUP_LANT";
    public static String PICKUP_LONG = "PICKUP_LONG";
    public static String DELIVER_LANT = "DELIVER_LANT";
    public static String DELIVER_LONG = "DELIVER_LONG";
    public static String DATE = "DATE";
    public static String Notification = "Notification";
    public static String GO = "go";

    public static void init(Context context) {
        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }
    private SharedPreferanse(Context context) {
        this.context = context;
        if (context != null) {
            mSharedPref = context.getSharedPreferences("app_sp", Context.MODE_PRIVATE);
            editor = mSharedPref.edit();
        }
    }

    public static SharedPreferanse getInstance(Context context) {
        if (instance == null)
            return new SharedPreferanse(context);

        return instance;
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }


    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public static Integer read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value).apply();
    }

    public static void clear() {
        mSharedPref.edit().clear().apply();
        write(SharedPreferanse.IS_FIRST_LAUNCH, false);
    }

}
