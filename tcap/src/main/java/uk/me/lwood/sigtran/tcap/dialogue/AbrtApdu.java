package uk.me.lwood.sigtran.tcap.dialogue;

/**
 * 
 * @author lukew
 */
public class AbrtApdu {
    private final AbrtSource abortSource;
    
    public AbrtApdu(AbrtSource abortSource) {
        this.abortSource = abortSource;
    }
    
    public AbrtSource getAbortSource() {
        return abortSource;
    }
}
