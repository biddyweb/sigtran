package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public abstract class IntegerParameter implements Parameter {
    private final int value;
    
    protected IntegerParameter(int value) {
        this.value = value;
    }

    @Override
    public final int getLength() {
        return 4;
    }

    @Override
    public final void writeTo(ByteBuf buf) {
        buf.writeInt(value);
    }
}
