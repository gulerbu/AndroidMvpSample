package com.example.burcuguler.androidmvpsample.weather.search;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.burcuguler.androidmvpsample.network.model.Location;

import java.util.List;

/**
 * Created by burcuguler on 10.01.2018.
 */

public class LocationListAdapter extends RecyclerView.Adapter<LocationListViewHolder> {

    private List<Location> locations;
    private LocationSelectListener listener;

    public LocationListAdapter(List<Location> locations, LocationSelectListener listener) {
        this.locations = locations;
        this.listener = listener;

    }

    @Override
    public LocationListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LocationListViewHolder(parent, listener);
    }

    @Override
    public void onBindViewHolder(LocationListViewHolder holder, int position) {
        holder.bind(locations.get(position));

    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public void update(List<Location> locations) {
        this.locations.clear();
        if (locations != null) {
            this.locations.addAll(locations);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        this.locations.clear();
        notifyDataSetChanged();
    }

}
