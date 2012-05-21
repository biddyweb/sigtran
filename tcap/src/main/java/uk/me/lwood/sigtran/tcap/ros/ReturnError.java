package uk.me.lwood.sigtran.tcap.ros;

import uk.me.lwood.sigtran.tcap.TcapError;

/**
 * 
 * @author lukew
 */
public class ReturnError {
    private final InvokeId invokeId;
    private final TcapError errorCode;
    
    private ReturnError(InvokeId invokeId, TcapError errorCode) {
        this.invokeId = invokeId;
        this.errorCode = errorCode;
    }

    public final InvokeId getInvokeId() {
        return invokeId;
    }

    public final TcapError getErrorCode() {
        return errorCode;
    }
}
