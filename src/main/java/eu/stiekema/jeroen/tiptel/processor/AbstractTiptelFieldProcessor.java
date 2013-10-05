package eu.stiekema.jeroen.tiptel.processor;

import eu.stiekema.jeroen.tiptel.TiptelRecord;
import eu.stiekema.jeroen.tiptel.input.TiptelFileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author Jeroen Stiekema
 */
abstract class AbstractTiptelFieldProcessor implements TiptelFieldProcessor {

    private TiptelFieldProcessor next;

    @Override
    public TiptelFieldProcessor next() {
        return next;
    }

    public void setNext(TiptelFieldProcessor next) {
        this.next = next;
    }

    protected int byteArrayToInt(byte[] bytes) {
        if (bytes.length == 1) {
            return (int) bytes[0];
        } else if (bytes.length == 2) {
            return ByteBuffer.wrap(bytes).getShort();
        } else {
            return -1;
        }
    }

    protected String byteArrayToString(byte[] bytes) {
        return new String(bytes, Charset.forName("UTF-8"));
    }

    protected void processNext(TiptelRecord tiptelRecord, TiptelFileReader tiptelFileReader) throws IOException {
        if (next() != null) {
            next().process(tiptelFileReader, tiptelRecord);
        }
    }
}
