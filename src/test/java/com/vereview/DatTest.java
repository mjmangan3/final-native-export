package com.vereview;

import com.vereview.context.ApplicationContext;
import com.vereview.csv.*;
import com.vereview.dao.ConnectionManager;
import com.vereview.dao.DaoTest;
import com.vereview.dao.FileDao;
import com.vereview.dao.FolderDao;
import com.vereview.index.IndexManager;
import com.vereview.message.DaoMessage;
import com.vereview.message.FileMessage;
import com.vereview.model.Folder;
import com.vereview.processor.*;
import com.vereview.utils.ExportUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.supercsv.io.ICsvMapWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatTest extends DaoTest {
    /*
    @Test
    public void createDat() {
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
                BaseIndexProcessor ip = new BaseIndexProcessor(indexManager, mgr);
                ip.process();
                FileDao fileDao = new FileDao(mgr);
                Set<Long> fileIds = fileDao.findAllFileId();

                List<String> headerSet = IndividualRowBuilder.StandardColumnNames.getHeader();
                headerSet.addAll(EmailRowBuilder.EmailHeaders.getHeader());
                headerSet.addAll(PropertyRowBuilder.PropertyHeader.getHeader());
                headerSet.addAll(IndividualTagBuilder.TagHeaders.getHeaders());
                headerSet.addAll(BookmarkBuilder.BookmarkHeaders.getHeaders());
                headerSet.addAll(QuestionBuilder.QuestionHeaders.getHeaders());

                String[] header = headerSet.toArray(new String[headerSet.size()]);
                Path dat = Files.createFile(Paths.get(exportDir.toAbsolutePath().toString(), "EXPORT.dat"));
                System.out.println("Start Dat creation");
                DatWriter datWriter = new DatWriter(header, dat);
                datWriter.createCsv(new DatRowWriter() {
                    @Override
                    public void write(ICsvMapWriter writer) {
                        int folderNum = 1;
                        int count = 0;

                        for (Long fileId : fileIds) {
                            try {
                                DaoProcessor daoProcessor = new DaoProcessor(mgr);
                                DaoMessage daoMessage = daoProcessor.process(fileId);

                                IndividualRowProcessor rowProcessor = new IndividualRowProcessor();
                                FileMessage message = rowProcessor.process(daoMessage);

                                count++;
                                folderNum = ExportUtils.incrementFolder(count, folderNum);
                                writer.write(message.getRow(), header);
                                System.out.println("Dat Row Processed: " + message.getRow().toString());
                            } catch (Exception e) {
                                throw new RuntimeException("Failed processing fileid: " + fileId, e);
                            }
                        }
                    }
                });





                //headerSet.addAll(NativeProcessor.NativeFileHeaders.getHeaders());
                //headerSet.addAll(TextProcessor.TextFileHeaders.getHeaders());


                System.out.println("Finished Dat creation");

            }

        }catch (Throwable t){
            Assert.fail(ExceptionUtils.getStackTrace(t));
        }
    }

     */
}
