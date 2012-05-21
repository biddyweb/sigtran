package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class PurgeMsArg implements TcapArgument {
    private final Imsi imsi;
    private final ISDNAddressString vlrNumber;
    private final ISDNAddressString sgsnNumber;
    
    public PurgeMsArg(Imsi imsi, ISDNAddressString vlrNumber, ISDNAddressString sgsnNumber) {
        this.imsi = imsi;
        this.vlrNumber = vlrNumber;
        this.sgsnNumber = sgsnNumber;
    }

    public final Imsi getImsi() {
        return imsi;
    }

    public final ISDNAddressString getVlrNumber() {
        return vlrNumber;
    }

    public final ISDNAddressString getSgsnNumber() {
        return sgsnNumber;
    }
}