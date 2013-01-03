package uk.me.lwood.sigtran.m3ua.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public class IntegerM3uaParameter extends M3uaParameter {
    private final int value;

    public IntegerM3uaParameter(M3uaTag tag, int value) {
        super(tag);
        
        this.value = value;
    }

    @Override
    public int getLength() {
        return 4;
    }

    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeInt(value);
    }

}
