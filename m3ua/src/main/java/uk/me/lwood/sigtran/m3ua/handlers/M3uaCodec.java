package uk.me.lwood.sigtran.m3ua.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SctpMessage;
import io.netty.handler.codec.MessageToMessageCodec;
import uk.me.lwood.sigtran.m3ua.M3uaMessage;
import uk.me.lwood.sigtran.m3ua.handlers.codec.M3uaMessageDecoder;
import uk.me.lwood.sigtran.m3ua.handlers.codec.M3uaMessageEncoder;

/**
 * A trivial wrapper around {@link M3uaMessageEncoder} and {@link M3uaMessageDecoder} for
 * convenience when constructing a new pipeline.
 * 
 * @author lukew
 */
public class M3uaCodec extends MessageToMessageCodec<SctpMessage, M3uaMessage, M3uaMessage, SctpMessage> {
    private final M3uaMessageEncoder encoder = new M3uaMessageEncoder();
    private final M3uaMessageDecoder decoder = new M3uaMessageDecoder();

    @Override
    public SctpMessage encode(ChannelHandlerContext ctx, M3uaMessage msg) throws Exception {
        return encoder.encode(ctx, msg);
    }

    @Override
    public M3uaMessage decode(ChannelHandlerContext ctx, SctpMessage msg) throws Exception {
        return decoder.decode(ctx, msg);
    }
}
