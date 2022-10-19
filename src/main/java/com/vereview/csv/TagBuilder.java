package com.vereview.csv;

import com.vereview.index.IndexManager;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mjmangan on 8/22/17.
 */
public class TagBuilder extends Builder{

    public TagBuilder(Long fileId) {
        this.fileId = fileId;
        row = new HashMap<>();
    }

    public TagBuilder tags(){
        Set<String> v = null;
        if(indexManager.getTagsByFileId().containsKey(fileId)){
            v = indexManager.getTagsByFileId().get(fileId);
        }
        this.row.put(TagHeaders.TAGS.getHeader(), getValuesAsString(v));
        return this;
    }

    public TagBuilder() {
    }

    public Map<String, String> build(){
        return this.row;
    }

    public static enum  TagHeaders{
        TAGS("Tags");

        private String header;

        TagHeaders(String header) {
            this.header = header;
        }

        public String getHeader() {
            return header;
        }

        public static List<String> getHeaders(){
            List<String> header = new ArrayList<>();
            header.add(TAGS.getHeader());
            return header;
        }
    }
}
