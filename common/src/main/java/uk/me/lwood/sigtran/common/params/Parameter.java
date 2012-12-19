package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;

public interface Parameter {
    public int getTag();
    public int getLength();
    public void writeTo(ByteBuf buf);
}
