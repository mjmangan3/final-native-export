package com.vereview.dao;

import com.vereview.context.ApplicationContext;
import com.vereview.model.File;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/12/17.
 */
public class FileDaoTest extends DaoTest{

    /*
    @Test
    public void findAllTest(){
        try {
            FileDao dao = new FileDao(mgr);
            Map<Long, File> files = dao.findAll();
            files.forEach((k,v) ->{
                System.out.println("FileId: " + k + " | " + v.getDateLastUpdated().toString() + " | " + v.toString());
            });
            System.out.println(files.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
