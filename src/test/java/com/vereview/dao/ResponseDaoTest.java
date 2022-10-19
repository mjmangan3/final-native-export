package com.vereview.dao;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by mjmangan on 8/26/17.
 */
public class ResponseDaoTest extends DaoTest {

    /*
    @Test
    public void getResponsesTest(){
        try {
            ResponseDao dao = new ResponseDao(mgr);
            Map<Long, String> responses = dao.getResponses();
            responses.forEach((k,v) -> {
                System.out.println("ResponseId: " + k + " | Value: " + v);
            });
            System.out.println(responses.size());
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
    */
}
