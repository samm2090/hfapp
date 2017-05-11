package com.hazfutbol.hfapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents a hf_player_skill
 */
public class PlayerSkill implements Parcelable {

    private Integer skillId;
    private String skillName;
    private String skillNameGroup;

    public PlayerSkill(Parcel source) {
        skillId = source.readInt();
        skillName = source.readString();
        skillNameGroup = source.readString();
    }

    public PlayerSkill() {
    }

    @Override
    public String toString() {
        return skillName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(skillId);
        dest.writeString(skillName);
        dest.writeString(skillNameGroup);
    }

    public static final Creator<PlayerSkill> CREATOR = new Creator<PlayerSkill>() {
        @Override
        public PlayerSkill createFromParcel(Parcel source) {
            return new PlayerSkill(source);
        }

        @Override
        public PlayerSkill[] newArray(int size) {
            return new PlayerSkill[size];
        }
    };

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillNameGroup() {
        return skillNameGroup;
    }

    public void setSkillNameGroup(String skillNameGroup) {
        this.skillNameGroup = skillNameGroup;
    }

}
