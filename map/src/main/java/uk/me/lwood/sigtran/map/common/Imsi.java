package uk.me.lwood.sigtran.map.common;

/**
 * 
 * 
 * @author lukew
 */
public final class Imsi {
    private final TbcdString imsi;
    
    public Imsi(TbcdString imsi) {
        if (imsi == null)
            throw new NullPointerException("imsi must not be null");
        
        this.imsi = imsi;
    }
    
    public TbcdString getImsi() {
        return imsi;
    }
}
