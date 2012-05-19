package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class ImsiWithLmsi {
    private final Imsi imsi;
    private final Lmsi lmsi;
    
    public ImsiWithLmsi(Imsi imsi, Lmsi lmsi) {
        this.imsi = imsi;
        this.lmsi = lmsi;
    }

    public final Imsi getImsi() {
        return imsi;
    }
    
    public final Lmsi getLmsi() {
        return lmsi;
    }
}
