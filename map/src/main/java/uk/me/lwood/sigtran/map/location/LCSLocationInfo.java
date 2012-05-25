package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.Lmsi;

/**
 * 
 * @author lukew
 */
public class LCSLocationInfo {
    private final ISDNAddressString mscNumber;
    @Optional
    private final Lmsi lmsi;
    
    public LCSLocationInfo(ISDNAddressString mscNumber, Lmsi lmsi) {
        this.mscNumber = mscNumber;
        this.lmsi = lmsi;
    }

    public final ISDNAddressString getMscNumber() {
        return mscNumber;
    }

    public final Lmsi getLmsi() {
        return lmsi;
    }
}
