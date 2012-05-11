package uk.me.lwood.sigtran.m3ua.exceptions;

/**
 * An exception specific to the M3UA layer of the stack; exceptions of this type thrown should be
 * considered fatal for the purposes of ongoing communication.
 * 
 * @author lukew
 */
public final class M3uaException extends Exception {
    private static final long serialVersionUID = 1L;
    
    private final M3uaExceptionReason reason;

    public M3uaException(M3uaExceptionReason reason, String message) {
        super(message);
        
        this.reason = reason;
    }
    
    public M3uaExceptionReason getReason() {
        return reason;
    }
}
