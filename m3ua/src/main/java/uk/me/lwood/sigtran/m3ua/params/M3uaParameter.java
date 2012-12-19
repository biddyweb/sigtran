package uk.me.lwood.sigtran.m3ua.params;

import uk.me.lwood.sigtran.common.params.Parameter;

/**
 * 
 * @author lukew
 */
public abstract class M3uaParameter implements Parameter {
    private final M3uaTag tag;
    
    protected M3uaParameter(M3uaTag tag) {
        this.tag = tag;
    }
    
    @Override
    public final int getTag() {
        return tag.getId();
    }
}
