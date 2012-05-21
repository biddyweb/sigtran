package uk.me.lwood.sigtran.map.maintenance;

import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class DeactivateTraceModeRequest implements TcapResult {
    private final Imsi imsi;
    private final TraceReference reference;
    
    public DeactivateTraceModeRequest(Imsi imsi, TraceReference reference) {
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
