package com.vereview.model;

/**
 * Created by mjmangan on 8/11/17.
 */
public class FileTag {
    private Long id;
    private Long fileId;
    private Long tagId;

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

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "FileTag{" +
                "id=" + id +
                ", fileId=" + fileId +
                ", tagId=" + tagId +
                '}';
    }
}
