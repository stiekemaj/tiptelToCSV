package eu.stiekema.jeroen.tiptel;

import eu.stiekema.jeroen.tiptel.input.TiptelFileReader;
import eu.stiekema.jeroen.tiptel.input.TiptelFileReaderImpl;
import eu.stiekema.jeroen.tiptel.output.CsvOutputWriter;
import eu.stiekema.jeroen.tiptel.output.OutputWriter;
import eu.stiekema.jeroen.tiptel.processor.Tiptel195ProcessorFactory;
import eu.stiekema.jeroen.tiptel.processor.TiptelProcessorFactory;
import java.io.IOException;

/**
 * @author Jeroen Stiekema
 */
public class Main {


    public static void main(String[] args) throws IOException, InvalidTiptelFileException {
        if (args.length != 2) {
            System.err.println("Two arguments expected: <inputfile> <outputfile>");
            System.exit(0);
        }

        TiptelFileReader tiptelFileReader = new TiptelFileReaderImpl(args[0]);
        TiptelProcessorFactory tiptelProcessorFactory = new Tiptel195ProcessorFactory();
        OutputWriter outputWriter = new CsvOutputWriter(args[1]);

        TiptelConverter converter = new TiptelConverter(tiptelProcessorFactory);
        converter.convert(tiptelFileReader, outputWriter);
        outputWriter.flush();
    }
}
