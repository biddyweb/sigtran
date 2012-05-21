package uk.me.lwood.sigtran.map.sms;

/**
 * 
 * @author lukew
 */
public class SmRpMti {
    public static final SmRpMti DELIVER = new SmRpMti(0);
    public static final SmRpMti STATUS_REPORT = new SmRpMti(0);
    
    private final int type;
    
    private SmRpMti(int type) {
        this.type = type;
    }
    
    public int getType() {
        return type;
    }
}
