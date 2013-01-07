package uk.me.lwood.sigtran.m3ua.handlers.codec;

import static uk.me.lwood.sigtran.m3ua.exceptions.M3uaExceptionReason.*;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SctpMessage;
import io.netty.handler.codec.MessageToMessageDecoder;
import uk.me.lwood.sigtran.m3ua.M3uaMessage;
import uk.me.lwood.sigtran.m3ua.M3uaMessageClass;
import uk.me.lwood.sigtran.m3ua.M3uaMessageType;
import uk.me.lwood.sigtran.m3ua.exceptions.M3uaException;
import uk.me.lwood.sigtran.m3ua.params.DefaultM3uaTag;
import uk.me.lwood.sigtran.m3ua.params.M3uaTag;
import uk.me.lwood.sigtran.m3ua.params.UnspecifiedM3uaTag;

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
public class M3uaMessageDecoder extends MessageToMessageDecoder<SctpMessage, M3uaMessage> {

    @Override
    public M3uaMessage decode(ChannelHandlerContext ctx, SctpMessage msg) throws Exception {
        ByteBuf payload = msg.getPayloadBuffer();
        
        int version = payload.readByte();
        if (version != 0x1) {
            throw new M3uaException(UNSUPPORTED_VERSION, "Unsupported version: " + version);
        }

        payload.skipBytes(1);
        M3uaMessageClass messageClass = M3uaMessageClass.getById(payload.readByte());
        M3uaMessageType messageType = M3uaMessageType.getByMessageClassAndId(messageClass, payload.readByte());

        M3uaMessage m3uaMsg = new M3uaMessage(version, messageClass, messageType);

        int length = payload.readInt() - 4;
        int offset = 0;
        while (offset < length) {
            if (offset + length < 4)
                throw new M3uaException(UNEXPECTED_TRAILING_BYTES, "Got unexpected trailing " + (length - offset) + " bytes");
            
            final short parameterTag = payload.readShort();
            final int parameterLength = payload.readShort() - 4;
            if (offset + parameterLength > length)
                throw new M3uaException(INVALID_LENGTH_FIELD, "Got invalid length field in tag: " + parameterTag);
            
            M3uaTag tag = DefaultM3uaTag.getById(parameterTag);
            if (tag == null) {
                tag = new UnspecifiedM3uaTag(parameterTag);
            }
            m3uaMsg.addParameter(tag.getFactory().get(tag, payload, parameterLength));
            
            if (parameterLength % 4 != 0)
                payload.skipBytes(4 - (parameterLength % 4));
            
            offset += 4 + parameterLength + (4 - (parameterLength % 4));
        }

        return m3uaMsg;
    }

}
