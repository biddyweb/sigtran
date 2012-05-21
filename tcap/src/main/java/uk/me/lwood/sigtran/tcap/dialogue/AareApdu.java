package uk.me.lwood.sigtran.tcap.dialogue;

/**
 * 
 * @author lukew
 */
public class AareApdu {
    private final int protocolVersion;
    private final AssociateResult result;
    private final AssociateSourceDiagnostic resultSourceDiagnostic;
    
    public AareApdu(int protocolVersion, AssociateResult result, AssociateSourceDiagnostic resultSourceDiagnostic) {
        this.protocolVersion = protocolVersion;
        this.result = result;
        this.resultSourceDiagnostic = resultSourceDiagnostic;
    }

    public final int getProtocolVersion() {
        return protocolVersion;
    }

    public final AssociateResult getResult() {
        return result;
    }

    public final AssociateSourceDiagnostic getResultSourceDiagnostic() {
        return resultSourceDiagnostic;
    }
}
