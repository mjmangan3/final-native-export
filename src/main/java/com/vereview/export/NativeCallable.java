package com.vereview.export;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vereview.context.ApplicationContext;
import com.vereview.dao.ConnectionManager;
import com.vereview.dao.FileExportErrorDao;
import com.vereview.message.FileMessage;
import com.vereview.model.FileExportError;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.Callable;

public class NativeCallable implements Callable<FileMessage> {
    private static final Logger logger = LoggerFactory.getLogger(NativeCallable.class);
    private FileMessage message;
    private ApplicationContext context = ApplicationContext.getInstance();
    private ConnectionManager mgr = ConnectionManager.getInstance();

    public NativeCallable(FileMessage message) {
        this.message = message;
    }

    @Override
    public FileMessage call() throws Exception {
        try {
            Thread.sleep(1000);
            Export export = new Export();
            export.copyNative(message);
            logger.debug("Document Id: " + message.getDocumentId() + " | Native File Export | From: " + message.getNativeVeFile() + " | To: " + message.getNativeExportFile());
        }catch (Throwable t){
            FileExportError error = new FileExportError();
            error.setExportId(message.getExport().getExportId());
            error.setDateCreated(new Date());
            error.setJsonMessage(message.toJson());
            error.setStackTrace(ExceptionUtils.getStackTrace(t));
            error.setFileId(message.getFileId());

            FileExportErrorDao dao = new FileExportErrorDao(mgr);
            dao.save(error);
        }
        return message;
    }

}
