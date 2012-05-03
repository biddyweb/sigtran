package uk.me.lwood.sigtran.m3ua;

import static uk.me.lwood.sigtran.m3ua.M3uaMessageClass.*;

import java.util.HashMap;
import java.util.Map;

/**
 * For each message class, a set of message types is defined.  It is this message type that
 * defines which parameters should and may be included in the body of the message.
 * 
 * @author lukew
 */
public class M3uaMessageType {
    /**
     * Error messages are used to notify message originators of errors in processing messages
     */
    public static final M3uaMessageType ERR = new M3uaMessageType(MGMT, 0);
    /**
     * Notify messages are used to indicate a change in state for an ASP within an application
     * server.  It is sent to all other ASPs that are in the UP state within the same application
     * server
     */
    public static final M3uaMessageType NTFY = new M3uaMessageType(MGMT, 1);

    /**
     * Data messages are used to deliver the M3UA payload, including ISUP, TUP, or SCCP
     */
    public static final M3uaMessageType DATA = new M3uaMessageType(Transfer, 1);

    /**
     * Destination Unavailable messages are sent by signalling gateways to all concerned ASPs to
     * notify that a destination is no longer available 
     */
    public static final M3uaMessageType DUNA = new M3uaMessageType(SSNM, 1);
    /**
     * Destination Available messages are used to indicate the availability of a network that was
     * previously unavailable
     */
    public static final M3uaMessageType DAVA = new M3uaMessageType(SSNM, 2);
    /**
     * Destination State Audit messages are used by an ASP to poll a remote ASP to see if a
     * destination become available again
     */
    public static final M3uaMessageType DAUD = new M3uaMessageType(SSNM, 3);
    /**
     * Signalling Congestion messages are used by signalling gateways to indicate that a
     * destination may have become congested
     */
    public static final M3uaMessageType SCON = new M3uaMessageType(SSNM, 4);
    /**
     * Destination User Part Unavailable messages are sent by signalling gateways when the
     * processor for a certain destination is not responding (but otherwise connected)
     */
    public static final M3uaMessageType DUPU = new M3uaMessageType(SSNM, 5);
    /**
     * Destination Restricted messages are sent by signalling gateways to all ASPs it is
     * connected to when a destination becomes restricted
     */
    public static final M3uaMessageType DRST = new M3uaMessageType(SSNM, 6);

    /**
     * ASP UP messages are used to indicate that an ASP is ready to process traffic for
     * all routing keys serviced by the originating ASP.
     */
    public static final M3uaMessageType ASPUP = new M3uaMessageType(ASPSM, 1);
    /**
     * ASP Down emssages are used to indicate than an ASP cannot handle any traffic
     */
    public static final M3uaMessageType ASPDN = new M3uaMessageType(ASPSM, 2);
    /**
     * Heartbeat messages are optional, and only used in non-SCTP contexts as a keep-alive
     * mechanism for the transport
     */
    public static final M3uaMessageType BEAT = new M3uaMessageType(ASPSM, 3);
    /**
     * ASP Up acknowledgement
     */
    public static final M3uaMessageType ASPUP_ACK = new M3uaMessageType(ASPSM, 4);
    /**
     * ASP Down acknowledgement
     */
    public static final M3uaMessageType ASPDN_ACK = new M3uaMessageType(ASPSM, 5);
    /**
     * Hearbeat acknowledgement
     */
    public static final M3uaMessageType BEAT_ACK = new M3uaMessageType(ASPSM, 6);

    /**
     * ASP Active messages are sent by an ASP to indicate that it is active and able to process
     * traffic for its associated application server
     */
    public static final M3uaMessageType ASPAC = new M3uaMessageType(ASPTM, 1);
    /**
     * ASP Inactive messages are sent by an ASP to indicate that it no longer active.
     */
    public static final M3uaMessageType ASPIA = new M3uaMessageType(ASPTM, 2);
    /**
     * ASP Active acknowledgement
     */
    public static final M3uaMessageType ASPAC_ACK = new M3uaMessageType(ASPTM, 3);
    /**
     * ASP Inactive acknowledgment
     */
    public static final M3uaMessageType ASPIA_ACK = new M3uaMessageType(ASPTM, 4);

    /**
     * Registration request messages are sent by an ASP to register a routing key
     */
    public static final M3uaMessageType REG_REQ = new M3uaMessageType(RKM, 1);
    /**
     * Registration response messages are returned to the ASP after a request to indicate
     * the success state of the registration
     */
    public static final M3uaMessageType REG_RSP = new M3uaMessageType(RKM, 2);
    /**
     * Deregistration request messages are sent by an ASP to deregister a routing key
     */
    public static final M3uaMessageType DEREG_REQ = new M3uaMessageType(RKM, 3);
    /**
     * Deregistration response messages are returned to the ASP after a request to indicate
     * the success state of the deregistration
     */
    public static final M3uaMessageType DEREG_RSP = new M3uaMessageType(RKM, 4);

    private static final Map<M3uaMessageClass, Map<Integer, M3uaMessageType>> messageTypes =
        new HashMap<M3uaMessageClass, Map<Integer, M3uaMessageType>>();
    static {
        final Map<Integer, M3uaMessageType> mgmtMap = new HashMap<Integer, M3uaMessageType>();
        mgmtMap.put(0, ERR);
        mgmtMap.put(1, NTFY);
        messageTypes.put(MGMT, mgmtMap);
        final Map<Integer, M3uaMessageType> transferMap = new HashMap<Integer, M3uaMessageType>();
        transferMap.put(1, DATA);
        messageTypes.put(Transfer, transferMap);
        final Map<Integer, M3uaMessageType> ssnmMap = new HashMap<Integer, M3uaMessageType>();
        ssnmMap.put(1, DUNA);
        ssnmMap.put(2, DAVA);
        ssnmMap.put(3, DAUD);
        ssnmMap.put(4, SCON);
        ssnmMap.put(5, DUPU);
        ssnmMap.put(6, DRST);
        messageTypes.put(SSNM, ssnmMap);
        final Map<Integer, M3uaMessageType> aspsmMap = new HashMap<Integer, M3uaMessageType>();
        aspsmMap.put(1, ASPUP);
        aspsmMap.put(2, ASPDN);
        aspsmMap.put(3, BEAT);
        aspsmMap.put(4, ASPUP_ACK);
        aspsmMap.put(5, ASPDN_ACK);
        aspsmMap.put(6, BEAT_ACK);
        messageTypes.put(ASPSM, aspsmMap);
        final Map<Integer, M3uaMessageType> asptmMap = new HashMap<Integer, M3uaMessageType>();
        asptmMap.put(1, ASPAC);
        asptmMap.put(2, ASPIA);
        asptmMap.put(3, ASPAC_ACK);
        asptmMap.put(4, ASPIA_ACK);
        messageTypes.put(ASPTM, asptmMap);
        final Map<Integer, M3uaMessageType> rkmMap = new HashMap<Integer, M3uaMessageType>();
        rkmMap.put(1, REG_REQ);
        rkmMap.put(2, REG_RSP);
        rkmMap.put(3, DEREG_REQ);
        rkmMap.put(4, DEREG_RSP);
        messageTypes.put(RKM, rkmMap);
    }

    public static M3uaMessageType getByMessageClassAndId(M3uaMessageClass messageClass, int id) {
        Map<Integer, M3uaMessageType> idMap = messageTypes.get(messageClass);
        if (idMap == null) {
            return new M3uaMessageType(messageClass, id);
        }

        M3uaMessageType messageType = idMap.get(id);
        if (messageType == null) {
            messageType = new M3uaMessageType(messageClass, id);
        }

        return messageType;
    }

    private final M3uaMessageClass messageClass;
    private final int id;

    M3uaMessageType(M3uaMessageClass messageClass, int id) {
        this.messageClass = messageClass;
        this.id = id;
    }
    

    public M3uaMessageClass getMessageClass() {
        return messageClass;
    }

    public int getId() {
        return id;
    }
}
