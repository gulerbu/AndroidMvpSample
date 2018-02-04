package com.example.burcuguler.androidmvpsample.util;

import android.content.res.Resources;
import android.text.TextUtils;

import com.example.burcuguler.androidmvpsample.R;
import com.example.burcuguler.androidmvpsample.weather.WeatherState;

import static com.example.burcuguler.androidmvpsample.weather.WeatherState.CLEAR;

/**
 * Created by burcuguler on 28.01.2018.
 */

public final class WeatherUtil {

    public static String getTemperatureAsText(Resources resources, double temperature) {
        return resources.getString(R.string.temperature_with_sign, (int) temperature);
    }

    public static String getMinMaxTemperatureAsText(Resources resources, double minTemp, double maxTemp) {

        return resources.getString(R.string.temperature_with_sign, (int) minTemp)
                + "/"
                + resources.getString(R.string.temperature_with_sign, (int) maxTemp);

    }

    public static WeatherState getWeatherState(String weatherStateAbbr) {

        for (WeatherState state : WeatherState.values()) {
            if (TextUtils.equals(state.getWeatherStateAbbr(), weatherStateAbbr)) {
                return state;
            }
        }

        return CLEAR;

    }

}
