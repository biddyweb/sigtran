package uk.me.lwood.sigtran.map.maintenance;

import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.common.AddressString;
import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class ActivateTraceModeArg implements TcapArgument {
    @Optional
    private final Imsi imsi;
    private final TraceReference reference;
    private final TraceType traceType;
    @Optional
    private final AddressString omcId;
    
    public ActivateTraceModeArg(Imsi imsi, TraceReference reference, TraceType traceType, AddressString omcId) {
        this.imsi = imsi;
        this.reference = reference;
        this.traceType = traceType;
        this.omcId = omcId;
    }

    public final Imsi getImsi() {
        return imsi;
    }

    public final TraceReference getReference() {
        return reference;
    }

    public final TraceType getTraceType() {
        return traceType;
    }

    public final AddressString getOmcId() {
        return omcId;
    }
}
