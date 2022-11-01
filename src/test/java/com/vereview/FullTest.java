package com.vereview;

import com.vereview.context.ApplicationContext;
import com.vereview.csv.*;
import com.vereview.dao.*;
import com.vereview.index.IndexManager;
import com.vereview.message.FileMessage;
import com.vereview.processor.IndexProcessor;
import com.vereview.processor.NativeProcessor;
import com.vereview.processor.RowProcessor;
import com.vereview.processor.TextProcessor;
import com.vereview.utils.ExportUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by mjmangan on 8/16/17.
 */
public class FullTest{

    /*
    @Test
    public void datCreationTest(){
        try {
            String exportPath = "/Users/mjmangan/Documents/Projects/fd";  //"C:\\export\\overlays";
            //String[] cases =  {"case_10_2941", "case_10_2975", "case_10_2808", "case_11_3083", "case_11_3081", "case_08_2183", "case_15_3437", "case_15_3440", "case_14_3424", "case_14_3421", "case_10_2957", "case_06_1562"};
            String[] cases = {"case_13_3392"};
            for(String dbName : cases){
                Path exportDir = Paths.get(exportPath, dbName);
                Files.createDirectories(exportDir);
                MainApp.Environment env = MainApp.Environment.DEV;
                ApplicationContext context = ApplicationContext.getInstance();
                context.init(dbName, env);
                ConnectionManager mgr = ConnectionManager.getInstance();
                mgr.init(context);
                IndexManager indexManager = IndexManager.getInstance();
                IndexProcessor ip = new IndexProcessor(indexManager, mgr);
                ip.process();

                int folderNum = 1;
                int count = 0;
                List<Map<String, String>> rows = new ArrayList<>();
                for (Long fileId : indexManager.getFileByFileId().keySet()) {
                    RowProcessor rowProcessor = new RowProcessor();
                    FileMessage message = rowProcessor.process(fileId);
                    NativeProcessor nativeProcessor = new NativeProcessor();
                    TextProcessor textProcessor = new TextProcessor();

                    //message = nativeProcessor.process(message, folderNum, exportDir);
                    //message = textProcessor.process(message, folderNum, exportDir);

                    rows.add(message.getRow());

                    //queueManager.getNativeQueue().offer(message);
                    //queueManager.getTextQueue().offer(message);
                    System.out.println("Metadata Processed: " + message.toString());

                    count++;
                    folderNum = ExportUtils.incrementFolder(count, folderNum);
                }



                List<String> headerSet = RowBuilder.StandardColumnNames.getHeader();
                headerSet.addAll(EmailRowBuilder.EmailHeaders.getHeader());
                headerSet.addAll(PropertyRowBuilder.PropertyHeader.getHeader());
                headerSet.addAll(TagBuilder.TagHeaders.getHeaders());
                headerSet.addAll(BookmarkBuilder.BookmarkHeaders.getHeaders());
                headerSet.addAll(QuestionBuilder.QuestionHeaders.getHeaders());
                //headerSet.addAll(NativeProcessor.NativeFileHeaders.getHeaders());
                //headerSet.addAll(TextProcessor.TextFileHeaders.getHeaders());
                System.out.println("Start Dat creation");
                CsvData data = new CsvData();
                data.setHeader(new ArrayList<>(headerSet));
                data.setRows(rows);
                Path dat = Files.createFile(Paths.get(exportDir.toAbsolutePath().toString(), "EXPORT.dat"));
                CsvWriter writer = new CsvWriter(data);
                writer.createCsv(dat);
                System.out.println("Finished Dat creation");

            }

        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

     */

}
