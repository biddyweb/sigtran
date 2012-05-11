package uk.me.lwood.sigtran.map.location;

/**
 * 
 * @author lukew
 */
public class LCSPriority {
    public static final LCSPriority HIGHEST = new LCSPriority(0);
    public static final LCSPriority NORMAL = new LCSPriority(1);
    
    private final byte[] value;
    
    private LCSPriority(int value) {
        this.value = new byte[] { (byte) value };
    }
    
    public byte[] getValue() {
        return value;
    }
}
