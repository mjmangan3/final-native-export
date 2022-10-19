package com.vereview.dao;

import com.vereview.model.PageInfo;
import com.vereview.model.PageLocationType;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 9/9/17.
 */
public class PageInfoDaoTest extends DaoTest {

    /*
    @Test
    public void getPageInfoByTypeTest(){
        try {
            PageInfoDao dao = new PageInfoDao(mgr);
            Map<Long, Map<Long, PageInfo>> pi = dao.getPageInfoByType(PageLocationType.TEXT);
            pi.forEach((k,v) -> {
                System.out.println("FileId: " + k);
                v.forEach((n, p) -> {
                    System.out.println("\tPageNumber: " + n + " | " + p);
                });
            });
            System.out.println(pi.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

    @Test
    public void getredactedPageInfoByTypeTest(){
        try {
            PageInfoDao dao = new PageInfoDao(mgr);
            Map<Long, Map<Long, PageInfo>> pi = dao.getPageInfoByType(PageLocationType.REDACTED_TEXT);
            pi.forEach((k,v) -> {
                System.out.println("FileId: " + k);
                v.forEach((n, p) -> {
                    System.out.println("\tPageNumber: " + n + " | " + p);
                });
            });
            System.out.println(pi.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
