package com.hazfutbol.hfapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a hf_user_player
 */
public class Player implements Parcelable, Serializable {
    private Integer userPlayerId;
    private Integer userId;
    private String playerImageProfile;
    private String playerNick;
    private Integer playerGender;
    private Date playerBirthday;
    private Integer playerAgePost;
    private Integer playerNationalities;
    private Integer playerCurrentCity;
    private Integer documentId;
    private String playerNumDocument;
    private String playerPhone;
    private String playerAddress;
    private Integer cityId;
    private String playerPresentation;
    private Integer playTimeId;
    private Integer playSizeId;
    private Integer playWeightId;
    private String playerAchievement;
    private Integer footDominatingId;
    private Integer photoId;
    private Integer stateId;
    private Integer provinceId;
    private String onTheHomePage;

    public Player() {
    }

    public Player(Parcel source) {
        userPlayerId = source.readInt();
        userId = source.readInt();
        playerImageProfile = source.readString();
        playerNick = source.readString();
        playerGender = source.readInt();
        playerBirthday = (Date) source.readSerializable();
        playerAgePost = source.readInt();
        playerNationalities = source.readInt();
        playerCurrentCity = source.readInt();
        documentId = source.readInt();
        playerNumDocument = source.readString();
        playerPhone = source.readString();
        playerAddress = source.readString();
        cityId = source.readInt();
        playerPresentation = source.readString();
        playTimeId = source.readInt();
        playSizeId = source.readInt();
        playWeightId = source.readInt();
        playerAchievement = source.readString();
        footDominatingId = source.readInt();
        photoId = source.readInt();
        stateId = source.readInt();
        provinceId = source.readInt();
        onTheHomePage = source.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }

        @Override
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userPlayerId);
        dest.writeValue(userId);
        dest.writeString(playerImageProfile);
        dest.writeString(playerNick);
        dest.writeValue(playerGender);
        dest.writeSerializable(playerBirthday);
        dest.writeValue(playerAgePost);
        dest.writeValue(playerNationalities);
        dest.writeValue(playerCurrentCity);
        dest.writeValue(documentId);
        dest.writeString(playerNumDocument);
        dest.writeString(playerPhone);
        dest.writeString(playerAddress);
        dest.writeValue(cityId);
        dest.writeString(playerPresentation);
        dest.writeValue(playTimeId);
        dest.writeValue(playSizeId);
        dest.writeValue(playWeightId);
        dest.writeString(playerAchievement);
        dest.writeValue(footDominatingId);
        dest.writeValue(photoId);
        dest.writeValue(stateId);
        dest.writeValue(provinceId);
        dest.writeString(onTheHomePage);
    }


    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getFootDominatingId() {
        return footDominatingId;
    }

    public void setFootDominatingId(Integer footDominatingId) {
        this.footDominatingId = footDominatingId;
    }

    public String getOnTheHomePage() {
        return onTheHomePage;
    }

    public void setOnTheHomePage(String onTheHomePage) {
        this.onTheHomePage = onTheHomePage;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPlayerAchievement() {
        return playerAchievement;
    }

    public void setPlayerAchievement(String playerAchievement) {
        this.playerAchievement = playerAchievement;
    }

    public String getPlayerAddress() {
        return playerAddress;
    }

    public void setPlayerAddress(String playerAddress) {
        this.playerAddress = playerAddress;
    }

    public Integer getPlayerAgePost() {
        return playerAgePost;
    }

    public void setPlayerAgePost(Integer playerAgePost) {
        this.playerAgePost = playerAgePost;
    }

    public Date getPlayerBirthday() {
        return playerBirthday;
    }

    public void setPlayerBirthday(Date playerBirthday) {
        this.playerBirthday = playerBirthday;
    }

    public Integer getPlayerCurrentCity() {
        return playerCurrentCity;
    }

    public void setPlayerCurrentCity(Integer playerCurrentCity) {
        this.playerCurrentCity = playerCurrentCity;
    }

    public Integer getPlayerGender() {
        return playerGender;
    }

    public void setPlayerGender(Integer playerGender) {
        this.playerGender = playerGender;
    }

    public String getPlayerImageProfile() {
        return playerImageProfile;
    }

    public void setPlayerImageProfile(String playerImageProfile) {
        this.playerImageProfile = playerImageProfile;
    }

    public Integer getPlayerNationalities() {
        return playerNationalities;
    }

    public void setPlayerNationalities(Integer playerNationalities) {
        this.playerNationalities = playerNationalities;
    }

    public String getPlayerNick() {
        return playerNick;
    }

    public void setPlayerNick(String playerNick) {
        this.playerNick = playerNick;
    }

    public String getPlayerNumDocument() {
        return playerNumDocument;
    }

    public void setPlayerNumDocument(String playerNumDocument) {
        this.playerNumDocument = playerNumDocument;
    }

    public String getPlayerPhone() {
        return playerPhone;
    }

    public void setPlayerPhone(String playerPhone) {
        this.playerPhone = playerPhone;
    }

    public String getPlayerPresentation() {
        return playerPresentation;
    }

    public void setPlayerPresentation(String playerPresentation) {
        this.playerPresentation = playerPresentation;
    }

    public Integer getPlaySizeId() {
        return playSizeId;
    }

    public void setPlaySizeId(Integer playSizeId) {
        this.playSizeId = playSizeId;
    }

    public Integer getPlayTimeId() {
        return playTimeId;
    }

    public void setPlayTimeId(Integer playTimeId) {
        this.playTimeId = playTimeId;
    }

    public Integer getPlayWeightId() {
        return playWeightId;
    }

    public void setPlayWeightId(Integer playWeightId) {
        this.playWeightId = playWeightId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserPlayerId() {
        return userPlayerId;
    }

    public void setUserPlayerId(Integer userPlayerId) {
        this.userPlayerId = userPlayerId;
    }
}
