package eu.stiekema.jeroen.tiptel.strategy;

import eu.stiekema.jeroen.tiptel.TiptelDataSource;
import eu.stiekema.jeroen.tiptel.TiptelResourceReader;

/**
 * @author Jeroen Stiekema
 */
public interface TiptelReadStrategy {
    public void execute(TiptelResourceReader reader, TiptelDataSource dataSource);
}
