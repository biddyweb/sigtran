package uk.me.lwood.sigtran.m3ua;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.oneone.OneToOneEncoder;

import java.util.Map;
import java.util.SortedMap;

/**
 * 
 * @author lukew
 */
public class M3uaMessageEncoder extends OneToOneEncoder {
    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        if (msg instanceof M3uaMessage) {
            M3uaMessage m = (M3uaMessage) msg;
            ChannelBuffer header = ChannelBuffers.dynamicBuffer(8, channel.getConfig().getBufferFactory());
            encodeHeader(header, m);
            
            SortedMap<Integer, ChannelBuffer> content = m.getContent();
            if (content.isEmpty()) {
                return header;
            }
            else {
                ChannelBuffer body = ChannelBuffers.dynamicBuffer(16, channel.getConfig().getBufferFactory());
                encodeBody(body, content);
                return ChannelBuffers.wrappedBuffer(header, body);
            }
        }
        
        return msg;
    }

    private void encodeHeader(ChannelBuffer buf, M3uaMessage message) {
        buf.writeByte(message.getVersion());
        buf.writeByte(0);
        buf.writeByte(message.getMessageClass().getId());
        buf.writeByte(message.getMessageType().getId());
        buf.writeInt(message.getLength());
    }
    
    private void encodeBody(ChannelBuffer buf, SortedMap<Integer, ChannelBuffer> content) {
        for (Map.Entry<Integer, ChannelBuffer> entry : content.entrySet()) {
            buf.writeShort(entry.getKey());
            int actualLength = entry.getValue().readableBytes();
            int octetLength = actualLength;
            if (actualLength % 4 != 0) {
                octetLength += 4 - actualLength % 4; 
            }
            buf.writeShort(actualLength);
            buf.writeBytes(entry.getValue());
            if (octetLength != actualLength) {
                buf.writeBytes(new byte[actualLength - octetLength]);
            }
        }
    }
}
