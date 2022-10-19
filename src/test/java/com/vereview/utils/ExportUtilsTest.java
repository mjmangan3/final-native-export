package com.vereview.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mjmangan on 9/2/17.
 */
public class ExportUtilsTest {

    @Test
    public void getFolderName(){
        try {
            String expected = "0010";
            Integer folderNumber = new Integer(10);
            String actual = ExportUtils.getFolderName(folderNumber);
            System.out.println(actual);
            Assert.assertEquals(expected, actual);
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

    @Test
    public void incrementFolderTest(){
        try {
            System.out.println(ExportUtils.incrementFolder(0, 1));
            System.out.println(ExportUtils.incrementFolder(999, 1));
            System.out.println(ExportUtils.incrementFolder(1000, 1));
            System.out.println(ExportUtils.incrementFolder(1001, 2));
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}
