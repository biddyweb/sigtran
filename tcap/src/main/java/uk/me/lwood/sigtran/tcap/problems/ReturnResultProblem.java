package uk.me.lwood.sigtran.tcap.problems;

import uk.me.lwood.sigtran.tcap.TcapProblem;

/**
 * 
 * @author lukew
 */
public enum ReturnResultProblem implements TcapProblem {
    UNRECOGNIZED_INVOKE_ID,
    RETURN_RESULT_UNEXPECTED,
    MISTYPED_PARAMETER
}
