package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;


/**
 * 
 * @author lukew
 */
public class ASPIdentifier implements Parameter {
    private final int id;
    
    public ASPIdentifier(int id) {
        this.id = id;
    }

    @Override
    public int getTag() {
        return 0x11;
    }
    
    @Override
    public int getLength() {
        return 4;
    }

    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeInt(id);
    }

}
