package uk.me.lwood.sigtran.tcap.ros;

import uk.me.lwood.asn1.Choice;

/**
 * 
 * @author lukew
 */
public class Component implements Choice {
    private final Invoke invoke;
    private final ReturnResult returnResultLast;
    private final ReturnError returnError;
    private final Reject reject;
    private final ReturnResult returnResultNotLast;
    
    private Component(Invoke invoke, ReturnResult returnResultLast, ReturnError returnError, Reject reject, ReturnResult returnResultNotLast) {
        this.invoke = invoke;
        this.returnResultLast = returnResultLast;
        this.returnError = returnError;
        this.reject = reject;
        this.returnResultNotLast = returnResultNotLast;
    }
    
    @Override
    public Object getChoice() {
        if (invoke != null)
            return invoke;
        
        if (returnResultLast != null)
            return returnResultLast;
        
        if (returnError != null)
            return returnError;
        
        if (reject != null)
            return reject;
        
        return returnResultNotLast;
    }
}
