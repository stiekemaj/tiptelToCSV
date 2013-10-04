package eu.stiekema.jeroen.tiptel.state;

import eu.stiekema.jeroen.tiptel.TiptelRecord;

/**
 * @author Jeroen Stiekema
 */
public class ProgramOrderNrState extends AbstractResourceState {
    @Override
    public void process(TiptelRecord record, byte[] value) {
        record.setProgramOrderNr(byteArrayToInt(value));
    }

    @Override
    public boolean startOfCycle() {
        return true;
    }
}
