package com.vereview.dao;

import com.vereview.index.IndexManager;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by mjmangan on 8/22/17.
 */
public class FileTagDaoTest extends DaoTest {

    /*
    @Test
    public void getFileTagsTest(){
        try {
            IndexManager indexManager = IndexManager.getInstance();
            TagDao tagDao = new TagDao(mgr);
            indexManager.setTagByTagId(tagDao.getTags());
            FileTagDao dao = new FileTagDao(mgr);
            Map<Long, Set<String>> fts = dao.getFileTags();
            fts.forEach((k,v) -> {
                System.out.println("FileId: " + k + " | tags: " + v);
            });
            System.out.println(fts.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
