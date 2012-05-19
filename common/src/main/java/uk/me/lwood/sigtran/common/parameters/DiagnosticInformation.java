package uk.me.lwood.sigtran.common.parameters;

import io.netty.buffer.ChannelBuffer;

/**
 * 
 * @author lukew
 */
public class DiagnosticInformation implements CommonParameter {
    private final ChannelBuffer info;
    
    public DiagnosticInformation(ChannelBuffer info) {
        this.info = info;
    }

    @Override
    public int getTag() {
        return 0x7;
    }

    @Override
    public ChannelBuffer asChannelBuffer() {
        return info;
    }

}
