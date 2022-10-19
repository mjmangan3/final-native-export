package com.vereview.csv;

import org.supercsv.io.ICsvMapWriter;

public interface DatRowWriter {
    void write(ICsvMapWriter writer);
}
