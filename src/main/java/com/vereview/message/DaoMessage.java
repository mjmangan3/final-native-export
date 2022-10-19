package com.vereview.message;

import com.vereview.model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DaoMessage {
    private File file;
    private File family;
    private Folder folder;
    private File parent;
    private Email email;
    private Property property;
    private Set<String> tags;
    private Set<String> bookmarks;
    private Map<Long, List<Answer>> answerMap;


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFamily() {
        return family;
    }

    public void setFamily(File family) {
        this.family = family;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public File getParent() {
        return parent;
    }

    public void setParent(File parent) {
        this.parent = parent;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Set<String> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<String> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Map<Long, List<Answer>> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<Long, List<Answer>> answerMap) {
        this.answerMap = answerMap;
    }
}
