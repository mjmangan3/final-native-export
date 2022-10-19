package com.vereview.dao;

import com.vereview.index.IndexManager;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by mjmangan on 8/23/17.
 */
public class FileBookmarkDaoTest extends DaoTest{

    /*
    @Test
    public void getFileBookmarksTest(){
        try {
            IndexManager indexManager = IndexManager.getInstance();
            BookmarkDao bDao = new BookmarkDao(mgr);
            indexManager.setBookmarkByBookmarkId(bDao.findAll());
            FileBookmarkDao dao = new FileBookmarkDao(mgr);
            Map<Long, Set<String>> fileBookmarks = dao.getFileBookmarks();
            fileBookmarks.forEach((k,v) -> {
                System.out.println("FileId: " + k + " | " + v);
            });
            System.out.println(fileBookmarks.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
