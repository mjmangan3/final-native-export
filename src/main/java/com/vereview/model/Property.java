package com.vereview.model;



import java.util.Date;

/**
 * Created by mjmangan on 8/20/17.
 */
public class Property {
    private Long propertyId;
    private Long fileId;
    private String title;
    private String author;
    private String company;
    private Date dateCreated;
    private Date dateLastSaved;
    private Date dateLastRead;
    private Date dateLastPrinted;
    private String lastSavedBy;
    private String revision;
    private Long pageCount;
    private Long originalId;
    private String userEntered;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastSaved() {
        return dateLastSaved;
    }

    public void setDateLastSaved(Date dateLastSaved) {
        this.dateLastSaved = dateLastSaved;
    }

    public Date getDateLastRead() {
        return dateLastRead;
    }

    public void setDateLastRead(Date dateLastRead) {
        this.dateLastRead = dateLastRead;
    }

    public Date getDateLastPrinted() {
        return dateLastPrinted;
    }

    public void setDateLastPrinted(Date dateLastPrinted) {
        this.dateLastPrinted = dateLastPrinted;
    }

    public String getLastSavedBy() {
        return lastSavedBy;
    }

    public void setLastSavedBy(String lastSavedBy) {
        this.lastSavedBy = lastSavedBy;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }

    public String getUserEntered() {
        return userEntered;
    }

    public void setUserEntered(String userEntered) {
        this.userEntered = userEntered;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", fileId=" + fileId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", company='" + company + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateLastSaved=" + dateLastSaved +
                ", dateLastRead=" + dateLastRead +
                ", dateLastPrinted=" + dateLastPrinted +
                ", lastSavedBy='" + lastSavedBy + '\'' +
                ", revision='" + revision + '\'' +
                ", pageCount=" + pageCount +
                ", originalId=" + originalId +
                ", userEntered='" + userEntered + '\'' +
                '}';
    }
}
