package uk.me.lwood.sigtran.map.service.location;

import uk.me.lwood.sigtran.map.common.Identity;

/**
 * 
 * @author lukew
 */
public class CancelLocationRequest {
    private final Identity identity;
    private final CancellationType type;
    
    public CancelLocationRequest(Identity identity, CancellationType type) {
        this.identity = identity;
        this.type = type;
    }

    public final Identity getIdentity() {
        return identity;
    }

    public final CancellationType getType() {
        return type;
    }
}
