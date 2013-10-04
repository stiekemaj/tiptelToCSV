package eu.stiekema.jeroen.tiptel;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Jeroen Stiekema
 */
public class TiptelResourceReaderImpl implements TiptelResourceReader {
    private RandomAccessFile randomAccessFile;
    private byte current = -1;


    public TiptelResourceReaderImpl(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public byte nextByte() throws IndexOutOfBoundsException {
//        if (hasNext()) {
//            byte returnVal = current;
//            current = -1;
//            return returnVal;
//        }
//
//        throw new IndexOutOfBoundsException();
        try {
            return (byte) randomAccessFile.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasNext() {
//        if (current == -1) {
//            try {
//                current = (byte) randomAccessFile.read();
//            } catch (IOException e) {
//                return false;
//            }
//        }
//        return current != -1;
        return true;
    }

    @Override
    public long getPosition() {
        try {
            return randomAccessFile.getFilePointer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
