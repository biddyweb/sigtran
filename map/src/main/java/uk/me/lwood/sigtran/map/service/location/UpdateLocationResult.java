package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class UpdateLocationResult implements TcapResult {
    private final ISDNAddressString hlrNumber;

    public UpdateLocationResult(ISDNAddressString hlrNumber) {
        this.hlrNumber = hlrNumber;
    }

    public final ISDNAddressString getHlrNumber() {
        return hlrNumber;
    }
}
