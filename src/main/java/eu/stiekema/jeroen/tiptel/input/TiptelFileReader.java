package eu.stiekema.jeroen.tiptel.input;

import java.io.IOException;

/**
 * @author Jeroen Stiekema
 */
public interface TiptelFileReader {
    byte[] nextField() throws IOException;

    boolean endOfFile() throws IOException;
}
