package com.example.burcuguler.androidmvpsample.weather.search;

import android.text.TextUtils;

import com.example.burcuguler.androidmvpsample.R;
import com.example.burcuguler.androidmvpsample.core.BasePresenter;
import com.example.burcuguler.androidmvpsample.network.RetrofitClient;
import com.example.burcuguler.androidmvpsample.network.WeatherService;
import com.example.burcuguler.androidmvpsample.network.model.Location;
import com.example.burcuguler.androidmvpsample.network.model.LocationWeatherInfo;
import com.example.burcuguler.androidmvpsample.util.ResourceUtil;
import com.example.burcuguler.androidmvpsample.weather.detail.LocationWeatherDetailActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by burcuguler on 8.01.2018.
 */

public class SearchPresenter extends BasePresenter<SearchView> {

    private final WeatherService weatherService = RetrofitClient.getWeatherService();

    void onSearchTextChanged(String searchText) {
        view.showLoading();

        if (TextUtils.isEmpty(searchText)) {
            view.dismissLoading();
            view.updateMessageText(ResourceUtil.getString(R.string.search_location_text));

        } else {
            Call<List<Location>> locationCall = weatherService.getLocations(searchText);

            locationCall.enqueue(new Callback<List<Location>>() {
                @Override
                public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                    final List<Location> locations = response.body();
                    view.dismissLoading();
                    if (locations != null && !locations.isEmpty()) {
                        view.updateLocationList(locations);

                    } else {
                        view.updateMessageText(ResourceUtil.getString(R.string.no_result_text));
                    }

                }

                @Override
                public void onFailure(Call<List<Location>> call, Throwable t) {
                    view.dismissLoading();
                    view.updateMessageText(ResourceUtil.getString(R.string.error_text));

                }
            });
        }

    }

    void onLocationSelect(Location location) {

        Call<LocationWeatherInfo> call = weatherService.getLocationWeatherInfo(location.getWoeid());

        call.enqueue(new Callback<LocationWeatherInfo>() {
            @Override
            public void onResponse(Call<LocationWeatherInfo> call, Response<LocationWeatherInfo> response) {
                if (response.body() != null) {
                    view.navigateTo(
                            LocationWeatherDetailActivity.createNavigationBundle(response.body())
                    );

                } else {
                    view.updateMessageText(ResourceUtil.getString(R.string.error_text));
                }


            }

            @Override
            public void onFailure(Call<LocationWeatherInfo> call, Throwable t) {
                view.updateMessageText(ResourceUtil.getString(R.string.error_text));

            }
        });


    }
}
