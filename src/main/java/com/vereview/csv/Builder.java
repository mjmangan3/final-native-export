package com.vereview.csv;

import com.vereview.index.IndexManager;

import java.util.Map;
import java.util.Set;

/**
 * Created by mjmangan on 8/19/17.
 */
public abstract class Builder {
    protected Map<String, String> row;
    protected IndexManager indexManager = IndexManager.getInstance();
    protected Long fileId;

    public String processNull(String value){
        if(value == null){
            value = "";
        }
        return removeIllegalCharacters(value);
    }

    public String getValuesAsString(Set<String> values){
        if(values == null || values.isEmpty()){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String v : values){
            builder.append(v);
            builder.append(";");
        }
        return builder.deleteCharAt(builder.lastIndexOf(";")).toString();
    }

    public String removeIllegalCharacters(String value){
        return value.replace("\n", "").replace("\r", "").replace(RelitivityDelimiters.COLUMN.getCharacter(), "").replace(RelitivityDelimiters.QUOTE.getCharacter(), "").replace(RelitivityDelimiters.NEW_LINE.getCharacter(), "");
    }
}
