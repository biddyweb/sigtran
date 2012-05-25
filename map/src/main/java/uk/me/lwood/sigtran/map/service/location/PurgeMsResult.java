package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.asn1.UniversalType;
import uk.me.lwood.asn1.annotations.Asn1Type;
import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class PurgeMsResult implements TcapResult {
    @Optional
    @Asn1Type(UniversalType.NULL)
    private final boolean freezeTmsi;
    @Optional
    @Asn1Type(UniversalType.NULL)
    private final boolean freezePTmsi;
    
    public PurgeMsResult(boolean freezeTmsi, boolean freezePTmsi) {
        this.freezeTmsi = freezeTmsi;
        this.freezePTmsi = freezePTmsi;
    }

    public final boolean isFreezeTmsi() {
        return freezeTmsi;
    }
    
    public final boolean isFreezePTmsi() {
        return freezePTmsi;
    }
}
