package com.example.apple.project2;

import android.app.ProgressDialog;
import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provides UI for the view with Cards.
 */
    public class ForecastFragment extends Fragment {
    public final String AppID = "1b978a6e60712d3738288dd41f9cac17";
    public final String BASE_URL = "http://api.openweathermap.org" ;
    public final String COUNT ="10";


    ViewGroup rootView;
    String CITY;
    private ProgressDialog mProgressDialog;

    static String d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,max1,max2,max3,max4,max5,max6,max7,max8,max9,max10,min1,min2,min3,min4,min5,min6,min7,min8,min9,min10,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ForecastModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    String[] nameArray;
    String[] iconArray;
    String[] minArray;
    String[] descArray;
    String[] maxArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater
                .inflate(R.layout.recycler_view, container, false);
        weatherUpdate();
        return rootView;
    }
    private void onDisplayWeather(ForecastInformation forecastInfo) {
        if (forecastInfo != null) {
          //  d1=String.valueOf(forecastInfo.getList().get(0).getDt());
            String TAG = "MyActivity";

            Log.i(TAG, "d1: @@@ " +d1);
            DateFormat df = DateFormat.getDateTimeInstance();
            String updatedOn = df.format(new Date(forecastInfo.getList().get(0).getDt()*1000));
            Log.i(TAG, "DATE: @@ " +updatedOn);
            Date date = new Date();

            nameArray = new String[10];
            iconArray = new String[10];
            minArray=new String[10];
            maxArray=new String[10];
            descArray=new String[10];

            SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd.MM.yyyy");
            GregorianCalendar cal = new GregorianCalendar();

            for (int i = 0; i < 10; i++) {
                cal.setTime(date);
                cal.add(Calendar.DATE, i+1);
                Log.i("dateTag", sdf.format(cal.getTime()));
                nameArray[i]=String.valueOf(sdf.format(cal.getTime()));
                minArray[i]=String.valueOf("Min: "+String.format("%.2f",forecastInfo.getList().get(i).getTemp().getMin()-273.15));
                maxArray[i]=String.valueOf("Max: "+String.format("%.2f",forecastInfo.getList().get(i).getTemp().getMax()-273.15));
                descArray[i]=String.valueOf(forecastInfo.getList().get(i).getWeather().get(0).getDescription());
            }

            for( int i=0;i<10;i++)
           {
               iconArray[i]="w"+forecastInfo.getList().get(i).getWeather().get(0).getIcon();
               Log.d(TAG,iconArray[i]);
           }
            viewRecycler();

        }
    }
    public void viewRecycler()
    {
        String TAG = "MyActivity";
        Log.d(TAG,"Recycler view forecast fragment");
        RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setMessage(getString(R.string.fetching_weather_info));
        mProgressDialog.setCancelable(false);


        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        data = new ArrayList<ForecastModel>();
        for (int i = 0; i < 10; i++) {
            data.add(new ForecastModel(
                    nameArray[i],
                    minArray[i],
                    maxArray[i],
                    ForecastData.id_[i],
                    iconArray[i],
                    descArray[i]
                  //  ForecastData.drawableArray[i]
            ));
            Log.d(TAG,"Image res:"+iconArray[i]);

        }
        Log.d(TAG,"Recycler view forecast fragment");
        Context mcontext =getContext();
        adapter = new ForecastAdapter(data,mcontext);
        recyclerView.setAdapter(adapter);

    }


    public void weatherUpdate(){

        ButterKnife.bind(this, rootView);


        Context mContext;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());

        mContext = getContext();

        String city = KeyValueDB.getCity(mContext);
        CITY=city;
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ForecastService forecastService = retrofit.create(ForecastService.class);

        Call<ForecastInformation> forecastInfoCall = forecastService.getForecastInfo(CITY,COUNT, AppID);

        forecastInfoCall.enqueue(new Callback<ForecastInformation>() {
            @Override
            public void onResponse(Call<ForecastInformation> call, Response<ForecastInformation> response) {
                onDisplayWeather(response.body());
            }

            @Override
            public void onFailure(Call<ForecastInformation> call, Throwable t) {
                String TAG = "MyActivity";
                Log.i(TAG, "FORECAST CaLL DOESNT WORK");
                Toast.makeText(getActivity(), R.string.fetching_weather_info_failure, Toast.LENGTH_SHORT).show();
            }
        });

    }


}

