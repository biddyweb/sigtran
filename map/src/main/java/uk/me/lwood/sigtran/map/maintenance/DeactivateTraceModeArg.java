package uk.me.lwood.sigtran.map.maintenance;

import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class DeactivateTraceModeArg implements TcapResult {
    @Optional
    private final Imsi imsi;
    private final TraceReference reference;
    
    public DeactivateTraceModeArg(Imsi imsi, TraceReference reference) {
        this.imsi = imsi;
        this.reference = reference;
    }

    public final Imsi getImsi() {
        return imsi;
    }

    public final TraceReference getReference() {
        return reference;
    }
}
