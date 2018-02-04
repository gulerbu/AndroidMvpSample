package com.example.burcuguler.androidmvpsample.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by burcuguler on 02/01/2018.
 */

public class Location implements Parcelable {

    @SerializedName("title")
    private String title;

    @SerializedName("location_type")
    private String locationType;

    @SerializedName("woeid")
    private int woeid;

    @SerializedName("latt_long")
    private String latLong;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.locationType);
        dest.writeInt(this.woeid);
        dest.writeString(this.latLong);
    }


    protected Location(Parcel in) {
        this.title = in.readString();
        this.locationType = in.readString();
        this.woeid = in.readInt();
        this.latLong = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getLocationType() {
        return locationType;
    }

    public int getWoeid() {
        return woeid;
    }

    public String getLatLong() {
        return latLong;
    }
}
