package com.vereview.job;

import com.vereview.dao.*;
import com.vereview.index.IndexManager;
import com.vereview.model.Email;
import com.vereview.model.FileProduction;
import com.vereview.model.Property;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by mjmangan on 9/4/17.
 */
public class IndexCreationJob {
    private ConnectionManager mgr;

    public IndexCreationJob(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public void run() throws SQLException{
        IndexManager indexManager = IndexManager.getInstance();
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
    }
}
