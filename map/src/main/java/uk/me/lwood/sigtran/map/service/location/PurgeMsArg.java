package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class PurgeMsArg implements TcapArgument {
    private final Imsi imsi;
    @Optional
    private final ISDNAddressString vlrNumber;
    @Optional
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
