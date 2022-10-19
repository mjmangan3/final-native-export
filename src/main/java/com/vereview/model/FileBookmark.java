package com.vereview.model;

import java.util.Date;

/**
 * Created by mjmangan on 8/11/17.
 */
public class FileBookmark {
    private Long id;
    private Long bookmarkId;
    private Long fileId;
    private Date dateAdded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(Long bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "FileBookmark{" +
                "id=" + id +
                ", bookmarkId=" + bookmarkId +
                ", fileId=" + fileId +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
