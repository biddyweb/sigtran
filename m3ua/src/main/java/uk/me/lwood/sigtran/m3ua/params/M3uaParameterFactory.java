package uk.me.lwood.sigtran.m3ua.params;

import io.netty.buffer.ByteBuf;

public interface M3uaParameterFactory {
    public static final M3uaParameterFactory INTEGER = new M3uaParameterFactory() {
        @Override
        public M3uaParameter get(M3uaTag tag, ByteBuf input, int length) {
            return new IntegerM3uaParameter(tag, input.readInt());
        }
    };
    public static final M3uaParameterFactory BYTEBUF = new M3uaParameterFactory() {
        @Override
        public M3uaParameter get(M3uaTag tag, ByteBuf input, int length) {
            return new ByteBufParameter(tag, input.slice(input.readerIndex(), length));
        }
    };
    
    public M3uaParameter get(M3uaTag tag, ByteBuf input, int length);
}
