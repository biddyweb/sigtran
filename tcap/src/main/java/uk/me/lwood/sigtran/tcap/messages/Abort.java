package uk.me.lwood.sigtran.tcap.messages;

import uk.me.lwood.sigtran.tcap.DestTransactionId;

/**
 * 
 * @author lukew
 */
public class Abort {
    private final DestTransactionId transactionId;

    private Abort(DestTransactionId transactionId) {
        this.transactionId = transactionId;
    }

    public final DestTransactionId getTransactionId() {
        return transactionId;
    }
}
