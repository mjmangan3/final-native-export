package com.vereview.model;

/**
 * Created by mjmangan on 8/11/17.
 */
public class FileLocation {
    private Long id;
    private Long fileId;
    private String type;
    private Long part;
    private Long size;
    private String md5Hash;
    private String sha1Hash;
    private String name;
    private String location;
    private String unixLocation;
    private Boolean placeHolder;
    private Boolean compressed;
    private Boolean isDetected;
    private String encoding;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPart() {
        return part;
    }

    public void setPart(Long part) {
        this.part = part;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getDetected() {
        return isDetected;
    }

    public void setDetected(Boolean detected) {
        isDetected = detected;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public String toString() {
        return "FileLocation{" +
                "id=" + id +
                ", fileId=" + fileId +
                ", type='" + type + '\'' +
                ", part=" + part +
                ", size=" + size +
                ", md5Hash='" + md5Hash + '\'' +
                ", sha1Hash='" + sha1Hash + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", unixLocation='" + unixLocation + '\'' +
                ", placeHolder=" + placeHolder +
                ", compressed=" + compressed +
                ", isDetected=" + isDetected +
                ", encoding='" + encoding + '\'' +
                '}';
    }
}
