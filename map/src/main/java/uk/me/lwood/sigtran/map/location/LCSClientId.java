package uk.me.lwood.sigtran.map.location;

import uk.me.lwood.sigtran.map.common.AddressString;
import uk.me.lwood.sigtran.map.common.LCSClientExternalId;
import uk.me.lwood.sigtran.map.common.LCSClientInternalId;

/**
 * 
 * @author lukew
 */
public class LCSClientId {
    private final LCSClientType lcsClientType;
    private final LCSClientExternalId lcsClientExternalId;
    private final AddressString lcsClientDialedByMS;
    private final LCSClientInternalId lcsClientInternalId;
    private final LCSClientName lcsClientName;
    
    public LCSClientId(LCSClientType lcsClientType, LCSClientExternalId lcsClientExternalId,
                       AddressString lcsClientDialedByMS, LCSClientInternalId lcsClientInternalId,
                       LCSClientName lcsClientName) {
        this.lcsClientType = lcsClientType;
        this.lcsClientExternalId = lcsClientExternalId;
        this.lcsClientDialedByMS = lcsClientDialedByMS;
        this.lcsClientInternalId = lcsClientInternalId;
        this.lcsClientName = lcsClientName;
    }

    public final LCSClientType getLcsClientType() {
        return lcsClientType;
    }

    public final LCSClientExternalId getLcsClientExternalId() {
        return lcsClientExternalId;
    }

    public final AddressString getLcsClientDialedByMS() {
        return lcsClientDialedByMS;
    }

    public final LCSClientInternalId getLcsClientInternalId() {
        return lcsClientInternalId;
    }

    public final LCSClientName getLcsClientName() {
        return lcsClientName;
    }
}
