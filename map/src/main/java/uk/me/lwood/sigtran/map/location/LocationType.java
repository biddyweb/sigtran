package uk.me.lwood.sigtran.map.location;

/**
 * 
 * @author lukew
 */
public class LocationType {
    private final LocationEstimateType locationEstimateType;
    
    public LocationType(LocationEstimateType locationEstimateType) {
        this.locationEstimateType = locationEstimateType;
    }

    public final LocationEstimateType getLocationEstimateType() {
        return locationEstimateType;
    }
}
