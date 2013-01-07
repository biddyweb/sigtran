package uk.me.lwood.sigtran.common;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public interface ByteBufWritable {
    public int getLength();
    public void writeTo(ByteBuf buf);
}
