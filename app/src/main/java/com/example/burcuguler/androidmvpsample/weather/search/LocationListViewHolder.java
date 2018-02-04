package com.example.burcuguler.androidmvpsample.weather.search;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.burcuguler.androidmvpsample.R;
import com.example.burcuguler.androidmvpsample.network.model.Location;
import com.example.burcuguler.androidmvpsample.view.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by burcuguler on 10.01.2018.
 */

public class LocationListViewHolder extends BaseViewHolder implements View.OnClickListener {

    @BindView(R.id.layout_search_list_item_text_view_name)
    TextView textViewLocationName;

    private LocationSelectListener listener;
    private Location location;

    public LocationListViewHolder(ViewGroup parent, LocationSelectListener listener) {
        super(parent, R.layout.layout_search_list_item);
        itemView.setOnClickListener(this);
        this.listener = listener;
    }

    public void bind(Location location) {
        this.location = location;
        textViewLocationName.setText(location.getTitle());

    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onLocationSelected(location);
        }

    }
}
