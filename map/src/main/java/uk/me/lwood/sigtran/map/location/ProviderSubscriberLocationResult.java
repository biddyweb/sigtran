package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.sigtran.map.common.AgeofLocationInformation;
import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class ProviderSubscriberLocationResult implements TcapResult {
    private final ExtGeographicalInformation locationEstimate;
    private final AgeofLocationInformation ageOfLocationEstimate;
    
    public ProviderSubscriberLocationResult(ExtGeographicalInformation locationEstimate,
                                              AgeofLocationInformation ageOfLocationEstimate) {
        this.locationEstimate = locationEstimate;
        this.ageOfLocationEstimate = ageOfLocationEstimate;
    }

    public final ExtGeographicalInformation getLocationEstimate() {
        return locationEstimate;
    }

    public final AgeofLocationInformation getAgeOfLocationEstimate() {
        return ageOfLocationEstimate;
    }
}
