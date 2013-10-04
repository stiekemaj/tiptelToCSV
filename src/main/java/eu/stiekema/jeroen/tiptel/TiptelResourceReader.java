package eu.stiekema.jeroen.tiptel;

/**
 * @author Jeroen Stiekema
 */
public interface TiptelResourceReader {
    byte nextByte();

    boolean hasNext();

    long getPosition();
}
