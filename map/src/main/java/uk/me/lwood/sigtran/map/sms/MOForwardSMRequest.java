package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.Imsi;
import uk.me.lwood.sigtran.map.common.SignalInfo;

/**
 * 
 * @author lukew
 */
public class MOForwardSMRequest {
    private final SmRpDa smRpDa;
    private final SmRpOa smRpOa;
    private final SignalInfo smRpUi;
    private final Imsi imsi;
    
    public MOForwardSMRequest(SmRpDa smRpDa, SmRpOa smRpOa, SignalInfo smRpUi, Imsi imsi) {
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
