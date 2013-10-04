package eu.stiekema.jeroen.tiptel.state;

import eu.stiekema.jeroen.tiptel.TiptelRecord;

/**
 * @author Jeroen Stiekema
 */
public interface ResourceState {
    ResourceState next();

    boolean startOfCycle();

    void process(TiptelRecord record, byte[] value);
}
