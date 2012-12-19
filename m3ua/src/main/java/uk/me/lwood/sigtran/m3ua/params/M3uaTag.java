package uk.me.lwood.sigtran.m3ua.params;

/**
 * 
 * @author lukew
 */
public enum M3uaTag {
    NETWORK_APPEARANCE(0x0200),
    USER_CAUSE(0x0204),
    CONGESTION_INDICATIONS(0x0205),
    CONCERNED_DESTINATION(0x0206),
    ROUTING_KEY(0x0207),
    REGISTRATION_RESULT(0x0208),
    DEREGISTRATION_RESULT(0x0209),
    LOCAL_ROUTING_KEY_ID(0x020A),
    DESTINATION_POINT_CODE(0x020B),
    SERVICE_INDICATORS(0x020C),
    ORIGINATING_POINT_CODE_LIST(0x020E),
    PROTOCOL_DATA(0x0210),
    REGISTRATION_STATUS(0x0212),
    DEREGISTRATION_STATUS(0x0213);
    
    private final short id;
    
    private M3uaTag(int id) {
        this.id = (short) id;
    }
    
    public short getId() {
        return id;
    }
}
