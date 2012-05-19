package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.Imei;
import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.map.common.Lmsi;
import uk.me.lwood.sigtran.tcap.TcapOperation;

/**
 * 
 * @author lukew
 */
public class ProvideSubscriberLocationRequest implements TcapOperation {
    private final LocationType locationType;
    private final ISDNAddressString mlcNumber;
    private final LCSClientId lcsClientId;
    private final boolean privacyOverride;
    private final Imsi imsi;
    private final ISDNAddressString msisdn;
    private final Lmsi lmsi;
    private final Imei imei;
    private final LCSPriority lcsPriority;
    private final LCSQoS lcsQoS;
    
    public ProvideSubscriberLocationRequest(LocationType locationType, ISDNAddressString mlcNumber,
                                            LCSClientId lcsClientId, boolean privacyOverride, Imsi imsi,
                                            ISDNAddressString msisdn, Lmsi lmsi, Imei imei, LCSPriority lcsPriority,
                                            LCSQoS lcsQoS) {
        this.locationType = locationType;
        this.mlcNumber = mlcNumber;
        this.lcsClientId = lcsClientId;
        this.privacyOverride = privacyOverride;
        this.imsi = imsi;
        this.msisdn = msisdn;
        this.lmsi = lmsi;
        this.imei = imei;
        this.lcsPriority = lcsPriority;
        this.lcsQoS = lcsQoS;
    }

    public final LocationType getLocationType() {
        return locationType;
    }

    public final ISDNAddressString getMlcNumber() {
        return mlcNumber;
    }

    public final LCSClientId getLcsClientId() {
        return lcsClientId;
    }

    public final boolean isPrivacyOverride() {
        return privacyOverride;
    }

    public final Imsi getImsi() {
        return imsi;
    }

    public final ISDNAddressString getMsisdn() {
        return msisdn;
    }

    public final Lmsi getLmsi() {
        return lmsi;
    }

    public final Imei getImei() {
        return imei;
    }

    public final LCSPriority getLcsPriority() {
        return lcsPriority;
    }

    public final LCSQoS getLcsQoS() {
        return lcsQoS;
    }
}
