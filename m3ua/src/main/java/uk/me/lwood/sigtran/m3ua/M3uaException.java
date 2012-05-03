package uk.me.lwood.sigtran.m3ua;

/**
 * An exception specific to the M3UA layer of the stack; exceptions of this type thrown should be
 * considered fatal for the purposes of ongoing communication.
 * 
 * @author lukew
 */
public final class M3uaException extends Exception {
    private static final long serialVersionUID = 1L;

    public M3uaException(String message) {
        super(message);
    }
}
