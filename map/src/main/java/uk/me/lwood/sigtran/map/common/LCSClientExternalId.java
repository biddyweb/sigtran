package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class LCSClientExternalId {
    private final AddressString externalAddress;

    public LCSClientExternalId(AddressString externalAddress) {
        this.externalAddress = externalAddress;
    }

    public final AddressString getExternalAddress() {
        return externalAddress;
    }
}
