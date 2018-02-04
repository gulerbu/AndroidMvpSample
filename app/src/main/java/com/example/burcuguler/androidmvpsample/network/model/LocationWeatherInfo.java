package com.example.burcuguler.androidmvpsample.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by burcuguler on 22.01.2018.
 */

public class LocationWeatherInfo implements Parcelable {

    @SerializedName("consolidated_weather")
    private List<Weather> fiveDaysWeatherList;

    @SerializedName("time")
    private String time;

    @SerializedName("sun_rise")
    private String sunRise;

    @SerializedName("sun_set")
    private String sunSet;

    @SerializedName("title")
    private String title;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.fiveDaysWeatherList);
        dest.writeString(this.time);
        dest.writeString(this.sunRise);
        dest.writeString(this.sunSet);
        dest.writeString(this.title);
    }


    protected LocationWeatherInfo(Parcel in) {
        this.fiveDaysWeatherList = in.createTypedArrayList(Weather.CREATOR);
        this.time = in.readString();
        this.sunRise = in.readString();
        this.sunSet = in.readString();
        this.title = in.readString();
    }

    public static final Creator<LocationWeatherInfo> CREATOR = new Creator<LocationWeatherInfo>() {
        @Override
        public LocationWeatherInfo createFromParcel(Parcel source) {
            return new LocationWeatherInfo(source);
        }

        @Override
        public LocationWeatherInfo[] newArray(int size) {
            return new LocationWeatherInfo[size];
        }
    };

    public List<Weather> getFiveDaysWeatherList() {
        return fiveDaysWeatherList;
    }

    public String getTime() {
        return time;
    }

    public String getSunRise() {
        return sunRise;
    }

    public String getSunSet() {
        return sunSet;
    }

    public String getTitle() {
        return title;
    }
}
