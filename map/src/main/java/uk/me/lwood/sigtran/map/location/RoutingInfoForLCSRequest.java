package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.SubscriberIdentity;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class RoutingInfoForLCSRequest implements TcapArgument {
    private final ISDNAddressString mlcNumber;
    private final SubscriberIdentity targetMS;
    
    public RoutingInfoForLCSRequest(ISDNAddressString mlcNumber, SubscriberIdentity targetMS) {
        this.mlcNumber = mlcNumber;
        this.targetMS = targetMS;
    }

    public final ISDNAddressString getMlcNumber() {
        return mlcNumber;
    }

    public final SubscriberIdentity getTargetMS() {
        return targetMS;
    }
}
