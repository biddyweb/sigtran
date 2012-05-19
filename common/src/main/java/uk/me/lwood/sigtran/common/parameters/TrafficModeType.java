package uk.me.lwood.sigtran.common.parameters;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;

/**
 * 
 * @author lukew
 */
public class TrafficModeType implements CommonParameter {
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
    public ChannelBuffer asChannelBuffer() {
        return ChannelBuffers.wrapInt(type);
    }

}
