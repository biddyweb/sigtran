package uk.me.lwood.sigtran.tcap;

/**
 * 
 * @author lukew
 */
public class DestTransactionId {
    private final byte[] transactionId;
    
    public DestTransactionId(byte[] transactionId) {
        if (transactionId.length < 1 || transactionId.length > 4)
            throw new IllegalArgumentException("TransactionId must be 1 .. 4 octets");
        
        this.transactionId = transactionId;
    }
    
    public byte[] getTransactionId() {
        return transactionId;
    }
}
