package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public final class Imei {
    private final String typeApprovalCode;
    private final String finalAssemblyCode;
    private final String serialNumber;
    private final String softwareVersionNumber;
    
    public Imei(String typeApprovalCode, String finalAssemblyCode, String serialNumber, String softwareVersionNumber) {
        this.typeApprovalCode = typeApprovalCode;
        this.finalAssemblyCode = finalAssemblyCode;
        this.serialNumber = serialNumber;
        this.softwareVersionNumber = softwareVersionNumber;
    }

    public final String getTypeApprovalCode() {
        return typeApprovalCode;
    }

    public final String getFinalAssemblyCode() {
        return finalAssemblyCode;
    }

    public final String getSerialNumber() {
        return serialNumber;
    }

    public final String getSoftwareVersionNumber() {
        return softwareVersionNumber;
    }
}
