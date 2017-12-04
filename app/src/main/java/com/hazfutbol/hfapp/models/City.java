package com.hazfutbol.hfapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Represents a hf_city
 */
public class City implements Parcelable, Serializable {

    private Integer cityId;
    private Integer provinceId;
    private String cityName;
    private Integer status;

    public City() {
    }

    public City(Parcel source) {
        cityId = source.readInt();
        provinceId = source.readInt();
        cityName = source.readString();
        status = source.readInt();
    }

    @Override
    public String toString() {
        return cityName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cityId);
        dest.writeValue(provinceId);
        dest.writeString(cityName);
        dest.writeValue(status);
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };


    public Integer getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
