package com.vereview.model;



/**
 * Created by mjmangan on 8/11/17.
 */
public class PageLocation {
    private Long id;
    private Long pageId;
    private String type;
    private Long size;
    private String md5Hash;
    private String sha1Hash;
    private String location;
    private String unixLocation;
    private Long productionId;
    private String bates;
    private Long ocrSize;
    private Boolean placeHolder;
    private Boolean compressed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUnixLocation() {
        return unixLocation;
    }

    public void setUnixLocation(String unixLocation) {
        this.unixLocation = unixLocation;
    }

    public Long getProductionId() {
        return productionId;
    }

    public void setProductionId(Long productionId) {
        this.productionId = productionId;
    }

    public String getBates() {
        return bates;
    }

    public void setBates(String bates) {
        this.bates = bates;
    }

    public Long getOcrSize() {
        return ocrSize;
    }

    public void setOcrSize(Long ocrSize) {
        this.ocrSize = ocrSize;
    }

    public Boolean getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(Boolean placeHolder) {
        this.placeHolder = placeHolder;
    }

    public Boolean getCompressed() {
        return compressed;
    }

    public void setCompressed(Boolean compressed) {
        this.compressed = compressed;
    }

    @Override
    public String toString() {
        return "PageLocation{" +
                "id=" + id +
                ", pageId=" + pageId +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", md5Hash='" + md5Hash + '\'' +
                ", sha1Hash='" + sha1Hash + '\'' +
                ", location='" + location + '\'' +
                ", unixLocation='" + unixLocation + '\'' +
                ", productionId=" + productionId +
                ", bates='" + bates + '\'' +
                ", ocrSize=" + ocrSize +
                ", placeHolder=" + placeHolder +
                ", compressed=" + compressed +
                '}';
    }
}
