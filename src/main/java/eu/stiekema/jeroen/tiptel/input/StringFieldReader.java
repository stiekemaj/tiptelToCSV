package eu.stiekema.jeroen.tiptel.input;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Jeroen Stiekema
 */
public class StringFieldReader implements FieldReader {
    private RandomAccessFile randomAccessFile;

    public StringFieldReader(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public byte[] read() throws IOException {
        int stringLength = randomAccessFile.readByte();
        byte[] byteArray = new byte[stringLength];
        randomAccessFile.read(byteArray);
        return byteArray;
    }
}
