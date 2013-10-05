package eu.stiekema.jeroen.tiptel;

import eu.stiekema.jeroen.tiptel.input.TiptelFileReader;
import eu.stiekema.jeroen.tiptel.output.OutputWriter;
import eu.stiekema.jeroen.tiptel.processor.TiptelFieldProcessor;
import eu.stiekema.jeroen.tiptel.processor.TiptelProcessorFactory;
import java.io.IOException;

/**
 * @author Jeroen Stiekema
 */
public class TiptelConverter {
    TiptelFieldProcessor tiptelFieldProcessor;

    public TiptelConverter(TiptelProcessorFactory tiptelProcessorFactory) {
        this.tiptelFieldProcessor = tiptelProcessorFactory.createTiptelFieldProcessor();
    }

    public void convert(TiptelFileReader tiptelFileReader, OutputWriter outputWriter) throws IOException {
        while (!tiptelFileReader.endOfFile()) {
            TiptelRecord tiptelRecord = new TiptelRecord();
            tiptelFieldProcessor.process(tiptelFileReader, tiptelRecord);
            outputWriter.write(tiptelRecord);
        }
    }
}
