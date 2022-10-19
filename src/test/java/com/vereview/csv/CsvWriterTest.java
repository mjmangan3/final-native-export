package com.vereview.csv;

import com.vereview.TestUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by mjmangan on 8/15/17.
 */
public class CsvWriterTest {

    @Test
    public void createCsvTest(){
        try {
            Path path = Files.createTempFile("VE", ".dat");
            CsvData data = TestUtils.createCsvDate();
            CsvWriter writer = new CsvWriter(data);
            writer.createCsv(path);
            System.out.println(path.toAbsolutePath().toString());
            Assert.assertTrue(Files.isRegularFile(path));
        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }
}
