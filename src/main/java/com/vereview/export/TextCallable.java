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

public class TextCallable implements Callable<FileMessage> {
    private static final Logger logger = LoggerFactory.getLogger(TextCallable.class);
    private FileMessage message;
    private ApplicationContext context = ApplicationContext.getInstance();
    private ConnectionManager mgr = ConnectionManager.getInstance();

    public TextCallable(FileMessage message) {
        this.message = message;
    }

    @Override
    public FileMessage call() throws Exception {
        try{
            Thread.sleep(1000);
            Export export = new Export();
            export.copyText(message);
            logger.debug("Text Copied: " + message.toJson());
        }catch (Throwable t){
            FileExportError error = new FileExportError();
            error.setExportId(message.getExport().getExportId());
            error.setDateCreated(new Date());
            error.setJsonMessage(message.toJson());
            error.setStackTrace(ExceptionUtils.getStackTrace(t));
            error.setFileId(message.getFileId());

            FileExportErrorDao dao = new FileExportErrorDao(mgr);
            dao.save(error);
            logger.error("Case: " + context.getDbName() + " | " + message.toString(), t);
        }
        return message;
    }
}
