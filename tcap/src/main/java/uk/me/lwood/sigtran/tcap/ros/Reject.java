package uk.me.lwood.sigtran.tcap.ros;

import uk.me.lwood.sigtran.tcap.TcapProblem;

/**
 * 
 * @author lukew
 */
public class Reject {
    private final InvokeId invokeId;
    private final TcapProblem problem;
    
    private Reject(InvokeId invokeId, TcapProblem problem) {
        this.invokeId = invokeId;
        this.problem = problem;
    }

    public final InvokeId getInvokeId() {
        return invokeId;
    }

    public final TcapProblem getProblem() {
        return problem;
    }
}
