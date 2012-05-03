package uk.me.lwood.sigtran.m3ua;

import io.netty.buffer.ChannelBuffer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.oneone.OneToOneDecoder;

/**
 * 
 * @author lukew
 */
public class M3uaMessageDecoder extends OneToOneDecoder {
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, Object msg) throws M3uaException {
        if (!(msg instanceof ChannelBuffer))
            return msg;   

        ChannelBuffer m = (ChannelBuffer) msg;
        int version = m.readByte();
        if (version != 0x1) {
            throw new M3uaException("Unsupported version: " + version);
        }

        m.readByte();
        M3uaMessageClass messageClass = M3uaMessageClass.getById(m.readByte());
        M3uaMessageType messageType = M3uaMessageType.getByMessageClassAndId(messageClass, m.readByte());

        M3uaMessage m3uaMsg = new M3uaMessage(version, messageClass, messageType);

        int length = m.readInt();
        int offset = 0;
        while (offset < length) {
            if (offset + length < 4)
                throw new M3uaException("Got unexpected trailing " + (length - offset) + " bytes");
            
            int parameterTag = m.readShort();
            int parameterLength = m.readShort();
            if (offset + parameterLength > length)
                throw new M3uaException("Got invalid length field in tag: " + parameterTag);
            
            m3uaMsg.putTagValue(parameterTag, m.readSlice(parameterLength));
        }

        return msg;

    }

}
