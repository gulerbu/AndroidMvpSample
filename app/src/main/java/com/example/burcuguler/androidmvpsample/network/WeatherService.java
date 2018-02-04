package com.example.burcuguler.androidmvpsample.network;

import com.example.burcuguler.androidmvpsample.network.model.Location;
import com.example.burcuguler.androidmvpsample.network.model.LocationWeatherInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by burcuguler on 02/01/2018.
 */

public interface WeatherService {

    @GET("api/location/search/")
    Call<List<Location>> getLocations(@Query("query") String location);

    @GET("api/location/{woeid}/")
    Call<LocationWeatherInfo> getLocationWeatherInfo(@Path("woeid") int woeid);

}
