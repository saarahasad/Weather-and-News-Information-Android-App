package com.example.apple.project2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

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
public class ListContentFragment extends Fragment {

    public final String AppID = "1b978a6e60712d3738288dd41f9cac17";
    public final String BASE_URL = "http://api.openweathermap.org";

    String CITY;
    String desc;
    String h,p;

    @BindView(R.id.city_field)
    TextView cityText;
    @BindView(R.id.temp_field)
    TextView tempText;

    @BindView(R.id.humditity_field)
    TextView detailText;


    @BindView(R.id.weather_icon)
    ImageView weatherimage;


    @BindView(R.id.change)
    TextView change;

    double c;
    Context mContext;
    ViewGroup rootView;
    View view;
    ImageButton button1;
    boolean success;Object message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater
                .inflate(R.layout.item_list, container, false);
        ButterKnife.bind(this, rootView);

         button1 = (ImageButton) rootView.findViewById(R.id.Settingbutton);
        button1.setOnClickListener(new OnClickListener() {


                public void onClick(View v) {
                       /*     Intent intent = new Intent(getActivity(), MenuActivity.class);
                        Bundle bundle = new Bundle();
                        intent.putExtras(bundle);
                        startActivity(intent);*/

                    //Creating the instance of PopupMenu
                    PopupMenu popup = new PopupMenu(getActivity(), button1);
                    //Inflating the Popup using xml file
                    popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

                    //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            Toast.makeText(getActivity(),"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                            // TODO Auto-generated method stub
                            getActivity().finish();
                            System.exit(0);
                            return true;
                        }
                    });

                    popup.show();//showing popup menu
                }



        });//closing the setOnClickListener method


    fonts();
        detailText = (TextView) rootView.findViewById(R.id.humditity_field);
       p="print desc";
        weatherUpdate();



        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivity(intent);
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Change city");

                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setNeutralButton("View Map", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        changeCity(input.getText().toString());
                        final String temp=input.getText().toString();
                      //  change.setText(temp);
                        String tagName = "android:switcher:" + R.id.viewpager + ":" + 2; // Your pager name & tab no of Second Fragment
                        DetailsFragment f2 = (DetailsFragment) getActivity().getSupportFragmentManager().findFragmentByTag(tagName);
                        f2.weatherUpdate();;
                        f2.viewRec();
                        String tagName1 = "android:switcher:" + R.id.viewpager + ":" + 3; // Your pager name & tab no of Second Fragment
                        ForecastFragment f1 = (ForecastFragment) getActivity().getSupportFragmentManager().findFragmentByTag(tagName1);
                        f1.weatherUpdate();

                        Intent intent = new Intent(getActivity(), MapsActivity.class);
                        Bundle bundle = new Bundle();
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
                builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        changeCity(input.getText().toString());
                        final String temp=input.getText().toString();
                        //  change.setText(temp);
                        String tagName = "android:switcher:" + R.id.viewpager + ":" + 2; // Your pager name & tab no of Second Fragment
                        DetailsFragment f2 = (DetailsFragment) getActivity().getSupportFragmentManager().findFragmentByTag(tagName);
                        f2.weatherUpdate();;
                        f2.viewRec();
                        String tagName1 = "android:switcher:" + R.id.viewpager + ":" + 3; // Your pager name & tab no of Second Fragment
                        ForecastFragment f1 = (ForecastFragment) getActivity().getSupportFragmentManager().findFragmentByTag(tagName1);
                        f1.weatherUpdate();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                builder.show();*/
            }
        });


        detailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p.equals("print desc"))
                {
                    detailText.setText(desc);
                    p="print humid";
                }
                else if(p.equals("print humid")){

                    detailText.setText(h);
                    p="print desc";
                }

            }
        });

        return rootView;

    }
    public void fonts()
    {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "LR.ttf");
        cityText.setTypeface(font);
        tempText.setTypeface(font);
        detailText.setTypeface(font);
        change.setTypeface(font);

    }
    public void changeCity(String city){
        mContext = getActivity();
        KeyValueDB.setCity(mContext, city);
        CITY=city;
        weatherUpdate();
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(getActivity(),v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());
        popup.show();
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

        WeatherService weatherService = retrofit.create(WeatherService.class);

        Call<WeatherInfo> weatherInfoCall = weatherService.getWeatherInfo(CITY, AppID);

        weatherInfoCall.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                onDisplayWeatherInfo(response.body());
                String tagName = "android:switcher:" + R.id.viewpager + ":" + 2; // Your pager name & tab no of Second Fragment
                DetailsFragment f2 = (DetailsFragment) getActivity().getSupportFragmentManager().findFragmentByTag(tagName);
                f2.weatherUpdate();;
                f2.viewRec();
                          }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(getActivity(), R.string.fetching_weather_info_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void onDisplayWeatherInfo(WeatherInfo weatherInfo) {
        if (weatherInfo != null) {
            String TAG = "MyActivity";
            Log.i(TAG, "LIST UI" );
            mContext=getContext();
            KeyValueDB.setLat(mContext,String.valueOf(weatherInfo.coord.lat));
            KeyValueDB.setLon(mContext,String.valueOf(weatherInfo.coord.lon));

            desc=String.valueOf(weatherInfo.weather[0].description);
           String cityname=(String.valueOf(weatherInfo.name));
           String countryname=(String.valueOf(weatherInfo.sys.country));
            cityname.toUpperCase();
            cityname.toUpperCase();
            countryname.toUpperCase();
            cityText.setText(cityname+" , "+countryname);
            detailText.setText("Humidity"+"     "+String.valueOf(weatherInfo.main.humidity)+"%\nSpeed         "+String.valueOf(weatherInfo.wind.speed)+" kmph");
            h="Humidity"+"     "+String.valueOf(weatherInfo.main.humidity)+"%\nSpeed          "+String.valueOf(weatherInfo.wind.speed)+" kmph";

            double temp=weatherInfo.main.temp;
            String choiceunit=KeyValueDB.getUnit(getContext());
            if("celsius".equals(choiceunit)) {
                c = (temp - 273.15);
                tempText.setText(String.format("%.2f", c)+"°C");

            }
            else {
                c = 1.8 * (temp - 273) + 32;
                tempText.setText(String.format("%.2f", c) + "°F");
            }


            double sunr=weatherInfo.sys.sunrise;
            double suns=weatherInfo.sys.sunset;
            double ID=weatherInfo.weather[0].id;
            setWeatherIcon(ID,sunr*1000,suns*1000);
        }
    }
    public void setWeatherIcon(double actualId,double sunr,double suns)
    {
        int id =(int) actualId / 100;
        String icon = "";
        AlphaAnimation blinkanimation= new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
        blinkanimation.setDuration(60000); // duration - half a second
        blinkanimation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        blinkanimation.setRepeatCount(1); // Repeat animation infinitely
        RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE); //Repeat animation indefinitely
        anim.setDuration(20000); //Put desired duration per anim cycle here, in milliseconds


        if(actualId == 800) {
            double currentTime = new Date().getTime();
            if (currentTime >= sunr && currentTime < suns) {
                weatherimage.setImageResource(R.drawable.weather_sunny);
                weatherimage.startAnimation(anim);

            }
            else {
                weatherimage.setImageResource(R.drawable.weather_clear_night);
                weatherimage.startAnimation(anim);
            }
        }
        else {
            TranslateAnimation animation = new TranslateAnimation(-950,950, 0, 0); // new TranslateAnimation (float fromXDelta,float toXDelta, float fromYDelta, float toYDelta)
            animation.setDuration(18000); // animation duration
            animation.setRepeatCount(Animation.INFINITE); // animation repeat count if u repeat only once set to 1 if u don't repeat set to 0
            animation.setFillAfter(true);

        switch(id) {

            case 2 :weatherimage.setImageResource(R.drawable.weather_thunder);
                weatherimage .startAnimation(animation);//your_view for mine is imageView

                break;
            case 3 : weatherimage.setImageResource(R.drawable.weather_drizzle);
                weatherimage .startAnimation(animation);//your_view for mine is imageView

                break;
            case 7 :weatherimage.setImageResource(R.drawable.weather_foggy);
                weatherimage .startAnimation(animation);//your_view for mine is imageView

                break;
            case 8 : weatherimage.setImageResource(R.drawable.weather_cloudy);
                weatherimage .startAnimation(animation);//your_view for mine is imageView

                break;
            case 6 : weatherimage.setImageResource(R.drawable.weather_snowy);
                weatherimage .startAnimation(animation);//your_view for mine is imageView

                break;
            case 5 : weatherimage.setImageResource(R.drawable.weather_rainy);
                weatherimage .startAnimation(animation);//your_view for mine is imageView
                break;
                }
         }
    }



}