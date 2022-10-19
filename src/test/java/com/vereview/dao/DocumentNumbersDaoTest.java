package com.vereview.dao;

import com.vereview.model.DocumentNumbers;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/16/17.
 */
public class DocumentNumbersDaoTest extends DaoTest {

    /*
    @Test
    public void findAllByProductionIdTest(){
        try {
            DocumentNumbersDao dao = new DocumentNumbersDao(mgr);
            Map<Long, DocumentNumbers> dn = dao.findAllByProductionId(new Long(9));
            dn.forEach((k,v) -> {
                System.out.println("FileId: " + k + " | " + v);
            });
            System.out.println(dn.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
