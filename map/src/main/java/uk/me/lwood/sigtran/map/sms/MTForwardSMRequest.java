package uk.me.lwood.sigtran.map.sms;

/**
 * 
 * @author lukew
 */
public class MTForwardSMRequest {
    private final SmRpDa smRpDa;
    private final SmRpOa smRpOa;
    private final String smRpUi;
    private final boolean moreMessagesToSend;
    
    public MTForwardSMRequest(SmRpDa smRpDa, SmRpOa smRpOa, String smRpUi, boolean moreMessagesToSend) {
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

    public final String getSmRpUi() {
        return smRpUi;
    }

    public final boolean isMoreMessagesToSend() {
        return moreMessagesToSend;
    }
}
