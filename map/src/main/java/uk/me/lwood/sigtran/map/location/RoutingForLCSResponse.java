package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.sigtran.map.common.SubscriberIdentity;

/**
 * 
 * @author lukew
 */
public class RoutingForLCSResponse {
    private final SubscriberIdentity targetMS;
    private final LCSLocationInfo lcsLocationInfo;
    
    public RoutingForLCSResponse(SubscriberIdentity targetMS, LCSLocationInfo lcsLocationInfo) {
        this.targetMS = targetMS;
        this.lcsLocationInfo = lcsLocationInfo;
    }

    public final SubscriberIdentity getTargetMS() {
        return targetMS;
    }

    public final LCSLocationInfo getLcsLocationInfo() {
        return lcsLocationInfo;
    }
}
