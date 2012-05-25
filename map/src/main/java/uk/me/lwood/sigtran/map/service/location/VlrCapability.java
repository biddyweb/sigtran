package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.asn1.UniversalType;
import uk.me.lwood.asn1.annotations.Asn1Type;
import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.service.subscriber.SupportedCamelPhases;

/**
 * 
 * @author lukew
 */
public class VlrCapability {
    @Optional
    private final SupportedCamelPhases phases;
    @Optional
    @Asn1Type(UniversalType.NULL)
    private final boolean solsaSupportIndicator;
    
    public VlrCapability(SupportedCamelPhases phases, boolean solsaSupportIndicator) {
        this.phases = phases;
        this.solsaSupportIndicator = solsaSupportIndicator;
    }

    public final SupportedCamelPhases getPhases() {
        return phases;
    }

    public final boolean isSolsaSupportIndicator() {
        return solsaSupportIndicator;
    }
}
