package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class SubscriberIdentity {
    private final Imsi imsi;
    private final ISDNAddressString msisdn;
    
    public SubscriberIdentity(Imsi imsi) {
        this(imsi, null);
    }
    
    public SubscriberIdentity(ISDNAddressString msisdn) {
        this(null, msisdn);
    }
    
    private SubscriberIdentity(Imsi imsi, ISDNAddressString msisdn) {
        this.imsi = imsi;
        this.msisdn = msisdn;
    }
    
    public Object getChoice() {
        if (imsi != null)
            return imsi;
        
        return msisdn;
    }
}
