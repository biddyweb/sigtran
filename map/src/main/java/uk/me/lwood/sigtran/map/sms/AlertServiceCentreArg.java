package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.AddressString;
import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class AlertServiceCentreArg implements TcapArgument {
    private final ISDNAddressString msisdn;
    private final AddressString serviceCentreAddress;
    
    private AlertServiceCentreArg(ISDNAddressString msisdn, AddressString serviceCentreAddress) {
        this.msisdn = msisdn;
        this.serviceCentreAddress = serviceCentreAddress;
    }

    public final ISDNAddressString getMsisdn() {
        return msisdn;
    }

    public final AddressString getServiceCentreAddress() {
        return serviceCentreAddress;
    }
}
