package uk.me.lwood.sigtran.common.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public class DiagnosticInformation implements Parameter {
    private final ByteBuf info;
    
    public DiagnosticInformation(ByteBuf info) {
        this.info = info;
    }

    @Override
    public int getTag() {
        return 0x7;
    }
    
    @Override
    public int getLength() {
        return info.readableBytes();
    }

    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeBytes(info);
    }

}
