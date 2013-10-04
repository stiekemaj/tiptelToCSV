package eu.stiekema.jeroen.tiptel.state;

import eu.stiekema.jeroen.tiptel.TiptelRecord;

/**
 * @author Jeroen Stiekema
 */
public class InformationResourceState extends AbstractResourceState {
    @Override
    public boolean startOfCycle() {
        return false;
    }

    @Override
    public void process(TiptelRecord record, byte[] value) {
        System.out.println("processing information: " + byteArrayToString(value));
        record.setInformation(byteArrayToString(value));
    }
}
