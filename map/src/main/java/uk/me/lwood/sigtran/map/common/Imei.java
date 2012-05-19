package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public final class Imei {
    private final TbcdString imei;
    
    public Imei(TbcdString imei) {
        this.imei = imei;
    }

    public final TbcdString getImei() {
        return imei;
    }
}
