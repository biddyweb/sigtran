package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public class RoutingContext implements Parameter {
    private final int context;
    
    public RoutingContext(int context) {
        this.context = context;
    }

    @Override
    public int getTag() {
        return 0x6;
    }
    
    @Override
    public int getLength() {
        return 4;
    }

    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeInt(context);
    }

}
