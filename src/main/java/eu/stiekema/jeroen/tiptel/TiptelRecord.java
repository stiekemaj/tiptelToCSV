package eu.stiekema.jeroen.tiptel;

/**
 * Holds the data of a single tiptel t9t record
 *
 * @author Jeroen Stiekema
 */
public class TiptelRecord {
    private int programOrderNr;
    private int memoryLocation;
    private String name;
    private String telephoneNumber;
    private String information;

    public void setProgramOrderNr(int programOrderNr) {
        this.programOrderNr = programOrderNr;
    }

    public int getProgramOrderNr() {
        return programOrderNr;
    }

    public void setMemoryLocation(int memoryLocation) {
        this.memoryLocation = memoryLocation;
    }

    public int getMemoryLocation() {
        return memoryLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }
}
