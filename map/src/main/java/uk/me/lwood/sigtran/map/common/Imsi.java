package uk.me.lwood.sigtran.map.common;

/**
 * 
 * 
 * @author lukew
 */
public final class Imsi {
    private final String mcc;
    private final String mnc;
    private final String msin;
    
    public Imsi(String mcc, String mnc, String msin) {
        if (mcc == null)
            throw new NullPointerException("mcc must not be null");
        
        if (mnc == null)
            throw new NullPointerException("mnc must not be null");
        
        if (msin == null)
            throw new NullPointerException("msin must not be null");
        
        if ((mcc.length() + mnc.length() + msin.length()) > 15)
            throw new IllegalArgumentException("mcc + mnc + msin must not be >15 digits");
        
        this.mcc = mcc;
        this.mnc = mnc;
        this.msin = msin;
    }
    
    public String getMcc() {
        return mcc;
    }
    
    public String getMnc() {
        return mnc;
    }
    
    public String getMsin() {
        return msin;
    }
}
