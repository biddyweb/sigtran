package uk.me.lwood.sigtran.common.parameters;

import io.netty.buffer.ChannelBuffer;

/**
 * 
 * @author lukew
 */
public class HeartbeatData implements CommonParameter {
    private final ChannelBuffer data;
    
    public HeartbeatData(ChannelBuffer data) {
        this.data = data;
    }

    @Override
    public int getTag() {
        return 0x9;
    }

    @Override
    public ChannelBuffer asChannelBuffer() {
        return data;
    }

}
