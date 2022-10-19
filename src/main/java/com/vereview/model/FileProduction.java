package com.vereview.model;

/**
 * Created by mjmangan on 8/11/17.
 */
public class FileProduction {
    private Long productionId;
    private Long fileId;
    private String number;
    private String volume;
    private String status;
    private String coding;

    public Long getProductionId() {
        return productionId;
    }

    public void setProductionId(Long productionId) {
        this.productionId = productionId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    @Override
    public String toString() {
        return "FileProduction{" +
                "productionId=" + productionId +
                ", fileId=" + fileId +
                ", number='" + number + '\'' +
                ", volume='" + volume + '\'' +
                ", status='" + status + '\'' +
                ", coding='" + coding + '\'' +
                '}';
    }
}
