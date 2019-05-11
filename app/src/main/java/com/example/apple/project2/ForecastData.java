package com.example.apple.project2;

import android.content.Context;
import android.os.Bundle;

public class ForecastData extends ForecastFragment {
    Context mContext = getContext();
    String C=KeyValueDB.getCity(mContext);
    static String[] nameArray = {ForecastFragment.d1, ForecastFragment.d2, ForecastFragment.d3,ForecastFragment.d4,ForecastFragment.d5,d6,d7,d8,d9,d10};
    static String[] minArray = {min1, min2,min3,min4,min5,min6,min7,min8,min9,min10};
    static String[] maxArray ={max1,max2,max3,max4,max5,max6,max7,max8,max9,max10};
    static String[] iconArray={i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};
  //  static Integer[] drawableArray = {R.drawable.weather_clear_night, R.drawable.weather_clear_night, R.drawable.weather_clear_night,
 //           R.drawable.weather_clear_night, R.drawable.weather_clear_night, R.drawable.weather_clear_night, R.drawable.weather_clear_night,
   //         R.drawable.weather_clear_night, R.drawable.weather_clear_night, R.drawable.weather_clear_night};

    static Integer[] id_ = {0, 1, 2, 3, 4,5,6,7,8,9};
    static String[] descArray={"x","x","x","x","x","x","x","x","x","x"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}