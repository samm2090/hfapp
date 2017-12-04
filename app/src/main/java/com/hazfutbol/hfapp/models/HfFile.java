package com.hazfutbol.hfapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a hf_storage_files
 */
public class HfFile implements Parcelable, Serializable {

    private Integer fileId;
    private Integer fileSettingId;
    private String type;
    private String typeChild;
    private String parentType;
    private Integer parentId;
    private Integer userId;
    private String storagePath;
    private String extension;
    private String name;
    private String mime;
    private Integer size;
    private String hash;
    private Date modifiedDate;
    private Date creationDate;
    private Integer fileParentId;

    public HfFile() {
    }

    public HfFile(Parcel source) {
        fileId = source.readInt();
        fileSettingId = source.readInt();
        type = source.readString();
        typeChild = source.readString();
        parentType = source.readString();
        parentId = source.readInt();
        userId = source.readInt();
        storagePath = source.readString();
        extension = source.readString();
        name = source.readString();
        mime = source.readString();
        size = source.readInt();
        hash = source.readString();
        modifiedDate = (Date) source.readSerializable();
        creationDate = (Date) source.readSerializable();
        fileParentId = source.readInt();
    }

    public static final Creator<HfFile> CREATOR = new Creator<HfFile>() {
        @Override
        public HfFile createFromParcel(Parcel source) {
            return new HfFile(source);
        }

        @Override
        public HfFile[] newArray(int size) {
            return new HfFile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fileId);
        dest.writeValue(fileSettingId);
        dest.writeString(type);
        dest.writeString(typeChild);
        dest.writeString(parentType);
        dest.writeValue(parentId);
        dest.writeValue(userId);
        dest.writeString(storagePath);
        dest.writeString(extension);
        dest.writeString(name);
        dest.writeString(mime);
        dest.writeValue(size);
        dest.writeString(hash);
        dest.writeSerializable(modifiedDate);
        dest.writeSerializable(creationDate);
        dest.writeValue(fileParentId);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getFileParentId() {
        return fileParentId;
    }

    public void setFileParentId(Integer fileParentId) {
        this.fileParentId = fileParentId;
    }

    public Integer getFileSettingId() {
        return fileSettingId;
    }

    public void setFileSettingId(Integer fileSettingId) {
        this.fileSettingId = fileSettingId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeChild() {
        return typeChild;
    }

    public void setTypeChild(String typeChild) {
        this.typeChild = typeChild;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
