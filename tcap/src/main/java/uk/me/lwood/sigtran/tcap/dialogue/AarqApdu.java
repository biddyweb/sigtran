package uk.me.lwood.sigtran.tcap.dialogue;

/**
 * 
 * @author lukew
 */
public class AarqApdu {
    private final int protocolVersion;

    private AarqApdu(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public final int getProtocolVersion() {
        return protocolVersion;
    }
}
