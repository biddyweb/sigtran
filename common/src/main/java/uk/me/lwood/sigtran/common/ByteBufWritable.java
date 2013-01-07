package uk.me.lwood.sigtran.common;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public interface ByteBufWritable {
    public void writeTo(ByteBuf buf);
}
