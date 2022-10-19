package com.vereview.utils;

import java.nio.file.Path;

public class FileUtils {

    public static String removeIllegalFileSystemCharacters(String value){
        return value.replaceAll("[\\\\/:*?\"<>|]", "");
    }

    public static Boolean isInvalidFileShare(String  file){
        if(file.contains("192.168.22.73") || file.contains("192.168.22.31")){
            return true;
        }
        return false;
    }
}