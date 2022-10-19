package com.vereview.csv;

import java.util.Set;

public class IndividualBookmarkBuilder extends BookmarkBuilder {
    private Set<String> bookmarks;

    public IndividualBookmarkBuilder(Long fileId, Set<String> bookmarks) {
        super(fileId);
        this.bookmarks = bookmarks;
    }

    @Override
    public BookmarkBuilder bookmarks(){
        this.row.put(BookmarkHeaders.BOOKMARK.getHeader(), getBookmarksAsString(bookmarks));
        return this;
    }
}
