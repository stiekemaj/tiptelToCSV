package eu.stiekema.jeroen.tiptel.output;

import eu.stiekema.jeroen.tiptel.TiptelRecord;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jeroen Stiekema
 */
public class CsvOutputWriter implements OutputWriter {

    PrintWriter printWriter;

    public CsvOutputWriter(String file) throws IOException {
        this.printWriter = new PrintWriter(file, "UTF-8");
        printHeader();
    }

    @Override
    public void write(TiptelRecord record) {
        this.printWriter.println(getLine(record));
    }

    @Override
    public void flush() {
        this.printWriter.flush();
    }

    private void printHeader() {
        this.printWriter.println("NAME\tPHONENUMBER\tINFORMATION");
    }

    private String getLine(TiptelRecord record) {
        return String.format("%s\t%s\t%s", record.getName(), record.getTelephoneNumber(), record.getInformation());
    }
}
