package eu.stiekema.jeroen.tiptel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jeroen Stiekema
 */
public class OutputWriter {
    private final TiptelDataSource dataSource;
    private final String file;

    public OutputWriter(String file, TiptelDataSource dataSource) {
        this.file = file;
        this.dataSource = dataSource;
    }

    public void write() throws IOException {
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        writer.println(TiptelRecord.getCommaSeparetedHeader());
        for (TiptelRecord record : dataSource.getRecords()) {
            writer.println(record.toCommaSeparatedLine());
        }
        writer.flush();
    }
}
