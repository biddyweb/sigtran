package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.map.common.Lmsi;

/**
 * 
 * @author lukew
 */
public class UpdateLocationArg {
    private final Imsi imsi;
    private final ISDNAddressString mscNumber;
    private final ISDNAddressString vlrNumber;
    private final Lmsi lmsi;
    private final VlrCapability vlrCapability;
    
    public UpdateLocationArg(Imsi imsi, ISDNAddressString mscNumber, ISDNAddressString vlrNumber, Lmsi lmsi,
                                 VlrCapability vlrCapability) {
        this.imsi = imsi;
        this.mscNumber = mscNumber;
        this.vlrNumber = vlrNumber;
        this.lmsi = lmsi;
        this.vlrCapability = vlrCapability;
    }

    public final Imsi getImsi() {
        return imsi;
    }

    public final ISDNAddressString getMscNumber() {
        return mscNumber;
    }

    public final ISDNAddressString getVlrNumber() {
        return vlrNumber;
    }

    public final Lmsi getLmsi() {
        return lmsi;
    }

    public final VlrCapability getVlrCapability() {
        return vlrCapability;
    }
}
