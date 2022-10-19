package com.vereview.processor;

import com.vereview.dao.*;
import com.vereview.message.DaoMessage;
import com.vereview.model.File;

import java.sql.SQLException;

public class DaoProcessor {
    private ConnectionManager mgr;

    public DaoProcessor(ConnectionManager mgr) {
        this.mgr = mgr;
    }

    public DaoMessage process(Long fileId) throws SQLException {
        DaoMessage m = new DaoMessage();

        FileDao fileDao = new FileDao(mgr);
        File file = fileDao.findFileByFileId(fileId);
        m.setFile(file);

        m.setFamily(fileDao.findFileByFileId(file.getFamilyId()));

        m.setParent(fileDao.findFileByFileId(file.getParentId()));

        FolderDao folderDao = new FolderDao(mgr);
        m.setFolder(folderDao.findFolderByFolderId(file.getFolderId()));

        EmailDao emailDao = new EmailDao(mgr);
        m.setEmail(emailDao.fetchEmailByFileId(fileId));

        PropertyDao propertyDao = new PropertyDao(mgr);
        m.setProperty(propertyDao.findPropertyByFileId(fileId));

        FileTagDao tagDao = new FileTagDao(mgr);
        m.setTags(tagDao.findFileTagsByFileId(fileId));

        FileBookmarkDao fileBookmarkDao = new FileBookmarkDao(mgr);
        m.setBookmarks(fileBookmarkDao.fetchBookmarksByFileId(fileId));

        AnswerDao answerDao = new AnswerDao(mgr);
        m.setAnswerMap(answerDao.getAnswersByFileId(fileId));

        return m;
    }
}
