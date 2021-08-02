package com.voise.homeservisegraduateproject.SharedPreferanse;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferanse {


    private static SharedPreferences mSharedPref;
    private SharedPreferences.Editor editor;
    private Context context;
    private static SharedPreferanse instance;
    private static final String PREF_NAME = "DATA";
    public static String APP_LANGUAGE = "APP_LANGUAGE";
    public static String IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH";

    public static String IDCustomer = "IDCustomer";
    public static String IDProvider = "IDProvider";

    public static String TOKENProvider = "TOKENProvider";
    public static String TOKEN = "TOKEN";

    public static String USERNAMEProvider = "USERNAMEProvider";
    public static String USERNAMECustomer = "USERNAMECustomer";

    public static String IMAGEProvider = "IMAGEProvider";
    public static String IMAGECustomer = "IMAGECustomer";

    public static String MOBILEProvider = "MOBILEProvider";
    public static String MOBILECustomer = "MOBILECustomer";

    public static String EmailProvider = "EmailProvider";
    public static String EmailCustomer = "EmailCustomer";

    public static String WorkId = "WorkId";
    public static String active = "active";

    public static String LoginChoice = "LoginChoice";
    public static String RegisterChoice = "RegisterChoice";

    public static String NameCruft = "NameCruft";
    public static String IDCruft = "IDCruft";
    public static String p_y_a = "p_y_a";

    public static String Type_Complete_Pending_UnComplete = "IMAGE_CATEGORIES";
    public static int Position =  1;
    public static String gist = "gist";
    public static double Longitude =  1;
    public static double latitude =  1;
     public static String TITLE_CATEGORIES = "TITLE_CATEGORIES";
    public static String ID_CATEGORIES = "ID_CATEGORIES";
    public static final String SP_USER = "user";
    public static final String SP_API_TOKEN = "fcm_token";

     public static String CITY_Title = "CITY_Title";
    public static String Country_Title = "Country_Title";


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
    public static int read2(int key1, int defValue) {
        return mSharedPref.getInt(String.valueOf(key1), defValue);
    }
    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }
    public static void write2(int keys, int values) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(String.valueOf(keys), values);
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





















