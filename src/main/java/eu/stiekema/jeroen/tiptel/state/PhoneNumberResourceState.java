package eu.stiekema.jeroen.tiptel.state;

import eu.stiekema.jeroen.tiptel.TiptelRecord;

/**
 * @author Jeroen Stiekema
 */
public class PhoneNumberResourceState extends AbstractResourceState {
    @Override
    public boolean startOfCycle() {
        return false;
    }

    @Override
    public void process(TiptelRecord record, byte[] value) {
        System.out.println("processing phone number: " + byteArrayToString(value));
        record.setTelephoneNumber(byteArrayToString(value));
    }
}
