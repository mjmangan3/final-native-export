package com.vereview.processor;

import com.vereview.index.IndexManager;
import com.vereview.message.FileMessage;
import com.vereview.message.TextInfo;
import com.vereview.model.PageInfo;
import com.vereview.utils.ExportUtils;
import com.vereview.utils.FileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mjmangan on 9/9/17.
 */
public class TextProcessor {

    private IndexManager indexManager;
    public static final String BASE_FOLDER = "TEXT";

    public TextProcessor() {
        indexManager = IndexManager.getInstance();
    }

    public FileMessage process(FileMessage fileMessage, Integer folderNumber, Path exportDir){
        TextInfo ti = fileMessage.getTextVeFiles();
        if(ti == null){
            ti = new TextInfo();
        }
        Boolean hasText = false;
        if(indexManager.getTextPageInfosByFileId().containsKey(fileMessage.getFileId())){
            if(!hasInvalid(indexManager.getTextPageInfosByFileId().get(fileMessage.getFileId()))) {
                ti.setPageText(true);
                ti.setTextFilePaths(indexManager.getTextPageInfosByFileId().get(fileMessage.getFileId()));
                hasText = true;
            }
        }

        if(indexManager.getTextFileLocationByFileId().containsKey(fileMessage.getFileId())){
            if(!FileUtils.isInvalidFileShare(indexManager.getTextFileLocationByFileId().get(fileMessage.getFileId()).getLocation())) {
                ti.setFileText(Paths.get(indexManager.getTextFileLocationByFileId().get(fileMessage.getFileId()).getLocation()));
                hasText = true;
            }
        }

        if(hasText) {
            String folder = ExportUtils.getFolderName(folderNumber);
            String fileName = fileMessage.getDocumentId() + ".txt";
            Path relPath = Paths.get(BASE_FOLDER, folder, fileName);
            fileMessage.getRow().put(TextFileHeaders.TEXT_LINK.getHeader(), relPath.toString());
            Path exportFile = Paths.get(exportDir.toAbsolutePath().toString(), relPath.toString());
            fileMessage.setTextExportFile(exportFile);
            fileMessage.setTextVeFiles(ti);
        }else {
            fileMessage.getRow().put(TextFileHeaders.TEXT_LINK.getHeader(), "");
        }

        return fileMessage;
    }


    public Boolean hasInvalid(Map<Long, PageInfo> pages){
        for(PageInfo info : pages.values()){
            if(FileUtils.isInvalidFileShare(info.getLocation().toAbsolutePath().toString())){
                return true;
            }
        }
        return false;
    }

    public enum TextFileHeaders{
        TEXT_LINK("ExtractedText");

        private String header;

        TextFileHeaders(String header) {
            this.header = header;
        }

        public String getHeader() {
            return header;
        }

        public static List<String> getHeaders(){
            List<String> h = new ArrayList<>();
            for(TextFileHeaders t : TextFileHeaders.values()){
                h.add(t.getHeader());
            }
            return h;
        }
    }
}
