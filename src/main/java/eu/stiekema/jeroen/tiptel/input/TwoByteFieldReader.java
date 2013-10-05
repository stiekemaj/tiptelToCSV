package eu.stiekema.jeroen.tiptel.input;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Jeroen Stiekema
 */
public class TwoByteFieldReader implements FieldReader {
    private RandomAccessFile randomAccessFile;

    public TwoByteFieldReader(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public byte[] read(TiptelFileReader reader) throws IOException {
        byte[] bytes = new byte[2];
        randomAccessFile.read(bytes);
        return bytes;
    }
}
