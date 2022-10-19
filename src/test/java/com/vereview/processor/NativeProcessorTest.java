package com.vereview.processor;

import com.vereview.TestUtils;
import com.vereview.index.IndexManager;
import com.vereview.message.FileMessage;
import com.vereview.utils.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by mjmangan on 9/4/17.
 */
public class NativeProcessorTest {
    private IndexManager indexManager;
    private FileMessage message;

    @Before
    public void setUp(){
        try {
            indexManager = TestUtils.getTestProcessorIndexManager();
            message = TestUtils.getTestProcessorFileMessage();
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

    @Test
    public void praocess(){
        try {
            NativeProcessor p = new NativeProcessor();
            message = p.process(message, 1, TestUtils.EXPORT_DIR);
            Assert.assertEquals(Paths.get(TestUtils.EXPORT_DIR.toAbsolutePath().toString(), "NATIVE" + File.separator + "0001", TestUtils.TEST_DOCUMENT_ID + ".xls" ), message.getNativeExportFile());
            Assert.assertEquals("NATIVE"+ File.separator + "0001" + File.separator + TestUtils.TEST_DOCUMENT_ID + ".xls", message.getRow().get(NativeProcessor.NativeFileHeaders.NATIVE_LINK.getHeader()));
            Assert.assertEquals(Paths.get("\\\\192.168.22.177\\data\\vereview\\case_13_3413\\original\\01\\native.xls.gz"), message.getNativeVeFile());
            System.out.println(message);
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

    @Test
    public void isInvalid(){
        try {
            String unc = "\\\\192.168.22.73\\data\\vereview\\case_11_3083\\original\\01\\32\\native.xml";
            NativeProcessor processor = new NativeProcessor();
            Assert.assertFalse(processor.isInvalid(message));
            Assert.assertTrue(FileUtils.isInvalidFileShare(unc));
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}
