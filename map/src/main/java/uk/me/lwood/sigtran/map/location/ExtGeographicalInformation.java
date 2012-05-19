package uk.me.lwood.sigtran.map.location;

/**
 * 
 * @author lukew
 */
public class ExtGeographicalInformation {
    private final byte[] value;
    
    public ExtGeographicalInformation(byte[] value) {
        this.value = value;
    }
    
    public byte[] getValue() {
        return value;
    }
}
