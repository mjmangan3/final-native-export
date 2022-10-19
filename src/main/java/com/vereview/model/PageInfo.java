package com.vereview.model;

import java.nio.file.Path;

/**
 * Created by mjmangan on 9/9/17.
 */
public class PageInfo {
    private Long fileId;
    private Long pageNumber;
    private PageLocationType type;
    private Path location;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PageLocationType getType() {
        return type;
    }

    public void setType(PageLocationType type) {
        this.type = type;
    }

    public Path getLocation() {
        return location;
    }

    public void setLocation(Path location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "fileId=" + fileId +
                ", pageNumber=" + pageNumber +
                ", type=" + type +
                ", location=" + location +
                '}';
    }
}
