package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public class ErrorCode implements Parameter {
    public static final int INVALID_VERSION = 0x01;
    public static final int UNSUPPORTED_MESSAGE_CLASS = 0x03;
    public static final int UNSUPPORTED_MESSAGE_TYPE = 0x04;
    public static final int UNSUPPORTED_TRAFFIC_MODE_TYPE = 0x05;
    public static final int UNEXPECTED_MESSAGE = 0x06;
    public static final int PROTOCOL_ERROR = 0x07;
    public static final int INVALID_STREAM_ID = 0x09;
    public static final int REFUSED_MGMT_BLOCKING = 0x0d;
    public static final int ASP_ID_REQUIRED = 0x0e;
    public static final int INVALID_ASP_ID = 0x0f;
    public static final int INVALID_PARAMETER_VALUE = 0x11;
    public static final int PARAMETER_FIELD_ERROR = 0x12;
    public static final int UNEXPECTED_PARAMETER = 0x13;
    public static final int DESTINATION_STATUS_UNKNOWN = 0x14;
    public static final int INVALID_NETWORK_APPEARANCE = 0x15;
    public static final int MISSING_PARAMETER = 0x16;
    public static final int INVALID_ROUTING_CONTEXT = 0x19;
    public static final int NO_CONFIGURED_AS_FOR_ASP = 0x1a;
    
    private final int code;
    
    public ErrorCode(int code) {
        this.code = code;
    }

    @Override
    public int getTag() {
        return 0xB;
    }
    
    @Override
    public int getLength() {
        return 4;
    }

    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeInt(code);
    }

}
