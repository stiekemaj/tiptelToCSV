package eu.stiekema.jeroen.tiptel;

import java.util.List;

/**
 * @author Jeroen Stiekema
 */
public interface TiptelDataSource {
    void processBytes(byte[] nextBytes);

    List<TiptelRecord> getRecords();
}
