package uk.me.lwood.sigtran.sccp;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author lukew
 */
public class SccpMessageType {
    /**
     * Connection request
     */
    public static final SccpMessageType CR = new SccpMessageType(1);
    /**
     * Connection confirm
     */
    public static final SccpMessageType CC = new SccpMessageType(2);
    /**
     * Connection refused
     */
    public static final SccpMessageType CREF = new SccpMessageType(3);
    /**
     * Released
     */
    public static final SccpMessageType RLSD = new SccpMessageType(4);
    /**
     * Release complete
     */
    public static final SccpMessageType RLC = new SccpMessageType(5);
    /**
     * Data form 1
     */
    public static final SccpMessageType DT1 = new SccpMessageType(6);
    /**
     * Data form 2
     */
    public static final SccpMessageType DT2 = new SccpMessageType(7);
    /**
     * Data acknowledgement
     */
    public static final SccpMessageType AK = new SccpMessageType(8);
    /**
     * Unitdata
     */
    public static final SccpMessageType UDT = new SccpMessageType(9);
    /**
     * Unitdata service
     */
    public static final SccpMessageType UDTS = new SccpMessageType(10);
    /**
     * Expedited data
     */
    public static final SccpMessageType ED = new SccpMessageType(11);
    /**
     * Expedited data acknowledgment
     */
    public static final SccpMessageType EA = new SccpMessageType(12);
    /**
     * Rest request
     */
    public static final SccpMessageType RSR = new SccpMessageType(13);
    /**
     * Rest confirmation
     */
    public static final SccpMessageType RSC = new SccpMessageType(14);
    /**
     * Protocol data unit error
     */
    public static final SccpMessageType ERR = new SccpMessageType(15);
    /**
     * Inactivity test
     */
    public static final SccpMessageType IT = new SccpMessageType(16);
    /**
     * Extended unitdata
     */
    public static final SccpMessageType XUDT = new SccpMessageType(17);
    /**
     * Extended unitdata service
     */
    public static final SccpMessageType XUDTS = new SccpMessageType(18);
    /**
     * Long unitdata
     */
    public static final SccpMessageType LUDT = new SccpMessageType(19);
    /**
     * Long unitdata service
     */
    public static final SccpMessageType LUDTS = new SccpMessageType(20);
    
    private static final Map<Integer, SccpMessageType> messageTypes = new HashMap<Integer, SccpMessageType>();
    static {
        messageTypes.put(1, CR);
        messageTypes.put(2, CC);
        messageTypes.put(3, CREF);
        messageTypes.put(4, RLSD);
        messageTypes.put(5, RLC);
        messageTypes.put(6, DT1);
        messageTypes.put(7, DT2);
        messageTypes.put(8, AK);
        messageTypes.put(9, UDT);
        messageTypes.put(10, UDTS);
        messageTypes.put(11, ED);
        messageTypes.put(12, EA);
        messageTypes.put(13, RSR);
        messageTypes.put(14, RSC);
        messageTypes.put(15, ERR);
        messageTypes.put(16, IT);
        messageTypes.put(17, XUDT);
        messageTypes.put(18, XUDTS);
        messageTypes.put(19, LUDT);
        messageTypes.put(20, LUDTS);
    }
    
    public static SccpMessageType getByCode(int code) {
        SccpMessageType messageType = messageTypes.get(code);
        if (messageType == null) {
            messageType = new SccpMessageType(code);
        }
        
        return messageType;
    }
    
    private final int code;
    
    SccpMessageType(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
}
