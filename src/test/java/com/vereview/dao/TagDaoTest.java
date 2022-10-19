package com.vereview.dao;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/22/17.
 */
public class TagDaoTest extends DaoTest {

    /*
    @Test
    public void getTagsTest(){
        try {
            TagDao dao = new TagDao(mgr);
            Map<Long, String> tags = dao.getTags();
            tags.forEach((k,v) -> {
                System.out.println("TagId: " + k + " | Name: " + v);
            });
            System.out.println(tags.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
