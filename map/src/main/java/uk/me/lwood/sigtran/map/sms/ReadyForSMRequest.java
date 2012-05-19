package uk.me.lwood.sigtran.map.sms;

import uk.me.lwood.sigtran.map.common.Imsi;

/**
 * 
 * @author lukew
 */
public class ReadyForSMRequest {
    private final Imsi imsi;
    private final AlertReason alertReason;
    private final boolean alertReasonIndicator;
    
    public ReadyForSMRequest(Imsi imsi, AlertReason alertReason, boolean alertReasonIndicator) {
        this.imsi = imsi;
        this.alertReason = alertReason;
        this.alertReasonIndicator = alertReasonIndicator;
    }

    public final Imsi getImsi() {
        return imsi;
    }

    public final AlertReason getAlertReason() {
        return alertReason;
    }

    public final boolean isAlertReasonIndicator() {
        return alertReasonIndicator;
    }
}
