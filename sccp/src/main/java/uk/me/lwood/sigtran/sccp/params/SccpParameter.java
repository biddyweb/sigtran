package uk.me.lwood.sigtran.sccp.params;

import uk.me.lwood.sigtran.common.ByteBufWritable;

public abstract class SccpParameter implements ByteBufWritable {
    private final SccpTag tag;
    
    public SccpParameter(SccpTag tag) {
        this.tag = tag;
    }
    
    public SccpTag getTag() {
        return tag;
    }
}
