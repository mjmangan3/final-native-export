package com.vereview.model;

/**
 * Created by mjmangan on 8/16/17.
 */
public class DocumentNumbers {
    private Long fileId;
    private String begDoc;
    private String endDoc;
    private String begAttach;
    private String endAttach;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getBegDoc() {
        return begDoc;
    }

    public void setBegDoc(String begDoc) {
        this.begDoc = begDoc;
    }

    public String getEndDoc() {
        return endDoc;
    }

    public void setEndDoc(String endDoc) {
        this.endDoc = endDoc;
    }

    public String getBegAttach() {
        return begAttach;
    }

    public void setBegAttach(String begAttach) {
        this.begAttach = begAttach;
    }

    public String getEndAttach() {
        return endAttach;
    }

    public void setEndAttach(String endAttach) {
        this.endAttach = endAttach;
    }

    @Override
    public String toString() {
        return "DocumentNumbers{" +
                "fileId=" + fileId +
                ", begDoc='" + begDoc + '\'' +
                ", endDoc='" + endDoc + '\'' +
                ", begAttach='" + begAttach + '\'' +
                ", endAttach='" + endAttach + '\'' +
                '}';
    }
}
