package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;

/**
 * 
 * @author lukew
 */
public class UpdateLocationResponse {
    private final ISDNAddressString hlrNumber;

    public UpdateLocationResponse(ISDNAddressString hlrNumber) {
        this.hlrNumber = hlrNumber;
    }

    public final ISDNAddressString getHlrNumber() {
        return hlrNumber;
    }
}
