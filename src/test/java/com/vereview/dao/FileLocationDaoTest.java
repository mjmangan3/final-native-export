package com.vereview.dao;

import com.vereview.model.FileLocation;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 9/2/17.
 */
public class FileLocationDaoTest extends DaoTest{

    /*
    @Test
    public void nativeTest(){
        try {
            FileLocationDao dao = new FileLocationDao(mgr);
            Map<Long, FileLocation> locations = dao.fetchFileLocationsByType("native");
            locations.forEach((k,v) -> {
                System.out.println("FileId: " + k + " | " + v);
            });
            System.out.println(locations.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

    @Test
    public void textTest(){
        try {
            FileLocationDao dao = new FileLocationDao(mgr);
            Map<Long, FileLocation> locations = dao.fetchFileLocationsByType("txt");
            locations.forEach((k,v) -> {
                System.out.println("FileId: " + k + " | " + v);
            });
            System.out.println(locations.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
