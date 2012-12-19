package uk.me.lwood.sigtran.common.params.impl;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

import uk.me.lwood.sigtran.common.params.Parameter;

/**
 * 
 * @author lukew
 */
public class Info implements Parameter {
    private final String str;
    
    public Info(String str) {
        this.str = str;
    }

    @Override
    public int getTag() {
        return 0x4;
    }
    
    @Override
    public int getLength() {
        return str.getBytes(Charset.forName("UTF-8")).length;
    }

    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeBytes(str.getBytes(Charset.forName("UTF-8")));
    }
}
