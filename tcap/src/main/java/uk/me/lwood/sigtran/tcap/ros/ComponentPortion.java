package uk.me.lwood.sigtran.tcap.ros;

import java.util.List;

/**
 * 
 * @author lukew
 */
public class ComponentPortion {
    private final List<Component> components;
    
    public ComponentPortion(List<Component> components) {
        this.components = components;
    }
    
    public List<Component> getComponents() {
        return components;
    }
}
