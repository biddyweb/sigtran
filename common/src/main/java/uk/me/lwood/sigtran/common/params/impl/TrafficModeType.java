package uk.me.lwood.sigtran.common.params.impl;

import uk.me.lwood.sigtran.common.params.IntegerParameter;

/**
 * 
 * @author lukew
 */
public class TrafficModeType extends IntegerParameter {
    public static final int OVERRIDE = 1;
    public static final int LOADSHARE = 1;
    public static final int BROADCAST = 1;
    
    public TrafficModeType(int type) {
        super(type);
    }

    @Override
    public int getTag() {
        return 0xB;
    }
}
