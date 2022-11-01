package com.vereview;

import com.vereview.context.ApplicationContext;
import com.vereview.csv.*;
import com.vereview.dao.ConnectionManager;
import com.vereview.dao.ExportDao;
import com.vereview.dao.FileDao;
import com.vereview.dao.FileExportDao;
import com.vereview.export.NativeCallable;
import com.vereview.export.TextCallable;
import com.vereview.index.IndexManager;
import com.vereview.message.FileMessage;
import com.vereview.model.Export;
import com.vereview.processor.IndexProcessor;
import com.vereview.processor.NativeProcessor;
import com.vereview.processor.RowProcessor;
import com.vereview.processor.TextProcessor;
import com.vereview.queue.QueueManager;
import com.vereview.utils.ExportUtils;
import com.vereview.utils.FileUtils;
import jcifs.Config;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Created by mjmangan on 8/9/17.
 */
public class MainApp {
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);
    public static AtomicBoolean NATIVE_PROCESSED = new AtomicBoolean(false);
    public static AtomicBoolean TEXT_PROCESSED = new AtomicBoolean(false);

    public static void main(String[] args){
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("log4j.properties")){
            Path logDir = Paths.get(".." + File.separator + "log");
            if(!Files.exists(logDir.toAbsolutePath())){
                Files.createDirectory(logDir);
            }
            String strPath = logDir.toAbsolutePath().toString();
            System.out.println("Log Directory: " +  strPath);
            Properties prop = new Properties();
            prop.load(in);
            prop.replace("log4j.appender.nativeExport.file", Paths.get(strPath, "final-native-export.log").toAbsolutePath().toString());
            LogManager.resetConfiguration();
            PropertyConfigurator.configure(prop);

            Path baseExportDir = getExportDir(args);
            String dbName = getDbName(args);
            Environment env = getEnv(args);
            ApplicationContext context = ApplicationContext.getInstance();
            context.init(dbName, env);
            ConnectionManager mgr = ConnectionManager.getInstance();
            mgr.init(context);

            ExecutorService nativeThreadPool = Executors.newFixedThreadPool(context.getThreadCount());
            ExecutorService textThreadPool = Executors.newFixedThreadPool(context.getThreadCount());

            QueueManager queueManager = QueueManager.getInstance();
            IndexManager indexManager = IndexManager.getInstance();
            Config.setProperty("jcifs.smb.client.disablePlainTextPasswords","false");

            ExportDao exportDao = new ExportDao(mgr);
            List<Export> exports = exportDao.getTodoExports();
            for (Export export : exports) {
                try {
                    export.setDateStarted(new Date());
                    export.setStatus("IN PROCESS");
                    exportDao.updateExport(export);

                    IndexProcessor ip = new IndexProcessor(IndexManager.getInstance(), mgr);
                    ip.process(export);

                    Path exportDir = Paths.get(baseExportDir.toString(), export.getName());

                    int folderNum = 1;
                    int count = 0;
                    List<Map<String, String>> rows = new ArrayList<>();
                    List<NativeCallable> nativeCallables = new ArrayList<>();
                    List<TextCallable> textCallables = new ArrayList<>();
                    FileExportDao fileExportDao = new FileExportDao(mgr);
                    Set<Long> fileIds = fileExportDao.fetchFileIdsByExportId(export.getExportId());
                    for (Long fileId : fileIds) {
                        RowProcessor rowProcessor = new RowProcessor();
                        FileMessage message = rowProcessor.process(fileId);
                        message.setExport(export);
                        NativeProcessor nativeProcessor = new NativeProcessor();
                        TextProcessor textProcessor = new TextProcessor();

                        message = nativeProcessor.process(message, folderNum, exportDir);
                        message = textProcessor.process(message, folderNum, exportDir);

                        rows.add(message.getRow());

                        if (message.getNativeVeFile() != null) {
                            nativeCallables.add(new NativeCallable(message));
                        }

                        if (message.getTextExportFile() != null) {
                            textCallables.add(new TextCallable(message));
                        }
                        //queueManager.getNativeQueue().offer(message);
                        //queueManager.getTextQueue().offer(message);
                        System.out.println("Metadata Processed: " + message.toString());

                        count++;
                        folderNum = ExportUtils.incrementFolder(count, folderNum);
                    }


                    //nativeThreadPool.execute(new NativeWorker());
                    //textThreadPool.execute(new TextWorker());
                    List<Future<FileMessage>> nativeFileFutures = nativeThreadPool.invokeAll(nativeCallables);
                    List<Future<FileMessage>> textFileFutures = textThreadPool.invokeAll(textCallables);

            /*
            while (!NATIVE_PROCESSED.get() && !TEXT_PROCESSED.get()){

                if (!nativeThreadPool.isShutdown()) {
                    nativeThreadPool.shutdown();
                }
                if (!textThreadPool.isShutdown()) {
                    textThreadPool.shutdown();
                }
            }
            */

                    List<String> headerSet = RowBuilder.StandardColumnNames.getHeader();
                    headerSet.addAll(EmailRowBuilder.EmailHeaders.getHeader());
                    headerSet.addAll(PropertyRowBuilder.PropertyHeader.getHeader());
                    headerSet.addAll(TagBuilder.TagHeaders.getHeaders());
                    headerSet.addAll(BookmarkBuilder.BookmarkHeaders.getHeaders());
                    headerSet.addAll(QuestionBuilder.QuestionHeaders.getHeaders());
                    headerSet.addAll(NativeProcessor.NativeFileHeaders.getHeaders());
                    headerSet.addAll(TextProcessor.TextFileHeaders.getHeaders());
                    System.out.println("Start Dat creation");
                    CsvData data = new CsvData();
                    data.setHeader(new ArrayList<>(headerSet));
                    data.setRows(rows);
                    Path dat = FileUtils.createTempFile("EXPORT.dat");

                    //Files.createFile(Paths.get(exportDir.toAbsolutePath().toString(), "EXPORT.dat"));
                    CsvWriter writer = new CsvWriter(data);
                    writer.createCsv(dat);
                    Path shareFile = Paths.get(exportDir.toString(), "EXPORT.dat");
                    FileUtils.copyToFileShare(dat, shareFile.toString(), context.getExportPathUserName(), context.getExportPathPassword());
                    System.out.println("Finished Dat creation");

                    export.setDateCompleted(new Date());
                    export.setStatus("DONE");
                    exportDao.updateExport(export);
                } catch (Throwable t) {
                    logger.error("failed to process export: " + export.toString(), t);
                }
            }
            if (!nativeThreadPool.isShutdown()) {
                nativeThreadPool.shutdown();
            }
            if (!textThreadPool.isShutdown()) {
                textThreadPool.shutdown();
            }
            
        }catch (Throwable t){
            ApplicationContext c = ApplicationContext.getInstance();
            logger.error("Exception in Application for case: " + c.getDbName(), t);
        }

    }

    public static String getDbName(String[] args){
        for(String arg : args){
            if(arg.startsWith(Arguments.DB_NAME.getAttribute())){
                String[] parts = arg.split("=");
                if(parts.length == 2){
                    return parts[1];
                }else {
                    throwIllegalArgumentException(arg);
                }
            }
        }
        throw new IllegalArgumentException("no database name directory");
    }

    public static Path getExportDir(String[] args){
        for(String arg : args){
            if(arg.startsWith(Arguments.EXPORT_DIR.getAttribute())){
                String[] parts = arg.split("=");
                if(parts.length == 2){
                    return Paths.get(parts[1]);
                }else {
                    throwIllegalArgumentException(arg);
                }
            }
        }
        throw new IllegalArgumentException("no export directory");
    }

    public static Environment getEnv(String[] args){
        for(String arg : args){
            if(arg.startsWith(Arguments.ENVIRONMENT.getAttribute())){
                String[] parts = arg.split("=");
                if(parts.length == 2){
                    return Environment.getEnvironment(parts[1]);
                }else {
                    throwIllegalArgumentException(arg);
                }
            }
        }
        throw new IllegalArgumentException("no env attr");
    }

    public static void throwIllegalArgumentException(String arg){
        throw new IllegalArgumentException("invalid argument | " + arg);
    }

    public enum Arguments{
        EXPORT_DIR("exportDir"),
        DB_NAME("dbName"),
        ENVIRONMENT("env");

        private String attribute;

        Arguments(String attribute) {
            this.attribute = attribute;
        }

        public String getAttribute() {
            return attribute;
        }
    }

    public enum Environment {
        DEV("production/conf/application.properties"),
        PROD("../conf/application.properties");

        private String propertiesFileName;

        Environment(String propertiesFileName) {
            this.propertiesFileName = propertiesFileName;
        }

        public String getPropertiesFileName() {
            return propertiesFileName;
        }

        public static Environment getEnvironment(String env){
            return Environment.valueOf(env.toUpperCase());
        }
    }
}
