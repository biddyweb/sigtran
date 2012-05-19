package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class ExternalSignalInfo {
    private final ProtocolId protocolId;
    private final SignalInfo signalInfo;
    
    public ExternalSignalInfo(ProtocolId protocolId, SignalInfo signalInfo) {
        if (signalInfo == null)
            throw new NullPointerException("signalInfo cannot be null");
        
        this.protocolId = protocolId;
        this.signalInfo = signalInfo;
    }

    public final ProtocolId getProtocolId() {
        return protocolId;
    }

    public final SignalInfo getSignalInfo() {
        return signalInfo;
    }
}
