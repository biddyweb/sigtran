package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public class TrafficModeType implements Parameter {
    public static final int OVERRIDE = 1;
    public static final int LOADSHARE = 1;
    public static final int BROADCAST = 1;
    
    private final int type;
    
    public TrafficModeType(int type) {
        this.type = type;
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
        buf.writeInt(type);
    }

}
