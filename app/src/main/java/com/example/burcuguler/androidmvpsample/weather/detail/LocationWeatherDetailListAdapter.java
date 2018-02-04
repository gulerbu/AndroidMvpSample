package com.example.burcuguler.androidmvpsample.weather.detail;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.burcuguler.androidmvpsample.network.model.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burcuguler on 30.01.2018.
 */

public class LocationWeatherDetailListAdapter extends
        RecyclerView.Adapter<LocationWeatherDetailViewHolder> {

    private List<Weather> weatherList;

    public LocationWeatherDetailListAdapter(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public LocationWeatherDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LocationWeatherDetailViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(LocationWeatherDetailViewHolder holder, int position) {
        holder.bind(weatherList.get(position));

    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }
}
