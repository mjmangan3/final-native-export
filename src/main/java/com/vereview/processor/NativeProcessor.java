package com.vereview.processor;

import com.vereview.csv.RowBuilder;
import com.vereview.index.IndexManager;
import com.vereview.message.FileMessage;
import com.vereview.model.FileLocation;
import com.vereview.utils.ExportUtils;
import com.vereview.utils.FileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjmangan on 9/3/17.
 */
public class NativeProcessor {
    private IndexManager indexManager;
    public static final String BASE_FOLDER = "NATIVE";

    public NativeProcessor() {
        this.indexManager = IndexManager.getInstance();
    }

    public FileMessage process(FileMessage fileMessage, Integer folderNumber, Path exportDir){
        //System.out.println(fileMessage.toString());
        if(!indexManager.getNativeFileLocationByFileId().containsKey(fileMessage.getFileId()) || isInvalid(fileMessage)) {
            fileMessage.getRow().put(NativeFileHeaders.NATIVE_LINK.getHeader(), "");
            return fileMessage;
        }
        String folder = ExportUtils.getFolderName(folderNumber);
        String extension = "";
        if(fileMessage.getRow().containsKey(RowBuilder.StandardColumnNames.FILE_EXTENSION.getColumnName())){
            extension = fileMessage.getRow().get(RowBuilder.StandardColumnNames.FILE_EXTENSION.getColumnName());
            if(!extension.isEmpty()){
                extension = "." + extension;
            }
        }
        String fileName = fileMessage.getDocumentId() + extension;
        Path relPath = Paths.get(BASE_FOLDER, folder, fileName);
        fileMessage.getRow().put(NativeFileHeaders.NATIVE_LINK.getHeader(), relPath.toString());
        Path exportFile = Paths.get(exportDir.toAbsolutePath().toString(), relPath.toString());
        fileMessage.setNativeExportFile(exportFile);
        fileMessage.setNativeVeFile(Paths.get(indexManager.getNativeFileLocationByFileId().get(fileMessage.getFileId()).getLocation()));


        return fileMessage;
    }

    public Boolean isInvalid(FileMessage message){
        FileLocation fl = indexManager.getNativeFileLocationByFileId().get(message.getFileId());
        return FileUtils.isInvalidFileShare(fl.getLocation());
    }

    public enum NativeFileHeaders{
        NATIVE_LINK("NativeFilePath");

        private String header;

        NativeFileHeaders(String header) {
            this.header = header;
        }

        public String getHeader() {
            return header;
        }

        public static List<String> getHeaders(){
            List<String> headers = new ArrayList<>();
            for(NativeFileHeaders h : NativeFileHeaders.values()){
                headers.add(h.getHeader());
            }
            return headers;
        }
    }
}
