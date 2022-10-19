package com.vereview.dao;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/23/17.
 */
public class BookmarkDaoTest extends DaoTest {
    /*
    @Test
    public void findAllTest(){
        try {
            BookmarkDao dao = new BookmarkDao(mgr);
            Map<Long, String> bookmarks = dao.findAll();
            bookmarks.forEach((k,v) -> {
                System.out.println("BookmarkId: " + k + " | Name: " + v);
            });
            System.out.println(bookmarks.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
