package uk.me.lwood.sigtran.tcap.problems;

import uk.me.lwood.sigtran.tcap.TcapProblem;

/**
 * 
 * @author lukew
 */
public enum ReturnErrorProblem implements TcapProblem {
    UNRECOGNIZED_INVOKE_ID,
    RETURN_ERROR_UNEXPECTED,
    UNRECOGNIZED_ERROR,
    UNEXPECTED_ERROR,
    MISTYPED_PARAMETER
}
