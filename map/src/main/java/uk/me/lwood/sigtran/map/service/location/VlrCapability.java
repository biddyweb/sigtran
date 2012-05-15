package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.sigtran.map.service.subscriber.SupportedCamelPhases;

/**
 * 
 * @author lukew
 */
public class VlrCapability {
    private final SupportedCamelPhases phases;
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
