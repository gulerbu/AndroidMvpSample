package com.example.burcuguler.androidmvpsample.weather.search;

import com.example.burcuguler.androidmvpsample.core.BaseView;
import com.example.burcuguler.androidmvpsample.network.model.Location;

import java.util.List;

/**
 * Created by burcuguler on 8.01.2018.
 */

public interface SearchView extends BaseView {

    void showLoading();

    void dismissLoading();

    void updateLocationList(List<Location> locations);

    void updateMessageText(String message);


}
