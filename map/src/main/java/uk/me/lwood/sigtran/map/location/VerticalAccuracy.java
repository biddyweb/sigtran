// $Id$
// Copyright 2012 MX Telecom Ltd
package uk.me.lwood.sigtran.map.location;

/**
 * 
 * @author lukew
 */
public class VerticalAccuracy {
    public static final VerticalAccuracy NONE = new VerticalAccuracy(0);
    
    private final byte[] value;
    
    private VerticalAccuracy(int value) {
        this.value = new byte[] { (byte) value };
    }
    
    public byte[] getValue() {
        return value;
    }
}
