package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class RoutingInfoForSMResponse implements TcapResult {
    private final Imsi imsi;
    private final LocationInfoWithLmsi locationInfo;
    
    private RoutingInfoForSMResponse(Imsi imsi, LocationInfoWithLmsi locationInfo) {
        this.imsi = imsi;
        this.locationInfo = locationInfo;
    }

    public final Imsi getImsi() {
        return imsi;
    }

    public final LocationInfoWithLmsi getLocationInfo() {
        return locationInfo;
    }
}
