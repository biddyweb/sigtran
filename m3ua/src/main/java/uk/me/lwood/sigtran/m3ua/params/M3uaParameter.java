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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tag == null) ? 0 : tag.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        M3uaParameter other = (M3uaParameter)obj;
        if (tag != other.tag) {
            return false;
        }
        return true;
    }
}
