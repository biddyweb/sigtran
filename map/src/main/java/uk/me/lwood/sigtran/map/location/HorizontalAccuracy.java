// $Id$
// Copyright 2012 MX Telecom Ltd
package uk.me.lwood.sigtran.map.location;

/**
 * 
 * @author lukew
 */
public class HorizontalAccuracy {
    public static final HorizontalAccuracy NONE = new HorizontalAccuracy(0);
    
    private final byte[] value;
    
    private HorizontalAccuracy(int value) {
        this.value = new byte[] { (byte) value };
    }
    
    public byte[] getValue() {
        return value;
    }
}
