package eu.stiekema.jeroen.tiptel.strategy;

import eu.stiekema.jeroen.tiptel.TiptelDataSource;
import eu.stiekema.jeroen.tiptel.TiptelResourceReader;

/**
 * @author Jeroen Stiekema
 */
public class StringReadStrategy implements TiptelReadStrategy {
    @Override
    public void execute(TiptelResourceReader reader, TiptelDataSource dataSource) {
        if (!reader.hasNext()) {
            throw new RuntimeException("unexpected end of file");
        }

        int stringLength = reader.nextByte();
        byte[] byteArray = new byte[stringLength];

        for (int i = 0; i < stringLength; i++) {
            byteArray[i] = reader.nextByte();
        }

        dataSource.processBytes(byteArray);
    }
}
