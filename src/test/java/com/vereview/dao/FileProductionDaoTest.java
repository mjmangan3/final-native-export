package com.vereview.dao;

import com.vereview.model.FileProduction;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/13/17.
 */
public class FileProductionDaoTest extends DaoTest {

    /*
    @Test
    public void findAllByProductionIdTest(){
        try {
            Long productionId = new Long(9);
            FileProductionDao dao = new FileProductionDao(mgr);
            Map<Long, FileProduction> fps = dao.findAllByProductionId(productionId);
            fps.forEach((k,v) -> {
                System.out.println("fileId: " + k + " | " + v);
            });
            System.out.println(fps.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
