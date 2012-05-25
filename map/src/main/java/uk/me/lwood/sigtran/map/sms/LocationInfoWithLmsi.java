package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.asn1.UniversalType;
import uk.me.lwood.asn1.annotations.Asn1Type;
import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.Lmsi;

/**
 * 
 * @author lukew
 */
public class LocationInfoWithLmsi {
    private final ISDNAddressString networkNodeNumber;
    @Optional
    private final Lmsi lmsi;
    @Optional
    @Asn1Type(UniversalType.NULL)
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
