package uk.me.lwood.sigtran.m3ua;

import java.util.HashMap;
import java.util.Map;

/**
 * The message class defined the type of M3UA message sent
 * 
 * @author lukew
 */
public class M3uaMessageClass {
    /**
     * Management
     */
    public static final M3uaMessageClass MGMT = new M3uaMessageClass(0);
    /**
     * Transfer
     */
    public static final M3uaMessageClass Transfer = new M3uaMessageClass(1);
    /**
     * SS7 Signaling Network Management
     */
    public static final M3uaMessageClass SSNM = new M3uaMessageClass(2);
    /**
     * ASP State Maintenance
     */
    public static final M3uaMessageClass ASPSM = new M3uaMessageClass(3);
    /**
     * ASP Traffic Maintenance
     */
    public static final M3uaMessageClass ASPTM = new M3uaMessageClass(4);
    /**
     * Routing Key Management
     */
    public static final M3uaMessageClass RKM = new M3uaMessageClass(9);

    private static final Map<Integer, M3uaMessageClass> messageClasses = new HashMap<Integer, M3uaMessageClass>();
    static {
        messageClasses.put(0, MGMT);
        messageClasses.put(1, Transfer);
        messageClasses.put(2, SSNM);
        messageClasses.put(3, ASPSM);
        messageClasses.put(4, ASPTM);
        messageClasses.put(9, RKM);
    }

    public static M3uaMessageClass getById(int id) {
        M3uaMessageClass messageClass = messageClasses.get(id);
        if (messageClass == null) {
            messageClass = new M3uaMessageClass(id);
        }

        return messageClass;
    }

    private final int id;

    M3uaMessageClass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
