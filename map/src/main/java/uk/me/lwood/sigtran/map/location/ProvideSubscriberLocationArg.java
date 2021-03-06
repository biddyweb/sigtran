package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.asn1.UniversalType;
import uk.me.lwood.asn1.annotations.Asn1Type;
import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.map.common.ISDNAddressString;
import uk.me.lwood.sigtran.map.common.Imei;
import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.map.common.Lmsi;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class ProvideSubscriberLocationArg implements TcapArgument {
    private final LocationType locationType;
    private final ISDNAddressString mlcNumber;
    @Optional
    private final LCSClientId lcsClientId;
    @Optional
    @Asn1Type(UniversalType.NULL)
    private final boolean privacyOverride;
    @Optional
    private final Imsi imsi;
    @Optional
    private final ISDNAddressString msisdn;
    @Optional
    private final Lmsi lmsi;
    @Optional
    private final Imei imei;
    @Optional
    private final LCSPriority lcsPriority;
    @Optional
    private final LCSQoS lcsQoS;
    
    public ProvideSubscriberLocationArg(LocationType locationType, ISDNAddressString mlcNumber,
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
