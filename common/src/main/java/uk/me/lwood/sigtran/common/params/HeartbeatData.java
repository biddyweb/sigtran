package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public class HeartbeatData implements Parameter {
    private final ByteBuf data;
    
    public HeartbeatData(ByteBuf data) {
        this.data = data;
    }

    @Override
    public int getTag() {
        return 0x9;
    }
    
    @Override
    public int getLength() {
        return data.readableBytes();
    }

    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeBytes(data);
    }

}
