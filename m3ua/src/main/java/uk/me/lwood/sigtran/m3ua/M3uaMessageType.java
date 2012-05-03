package uk.me.lwood.sigtran.m3ua;

import static uk.me.lwood.sigtran.m3ua.M3uaMessageClass.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author lukew
 */
public class M3uaMessageType {
    public static final M3uaMessageType ERR = new M3uaMessageType(MGMT, 0);
    public static final M3uaMessageType NTFY = new M3uaMessageType(MGMT, 1);

    public static final M3uaMessageType DATA = new M3uaMessageType(Transfer, 1);

    public static final M3uaMessageType DUNA = new M3uaMessageType(SSNM, 1);
    public static final M3uaMessageType DAVA = new M3uaMessageType(SSNM, 2);
    public static final M3uaMessageType DAUD = new M3uaMessageType(SSNM, 3);
    public static final M3uaMessageType SCON = new M3uaMessageType(SSNM, 4);
    public static final M3uaMessageType DUPU = new M3uaMessageType(SSNM, 5);
    public static final M3uaMessageType DRST = new M3uaMessageType(SSNM, 6);

    public static final M3uaMessageType ASPUP = new M3uaMessageType(ASPSM, 1);
    public static final M3uaMessageType ASPDN = new M3uaMessageType(ASPSM, 2);
    public static final M3uaMessageType BEAT = new M3uaMessageType(ASPSM, 3);
    public static final M3uaMessageType ASPUP_ACK = new M3uaMessageType(ASPSM, 4);
    public static final M3uaMessageType ASPDN_ACK = new M3uaMessageType(ASPSM, 5);
    public static final M3uaMessageType BEAT_ACK = new M3uaMessageType(ASPSM, 6);

    public static final M3uaMessageType ASPAC = new M3uaMessageType(ASPTM, 1);
    public static final M3uaMessageType ASPIA = new M3uaMessageType(ASPTM, 2);
    public static final M3uaMessageType ASPAC_ACK = new M3uaMessageType(ASPTM, 3);
    public static final M3uaMessageType ASPIA_ACK = new M3uaMessageType(ASPTM, 4);

    public static final M3uaMessageType REG_REQ = new M3uaMessageType(RKM, 1);
    public static final M3uaMessageType REG_RSP = new M3uaMessageType(RKM, 2);
    public static final M3uaMessageType DEREG_REQ = new M3uaMessageType(RKM, 3);
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
