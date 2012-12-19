package uk.me.lwood.sigtran.m3ua.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SctpMessage;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.Map;
import java.util.SortedMap;

import uk.me.lwood.sigtran.m3ua.M3uaMessage;

/**
 * Assuming an {@link M3uaMessage} as input, this encoder will convert the object into a
 * {@link ChannelBuffer} containing the byte-serialized form of the PDU.
 * 
 * @author lukew
 */
public class M3uaMessageEncoder extends MessageToMessageEncoder<M3uaMessage, SctpMessage> {

    /**
     * Transcode the header information from the {@link M3uaMessage} to the {@link ChannelBuffer}.
     */
    private void encodeHeader(ByteBuf buf, M3uaMessage message) {
        buf.writeByte(message.getVersion());
        buf.writeByte(0);
        buf.writeByte(message.getMessageClass().getId());
        buf.writeByte(message.getMessageType().getId());
        buf.writeInt(message.getLength());
    }
    
    /**
     * Transcode the body information from the {@link M3uaMessage} to the {@link ChannelBuffer}.
     */
    private void encodeBody(ByteBuf buf, SortedMap<Integer, ByteBuf> content) {
        for (Map.Entry<Integer, ByteBuf> entry : content.entrySet()) {
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

    @Override
    public SctpMessage encode(ChannelHandlerContext ctx, M3uaMessage msg) throws Exception {
        ByteBuf header = ctx.alloc().buffer(8 + msg.getLength());
        encodeHeader(header, msg);

        SortedMap<Integer, ByteBuf> content = msg.getContent();
        if (content.isEmpty()) {
            return new SctpMessage(0, 0, header);
        }
        
        encodeBody(header, content);
        
        return new SctpMessage(0, 0, header);
    }
}
