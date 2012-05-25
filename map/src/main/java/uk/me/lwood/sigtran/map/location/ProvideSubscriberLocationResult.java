package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.common.AgeofLocationInformation;
import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class ProvideSubscriberLocationResult implements TcapResult {
    private final ExtGeographicalInformation locationEstimate;
    @Optional
    private final AgeofLocationInformation ageOfLocationEstimate;
    
    public ProvideSubscriberLocationResult(ExtGeographicalInformation locationEstimate,
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
