package com.example.burcuguler.androidmvpsample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by burcuguler on 02/01/2018.
 */

public class RetrofitClient {

    private final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.metaweather.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static WeatherService getWeatherService() {
        return retrofit.create(WeatherService.class);
    }
}
