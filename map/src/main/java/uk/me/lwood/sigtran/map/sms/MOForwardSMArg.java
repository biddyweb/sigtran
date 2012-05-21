package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.map.common.SignalInfo;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class MOForwardSMArg implements TcapArgument {
    private final SmRpDa smRpDa;
    private final SmRpOa smRpOa;
    private final SignalInfo smRpUi;
    private final Imsi imsi;
    
    public MOForwardSMArg(SmRpDa smRpDa, SmRpOa smRpOa, SignalInfo smRpUi, Imsi imsi) {
        this.smRpDa = smRpDa;
        this.smRpOa = smRpOa;
        this.smRpUi = smRpUi;
        this.imsi = imsi;
    }

    public final SmRpDa getSmRpDa() {
        return smRpDa;
    }

    public final SmRpOa getSmRpOa() {
        return smRpOa;
    }

    public final SignalInfo getSmRpUi() {
        return smRpUi;
    }

    public final Imsi getImsi() {
        return imsi;
    }
}
