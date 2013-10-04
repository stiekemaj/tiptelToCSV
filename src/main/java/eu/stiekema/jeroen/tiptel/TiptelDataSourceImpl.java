package eu.stiekema.jeroen.tiptel;

import eu.stiekema.jeroen.tiptel.factory.ResourceStateFactory;
import eu.stiekema.jeroen.tiptel.state.ResourceState;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeroen Stiekema
 */
public class TiptelDataSourceImpl implements TiptelDataSource {

    private List<TiptelRecord> records = new ArrayList<TiptelRecord>();

    private TiptelRecord currentRecord;

    private ResourceState resourceState;


    public TiptelDataSourceImpl() {
        resourceState = ResourceStateFactory.createResourceState();
        currentRecord = new TiptelRecord();
    }

    @Override
    public void processBytes(byte[] nextBytes) {
        resourceState.process(currentRecord, nextBytes);
        resourceState = resourceState.next();

        if (resourceState.startOfCycle()) {
            records.add(currentRecord);
            currentRecord = new TiptelRecord();
        }
    }

    @Override
    public List<TiptelRecord> getRecords() {
        return records;
    }
}
