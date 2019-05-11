package com.example.apple.project2;

import android.content.Context;
import android.os.Bundle;

public class MyData extends DetailsFragment {
   Context mContext = getContext();
    String C=KeyValueDB.getCity(mContext);
    static String[] fieldArray = {"Latitude", "Longitude", "Country", "Description", "Temp", "Humidity", "Temperature Min","Temperature max", "Speed", "Name",};
    static String[] entryArray = {DetailsFragment.LAT, DetailsFragment.LON, DetailsFragment.CON, DES, TEMP, HUM, TMIN, TMAX, SP, NM};

    static Integer[] drawableArray = {R.drawable.weather_clear_night, R.drawable.weather_clear_night, R.drawable.weather_clear_night,
            R.drawable.weather_clear_night, R.drawable.weather_clear_night, R.drawable.weather_clear_night, R.drawable.weather_clear_night,
            R.drawable.weather_clear_night, R.drawable.weather_clear_night, R.drawable.weather_clear_night};

    static Integer[] id_ = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}