package uk.me.lwood.sigtran.map.maintenance;

/**
 * 
 * @author lukew
 */
public class TraceReference {
    private final byte[] reference;
    
    public TraceReference(byte[] reference) {
        this.reference = reference;
    }
    
    public byte[] getReference() {
        return reference;
    }
}
