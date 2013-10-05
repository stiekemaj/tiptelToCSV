package eu.stiekema.jeroen.tiptel.processor;

import eu.stiekema.jeroen.tiptel.TiptelRecord;
import eu.stiekema.jeroen.tiptel.input.TiptelFileReader;
import java.io.IOException;

/**
 * @author Jeroen Stiekema
 */
class InformationFieldProcessor extends AbstractTiptelFieldProcessor {

    @Override
    public void process(TiptelFileReader tiptelFileReader, TiptelRecord record) throws IOException {
        byte[] field = tiptelFileReader.nextField();
        record.setInformation(byteArrayToString(field));
        processNext(record, tiptelFileReader);
    }
}
