package com.vereview.csv;

import com.google.common.base.Strings;
import jcifs.smb.SmbFile;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by mjmangan on 8/15/17.
 */
public class CsvWriter {
    private CsvData data;

    public CsvWriter(CsvData data) {
        this.data = data;
    }

    public void createCsv(Path exportFile) throws Exception{
        CsvPreference preference = new CsvPreference.Builder(RelitivityDelimiters.QUOTE.getCharacter().charAt(0), RelitivityDelimiters.COLUMN.getCharacter().charAt(0), RelitivityDelimiters.NEW_LINE.getCharacter()).useQuoteMode(new AlwaysQuoteMode()).build();

        try (Writer w = Files.newBufferedWriter(exportFile); ICsvMapWriter writer = new CsvMapWriter(w, preference)){

            String[] header = data.getHeader().toArray(new String[data.getHeader().size()]);
            writer.writeHeader(header);
            for(Map<String, String> row : data.getRows()){
                writer.write(row, header);
            }

        }catch (Exception e){
            throw e;
        }
    }
}
