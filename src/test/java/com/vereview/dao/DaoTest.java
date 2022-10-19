package com.vereview.dao;

import com.vereview.context.ApplicationContext;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by mjmangan on 8/13/17.
 */
public class DaoTest {
    protected ApplicationContext context;
    protected ConnectionManager mgr;

    @Before
    public void setUp(){
        try {
            context = ApplicationContext.getInstance();
            context.setDbInstance("MSSQLSERVER");
            context.setDbName("case_11_3101");
            context.setDbPassword("L1nux:R0ck5");
            context.setDbServer("192.168.0.201");
            context.setDbUserName("sa");
            mgr = ConnectionManager.getInstance();
            mgr.init(context);
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}
