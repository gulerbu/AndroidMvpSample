package com.example.burcuguler.androidmvpsample.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by burcuguler on 21.01.2018.
 */

public class Weather implements Parcelable {

    @SerializedName("id")
    private long id;

    @SerializedName("applicable_date")
    private String date;

    @SerializedName("weather_state_name")
    private String weatherStateName;

    @SerializedName("weather_state_abbr")
    private String weatherStateAbbr;

    @SerializedName("min_temp")
    private double minTemp;

    @SerializedName("max_temp")
    private double maxTemp;

    @SerializedName("the_temp")
    private double currentTemp;

    @SerializedName("wind_speed")
    private double windSpeed;

    @SerializedName("wind_direction")
    private double windDirection;

    @SerializedName("air_pressure")
    private double airPressure;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("visibility")
    private double visibility;

    @SerializedName("predictability")
    private int predictability;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.date);
        dest.writeString(this.weatherStateName);
        dest.writeString(this.weatherStateAbbr);
        dest.writeDouble(this.minTemp);
        dest.writeDouble(this.maxTemp);
        dest.writeDouble(this.currentTemp);
        dest.writeDouble(this.windSpeed);
        dest.writeDouble(this.windDirection);
        dest.writeDouble(this.airPressure);
        dest.writeDouble(this.humidity);
        dest.writeDouble(this.visibility);
        dest.writeInt(this.predictability);
    }

    public Weather() {
    }

    protected Weather(Parcel in) {
        this.id = in.readLong();
        this.date = in.readString();
        this.weatherStateName = in.readString();
        this.weatherStateAbbr = in.readString();
        this.minTemp = in.readDouble();
        this.maxTemp = in.readDouble();
        this.currentTemp = in.readDouble();
        this.windSpeed = in.readDouble();
        this.windDirection = in.readDouble();
        this.airPressure = in.readDouble();
        this.humidity = in.readDouble();
        this.visibility = in.readDouble();
        this.predictability = in.readInt();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel source) {
            return new Weather(source);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public String getWeatherStateAbbr() {
        return weatherStateAbbr;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public double getAirPressure() {
        return airPressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getVisibility() {
        return visibility;
    }

    public int getPredictability() {
        return predictability;
    }
}
