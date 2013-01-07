package uk.me.lwood.sigtran.m3ua.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public class ByteBufParameter extends M3uaParameter {
    private final ByteBuf data;
    
    public ByteBufParameter(M3uaTag tag, ByteBuf data) {
        super(tag);
        
        this.data = data;
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
