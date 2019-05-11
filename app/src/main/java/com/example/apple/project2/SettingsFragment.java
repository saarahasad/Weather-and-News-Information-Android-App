package com.example.apple.project2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

    public static final String KEY_TINT = "tempKey";
    public static final String KEY_USERNAME = "usernameKey";
    Activity act;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view != null) {
            view.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.white));
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Preference tintPreference = findPreference(KEY_TINT);
       // Preference usernamePreference = findPreference(KEY_USERNAME);

        SharedPreferences preferences = getDefaultSharedPreferences(getActivity());
        String TAG="Preffff";
        Log.d(TAG,"HELLO");
        String[] tintValues = getResources().getStringArray(R.array.listArray);
        if (preferences.contains(KEY_TINT)) {
            tintPreference.setSummary(preferences.getString(KEY_TINT, tintValues[1]));
            String choice=preferences.getString(KEY_TINT, tintValues[1]);
            KeyValueDB.setCity(getContext(), choice);
             TAG="Preffff";
            Log.d(TAG,choice);
            String tagName = "android:switcher:" + R.id.viewpager + ":" + 0; // Your pager name & tab no of Second Fragment


        }
      /*  if (preferences.contains(KEY_USERNAME)) {
            usernamePreference.setSummary(preferences.getString(KEY_USERNAME, ""));
        }*/

        tintPreference.setOnPreferenceChangeListener(this);
      //  usernamePreference.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        preference.setSummary(String.valueOf(newValue));
        String choice=String.valueOf(newValue);
        String TAG="Preffff";
        KeyValueDB.setCity(getContext(), choice);
        Log.d(TAG,choice);

        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);



        return true;
    }
}
