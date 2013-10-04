package eu.stiekema.jeroen.tiptel.strategy;

import eu.stiekema.jeroen.tiptel.TiptelDataSource;
import eu.stiekema.jeroen.tiptel.TiptelResourceReader;

/**
 * @author Jeroen Stiekema
 */
public class TwoByteReadStrategy implements TiptelReadStrategy {
    @Override
    public void execute(TiptelResourceReader reader, TiptelDataSource dataSource) {
        byte[] bytes = new byte[2];

        if (!reader.hasNext()) {
            throw new RuntimeException("unexpected end of file");
        }

        bytes[0] = reader.nextByte();

        if (!reader.hasNext()) {
            throw new RuntimeException("unexpected end of file");
        }

        bytes[1] = reader.nextByte();

        dataSource.processBytes(bytes);
    }
}
