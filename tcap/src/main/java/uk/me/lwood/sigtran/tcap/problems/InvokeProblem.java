package uk.me.lwood.sigtran.tcap.problems;

import uk.me.lwood.sigtran.tcap.TcapProblem;

/**
 * 
 * @author lukew
 */
public enum InvokeProblem implements TcapProblem {
    DUPLICATE_INVOKE_ID,
    UNRECOGNIZED_OPERATION,
    MISTYPED_PARAMETER,
    RESOURCE_LIMITATION,
    INITIATING_RELEASE,
    UNRECOGNIZED_LINKED_ID,
    LINKED_RESPONSE_UNEXPECTED,
    UNEXPECTED_LINKED_OPERATION
}
