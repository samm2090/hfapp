package com.hazfutbol.hfapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by ninosimeon on 08/02/17.
 */

public class User implements Parcelable {

    private Integer userId;
    private Integer userTypeId;
    private String userName;
    private String userLastName;
    private String userCode;
    private String userEmail;
    private String userPassword;
    private Integer aclRolId;
    private String userRegisterAllFeatures;
    private String userRegisterIp;
    private Integer userActiveForgot;
    private Integer userCommunity;
    private String userUri;
    private Integer userRegisterById;
    private Integer affiliationTypeId;
    private String userAfChangedPassword;
    private String userToken;
    private String userTokenForgot;
    private String userTokenInactive;
    private Integer userActive;
    private Integer userStatus;
    private Date userRegisterDate;

    public User(Parcel source) {
        aclRolId = source.readInt();
        affiliationTypeId = source.readInt();
        userActive = source.readInt();
        userActiveForgot = source.readInt();
        userAfChangedPassword = source.readString();
        userCode = source.readString();
        userCommunity = source.readInt();
        userEmail = source.readString();
        userId = source.readInt();
        userLastName = source.readString();
        userName = source.readString();
        userPassword = source.readString();
        userRegisterAllFeatures = source.readString();
        userRegisterById = source.readInt();
        userRegisterDate = (Date) source.readSerializable();
        userRegisterIp = source.readString();
        userStatus = source.readInt();
        userToken = source.readString();
        userTokenForgot = source.readString();
        userTokenInactive = source.readString();
        userTypeId = source.readInt();
        userUri = source.readString();
    }

    public User(){}

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(aclRolId);
        dest.writeInt(affiliationTypeId);
        dest.writeInt(userActive);
        dest.writeInt(userActiveForgot);
        dest.writeString(userAfChangedPassword);
        dest.writeString(userCode);
        dest.writeInt(userCommunity);
        dest.writeString(userEmail);
        dest.writeInt(userId);
        dest.writeString(userLastName);
        dest.writeString(userName);
        dest.writeString(userPassword);
        dest.writeString(userRegisterAllFeatures);
        dest.writeInt(userRegisterById);
        dest.writeSerializable(userRegisterDate);
        dest.writeString(userRegisterIp);
        dest.writeInt(userStatus);
        dest.writeString(userToken);
        dest.writeString(userTokenForgot);
        dest.writeString(userTokenInactive);
        dest.writeInt(userTypeId);
        dest.writeString(userUri);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getUserUri() {
        return userUri;
    }

    public void setUserUri(String userUri) {
        this.userUri = userUri;
    }

    public Integer getUserActive() {
        return userActive;
    }

    public void setUserActive(Integer userActive) {
        this.userActive = userActive;
    }

    public Integer getUserActiveForgot() {
        return userActiveForgot;
    }

    public void setUserActiveForgot(Integer userActiveForgot) {
        this.userActiveForgot = userActiveForgot;
    }

    public String getUserAfChangedPassword() {
        return userAfChangedPassword;
    }

    public void setUserAfChangedPassword(String userAfChangedPassword) {
        this.userAfChangedPassword = userAfChangedPassword;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getUserCommunity() {
        return userCommunity;
    }

    public void setUserCommunity(Integer userCommunity) {
        this.userCommunity = userCommunity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRegisterAllFeatures() {
        return userRegisterAllFeatures;
    }

    public void setUserRegisterAllFeatures(String userRegisterAllFeatures) {
        this.userRegisterAllFeatures = userRegisterAllFeatures;
    }

    public Integer getUserRegisterById() {
        return userRegisterById;
    }

    public void setUserRegisterById(Integer userRegisterById) {
        this.userRegisterById = userRegisterById;
    }

    public Date getUserRegisterDate() {
        return userRegisterDate;
    }

    public void setUserRegisterDate(Date userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
    }

    public String getUserRegisterIp() {
        return userRegisterIp;
    }

    public void setUserRegisterIp(String userRegisterIp) {
        this.userRegisterIp = userRegisterIp;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserTokenForgot() {
        return userTokenForgot;
    }

    public void setUserTokenForgot(String userTokenForgot) {
        this.userTokenForgot = userTokenForgot;
    }

    public String getUserTokenInactive() {
        return userTokenInactive;
    }

    public void setUserTokenInactive(String userTokenInactive) {
        this.userTokenInactive = userTokenInactive;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Integer getAffiliationTypeId() {
        return affiliationTypeId;
    }

    public void setAffiliationTypeId(Integer affiliationTypeId) {
        this.affiliationTypeId = affiliationTypeId;
    }

    public Integer getAclRolId() {
        return aclRolId;
    }

    public void setAclRolId(Integer aclRolId) {
        this.aclRolId = aclRolId;
    }

}
