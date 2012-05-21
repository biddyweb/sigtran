package uk.me.lwood.sigtran.map.sms;

/**
 * 
 * @author lukew
 */
public class SmRpSmea {
    private final byte[] address;
    
    public SmRpSmea(byte[] address) {
        this.address = address;
    }
    
    public byte[] getAddress() {
        return address;
    }
}
