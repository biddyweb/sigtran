package uk.me.lwood.sigtran.m3ua.codec;

import static org.junit.Assert.assertArrayEquals;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import org.junit.Test;

import uk.me.lwood.sigtran.m3ua.M3uaMessage;
import uk.me.lwood.sigtran.m3ua.M3uaMessageClass;
import uk.me.lwood.sigtran.m3ua.M3uaMessageType;

/**
 * 
 * @author lukew
 */
public class M3uaMessageEncoderTest {
    private final M3uaMessageEncoder encoder = new M3uaMessageEncoder();

    @Test
    public void encodeValidTransfer() throws Exception {
        M3uaMessage msg = new M3uaMessage(1, M3uaMessageClass.Transfer, M3uaMessageType.DATA);
        short[] networkAppearance = {
            0x00, 0x00, 0x00, 0x02,
        };
        ByteBuf buf = Unpooled.buffer(networkAppearance.length);
        for (short s : networkAppearance) {
            buf.writeByte(s);
        }
        msg.putTagValue(512, buf);
        
        short[] payload = {
            0x00, 0x00, 0x04, 0xa8, 0x00, 0x00, 0x02, 0x82, 0x03, 0x02, 0x00, 0x06,
            0x09, 0x80, 0x03, 0x0e, 0x19, 0x0b, 0x12, 0x08, 0x00, 0x12, 0x04, 0x79, 0x51, 0x55, 0x15, 0x55,
            0x81, 0x0b, 0x12, 0x08, 0x00, 0x12, 0x04, 0x44, 0x77, 0x79, 0x07, 0x26, 0x44, 0x9f, 0x62, 0x81,
            0x9c, 0x48, 0x04, 0x0f, 0x00, 0xa6, 0xf2, 0x6c, 0x81, 0x93, 0xa1, 0x81, 0x90, 0x02, 0x01, 0x01,
            0x02, 0x01, 0x2e, 0x30, 0x81, 0x87, 0x80, 0x08, 0x24, 0x04, 0x03, 0x00, 0x83, 0x87, 0x38, 0xf9,
            0x84, 0x07, 0x91, 0x44, 0x77, 0x79, 0x07, 0x26, 0x44, 0x04, 0x72, 0x64, 0x0c, 0x91, 0x44, 0x77,
            0x68, 0x02, 0x05, 0x49, 0x00, 0x11, 0x21, 0x50, 0x90, 0x71, 0x54, 0x74, 0x40, 0x6c, 0x06, 0x05,
            0x04, 0x15, 0x79, 0x00, 0x00, 0xd2, 0xe2, 0xb1, 0x25, 0x2d, 0x4e, 0xa1, 0x3f, 0x7b, 0x6f, 0xb6,
            0x93, 0xf7, 0x62, 0x63, 0x98, 0x0c, 0x47, 0x9e, 0xe1, 0x76, 0xee, 0xde, 0x2a, 0x77, 0x8b, 0xd5,
            0x6a, 0xb6, 0x9c, 0xed, 0x96, 0xcb, 0xe5, 0x76, 0xf3, 0x1e, 0x4c, 0x46, 0x33, 0x06, 0x83, 0x39,
            0xe3, 0x2c, 0x68, 0x34, 0x1a, 0x8d, 0x46, 0xa3, 0xd1, 0x38, 0xb4, 0x0d, 0x83, 0x33, 0xe3, 0x30,
            0x17, 0xab, 0x05, 0x85, 0x31, 0x62, 0x2c, 0x96, 0x83, 0x15, 0x67, 0xc5, 0x9b, 0x70, 0x96, 0x93,
            0xc1, 0x6a, 0xb7, 0x9a, 0x31, 0x58, 0x0b, 0xd2, 0x72, 0x45, 0x5c, 0x2e, 0x08
        };
        buf = Unpooled.buffer(payload.length);
        for (short s : payload) {
            buf.writeByte(s);
        }
        msg.putTagValue(528, buf);
        
        short[] expected = {
            0x01, 0x00, 0x01, 0x01, 0x00, 0x00, 0x00, 0xe0, 0x02, 0x00, 0x00, 0x08, 0x00, 0x00, 0x00, 0x02,
            0x02, 0x10, 0x00, 0xcd, 0x00, 0x00, 0x04, 0xa8, 0x00, 0x00, 0x02, 0x82, 0x03, 0x02, 0x00, 0x06,
            0x09, 0x80, 0x03, 0x0e, 0x19, 0x0b, 0x12, 0x08, 0x00, 0x12, 0x04, 0x79, 0x51, 0x55, 0x15, 0x55,
            0x81, 0x0b, 0x12, 0x08, 0x00, 0x12, 0x04, 0x44, 0x77, 0x79, 0x07, 0x26, 0x44, 0x9f, 0x62, 0x81,
            0x9c, 0x48, 0x04, 0x0f, 0x00, 0xa6, 0xf2, 0x6c, 0x81, 0x93, 0xa1, 0x81, 0x90, 0x02, 0x01, 0x01,
            0x02, 0x01, 0x2e, 0x30, 0x81, 0x87, 0x80, 0x08, 0x24, 0x04, 0x03, 0x00, 0x83, 0x87, 0x38, 0xf9,
            0x84, 0x07, 0x91, 0x44, 0x77, 0x79, 0x07, 0x26, 0x44, 0x04, 0x72, 0x64, 0x0c, 0x91, 0x44, 0x77,
            0x68, 0x02, 0x05, 0x49, 0x00, 0x11, 0x21, 0x50, 0x90, 0x71, 0x54, 0x74, 0x40, 0x6c, 0x06, 0x05,
            0x04, 0x15, 0x79, 0x00, 0x00, 0xd2, 0xe2, 0xb1, 0x25, 0x2d, 0x4e, 0xa1, 0x3f, 0x7b, 0x6f, 0xb6,
            0x93, 0xf7, 0x62, 0x63, 0x98, 0x0c, 0x47, 0x9e, 0xe1, 0x76, 0xee, 0xde, 0x2a, 0x77, 0x8b, 0xd5,
            0x6a, 0xb6, 0x9c, 0xed, 0x96, 0xcb, 0xe5, 0x76, 0xf3, 0x1e, 0x4c, 0x46, 0x33, 0x06, 0x83, 0x39,
            0xe3, 0x2c, 0x68, 0x34, 0x1a, 0x8d, 0x46, 0xa3, 0xd1, 0x38, 0xb4, 0x0d, 0x83, 0x33, 0xe3, 0x30,
            0x17, 0xab, 0x05, 0x85, 0x31, 0x62, 0x2c, 0x96, 0x83, 0x15, 0x67, 0xc5, 0x9b, 0x70, 0x96, 0x93,
            0xc1, 0x6a, 0xb7, 0x9a, 0x31, 0x58, 0x0b, 0xd2, 0x72, 0x45, 0x5c, 0x2e, 0x08, 0x00, 0x00, 0x00,
        };
        buf = Unpooled.buffer(expected.length);
        for (short s : expected) {
            buf.writeByte(s);
        }
        
        ByteBuf encodedForm = encoder.encode(null, msg).getPayloadBuffer();
        byte[] actual = new byte[encodedForm.readableBytes()];
        encodedForm.readBytes(actual);
        assertArrayEquals(buf.array(), actual);
    }
}
