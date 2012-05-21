package uk.me.lwood.sigtran.tcap.ros;

/**
 * 
 * @author lukew
 */
public class InvokeId {
    private final int id;
    
    public InvokeId(int id) {
        if (id < -128 || id > 127)
            throw new IllegalArgumentException("Id must be in the range -128 .. 127");
        
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
}
