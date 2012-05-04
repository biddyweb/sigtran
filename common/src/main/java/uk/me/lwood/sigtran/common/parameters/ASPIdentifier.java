package uk.me.lwood.sigtran.common.parameters;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;

/**
 * 
 * @author lukew
 */
public class ASPIdentifier implements CommonParameter {
    private final int id;
    
    public ASPIdentifier(int id) {
        this.id = id;
    }

    @Override
    public int getTag() {
        return 0x11;
    }

    @Override
    public ChannelBuffer asChannelBuffer() {
        return ChannelBuffers.wrapInt(id);
    }

}
