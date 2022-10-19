package com.vereview.csv;

import java.util.HashMap;
import java.util.Set;

public class IndividualTagBuilder extends TagBuilder {
    protected Set<String> tags;

    public IndividualTagBuilder(Long fileId, Set<String> tags) {
        this.fileId = fileId;
        this.tags = tags;
        this.row = new HashMap<>();
    }

    @Override
    public TagBuilder tags(){
        this.row.put(TagHeaders.TAGS.getHeader(), getValuesAsString(tags));
        return this;
    }
}
