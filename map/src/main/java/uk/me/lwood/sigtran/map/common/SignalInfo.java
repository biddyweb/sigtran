package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class SignalInfo {
    private final byte[] value;
    
    public SignalInfo(byte[] value) {
        if (value.length < 1 || value.length > 200)
            throw new IllegalArgumentException("signalInfo must be 1 .. 200 characters in length");
        
        this.value = value;
    }
    
    public byte[] getValue() {
        return value;
    }
}
