package com.vereview.csv;

import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;


public class DatWriter {
    private String[] header;
    private Path datFile;

    public DatWriter(String[] header, Path datFile) {
        this.header = header;
        this.datFile = datFile;
    }

    public void createCsv(DatRowWriter datRowWriter) throws IOException {
        CsvPreference preference = new CsvPreference.Builder(RelitivityDelimiters.QUOTE.getCharacter().charAt(0), RelitivityDelimiters.COLUMN.getCharacter().charAt(0), RelitivityDelimiters.NEW_LINE.getCharacter()).useQuoteMode(new AlwaysQuoteMode()).build();

        try (Writer w = Files.newBufferedWriter(datFile); ICsvMapWriter writer = new CsvMapWriter(w, preference)){
            writer.writeHeader(header);
            datRowWriter.write(writer);
        }catch (Exception e){
            throw e;
        }
    }
}
