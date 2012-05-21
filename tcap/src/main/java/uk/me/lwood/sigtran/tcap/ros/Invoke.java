package uk.me.lwood.sigtran.tcap.ros;

import uk.me.lwood.sigtran.tcap.TcapOperation;

/**
 * 
 * @author lukew
 */
public class Invoke {
    private final InvokeId invokeId;
    private final InvokeId linkedId;
    private final TcapOperation operation;
    
    public Invoke(InvokeId invokeId, InvokeId linkedId, TcapOperation operation) {
        this.invokeId = invokeId;
        this.linkedId = linkedId;
        this.operation = operation;
    }

    public final InvokeId getInvokeId() {
        return invokeId;
    }

    public final InvokeId getLinkedId() {
        return linkedId;
    }

    public final TcapOperation getOperation() {
        return operation;
    }
}
