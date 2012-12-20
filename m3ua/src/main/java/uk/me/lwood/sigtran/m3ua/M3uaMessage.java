package uk.me.lwood.sigtran.m3ua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uk.me.lwood.sigtran.m3ua.params.M3uaParameter;

/**
 * An M3uaMessage is composed of a common fixed-length header, followed by a series of
 * variable-length parameters included based on the context (usually provided by the Message
 * Class and Type fields, and according to state held on each side of the connection).
 * 
 * The common header is composed of 5 fields
 * <pre>
 * +--------+--------+--------+--------+
 * |   V    |    R   |    C   |    T   |
 * +--------+--------+--------+--------+
 * |               Length              |
 * +-----------------------------------+
 * </pre>
 * where:
 * <ul>
 *  <li>V is <em>Version</em>, and should only ever be "1"</li>
 *  <li>R is <em>Reserved</em>, and is reserved for extension</li>
 *  <li>C is <em>Class</em>, and should be one of the instances defined in {@link M3uaMessageClass}</li>
 *  <li>T is <em>Type</em>, and should be one of the instances defined in {@link M3uaMessageType}</li>
 *  <li><em>Length</em> is the total length of the variable-length parameter section, in bytes</li>
 * </ul>
 *
 * The body, then, is composed of variable-length parameters of the form:
 * <pre>
 * +--------+--------+--------+--------+
 * |       Tag       |      Length     |
 * +--------+--------+--------+--------+
 * \\              Value               \\
 * +--------+--------+--------+--------+
 * </pre>
 * where:
 * <ul>
 *   <li><em>Tag</em> is a two byte integer indicating the parameter it specifies</li>      
 *   <li><em>Length</em> is the length of the value of the parameter, excluding padding bytes</li>
 *   <li><em>Value</em> is the raw content of that parameter</li>
 * </ul>
 * 
 * If the length of the value does not fit into a multiple of 4 octets, the value should be padded
 * at the end up to a multiple of 4 octets.  For example, if the value is 17 bytes long,
 * 3 zero-filled bytes should be appended to the end before writing out the next parameter.
 * 
 * @author lukew
 */
public final class M3uaMessage {
    private final int version;
    private final M3uaMessageClass messageClass;
    private final M3uaMessageType messageType;
    private final List<M3uaParameter> content = new ArrayList<M3uaParameter>();

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
        int length = 8;
        for (M3uaParameter param : content) {
            int paramLength = param.getLength();
            length += paramLength + 4;
            if (paramLength % 4 != 0) {
                length += 4 - paramLength % 4;
            }
        }

        return length;
    }

    public List<M3uaParameter> getContent() {
        return Collections.unmodifiableList(content);
    }

    public void addParameter(M3uaParameter parameter) {
        content.add(parameter);
    }

    public void removeParameter(M3uaParameter parameter) {
        content.remove(parameter);
    }
}
