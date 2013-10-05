package eu.stiekema.jeroen.tiptel.input;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Jeroen Stiekema
 */
public class OneByteFieldReader implements FieldReader {

    private RandomAccessFile randomAccessFile;

    public OneByteFieldReader(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public byte[] read(TiptelFileReader reader) throws IOException {
        byte bite = randomAccessFile.readByte();
        return new byte[]{bite};
    }
}
