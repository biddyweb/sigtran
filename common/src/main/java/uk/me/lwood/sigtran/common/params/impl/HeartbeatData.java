package uk.me.lwood.sigtran.common.params.impl;

import io.netty.buffer.ByteBuf;
import uk.me.lwood.sigtran.common.params.ByteBufParameter;

/**
 * 
 * @author lukew
 */
public class HeartbeatData extends ByteBufParameter {
    
    public HeartbeatData(ByteBuf data) {
        super(data);
    }

    @Override
    public int getTag() {
        return 0x9;
    }
}
