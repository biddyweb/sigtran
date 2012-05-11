package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.SignalInfo;

/**
 * 
 * @author lukew
 */
public class MTForwardSMRequest {
    private final SmRpDa smRpDa;
    private final SmRpOa smRpOa;
    private final SignalInfo smRpUi;
    private final boolean moreMessagesToSend;
    
    public MTForwardSMRequest(SmRpDa smRpDa, SmRpOa smRpOa, SignalInfo smRpUi, boolean moreMessagesToSend) {
        this.smRpDa = smRpDa;
        this.smRpOa = smRpOa;
        this.smRpUi = smRpUi;
        this.moreMessagesToSend = moreMessagesToSend;
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

    public final boolean isMoreMessagesToSend() {
        return moreMessagesToSend;
    }
}
