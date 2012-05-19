package uk.me.lwood.sigtran.map.common;

/**
 * 
 * @author lukew
 */
public class AddressString {
    private final NatureOfAddress noa;
    private final NumberingPlanIndicator npi;
    private final String address;
    
    public AddressString(NatureOfAddress noa, NumberingPlanIndicator npi, String address) {
        if (address == null)
            throw new NullPointerException("address cannot be null");
        
        if (address.length() < 1 || address.length() > 20)
            throw new IllegalArgumentException("address must be 1 .. 20 digits in length");
        
        this.noa = noa;
        this.npi = npi;
        this.address = address;
    }
    
    public NatureOfAddress getNatureOfAddress() {
        return noa;
    }
    
    public NumberingPlanIndicator getNumberingPlanIndicator() {
        return npi;
    }
    
    public String getAddress() {
        return address;
    }
    
    public static enum NatureOfAddress {
        UNKNOWN(0),
        INTERNATIONAL(1),
        NATIONAL(2),
        NETWORK_SPECIFIC(3),
        SUBSCRIBER(4),
        ABBREVIATED(5);
        
        private final byte bitValue;
        
        private NatureOfAddress(int value) {
            bitValue = (byte)value;
        }
        
        public byte getBitValue() {
            return bitValue;
        }
    }
    
    public static enum NumberingPlanIndicator {
        UNKNOWN(0),
        ISDN(1),
        DATA_NUMBERING_PLAN(3),
        TELEX_NUMBERING_PLAN(4),
        LAND_MOBILE(6),
        NATIONAL(8),
        PRIVATE(9);
        
        private final byte bitValue;
        
        private NumberingPlanIndicator(int value) {
            bitValue = (byte)value;
        }
        
        public byte getBitValue() {
            return bitValue;
        }
    }
}
