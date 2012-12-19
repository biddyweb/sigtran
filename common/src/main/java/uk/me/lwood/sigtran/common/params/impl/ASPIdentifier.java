package uk.me.lwood.sigtran.common.params.impl;

import uk.me.lwood.sigtran.common.params.IntegerParameter;


/**
 * 
 * @author lukew
 */
public class ASPIdentifier extends IntegerParameter {
    
    public ASPIdentifier(int id) {
        super(id);
    }

    @Override
    public int getTag() {
        return 0x11;
    }
}
