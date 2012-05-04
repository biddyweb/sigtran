package uk.me.lwood.sigtran.common.parameters;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;

/**
 * 
 * @author lukew
 */
public class RoutingContext implements CommonParameter {
    private final int context;
    
    public RoutingContext(int context) {
        this.context = context;
    }

    @Override
    public int getTag() {
        return 0x6;
    }

    @Override
    public ChannelBuffer asChannelBuffer() {
        return ChannelBuffers.wrapInt(context);
    }

}
