package com.vereview.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

public class FileUtilsTest {

    @Test
    public void IllegalCharTest(){
        try {
            Assert.assertEquals("EML01000003.160304", FileUtils.removeIllegalFileSystemCharacters("EML01000003.16:03:04"));
            Assert.assertEquals("EML01000003.160304", FileUtils.removeIllegalFileSystemCharacters("EML01000003\\.16:03:04"));
            Assert.assertEquals("EML01000003.160304", FileUtils.removeIllegalFileSystemCharacters("EML01000003/?.16:03:04"));
            Assert.assertEquals("EML01000003.160304", FileUtils.removeIllegalFileSystemCharacters("EML01000003|.<16:03:04>"));
            Assert.assertEquals("EML01000003.eml", FileUtils.removeIllegalFileSystemCharacters("EML01000003.eml"));
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}
