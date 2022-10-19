package com.vereview.csv;

import com.vereview.index.IndexManager;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mjmangan on 8/23/17.
 */
public class BookmarkBuilder extends Builder {

    public BookmarkBuilder(Long fileId) {
        this.fileId = fileId;
        row = new HashMap<>();
    }

    public BookmarkBuilder bookmarks(){
        Set<String> v = null;
        if(indexManager.getBookmarksByFileId().containsKey(fileId)){
            v = indexManager.getBookmarksByFileId().get(fileId);
        }
        this.row.put(BookmarkHeaders.BOOKMARK.getHeader(), getBookmarksAsString(v));
        return this;
    }

    public BookmarkBuilder bookmarks(Set<String> bookmarks){
        this.row.put(BookmarkHeaders.BOOKMARK.getHeader(), getBookmarksAsString(bookmarks));
        return this;
    }


    protected String getBookmarksAsString(Set<String> bookmarks){
        if(bookmarks == null || bookmarks.isEmpty()){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String a : bookmarks){
            builder.append(a);
            builder.append(";");
        }
        return builder.deleteCharAt(builder.lastIndexOf(";")).toString();
    }

    public Map<String, String> build(){
        return row;
    }

    public static enum  BookmarkHeaders{
        BOOKMARK("Bookmark");

        private String header;

        BookmarkHeaders(String header) {
            this.header = header;
        }

        public String getHeader() {
            return header;
        }

        public static List<String> getHeaders(){
            List<String> headers = new ArrayList<>();
            headers.add(BOOKMARK.getHeader());
            return headers;
        }
    }

}
