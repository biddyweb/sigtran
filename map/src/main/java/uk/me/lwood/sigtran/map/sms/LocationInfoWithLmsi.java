package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.Lmsi;

/**
 * 
 * @author lukew
 */
public class LocationInfoWithLmsi {
    private final ISDNAddressString networkNodeNumber;
    private final Lmsi lmsi;
    private final boolean gprsNodeIndicator;
    
    private LocationInfoWithLmsi(ISDNAddressString networkNodeNumber, Lmsi lmsi, boolean gprsNodeIndicator) {
        this.networkNodeNumber = networkNodeNumber;
        this.lmsi = lmsi;
        this.gprsNodeIndicator = gprsNodeIndicator;
    }

    public final ISDNAddressString getNetworkNodeNumber() {
        return networkNodeNumber;
    }
    
    public final Lmsi getLmsi() {
        return lmsi;
    }
    
    public final boolean isGprsNodeIndicator() {
        return gprsNodeIndicator;
    }
}
