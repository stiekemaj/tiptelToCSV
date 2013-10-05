package eu.stiekema.jeroen.tiptel.processor;

import eu.stiekema.jeroen.tiptel.TiptelRecord;
import eu.stiekema.jeroen.tiptel.input.TiptelFileReader;
import java.io.IOException;

/**
 * @author Jeroen Stiekema
 */
public interface TiptelFieldProcessor {

    TiptelFieldProcessor next();

    void process(TiptelFileReader tiptelFileReader, TiptelRecord record) throws IOException;
}
