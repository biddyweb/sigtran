package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public abstract class ByteBufParameter implements Parameter {
    private final ByteBuf value;
    
    protected ByteBufParameter(ByteBuf value) {
        this.value = value;
    }

    @Override
    public final int getLength() {
        return value.readableBytes();
    }

    @Override
    public final void writeTo(ByteBuf buf) {
        buf.writeBytes(value);
    }

}
