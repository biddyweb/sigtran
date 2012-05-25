package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class InformServiceCentreArg implements TcapArgument {
    @Optional
    private final ISDNAddressString storedMsisdn;
    @Optional
    private final MwStatus mwStatus;
    
    private InformServiceCentreArg(ISDNAddressString storedMsisdn, MwStatus mwStatus) {
        this.storedMsisdn = storedMsisdn;
        this.mwStatus = mwStatus;
    }

    public final ISDNAddressString getStoredMsisdn() {
        return storedMsisdn;
    }

    public final MwStatus getMwStatus() {
        return mwStatus;
    }
}
