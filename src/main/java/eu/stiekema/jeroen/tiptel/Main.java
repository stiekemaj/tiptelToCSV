package eu.stiekema.jeroen.tiptel;

import java.io.IOException;

/**
 * @author Jeroen Stiekema
 */
public class Main {


    public static void main(String[] args) throws IOException, InvalidTiptelFileException {
        if (args.length != 2) {
            throw new RuntimeException("Twee argumenten verwacht: <inputfile> <outputfile>");
        }

        TiptelFileReader tiptelFileReader = new TiptelFileReader();
        TiptelDataSource tiptelDataSource = new TiptelDataSourceImpl();
        tiptelFileReader.read(args[0], tiptelDataSource);
        new OutputWriter(args[1], tiptelDataSource).write();
    }


}
