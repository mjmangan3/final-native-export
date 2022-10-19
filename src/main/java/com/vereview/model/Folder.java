package com.vereview.model;

/**
 * Created by mjmangan on 8/11/17.
 */
public class Folder {
    private Long folderId;
    private Long deviceId;
    private Long parentId;
    private String fullName;
    private String name;
    private String fullNameSha1;

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullNameSha1() {
        return fullNameSha1;
    }

    public void setFullNameSha1(String fullNameSha1) {
        this.fullNameSha1 = fullNameSha1;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "folderId=" + folderId +
                ", deviceId=" + deviceId +
                ", parentId=" + parentId +
                ", fullName='" + fullName + '\'' +
                ", name='" + name + '\'' +
                ", fullNameSha1='" + fullNameSha1 + '\'' +
                '}';
    }
}
