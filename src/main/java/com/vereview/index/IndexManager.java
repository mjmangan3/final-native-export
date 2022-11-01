package com.vereview.index;

import com.vereview.model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mjmangan on 8/13/17.
 */
public class IndexManager {
    private static final IndexManager instance = new IndexManager();

    private Map<Long, File> fileByFileId;
    private Map<Long, FileProduction> fileProductionByFileId;
    private Map<Long, Folder> folderByFolderId;
    private Map<Long, String> custodainByCustodianId;
    private Map<Long, DocumentNumbers> documentNumbersByFileId;
    private Map<Long, Email> emailByFileId;
    private Map<Long, Property> propertyByFileId;
    private Map<Long, String> tagByTagId;
    private Map<Long, Set<String>> tagsByFileId;
    private Map<Long, String> bookmarkByBookmarkId;
    private Map<Long, Set<String>> bookmarksByFileId;
    private Map<Long, String> questionsByQuestionId;
    private Map<Long, String> responseByResponseId;
    private Map<Long, Map<Long, List<Answer>>> answersByFileId;
    private Map<Long, FileLocation> nativeFileLocationByFileId;
    private Map<Long, FileLocation> textFileLocationByFileId;
    private Map<Long, Map<Long, PageInfo>> textPageInfosByFileId;
    private Map<Long, Map<Long, PageInfo>> redactedTextPageInfosByFileId;
    private Map<Long, String> categoriesByCategoryId;

    private IndexManager(){

    }

    public void clear() {
        this.fileByFileId = null;
        this.fileProductionByFileId = null;
        this.folderByFolderId = null;
        this.custodainByCustodianId = null;
        this.documentNumbersByFileId = null;
        this.emailByFileId = null;
        this.propertyByFileId = null;
        this.tagByTagId = null;
        this.tagsByFileId = null;
        this.bookmarkByBookmarkId = null;
        this.bookmarksByFileId = null;
        this.questionsByQuestionId = null;
        this.responseByResponseId = null;
        this.answersByFileId = null;
        this.nativeFileLocationByFileId = null;
        this.textFileLocationByFileId = null;
        this.textPageInfosByFileId = null;
        this.redactedTextPageInfosByFileId = null;
        this.categoriesByCategoryId = null;
    }

    public static IndexManager getInstance(){
        return instance;
    }

    public Map<Long, File> getFileByFileId() {
        return fileByFileId;
    }

    public void setFileByFileId(Map<Long, File> fileByFileId) {
        this.fileByFileId = fileByFileId;
    }

    public Map<Long, FileProduction> getFileProductionByFileId() {
        return fileProductionByFileId;
    }

    public void setFileProductionByFileId(Map<Long, FileProduction> fileProductionByFileId) {
        this.fileProductionByFileId = fileProductionByFileId;
    }

    public Map<Long, Folder> getFolderByFolderId() {
        return folderByFolderId;
    }

    public void setFolderByFolderId(Map<Long, Folder> folderByFolderId) {
        this.folderByFolderId = folderByFolderId;
    }

    public Map<Long, String> getCustodainByCustodianId() {
        return custodainByCustodianId;
    }

    public void setCustodainByCustodianId(Map<Long, String> custodainByCustodianId) {
        this.custodainByCustodianId = custodainByCustodianId;
    }

    public Map<Long, DocumentNumbers> getDocumentNumbersByFileId() {
        return documentNumbersByFileId;
    }

    public void setDocumentNumbersByFileId(Map<Long, DocumentNumbers> documentNumbersByFileId) {
        this.documentNumbersByFileId = documentNumbersByFileId;
    }

    public Map<Long, Email> getEmailByFileId() {
        return emailByFileId;
    }

    public void setEmailByFileId(Map<Long, Email> emailByFileId) {
        this.emailByFileId = emailByFileId;
    }

    public Map<Long, Property> getPropertyByFileId() {
        return propertyByFileId;
    }

    public void setPropertyByFileId(Map<Long, Property> propertyByFileId) {
        this.propertyByFileId = propertyByFileId;
    }

    public Map<Long, String> getTagByTagId() {
        return tagByTagId;
    }

    public void setTagByTagId(Map<Long, String> tagByTagId) {
        this.tagByTagId = tagByTagId;
    }

    public Map<Long, Set<String>> getTagsByFileId() {
        return tagsByFileId;
    }

    public void setTagsByFileId(Map<Long, Set<String>> tagsByFileId) {
        this.tagsByFileId = tagsByFileId;
    }

    public Map<Long, String> getBookmarkByBookmarkId() {
        return bookmarkByBookmarkId;
    }

    public void setBookmarkByBookmarkId(Map<Long, String> bookmarkByBookmarkId) {
        this.bookmarkByBookmarkId = bookmarkByBookmarkId;
    }

    public Map<Long, Set<String>> getBookmarksByFileId() {
        return bookmarksByFileId;
    }

    public void setBookmarksByFileId(Map<Long, Set<String>> bookmarksByFileId) {
        this.bookmarksByFileId = bookmarksByFileId;
    }

    public Map<Long, String> getQuestionsByQuestionId() {
        return questionsByQuestionId;
    }

    public void setQuestionsByQuestionId(Map<Long, String> questionsByQuestionId) {
        this.questionsByQuestionId = questionsByQuestionId;
    }

    public Map<Long, String> getResponseByResponseId() {
        return responseByResponseId;
    }

    public void setResponseByResponseId(Map<Long, String> responseByResponseId) {
        this.responseByResponseId = responseByResponseId;
    }

    public Map<Long, Map<Long, List<Answer>>> getAnswersByFileId() {
        return answersByFileId;
    }

    public void setAnswersByFileId(Map<Long, Map<Long, List<Answer>>> answersByFileId) {
        this.answersByFileId = answersByFileId;
    }

    public Map<Long, FileLocation> getNativeFileLocationByFileId() {
        return nativeFileLocationByFileId;
    }

    public void setNativeFileLocationByFileId(Map<Long, FileLocation> nativeFileLocationByFileId) {
        this.nativeFileLocationByFileId = nativeFileLocationByFileId;
    }

    public Map<Long, FileLocation> getTextFileLocationByFileId() {
        return textFileLocationByFileId;
    }

    public void setTextFileLocationByFileId(Map<Long, FileLocation> textFileLocationByFileId) {
        this.textFileLocationByFileId = textFileLocationByFileId;
    }

    public Map<Long, Map<Long, PageInfo>> getTextPageInfosByFileId() {
        return textPageInfosByFileId;
    }

    public void setTextPageInfosByFileId(Map<Long, Map<Long, PageInfo>> textPageInfosByFileId) {
        this.textPageInfosByFileId = textPageInfosByFileId;
    }

    public Map<Long, Map<Long, PageInfo>> getRedactedTextPageInfosByFileId() {
        return redactedTextPageInfosByFileId;
    }

    public void setRedactedTextPageInfosByFileId(Map<Long, Map<Long, PageInfo>> redactedTextPageInfosByFileId) {
        this.redactedTextPageInfosByFileId = redactedTextPageInfosByFileId;
    }

    public Map<Long, String> getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Map<Long, String> categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }
}
