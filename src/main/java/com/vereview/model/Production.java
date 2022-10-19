package com.vereview.model;

import java.util.Date;

/**
 * Created by mjmangan on 8/12/17.
 */
public class Production {
    private Long productionId;
    private Date dateLastUpdated;
    private Date date;
    private Date dateCreated;
    private String name;
    private String type;
    private Long userId;
    private String media;
    private String description;
    private Boolean locked;
    private String controlPrefix;
    private Integer controlStartNumber;
    private Integer controlPadding;
    private String volumePrefix;
    private Integer volumeStartNumber;
    private Integer volumePadding;

    public Long getProductionId() {
        return productionId;
    }

    public void setProductionId(Long productionId) {
        this.productionId = productionId;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getControlPrefix() {
        return controlPrefix;
    }

    public void setControlPrefix(String controlPrefix) {
        this.controlPrefix = controlPrefix;
    }

    public Integer getControlStartNumber() {
        return controlStartNumber;
    }

    public void setControlStartNumber(Integer controlStartNumber) {
        this.controlStartNumber = controlStartNumber;
    }

    public Integer getControlPadding() {
        return controlPadding;
    }

    public void setControlPadding(Integer controlPadding) {
        this.controlPadding = controlPadding;
    }

    public String getVolumePrefix() {
        return volumePrefix;
    }

    public void setVolumePrefix(String volumePrefix) {
        this.volumePrefix = volumePrefix;
    }

    public Integer getVolumeStartNumber() {
        return volumeStartNumber;
    }

    public void setVolumeStartNumber(Integer volumeStartNumber) {
        this.volumeStartNumber = volumeStartNumber;
    }

    public Integer getVolumePadding() {
        return volumePadding;
    }

    public void setVolumePadding(Integer volumePadding) {
        this.volumePadding = volumePadding;
    }

    @Override
    public String toString() {
        return "Production{" +
                "productionId=" + productionId +
                ", dateLastUpdated=" + dateLastUpdated +
                ", date=" + date +
                ", dateCreated=" + dateCreated +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", userId=" + userId +
                ", media='" + media + '\'' +
                ", description='" + description + '\'' +
                ", locked=" + locked +
                ", controlPrefix='" + controlPrefix + '\'' +
                ", controlStartNumber=" + controlStartNumber +
                ", controlPadding=" + controlPadding +
                ", volumePrefix='" + volumePrefix + '\'' +
                ", volumeStartNumber=" + volumeStartNumber +
                ", volumePadding=" + volumePadding +
                '}';
    }
}
