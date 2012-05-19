package uk.me.lwood.sigtran.map.location;

/**
 * 
 * @author lukew
 */
public class ResponseTime {
    private final ResponseTimeCategory responseTimeCategory;

    public ResponseTime(ResponseTimeCategory responseTimeCategory) {
        this.responseTimeCategory = responseTimeCategory;
    }

    public final ResponseTimeCategory getResponseTimeCategory() {
        return responseTimeCategory;
    }
}
