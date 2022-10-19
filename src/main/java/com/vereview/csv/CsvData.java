package com.vereview.csv;

import java.util.List;
import java.util.Map;

/**
 * Created by mjmangan on 8/15/17.
 */
public class CsvData {
    private List<String> header;
    private List<Map<String, String>> rows;

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<Map<String, String>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, String>> rows) {
        this.rows = rows;
    }


}
