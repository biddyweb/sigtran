package uk.me.lwood.sigtran.m3ua;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author lukew
 */
public class M3uaMessageClass {
    public static final M3uaMessageClass MGMT = new M3uaMessageClass(0);
    public static final M3uaMessageClass Transfer = new M3uaMessageClass(1);
    public static final M3uaMessageClass SSNM = new M3uaMessageClass(2);
    public static final M3uaMessageClass ASPSM = new M3uaMessageClass(3);
    public static final M3uaMessageClass ASPTM = new M3uaMessageClass(4);
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
