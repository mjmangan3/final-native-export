package com.vereview.utils;

import com.vereview.TestUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by mjmangan on 8/19/17.
 */
public class DateUtilsTest {
    private Date date;

    @Before
    public void setUp(){
        try{
            date = TestUtils.TEST_DATE_FORMAT.parse("2017-06-17 10:16:17");
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

    @Test
    public void getDateStringTest(){
        try {
            String strDate = DateUtils.getDateString(date);
            Assert.assertNotNull(strDate);
            Assert.assertEquals("06/17/2017", strDate);
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

    @Test
    public void getTimeStringTest(){
        try {
            String strTime = DateUtils.getTimeString(date);
            Assert.assertNotNull(strTime);
            Assert.assertEquals("10:16 AM", strTime);
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}
