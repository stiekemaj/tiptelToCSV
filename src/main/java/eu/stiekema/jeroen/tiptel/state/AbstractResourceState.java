package eu.stiekema.jeroen.tiptel.state;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author Jeroen Stiekema
 */
public abstract class AbstractResourceState implements ResourceState {

    private ResourceState next;

    @Override
    public ResourceState next() {
        return next;
    }

    public void setNext(ResourceState next) {
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
}
