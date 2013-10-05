package eu.stiekema.jeroen.tiptel.input;

import java.io.IOException;

/**
 * @author Jeroen Stiekema
 */
public interface FieldReader {
    public byte[] read(TiptelFileReader reader) throws IOException;
}
