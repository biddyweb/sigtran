package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.Imsi;

/**
 * 
 * @author lukew
 */
public class MOForwardSMRequest {
    private final SmRpDa smRpDa;
    private final SmRpOa smRpOa;
    private final String smRpUi;
    private final Imsi imsi;
    
    public MOForwardSMRequest(SmRpDa smRpDa, SmRpOa smRpOa, String smRpUi, Imsi imsi) {
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

    public final String getSmRpUi() {
        return smRpUi;
    }

    public final Imsi getImsi() {
        return imsi;
    }
}
