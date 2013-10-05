package eu.stiekema.jeroen.tiptel.output;

import eu.stiekema.jeroen.tiptel.TiptelRecord;

/**
 * @author Jeroen Stiekema
 */
public interface OutputWriter {
    void write(TiptelRecord record);

    void flush();
}
