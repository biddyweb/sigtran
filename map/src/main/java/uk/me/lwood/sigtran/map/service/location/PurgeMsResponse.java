package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.sigtran.tcap.TcapResult;

/**
 * 
 * @author lukew
 */
public class PurgeMsResponse implements TcapResult {
    private final boolean freezeTmsi;
    private final boolean freezePTmsi;
    
    public PurgeMsResponse(boolean freezeTmsi, boolean freezePTmsi) {
        this.freezeTmsi = freezeTmsi;
        this.freezePTmsi = freezePTmsi;
    }

    public final boolean isFreezeTmsi() {
        return freezeTmsi;
    }
    
    public final boolean isFreezePTmsi() {
        return freezePTmsi;
    }
}
