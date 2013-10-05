package eu.stiekema.jeroen.tiptel.input;

import eu.stiekema.jeroen.tiptel.InvalidTiptelFileException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author Jeroen Stiekema
 */
public class TiptelFileReaderImpl implements TiptelFileReader {
    private static final byte[] HEADER = new byte[]{0x06, 0x0D, 0x54, 0x53, 0x74, 0x43, 0x6F, 0x6C, 0x6C, 0x65, 0x63, 0x74, 0x69, 0x6F, 0x6E, 0x02, 0x64, 0x01};
    private static final byte ONE_BYTE_WORD_PREFIX = 0x02;
    private static final byte TWO_BYTES_WORD_PREFIX = 0x03;
    private static final byte STRING_PREFIX = 0x06;
    private static final byte END_OF_FILE = 0x00;

    private FieldReader oneByteFieldReader;
    private FieldReader twoByteFieldReader;
    private FieldReader stringFieldReader;

    private RandomAccessFile randomAccessFile;

    private byte lastMarkerByte = -1;

    public TiptelFileReaderImpl(String file) throws IOException, InvalidTiptelFileException {
        this.randomAccessFile = new RandomAccessFile(file, "r");
        this.oneByteFieldReader = new OneByteFieldReader(this.randomAccessFile);
        this.twoByteFieldReader = new TwoByteFieldReader(this.randomAccessFile);
        this.stringFieldReader = new StringFieldReader(this.randomAccessFile);

        readHeader(randomAccessFile);
    }

    @Override
    public byte[] nextField() throws IOException {
        int markerByte = getAndResetMarkerByte();
        switch (markerByte) {
            case ONE_BYTE_WORD_PREFIX:
                return oneByteFieldReader.read(this);
            case TWO_BYTES_WORD_PREFIX:
                return twoByteFieldReader.read(this);
            case STRING_PREFIX:
                return stringFieldReader.read(this);
            case END_OF_FILE:
                return null;
            default:
                throw new RuntimeException("Unexpected byte '" + markerByte + "' at position " + getCurrentOffset());
        }
    }

    @Override
    public boolean endOfFile() throws IOException {
        return getMarkerByte() == END_OF_FILE;
    }

    private byte getMarkerByte() throws IOException {
        if (lastMarkerByte == -1) {
            lastMarkerByte = randomAccessFile.readByte();
        }

        return lastMarkerByte;
    }

    private byte getAndResetMarkerByte() throws IOException {
        byte markerByte = getMarkerByte();
        this.lastMarkerByte = -1;
        return markerByte;
    }

    private void readHeader(RandomAccessFile randomAccessFile) throws IOException, InvalidTiptelFileException {
        byte[] bytes = new byte[HEADER.length];
        randomAccessFile.seek(0);
        randomAccessFile.read(bytes);
        if (!Arrays.equals(HEADER, bytes)) {
            throw new InvalidTiptelFileException("Invalid header, cannot convert file");
        }
    }

    private long getCurrentOffset() {
        try {
            return randomAccessFile.getFilePointer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
