package uk.me.lwood.sigtran.tcap.ros;

import uk.me.lwood.asn1.annotations.Optional;
import uk.me.lwood.sigtran.tcap.TcapArgument;

/**
 * 
 * @author lukew
 */
public class Invoke {
    private final InvokeId invokeId;
    @Optional
    private final InvokeId linkedId;
    @Optional
    private final TcapArgument argument;
    
    public Invoke(InvokeId invokeId, InvokeId linkedId, TcapArgument operation) {
        this.invokeId = invokeId;
        this.linkedId = linkedId;
        this.argument = operation;
    }

    public final InvokeId getInvokeId() {
        return invokeId;
    }

    public final InvokeId getLinkedId() {
        return linkedId;
    }

    public final TcapArgument getArgument() {
        return argument;
    }
}
