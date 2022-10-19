package com.vereview.model;



/**
 * Created by mjmangan on 8/11/17.
 */
public class Page {
    private Long pageId;
    private Long fileId;
    private Long number;
    private String bates;
    private Boolean redacted;
    private Boolean isBlank;
    private Boolean isColor;
    private String stampTl;
    private String stampTm;
    private String stampTr;
    private String stampBl;
    private String stampBm;
    private String stampBr;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getBates() {
        return bates;
    }

    public void setBates(String bates) {
        this.bates = bates;
    }

    public Boolean getRedacted() {
        return redacted;
    }

    public void setRedacted(Boolean redacted) {
        this.redacted = redacted;
    }

    public Boolean getBlank() {
        return isBlank;
    }

    public void setBlank(Boolean blank) {
        isBlank = blank;
    }

    public Boolean getColor() {
        return isColor;
    }

    public void setColor(Boolean color) {
        isColor = color;
    }

    public String getStampTl() {
        return stampTl;
    }

    public void setStampTl(String stampTl) {
        this.stampTl = stampTl;
    }

    public String getStampTm() {
        return stampTm;
    }

    public void setStampTm(String stampTm) {
        this.stampTm = stampTm;
    }

    public String getStampTr() {
        return stampTr;
    }

    public void setStampTr(String stampTr) {
        this.stampTr = stampTr;
    }

    public String getStampBl() {
        return stampBl;
    }

    public void setStampBl(String stampBl) {
        this.stampBl = stampBl;
    }

    public String getStampBm() {
        return stampBm;
    }

    public void setStampBm(String stampBm) {
        this.stampBm = stampBm;
    }

    public String getStampBr() {
        return stampBr;
    }

    public void setStampBr(String stampBr) {
        this.stampBr = stampBr;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", fileId=" + fileId +
                ", number=" + number +
                ", bates='" + bates + '\'' +
                ", redacted=" + redacted +
                ", isBlank=" + isBlank +
                ", isColor=" + isColor +
                ", stampTl='" + stampTl + '\'' +
                ", stampTm='" + stampTm + '\'' +
                ", stampTr='" + stampTr + '\'' +
                ", stampBl='" + stampBl + '\'' +
                ", stampBm='" + stampBm + '\'' +
                ", stampBr='" + stampBr + '\'' +
                '}';
    }
}
