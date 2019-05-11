package com.example.apple.project2;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyValueDB {
    private SharedPreferences sharedPreferences;
    private static String PREF_NAME = "prefs";

    public KeyValueDB() {
        // Blank
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static String getCity(Context context) {
        return getPrefs(context).getString("city", "bangalore");
    }

    public static void setCity(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("city", input);
        editor.commit();
    }

    public static String getUnit(Context context) {
        return getPrefs(context).getString("unit", "celsius");
    }

    public static void setUnit(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("city", input);
        editor.commit();
    }
    public static String getChannel(Context context) {
        return getPrefs(context).getString("channel", "bbc-news");
    }

    public static void setChannel(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("channel", input);
        editor.commit();
    }
    public static String getLat(Context context) {
        return getPrefs(context).getString("lat", "13.222");
    }

    public static void setLat(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("lat", input);
        editor.commit();
    }
    public static String getLon(Context context) {
        return getPrefs(context).getString("lon", "13.222");
    }

    public static void setLon(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("lon", input);
        editor.commit();
    }

    public static String getTemp(Context context) {
        return getPrefs(context).getString("temperature", "30");
    }

    public static void setTemp(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("temperature", input);
        editor.commit();
    }

    public  String getCountry(Context context) {
        return getPrefs(context).getString("country", "IN");
    }

    public static void setCountry(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("country", input);
        editor.commit();
    }

    public static String getHumidity(Context context) {
        return getPrefs(context).getString("humidity", "29");
    }

    public static void setHumidity(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("humidity", input);
        editor.commit();
    }

    public static String getSpeed(Context context) {
        return getPrefs(context).getString("speed", "29");
    }

    public static void setSpeed(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("speed", input);
        editor.commit();
    }

    public static String getImage(Context context) {
        return getPrefs(context).getString("image", "29");
    }

    public static void setImage(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("image", input);
        editor.commit();
    }
}