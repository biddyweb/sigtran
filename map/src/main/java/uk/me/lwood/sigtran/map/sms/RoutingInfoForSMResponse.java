package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.Imsi;

/**
 * 
 * @author lukew
 */
public class RoutingInfoForSMResponse {
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
