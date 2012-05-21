package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.sigtran.map.common.SubscriberIdentity;
import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class RoutingInfoForLCSResponse implements TcapResult {
    private final SubscriberIdentity targetMS;
    private final LCSLocationInfo lcsLocationInfo;
    
    public RoutingInfoForLCSResponse(SubscriberIdentity targetMS, LCSLocationInfo lcsLocationInfo) {
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
