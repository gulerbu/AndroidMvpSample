package com.example.burcuguler.androidmvpsample.weather;

import android.support.annotation.DrawableRes;

import com.example.burcuguler.androidmvpsample.R;

/**
 * Created by burcuguler on 28.01.2018.
 */

public enum WeatherState {
    CLEAR("sn", R.drawable.ic_clear),
    HAIL("hl", R.drawable.ic_hail),
    HEAVY_CLOUD("hc", R.drawable.ic_heavy_cloud),
    HEAVY_RAIN("hr", R.drawable.ic_heavy_rain),
    LIGHT_CLOUD("lc", R.drawable.ic_light_cloud),
    LIGHT_RAIN("lr", R.drawable.ic_light_rain),
    SHOWERS("s", R.drawable.ic_showers),
    SLEET("sl", R.drawable.ic_sleet),
    SNOW("sn", R.drawable.ic_snow),
    THUNDERSTORM("t", R.drawable.ic_thunderstorm);

    private String weatherStateAbbr;

    @DrawableRes
    private int weatherStateIconResId;


    WeatherState(String weatherStateAbbr, @DrawableRes int weatherStateIconResId) {
        this.weatherStateAbbr = weatherStateAbbr;
        this.weatherStateIconResId = weatherStateIconResId;

    }

    public int getWeatherStateIconResId() {
        return weatherStateIconResId;
    }

    public String getWeatherStateAbbr() {
        return weatherStateAbbr;
    }
}
