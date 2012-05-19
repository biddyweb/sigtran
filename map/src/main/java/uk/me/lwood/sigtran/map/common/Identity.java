package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class Identity {
    private final Imsi imsi;
    private final ImsiWithLmsi imsiWithLmsi;
    
    public Identity(Imsi imsi) {
        this(imsi, null);
    }
    
    public Identity(ImsiWithLmsi imsiWithLmsi) {
        this(null, imsiWithLmsi);
    }
    
    private Identity(Imsi imsi, ImsiWithLmsi imsiWithLmsi) {
        this.imsi = imsi;
        this.imsiWithLmsi = imsiWithLmsi;
    }
    
    public Object getChoice() {
        if (imsi != null)
            return imsi;
        
        return imsiWithLmsi;
    }
}
