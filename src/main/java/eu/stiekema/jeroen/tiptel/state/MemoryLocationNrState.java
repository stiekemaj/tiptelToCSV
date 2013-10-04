package eu.stiekema.jeroen.tiptel.state;

import eu.stiekema.jeroen.tiptel.TiptelRecord;

/**
 * @author Jeroen Stiekema
 */
public class MemoryLocationNrState extends AbstractResourceState {

    @Override
    public boolean startOfCycle() {
        return false;
    }

    @Override
    public void process(TiptelRecord record, byte[] value) {
        record.setMemoryLocation(byteArrayToInt(value));
    }
}
