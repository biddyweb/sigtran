package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.tcap.TcapOperation;

/**
 * 
 * @author lukew
 */
public class UpdateLocationResponse implements TcapOperation {
    private final ISDNAddressString hlrNumber;

    public UpdateLocationResponse(ISDNAddressString hlrNumber) {
        this.hlrNumber = hlrNumber;
    }

    public final ISDNAddressString getHlrNumber() {
        return hlrNumber;
    }
}
