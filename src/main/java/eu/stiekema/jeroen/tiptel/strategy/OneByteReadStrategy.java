package eu.stiekema.jeroen.tiptel.strategy;

import eu.stiekema.jeroen.tiptel.TiptelDataSource;
import eu.stiekema.jeroen.tiptel.TiptelResourceReader;

/**
 * @author Jeroen Stiekema
 */
public class OneByteReadStrategy implements TiptelReadStrategy {
    @Override
    public void execute(TiptelResourceReader reader, TiptelDataSource dataSource) {
        if (!reader.hasNext()) {
            throw new IllegalStateException("unexpected end of file");
        }

        byte bite = reader.nextByte();
        dataSource.processBytes(new byte[] {bite});
    }
}
