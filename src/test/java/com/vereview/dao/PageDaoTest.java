package com.vereview.dao;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/13/17.
 */
public class PageDaoTest extends DaoTest{

    /*
    @Test
    public void getEndBatesTest(){
        try {
            PageDao dao = new PageDao(mgr);
            Map<Long, String> mb = dao.getEndBatesIndex();
            mb.forEach((k,v) -> {
                System.out.println("fileId: " + k + " | bates: " + v);
            });
            System.out.println(mb.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

    @Test
    public void getStartBatesTest(){
        try {
            PageDao dao = new PageDao(mgr);
            Map<Long, String> mb = dao.getStartBatesIndex();
            mb.forEach((k,v) -> {
                System.out.println("fileId: " + k + " | bates: " + v);
            });
            System.out.println(mb.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
