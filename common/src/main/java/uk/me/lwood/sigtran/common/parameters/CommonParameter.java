package uk.me.lwood.sigtran.common.parameters;

import io.netty.buffer.ChannelBuffer;

/**
 * 
 * @author lukew
 */
public interface CommonParameter {
    public int getTag();
    public ChannelBuffer asChannelBuffer();
}
