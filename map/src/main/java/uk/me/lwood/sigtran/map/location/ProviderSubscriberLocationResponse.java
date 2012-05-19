package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.sigtran.map.common.AgeofLocationInformation;

/**
 * 
 * @author lukew
 */
public class ProviderSubscriberLocationResponse {
    private final ExtGeographicalInformation locationEstimate;
    private final AgeofLocationInformation ageOfLocationEstimate;
    
    public ProviderSubscriberLocationResponse(ExtGeographicalInformation locationEstimate,
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