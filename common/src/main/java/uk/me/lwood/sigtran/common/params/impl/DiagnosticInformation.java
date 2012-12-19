package uk.me.lwood.sigtran.common.params.impl;

import io.netty.buffer.ByteBuf;
import uk.me.lwood.sigtran.common.params.ByteBufParameter;

/**
 * 
 * @author lukew
 */
public class DiagnosticInformation extends ByteBufParameter {
    
    public DiagnosticInformation(ByteBuf info) {
        super(info);
    }

    @Override
    public int getTag() {
        return 0x7;
    }
}
