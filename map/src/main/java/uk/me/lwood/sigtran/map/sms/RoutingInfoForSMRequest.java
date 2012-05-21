package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.tcap.TcapOperation;

/**
 * 
 * @author lukew
 */
public class RoutingInfoForSMRequest implements TcapOperation {
    private final ISDNAddressString msisdn;
    private final boolean smRpPri;
    private final ISDNAddressString serviceCentre;
    private final boolean gprsSupportIndicator;
    private final SmRpMti smRpMti;
    private final SmRpSmea smRpSmea;
    
    private RoutingInfoForSMRequest(ISDNAddressString msisdn, boolean smRpPri, ISDNAddressString serviceCentre,
                                    boolean gprsSupportIndicator, SmRpMti smRpMti, SmRpSmea smRpSmea) {
        this.msisdn = msisdn;
        this.smRpPri = smRpPri;
        this.serviceCentre = serviceCentre;
        this.gprsSupportIndicator = gprsSupportIndicator;
        this.smRpMti = smRpMti;
        this.smRpSmea = smRpSmea;
    }

    public final ISDNAddressString getMsisdn() {
        return msisdn;
    }

    public final boolean isSmRpPri() {
        return smRpPri;
    }

    public final ISDNAddressString getServiceCentre() {
        return serviceCentre;
    }

    public final boolean isGprsSupportIndicator() {
        return gprsSupportIndicator;
    }

    public final SmRpMti getSmRpMti() {
        return smRpMti;
    }

    public final SmRpSmea getSmRpSmea() {
        return smRpSmea;
    }
}
