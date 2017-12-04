package com.hazfutbol.hfapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Represents a hf_position_prefer
 */
public class PlayerPosition implements Parcelable, Serializable {

    private Integer nPositionPreferId;
    private Integer userPlayerId;
    private Integer positionId;
    private String positionPreferStatus;

    public PlayerPosition() {
    }

    public PlayerPosition(Parcel source) {
        nPositionPreferId = source.readInt();
        userPlayerId = source.readInt();
        positionId = source.readInt();
        positionPreferStatus = source.readString();
    }

    public static final Creator<PlayerPosition> CREATOR = new Creator<PlayerPosition>() {
        @Override
        public PlayerPosition createFromParcel(Parcel source) {
            return new PlayerPosition(source);
        }

        @Override
        public PlayerPosition[] newArray(int size) {
            return new PlayerPosition[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(nPositionPreferId);
        dest.writeValue(userPlayerId);
        dest.writeValue(positionId);
        dest.writeString(positionPreferStatus);
    }

    public Integer getnPositionPreferId() {
        return nPositionPreferId;
    }

    public void setnPositionPreferId(Integer nPositionPreferId) {
        this.nPositionPreferId = nPositionPreferId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionPreferStatus() {
        return positionPreferStatus;
    }

    public void setPositionPreferStatus(String positionPreferStatus) {
        this.positionPreferStatus = positionPreferStatus;
    }

    public Integer getUserPlayerId() {
        return userPlayerId;
    }

    public void setUserPlayerId(Integer userPlayerId) {
        this.userPlayerId = userPlayerId;
    }
}
