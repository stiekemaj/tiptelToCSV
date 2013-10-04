package eu.stiekema.jeroen.tiptel;

import eu.stiekema.jeroen.tiptel.strategy.OneByteReadStrategy;
import eu.stiekema.jeroen.tiptel.strategy.StringReadStrategy;
import eu.stiekema.jeroen.tiptel.strategy.TiptelReadStrategy;
import eu.stiekema.jeroen.tiptel.strategy.TwoByteReadStrategy;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author Jeroen Stiekema
 *
 * File format details can be found at http://www.arndt-netz.de/tiptel/ttreadme.htm
 *
 */
public class TiptelFileReader {
    private static final byte[] HEADER = new byte[]{0x06, 0x0D, 0x54, 0x53, 0x74, 0x43, 0x6F, 0x6C, 0x6C, 0x65, 0x63, 0x74, 0x69, 0x6F, 0x6E, 0x02, 0x64, 0x01};
    private static final byte ONE_BYTE_WORD_PREFIX = 0x02;
    private static final byte TWO_BYTES_WORD_PREFIX = 0x03;
    private static final byte STRING_PREFIX = 0x06;
    private static final byte END_OF_FILE = 0x00;

    private TiptelReadStrategy oneByteReadStrategy = new OneByteReadStrategy();
    private TiptelReadStrategy twoByteReadStrategy = new TwoByteReadStrategy();
    private TiptelReadStrategy stringReadStrategy = new StringReadStrategy();

    public void read(String file, TiptelDataSource tiptelDataSource) throws InvalidTiptelFileException {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            readHeader(randomAccessFile);

            TiptelResourceReaderImpl reader = new TiptelResourceReaderImpl(randomAccessFile);
            readBody(reader, tiptelDataSource);
        } catch (IOException e) {
            throw new RuntimeException(String.format("I/O exception while reading %1", file));
        }
    }

    public void readBody(TiptelResourceReader reader, TiptelDataSource tiptelDataSource) throws IOException {

        TiptelReadStrategy strategy = null;

        while (reader.hasNext()) {
            byte b = reader.nextByte();
            switch (b) {
                case ONE_BYTE_WORD_PREFIX:
                    strategy = oneByteReadStrategy;
                    break;
                case TWO_BYTES_WORD_PREFIX:
                    strategy = twoByteReadStrategy;
                    break;
                case STRING_PREFIX:
                    strategy = stringReadStrategy;
                    break;
                case END_OF_FILE:
                    return;
                default:
                    throw new RuntimeException("Unexpected byte: " + b + " + at position " + reader.getPosition());
            }

            strategy.execute(reader, tiptelDataSource);
        }
    }

    private void readHeader(RandomAccessFile randomAccessFile) throws IOException, InvalidTiptelFileException {
        byte[] bytes = new byte[HEADER.length];
        randomAccessFile.seek(0);
        randomAccessFile.read(bytes);
        if (!Arrays.equals(HEADER, bytes)) {
            throw new InvalidTiptelFileException("Invalid header, cannot read file");
        }
    }
}
