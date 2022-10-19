package com.vereview.model;


import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by mjmangan on 8/11/17.
 */
public class File {
    private Long fileId;
    private Date dateLastUpdated;
    private Date dateLoaded;
    private Long rootParentId;
    private Long parentId;
    private Long familyId;
    private String type;
    private Long custodianId;
    private Long deviceId;
    private Long folderId;
    private Long assignedUserId;
    private Long checkoutUserId;
    private Long reviewLevelId;
    private Long categoryId;
    private Boolean hotDoc;
    private Boolean locked;
    private Long lastReviewerId;
    private Date dateLastReviewed;
    private Boolean viewable;
    private Date docDate;
    private Date dateCreated;
    private Date dateModified;
    private Date dateAccessed;
    private Date dateDeleted;
    private Boolean deleted;
    private String number;
    private String name;
    private String extension;
    private String suggestedExtension;
    private Long size;
    private String application;
    private String signature;
    private Boolean protectedFile;
    private Boolean corrupted;
    private Boolean filePatch;
    private Boolean cracked;
    private String password;
    private Long sourceId;
    private Long pageCount;
    private Boolean tiffOverride;
    private Boolean tiffEnabled;
    private Boolean ocrOverride;
    private String md5Hash;
    private String sha1Hash;
    private String emd5Hash;
    private String esha1Hash;
    private String sha128Hash;
    private String esha128Hash;
    private Boolean daejaRedacted;
    private Boolean daejaHasStickyNotes;
    private Boolean daejaHighlighted;
    private Boolean daejaHasText;
    private Long techId;
    private Long evidenceId;
    private Boolean extracted;
    private String loaderVersion;
    private Long originalId;
    private String endNumber;
    private Boolean hastext;
    private String userEntered;
    private String prefix;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public void setDateLastUpdated(Timestamp dateLastUpdated) {
        if(dateLastUpdated != null) {
            this.dateLastUpdated = new Date(dateLastUpdated.getTime());
        }
    }

    public Date getDateLoaded() {
        return dateLoaded;
    }

    public void setDateLoaded(Date dateLoaded) {
        this.dateLoaded = dateLoaded;
    }

    public void setDateLoaded(Timestamp dateLoaded) {
        if(dateLoaded != null) {
            this.dateLoaded = new Date(dateLoaded.getTime());
        }
    }

    public Long getRootParentId() {
        return rootParentId;
    }

    public void setRootParentId(Long rootParentId) {
        this.rootParentId = rootParentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCustodianId() {
        return custodianId;
    }

    public void setCustodianId(Long custodianId) {
        this.custodianId = custodianId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public Long getCheckoutUserId() {
        return checkoutUserId;
    }

    public void setCheckoutUserId(Long checkoutUserId) {
        this.checkoutUserId = checkoutUserId;
    }

    public Long getReviewLevelId() {
        return reviewLevelId;
    }

    public void setReviewLevelId(Long reviewLevelId) {
        this.reviewLevelId = reviewLevelId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getHotDoc() {
        return hotDoc;
    }

    public void setHotDoc(Boolean hotDoc) {
        this.hotDoc = hotDoc;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Long getLastReviewerId() {
        return lastReviewerId;
    }

    public void setLastReviewerId(Long lastReviewerId) {
        this.lastReviewerId = lastReviewerId;
    }

    public Date getDateLastReviewed() {
        return dateLastReviewed;
    }

    public void setDateLastReviewed(Date dateLastReviewed) {
        this.dateLastReviewed = dateLastReviewed;
    }

    public void setDateLastReviewed(Timestamp dateLastReviewed) {
        if(dateLastReviewed != null) {
            this.dateLastReviewed = new Date(dateLastReviewed.getTime());
        }
    }

    public Boolean getViewable() {
        return viewable;
    }

    public void setViewable(Boolean viewable) {
        this.viewable = viewable;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setDocDate(Timestamp docDate) {
        if(docDate != null) {
            this.docDate = new Date(docDate.getTime());
        }
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        if(dateCreated != null) {
            this.dateCreated = new Date(dateCreated.getTime());
        }
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        if(dateModified != null) {
            this.dateModified = new Date(dateModified.getTime());
        }
    }

    public Date getDateAccessed() {
        return dateAccessed;
    }

    public void setDateAccessed(Date dateAccessed) {
        this.dateAccessed = dateAccessed;
    }

    public void setDateAccessed(Timestamp dateAccessed) {
        if(dateAccessed != null) {
            this.dateAccessed = new Date(dateAccessed.getTime());
        }
    }

    public Date getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public void setDateDeleted(Timestamp dateDeleted) {
        if(dateDeleted != null) {
            this.dateDeleted = new Date(dateDeleted.getTime());
        }
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getSuggestedExtension() {
        return suggestedExtension;
    }

    public void setSuggestedExtension(String suggestedExtension) {
        this.suggestedExtension = suggestedExtension;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Boolean getProtectedFile() {
        return protectedFile;
    }

    public void setProtectedFile(Boolean protectedFile) {
        this.protectedFile = protectedFile;
    }

    public Boolean getCorrupted() {
        return corrupted;
    }

    public void setCorrupted(Boolean corrupted) {
        this.corrupted = corrupted;
    }

    public Boolean getFilePatch() {
        return filePatch;
    }

    public void setFilePatch(Boolean filePatch) {
        this.filePatch = filePatch;
    }

    public Boolean getCracked() {
        return cracked;
    }

    public void setCracked(Boolean cracked) {
        this.cracked = cracked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Boolean getTiffOverride() {
        return tiffOverride;
    }

    public void setTiffOverride(Boolean tiffOverride) {
        this.tiffOverride = tiffOverride;
    }

    public Boolean getTiffEnabled() {
        return tiffEnabled;
    }

    public void setTiffEnabled(Boolean tiffEnabled) {
        this.tiffEnabled = tiffEnabled;
    }

    public Boolean getOcrOverride() {
        return ocrOverride;
    }

    public void setOcrOverride(Boolean ocrOverride) {
        this.ocrOverride = ocrOverride;
    }

    public String getMd5Hash() {
        return md5Hash;
    }

    public void setMd5Hash(String md5Hash) {
        this.md5Hash = md5Hash;
    }

    public String getSha1Hash() {
        return sha1Hash;
    }

    public void setSha1Hash(String sha1Hash) {
        this.sha1Hash = sha1Hash;
    }

    public String getEmd5Hash() {
        return emd5Hash;
    }

    public void setEmd5Hash(String emd5Hash) {
        this.emd5Hash = emd5Hash;
    }

    public String getEsha1Hash() {
        return esha1Hash;
    }

    public void setEsha1Hash(String esha1Hash) {
        this.esha1Hash = esha1Hash;
    }

    public String getSha128Hash() {
        return sha128Hash;
    }

    public void setSha128Hash(String sha128Hash) {
        this.sha128Hash = sha128Hash;
    }

    public String getEsha128Hash() {
        return esha128Hash;
    }

    public void setEsha128Hash(String esha128Hash) {
        this.esha128Hash = esha128Hash;
    }

    public Boolean getDaejaRedacted() {
        return daejaRedacted;
    }

    public void setDaejaRedacted(Boolean daejaRedacted) {
        this.daejaRedacted = daejaRedacted;
    }

    public Boolean getDaejaHasStickyNotes() {
        return daejaHasStickyNotes;
    }

    public void setDaejaHasStickyNotes(Boolean daejaHasStickyNotes) {
        this.daejaHasStickyNotes = daejaHasStickyNotes;
    }

    public Boolean getDaejaHighlighted() {
        return daejaHighlighted;
    }

    public void setDaejaHighlighted(Boolean daejaHighlighted) {
        this.daejaHighlighted = daejaHighlighted;
    }

    public Boolean getDaejaHasText() {
        return daejaHasText;
    }

    public void setDaejaHasText(Boolean daejaHasText) {
        this.daejaHasText = daejaHasText;
    }

    public Long getTechId() {
        return techId;
    }

    public void setTechId(Long techId) {
        this.techId = techId;
    }

    public Long getEvidenceId() {
        return evidenceId;
    }

    public void setEvidenceId(Long evidenceId) {
        this.evidenceId = evidenceId;
    }

    public Boolean getExtracted() {
        return extracted;
    }

    public void setExtracted(Boolean extracted) {
        this.extracted = extracted;
    }

    public String getLoaderVersion() {
        return loaderVersion;
    }

    public void setLoaderVersion(String loaderVersion) {
        this.loaderVersion = loaderVersion;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }

    public String getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(String endNumber) {
        this.endNumber = endNumber;
    }

    public Boolean getHastext() {
        return hastext;
    }

    public void setHastext(Boolean hastext) {
        this.hastext = hastext;
    }

    public String getUserEntered() {
        return userEntered;
    }

    public void setUserEntered(String userEntered) {
        this.userEntered = userEntered;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", dateLastUpdated=" + dateLastUpdated +
                ", dateLoaded=" + dateLoaded +
                ", rootParentId=" + rootParentId +
                ", parentId=" + parentId +
                ", familyId=" + familyId +
                ", type='" + type + '\'' +
                ", custodianId=" + custodianId +
                ", deviceId=" + deviceId +
                ", folderId=" + folderId +
                ", assignedUserId=" + assignedUserId +
                ", checkoutUserId=" + checkoutUserId +
                ", reviewLevelId=" + reviewLevelId +
                ", categoryId=" + categoryId +
                ", hotDoc=" + hotDoc +
                ", locked=" + locked +
                ", lastReviewerId=" + lastReviewerId +
                ", dateLastReviewed=" + dateLastReviewed +
                ", viewable=" + viewable +
                ", docDate=" + docDate +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", dateAccessed=" + dateAccessed +
                ", dateDeleted=" + dateDeleted +
                ", deleted=" + deleted +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                ", suggestedExtension='" + suggestedExtension + '\'' +
                ", size=" + size +
                ", application='" + application + '\'' +
                ", signature='" + signature + '\'' +
                ", protectedFile=" + protectedFile +
                ", corrupted=" + corrupted +
                ", filePatch=" + filePatch +
                ", cracked=" + cracked +
                ", password='" + password + '\'' +
                ", sourceId=" + sourceId +
                ", pageCount=" + pageCount +
                ", tiffOverride=" + tiffOverride +
                ", tiffEnabled=" + tiffEnabled +
                ", ocrOverride=" + ocrOverride +
                ", md5Hash='" + md5Hash + '\'' +
                ", sha1Hash='" + sha1Hash + '\'' +
                ", emd5Hash='" + emd5Hash + '\'' +
                ", esha1Hash='" + esha1Hash + '\'' +
                ", sha128Hash='" + sha128Hash + '\'' +
                ", esha128Hash='" + esha128Hash + '\'' +
                ", daejaRedacted=" + daejaRedacted +
                ", daejaHasStickyNotes=" + daejaHasStickyNotes +
                ", daejaHighlighted=" + daejaHighlighted +
                ", daejaHasText=" + daejaHasText +
                ", techId=" + techId +
                ", evidenceId=" + evidenceId +
                ", extracted=" + extracted +
                ", loaderVersion='" + loaderVersion + '\'' +
                ", originalId=" + originalId +
                ", endNumber='" + endNumber + '\'' +
                ", hastext=" + hastext +
                ", userEntered='" + userEntered + '\'' +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}
