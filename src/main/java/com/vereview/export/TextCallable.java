package com.vereview.export;

import com.vereview.context.ApplicationContext;
import com.vereview.message.FileMessage;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class TextCallable implements Callable<FileMessage> {
    private static final Logger logger = LoggerFactory.getLogger(TextCallable.class);
    private FileMessage message;
    private ApplicationContext context = ApplicationContext.getInstance();

    public TextCallable(FileMessage message) {
        this.message = message;
    }

    @Override
    public FileMessage call() throws Exception {
        try{
            Thread.sleep(1000);
            Export export = new Export();
            export.copyText(message);
            System.out.println("DEBUG | Document Id: " + message.getDocumentId() + " | Text File Export | From: " + message.getTextVeFiles().toString() + " | To: " + message.getTextExportFile()!=null?message.getTextExportFile():"");
        }catch (Throwable t){
            logger.error("Case: " + context.getDbName() + " | " + message.toString(), t);
            //System.out.println("ERROR | " + message.toString() + " | Stacktrace: " + ExceptionUtils.getStackTrace(t));
        }
        return message;
    }
}
