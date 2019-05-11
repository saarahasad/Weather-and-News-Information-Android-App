package com.example.apple.project2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastService {

    @GET("data/2.5/forecast/daily")
    Call<ForecastInformation> getForecastInfo(@Query("q") String city, @Query("cnt") String COUNT, @Query("appid") String appId);


}
