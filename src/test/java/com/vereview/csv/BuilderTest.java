package com.vereview.csv;

import com.vereview.context.ApplicationContext;
import com.vereview.dao.ConnectionManager;
import com.vereview.dao.QuestionDao;
import com.vereview.index.IndexManager;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by mjmangan on 8/26/17.
 */
public class BuilderTest {

    protected ApplicationContext context;
    protected ConnectionManager mgr;
    protected IndexManager indexManager;

    @Before
    public void setUp(){
        try {
            context = ApplicationContext.getInstance();
            context.setDbInstance("DBVSERVER3");
            context.setDbName("case_13_3413");
            context.setDbPassword("sqladmin");
            context.setDbServer("192.168.22.193");
            context.setDbUserName("sa");
            mgr = ConnectionManager.getInstance();
            mgr.init(context);
            indexManager = IndexManager.getInstance();
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}
