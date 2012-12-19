package uk.me.lwood.sigtran.common.params.impl;

import uk.me.lwood.sigtran.common.params.IntegerParameter;


/**
 * 
 * @author lukew
 */
public class RoutingContext extends IntegerParameter {
    
    public RoutingContext(int context) {
        super(context);
    }

    @Override
    public int getTag() {
        return 0x6;
    }
}
