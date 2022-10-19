package com.vereview.utils;

/**
 * Created by mjmangan on 9/2/17.
 */
public class ExportUtils {

    public static String getFolderName(Integer folderNumber){
        return String.format("%04d", folderNumber);
    }

    public static Integer incrementFolder(Integer fileCount, Integer folderNumber){
        if((fileCount != 0) && fileCount % 1000 == 0){
            return ++folderNumber;
        }
        return folderNumber;
    }
}
