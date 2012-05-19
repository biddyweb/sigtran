package uk.me.lwood.sigtran.m3ua.codec;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.oneone.OneToOneEncoder;

import java.util.Map;
import java.util.SortedMap;

import uk.me.lwood.sigtran.m3ua.M3uaMessage;

/**
 * Assuming an {@link M3uaMessage} as input, this encoder will convert the object into a
 * {@link ChannelBuffer} containing the byte-serialized form of the PDU.
 * 
 * @author lukew
 */
public class M3uaMessageEncoder extends OneToOneEncoder {
    @Override
    public Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        if (!(msg instanceof M3uaMessage))
            return msg;
        
        M3uaMessage m = (M3uaMessage) msg;
        ChannelBuffer header = ChannelBuffers.buffer(8); // , channel.getConfig().getBufferFactory()
        encodeHeader(header, m);

        SortedMap<Integer, ChannelBuffer> content = m.getContent();
        if (content.isEmpty()) {
            return header;
        }
        
        ChannelBuffer body = ChannelBuffers.dynamicBuffer(m.getLength());
        encodeBody(body, content);
        return ChannelBuffers.wrappedBuffer(header, body);
    }

    /**
     * Transcode the header information from the {@link M3uaMessage} to the {@link ChannelBuffer}.
     */
    private void encodeHeader(ChannelBuffer buf, M3uaMessage message) {
        buf.writeByte(message.getVersion());
        buf.writeByte(0);
        buf.writeByte(message.getMessageClass().getId());
        buf.writeByte(message.getMessageType().getId());
        buf.writeInt(message.getLength());
    }
    
    /**
     * Transcode the body information from the {@link M3uaMessage} to the {@link ChannelBuffer}.
     */
    private void encodeBody(ChannelBuffer buf, SortedMap<Integer, ChannelBuffer> content) {
        for (Map.Entry<Integer, ChannelBuffer> entry : content.entrySet()) {
            buf.writeShort(entry.getKey());
            int actualLength = entry.getValue().readableBytes();
            int octetLength = actualLength;
            if (actualLength % 4 != 0) {
                octetLength += 4 - actualLength % 4; 
            }
            buf.writeShort(actualLength + 4);
            buf.writeBytes(entry.getValue());
            if (octetLength != actualLength) {
                buf.writeBytes(new byte[octetLength - actualLength]);
            }
        }
    }
}
