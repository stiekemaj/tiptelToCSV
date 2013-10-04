package eu.stiekema.jeroen.tiptel.state;

import eu.stiekema.jeroen.tiptel.TiptelRecord;
import java.util.Arrays;

/**
 * @author Jeroen Stiekema
 */
public class ChargeResourceState extends AbstractResourceState {
    @Override
    public boolean startOfCycle() {
        return false;
    }

    @Override
    public void process(TiptelRecord record, byte[] value) {
        System.out.println("processing charge: " + Arrays.toString(value));
    }
}
