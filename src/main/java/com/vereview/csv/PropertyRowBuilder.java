package com.vereview.csv;

import com.vereview.model.Property;
import com.vereview.utils.DateUtils;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.*;

/**
 * Created by mjmangan on 8/20/17.
 */
public class PropertyRowBuilder extends Builder{
    private Property property;

    public PropertyRowBuilder(Long fileId) {
        this.fileId = fileId;
        this.row = new HashMap<>();
        property = indexManager.getPropertyByFileId().get(fileId);
    }

    public PropertyRowBuilder(Long fileId, Property property) {
        this.fileId = fileId;
        this.row = new HashMap<>();
        this.property = property;
    }

    public PropertyRowBuilder title(){
        row.put(PropertyHeader.TITLE.getColumnName(), processNull(property!=null?property.getTitle():""));
        return this;
    }

    public PropertyRowBuilder author(){
        row.put(PropertyHeader.AUTHOR.getColumnName(), processNull(property!=null?property.getAuthor():""));
        return this;
    }

    public PropertyRowBuilder datePrinted(){
        Date date = property!=null?property.getDateLastPrinted():null;
        row.put(PropertyHeader.DATE_PRINTED.getColumnName(), processNull(DateUtils.getDateString(date)));
        return this;
    }

    public PropertyRowBuilder revision(){
        row.put(PropertyHeader.REVISION.getColumnName(), processNull(property!=null?property.getRevision():""));
        return this;
    }



    public Map<String, String> build(){
        return row;
    }

    public static enum PropertyHeader{
        TITLE("TITLE"),
        AUTHOR("Author"),
        DATE_PRINTED("DatePrinted"),
        REVISION("Revision");

        private String columnName;

        PropertyHeader(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName() {
            return columnName;
        }

        public static List<String> getHeader(){
            List<String> headers = new ArrayList<>();
            for(PropertyHeader header : PropertyHeader.values()){
                headers.add(header.getColumnName());
            }
            return headers;
        }
    }
}
