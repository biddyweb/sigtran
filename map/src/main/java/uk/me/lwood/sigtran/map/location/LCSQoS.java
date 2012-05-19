package uk.me.lwood.sigtran.map.location;

/**
 * 
 * @author lukew
 */
public class LCSQoS {
    private final HorizontalAccuracy horizontalAccuracy;
    private final boolean verticalCoordinateRequest;
    private final VerticalAccuracy verticalAccuracy;
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
