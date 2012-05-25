package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.asn1.annotations.Optional;

/**
 * 
 * @author lukew
 */
public class LCSQoS {
    @Optional
    private final HorizontalAccuracy horizontalAccuracy;
    @Optional
    private final boolean verticalCoordinateRequest;
    @Optional
    private final VerticalAccuracy verticalAccuracy;
    @Optional
    private final ResponseTime responseTime;
    
    public LCSQoS(HorizontalAccuracy horizontalAccuracy, boolean verticalCoordinateRequest,
                  VerticalAccuracy verticalAccuracy, ResponseTime responseTime) {
        this.horizontalAccuracy = horizontalAccuracy;
        this.verticalCoordinateRequest = verticalCoordinateRequest;
        this.verticalAccuracy = verticalAccuracy;
        this.responseTime = responseTime;
    }

    public final HorizontalAccuracy getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    public final boolean isVerticalCoordinateRequest() {
        return verticalCoordinateRequest;
    }

    public final VerticalAccuracy getVerticalAccuracy() {
        return verticalAccuracy;
    }

    public final ResponseTime getResponseTime() {
        return responseTime;
    }
}
