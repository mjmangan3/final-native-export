package com.vereview.model;

import java.util.Date;

public class FileExportError {
    private Long fileId;
    private String stackTrace;
    private Date dateCreated;
    private Long exportId;
    private String jsonMessage;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getExportId() {
        return exportId;
    }

    public void setExportId(Long exportId) {
        this.exportId = exportId;
    }

    public String getJsonMessage() {
        return jsonMessage;
    }

    public void setJsonMessage(String jsonMessage) {
        this.jsonMessage = jsonMessage;
    }
}
