package com.example.apple.project2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import java.util.Date;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsFragment extends Fragment {

    public final String AppID = "1b978a6e60712d3738288dd41f9cac17";
    public final String BASE_URL = "http://api.openweathermap.org";

  /*  @BindView(R.id.latitudeTextView)
    TextView latitudeTextView;
    @BindView(R.id.longitudeTextView)
    TextView longitudeTextView;
    @BindView(R.id.countryTextView)
    TextView countryTextView;
    @BindView(R.id.descriptionTextView)
    TextView descriptionTextView;
    @BindView(R.id.tempTextView)
    TextView tempTextView;
    @BindView(R.id.humidityTextView)
    TextView humidityTextView;
    @BindView(R.id.tempMinTextView)
    TextView tempMinTextView;
    @BindView(R.id.tempMaxTextView)
    TextView tempMaxTextView;
    @BindView(R.id.speedTextView)
    TextView speedTextView;
    @BindView(R.id.nameTextView)
    TextView nameTextView;*/
    @BindView(R.id.change)
    TextView change;

    private ProgressDialog mProgressDialog;
    private ViewPager mCategoriesViewPager;
    private TabLayout tabLayout;
    private View mViewHome;
    String CITY;
    View view;
    Context mContext;
    ViewGroup rootView,changeView;


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    static String LAT,LON,CON,DES,TEMP,HUM,TMIN,TMAX,SP,NM;

    public DetailsFragment() {
// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater
                .inflate(R.layout.recycler_view, container, false);



        weatherUpdate();
        viewRec();



        return rootView;
    }

   public void updateView(boolean success,Object message){

        weatherUpdate();
        viewRec();
    }
    public void viewRec()
    {
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

        String[] fieldArray = {"Latitude:", "Longitude:", "Country:", "Description:", "Temp:", "Humidity:", "Min Temp:","Max Temp:", "Speed:", "City:",};
        String[] entryArray = {DetailsFragment.LAT, DetailsFragment.LON, DetailsFragment.CON, DES, TEMP+"°C", HUM+"%", TMIN+"°C", TMAX+"°C", SP+"kmph", NM};

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.fieldArray.length; i++) {
            data.add(new DataModel(
                    fieldArray[i],
                    entryArray[i],

                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }
        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);

    }

    public void onClickMethod(View v)
    {
        // do something
    }

    public void weatherUpdate(){



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

        WeatherService weatherService = retrofit.create(WeatherService.class);

        Call<WeatherInfo> weatherInfoCall = weatherService.getWeatherInfo(CITY, AppID);

        weatherInfoCall.enqueue(new Callback<WeatherInfo>() {

            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                showProgressDialog(false);
                String TAG = "MyActivity";
                Log.i(TAG, "DETAILS RESPONSE" );
                onDisplayWeatherInfo(response.body());

                showProgressDialog(false);            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                showProgressDialog(false);
                Toast.makeText(getActivity(), R.string.fetching_weather_info_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void showProgressDialog(boolean show) {
        if (show) {
            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } else {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        }
    }


    public void changeCity(String city){
        mContext = getActivity();
        KeyValueDB.setCity(mContext, city);
        CITY=city;
        weatherUpdate();
    }
    double f,c;
    String humid,temp,speed,countryname,cityname;
    private void onDisplayWeatherInfo(WeatherInfo weatherInfo) {
        String TAG = "MyActivity";
        Log.i(TAG, "DETAILS UI" );
        if (weatherInfo != null) {
            String TAG1 = "MyActivity";
            Log.i(TAG1, "DETAILS UI TEXT" );
            LAT=String.valueOf(weatherInfo.coord.lat);
            LON=String.valueOf(weatherInfo.coord.lon);


            CON=String.valueOf(weatherInfo.sys.country);
            DES=String.valueOf(weatherInfo.weather[0].description);
            temp=String.valueOf(String.format("%.2f",weatherInfo.main.temp-273.15));
            TEMP=String.valueOf(String.format("%.2f",weatherInfo.main.temp-273.15));

             humid=String.valueOf(weatherInfo.main.humidity);
            HUM=String.valueOf(String.format("%.2f",weatherInfo.main.humidity));

            TMIN=String.valueOf(String.format("%.2f",weatherInfo.main.temp_min-273.15));
            TMAX=String.valueOf(String.format("%.2f",weatherInfo.main.temp_max-273.15));
            cityname=(String.valueOf(weatherInfo.name));
            NM=String.valueOf(weatherInfo.name);
             countryname=(String.valueOf(weatherInfo.sys.country));

            SP=speed=String.valueOf(weatherInfo.wind.speed);

            double sunr=weatherInfo.sys.sunrise;
            double suns=weatherInfo.sys.sunset;
            double ID=weatherInfo.weather[0].id;
            updateUI();
            viewRec();
            setWeatherIcon(ID,sunr*1000,suns*100);
        }
    }
    public void setWeatherIcon(double actualId,double sunr,double suns)
    {
            double id = actualId / 100;
    String icon = "";
        if(actualId == 800) {
            long currentTime = new Date().getTime();
            if (currentTime >= sunr && currentTime < suns) {
                icon = "weather_sunny";
                icon = "weather_clear_night";
            }
        }
       /* else {
        switch(id) {
            case 2 : icon = getActivity().getString(R.string.weather_thunder);
                break;
            case 3 : icon = getActivity().getString(R.string.weather_drizzle);
                break;
            case 7 : icon = getActivity().getString(R.string.weather_foggy);
                break;
            case 8 : icon = getActivity().getString(R.string.weather_cloudy);
                break;
            case 6 : icon = getActivity().getString(R.string.weather_snowy);
                break;
            case 5 : icon = getActivity().getString(R.string.weather_rainy);
                break;*/
       // }
    }


    public void updateUI()
    {
        f=Double.parseDouble(temp);
        c= (f-273.15);
        temp = String.valueOf(c);
        mContext=getActivity();
        KeyValueDB.setTemp(mContext, temp);
        mContext=getActivity();
        KeyValueDB.setHumidity(mContext, humid);
        mContext=getActivity();
        KeyValueDB.setCity(mContext, cityname);
        mContext=getActivity();
        KeyValueDB.setCountry(mContext, countryname);
        mContext=getActivity();
        KeyValueDB.setSpeed(mContext, speed);
    }


}