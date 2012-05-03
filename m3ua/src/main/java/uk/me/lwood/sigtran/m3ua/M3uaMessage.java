package uk.me.lwood.sigtran.m3ua;

import io.netty.buffer.ChannelBuffer;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 
 * @author lukew
 */
public class M3uaMessage {
    private final int version;
    private final M3uaMessageClass messageClass;
    private final M3uaMessageType messageType;
    private final SortedMap<Integer, ChannelBuffer> content = new TreeMap<Integer, ChannelBuffer>();

    public M3uaMessage(int version, M3uaMessageClass messageClass, M3uaMessageType messageType) {
        this.version = version;
        this.messageClass = messageClass;
        this.messageType = messageType;
    }

    public int getVersion() {
        return version;
    }

    public M3uaMessageClass getMessageClass() {
        return messageClass;
    }

    public M3uaMessageType getMessageType() {
        return messageType;
    }

    public int getLength() {
        int length = 0;
        for (Map.Entry<Integer, ChannelBuffer> entry : content.entrySet()) {
            int oneLength = entry.getValue().readableBytes();
            length += oneLength;
            if (oneLength % 4 != 0) {
                length += 4 - oneLength % 4;
            }
        }

        return length;
    }

    public SortedMap<Integer, ChannelBuffer> getContent() {
        return content;
    }

    public void putTagValue(int tag, ChannelBuffer value) {
        content.put(tag, value);
    }

    public void putContent(SortedMap<Integer, ChannelBuffer> content) {
        this.content.putAll(content);
    }

    public void removeTag(int tag) {
        content.remove(tag);
    }
}
