package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.AddressString;
import uk.me.lwood.sigtran.map.common.ISDNAddressString;

/**
 * XXX: currently has no GPRS support
 * 
 * @author lukew
 */
public class ReportSMDeliveryStatusRequest {
    private final ISDNAddressString msisdn;
    private final AddressString serviceCentreAddress;
    private final SMDeliveryOutcome smDeliveryOutcome;
    
    public ReportSMDeliveryStatusRequest(ISDNAddressString msisdn, AddressString serviceCentreAddress,
                                         SMDeliveryOutcome smDeliveryOutcome) {
        this.msisdn = msisdn;
        this.serviceCentreAddress = serviceCentreAddress;
        this.smDeliveryOutcome = smDeliveryOutcome;
    }

    public final ISDNAddressString getMsisdn() {
        return msisdn;
    }

    public final AddressString getServiceCentreAddress() {
        return serviceCentreAddress;
    }

    public final SMDeliveryOutcome getSmDeliveryOutcome() {
        return smDeliveryOutcome;
    }
}
