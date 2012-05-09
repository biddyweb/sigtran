package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class ExternalSignalInfo {
    private final ProtocolId protocolId;
    private final String signalInfo;
    
    public ExternalSignalInfo(ProtocolId protocolId, String signalInfo) {
        if (signalInfo == null)
            throw new NullPointerException("signalInfo cannot be null");
        
        if (signalInfo.length() < 1 || signalInfo.length() > 200)
            throw new IllegalArgumentException("signalInfo must be 1 .. 200 characters in length");
        
        this.protocolId = protocolId;
        this.signalInfo = signalInfo;
    }

    public final ProtocolId getProtocolId() {
        return protocolId;
    }

    public final String getSignalInfo() {
        return signalInfo;
    }
}
