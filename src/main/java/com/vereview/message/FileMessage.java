package com.vereview.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vereview.model.Export;

import java.nio.file.Path;
import java.util.Map;

/**
 * Created by mjmangan on 9/3/17.
 */
public class FileMessage implements Comparable<FileMessage>{
    private Long fileId;
    private String documentId;
    private Map<String, String> row;
    private Path nativeExportFile;
    private Path nativeVeFile;
    private Path textExportFile;
    private Path redactedTextExportFile;
    private TextInfo textVeFiles;
    private Export export;


    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Map<String, String> getRow() {
        return row;
    }

    public void setRow(Map<String, String> row) {
        this.row = row;
    }

    public Path getNativeExportFile() {
        return nativeExportFile;
    }

    public void setNativeExportFile(Path nativeExportFile) {
        this.nativeExportFile = nativeExportFile;
    }

    public Path getNativeVeFile() {
        return nativeVeFile;
    }

    public void setNativeVeFile(Path nativeVeFile) {
        this.nativeVeFile = nativeVeFile;
    }

    public Path getTextExportFile() {
        return textExportFile;
    }

    public void setTextExportFile(Path textExportFile) {
        this.textExportFile = textExportFile;
    }

    public Path getRedactedTextExportFile() {
        return redactedTextExportFile;
    }

    public void setRedactedTextExportFile(Path redactedTextExportFile) {
        this.redactedTextExportFile = redactedTextExportFile;
    }

    public TextInfo getTextVeFiles() {
        return textVeFiles;
    }

    public void setTextVeFiles(TextInfo textVeFiles) {
        this.textVeFiles = textVeFiles;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public int compareTo(FileMessage other) {
        return this.documentId.compareTo(other.getDocumentId());
    }

    public Export getExport() {
        return export;
    }

    public void setExport(Export export) {
        this.export = export;
    }

    @Override
    public String toString() {
        return "FileMessage{" +
                "fileId=" + fileId +
                ", documentId='" + documentId + '\'' +
                ", row=" + row +
                ", nativeExportFile=" + nativeExportFile +
                ", nativeVeFile=" + nativeVeFile +
                ", textExportFile=" + textExportFile +
                ", redactedTextExportFile=" + redactedTextExportFile +
                ", textVeFiles=" + textVeFiles +
                '}';
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
