package uk.me.lwood.sigtran.m3ua.params;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author lukew
 */
public enum DefaultM3uaTag implements M3uaTag {
    INFO_STRING(0x0004, M3uaParameterFactory.BYTEBUF), // XXX: UTF-8 String
    ROUTING_CONTEXT(0x0006, M3uaParameterFactory.INTEGER), // XXX: Complex type
    DIAGNOSTIC_INFORMATION(0x0007, M3uaParameterFactory.BYTEBUF),
    HEARTBEAT_DATA(0x0009, M3uaParameterFactory.BYTEBUF),
    TRAFFIC_MODE_TYPE(0x000B, M3uaParameterFactory.INTEGER),
    ERROR_CODE(0x000C, M3uaParameterFactory.INTEGER),
    STATUS(0x000D, M3uaParameterFactory.INTEGER),
    ASP_IDENTIFIER(0x0011, M3uaParameterFactory.INTEGER),
    
    
    NETWORK_APPEARANCE(0x0200, M3uaParameterFactory.INTEGER),
    USER_CAUSE(0x0204, M3uaParameterFactory.INTEGER),
    CONGESTION_INDICATIONS(0x0205, M3uaParameterFactory.INTEGER),
    CONCERNED_DESTINATION(0x0206, M3uaParameterFactory.INTEGER),
    ROUTING_KEY(0x0207, M3uaParameterFactory.INTEGER),
    REGISTRATION_RESULT(0x0208, M3uaParameterFactory.INTEGER),
    DEREGISTRATION_RESULT(0x0209, M3uaParameterFactory.INTEGER),
    LOCAL_ROUTING_KEY_ID(0x020A, M3uaParameterFactory.INTEGER),
    DESTINATION_POINT_CODE(0x020B, M3uaParameterFactory.INTEGER),
    SERVICE_INDICATORS(0x020C, M3uaParameterFactory.INTEGER),
    ORIGINATING_POINT_CODE_LIST(0x020E, M3uaParameterFactory.INTEGER),
    PROTOCOL_DATA(0x0210, M3uaParameterFactory.INTEGER), // XXX: Complex type
    REGISTRATION_STATUS(0x0212, M3uaParameterFactory.INTEGER),
    DEREGISTRATION_STATUS(0x0213, M3uaParameterFactory.INTEGER);
    
    private final short id;
    private final M3uaParameterFactory factory;
    
    private DefaultM3uaTag(int id, M3uaParameterFactory factory) {
        this.id = (short) id;
        this.factory = factory;
    }
    
    @Override
    public short getId() {
        return id;
    }
    
    @Override
    public M3uaParameterFactory getFactory() {
        return factory;
    }
    
    private static final Map<Short, DefaultM3uaTag> TAGS = new HashMap<Short, DefaultM3uaTag>();
    static {
        for (DefaultM3uaTag tag : DefaultM3uaTag.values()) {
            TAGS.put(tag.getId(), tag);
        }
    }
    
    public static M3uaTag getById(short id) {
        return TAGS.get(id);
    }
}
