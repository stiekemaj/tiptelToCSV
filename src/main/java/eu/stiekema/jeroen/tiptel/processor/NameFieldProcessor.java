package eu.stiekema.jeroen.tiptel.processor;

import eu.stiekema.jeroen.tiptel.TiptelRecord;
import eu.stiekema.jeroen.tiptel.input.TiptelFileReader;
import java.io.IOException;

/**
 * @author Jeroen Stiekema
 */
class NameFieldProcessor extends AbstractTiptelFieldProcessor {

    @Override
    public void process(TiptelFileReader tiptelFileReader, TiptelRecord tiptelRecord) throws IOException {
        byte[] field = tiptelFileReader.nextField();
        tiptelRecord.setName(byteArrayToString(field));
        processNext(tiptelRecord, tiptelFileReader);
    }
}
