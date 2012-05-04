package uk.me.lwood.sigtran.common.parameters;

import java.nio.charset.Charset;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;

/**
 * 
 * @author lukew
 */
public class Info implements CommonParameter {
    private final String str;
    
    public Info(String str) {
        this.str = str;
    }

    @Override
    public int getTag() {
        return 0x4;
    }

    @Override
    public ChannelBuffer asChannelBuffer() {
        return ChannelBuffers.wrappedBuffer(str.getBytes(Charset.forName("UTF-8")));
    }
}
