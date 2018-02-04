package com.example.burcuguler.androidmvpsample.weather.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.burcuguler.androidmvpsample.R;
import com.example.burcuguler.androidmvpsample.core.BaseActivity;
import com.example.burcuguler.androidmvpsample.network.model.LocationWeatherInfo;
import com.example.burcuguler.androidmvpsample.network.model.Weather;
import com.example.burcuguler.androidmvpsample.util.NavigationBundle;
import com.example.burcuguler.androidmvpsample.util.WeatherUtil;
import com.example.burcuguler.androidmvpsample.view.BaseTextView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by burcuguler on 26.01.2018.
 */

public class LocationWeatherDetailActivity extends
        BaseActivity<LocationWeatherDetailPresenter> implements LocationWeatherDetailView {

    private static final String KEY_LOCATION_INFO = "locationInfo";

    @BindView(R.id.activity_location_weather_detail_text_view_condition)
    BaseTextView textViewWeatherCondition;

    @BindView(R.id.activity_location_weather_detail_text_view_location)
    BaseTextView textViewLocationName;

    @BindView(R.id.activity_location_weather_detail_text_view_date)
    BaseTextView textViewLocationDate;

    @BindView(R.id.activity_location_weather_detail_text_view_current_temp)
    BaseTextView textViewCurrentTemp;

    @BindView(R.id.activity_location_weather_detail_text_view_min_max_temp)
    BaseTextView textViewMinMaxTemp;

    @BindView(R.id.activity_location_weather_detail_image_view_icon)
    ImageView imageViewWeatherIcon;

    @BindView(R.id.activity_location_weather_detail_recycler_view)
    RecyclerView recyclerView;


    public static NavigationBundle createNavigationBundle(@NonNull LocationWeatherInfo location) {
        final Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_LOCATION_INFO, location);

        return new NavigationBundle(LocationWeatherDetailActivity.class, bundle);
    }

    @Override
    public int getContentResourceId() {
        return R.layout.activity_location_weather_detail;
    }

    @Override
    public LocationWeatherDetailPresenter createPresenter() {
        return new LocationWeatherDetailPresenter();
    }

    @Override
    public void initUserInterface() {

        if (getIntent().getExtras() != null) {
            final LocationWeatherInfo info = getIntent().getExtras().getParcelable(KEY_LOCATION_INFO);

            final List<Weather> weathers = info.getFiveDaysWeatherList();
            final Weather weatherToday = weathers.get(0);
            weathers.remove(0);

            textViewLocationName.setText(info.getTitle());
            textViewWeatherCondition.setText(weatherToday.getWeatherStateName());
            textViewLocationDate.setText(weatherToday.getDate());

            textViewCurrentTemp.setText(WeatherUtil.getTemperatureAsText(getResources(),
                    weatherToday.getCurrentTemp())
            );

            textViewMinMaxTemp.setText(WeatherUtil.getMinMaxTemperatureAsText(getResources(),
                    weatherToday.getMaxTemp(),
                    weatherToday.getMinTemp())
            );

            imageViewWeatherIcon.setImageResource(WeatherUtil.getWeatherState(weatherToday.getWeatherStateAbbr())
                    .getWeatherStateIconResId());


            final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new LocationWeatherDetailListAdapter(weathers));

        }

    }

}
