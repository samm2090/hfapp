package com.hazfutbol.hfapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Team implements Parcelable {

    private Integer groupId;
    private Integer userId;
    private Integer complexId;
    private String groupName;
    private String groupDescription;
    private Integer groupCategoryId;
    private Integer groupSearch;
    private Integer groupInvite;
    private Integer groupApproval;
    private String groupPhoto;
    private Date groupCreationDate;
    private Date groupModifiedDate;
    private Integer groupMemberCount;
    private Integer groupViewCount;
    private String groupShortName;
    private Integer sexId;
    private Integer footballCategoryId;
    private Integer footballTypeId;
    private Integer fieldTypeId;
    private Integer provenanceTypeId;
    private String groupDescriptionProvenance;
    private Integer groupChallengeTeam;
    private Integer groupInfoTourney;
    private Integer groupNewRequestPlayer;
    private Integer groupCantWin;
    private Integer groupCantTie;
    private Integer groupCantLose;
    private Integer groupFrequencyGameId;
    private String groupPreferredTime;
    private Integer locationAreaId;
    private Integer communityCategoryId;
    private Integer communityId;
    private Integer groupFlag;
    private Integer locality;
    private Integer areaAccess;
    private String groupTrajectory;
    private Integer photoId;
    private String cGroupIsClosed;

    public Team() {
    }

    public Team(Parcel source) {
        groupId = source.readInt();
        userId = source.readInt();
        complexId = source.readInt();
        groupName = source.readString();
        groupDescription = source.readString();
        groupCategoryId = source.readInt();
        groupSearch = source.readInt();
        groupInvite = source.readInt();
        groupApproval = source.readInt();
        groupPhoto = source.readString();
        groupCreationDate = (Date) source.readSerializable();
        groupModifiedDate = (Date) source.readSerializable();
        groupMemberCount = source.readInt();
        groupViewCount = source.readInt();
        groupShortName = source.readString();
        sexId = source.readInt();
        footballCategoryId = source.readInt();
        footballTypeId = source.readInt();
        fieldTypeId = source.readInt();
        provenanceTypeId = source.readInt();
        groupDescriptionProvenance = source.readString();
        groupChallengeTeam = source.readInt();
        groupInfoTourney = source.readInt();
        groupNewRequestPlayer = source.readInt();
        groupCantWin = source.readInt();
        groupCantTie = source.readInt();
        groupCantLose = source.readInt();
        groupFrequencyGameId = source.readInt();
        groupPreferredTime = source.readString();
        locationAreaId = source.readInt();
        communityCategoryId = source.readInt();
        communityId = source.readInt();
        groupFlag = source.readInt();
        locality = source.readInt();
        areaAccess = source.readInt();
        groupTrajectory = source.readString();
        photoId = source.readInt();
        cGroupIsClosed = source.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }

        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(groupId);
        dest.writeInt(userId);
        dest.writeInt(complexId);
        dest.writeString(groupName);
        dest.writeString(groupDescription);
        dest.writeInt(groupCategoryId);
        dest.writeInt(groupSearch);
        dest.writeInt(groupInvite);
        dest.writeInt(groupApproval);
        dest.writeString(groupPhoto);
        dest.writeSerializable(groupCreationDate);
        dest.writeSerializable(groupModifiedDate);
        dest.writeInt(groupMemberCount);
        dest.writeInt(groupViewCount);
        dest.writeString(groupShortName);
        dest.writeInt(sexId);
        dest.writeInt(footballCategoryId);
        dest.writeInt(footballTypeId);
        dest.writeInt(fieldTypeId);
        dest.writeInt(provenanceTypeId);
        dest.writeString(groupDescriptionProvenance);
        dest.writeInt(groupChallengeTeam);
        dest.writeInt(groupInfoTourney);
        dest.writeInt(groupNewRequestPlayer);
        dest.writeInt(groupCantWin);
        dest.writeInt(groupCantTie);
        dest.writeInt(groupCantLose);
        dest.writeInt(groupFrequencyGameId);
        dest.writeString(groupPreferredTime);
        dest.writeInt(locationAreaId);
        dest.writeInt(communityCategoryId);
        dest.writeInt(communityId);
        dest.writeInt(groupFlag);
        dest.writeInt(locality);
        dest.writeInt(areaAccess);
        dest.writeString(groupTrajectory);
        dest.writeInt(photoId);
        dest.writeString(cGroupIsClosed);
    }

    public Integer getAreaAccess() {
        return areaAccess;
    }

    public String getcGroupIsClosed() {
        return cGroupIsClosed;
    }

    public Integer getCommunityCategoryId() {
        return communityCategoryId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public Integer getComplexId() {
        return complexId;
    }

    public static Creator<Team> getCREATOR() {
        return CREATOR;
    }

    public Integer getFieldTypeId() {
        return fieldTypeId;
    }

    public Integer getFootballCategoryId() {
        return footballCategoryId;
    }

    public Integer getFootballTypeId() {
        return footballTypeId;
    }

    public Integer getGroupApproval() {
        return groupApproval;
    }

    public Integer getGroupCantLose() {
        return groupCantLose;
    }

    public Integer getGroupCantTie() {
        return groupCantTie;
    }

    public Integer getGroupCantWin() {
        return groupCantWin;
    }

    public Integer getGroupCategoryId() {
        return groupCategoryId;
    }

    public Integer getGroupChallengeTeam() {
        return groupChallengeTeam;
    }

    public Date getGroupCreationDate() {
        return groupCreationDate;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public String getGroupDescriptionProvenance() {
        return groupDescriptionProvenance;
    }

    public Integer getGroupFlag() {
        return groupFlag;
    }

    public Integer getGroupFrequencyGameId() {
        return groupFrequencyGameId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public Integer getGroupInfoTourney() {
        return groupInfoTourney;
    }

    public Integer getGroupInvite() {
        return groupInvite;
    }

    public Integer getGroupMemberCount() {
        return groupMemberCount;
    }

    public Date getGroupModifiedDate() {
        return groupModifiedDate;
    }

    public String getGroupName() {
        return groupName;
    }

    public Integer getGroupNewRequestPlayer() {
        return groupNewRequestPlayer;
    }

    public String getGroupPhoto() {
        return groupPhoto;
    }

    public String getGroupPreferredTime() {
        return groupPreferredTime;
    }

    public Integer getGroupSearch() {
        return groupSearch;
    }

    public String getGroupShortName() {
        return groupShortName;
    }

    public String getGroupTrajectory() {
        return groupTrajectory;
    }

    public Integer getGroupViewCount() {
        return groupViewCount;
    }

    public Integer getLocality() {
        return locality;
    }

    public Integer getLocationAreaId() {
        return locationAreaId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public Integer getProvenanceTypeId() {
        return provenanceTypeId;
    }

    public Integer getSexId() {
        return sexId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setAreaAccess(Integer areaAccess) {
        this.areaAccess = areaAccess;
    }

    public void setcGroupIsClosed(String cGroupIsClosed) {
        this.cGroupIsClosed = cGroupIsClosed;
    }

    public void setCommunityCategoryId(Integer communityCategoryId) {
        this.communityCategoryId = communityCategoryId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public void setComplexId(Integer complexId) {
        this.complexId = complexId;
    }

    public void setFieldTypeId(Integer fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }

    public void setFootballCategoryId(Integer footballCategoryId) {
        this.footballCategoryId = footballCategoryId;
    }

    public void setFootballTypeId(Integer footballTypeId) {
        this.footballTypeId = footballTypeId;
    }

    public void setGroupApproval(Integer groupApproval) {
        this.groupApproval = groupApproval;
    }

    public void setGroupCantLose(Integer groupCantLose) {
        this.groupCantLose = groupCantLose;
    }

    public void setGroupCantTie(Integer groupCantTie) {
        this.groupCantTie = groupCantTie;
    }

    public void setGroupCantWin(Integer groupCantWin) {
        this.groupCantWin = groupCantWin;
    }

    public void setGroupCategoryId(Integer groupCategoryId) {
        this.groupCategoryId = groupCategoryId;
    }

    public void setGroupChallengeTeam(Integer groupChallengeTeam) {
        this.groupChallengeTeam = groupChallengeTeam;
    }

    public void setGroupCreationDate(Date groupCreationDate) {
        this.groupCreationDate = groupCreationDate;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public void setGroupDescriptionProvenance(String groupDescriptionProvenance) {
        this.groupDescriptionProvenance = groupDescriptionProvenance;
    }

    public void setGroupFlag(Integer groupFlag) {
        this.groupFlag = groupFlag;
    }

    public void setGroupFrequencyGameId(Integer groupFrequencyGameId) {
        this.groupFrequencyGameId = groupFrequencyGameId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setGroupInfoTourney(Integer groupInfoTourney) {
        this.groupInfoTourney = groupInfoTourney;
    }

    public void setGroupInvite(Integer groupInvite) {
        this.groupInvite = groupInvite;
    }

    public void setGroupMemberCount(Integer groupMemberCount) {
        this.groupMemberCount = groupMemberCount;
    }

    public void setGroupModifiedDate(Date groupModifiedDate) {
        this.groupModifiedDate = groupModifiedDate;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupNewRequestPlayer(Integer groupNewRequestPlayer) {
        this.groupNewRequestPlayer = groupNewRequestPlayer;
    }

    public void setGroupPhoto(String groupPhoto) {
        this.groupPhoto = groupPhoto;
    }

    public void setGroupPreferredTime(String groupPreferredTime) {
        this.groupPreferredTime = groupPreferredTime;
    }

    public void setGroupSearch(Integer groupSearch) {
        this.groupSearch = groupSearch;
    }

    public void setGroupShortName(String groupShortName) {
        this.groupShortName = groupShortName;
    }

    public void setGroupTrajectory(String groupTrajectory) {
        this.groupTrajectory = groupTrajectory;
    }

    public void setGroupViewCount(Integer groupViewCount) {
        this.groupViewCount = groupViewCount;
    }

    public void setLocality(Integer locality) {
        this.locality = locality;
    }

    public void setLocationAreaId(Integer locationAreaId) {
        this.locationAreaId = locationAreaId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public void setProvenanceTypeId(Integer provenanceTypeId) {
        this.provenanceTypeId = provenanceTypeId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
