package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.AddressString;
import uk.me.lwood.sigtran.map.common.ISDNAddressString;

/**
 * 
 * @author lukew
 */
public class SmRpOa {
    private final ISDNAddressString msisdn;
    private final AddressString serviceCentreAddress;
    
    public SmRpOa(ISDNAddressString msisdn) {
        this(msisdn, null);
    }
    
    public SmRpOa(AddressString serviceCentreAddress) {
        this(null, serviceCentreAddress);
    }

    private SmRpOa(ISDNAddressString msisdn, AddressString serviceCentreAddress) {
        this.msisdn = msisdn;
        this.serviceCentreAddress = serviceCentreAddress;
    }
    
    public Object getChoice() {
        if (msisdn != null)
            return msisdn;
        
        if (serviceCentreAddress != null)
            return serviceCentreAddress;
        
        return null;
    }
}
