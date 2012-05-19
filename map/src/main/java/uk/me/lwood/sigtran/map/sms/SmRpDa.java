package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.AddressString;
import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.map.common.Lmsi;

/**
 * 
 * @author lukew
 */
public class SmRpDa {
    private final Imsi imsi;
    private final Lmsi lmsi;
    private final AddressString serviceCentreAddress;
    
    public SmRpDa(Imsi imsi) {
        this(imsi, null, null);
    }
    
    public SmRpDa(Lmsi lmsi) {
        this(null, lmsi, null);
    }
    
    public SmRpDa(AddressString serviceCentreAddress) {
        this(null, null, serviceCentreAddress);
    }

    private SmRpDa(Imsi imsi, Lmsi lmsi, AddressString serviceCentreAddress) {
        this.imsi = imsi;
        this.lmsi = lmsi;
        this.serviceCentreAddress = serviceCentreAddress;
    }
    
    public Object getChoice() {
        if (imsi != null)
            return imsi;
        
        if (lmsi != null)
            return lmsi;
        
        if (serviceCentreAddress != null)
            return serviceCentreAddress;
        
        return null;
    }
}
