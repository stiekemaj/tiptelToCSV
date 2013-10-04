package eu.stiekema.jeroen.tiptel;

/**
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

    public String toCommaSeparatedLine() {
        String name = this.name != null ? this.name.replace("\t", "   ") : "";
        String telephoneNumber = this.telephoneNumber != null ? this.telephoneNumber.replace("\t", "   ") : "";
        String information = this.information != null ? this.information.replace("\t", "   ") : "";
        return String.format("%s\t%s\t%s", name.replace("\t", "  "), telephoneNumber, information);
    }

    public static String getCommaSeparetedHeader() {
        return "NAAM\tTELEFOONNUMMER\tINFORMATIE";
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }
}
