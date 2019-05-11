package com.example.apple.project2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import butterknife.ButterKnife;


public class LocationSearchFragment extends Fragment implements
        GoogleApiClient.OnConnectionFailedListener {
    ViewGroup rootView;
    String TAG="Location Search:";
    private FragmentActivity myContext;

    PlaceAutocompleteFragment places;

    private Context context;    private GoogleApiClient mGoogleApiClient;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.place_search, container, false);


        mGoogleApiClient = new GoogleApiClient
                .Builder(rootView.getContext())
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .build();


         places= (PlaceAutocompleteFragment)
                getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
                .build();
        places.setFilter(typeFilter);
        places.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {

                Toast.makeText(getContext(),place.getName(),Toast.LENGTH_SHORT).show();
                Context mContext=getContext();
                KeyValueDB.setCity(mContext, String.valueOf(place.getName()));

                String tagName0 = "android:switcher:" + R.id.viewpager + ":" + 1; // Your pager name & tab no of Second Fragment
                ListContentFragment f0 = (ListContentFragment) getActivity().getSupportFragmentManager().findFragmentByTag(tagName0);
                f0.weatherUpdate();;

                String tagName = "android:switcher:" + R.id.viewpager + ":" + 2; // Your pager name & tab no of Second Fragment
                DetailsFragment f2 = (DetailsFragment) getActivity().getSupportFragmentManager().findFragmentByTag(tagName);
                f2.weatherUpdate();;
                f2.viewRec();
                String tagName1 = "android:switcher:" + R.id.viewpager + ":" +3; // Your pager name & tab no of Second Fragment
                ForecastFragment f1 = (ForecastFragment) getActivity().getSupportFragmentManager().findFragmentByTag(tagName1);
                f1.weatherUpdate();
            }

            @Override
            public void onError(Status status) {

                Toast.makeText(getContext(),status.toString(),Toast.LENGTH_SHORT).show();

            }
        });

        ButterKnife.bind(this, rootView);
        return rootView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        places = (PlaceAutocompleteFragment) getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        if (places != null)
        {
            getActivity().getFragmentManager().beginTransaction().remove(places).commitAllowingStateLoss();
        }

        places = null;
    }
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // An unresolvable error has occurred and a connection to Google APIs
        // could not be established. Display an error message, or handle
        // the failure silently

        // ...
    }
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}