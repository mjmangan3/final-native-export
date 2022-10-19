package com.vereview;

import com.vereview.csv.CsvData;
import com.vereview.csv.RowBuilder;
import com.vereview.index.IndexManager;
import com.vereview.message.FileMessage;
import com.vereview.model.FileLocation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mjmangan on 8/12/17.
 */
public class TestUtils {

    public static final SimpleDateFormat TEST_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String TEST_DOCUMENT_ID = "TEST000001";
    public static final Path EXPORT_DIR = Paths.get("/Users/mjmangan/Documents/Projects/13-3413 Eaton Allstate/EXPORT");

    public static CsvData createCsvDate(){
        CsvData data = new CsvData();
        List<String> header = new ArrayList<>();
        header.add("BEGDOC");
        header.add("ENDDOC");
        header.add("EXTENSION");

        List<Map<String, String>> rows = new ArrayList<>();

        Map<String, String> row1 = new HashMap<>();
        row1.put("BEGDOC", "TEST001");
        row1.put("ENDDOC", "TEST002");
        row1.put("EXTENSION", "pdf");
        rows.add(row1);

        Map<String, String> row2 = new HashMap<>();
        row2.put("BEGDOC", "TEST003");
        row2.put("ENDDOC", "TEST004");
        row2.put("EXTENSION", "docx");
        rows.add(row2);

        Map<String, String> row3 = new HashMap<>();
        row3.put("BEGDOC", "TEST005");
        row3.put("ENDDOC", "TEST006");
        row3.put("EXTENSION", "");
        rows.add(row3);

        Map<String, String> row4 = new HashMap<>();
        row4.put("BEGDOC", "TEST007");
        row4.put("ENDDOC", "TEST008");
        row4.put("EXTENSION", "msg");
        rows.add(row4);

        data.setHeader(header);
        data.setRows(rows);

        return data;
    }

    public static IndexManager getTestProcessorIndexManager(){
        IndexManager indexManager = IndexManager.getInstance();
        Map<Long, FileLocation> fl = new HashMap<>();
        FileLocation fileLocation = new FileLocation();
        fileLocation.setId(new Long(2));
        fileLocation.setFileId(new Long(509));
        fileLocation.setType("NATIVE");
        fileLocation.setPart(new Long(1));
        fileLocation.setSize(new Long(11429888));
        fileLocation.setMd5Hash("b1d4eaf6fcc037e4c5384b5009e84a3b");
        fileLocation.setSha1Hash("9c61e04715b15b860d8d489054879f47477bf003");
        fileLocation.setName("native.xls");
        fileLocation.setLocation("\\\\192.168.22.177\\data\\vereview\\case_13_3413\\original\\01\\native.xls.gz");
        fileLocation.setUnixLocation("/data/192.168.22.177/vereview/case_13_3413/original/01/native.xls.gz");
        fileLocation.setPlaceHolder(false);
        fileLocation.setCompressed(true);
        fileLocation.setDetected(false);
        fileLocation.setEncoding("System.Text.UnicodeEncoding");
        fl.put(fileLocation.getFileId(), fileLocation);

        indexManager.setNativeFileLocationByFileId(fl);
        return indexManager;
    }

    public static FileMessage getTestProcessorFileMessage(){
        FileMessage message = new FileMessage();
        message.setDocumentId(TEST_DOCUMENT_ID);
        message.setFileId(new Long(509));
        Map<String, String> row = new HashMap<>();
        row.put(RowBuilder.StandardColumnNames.FILE_EXTENSION.getColumnName(), "xls");

        message.setRow(row);
        return message;
    }

    public static FileMessage getTestNativeCopyMessage(){
        FileMessage message = new FileMessage();
        message.setDocumentId("VE0000000017");
        message.setFileId(new Long(525));
        Map<String, String> row = new HashMap<>();
        row.put(RowBuilder.StandardColumnNames.FILE_EXTENSION.getColumnName(), "ppt");
        message.setRow(row);
        message.setNativeVeFile(Paths.get("\\\\192.168.22.177\\data\\vereview\\case_13_3413\\original\\01\\48", "native.ppt.gz"));
        message.setNativeExportFile(Paths.get("C:\\export\\test", "VE0000000017.ppt"));
        return message;
    }
}
