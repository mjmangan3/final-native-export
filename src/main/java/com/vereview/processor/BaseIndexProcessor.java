package com.vereview.processor;

import com.vereview.dao.*;
import com.vereview.index.IndexManager;

import java.sql.SQLException;

public class BaseIndexProcessor {
    private IndexManager indexManager;
    private ConnectionManager mgr;

    public BaseIndexProcessor(IndexManager indexManager, ConnectionManager mgr) {
        this.indexManager = indexManager;
        this.mgr = mgr;
    }

    public void process() throws SQLException {

        CustodianDao custodianDao = new CustodianDao(mgr);
        indexManager.setCustodainByCustodianId(custodianDao.findAll());

        TagDao tagDao = new TagDao(mgr);
        indexManager.setTagByTagId(tagDao.getTags());

        BookmarkDao bookmarkDao = new BookmarkDao(mgr);
        indexManager.setBookmarkByBookmarkId(bookmarkDao.findAll());

        QuestionDao questionDao = new QuestionDao(mgr);
        indexManager.setQuestionsByQuestionId(questionDao.getQuestions());

        ResponseDao responseDao = new ResponseDao(mgr);
        indexManager.setResponseByResponseId(responseDao.getResponses());

        CategoryDao categoryDao = new CategoryDao(mgr);
        indexManager.setCategoriesByCategoryId(categoryDao.getCategories());

    }
}
