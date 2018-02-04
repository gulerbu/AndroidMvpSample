package com.example.burcuguler.androidmvpsample.weather.detail;

import android.view.ViewGroup;

import com.example.burcuguler.androidmvpsample.R;
import com.example.burcuguler.androidmvpsample.network.model.Weather;
import com.example.burcuguler.androidmvpsample.util.WeatherUtil;
import com.example.burcuguler.androidmvpsample.view.BaseTextView;
import com.example.burcuguler.androidmvpsample.view.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by burcuguler on 30.01.2018.
 */

public class LocationWeatherDetailViewHolder extends BaseViewHolder {

    @BindView(R.id.layout_detail_list_item_text_view_day)
    BaseTextView textViewDay;

    @BindView(R.id.layout_detail_list_item_text_view_condition)
    BaseTextView textViewCondition;

    @BindView(R.id.layout_detail_list_item_text_view_temp)
    BaseTextView textViewTemp;

    public LocationWeatherDetailViewHolder(ViewGroup parent) {
        super(parent, R.layout.layout_detail_list_item);
    }

    public void bind(Weather weather) {
        textViewDay.setText(weather.getDate());
        textViewCondition.setText(weather.getWeatherStateName());
        textViewCondition.setCompoundDrawablesWithIntrinsicBounds(0,
                WeatherUtil.getWeatherState(weather.getWeatherStateAbbr()).getWeatherStateIconResId(),
                0,
                0);
        textViewTemp.setText(WeatherUtil.getMinMaxTemperatureAsText(
                textViewTemp.getResources(),
                weather.getMaxTemp(),
                weather.getMinTemp())
        );

    }


}
