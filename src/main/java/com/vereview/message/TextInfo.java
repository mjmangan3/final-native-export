package com.vereview.message;

import com.vereview.model.PageInfo;

import java.nio.file.Path;
import java.util.Map;

/**
 * Created by mjmangan on 9/9/17.
 */
public class TextInfo {
    private Path fileText;
    private Boolean pageText = false;
    private Map<Long, PageInfo> textFilePaths;
    private Boolean redactedPageText = false;
    private Map<Long, PageInfo> redactedTextPaths;

    public Path getFileText() {
        return fileText;
    }

    public void setFileText(Path fileText) {
        this.fileText = fileText;
    }

    public Boolean hasPageText() {
        return pageText;
    }

    public void setPageText(Boolean pageText) {
        this.pageText = pageText;
    }

    public Map<Long, PageInfo> getTextFilePaths() {
        return textFilePaths;
    }

    public void setTextFilePaths(Map<Long, PageInfo> textFilePaths) {
        this.textFilePaths = textFilePaths;
    }

    public Boolean hasRedactedPageText() {
        return redactedPageText;
    }

    public void setRedactedPageText(Boolean redactedPageText) {
        this.redactedPageText = redactedPageText;
    }

    public Map<Long, PageInfo> getRedactedTextPaths() {
        return redactedTextPaths;
    }

    public void setRedactedTextPaths(Map<Long, PageInfo> redactedTextPaths) {
        this.redactedTextPaths = redactedTextPaths;
    }
}
