package uk.me.lwood.sigtran.map.service.subscriber;

/**
 * 
 * @author lukew
 */
public class SupportedCamelPhases {
    private final byte[] phases;
    
    public SupportedCamelPhases(byte[] phases) {
        this.phases = phases;
    }
    
    public byte[] getPhases() {
        return phases;
    }
}
