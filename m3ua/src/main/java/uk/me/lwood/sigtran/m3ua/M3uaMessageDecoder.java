package uk.me.lwood.sigtran.m3ua;

import static uk.me.lwood.sigtran.m3ua.exceptions.M3uaExceptionReason.*;

import uk.me.lwood.sigtran.m3ua.exceptions.M3uaException;
import io.netty.buffer.ChannelBuffer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.oneone.OneToOneDecoder;

/**
 * Assuming a ChannelBuffer as input (which should be guaranteed by another decoder unwrapping the
 * M3UA payload), this will parse the bytes in the ChannelBuffer as a {@link M3uaMessage}, by
 * attempting first to read the header and then the body.
 * 
 * <p>This decoder will throw an exception for the following reasons:
 * <ul>
 *   <li>If the version field in the header is not "1"</li>
 *   <li>If there are any problems reading the variable-length parameters, including:
 *     <ul>
 *       <li>Trailing bytes at the end of the buffer that are counted in the length, but unaccounted
 *           for by any parameters</li>
 *       <li>Parameter length fields that would exceed the size of the passed ChannelBuffer</li>
 *       <li>Parameter payloads with no trailing padding, when padding is expected</li>
 *     </ul>
 *   </li>
 * </ul>
 * 
 * @author lukew
 */
public class M3uaMessageDecoder extends OneToOneDecoder {
    @Override
    public Object decode(ChannelHandlerContext ctx, Channel channel, Object msg) throws M3uaException {
        if (!(msg instanceof ChannelBuffer))
            return msg;

        ChannelBuffer m = (ChannelBuffer) msg;
        int version = m.readByte();
        if (version != 0x1) {
            throw new M3uaException(UNSUPPORTED_VERSION, "Unsupported version: " + version);
        }

        m.readByte();
        M3uaMessageClass messageClass = M3uaMessageClass.getById(m.readByte());
        M3uaMessageType messageType = M3uaMessageType.getByMessageClassAndId(messageClass, m.readByte());

        M3uaMessage m3uaMsg = new M3uaMessage(version, messageClass, messageType);

        int length = m.readInt() - 4;
        int offset = 0;
        while (offset < length) {
            if (offset + length < 4)
                throw new M3uaException(UNEXPECTED_TRAILING_BYTES, "Got unexpected trailing " + (length - offset) + " bytes");
            
            int parameterTag = m.readShort();
            int parameterLength = m.readShort();
            parameterLength -= 4;
            if (offset + parameterLength > length)
                throw new M3uaException(INVALID_LENGTH_FIELD, "Got invalid length field in tag: " + parameterTag);
            
            m3uaMsg.putTagValue(parameterTag, m.readSlice(parameterLength));
            
            if (parameterLength % 4 != 0)
                m.skipBytes(4 - (parameterLength % 4));
            
            offset += 4 + parameterLength + (4 - (parameterLength % 4));
        }

        return m3uaMsg;

    }

}
