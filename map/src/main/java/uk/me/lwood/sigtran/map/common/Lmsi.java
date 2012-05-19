package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class Lmsi {
    private final String lmsi;
    
    public Lmsi(String lmsi) {
        if (lmsi == null)
            throw new NullPointerException("lmsi cannot be null");
        
        if (lmsi.length() != 4)
            throw new IllegalArgumentException("lmsi must be 4 characters long");
        
        this.lmsi = lmsi;
    }
    
    public String getLmsi() {
        return lmsi;
    }
}
