package com.vereview.export;

import com.vereview.context.ApplicationContext;
import com.vereview.message.FileMessage;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class NativeCallable implements Callable<FileMessage> {
    private static final Logger logger = LoggerFactory.getLogger(NativeCallable.class);
    private FileMessage message;
    private ApplicationContext context = ApplicationContext.getInstance();

    public NativeCallable(FileMessage message) {
        this.message = message;
    }

    @Override
    public FileMessage call() throws Exception {
        try {
            Thread.sleep(1000);
            Export export = new Export();
            export.copyNative(message);
            System.out.println("DEBUG | Document Id: " + message.getDocumentId() + " | Native File Export | From: " + message.getNativeVeFile() + " | To: " + message.getNativeExportFile());
        }catch (Throwable t){
            logger.error("Case: " + context.getDbName() + " | " + message.toString(), t);
            //System.out.println("ERROR | " + message.toString() + " | Stacktrace: " + ExceptionUtils.getStackTrace(t));
        }
        return message;
    }
}
