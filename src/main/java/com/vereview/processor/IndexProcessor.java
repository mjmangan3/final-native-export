package com.vereview.processor;

import com.vereview.dao.*;
import com.vereview.index.IndexManager;
import com.vereview.model.Email;
import com.vereview.model.Export;
import com.vereview.model.PageLocationType;
import com.vereview.model.Property;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by mjmangan on 9/4/17.
 */
public class IndexProcessor {
    private IndexManager indexManager;
    private ConnectionManager mgr;

    public IndexProcessor(IndexManager indexManager, ConnectionManager mgr) {
        this.indexManager = indexManager;
        this.mgr = mgr;
    }

    public void process() throws SQLException{
        FileDao fileDao = new FileDao(mgr);
        indexManager.setFileByFileId(fileDao.findAll());

        FolderDao folderDao = new FolderDao(mgr);
        indexManager.setFolderByFolderId(folderDao.findAll());

        CustodianDao custodianDao = new CustodianDao(mgr);
        indexManager.setCustodainByCustodianId(custodianDao.findAll());


        EmailDao emailDao = new EmailDao(mgr);
        Map<Long, Email> emailIndex = emailDao.fetchAllEmails();
        indexManager.setEmailByFileId(emailIndex);

        PropertyDao propertyDao = new PropertyDao(mgr);
        Map<Long, Property> properties = propertyDao.findAll();
        indexManager.setPropertyByFileId(properties);

        TagDao tagDao = new TagDao(mgr);
        indexManager.setTagByTagId(tagDao.getTags());

        FileTagDao fileTagDao = new FileTagDao(mgr);
        indexManager.setTagsByFileId(fileTagDao.getFileTags());

        BookmarkDao bookmarkDao = new BookmarkDao(mgr);
        indexManager.setBookmarkByBookmarkId(bookmarkDao.findAll());

        FileBookmarkDao fileBookmarkDao = new FileBookmarkDao(mgr);
        indexManager.setBookmarksByFileId(fileBookmarkDao.getFileBookmarks());

        QuestionDao questionDao = new QuestionDao(mgr);
        indexManager.setQuestionsByQuestionId(questionDao.getQuestions());

        ResponseDao responseDao = new ResponseDao(mgr);
        indexManager.setResponseByResponseId(responseDao.getResponses());

        AnswerDao answerDao = new AnswerDao(mgr);
        indexManager.setAnswersByFileId(answerDao.getAnswers());

        CategoryDao categoryDao = new CategoryDao(mgr);
        indexManager.setCategoriesByCategoryId(categoryDao.getCategories());

        FileLocationDao fileLocationDao = new FileLocationDao(mgr);
        indexManager.setNativeFileLocationByFileId(fileLocationDao.fetchFileLocationsByType("NATIVE"));
        indexManager.setTextFileLocationByFileId(fileLocationDao.fetchFileLocationsByType("TXT"));

        PageInfoDao pageInfoDao = new PageInfoDao(mgr);
        indexManager.setTextPageInfosByFileId(pageInfoDao.getPageInfoByType(PageLocationType.TEXT));
        indexManager.setRedactedTextPageInfosByFileId(pageInfoDao.getPageInfoByType(PageLocationType.REDACTED_TEXT));
    }

    public void process(Export export) throws SQLException {
        indexManager.clear();

        FileDao fileDao = new FileDao(mgr);
        indexManager.setFileByFileId(fileDao.findAllByExportId(export.getExportId()));

        FolderDao folderDao = new FolderDao(mgr);
        indexManager.setFolderByFolderId(folderDao.findByExportId(export.getExportId()));

        CustodianDao custodianDao = new CustodianDao(mgr);
        indexManager.setCustodainByCustodianId(custodianDao.findByExportId(export.getExportId()));


        EmailDao emailDao = new EmailDao(mgr);
        Map<Long, Email> emailIndex = emailDao.fetchByExportId(export.getExportId());
        indexManager.setEmailByFileId(emailIndex);

        PropertyDao propertyDao = new PropertyDao(mgr);
        Map<Long, Property> properties = propertyDao.findByExportId(export.getExportId());
        indexManager.setPropertyByFileId(properties);

        TagDao tagDao = new TagDao(mgr);
        indexManager.setTagByTagId(tagDao.getTags());

        FileTagDao fileTagDao = new FileTagDao(mgr);
        indexManager.setTagsByFileId(fileTagDao.getFileTagsByExportId(export.getExportId()));

        BookmarkDao bookmarkDao = new BookmarkDao(mgr);
        indexManager.setBookmarkByBookmarkId(bookmarkDao.findAll());

        FileBookmarkDao fileBookmarkDao = new FileBookmarkDao(mgr);
        indexManager.setBookmarksByFileId(fileBookmarkDao.getFileBookmarksByExportId(export.getExportId()));

        QuestionDao questionDao = new QuestionDao(mgr);
        indexManager.setQuestionsByQuestionId(questionDao.getQuestions());

        ResponseDao responseDao = new ResponseDao(mgr);
        indexManager.setResponseByResponseId(responseDao.getResponses());

        AnswerDao answerDao = new AnswerDao(mgr);
        indexManager.setAnswersByFileId(answerDao.getAnswersByExportId(export.getExportId()));

        CategoryDao categoryDao = new CategoryDao(mgr);
        indexManager.setCategoriesByCategoryId(categoryDao.getCategories());

        FileLocationDao fileLocationDao = new FileLocationDao(mgr);
        indexManager.setNativeFileLocationByFileId(fileLocationDao.fetchFileLocationsByTypeAndExportId("NATIVE", export.getExportId()));
        indexManager.setTextFileLocationByFileId(fileLocationDao.fetchFileLocationsByTypeAndExportId("TXT", export.getExportId())  );

        PageInfoDao pageInfoDao = new PageInfoDao(mgr);
        indexManager.setTextPageInfosByFileId(pageInfoDao.getPageInfoByTypeAndExportId(PageLocationType.TEXT, export.getExportId()));
        indexManager.setRedactedTextPageInfosByFileId(pageInfoDao.getPageInfoByTypeAndExportId(PageLocationType.REDACTED_TEXT, export.getExportId()));
    }
}
